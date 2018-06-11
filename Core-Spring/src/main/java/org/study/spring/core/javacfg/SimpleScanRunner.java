package org.study.spring.core.javacfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.javacfg.beans.scannedA.BeanA;
import org.study.spring.core.javacfg.beans.scannedB.BeanB;
import org.study.spring.core.javacfg.beans.scannedB.BeanD;
import org.study.spring.core.javacfg.beans.scannedC.BeanC;
import org.study.spring.core.javacfg.configs.ScanRunnerConfig;

public class SimpleScanRunner {
	
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SimpleScanRunner ssr = new SimpleScanRunner();
		ssr.loadCtx();
		ssr.loadConfigAndScannedBeans();
		ssr.beanLoadingWithName();
		ssr.beanLoadingUsingQualifier();
	}

	private void beanLoadingUsingQualifier() {
		BeanC bc = (BeanC)ctx.getBean(BeanC.class);
		System.out.println("Bean retrieved using the qualifier name => " + bc.getCollabC());
		BeanD bd = (BeanD)ctx.getBean(BeanD.class);
		System.out.println("Bean retrieved using qualifier used with @Component and at injection point => " +
				bd.getCollabD());
	}

	private void beanLoadingWithName() {
		BeanB bb1 = (BeanB)ctx.getBean("beanName1");
		BeanB bb2 = (BeanB)ctx.getBean("beanName2");
		
		System.out.println("Bean retrieved using the bean name 'beanName1' specified in the @Bean annotation => " + bb1.toString());
		System.out.println("Bean retrieved using the bean name 'beanName2' specified in the @Bean annotation => " + bb2.toString());
		
		System.out.println("Are both beans same (is singleton) => " + (bb1 == bb2));
	}

	private void loadConfigAndScannedBeans() {
		BeanA ba = ctx.getBean(BeanA.class);
		System.out.println("Collab A reference => " + ba.getCollabA());
		System.out.println("Collab B reference => " + ba.getCollabB());
	}

	private void loadCtx() {
		ctx = new AnnotationConfigApplicationContext(ScanRunnerConfig.class);
	}
}
