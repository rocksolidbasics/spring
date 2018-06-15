package org.study.spring.core.javacfg12.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.spring.core.javacfg12.beans.ExternalService_I;
import org.study.spring.core.javacfg12.beans.HTTPServiceBean;
import org.study.spring.core.javacfg12.beans.WSServiceBean;

@Configuration
@ComponentScan("org.study.spring.core.javacfg12.beans")
public class MultitypeBeanConfig {

	/**
	 * Without a qualifier, the @Autowired on DataAccessor won't be able to resolve onto a single bean.
	 * Else the return type of both the methods should be on the specific type rather than on being on
	 * a super-type 'ExternalService_I'
	 * @return
	 */
	
	@Bean
	@Qualifier("wBean")
	public ExternalService_I getWSBean() {
		return new WSServiceBean();
	}
	
	
	@Bean
	@Qualifier("hBean")
	public ExternalService_I getHTTPBean() {
		return new HTTPServiceBean();
	}
}
