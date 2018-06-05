package org.study.spring.core.appCtx;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.postProc.ReqTestBean;
import org.study.spring.core.appCtx.postProc.TestBean1;
import org.study.spring.core.appCtx.postProc.TestBean2;
import org.study.spring.core.appCtx.postProc.autowired.MovieRecommenderBeanA;
import org.study.spring.core.appCtx.postProc.autowired.MovieRecommenderBeanB;
import org.study.spring.core.appCtx.postProc.autowired.MovieRecommenderBeanC;

public class PostProcRunner {

	private ApplicationContext ctx;
	private RequiredAnnotationBeanPostProcessor pr;
	
	public static void main(String[] args) {
		PostProcRunner ppr = new PostProcRunner();
		ppr.initCtx();
		ppr.testPostProcRunner();
		ppr.testRequiredAnnBeanPostProc();
		ppr.testAutoWired();
		ppr.testListAutowire();
	}

	private void testListAutowire() {
		MovieRecommenderBeanC mrb = (MovieRecommenderBeanC)ctx.getBean("movieRecommenderC");
		System.out.println("List of movie types => " + Arrays.asList(mrb.getMovieTypes()));
		System.out.println("List of movie catalogs => " + mrb.getMoviCatalog());
		System.out.println("Billing address => " + mrb.getCustomerPrefs().getBillingAddr());
		System.out.println("Shipping address => " + mrb.getCustomerPrefs().getShippingAddr());
	}

	private void testAutoWired() {
		MovieRecommenderBeanA mrb1 = (MovieRecommenderBeanA)ctx.getBean("movieRecommenderA");
		System.out.println("Customer prefs => " + mrb1.getCustomerPrefs().getMovieCategory());
		
		MovieRecommenderBeanB mrb2 = (MovieRecommenderBeanB)ctx.getBean("movieRecommenderB");
		System.out.println("Customer prefs => " + mrb2.getCustomerPrefs().getMovieCategory() + ", " +
				"Previous selection => " + mrb2.getPrevSels().getMovieNames());
	}

	private void testRequiredAnnBeanPostProc() {
		ReqTestBean rtb = (ReqTestBean)ctx.getBean("reqTestBean");
		System.out.println("Test bean has property prop2 => " + rtb.getProp2());
	}

	private void testPostProcRunner() {
		TestBean1 tbean1 = (TestBean1)ctx.getBean("testBean1");
		TestBean2 tbean2 = (TestBean2)ctx.getBean("testBean2");
	}
	
	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:postProc.xml");
	}
}
