package org.study.spring.core.appCtx.postProc.autowired;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MovieList {
	
	private int id;
	@Qualifier("thriller")
	@Autowired
	private List<Movie> movieList;
	
	@Autowired
	private Movie comedy;
	
	@Resource(name="scifi")
	private Movie scifi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public Movie getComedy() {
		return comedy;
	}
	public void setComedy(Movie comedy) {
		this.comedy = comedy;
	}
	public Movie getScifi() {
		return scifi;
	}
	public void setScifi(Movie scifi) {
		this.scifi = scifi;
	}

}
