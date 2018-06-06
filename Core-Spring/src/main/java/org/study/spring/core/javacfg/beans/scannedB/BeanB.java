package org.study.spring.core.javacfg.beans.scannedB;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanB {

	@Autowired
	private CollaboratorB collabB;

	public CollaboratorB getCollabB() {
		return collabB;
	}

	public void setCollabB(CollaboratorB collabB) {
		this.collabB = collabB;
	}
	
	
}
