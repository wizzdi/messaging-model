package com.wizzdi.messaging.model;

import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ChatToChatUser extends Basic {


	private boolean pendingInvite;
	@ManyToOne(targetEntity = Chat.class)
	private Chat chat;
	@ManyToOne(targetEntity = ChatUser.class)
	private ChatUser chatUser;

	@ManyToOne(targetEntity = Chat.class)
	public Chat getChat() {
		return chat;
	}

	public <T extends ChatToChatUser> T setChat(Chat chat) {
		this.chat = chat;
		return (T) this;
	}

	@ManyToOne(targetEntity = ChatUser.class)
	public ChatUser getChatUser() {
		return chatUser;
	}

	public <T extends ChatToChatUser> T setChatUser(ChatUser participant) {
		this.chatUser = participant;
		return (T) this;
	}

	public boolean isPendingInvite() {
		return pendingInvite;
	}

	public <T extends ChatToChatUser> T setPendingInvite(boolean pendingInvite) {
		this.pendingInvite = pendingInvite;
		return (T) this;
	}
}
