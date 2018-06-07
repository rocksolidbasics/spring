package org.study.spring.core.javacfg.beans.inclexcl;

import org.springframework.stereotype.Component;
import org.study.spring.core.javacfg.ann.Exclude;

//@Exclude
@Component
public class ExcludeBeanB {

	private String prop1;

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	
}
