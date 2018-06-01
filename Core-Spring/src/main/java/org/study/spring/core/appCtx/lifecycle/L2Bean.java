package org.study.spring.core.appCtx.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class L2Bean implements InitializingBean, DisposableBean {

	private L2_1Bean l21;
	private L2_2Bean l22;

	public L2Bean(L2_1Bean l21b, L2_2Bean l22b) {
		this.setL21(l21b);
		this.setL22(l22b);
	}
	
	public void customInit() {
		System.out.println("L2 - >> custom init called");
	}
	
	public void customDestroy() {
		System.out.println("L2 - << custom destroy called");
	}
	
	@PostConstruct
	public void postConstructMethod() {
		System.out.println("L2 - >> post construct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("L2 - << preDestroy annotated method called");
	}
	
	@Override
	public void afterPropertiesSet() {
		System.out.println("L2 - >> after properties set");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("L2 - << destroy");
	}

	public L2_1Bean getL21() {
		return l21;
	}

	public void setL21(L2_1Bean l21) {
		this.l21 = l21;
	}

	public L2_2Bean getL22() {
		return l22;
	}

	public void setL22(L2_2Bean l22) {
		this.l22 = l22;
	}
}
