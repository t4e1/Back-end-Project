package com.teamphoenix.ahub.news.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class News {

    @Id
    @Column(name = "news_id")
    private int newsId;

    @Column(name = "news_title")
    private String newsTitle;

    @Column(name = "news_content")
    private String news_content;

    @Column(name = "news_writedate")
    @Temporal(TemporalType.TIMESTAMP)
    private java.time.LocalDateTime newsWritedate;

    @Column(name = "use_acceptance")
    private int useAcceptance;

    @Column(name = "member_code")
    private int memberCode;
}
