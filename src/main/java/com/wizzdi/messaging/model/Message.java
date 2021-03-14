package com.wizzdi.messaging.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Basic;
import com.wizzdi.messaging.model.converters.JsonConverter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Message extends Basic {
public static final String CHATUSERS_FIELD="chatUsers";
public static final String CONTENT_FIELD="content";
private static final String MEDIA_FIELD="media";
	@Column(columnDefinition = "jsonb")
	@Convert(converter = JsonConverter.class)
	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();
	@ManyToOne(targetEntity = Chat.class)
	private Chat chat;
	@ManyToOne(targetEntity = ChatUser.class)
	private ChatUser sender;


	@JsonAnySetter
	public void set(String key, Object val) {
		other.put(key, val);
	}

	@JsonAnyGetter
	public Object get(String key) {
		return other.get(key);
	}

	@Column(columnDefinition = "jsonb")
	@Convert(converter = JsonConverter.class)
	@JsonIgnore
	public Map<String, Object> getOther() {
		return other;
	}

	public <T extends Message> T setOther(Map<String, Object> other) {
		this.other = other;
		return (T) this;
	}

	@ManyToOne(targetEntity = Chat.class)
	public Chat getChat() {
		return chat;
	}

	public <T extends Message> T setChat(Chat chat) {
		this.chat = chat;
		return (T) this;
	}

	@ManyToOne(targetEntity = ChatUser.class)
	public ChatUser getSender() {
		return sender;
	}

	public <T extends Message> T setSender(ChatUser sender) {
		this.sender = sender;
		return (T) this;
	}

	@Transient
	public Set<String> getMedia(){
		return (Set<String>) other.get(MEDIA_FIELD);
	}

	public <T extends Message> T setMedia(Set<String> media) {
		other.put(MEDIA_FIELD,media);
		return (T) this;
	}

	@Transient
	public String getContent(){
		return (String) other.get(CONTENT_FIELD);
	}

	public <T extends Message> T setContent(String content) {
		other.put(CONTENT_FIELD,content);
		return (T) this;
	}


	@Transient
	public Map<String, OffsetDateTime> getChatUsers(){
		return (Map<String, OffsetDateTime>) other.get(CHATUSERS_FIELD);
	}

	public <T extends Message> T setChatUsers(Map<String, OffsetDateTime> chatUsers) {
		other.put(CHATUSERS_FIELD,chatUsers);
		return (T) this;
	}
}
