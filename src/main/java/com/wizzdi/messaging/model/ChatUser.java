package com.wizzdi.messaging.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ChatUser extends Basic {

	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;

	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends ChatUser> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}
}
