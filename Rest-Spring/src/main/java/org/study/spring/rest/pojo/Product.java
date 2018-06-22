package org.study.spring.rest.pojo;

public class Product {

	private long id;
	private String name;
	private double price;
	private String sku;
	
	public Product(long id, String name, double price, String sku) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setSku(sku);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		
		Product prod = (Product)obj;
		return this.getId() == prod.getId();
	}

}
