package com.teamphoenix.ahub.fair.command.vo;



import java.time.LocalDateTime;


public class ResponseMember {

    private int memberCode;
    private String memberId;
    private String memberName;
    private String memberPwd;
    private String memberEmail;
    private String memberAddr;
    private String memberPhone;
    private int blacklistStatus;

    private LocalDateTime restrictStartDate;
    private LocalDateTime restrictEndDate;
    private int loginFailCount;
    private int accessAcceptancce;
    private int withdrawalAcceptance;
    private int memberCategoryId;

    public ResponseMember() {
    }

    public ResponseMember(int memberCode, String memberId, String memberName, String memberPwd, String memberEmail, String memberAddr, String memberPhone, int blacklistStatus, LocalDateTime restrictStartDate, LocalDateTime restrictEndDate, int loginFailCount, int accessAcceptancce, int withdrawalAcceptance, int memberCategoryId) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPwd = memberPwd;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.blacklistStatus = blacklistStatus;
        this.restrictStartDate = restrictStartDate;
        this.restrictEndDate = restrictEndDate;
        this.loginFailCount = loginFailCount;
        this.accessAcceptancce = accessAcceptancce;
        this.withdrawalAcceptance = withdrawalAcceptance;
        this.memberCategoryId = memberCategoryId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberAddr() {
        return memberAddr;
    }

    public void setMemberAddr(String memberAddr) {
        this.memberAddr = memberAddr;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public int getBlacklistStatus() {
        return blacklistStatus;
    }

    public void setBlacklistStatus(int blacklistStatus) {
        this.blacklistStatus = blacklistStatus;
    }

    public LocalDateTime getRestrictStartDate() {
        return restrictStartDate;
    }

    public void setRestrictStartDate(LocalDateTime restrictStartDate) {
        this.restrictStartDate = restrictStartDate;
    }

    public LocalDateTime getRestrictEndDate() {
        return restrictEndDate;
    }

    public void setRestrictEndDate(LocalDateTime restrictEndDate) {
        this.restrictEndDate = restrictEndDate;
    }

    public int getLoginFailCount() {
        return loginFailCount;
    }

    public void setLoginFailCount(int loginFailCount) {
        this.loginFailCount = loginFailCount;
    }

    public int getAccessAcceptancce() {
        return accessAcceptancce;
    }

    public void setAccessAcceptancce(int accessAcceptancce) {
        this.accessAcceptancce = accessAcceptancce;
    }

    public int getWithdrawalAcceptance() {
        return withdrawalAcceptance;
    }

    public void setWithdrawalAcceptance(int withdrawalAcceptance) {
        this.withdrawalAcceptance = withdrawalAcceptance;
    }

    public int getMemberCategoryId() {
        return memberCategoryId;
    }

    public void setMemberCategoryId(int memberCategoryId) {
        this.memberCategoryId = memberCategoryId;
    }

    @Override
    public String toString() {
        return "ResponseMember{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberAddr='" + memberAddr + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", blacklistStatus=" + blacklistStatus +
                ", restrictStartDate=" + restrictStartDate +
                ", restrictEndDate=" + restrictEndDate +
                ", loginFailCount=" + loginFailCount +
                ", accessAcceptancce=" + accessAcceptancce +
                ", withdrawalAcceptance=" + withdrawalAcceptance +
                ", memberCategoryId=" + memberCategoryId +
                '}';
    }
}

