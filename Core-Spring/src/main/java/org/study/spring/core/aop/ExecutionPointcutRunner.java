package org.study.spring.core.aop;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.aop.config.ExecutionPointcutConfig;
import org.study.spring.core.aop.targets.Lift;
import org.study.spring.core.aop.targets.Person;
import org.study.spring.core.aop.targets.Route;

public class ExecutionPointcutRunner {

	private AnnotationConfigApplicationContext appCtx;
	
	public static void main(String[] args) {
		ExecutionPointcutRunner epr = new ExecutionPointcutRunner();
		epr.initCtx();
		epr.runTest();
	}

	private void runTest() {
		Route r1 = new Route(3, new Person("P1"));
		Route r2 = new Route(3, new Person("P2"));
		Route r3 = new Route(3, new Person("P3"));
		Route r4 = new Route(3, new Person("P4"));
		
		List<Route> routes = new LinkedList<Route>();
		routes.add(r1);
		routes.add(r2);
		routes.add(r3);
		routes.add(r4);
		
		Lift lift = (Lift)appCtx.getBean("liftBean");
		lift.register(routes);
		lift.setLevel(0);
		
		lift.travel();
	}

	private void initCtx() {
		appCtx = new AnnotationConfigApplicationContext(); 
		appCtx.register(ExecutionPointcutConfig.class);
		appCtx.refresh();
	}

}
