package com.renanmateus.comic.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.renanmateus.comic.domain.model.Comics;
import com.renanmateus.comic.domain.model.Usuario;
import com.renanmateus.comic.domain.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/{cpfOuEmail}")
	public Usuario buscar(@PathVariable("cpfOuEmail") String cpfOuEmail) {
		return usuarioService.buscarPorCpfOuEmail(cpfOuEmail);
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public Usuario adicionar(@RequestBody @Valid Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
	
	// Não foi pedido. 
	// Recurso utilizado como atalho para inserir um comics a um usuário
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/addComics/{cpfOuEmail}")
	public Usuario adcionarComicAoUsuario(@PathVariable("cpfOuEmail") String cpfOuEmail, @RequestBody Comics comicRequest) {
		return usuarioService.adicionaComics(cpfOuEmail, comicRequest);
	}
	

}
