package com.teamphoenix.ahub.fair.command.vo;

import java.util.Objects;

/* 연습용 VO 클래스도 만들어 보기 */
/* VO 클래스 조건
 * 1. 불변 객체 ( final ) & Setter나 Build 사용 x
 * 2. 유효성 검사 ( validation )
 * 3. 동일성 검사 ( equals & hashCode )
* */
public class FairVO {

    private final String title;
    private final String content;

    public FairVO(String title, String content) {

        validateInputText(title, content);
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FairVO fairVO = (FairVO) o;
        return Objects.equals(title, fairVO.title) && Objects.equals(content, fairVO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }

    /* 유효성 검사를 위한 메소드.
     * 입력받은 값 중 제목이나 내용이 없다면 예외를 반환
    * */
    private void validateInputText(String title, String content) {

        if (title.isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해 주세요.");
        } else if (content.isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해 주세요.");
        }
    }

}
