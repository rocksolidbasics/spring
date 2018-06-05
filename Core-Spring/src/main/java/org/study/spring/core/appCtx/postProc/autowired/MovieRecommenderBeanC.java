package org.study.spring.core.appCtx.postProc.autowired;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;

public class MovieRecommenderBeanC {
	
	@Autowired
	private ApplicationContext ctx;

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

		/*This will throw a null pointer exception, becuase it seems that the @Autowired on constructors
		 * are processed first followed by the autowired on fields
		 */
		//System.out.println("Application context set into MovieRecommenderBeanC => " + getCtx().getClass().getName());
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

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
}
