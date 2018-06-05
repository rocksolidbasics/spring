package org.study.spring.core.appCtx.postProc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class Order2BeanPostProcessor implements BeanPostProcessor, Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Order2PP - Bean: " + beanName + " created - " + bean.toString());
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
