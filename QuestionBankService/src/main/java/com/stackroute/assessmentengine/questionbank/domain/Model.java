package com.stackroute.assessmentengine.questionbank.domain;

import org.springframework.stereotype.Service;

@Service
public class Model {

    String key;
    String value;
    
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }    
}