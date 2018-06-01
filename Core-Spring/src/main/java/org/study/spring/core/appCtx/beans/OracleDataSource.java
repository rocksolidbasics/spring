package org.study.spring.core.appCtx.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class OracleDataSource {

	//Annotation won't work with properties loaded via the context:property-placeholder tag
	//@see loadProperties.xml
	@Value("${ppc.driver}")
	private String driverClassName;
	
	//This property configured from ppc.properties during bean definition
	private String url;
	
	//Properties username and password are injected from the bean specification in XML, with
	//properties defined in db.props
	private String username;
	private transient String password;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
