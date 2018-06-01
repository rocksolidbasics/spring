package org.study.spring.core.appCtx.lifecycle;

import org.springframework.context.Lifecycle;

public class RootBean implements Lifecycle {
	
	private L1Bean l1;
	private L2Bean l2;
	private L3Bean l3;
	private L4Bean l4;

	public RootBean(L1Bean l1b, L2Bean l2b, L3Bean l3b, L4Bean l4b) {
		this.setL1(l1b);
		this.setL2(l2b);
		this.setL3(l3b);
		this.setL4(l4b);
	}

	@Override
	public void start() {
		System.out.println("=> Started Root bean");
	}

	@Override
	public void stop() {
		System.out.println("<= Stopping Root bean");
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	public L1Bean getL1() {
		return l1;
	}

	public void setL1(L1Bean l1) {
		this.l1 = l1;
	}

	public L2Bean getL2() {
		return l2;
	}

	public void setL2(L2Bean l2) {
		this.l2 = l2;
	}

	public L3Bean getL3() {
		return l3;
	}

	public void setL3(L3Bean l3) {
		this.l3 = l3;
	}

	public L4Bean getL4() {
		return l4;
	}

	public void setL4(L4Bean l4) {
		this.l4 = l4;
	}

}
