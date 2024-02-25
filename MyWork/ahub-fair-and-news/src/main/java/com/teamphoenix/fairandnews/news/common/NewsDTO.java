package com.teamphoenix.fairandnews.news.common;

import java.time.LocalDateTime;

public class NewsDTO {

    private int newsId;
    private String newsTitle;
    private String newsContent;
    private java.time.LocalDateTime newsWritedate;
    private int useAcceptance;
    private int member_code;

    public NewsDTO() {
    }

    public NewsDTO(int newsId, String newsTitle, String newsContent, LocalDateTime newsWritedate, int useAcceptance, int member_code) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsWritedate = newsWritedate;
        this.useAcceptance = useAcceptance;
        this.member_code = member_code;
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

    public int getMember_code() {
        return member_code;
    }

    public void setMember_code(int member_code) {
        this.member_code = member_code;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsWritedate=" + newsWritedate +
                ", useAcceptance=" + useAcceptance +
                ", member_code=" + member_code +
                '}';
    }
}
