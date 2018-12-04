package org.study.spring.core.profiles.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.spring.core.profiles.beans.Inventory;

@Configuration
@ComponentScan("org.study.spring.core.profiles.beans")
public class AnnotatedProfileConfig {

	@Bean
	public Inventory getInventory() {
		return new Inventory();
	}
	
}
