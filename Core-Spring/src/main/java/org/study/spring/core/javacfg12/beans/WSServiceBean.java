package org.study.spring.core.javacfg12.beans;

public class WSServiceBean implements ExternalService_I {

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public Object getResource() {
		return new String("WSServiceBean");
	}

}
