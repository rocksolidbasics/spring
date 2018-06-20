package org.study.spring.core.aop.targets;

public class Route {

	private int destLevel;
	private int sourceLevel;
	
	public Route(int destLevel, Person person) {
		this.setDestLevel(destLevel);
	}

	public int getDestLevel() {
		return destLevel;
	}

	public void setDestLevel(int destLevel) {
		this.destLevel = destLevel;
	}

	public int getSourceLevel() {
		return sourceLevel;
	}

	public void setSourceLevel(int sourceLevel) {
		this.sourceLevel = sourceLevel;
	}

}
