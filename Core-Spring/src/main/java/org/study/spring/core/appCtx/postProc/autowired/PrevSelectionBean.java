package org.study.spring.core.appCtx.postProc.autowired;

import java.util.List;

public class PrevSelectionBean {

	private List<String> movieNames;

	public List<String> getMovieNames() {
		return movieNames;
	}

	public void setMovieNames(List<String> movieNames) {
		this.movieNames = movieNames;
	}
}
