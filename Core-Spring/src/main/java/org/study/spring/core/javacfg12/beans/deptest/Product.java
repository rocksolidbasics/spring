package org.study.spring.core.javacfg12.beans.deptest;

public class Product {

	private String prodName;
	private int prodWeight;
	
	public Product(String nm, int wt) {
		this.setProdName(nm);
		this.setProdWeight(wt);
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdWeight() {
		return prodWeight;
	}

	public void setProdWeight(int prodWeight) {
		this.prodWeight = prodWeight;
	}
	
	public String toString() {
		return "(Name=>" + prodName + ",Weight=>" + prodWeight + ")";
	}
}
