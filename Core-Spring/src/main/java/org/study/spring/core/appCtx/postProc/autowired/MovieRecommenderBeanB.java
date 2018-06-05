package org.study.spring.core.appCtx.postProc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class MovieRecommenderBeanB {

	private CustomerPrefDao customerPrefs;
	private PrevSelectionBean prevSels;
	
	public MovieRecommenderBeanB(CustomerPrefDao prefs) {
		this.setCustomerPrefs(prefs);
	}
	
	@Autowired
	public MovieRecommenderBeanB(CustomerPrefDao prefs, PrevSelectionBean prevSels) {
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
}
