package com.soct.ott.ms.services;

import java.util.List;

import com.soct.ott.ms.entities.MediaEntity;

public interface RecommendationService {

	List<MediaEntity> getRecommendations(int movieId);
}
