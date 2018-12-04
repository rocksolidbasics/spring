package org.study.spring.core.profiles.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("integration")
public class IntInventoryService extends InventoryService {

	public IntInventoryService() {
		this.put("type", "Integration");
	}
}
