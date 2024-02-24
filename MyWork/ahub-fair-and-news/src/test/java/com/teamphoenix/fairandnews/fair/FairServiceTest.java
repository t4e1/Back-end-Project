package com.teamphoenix.fairandnews.fair;

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
class FairServiceTest {

    @Autowired
    private FairService findFairService;

    static Stream<Arguments> getPostNum() {
            return Stream.of(
                    Arguments.of(Map.of("fairId", "1")),
                    Arguments.of(Map.of("fairId", "5"))
            );
    }

    @DisplayName("게시글 선택 시 게시글 번호로 내용 불러오기 테스트")
    @ParameterizedTest
    @MethodSource("getPostNum")
    void findFairPost(Map<String, String> postNum) {
        Assertions.assertDoesNotThrow(
                () -> findFairService.getFairPost(postNum)
        );
    }

}