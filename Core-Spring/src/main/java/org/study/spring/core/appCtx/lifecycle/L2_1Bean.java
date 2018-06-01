package org.study.spring.core.appCtx.lifecycle;

public class L2_1Bean {

	private int value;
	
	public void customInit() {
		value = 10;
		System.out.println("L21 - >> custom init called - value set = " + value);
	}
	
	public void customDestroy() {
		System.out.println("L21 - << custom destroy called - value = " + value);
	}
}
