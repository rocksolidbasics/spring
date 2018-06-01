package org.study.spring.core.appCtx.beaninherit;

public class S2SubClassChild extends S1AbstractParent {

	private String prop4;
	
	/**
	 * Default constructor required, otherwise properties supplied as part
	 * of parent abstract call can't be set, with creating an object of this
	 * bean. Without a default constructor, creating this bean is not possible
	 * using "parent" definition
	 */
	
	public S2SubClassChild() {
		super();
	}
	
	public S2SubClassChild(String p1) {
		super(p1);
	}

	public String getProp4() {
		return prop4;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	
}
