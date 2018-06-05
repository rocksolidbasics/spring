package org.study.spring.core.appCtx.postProc;

public class TestBean2 implements TestBeanValidationMarker {

	private String prop3;
	private String prop4;
	
	public String getProp3() {
		return prop3;
	}
	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}
	public String getProp4() {
		return prop4;
	}
	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	
	public void testAndFixProperty() {
		System.out.println("Tested properties values on bean2 and fixed them");
	}
	
}
