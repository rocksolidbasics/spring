package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * Bean L3.2
 * Phase = 2
 * IsAutoStartup = true
 *
 */

public class L3_2Bean implements SmartLifecycle {

	private L3_2_1Bean l321;
	private L3_2_2Bean l322;

	public L3_2Bean(L3_2_1Bean l321b, L3_2_2Bean l322b) {
		this.setL321(l321b);
		this.setL322(l322b);
	}
	
	@Override
	public void start() {
		System.out.println("L32 - >> start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L32 - << stop called");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public int getPhase() {
		return 2;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("L32 - << SmartLifecycle stop called");
		callback.run();
	}

	public L3_2_1Bean getL321() {
		return l321;
	}

	public void setL321(L3_2_1Bean l321) {
		this.l321 = l321;
	}

	public L3_2_2Bean getL322() {
		return l322;
	}

	public void setL322(L3_2_2Bean l322) {
		this.l322 = l322;
	}

}
