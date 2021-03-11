package com.wizzdi.messaging.model;

import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ChatToParticipant extends Basic {


	private boolean pendingInvite;
	@ManyToOne(targetEntity = Chat.class)
	private Chat chat;
	@ManyToOne(targetEntity = Participant.class)
	private  Participant participant;

	@ManyToOne(targetEntity = Chat.class)
	public Chat getChat() {
		return chat;
	}

	public <T extends ChatToParticipant> T setChat(Chat chat) {
		this.chat = chat;
		return (T) this;
	}

	@ManyToOne(targetEntity = Participant.class)
	public Participant getParticipant() {
		return participant;
	}

	public <T extends ChatToParticipant> T setParticipant(Participant participant) {
		this.participant = participant;
		return (T) this;
	}

	public boolean isPendingInvite() {
		return pendingInvite;
	}

	public <T extends ChatToParticipant> T setPendingInvite(boolean pendingInvite) {
		this.pendingInvite = pendingInvite;
		return (T) this;
	}
}
