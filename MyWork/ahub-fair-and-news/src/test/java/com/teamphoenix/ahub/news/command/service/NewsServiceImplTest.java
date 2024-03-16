package com.teamphoenix.ahub.news.command.service;

import com.teamphoenix.ahub.news.command.dto.NewsDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;


@SpringBootTest
class NewsServiceImplTest {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    static Stream<Arguments> getFairDTO() {

        return Stream.of(
                Arguments.of(new NewsDTO("뉴스 게시물 등록", "뉴스 게시물 등록합니다.", LocalDateTime.now(), 1, 1))
        );
    }

    static Stream<Arguments> getModifyInfo() {

        return Stream.of(
                Arguments.of(8, new NewsDTO(8,"뉴스 게시물 수정", "뉴스 게시물 수정합니다 ", LocalDateTime.now(), 1, 1))
        );
    }

    @DisplayName("T1 - 뉴스 게시글 등록")
    @ParameterizedTest
    @MethodSource("getFairDTO")
    @Transactional
    void registNewsPostTest(NewsDTO newsInfo) {

        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.registNewsPost(newsInfo)
        );
    }

    @DisplayName("T2 - 뉴스 게시글 수정")
    @ParameterizedTest
    @MethodSource("getModifyInfo")
    @Transactional
    void modifyFairPostTest(int postNum, NewsDTO modifyInfo) {

        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.modifyNewsPost(postNum, modifyInfo)
        );
    }

    @DisplayName("T3 - 뉴스 게시글 삭제")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 8})
    @Transactional
    void deleteFairPostTest(int postNum) {
        Assertions.assertDoesNotThrow(
                () -> newsServiceImpl.removeNewsPost(postNum)
        );

    }
}