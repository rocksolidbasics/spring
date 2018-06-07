package org.study.spring.core.javacfg.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.study.spring.core.javacfg.ann.Exclude;
import org.study.spring.core.javacfg.beans.inclexcl.MainBeanA;

@Configuration
@ComponentScan(basePackages="org.study.spring.core.javacfg.beans.inclexcl",
		includeFilters = @Filter(type=FilterType.REGEX, pattern="\\..*IncludeBean\\..*"),
		excludeFilters = @Filter(Exclude.class))	//Default value is type 'annotation'
public class InclusionExclConfig {

	@Bean("mainBeanAName")
	//The qualifier name can't be used when using context.getBean(), instead the bean
	//name has to be used
	@Qualifier("mainBeanAQual")	
	public MainBeanA createMainBeanA() {
		MainBeanA mba = new MainBeanA();
		return mba;
	}
	
}
