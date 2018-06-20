package org.study.spring.core.aop.targets;

import java.util.List;
import java.util.Stack;

public class Lift {

	private static final int maxLevel = 10;
	
	private Stack<Route> activeRoutes;
	private int curLevel;
	private boolean isTravelling = false;
	private int travelDir = 1;
	
	public void register(List<Route> routes) {
		if(isTravelling) return;
		
		for(Route r : routes) {
			r.setSourceLevel(this.getLevel());
		}
	}

	public void setLevel(int level) {
		this.curLevel = level;
	}
	
	public int getLevel() {
		return curLevel;
	}

	public void travel() {
		System.out.println("Travelling");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	public boolean isTravelling() {
		return isTravelling;
	}

	public void setTravelling(boolean isTravelling) {
		this.isTravelling = isTravelling;
	}

}
