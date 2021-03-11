package com.wizzdi.messaging.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.SecurityUser;

import javax.persistence.Entity;

@Entity
public class ChatUser extends SecurityUser {

	private String username;
	@JsonIgnore
	private String password;

	public String getUsername() {
		return username;
	}

	public <T extends ChatUser> T setUsername(String username) {
		this.username = username;
		return (T) this;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public <T extends ChatUser> T setPassword(String password) {
		this.password = password;
		return (T) this;
	}
}
