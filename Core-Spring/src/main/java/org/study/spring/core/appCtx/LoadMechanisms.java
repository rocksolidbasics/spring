package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.study.spring.core.appCtx.beans.Customer;
import org.study.spring.core.appCtx.beans.Order;
import org.study.spring.core.appCtx.beans.Order.LineItem;
import org.study.spring.core.appCtx.beans.OtherOrder;
import org.study.spring.core.appCtx.beans.Product;
import org.study.spring.core.appCtx.delegatedBeanFactory.EntityFactory;

public class LoadMechanisms {
	
	private ApplicationContext fCtx;

	/*
	 * Available implementations of application context are:
	 * ClassPathXmlApplicationContext, FileSystemXml*, StaticApplicationContext, XmlWebApplicationContext
	 * 
	 * Note:
	 * In case the classpath:<fileName> doesn't work (file not found error is thrown), run the jar command
	 * in the gradle and try again, or try creating a new 'Run' configuration in eclipse and run again
	 */

	public static void main(String args[]) {
		LoadMechanisms m = new LoadMechanisms();
		m.loadFromFile();
		m.loadFromClasspath();
		m.loadFragmentBeans();
		m.loadInnerClassBean();
		
		m.loadFromBeanFactoryStatic();
		m.loadFromBeanFactoryInstance();
		
		m.getCtrBasedOrder();
		m.getSetterBasedOrderAddress();
	}
	
	private void getSetterBasedOrderAddress() {
		Order order = (Order) fCtx.getBean("setOrder");
		System.out.println("Order address set via setter DI: " + order.getAddress());
	}



	private void getCtrBasedOrder() {
		Order order = (Order) fCtx.getBean("ctrOrder");
		System.out.println("Order created via constructor: " + order.getLineItems());
	}

	private void loadFromBeanFactoryInstance() {
		Product prod = (Product)fCtx.getBean("factoryProd");
		System.out.println("Product created via instance factory: " + prod.getSku() + ", " + prod.getName());
	}

	private void loadFromBeanFactoryStatic() {
		EntityFactory factory = (EntityFactory)fCtx.getBean("staticBeanFactory");
		System.out.println("Factory reference: " + factory);
	}

	private void loadInnerClassBean() {
		LineItem l1 = (LineItem)fCtx.getBean("lineItem");
		LineItem l2 = (LineItem)fCtx.getBean("lineItemNew");
		
		System.out.println("LineItem1 = " + l1.getItemSeq());
		System.out.println("LineItem2 = " + l2.getItemSeq());
	}

	/**
	 * > Load bean using alias name, and extended name using <alias> tag
	 * > Load beans defined in the fragment imported into the main application context
	 */
	
	private void loadFragmentBeans() {
		Product prod = (Product)fCtx.getBean("productAlias");
		System.out.println("Fragment bean - Product: " + prod.getSku() + ", " + prod.getName());
		Customer cust = (Customer)fCtx.getBean("customer");
		System.out.println("Fragment bean - Customer: " + cust.getCustomerId() + ", " + cust.getName());
		
		Customer custAlias = (Customer)fCtx.getBean("customerNewAlias");
		System.out.println("<alias> tag using the orignal bean declarations 'id' as reference: " + custAlias.getCustomerId());
		Customer custAliasAlias = (Customer)fCtx.getBean("customerAliasAlias");
		System.out.println("<alias> tag using another alias as reference for new alias: " + custAliasAlias.getCustomerId());
	}
	
	private void loadFromClasspath() {
		fCtx = new ClassPathXmlApplicationContext("classpath:appContext.xml");
		
		Order o1 = (Order)fCtx.getBean("order");
		System.out.println("Values loaded from classpath: " + o1.getOrderId() + ", " + o1.getCustomerName());
	}
	
	/**
	 * The paths can have ${PROPERTY_NAME} placeholder to avoid hardcoding of absolute paths. The 
	 * property values can be passed on from the command line
	 */
	
	private void loadFromFile() {
		FileSystemXmlApplicationContext fCtx = new FileSystemXmlApplicationContext("D:\\Others\\Spring\\Projects\\Core-Spring\\src\\main\\others\\appContext.xml");
		OtherOrder o1 = (OtherOrder)fCtx.getBean("order");
		System.out.println("Values loaded from file definition: " + o1.getOrderId() + ", " + o1.getCustomerName());
	}
}
