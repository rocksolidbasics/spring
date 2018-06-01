package org.study.spring.core.appCtx.methodInjn;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class AbstractLookupProcessor {
	
	public void process(String commandType) {
		Command cmd = this.getCommand();
		cmd.setCmdType(commandType);
		cmd.execute();
	}
	
	/**
	 * Note: The method doesn't have a input parameter
	 */
	public abstract Command getCommand();
	
	/* Use context:component-scan tag so that the @Lookup annotation is processed */
	@Lookup("commandBean")
	public abstract Command getAnnotatedCommand();
}
