package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import com.teamphoenix.ahub.fair.command.vo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController(value = "fairCommandController")
@RequestMapping("/board/fairs")
//@RequestMapping("/") Spring Cloud Gateway  // 필터 설정 시 활성화 할 것
public class FairController {

    private final FairService fairService;
    private final ModelMapper modelMapper;

    @Autowired
    public FairController(FairService fairService, ModelMapper modelMapper) {
        this.fairService = fairService;
        this.modelMapper = modelMapper;
    }

    /* 새 게시글 등록 핸들러 메소드 */
    @PostMapping("/new")
    public ResponseEntity<ResponseUrlMessage> addNewPost(@RequestBody RegistFairInfo postInfo) {


        FairDTO newFairPost = modelMapper.map(postInfo, FairDTO.class);
        fairService.registFairPost(newFairPost);

        ResponseUrlMessage respMessage = new ResponseUrlMessage();
        respMessage.setMessage("post-list");
        respMessage.setUrl("/board/fairs/lists");

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);   // 게시글 등록 후 전체 리스트 반환할 수 있도록 url반환
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    /* find 하고 가져온 모든 값들 중 해당하는 값만 수정해서 업데이트 & flush 하기 때문에 동적쿼리 신경 쓸 필요가 없음 */
    /* 게시글이 열린 상태에서 수정 버튼을 눌러서 수정을 할 것이기 때문에 화면의 모든 정보를 가져올 수 있다 = FairDTO 그대로 임 */
    @PutMapping("/{postNum}")
    public ResponseEntity<ResponseUrlMessage> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody FairDTO modifyInfo) {

        /* 수정을 하면 작성일(최종 수정일)을 서버 기준으로 변경해서 DTO에 담기 */
        modifyInfo.setFairWritedate(LocalDateTime.now());

        fairService.modifyFairPost(postNum, modifyInfo);

        /* 연결될 url을 과 해당 url에 대한 설명을 포함한 VO클래스 */
        ResponseUrlMessage respMessage = new ResponseUrlMessage();
        respMessage.setMessage("post-list");
        respMessage.setUrl("/board/fairs/lists");

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);

    }
        /* 게시글 사용여부 수정 (관리자) */

    /* 게시글 삭제 */
    @DeleteMapping("/{postNum}")
    public ResponseEntity<ResponseUrlMessage> removeFairPost(@PathVariable("postNum") int postNum) {

        fairService.removeFairPost(postNum);

        ResponseUrlMessage respMessage = new ResponseUrlMessage();
        respMessage.setMessage("post-list");
        respMessage.setUrl("/board/fairs/lists");
        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }
//    /* VO -> DTO 로 만들면서 미입력 정보 넣어도 넣어주는 메소드 */
//    public FairDTO transferVOtoDTO (RegistFairInfo postInfo) {
//
//        FairDTO newPostInfo = modelMapper.map(postInfo, FairDTO.class);
//
//        newPostInfo.setFairWritedate(LocalDateTime.now());
//        newPostInfo.setUseAcceptance(1);
//        newPostInfo.setMemberCode(1);
//
//        return newPostInfo;
//    }
}
