package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

public class L2_2Bean implements SmartLifecycle {

	private int value;
	
	public void customInit() {
		value = 20;
		System.out.println("L22 - >> custom init called - value set = " + value);
	}
	
	public void customDestroy() {
		System.out.println("L22 - << custom destroy called - value = " + value);
	}

	@Override
	public void start() {
		System.out.println("L22 - >> smart lifecycle - start");
	}

	@Override
	public void stop() {
		System.out.println("L22 - << smart lifecycle - stop");
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
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		callback.run();
	}
	
}
