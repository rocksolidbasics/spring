package org.study.spring.core.javacfg.beans.scannedB;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("collabDqual")
public class CollaboratorD {

	private String prop1;

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
}
