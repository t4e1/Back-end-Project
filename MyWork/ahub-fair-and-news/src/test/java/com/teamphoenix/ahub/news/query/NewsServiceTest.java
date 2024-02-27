package com.teamphoenix.ahub.news.query;

import com.teamphoenix.ahub.news.query.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    static Stream<Arguments> getPostNum() {

        return Stream.of(
                Arguments.of(Map.of("newsId", "2")),
                Arguments.of(Map.of("newsId", "8"))
        );
    }

    @DisplayName("T1-게시글 선택 시 게시글 번호로 내용 불러오기 테스트")
    @ParameterizedTest
    @MethodSource("getPostNum")
    void findFairPost(Map<String, String> postNum) {
        Assertions.assertDoesNotThrow(
                () -> newsService.getNewsPost(postNum)
        );
    }


}