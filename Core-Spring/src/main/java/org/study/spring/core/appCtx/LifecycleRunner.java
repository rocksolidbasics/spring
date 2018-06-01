package org.study.spring.core.appCtx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.lifecycle.L3_1Bean;
import org.study.spring.core.appCtx.lifecycle.RootBean;

public class LifecycleRunner {

	ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		LifecycleRunner lr = new LifecycleRunner();
		lr.initCtx();
		
		//Register shutdown hook so that destroy events get called gracefully
		lr.ctx.registerShutdownHook();
		
		lr.getRootBean();
		lr.getL31Bean();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void getL31Bean() {
		L3_1Bean l31b = (L3_1Bean)ctx.getBean("l31Bean");
		System.out.println(l31b.toString());
	}
	
	private void getRootBean() {
		RootBean rootBean = (RootBean)ctx.getBean("rootBean");
		rootBean.getL1();
		rootBean.getL2();
	}
	
	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:lifecycle.xml");
	}
}
