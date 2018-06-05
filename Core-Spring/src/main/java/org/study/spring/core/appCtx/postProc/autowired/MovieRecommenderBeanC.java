package org.study.spring.core.appCtx.postProc.autowired;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class MovieRecommenderBeanC {

	private CustomerPrefDao customerPrefs;
	private PrevSelectionBean prevSels;
	@Autowired(required = false)
	private MovieType[] movieTypes;
	private Set<MovieCatalog> moviCatalog;

	public MovieRecommenderBeanC(CustomerPrefDao prefs) {
		this.setCustomerPrefs(prefs);
	}
	
	@Autowired
	public MovieRecommenderBeanC(CustomerPrefDao prefs, PrevSelectionBean prevSels) {
		this.setCustomerPrefs(prefs);
		this.setPrevSels(prevSels);
	}

	public CustomerPrefDao getCustomerPrefs() {
		return customerPrefs;
	}

	public void setCustomerPrefs(CustomerPrefDao customerPrefs) {
		this.customerPrefs = customerPrefs;
	}

	@Required
	public PrevSelectionBean getPrevSels() {
		return prevSels;
	}

	public void setPrevSels(PrevSelectionBean prevSels) {
		this.prevSels = prevSels;
	}

	public MovieType[] getMovieTypes() {
		return movieTypes;
	}

	public void setMovieTypes(MovieType[] movieTypes) {
		this.movieTypes = movieTypes;
	}

	public Set<MovieCatalog> getMoviCatalog() {
		return moviCatalog;
	}

	@Autowired
	public void setMoviCatalog(Set<MovieCatalog> moviCatalog) {
		this.moviCatalog = moviCatalog;
	}
}
