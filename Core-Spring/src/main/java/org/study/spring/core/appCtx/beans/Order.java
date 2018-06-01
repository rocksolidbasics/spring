package org.study.spring.core.appCtx.beans;

import java.util.LinkedList;
import java.util.List;

public class Order {

	private int orderId = 1;
	private String customerName = "Customer1";
	private Address address;
	private List<LineItem> lineItems = new LinkedList<LineItem>();
	
	public Order() { }
	
	public Order(Product prod) {
		LineItem li = new LineItem();
		li.setItemSeq(2);
		li.setCurrency("INR");
		li.setProdId(prod.getSku());
		
		getLineItems().add(li);
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Only static class are allowed to be created as beans using the
	 * default constructor initialization (SimpleInstantiationStrategy)
	 */
	
	public static class LineItem {
		
		private int itemSeq = 1;
		private String prodId = "393930";
		private int quantity = 2;
		private String currency = "INR";
		
		public int getItemSeq() {
			return itemSeq;
		}
		public void setItemSeq(int itemSeq) {
			this.itemSeq = itemSeq;
		}
		public String getProdId() {
			return prodId;
		}
		public void setProdId(String prodId) {
			this.prodId = prodId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
	}
	
}
