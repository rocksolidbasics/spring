package org.study.spring.core.javacfg12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.javacfg12.beans.DataAccessor;
import org.study.spring.core.javacfg12.configs.MultitypeBeanConfig;

public class MultitypeBeanRunner {

	AnnotationConfigApplicationContext ctx = null;
	
	public static void main(String[] args) {
		MultitypeBeanRunner mbr = new MultitypeBeanRunner();
		mbr.initCtx();
		mbr.getMultitypeBean();
	}

	private void getMultitypeBean() {
		DataAccessor da = (DataAccessor)ctx.getBean(DataAccessor.class);
		System.out.println(da.getExtServ());
	}
	
	private void initCtx() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(MultitypeBeanConfig.class);
		ctx.refresh();
	}

}
