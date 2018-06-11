package org.study.spring.core.javacfg.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.spring.core.javacfg.beans.scannedA.BeanA;
import org.study.spring.core.javacfg.beans.scannedB.BeanB;
import org.study.spring.core.javacfg.beans.scannedB.BeanD;
import org.study.spring.core.javacfg.beans.scannedC.BeanC;
import org.study.spring.core.javacfg.beans.scannedC.CollaboratorC;

/**
 * > Bean component scan done from selected packages having @Component annotated beans
 *
 */
@Configuration
@ComponentScan(basePackages="org.study.spring.core.javacfg.beans.scannedA,org.study.spring.core.javacfg.beans.scannedB")
public class ScanRunnerConfig {
	
	/**
	 * Bean definition without a name, hence has to be dereferenced using class name
	 * @return
	 */
	@Bean
	public BeanA getBeanA() {
		return new BeanA();
	}
	
	/**
	 * Bean definition using the "name" attribute, can be denoted using the default value attribute
	 * as @Bean("beanName1")
	 * @return
	 */
	@Bean(name="beanName1")
	public BeanB getBeanB1() {
		return new BeanB();
	}
	
	/**
	 * > Below is equivalent to using @Bean("beanName2")
	 * > Even though there are two methods for the same bean class, beanName1 and beanName2, 
	 * we will have two objects created. Each of these method calls will return
	 * the same object, hence the singleton
	 */
	@Bean(name="beanName2")
	public BeanB getBeanB2() {
		return new BeanB();
	}
	
	/**
	 * @Qualifier is both used at the bean generation point as well as at its
	 * usual injection point
	 * @return
	 */
	@Bean
	@Qualifier("collabC1")
	public CollaboratorC getBeanC1() {
		return new CollaboratorC();
	}
	
	@Bean
	public BeanC getBeanC2() {
		return new BeanC();
	}
	
	@Bean
	public BeanD getBeanD() {
		return new BeanD();
	}
}
