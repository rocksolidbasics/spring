package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.SmartLifecycle;

public class L4Bean implements SmartLifecycle {

	//DefaultLifecycleProcessor;
	//ConfigurableApplicationContext;
	
	@Override
	public void start() {
		System.out.println("L4 - >> SmartLifecycle start called");
	}

	/* Method not called for SmartLifecycle beans only for Lifecycle based beans */
	@Override
	public void stop() {
		System.out.println("L4 - << Lifecycle stop called");
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
		System.out.println("L4 - << SmartLifecycle stop called");
		callback.run();
	}

}
