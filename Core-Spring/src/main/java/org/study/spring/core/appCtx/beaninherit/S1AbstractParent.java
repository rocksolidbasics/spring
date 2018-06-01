package org.study.spring.core.appCtx.beaninherit;

public abstract class S1AbstractParent {

	private String prop1;
	private String prop2;
	
	public S1AbstractParent() {
		
	}
	
	public S1AbstractParent(String prop1) {
		this.setProp1(prop1);
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

}
