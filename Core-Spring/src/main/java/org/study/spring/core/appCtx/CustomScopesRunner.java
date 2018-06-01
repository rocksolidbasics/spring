package org.study.spring.core.appCtx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.SimpleThreadScope;
import org.study.spring.core.appCtx.scopes.SampleThreadBean;

public class CustomScopesRunner {

	ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		CustomScopesRunner cs = new CustomScopesRunner();
		cs.initCtx();
		
		cs.testThreadScopes();
	}
	
	private void testThreadScopes() {
		//Registering scope programatically doesn't work
		/*SimpleThreadScope threadScope = new SimpleThreadScope();
		ctx.getBeanFactory().registerScope("threadScope", threadScope);*/
		
		SampleThreadBean stb1 = (SampleThreadBean) ctx.getBean("testThread");
		Thread t1 = new Thread(stb1, "T1");
		t1.start();
		
		SampleThreadBean stb2 = (SampleThreadBean) ctx.getBean("testThread");
		Thread t2 = new Thread(stb2, "T2");
		t2.start();
	}
	
	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:customScopes.xml");
	}
}
