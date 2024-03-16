package com.teamphoenix.ahub.news.query.vo;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;

public class ResponseFindPost {

    private String code;
    private String message;
    private String url;
    private NewsDTO result;
    private String writerId;

    public ResponseFindPost() {
    }

    public ResponseFindPost(String code, String message, String url, NewsDTO result, String writerId) {
        this.code = code;
        this.message = message;
        this.url = url;
        this.result = result;
        this.writerId = writerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public NewsDTO getResult() {
        return result;
    }

    public void setResult(NewsDTO result) {
        this.result = result;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "ResponseFindPost{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", result=" + result +
                ", writerId='" + writerId + '\'' +
                '}';
    }
}
