package org.study.spring.core.appCtx.beans;

public class Product {

	private String sku = "S289292";
	private String name = "Product_1";
	
	public Product() { }
	
	public Product(String sku, String name) {
		this.sku = sku;
		this.name = name;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
