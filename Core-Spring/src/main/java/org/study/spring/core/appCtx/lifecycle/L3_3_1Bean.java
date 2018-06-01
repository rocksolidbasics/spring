package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L3.3.1 Bean
 * Phase = 5
 * IsAutoStartup = true
 *
 */

public class L3_3_1Bean implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("L331 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L331 - << stop called");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public int getPhase() {
		return 5;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L331 - << SmartLifecycle stop called");
		callback.run();
	}

}
