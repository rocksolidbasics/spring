package org.study.spring.core.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.spel.beans.IdGenerator;

public class XMLConfigurationRunner {

	private ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		XMLConfigurationRunner r = new XMLConfigurationRunner();
		r.initCtx();
		r.getIdGenerator();
	}

	private void getIdGenerator() {
		IdGenerator idGen = (IdGenerator)ctx.getBean("idGenerator");
		System.out.println("IdGenerator object prototype 1: =>" + idGen.getId() + ", " + idGen.getLocale());
		idGen = (IdGenerator)ctx.getBean("idGenerator");
		System.out.println("IdGenerator object prototype 2: =>" + idGen.getId() + ", " + idGen.getLocale());
	}

	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:spelUsage.xml");
	}
}
