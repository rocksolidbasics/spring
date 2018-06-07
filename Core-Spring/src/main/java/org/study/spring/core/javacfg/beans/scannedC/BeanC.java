package org.study.spring.core.javacfg.beans.scannedC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanC {

	/**
	 * This injection point qualifier resolves the bean using the @Qualifier used on the configuration
	 * class' method with the same name as provided here @Qualifier("collabC1"). Hence, a @Qualifier can
	 * be used at injection point with an @Autowired, and can also be used with @Bean to name a generated bean
	 */
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
