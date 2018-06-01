package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * L3.1 Bean
 * > Auto-startup = true
 * > Phase = 1
 *
 */

public class L3_1Bean implements SmartLifecycle {
	
	private L3_1_1Bean l311;

	public L3_1Bean(L3_1_1Bean l311b) {
		this.setL311(l311b);
	}

	@Override
	public void start() {
		System.out.println("L31 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L31 - << stop called");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public int getPhase() {
		return 1;
	}

	/* Auto-startup set to TRUE */
	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L31 - << SmartLifecycle stop called");
		callback.run();
	}

	public L3_1_1Bean getL311() {
		return l311;
	}

	public void setL311(L3_1_1Bean l311) {
		this.l311 = l311;
	}
	
}
