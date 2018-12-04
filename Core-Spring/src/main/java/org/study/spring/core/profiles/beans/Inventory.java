package org.study.spring.core.profiles.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Inventory {

	@Autowired
	private InventoryService invService;

	public InventoryService getInvService() {
		return invService;
	}

	public void setInvService(InventoryService invService) {
		this.invService = invService;
	}
}
