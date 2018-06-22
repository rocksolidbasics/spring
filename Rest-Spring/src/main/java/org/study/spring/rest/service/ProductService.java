package org.study.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.study.spring.rest.pojo.Product;

@Service
public class ProductService {

	private long idCounter = 0;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public ProductService() {
		products.add(new Product(++idCounter, "P1", 25.50, "SKU-101"));
		products.add(new Product(++idCounter, "P2", 20.50, "SKU-102"));
		products.add(new Product(++idCounter, "P3", 30.02, "SKU-103"));
		products.add(new Product(++idCounter, "P4", 10.00, "SKU-104"));
		products.add(new Product(++idCounter, "P5", 12.58, "SKU-105"));
	}
	
	public List<Product> findAll() {
		return products;
	}

	public Product findOne(Long id) {
		for(Product prod : this.products) {
			if(prod.getId() == id)
				return prod;
		}
		
		return null;
	}

	public Long create(Product resource) {
		resource.setId(++idCounter);
		products.add(resource);
		return idCounter;
	}

	public void update(Product product) {
		Product prod = findOne(product.getId());
		if(prod == null)
			return;
		
		products.remove(product);
		products.add(product);
	}

	public Object getById(Long id) {
		return this.findOne(id);
	}

	public void deleteById(Long id) {
		this.products.remove(this.findOne(id));
	}

}
