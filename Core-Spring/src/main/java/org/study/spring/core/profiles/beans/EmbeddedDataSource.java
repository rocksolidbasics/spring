package org.study.spring.core.profiles.beans;

public class EmbeddedDataSource implements DataSource_I {

	@Override
	public String getConnection() {
		return "EmbeddedDB";
	}

	@Override
	public void close() {
		System.out.println("Close embedded DS");
		return;
	}

	@Override
	public void shutdown() {
		System.out.println("Shutdown embedded DS");
		return;
	}

}
