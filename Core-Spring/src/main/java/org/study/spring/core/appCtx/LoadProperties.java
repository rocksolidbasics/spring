package org.study.spring.core.appCtx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.core.appCtx.beans.BasicDataSource;
import org.study.spring.core.appCtx.beans.MysqlDataSource;
import org.study.spring.core.appCtx.beans.OracleDataSource;

public class LoadProperties {
	
	private ApplicationContext ctx;

	public static void main(String args[]) {
		LoadProperties lp = new LoadProperties();
		lp.loadContext();
		
		lp.loadPropertiesDefinedByP();
		lp.loadMysqlDSBean();
		lp.loadOraDSBean();
	}
	
	private void loadOraDSBean() {
		OracleDataSource oraDs = (OracleDataSource)ctx.getBean("oraDS");
		System.out.println("Properties loaded from db.props: " 
				+ oraDs.getUsername() + ", " + oraDs.getPassword());
		System.out.println("Properties loaded from ppc.props: " 
				+ oraDs.getUrl());
	}

	private void loadMysqlDSBean() {
		MysqlDataSource mDs = (MysqlDataSource)ctx.getBean("mysqlDS");
		System.out.println(mDs.getDriverClassName());	//@PropertySource("propertyMap") not working
	}

	public void loadPropertiesDefinedByP() {
		BasicDataSource props = (BasicDataSource)ctx.getBean("datasource");
		System.out.println("Properties defined using 'p' namespace: " + props.getDriverClassName());
	}
	
	public void loadContext() {
		ctx = new ClassPathXmlApplicationContext("classpath:loadProperties.xml");
	}
}
