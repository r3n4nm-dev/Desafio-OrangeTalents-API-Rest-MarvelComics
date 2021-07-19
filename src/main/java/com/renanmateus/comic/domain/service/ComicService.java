package com.renanmateus.comic.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.renanmateus.comic.domain.exception.EntidadeNaoEncontradaException;
import com.renanmateus.comic.domain.model.Comics;
import com.renanmateus.comic.domain.repository.ComicRepository;
import com.renanmateus.comic.domain.utils.DescontoUtils;
import com.renanmateus.comic.domain.utils.HashUtils;
import com.renanmateus.comic.domain.utils.TimestampUtils;
import com.renanmateus.comic.domain.utils.model.ComicFeign;
import com.renanmateus.comic.domain.utils.model.Item;
import com.renanmateus.comic.domain.utils.model.Result;

import feign.FeignException;

@Service
public class ComicService {

	@Autowired
	private ComicRepository comicRepository;
	@Autowired
	private ComicFeignService comicFeignService;

	@Value("${marvel.privateKey}")
	private String privateKey;
	@Value("${marvel.publicKey}")
	private String publicKey;
	private String ts;
	private String hash;


	
	public Comics salvar(Comics comic) {
		
		ts = TimestampUtils.geraTimestamp();
		hash = HashUtils.geraHashMd5(ts, privateKey, publicKey);
		try {
			
		long comicId = comic.getComicId();
		Comics newComic = new Comics();
		ComicFeign comicFeign = comicFeignService.retornaComic(comicId, ts, hash, publicKey);
		Result resultado = comicFeign.getData().getResults().get(0);

		newComic.setTitulo(resultado.getTitle());
		newComic.setComicId(resultado.getId());
		newComic.setDescricao(resultado.getDescription());
		newComic.setIsbn(resultado.getIsbn());

		// Adicionando autores
		List<Item> autores = resultado.getCreators().getItems();
		StringBuilder sb = new StringBuilder();
		autores.forEach(autor -> sb.append(autor.getName() + ", "));
		if (!autores.isEmpty()) {
			String autor = sb.toString();
			newComic.setAutores(autor.substring(0, autor.length() - 2));
		}

		// Adicionando dia do desconto e descontoAtivo

		String diaDesconto = DescontoUtils.verificaDiaDesconto(resultado.getIsbn());
		newComic.setDiaDesconto(diaDesconto);
		boolean descontoAtivo = DescontoUtils.verificaDescontoAtivo(diaDesconto);
		newComic.setDescontoAtivo(descontoAtivo);

		// Adicionando preço

		newComic.setPreco(resultado.getPrices().get(0).getPrice());

		return comicRepository.save(newComic);

		 } catch (FeignException e) {
		 throw new EntidadeNaoEncontradaException("Objeto não encontrado");
		 }
	}
}
