package org.study.spring.core.appCtx.postProc.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieRecommenderBeanD {

	private MovieType movieType;

	public MovieType getMovieType() {
		return movieType;
	}

	@Autowired
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
}
