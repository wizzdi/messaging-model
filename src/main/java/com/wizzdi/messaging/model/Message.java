package com.wizzdi.messaging.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Basic;
import com.wizzdi.messaging.model.converters.JsonConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Message extends Basic {

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverter.class)
    @JsonIgnore
    private Map<String,Object> other=new HashMap<>();


    @JsonAnySetter
    public void set(String key,Object val){
        other.put(key,val);
    }

    @JsonAnyGetter
    public Object get(String key){
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
}
