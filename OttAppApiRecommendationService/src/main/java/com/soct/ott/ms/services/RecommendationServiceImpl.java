package com.soct.ott.ms.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soct.ott.ms.entities.MediaEntity;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Override
	public List<MediaEntity> getRecommendations(int movieId) {
		
		List<MediaEntity> movieList = new ArrayList<MediaEntity>();
		
		ObjectMapper mapper = new ObjectMapper()
		        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<MediaEntity>> typeReference = new TypeReference<List<MediaEntity>>(){};
		
		int randId = this.getRandomNumber(1, 4);
		System.out.println("randID: "+randId);
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/movies-"+randId+".json");
		
		try {
			movieList = mapper.readValue(inputStream,typeReference);
			Collections.shuffle(movieList);
			movieList = movieList.subList(0, 5);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return movieList;
	}
	
	private int getRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max-min+1)+min;
	}

}
