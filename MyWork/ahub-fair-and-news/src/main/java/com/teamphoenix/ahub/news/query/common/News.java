package com.teamphoenix.ahub.news.query.common;

import java.time.LocalDateTime;

public class News {

    private int newsId;
    private String newsTitle;
    private String newsContent;
    private LocalDateTime newsWritedate;
    private int useAcceptance;
    private int member_code;

    public News() {
    }

    public News(int newsId, String newsTitle, String newsContent, LocalDateTime newsWritedate, int useAcceptance, int member_code) {
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

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public LocalDateTime getNewsWritedate() {
        return newsWritedate;
    }

    public int getUseAcceptance() {
        return useAcceptance;
    }

    public int getMember_code() {
        return member_code;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsWritedate=" + newsWritedate +
                ", useAcceptance=" + useAcceptance +
                ", member_code=" + member_code +
                '}';
    }
}
