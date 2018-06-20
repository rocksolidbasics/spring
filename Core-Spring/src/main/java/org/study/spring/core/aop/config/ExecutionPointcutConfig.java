package org.study.spring.core.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.study.spring.core.aop.targets.Lift;

/**
 * Use @EnableAspectJAutoProxy is available with the default spring-context jar inclusion,
 * but to run the application and to use the @Aspect annotation, it requires
 * AspectJ dependency jars to be present in the classpath (@see build.gradle for spring-aspects
 * inclusion)
 * 
 */

@Configuration
@ComponentScan("org.study.spring.core.aop.defs, org.study.spring.core.aop.targets")
@EnableAspectJAutoProxy
public class ExecutionPointcutConfig {

	@Bean("liftBean")
	public Lift getLift() {
		return new Lift();
	}
}
