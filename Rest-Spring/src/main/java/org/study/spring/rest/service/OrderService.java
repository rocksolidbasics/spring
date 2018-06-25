package org.study.spring.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.spring.rest.pojo.hateoas.OrderResource;
import org.study.spring.rest.pojo.hateoas.ProductResource;

@Service
public class OrderService {

	@Autowired
	private ProductService prodService;
	
	private List<OrderResource> orders = new ArrayList<OrderResource>();
	
	@PostConstruct
	public void preInit() {
		OrderResource or1 = new OrderResource(1l, new Date());
		List<ProductResource> lines = new LinkedList<ProductResource>();
		lines.add(new ProductResource(prodService.findOne(1l)));
		lines.add(new ProductResource(prodService.findOne(2l)));
		or1.setLines(lines);
		orders.add(or1);
		
		OrderResource or2 = new OrderResource(2l, new Date());
		lines = new LinkedList<ProductResource>();
		lines.add(new ProductResource(prodService.findOne(2l)));
		lines.add(new ProductResource(prodService.findOne(3l)));
		lines.add(new ProductResource(prodService.findOne(4l)));
		lines.add(new ProductResource(prodService.findOne(5l)));
		or2.setLines(lines);
		orders.add(or2);

		OrderResource or3 = new OrderResource(3l, new Date());
		lines = new LinkedList<ProductResource>();
		lines.add(new ProductResource(prodService.findOne(1l)));
		lines.add(new ProductResource(prodService.findOne(4l)));
		lines.add(new ProductResource(prodService.findOne(2l)));
		or3.setLines(lines);
		orders.add(or3);
		
		OrderResource or4 = new OrderResource(4l, new Date());
		lines = new LinkedList<ProductResource>();
		lines.add(new ProductResource(prodService.findOne(1l)));
		or4.setLines(lines);
		orders.add(or4);
	}
	
	public List<OrderResource> getAllOrders(Long prodId) {
		List<OrderResource> oList = new LinkedList<OrderResource>();
		for(OrderResource or : this.orders) {
			for(ProductResource pr : or.getLines()) {
				if(pr.getProdId() == prodId) {
					oList.add(or);
					break;
				}
			}
		}
		
		System.out.println("Orders for prodId = " + prodId + ", " + oList.size());
		
		return oList;
	}
	
	public OrderResource getOrder(Long orderId) {
		for(OrderResource or : this.orders) {
			if(or.getOrderId() == orderId) {
				return or;
			}
		}
		
		return null;
	}

}
