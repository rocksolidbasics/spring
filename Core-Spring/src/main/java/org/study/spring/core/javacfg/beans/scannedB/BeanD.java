package org.study.spring.core.javacfg.beans.scannedB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanD {

	@Autowired
	@Qualifier("collabDqual")
	private CollaboratorD collabD;

	public CollaboratorD getCollabD() {
		return collabD;
	}

	public void setCollabD(CollaboratorD collabD) {
		this.collabD = collabD;
	}
	
}
