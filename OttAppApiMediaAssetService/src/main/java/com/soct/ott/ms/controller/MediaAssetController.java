package com.soct.ott.ms.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soct.ott.ms.service.MediaAssetService;
import com.soct.ott.ms.entities.MovieEntity;

@RestController
@RequestMapping("/assets")
public class MediaAssetController {
	
	MediaAssetService mediaAssetService;
	
	@Autowired
	public MediaAssetController(MediaAssetService mediaAssetService) {
		this.mediaAssetService = mediaAssetService;
	}
	
	@GetMapping("/status/check")
	public String check() {
		return "Media Asset service - hello world";
	}
	
	
	@GetMapping(value= {"", "/pages/{pageId}"}, produces = { 
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
        })
	public List<MovieEntity> getMovieList(@PathVariable("pageId") Optional<Integer> pageId) {
		int pageNum = (pageId.isPresent() ? pageId.get() : 1);
		
		List<MovieEntity> movieList = mediaAssetService.getMovies(pageNum);
		return movieList;
	}

	@GetMapping(value="/{id}", produces = { 
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
        })
	public MovieEntity getMovieDetails(@PathVariable("id") int id, @RequestHeader HttpHeaders headers) {
		System.out.println(headers);
		
		return mediaAssetService.getMovieDetails(id, headers);
	}
	
	
}

