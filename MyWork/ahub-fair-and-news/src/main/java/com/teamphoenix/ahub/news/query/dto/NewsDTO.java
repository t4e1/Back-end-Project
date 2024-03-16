package com.teamphoenix.ahub.news.query.dto;

import java.time.LocalDateTime;

public class NewsDTO {

    private int newsId;
    private String newsTitle;
    private String newsContent;
    private LocalDateTime newsWritedate;
    private int useAcceptance;
    private int memberCode;
    private String writerId;

    public NewsDTO() {
    }

    public NewsDTO(String newsTitle, String newsContent) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public NewsDTO(String newsTitle, String newsContent, String writerId) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.writerId = writerId;
    }

    public NewsDTO(int newsId, String newsTitle, String newsContent, LocalDateTime newsWritedate, int useAcceptance, int memberCode) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsWritedate = newsWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    public NewsDTO(int newsId, String newsTitle, String newsContent, LocalDateTime newsWritedate, int useAcceptance, int memberCode, String writerId) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsWritedate = newsWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
        this.writerId = writerId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public LocalDateTime getNewsWritedate() {
        return newsWritedate;
    }

    public void setNewsWritedate(LocalDateTime newsWritedate) {
        this.newsWritedate = newsWritedate;
    }

    public int getUseAcceptance() {
        return useAcceptance;
    }

    public void setUseAcceptance(int useAcceptance) {
        this.useAcceptance = useAcceptance;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsWritedate=" + newsWritedate +
                ", useAcceptance=" + useAcceptance +
                ", memberCode=" + memberCode +
                ", writerId='" + writerId + '\'' +
                '}';
    }
}