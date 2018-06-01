package org.study.spring.core.appCtx.delegatedBeanFactory;

import org.study.spring.core.appCtx.beans.Product;

public class EntityFactory {

	private static EntityFactory factoryInst = new EntityFactory();
	
	private EntityFactory() {}
	
	public static EntityFactory createInstance() {
		return factoryInst;
	}
	
	public Product getProductInstance() {
		Product p = new Product();
		p.setName("Factory created product");
		p.setSku("kdf0333");
		
		return p;
	}
}
