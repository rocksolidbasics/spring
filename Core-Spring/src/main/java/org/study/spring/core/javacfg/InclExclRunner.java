package org.study.spring.core.javacfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.spring.core.javacfg.beans.inclexcl.MainBeanA;
import org.study.spring.core.javacfg.configs.InclusionExclConfig;

public class InclExclRunner {

	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		InclExclRunner ier = new InclExclRunner();
		ier.initCtx();
		
		ier.testIncludeExcludeScanning();
	}

	private void testIncludeExcludeScanning() {
		MainBeanA mba = (MainBeanA)ctx.getBean("mainBeanAName");
		System.out.println("MainBeanA resolved and its collaborator bean IncludeBeanA is resolved, but "
				+ "ExcludeBeanB won't be resolved as it contains the @Exclude custom annotation (Uncomment"
				+ "the @Exlude annotation to see the exclusion behavior => " + mba.getiBeanA());
	}

	private void initCtx() {
		ctx = new AnnotationConfigApplicationContext(InclusionExclConfig.class);
	}

}
