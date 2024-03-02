package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
