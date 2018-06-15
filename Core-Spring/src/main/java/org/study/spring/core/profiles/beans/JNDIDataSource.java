package org.study.spring.core.profiles.beans;

public class JNDIDataSource implements DataSource_I {

	@Override
	public String getConnection() {
		return "JNDIDataSource";
	}

	@Override
	public void close() {
		System.out.println("Closing JNDI DS");
		return;
	}

	@Override
	public void shutdown() {
		System.out.println("Shutdown JNDI DS");
		return;
	}

}
