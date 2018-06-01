package org.study.spring.core.appCtx.methodInjn;

public class Command {

	private String cmdType;
	
	public void execute() {
		System.out.println("Executing command: Bean - " + this.toString() + " - " + getCmdType());
	}

	public String getCmdType() {
		return cmdType;
	}

	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}
}
