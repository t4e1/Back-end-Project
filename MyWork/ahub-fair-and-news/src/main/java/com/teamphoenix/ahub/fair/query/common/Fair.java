package com.teamphoenix.ahub.fair.query.common;

import java.time.LocalDateTime;

public class Fair {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private LocalDateTime fairWritedate;
    private int memberCode;

    public Fair() {
    }

    public Fair(int fairId) {
        this.fairId = fairId;
    }

    public Fair(int fairId, String fairTitle, String fairContent, LocalDateTime fairWritedate, int memberCode) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.memberCode = memberCode;
    }

    public int getFairId() {
        return fairId;
    }

    public String getFairTitle() {
        return fairTitle;
    }

    public String getFairContent() {
        return fairContent;
    }

    public LocalDateTime getFairWritedate() {
        return fairWritedate;
    }

    public int getMemberCode() {
        return memberCode;
    }

    @Override
    public String toString() {
        return "Fair{" +
                "fairId=" + fairId +
                ", fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairWritedate=" + fairWritedate +
                ", memberCode=" + memberCode +
                '}';
    }
}
