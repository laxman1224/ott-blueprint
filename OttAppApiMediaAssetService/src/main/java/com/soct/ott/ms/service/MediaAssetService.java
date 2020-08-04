package com.soct.ott.ms.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;

import com.soct.ott.ms.entities.MovieEntity;

public interface MediaAssetService {

	List<MovieEntity> getMovies(int pageNum);
	
	MovieEntity getMovieDetails(int id, HttpHeaders headers);
}
