package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import com.teamphoenix.ahub.fair.command.vo.RequestRegist;
import com.teamphoenix.ahub.fair.command.vo.ResponseStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController(value = "fairCommandController")
@RequestMapping("/fairs")
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
    public ResponseEntity<ResponseStatus> addNewPost(@RequestBody RequestRegist postInfo) {

        FairDTO newFairPost = modelMapper.map(postInfo, FairDTO.class);
        newFairPost.setFairWritedate(LocalDateTime.now());
        newFairPost.setUseAcceptance(1);
        newFairPost.setMemberCode(1); // 차후 토큰을 통해 userCode를 받아오는 것도 필요하다.

        FairDTO result = fairService.registFairPost(newFairPost);

        ResponseStatus respMessage = createResponseStatus("201, CREATED"
                ,"Success to add new post."
                ,"http://localhost:8000/board/fairs/lists"
                ,result );

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    @PutMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody FairDTO modifyInfo) {

        modifyInfo.setFairWritedate(LocalDateTime.now());

        FairDTO result = fairService.modifyFairPost(postNum, modifyInfo);

        ResponseStatus respMessage = createResponseStatus("200, OK"
                ,"Success to update [ " + postNum + " ] fair post."
                ,"http://localhost:8000/board/fairs/lists"
                ,result );

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }

    /* 게시글 삭제 */
    @DeleteMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> removeFairPost(@PathVariable("postNum") int postNum) {

        fairService.removeFairPost(postNum);

        ResponseStatus respMessage = createResponseStatus("200, OK"
                ,"Success to delete [ " + postNum + " ] fair post."
                ,"http://localhost:8000/board/fairs/lists"
                ,null );

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }

    private ResponseStatus createResponseStatus(String httpStatus, String message, String url, FairDTO result) {
        return new ResponseStatus(httpStatus.toString(), message, url, result);
    }
}
