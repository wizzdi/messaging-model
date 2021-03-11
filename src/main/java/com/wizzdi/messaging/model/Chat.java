package com.wizzdi.messaging.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Chat extends Basic {
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;
	@ManyToOne(targetEntity = Participant.class)
	private Participant participant;


	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends Chat> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}

	@ManyToOne(targetEntity = Participant.class)
	public Participant getParticipant() {
		return participant;
	}

	public <T extends Chat> T setParticipant(Participant participant) {
		this.participant = participant;
		return (T) this;
	}
}
