package com.soct.ott.ms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soct.ott.ms.entities.MovieEntity;

@Service
public class MediaAssetServiceImpl implements MediaAssetService {

	List<MovieEntity> movieList = new ArrayList<MovieEntity>();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<MovieEntity> getMovies(int pageNum) {
		
		ObjectMapper mapper = new ObjectMapper()
		        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<MovieEntity>> typeReference = new TypeReference<List<MovieEntity>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/movies-"+pageNum+".json");
		
		try {
			this.movieList = mapper.readValue(inputStream,typeReference);
		} catch (IOException e){
			System.out.println(e.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.movieList;
	}

	@Override
	public MovieEntity getMovieDetails(int id, HttpHeaders headers) {
		if (this.movieList.size() == 0) {
			this.movieList = this.getMovies(1);
		}
		
		for (MovieEntity movie : this.movieList) {
		    if (movie.getId() == id) {
		    	movie.setRecommendations(this.getRecommendations(id, headers));
		    	return movie;
		    }
		}
		return new MovieEntity();
	}
	
	private List<MovieEntity> getRecommendations(int movieId, HttpHeaders headers) {
		String movieListUrl = "http://localhost:8765/recommendations-ws/recommendations/"+movieId;

		HttpEntity<List<MovieEntity>> entity = new HttpEntity<>(headers);
		ResponseEntity<List<MovieEntity>> movieListResponse = restTemplate.exchange(movieListUrl, HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<MovieEntity>>() {
				});
		List<MovieEntity> movieList = movieListResponse.getBody();
		return movieList;
	}

}
