package org.study.spring.core.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.profiles.beans.DataSource_I;
import org.study.spring.core.profiles.configs.ProfileConfig;

public class SimpleProfileRunner {

	private AnnotationConfigApplicationContext ctx;
	
	public static void main(String[] args) {
		SimpleProfileRunner spr = new SimpleProfileRunner();
		spr.initCtx();
		spr.getDevBeans();
	}
	
	private void getDevBeans() {
		DataSource_I ds = (DataSource_I)ctx.getBean("datasource");
		System.out.println(ds.getConnection());
	}

	private void initCtx() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(ProfileConfig.class);
		//Alternatively, the -Dspring.profiles.active property can be used to set
		//the active profile
		ctx.getEnvironment().setActiveProfiles("developement");
		ctx.refresh();
	}
}
