package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetBeanReference {

	ApplicationContext ctx;
	
	public static void main(String[] args) {
		SetBeanReference sb = new SetBeanReference();
		sb.initContext();
		sb.setViaIdRefTag();
		sb.setViaValueAttr();
		sb.setViaRefTag();
	}

	private void initContext() {
		ctx = new ClassPathXmlApplicationContext("classpath:beanRef.xml");
	}

	private void setViaRefTag() {
		
	}

	private void setViaValueAttr() {
		// TODO Auto-generated method stub
		
	}

	private void setViaIdRefTag() {
		ctx.getBean("customerBean");
	}
}
