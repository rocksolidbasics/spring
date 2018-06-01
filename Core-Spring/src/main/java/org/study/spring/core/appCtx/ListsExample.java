package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.beans.ListInputBean;

public class ListsExample {

	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		ListsExample le = new ListsExample();
		le.initContext();
		le.getListInputBean();
	}

	private void getListInputBean() {
		ListInputBean lb = (ListInputBean)ctx.getBean("listInputBean");
		System.out.println(lb.getProps());
		System.out.println(lb.getList());
		System.out.println(lb.getListSet());
		System.out.println(lb.getMap());
		
		ListInputBean mergedLb = (ListInputBean)ctx.getBean("mergedInputBean");
		System.out.println("Merged bean: " + mergedLb.getProps());
		System.out.println("Merged bean: " + mergedLb.getMap());
	}
	
	private void initContext() {
		ctx = new ClassPathXmlApplicationContext("classpath:listExample.xml");
	}
}
