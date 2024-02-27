package com.teamphoenix.ahub.fair.query;

import com.teamphoenix.ahub.fair.query.common.FairDTO;
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
    private FairService fairService;

    static Stream<Arguments> getPostNum() {

            return Stream.of(
                    Arguments.of(Map.of("fairId", "2")),
                    Arguments.of(Map.of("fairId", "8"))
            );
    }

    static Stream<Arguments> getCategoryInfo() {

        return Stream.of(
                Arguments.of(new FairDTO("2024", null)),
                Arguments.of(new FairDTO(null,"맥주")),
                Arguments.of(new FairDTO("맥주", "맥주"))
        );

    }

    @DisplayName("T1-게시글 선택 시 게시글 번호로 내용 불러오기 테스트")
    @ParameterizedTest
    @MethodSource("getPostNum")
    void findFairPost(Map<String, String> postNum) {
        Assertions.assertDoesNotThrow(
                () -> fairService.getFairPost(postNum)
        );
    }

    @DisplayName("T2-검색창에서 카테고리 조건에 맞는 게시글 검색 후 리스트 반환")
    @ParameterizedTest
    @MethodSource("getCategoryInfo")
    void selectPostByCategory(FairDTO getInfo) {
        Assertions.assertDoesNotThrow(
                () -> fairService.findFairByCondition(getInfo)
        );
    }

}