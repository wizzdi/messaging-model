package com.wizzdi.messaging.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Chat extends Basic {
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;
	@ManyToOne(targetEntity = ChatUser.class)
	private ChatUser owner;


	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends Chat> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}

	@ManyToOne(targetEntity = ChatUser.class)
	public ChatUser getOwner() {
		return owner;
	}

	public <T extends Chat> T setOwner(ChatUser participant) {
		this.owner = participant;
		return (T) this;
	}
}
