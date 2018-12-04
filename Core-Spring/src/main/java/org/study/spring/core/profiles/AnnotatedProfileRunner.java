package org.study.spring.core.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.profiles.beans.Inventory;
import org.study.spring.core.profiles.configs.AnnotatedProfileConfig;

public class AnnotatedProfileRunner {

	private AnnotationConfigApplicationContext ctx;
	
	public static void main(String[] args) {
		AnnotatedProfileRunner runner = new AnnotatedProfileRunner();
		runner.initCtx();
		runner.getDevBeans();
	}
	
	private void getDevBeans() {
		Inventory obj  = (Inventory)ctx.getBean("getInventory");
		System.out.println(obj.getInvService().get("type"));
	}

	private void initCtx() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(AnnotatedProfileConfig.class);
		//Alternatively, the -Dspring.profiles.active property can be used to set
		//the active profile
		ctx.getEnvironment().setActiveProfiles("staging");
		ctx.refresh();
	}
}
