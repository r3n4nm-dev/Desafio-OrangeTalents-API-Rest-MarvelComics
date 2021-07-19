package com.renanmateus.comic.domain.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.renanmateus.comic.domain.utils.model.ComicFeign;

@FeignClient(name="marvel-api", url = "http://gateway.marvel.com/v1/public/comics/")
public interface ComicFeignService {
 
	
	@GetMapping("{comicId}?ts={ts}&hash={hash}&apikey={api}")
	public ComicFeign retornaComic(@PathVariable("comicId") long comicId, @PathVariable("ts") String ts,
			@PathVariable("hash") String hash, @PathVariable("api") String api);
	
}
