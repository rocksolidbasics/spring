package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L3.3 Bean
 * Phase = 3
 * IsAutoStartup = false
 *
 */

public class L3_3Bean implements SmartLifecycle {
	
	private L3_3_1Bean l331;

	public L3_3Bean(L3_3_1Bean l331b) {
		this.setL331(l331b);
	}
	
	@Override
	public void start() {
		System.out.println("L33 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L33 - << stop called");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public int getPhase() {
		return 3;
	}

	@Override
	public boolean isAutoStartup() {
		return true;	//false
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L33 - << SmartLifecycle stop called");
		callback.run();
	}

	public L3_3_1Bean getL331() {
		return l331;
	}

	public void setL331(L3_3_1Bean l331) {
		this.l331 = l331;
	}

}
