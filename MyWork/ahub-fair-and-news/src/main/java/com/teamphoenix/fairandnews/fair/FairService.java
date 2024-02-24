package com.teamphoenix.fairandnews.fair;

import com.teamphoenix.fairandnews.fair.common.Fair;
import com.teamphoenix.fairandnews.fair.common.FairDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FairService {

    private final FairMapper fairMapper;

    @Autowired
    public FairService(FairMapper fairMapper) {
        this.fairMapper = fairMapper;
    }

    /* 사용자가 웹 브라우저에서 행사 정보 게시글을 클릭했을 때,
     * 해당 게시글의 게시글 번호(fair_id)를 조건으로
     * 게시글 번호, 제목, 내용, 작성일, 작성자 를 조회해 오는 메소드
    * */
    public FairDTO getFairPost(Map<String, String> fairId) {

        int postNum = Integer.valueOf(fairId.get("fairId"));
        // fairId 의 밸류가 넘어와서 getPostNum 에 저장됨
        FairDTO result = fairMapper.getFairPost(postNum);
        System.out.println("result = " + result);

        return result;
    }

    /* 사용자가 웹 브라우저의 정보 게시판 화면에서,
     * 검색창 옆의 카테고리를 선택(제목, 내용, 제목+내용, 작성자)하고 검색어를 입력,
     * 해당하는 카테고리와 검색어를 포함하는 게시물 리스트를 뽑아주는 메소드
    * */
    public List<FairDTO> findPostBySearchCategory(FairDTO searchInfo) {


        List<FairDTO> result = fairMapper.selectPostsBySearchCategory(searchInfo);

        result.forEach(System.out::println);


        return result;
    }
}
