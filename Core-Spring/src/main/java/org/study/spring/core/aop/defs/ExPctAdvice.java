package org.study.spring.core.aop.defs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExPctAdvice {

	@Before("org.study.spring.core.aop.defs.ExPctAspect.anyPublicMethodExec()")
	public void onPublicMethodExec() {
		//System.out.println("A public method executed");
	}
	
	@Before("org.study.spring.core.aop.defs.ExPctAspect.anyPublicSetterExec()")
	public void onBeforeSetterExec() {
		System.out.println("Setter about to be executed");
	}
}
