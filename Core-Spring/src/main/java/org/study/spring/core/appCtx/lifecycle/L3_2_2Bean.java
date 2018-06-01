package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L3.2.2 Bean
 * Phase = 3
 * IsAutoStartup = true
 * 
 */

public class L3_2_2Bean implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("L322 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L322 - << stop called");
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
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L322 - << SmartLifecycle stop called");
		callback.run();
	}

}
