package com.teamphoenix.ahub.fair.command.vo;

import java.time.LocalDate;
import java.util.List;

//ResponseStatus로 화면에 반환할 값들을 모아둔 VO클래스
public class ResponsePost {

    private String fairTitle;
    private String fairContent;
    private String fairWriteDate;
    private String fairTag1;
    private String fairTag2;
    private String fairTag3;
    private LocalDate fairStartdate;
    private LocalDate faireEnddate;
    private String fairLocation;
    private String fairWriterId;
    private String thumPictureUrl;
    private List<String> contentPictures;

    public ResponsePost() {
    }

    public ResponsePost(String fairTitle, String fairContent, String fairWriteDate,
                        String fairTag1, String fairTag2, String fairTag3, LocalDate fairStartdate,
                        LocalDate faireEnddate, String fairLocation, String fairWriterId,
                        String thumPictureUrl, List<String> contentPictures) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWriteDate = fairWriteDate;
        this.fairTag1 = fairTag1;
        this.fairTag2 = fairTag2;
        this.fairTag3 = fairTag3;
        this.fairStartdate = fairStartdate;
        this.faireEnddate = faireEnddate;
        this.fairLocation = fairLocation;
        this.fairWriterId = fairWriterId;
        this.thumPictureUrl = thumPictureUrl;
        this.contentPictures = contentPictures;
    }
}
