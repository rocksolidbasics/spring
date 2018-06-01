package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L3.2.1 Bean
 * Phase = 4
 * IsAutoStartup = false (Phase 4 bean startup doens't happen when this property is false)
 *
 */

public class L3_2_1Bean implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("L321 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L321 - << stop called");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public int getPhase() {
		return 4;
	}

	@Override
	public boolean isAutoStartup() {
		return true;	//false
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L321 - << SmartLifecycle stop called");
		callback.run();
	}

}
