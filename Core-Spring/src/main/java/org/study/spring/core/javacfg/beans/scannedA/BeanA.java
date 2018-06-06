package org.study.spring.core.javacfg.beans.scannedA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.study.spring.core.javacfg.beans.scannedB.CollaboratorB;

/**
 * This class is not registered via the @Component annotation.
 * Instead the javaconfig will register it
 *
 */

public class BeanA {

	private String prop1;
	private String prop2;
	
	@Autowired
	private CollaboratorA collabA;
	
	@Qualifier("collabQual")
	@Autowired
	private CollaboratorB collabB;
	
	public String getProp1() {
		return prop1;
	}
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	public String getProp2() {
		return prop2;
	}
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	public CollaboratorA getCollabA() {
		return collabA;
	}
	public void setCollabA(CollaboratorA collabA) {
		this.collabA = collabA;
	}
	public CollaboratorB getCollabB() {
		return collabB;
	}
	public void setCollabB(CollaboratorB collabB) {
		this.collabB = collabB;
	}
	
}
