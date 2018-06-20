package org.study.spring.core.aop.defs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExPctAspect {

	@Pointcut("execution(public * *(..))")
	public void anyPublicMethodExec() { }
	
	@Pointcut("execution(* set*(..))")
	public void anyPublicSetterExec() { }
}
