package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import com.teamphoenix.ahub.fair.command.vo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<?> addNewPost(@RequestBody RegistFairInfo postInfo) {

        FairDTO newPostInfo = transferVOtoDTO(postInfo);

        fairService.registFairPost(newPostInfo);

        return ResponseEntity
                .created(URI.create("/board/fairs/lists"))      // 게시글 등록 후 전체 리스트 반환할 수 있도록 url반환
                .build();
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    /* find 하고 가져온 모든 값들 중 해당하는 값만 수정해서 업데이트 & flush 하기 때문에 동적쿼리 신경 쓸 필요가 없음 */
    @PutMapping("/{postNum}")
    public ResponseEntity<?> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody FairDTO modifyInfo) {

        modifyInfo.setFairWritedate(LocalDateTime.now());

        fairService.modifyFairPost(postNum, modifyInfo);

        return ResponseEntity
                .created(URI.create("/board/fairs/lists"))      // 게시글 수정 후 전체글 list로 이동
                .build();
    }

    /* 게시글 사용여부 수정 (관리자) */
    
    /* 게시글 삭제 */

    /* VO -> DTO 로 만들어 주는 메소드 */
    private FairDTO transferVOtoDTO(RegistFairInfo postInfo) {

        FairDTO newPostInfo = modelMapper.map(postInfo, FairDTO.class);
        newPostInfo.setFairWritedate(LocalDateTime.now());
        newPostInfo.setUseAcceptance(1);
        newPostInfo.setMemberCode(1);

        return newPostInfo;
    }

}
