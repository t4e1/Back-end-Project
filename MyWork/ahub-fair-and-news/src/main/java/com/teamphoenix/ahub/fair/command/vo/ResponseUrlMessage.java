package com.teamphoenix.ahub.fair.command.vo;

import java.util.Map;

public class ResponseUrlMessage {

    private String message;
    private String url;

    public ResponseUrlMessage() {

    }

    public ResponseUrlMessage(String message, String url) {
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResponseUrlMessage{" +
                "message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
