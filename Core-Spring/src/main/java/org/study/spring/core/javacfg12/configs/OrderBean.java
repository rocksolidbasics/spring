package org.study.spring.core.javacfg12.configs;

import java.util.List;

import org.study.spring.core.appCtx.beans.Customer;
import org.study.spring.core.javacfg12.beans.deptest.Product;

public class OrderBean {

	private Customer cust;
	private List<Product> prodList;
	
	public OrderBean(Customer cust, List<Product> prods) {
		this.setCust(cust);
		this.setProdList(prods);
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public List<Product> getProdList() {
		return prodList;
	}

	public void setProdList(List<Product> prodList) {
		this.prodList = prodList;
	}
}
