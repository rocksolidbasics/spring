package org.study.spring.rest.pojo.hateoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {

	private long orderId;
	private Date orderDate;
	private List<ProductResource> lines = new ArrayList<ProductResource>();
	
	public OrderResource(Long orderId, Date orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<ProductResource> getLines() {
		return lines;
	}
	public void setLines(List<ProductResource> lines) {
		this.lines = lines;
	}
	
}
