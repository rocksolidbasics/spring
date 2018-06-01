package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L311 Bean
 * > Timeout set to above wait time of 10 secs. - 12 secs.
 * > Phase = 1
 * > isAutoStartup = false
 *
 */

public class L3_1_1Bean implements SmartLifecycle {

	private int counter;
	
	@Override
	public void start() {
		counter++;
		System.out.println("L311 => bean started - counter = " + counter);
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L311 => bean stopped - counter = " + counter);
	}

	@Override
	public boolean isRunning() {
		counter++;
		return true;
	}

	@Override
	public int getPhase() {
		counter++;
		return 1;
	}

	@Override
	public boolean isAutoStartup() {
		counter++;
		return true;	//false
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L311 - << SmartLifecycle stop called");
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		callback.run();
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
