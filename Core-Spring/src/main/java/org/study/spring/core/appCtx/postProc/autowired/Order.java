package org.study.spring.core.appCtx.postProc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {

	private String id;
	@Autowired
	@Qualifier("billingAddress")
	private Address billingAddress;
	@Autowired
	@Qualifier("shipQual")
	private Address shippingAddress;
	
	//@Autowired
	private Address defaultAddress;
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(Address defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	
}
