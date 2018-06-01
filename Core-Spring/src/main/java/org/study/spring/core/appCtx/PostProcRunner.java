package org.study.spring.core.appCtx;

import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.postProc.TestBean1;
import org.study.spring.core.appCtx.postProc.TestBean2;

public class PostProcRunner {

	private ApplicationContext ctx;
	private RequiredAnnotationBeanPostProcessor pr;
	
	public static void main(String[] args) {
		PostProcRunner ppr = new PostProcRunner();
		ppr.initCtx();
		ppr.testPostProcRunner();
	}

	private void testPostProcRunner() {
		TestBean1 tbean1 = (TestBean1)ctx.getBean("testBean1");
		TestBean2 tbean2 = (TestBean2)ctx.getBean("testBean2");
	}
	
	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:postProc.xml");
	}
}
