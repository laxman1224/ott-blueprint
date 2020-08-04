package com.soct.ott.web.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MovieResultsEntity {

	private List<MovieEntity> results;

	public List<MovieEntity> getResults() {
		return results;
	}

	public void setResults(List<MovieEntity> results) {
		this.results = results;
	}

}
