package com.wizzdi.messaging.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat extends Basic {
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;
	@ManyToOne(targetEntity = ChatUser.class)
	private ChatUser owner;
	@JsonIgnore
	@OneToMany(targetEntity = ChatToChatUser.class,mappedBy = "chat")
	private List<ChatToChatUser> chatToChatUsers=new ArrayList<>();


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

	@JsonIgnore
	@OneToMany(targetEntity = ChatToChatUser.class,mappedBy = "chat")
	public List<ChatToChatUser> getChatToChatUsers() {
		return chatToChatUsers;
	}

	public <T extends Chat> T setChatToChatUsers(List<ChatToChatUser> chatToChatUsers) {
		this.chatToChatUsers = chatToChatUsers;
		return (T) this;
	}
}
