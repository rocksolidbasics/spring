package org.study.spring.core.profiles.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.study.spring.core.profiles.beans.Customer;
import org.study.spring.core.profiles.beans.DataSource_I;
import org.study.spring.core.profiles.beans.EmbeddedDataSource;
import org.study.spring.core.profiles.beans.JNDIDataSource;
import org.study.spring.core.profiles.beans.OrderBean;

@Configuration
@ComponentScan("org.study.spring.core.profiles.beans")
public class ProfileConfig {

	@Profile("developement")
	@Bean("datasource")
	public DataSource_I dataSourceEmbDS() {
		return new EmbeddedDataSource();
	}
	
	@Profile("production")
	@Bean("datasource")
	public DataSource_I dataSourceJNDIDS() {
		return new JNDIDataSource();
	}
	
	@Bean
	public OrderBean getOrder(Customer cust) {
		return new OrderBean(cust);
	}
}
