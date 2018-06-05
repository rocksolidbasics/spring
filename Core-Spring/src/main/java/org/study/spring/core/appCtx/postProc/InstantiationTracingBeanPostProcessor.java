package org.study.spring.core.appCtx.postProc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor, Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Order1PP: Bean: " + beanName + " created - " + bean.toString());
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof TestBeanValidationMarker) {
			((TestBean2)bean).testAndFixProperty();
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
