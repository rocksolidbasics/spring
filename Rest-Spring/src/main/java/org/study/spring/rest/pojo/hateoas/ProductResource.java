package org.study.spring.rest.pojo.hateoas;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.study.spring.rest.MvcRestController;
import org.study.spring.rest.pojo.Product;

public class ProductResource extends ResourceSupport {

	private Product prod;
	
	public ProductResource(Product prod) {
		this.prod = prod;
	}
	
	public ProductResource(long id, String name, double price, String sku) {
		this(new Product(id, name, price, sku));
	}
	
	public void addSelfLink() {
		ControllerLinkBuilder cb = new ControllerLinkBuilderFactory().linkTo(MvcRestController.class);
		this.add(cb.slash(this.prod.getId()).withSelfRel());
	}

	public long getProdId() {
		return this.prod.getId();
	}

	public void setId(long id) {
		this.prod.setId(id);
	}

	public String getName() {
		return this.prod.getName();
	}

	public void setName(String name) {
		this.prod.setName(name);
	}

	public double getPrice() {
		return this.prod.getPrice();
	}

	public void setPrice(double price) {
		this.prod.setPrice(price);
	}

	public String getSku() {
		return this.prod.getSku();
	}

	public void setSku(String sku) {
		this.prod.setSku(sku);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		
		Product prod = (Product)obj;
		return this.prod.getId() == prod.getId();
	}
	
}
