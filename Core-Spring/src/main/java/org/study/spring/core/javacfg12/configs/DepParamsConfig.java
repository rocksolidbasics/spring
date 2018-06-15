package org.study.spring.core.javacfg12.configs;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.spring.core.appCtx.beans.Customer;
import org.study.spring.core.javacfg12.beans.deptest.Product;

@Configuration
@ComponentScan("org.study.spring.core.javacfg12.beans.deptest")
public class DepParamsConfig {

	/**
	 * Product list is auto injected by calling multiple getProductX() methods.
	 * 
	 * @param cust
	 * @param productList
	 * @return
	 */
	@Bean("simpleOrderBean")
	@Qualifier("sob")
	public OrderBean getOrderBeanA(Customer cust, List<Product> productList) {
		return new OrderBean(cust, productList);
	}
	
	/**
	 * Product list is fetched by calling other bean generation methods, although
	 * these methods are CGLIB intercepted by spring to ensure singleton access or
	 * as specified by the @Scope
	 * 
	 * Note: Have the method getOrderBean() overloaded causes lookup calls to return
	 * the same bean instead of two different beans even if the @Bean has a name and
	 * a @Qualifier was specified, hence had to rename it to two different methods A
	 * and B
	 */
	
	@Bean("listOrderBean")
	@Qualifier("lob")
	public OrderBean getOrderBeanB(Customer cust) {
		return new OrderBean(cust, getProducts());
	}
	
	/**
	 * This list bean won't be injected into the productList argument when creating the
	 * OrderBean in the getOrderBean() method arguments
	 * @return
	 */
	@Bean
	public List<Product> getProducts() {
		List<Product> prods = new LinkedList<Product>();
		prods.add(new Product("P1", 1));
		prods.add(new Product("P2", 2));
		
		return prods;
	}
	
	@Bean
	public Product getProduct3() {
		return new Product("P3", 3);
	}
	
	@Bean
	public Product getProduct4() {
		return new Product("P4", 4);
	}
	
	@Bean
	public Customer getCustomer() {
		return new Customer();
	}
}
