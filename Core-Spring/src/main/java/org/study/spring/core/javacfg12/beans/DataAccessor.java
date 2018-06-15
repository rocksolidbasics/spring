package org.study.spring.core.javacfg12.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataAccessor {

	@Autowired
	@Qualifier("hBean")
	private ExternalService_I extServ;

	public ExternalService_I getExtServ() {
		return extServ;
	}

	public void setExtServ(ExternalService_I extServ) {
		this.extServ = extServ;
	}
}
