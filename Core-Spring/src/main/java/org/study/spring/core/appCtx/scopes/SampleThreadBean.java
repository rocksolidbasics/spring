package org.study.spring.core.appCtx.scopes;

public class SampleThreadBean implements Runnable {
	
	private ThreadSessionObj mObj;
	
	public SampleThreadBean(ThreadSessionObj obj) {
		this.setmObj(obj);
	}

	@Override
	public void run() {
		int i = 0;
		while(i < 10) {
			this.mObj.increament();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		System.out.println(this + ": " + this.mObj.getCounter());
	}

	public ThreadSessionObj getmObj() {
		return mObj;
	}

	public void setmObj(ThreadSessionObj mObj) {
		this.mObj = mObj;
	}

}
