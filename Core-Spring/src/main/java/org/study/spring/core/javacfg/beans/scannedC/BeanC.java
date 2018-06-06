package org.study.spring.core.javacfg.beans.scannedC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanC {

	@Qualifier("collabC1")
	@Autowired
	private CollaboratorC collabC;

	public CollaboratorC getCollabC() {
		return collabC;
	}

	public void setCollabC(CollaboratorC collabC) {
		this.collabC = collabC;
	}

}
