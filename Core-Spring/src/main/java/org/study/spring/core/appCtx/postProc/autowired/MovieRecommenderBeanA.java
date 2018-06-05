package org.study.spring.core.appCtx.postProc.autowired;

public class MovieRecommenderBeanA {

	private CustomerPrefDao customerPrefs;
	
	public MovieRecommenderBeanA(CustomerPrefDao prefs) {
		this.setCustomerPrefs(prefs);
	}

	public CustomerPrefDao getCustomerPrefs() {
		return customerPrefs;
	}

	public void setCustomerPrefs(CustomerPrefDao customerPrefs) {
		this.customerPrefs = customerPrefs;
	}
}
