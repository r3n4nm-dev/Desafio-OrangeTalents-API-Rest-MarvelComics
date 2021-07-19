package com.renanmateus.comic.api.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.renanmateus.comic.domain.model.Comics;
import com.renanmateus.comic.domain.service.ComicService;

	
@RestController
@RequestMapping("comics")
public class ComicController {

	@Autowired
	private ComicService comicService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping()
	public Comics adicionaComic(@RequestBody Comics comicRequest) {
		return comicService.salvar(comicRequest);

	}

}
