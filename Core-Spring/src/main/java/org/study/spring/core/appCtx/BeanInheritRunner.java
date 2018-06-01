package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.beaninherit.S1NoSubClassChild;
import org.study.spring.core.appCtx.beaninherit.S2SubClassChild;
import org.study.spring.core.appCtx.beaninherit.S3NonSubClassChild;
import org.study.spring.core.appCtx.beaninherit.S3Parent;
import org.study.spring.core.appCtx.beaninherit.S6Child;

public class BeanInheritRunner {

	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		BeanInheritRunner bRunner = new BeanInheritRunner();
		bRunner.initCtx();
		bRunner.testScenario1();
		bRunner.testScenario2();
		bRunner.testScenario3();
		//bRunner.testScenario5(); - Valid non-working test for one-less property than the parent
		bRunner.testScenario6();
		bRunner.testScenario7();
	}
	
	private void testScenario3() {
		S3NonSubClassChild child = (S3NonSubClassChild)ctx.getBean("s3ChildBean");
		System.out.println("Scenario 3 -> " + child.getProp1() + ", " + child.getProp2() + 
				", " + child.getProp4());
	}

	private void testScenario6() {
		S6Child child = (S6Child)ctx.getBean("s6ChildBean");
		System.out.println("Scenario 6 -> " + child.getProp1() + ", " + child.getProp2() + 
				", " + child.getProp3());
	}

	private void testScenario7() {
		S3Parent childRef = (S3Parent)ctx.getBean("s7ChildBean");
		System.out.println("Scenario 7 -> " + childRef.getProp1() + ", " + childRef.getProp2() + 
				", " + childRef.getProp3());
	}

	/**
	 * Valid non-working test for one-less property than the parent
	 */
	/*private void testScenario5() {
		S5NoSubClassChild child = (S5NoSubClassChild) ctx.getBean("s5ChildBean");
		System.out.println("Scenario 5 -> " + child.getProp1());
	}*/

	private void testScenario2() {
		S2SubClassChild child = (S2SubClassChild)ctx.getBean("s2ChildBean");
		System.out.println("Scenario 2 -> " + child.getProp1() + ", " + child.getProp2() + 
				", " + child.getProp4());
	}

	private void testScenario1() {
		S1NoSubClassChild child = (S1NoSubClassChild)ctx.getBean("s1ChildBean");
		System.out.println("Scenario 1 -> " + child.getProp1() + ", " + child.getProp2() + 
				", " + child.getProp3());
	}

	private void initCtx() {
		ctx = new ClassPathXmlApplicationContext("classpath:beaninherit.xml");
	}
}
