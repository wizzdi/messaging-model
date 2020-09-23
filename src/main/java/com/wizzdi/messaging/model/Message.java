package com.wizzdi.messaging.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.User;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Message extends Baseclass {

    private String subject;
    @Lob
    private String content;
    @ManyToOne(targetEntity = User.class)
    private User fromUser;
    @ManyToOne(targetEntity = User.class)
    private User toUser;

    public Message() {
    }

    public Message(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    public String getSubject() {
        return subject;
    }

    public <T extends Message> T setSubject(String subject) {
        this.subject = subject;
        return (T) this;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public <T extends Message> T setContent(String content) {
        this.content = content;
        return (T) this;
    }

    @ManyToOne(targetEntity = User.class)
    public User getFromUser() {
        return fromUser;
    }

    public <T extends Message> T setFromUser(User fromUser) {
        this.fromUser = fromUser;
        return (T) this;
    }

    @ManyToOne(targetEntity = User.class)
    public User getToUser() {
        return toUser;
    }

    public <T extends Message> T setToUser(User toUser) {
        this.toUser = toUser;
        return (T) this;
    }
}
