package com.soct.ott.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soct.ott.ms.entities.MediaEntity;
import com.soct.ott.ms.services.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
	
	RecommendationService recommendationService;
	
	@Autowired
	public RecommendationController(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
	@GetMapping("/status/check")
	public String check() {
		return "Recommendation service - hello world";
	}
	
	@GetMapping(value="/{id}", produces = { 
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
        })
	public List<MediaEntity> getRecommendations(@PathVariable("id") int id) {
		return recommendationService.getRecommendations(id);
	}
	
	
}

