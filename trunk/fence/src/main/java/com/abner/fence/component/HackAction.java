package com.abner.fence.component;

import com.abner.fence.annotation.ClientConfig;

public abstract class HackAction extends ExtCommand {

	@Override
	@ClientConfig(name = "itemId")
	public String getId() {
		return super.getId();
	}
}
