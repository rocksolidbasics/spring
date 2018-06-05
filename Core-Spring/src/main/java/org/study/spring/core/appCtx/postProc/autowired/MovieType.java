package org.study.spring.core.appCtx.postProc.autowired;

public class MovieType {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
