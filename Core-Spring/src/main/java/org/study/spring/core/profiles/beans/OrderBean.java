package org.study.spring.core.profiles.beans;

public class OrderBean {

	private Customer cust;
	
	public OrderBean(Customer cust) {
		this.cust = cust;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
}
