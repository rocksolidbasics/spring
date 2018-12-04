package org.study.spring.core.profiles.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("staging")
@Service
public class StgInventoryService extends InventoryService {

	public StgInventoryService() {
		this.put("type", "Staging");
	}
	
}
