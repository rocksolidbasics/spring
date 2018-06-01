package org.study.spring.core.appCtx.methodInjn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Command processor is a singleton bean (hence intended to be a stateless bean)
 * takes the command type to run, creates the prototype command object and runs
 * it.
 * The ApplicationContextAware interface is used by the singleton to allow for it
 * to lookup the prototype command object when required
 * 
 */
public class CommandProcessor implements ApplicationContextAware {
	
	private ApplicationContext appCtx;
	
	public void process(String commandType) {
		Command cmd = this.getCommand(commandType);
		cmd.execute();
	}
	
	public Command getCommand(String commandType) {
		Command cmd = (Command)appCtx.getBean("commandBean", Command.class);
		cmd.setCmdType(commandType);
		return cmd;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx = applicationContext;
	}

}
