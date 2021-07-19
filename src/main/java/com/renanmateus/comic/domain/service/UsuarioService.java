package com.renanmateus.comic.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanmateus.comic.domain.exception.EntidadeNaoEncontradaException;
import com.renanmateus.comic.domain.exception.EntidadeJaExistenteException;
import com.renanmateus.comic.domain.model.Comics;
import com.renanmateus.comic.domain.model.Usuario;
import com.renanmateus.comic.domain.repository.ComicRepository;
import com.renanmateus.comic.domain.repository.UsuarioRepository;
import com.renanmateus.comic.domain.utils.DescontoUtils;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ComicRepository comicRepository;

	public Usuario salvar(Usuario usuario) {
		String cpf = usuario.getId().getCpf();
		String email = usuario.getId().getEmail();
		Optional<Usuario> novoUsuario = usuarioRepository.findFirstByIdCpfOrIdEmail(cpf, email);
		if(novoUsuario.isEmpty()) {
			return usuarioRepository.save(usuario);
		}
		throw new EntidadeJaExistenteException("Objeto já inserido");
	}

	public Usuario buscarPorCpfOuEmail(String cpfOuEmail) {
		Usuario usuario = usuarioRepository
				.findByIdCpfOrIdEmail(cpfOuEmail, cpfOuEmail)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Objeto não encontrado."));
			List<Comics> comics = usuario.getComics();
			// definindo descontoAtivo
			comics.forEach(comic -> {
				String diaDesconto = comic.getDiaDesconto();
				if (DescontoUtils.verificaDescontoAtivo(diaDesconto)) {
					comic.setDescontoAtivo(true);
				}
				// definindo novo preco
				if (comic.isDescontoAtivo()) {
					double preco = comic.getPreco();
					comic.setPreco(preco - (preco * 0.1));
				}
			});
			usuario.setComics(comics);
		return usuario;
	}

	public Usuario adicionaComics(String cpfOuEmail, Comics comic) {
		Comics newComic = comicRepository
				.findById(comic.getComicId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Objeto não encontrado."));
		Usuario usuario = usuarioRepository
				.findByIdCpfOrIdEmail(cpfOuEmail, cpfOuEmail)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Objeto não encontrado."));
			List<Comics> comics = usuario.getComics();
			comics.add(newComic);
			usuario.setComics(comics);
			return usuarioRepository.save(usuario);
		}

}
