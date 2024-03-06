package com.teamphoenix.ahub.fair.query.dto;

import java.time.LocalDateTime;

public class FairDTO {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private LocalDateTime fairWritedate;
    private int useAcceptance;
    private int memberCode;  // fk로 불러온 회원 코드와 매치

    public FairDTO() {
    }

    /* 테스트 케이스(T2) 작성을 위한 DTO 생성자 추가 */
    public FairDTO(String fairTitle, String fairContent) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
    }

    public FairDTO(int fairId, String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairId = fairId;
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }

    public int getFairId() {
        return fairId;
    }

    public void setFairId(int fairId) {
        this.fairId = fairId;
    }

    public String getFairTitle() {
        return fairTitle;
    }

    public void setFairTitle(String fairTitle) {
        this.fairTitle = fairTitle;
    }

    public String getFairContent() {
        return fairContent;
    }

    public void setFairContent(String fairContent) {
        this.fairContent = fairContent;
    }

    public LocalDateTime getFairWritedate() {
        return fairWritedate;
    }

    public void setFairWritedate(LocalDateTime fairWritedate) {
        this.fairWritedate = fairWritedate;
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

    @Override
    public String toString() {
        return "FairDTO{" +
                "fairId=" + fairId +
                ", fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                ", fairWritedate=" + fairWritedate +
                ", useAcceptance=" + useAcceptance +
                ", memberCode='" + memberCode + '\'' +
                '}';
    }
}