package org.study.spring.core.profiles.beans;

public interface DataSource_I {

	public String getConnection();
	
	public void close();
	
	public void shutdown();
}
