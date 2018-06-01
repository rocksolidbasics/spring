package org.study.spring.core.appCtx.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class L1Bean implements InitializingBean {

	@PostConstruct
	public void postConstructMethod() {
		System.out.println("L1 - >> post construct annotated method called");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("L1 - >> after properties set method called");
	}
	
	public void customInit() {
		System.out.println("L1 - >> custom init method called");
	}

}
