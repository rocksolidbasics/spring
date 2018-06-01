package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.methodInjn.AbstractLookupProcessor;
import org.study.spring.core.appCtx.methodInjn.Command;
import org.study.spring.core.appCtx.methodInjn.CommandProcessor;

public class MethodInjection {
	
	private ApplicationContext appCtx;

	public static void main(String[] args) {
		MethodInjection mi = new MethodInjection();
		mi.initContext();
		
		mi.usingAppCtxAware();
		mi.usingAbstractLookupInjection();
	}
	
	private void usingAbstractLookupInjection() {
		AbstractLookupProcessor lp = (AbstractLookupProcessor) appCtx.getBean("abstractProcBean");
		System.out.println("Command Processor Bean: " + lp.toString());
		Command cmd1 = lp.getCommand();
		cmd1.setCmdType("C1");
		cmd1.execute();
		Command cmd2 = lp.getCommand();
		cmd2.setCmdType("C2");
		cmd2.execute();
		
		/* Using context:component-scan tag so that the @Lookup annotation is processed */
		Command cmdA1 = lp.getAnnotatedCommand();
		cmdA1.setCmdType("CA1");
		cmdA1.execute();
	
		AbstractLookupProcessor lp1 = (AbstractLookupProcessor) appCtx.getBean("abstractProcBean");
		System.out.println("Command Processor Bean: " + lp1.toString());
		Command cmd3 = lp1.getCommand();
		cmd3.setCmdType("C3");
		cmd3.execute();
		Command cmd4 = lp1.getCommand();
		cmd4.setCmdType("C4");
		cmd4.execute();
	}
	
	private void usingAppCtxAware() {
		CommandProcessor cp = (CommandProcessor) appCtx.getBean("procBean");
		System.out.println("Command Processor Bean: " + cp.toString());
		Command cmd1 = cp.getCommand("C1");
		cmd1.execute();
		Command cmd2 = cp.getCommand("C2");
		cmd2.execute();
		
		CommandProcessor cp1 = (CommandProcessor) appCtx.getBean("procBean");
		System.out.println("Command Processor Bean: " + cp1.toString());
		Command cmd3 = cp1.getCommand("C3");
		cmd3.execute();
	}

	public void initContext() {
		appCtx = new ClassPathXmlApplicationContext("classpath:methodInj.xml");
	}

}
