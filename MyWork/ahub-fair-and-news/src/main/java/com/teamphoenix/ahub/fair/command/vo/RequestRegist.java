package com.teamphoenix.ahub.fair.command.vo;

/* 연습용 VO 클래스도 만들어 보기 */
/* VO 클래스 조건
 * 1. 불변 객체 ( final ) & Setter나 Build 사용 x
 * 2. 유효성 검사 ( validation )
 * 3. 동일성 검사 ( equals & hashCode )
* */
/* VO 패키지 안에는 프론트로부터 데이터를 받을 클래스나, 화면의 재료가 될 데이터들을 취합하는 클래스들이 들어간다. */
/* 이 패키지의 VO는 불변 객체나 그런 개념을 그렇게 중요시 하지 않는다. aggregate 패키지의 vo클래스에서 중시할 것 */
public class RequestRegist {

    private String fairTitle;
    private String fairContent;

    public RequestRegist() {
    }

    public RequestRegist(String fairTitle, String fairContent) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
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

    @Override
    public String toString() {
        return "RegistFairInfo{" +
                "fairTitle='" + fairTitle + '\'' +
                ", fairContent='" + fairContent + '\'' +
                '}';
    }
}
