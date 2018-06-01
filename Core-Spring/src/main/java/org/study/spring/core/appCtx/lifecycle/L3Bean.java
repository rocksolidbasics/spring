package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.Lifecycle;

public class L3Bean implements Lifecycle {

	private L3_1Bean l31;
	private L3_2Bean l32;
	private L3_3Bean l33;

	public L3Bean(L3_1Bean l31b, L3_2Bean l32b, L3_3Bean l33b) {
		this.setL31(l31b);
		this.setL32(l32b);
		this.setL33(l33b);
	}
	
	@Override
	public void start() {
		System.out.println("L3 - >> started bean");
	}

	@Override
	public void stop() {
		System.out.println("L3 - << stopped bean");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	public L3_1Bean getL31() {
		return l31;
	}

	public void setL31(L3_1Bean l31) {
		this.l31 = l31;
	}

	public L3_2Bean getL32() {
		return l32;
	}

	public void setL32(L3_2Bean l32) {
		this.l32 = l32;
	}

	public L3_3Bean getL33() {
		return l33;
	}

	public void setL33(L3_3Bean l33) {
		this.l33 = l33;
	}

	
}
