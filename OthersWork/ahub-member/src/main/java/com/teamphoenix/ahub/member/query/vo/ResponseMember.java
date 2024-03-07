package com.teamphoenix.ahub.member.query.vo;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMember {
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberAddr;
    private String memberPhone;
    private LocalDateTime restrictStartDate;
}

