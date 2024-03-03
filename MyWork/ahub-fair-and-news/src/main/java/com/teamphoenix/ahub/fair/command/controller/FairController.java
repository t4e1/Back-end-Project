package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController(value = "fairCommandController")
@RequestMapping("/board/fairs")
public class FairController {

    private final FairService fairService;

    @Autowired
    public FairController(FairService fairService) {
        this.fairService = fairService;
    }

    /* 새 게시글 등록 핸들러 메소드 */
    @PostMapping("/new")
    public ResponseEntity<?> addNewPost(@RequestBody FairDTO postInfo) {

        /* 프론트로부터 현재시간, 사용여부, 작성자 코드를 받아오지 않는 경우 백엔드 서버에서 직접 입력 */
        if (postInfo.getFairWritedate() == null) {
            postInfo.setFairWritedate(LocalDateTime.now());
        }
        if (postInfo.getUseAcceptance() == 0) {
            postInfo.setUseAcceptance(1);
        }
        if (postInfo.getMemberCode() == 0) {
            postInfo.setMemberCode(1);
        }

        fairService.registFairPost(postInfo);

        return ResponseEntity
                .created(URI.create("/board/fairs/lists"))
                .build();
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    @PutMapping("/{postNum}")
    public ResponseEntity<?> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody FairDTO modifyInfo) {

        /* 수정할 게시글에서 가져온 작성 시간이 현재 시각과 일치하지 않으면 현재시각으로 변경 */
        if (modifyInfo.getFairWritedate() != LocalDateTime.now())
            modifyInfo.setFairWritedate(LocalDateTime.now());

        fairService.modifyFairPost(postNum, modifyInfo);

        return ResponseEntity
                .created(URI.create("/board/fairs/lists"))      // 게시글 수정 후 전체글 list로 이동
                .build();
    }

    /* 게시글 사용여부 수정 (관리자) */
    
    /* 게시글 삭제 */

}
