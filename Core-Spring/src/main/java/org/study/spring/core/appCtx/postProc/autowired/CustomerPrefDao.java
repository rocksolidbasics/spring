package org.study.spring.core.appCtx.postProc.autowired;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.study.spring.core.appCtx.beans.Address;

public class CustomerPrefDao {

	private int customerId;
	private String movieCategory;
	
	private Address billingAddr;
	private Address shippingAddr;
	private Address preferredAddr;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getMovieCategory() {
		return movieCategory;
	}
	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}
	public Address getBillingAddr() {
		return billingAddr;
	}
	@Autowired
	public void setBillingAddr(@Nullable Address billingAddr) {
		this.billingAddr = billingAddr;
	}
	public Address getShippingAddr() {
		return shippingAddr;
	}
	@Autowired
	public void setShippingAddr(Optional<Address> shippingAddr) {
		this.shippingAddr = (shippingAddr.isPresent()) ? shippingAddr.get() : null;
	}
	
	public Address getPreferredAddr() {
		return preferredAddr;
	}
	
	/**
	 * If the below autowire is enabled without an optional semantic then, it may throw the below exception
	 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 
	 * 'org.study.spring.core.appCtx.beans.Address' available: expected at least 1 bean which qualifies as 
	 * autowire candidate. Dependency annotations: {}
	 * 
	 */
	
	//@Autowired
	public void setPreferredAddr(Address preferredAddr) {
		this.preferredAddr = preferredAddr;
	}
}
