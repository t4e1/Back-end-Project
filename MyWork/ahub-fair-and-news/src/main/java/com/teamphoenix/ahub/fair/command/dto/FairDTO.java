package com.teamphoenix.ahub.fair.command.dto;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FairDTO {

    private int fairId;
    private String fairTitle;
    private String fairContent;
    private java.time.LocalDateTime fairWritedate;
    private int useAcceptance;
    private int memberCode;

    public FairDTO(String fairTitle, String fairContent, LocalDateTime fairWritedate, int useAcceptance, int memberCode) {
        this.fairTitle = fairTitle;
        this.fairContent = fairContent;
        this.fairWritedate = fairWritedate;
        this.useAcceptance = useAcceptance;
        this.memberCode = memberCode;
    }
}
