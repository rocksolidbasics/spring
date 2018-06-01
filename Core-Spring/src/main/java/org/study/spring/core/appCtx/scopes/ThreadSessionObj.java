package org.study.spring.core.appCtx.scopes;

public class ThreadSessionObj {

	private int counter;
	
	public void increament() {
		setCounter(getCounter() + 1);
		System.out.println("Increment called by thread: " + Thread.currentThread().getName() + " - " + counter);
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
}
