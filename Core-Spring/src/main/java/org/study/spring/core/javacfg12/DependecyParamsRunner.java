package org.study.spring.core.javacfg12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.javacfg12.configs.DepParamsConfig;
import org.study.spring.core.javacfg12.configs.OrderBean;

public class DependecyParamsRunner {
	
	private AnnotationConfigApplicationContext ctx = null; 

	public static void main(String[] args) {
		DependecyParamsRunner dp = new DependecyParamsRunner();
		dp.initCtx();
		dp.doAppConfigDepParams();
	}
	
	private void doAppConfigDepParams() {
		OrderBean ob = (OrderBean)ctx.getBean("simpleOrderBean");
		System.out.println("Simple Order Bean details:");
		System.out.println("Customer => " + ob.getCust());
		System.out.println("Products => " + ob.getProdList());
		
		System.out.println("Inter-bean call Order bean details:");
		ob = (OrderBean)ctx.getBean("listOrderBean");
		System.out.println("Customer => " + ob.getCust());
		System.out.println("Products => " + ob.getProdList());
	}

	private void initCtx() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(DepParamsConfig.class);
		ctx.refresh();
	}
}
