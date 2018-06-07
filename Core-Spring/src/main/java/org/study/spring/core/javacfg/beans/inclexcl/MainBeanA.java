package org.study.spring.core.javacfg.beans.inclexcl;

import org.springframework.beans.factory.annotation.Autowired;

public class MainBeanA {

	@Autowired
	private IncludeBeanA iBeanA;
	@Autowired
	private ExcludeBeanB eBeanB;
	
	public IncludeBeanA getiBeanA() {
		return iBeanA;
	}
	public void setiBeanA(IncludeBeanA iBeanA) {
		this.iBeanA = iBeanA;
	}
	public ExcludeBeanB geteBeanB() {
		return eBeanB;
	}
	public void seteBeanB(ExcludeBeanB eBeanB) {
		this.eBeanB = eBeanB;
	}
	
}
