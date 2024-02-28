package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FairServiceTest {

    @Autowired
    private FairService fairService;

    static Stream<Arguments> getFairDTO() {

        return Stream.of(
                Arguments.of(new FairDTO("위스키 페어 게시물 등록2", "위스키 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new FairDTO("맥주 페어 게시물 등록3", "맥주 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1)),
                Arguments.of(new FairDTO("와인 페어 게시물 등록4", "와인 페어 게시물을 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    @DisplayName("T1 - 페어 정보 게시글 등록")
    @ParameterizedTest
    @MethodSource("getFairDTO")
//    @Transactional
    void registFairPostTest(FairDTO fairInfo) {

        Assertions.assertDoesNotThrow(
                () -> fairService.registFairPost(fairInfo)
        );
    }
}