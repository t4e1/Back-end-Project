package com.teamphoenix.ahub.fair.query.controller;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import com.teamphoenix.ahub.fair.query.service.FairService;
import com.teamphoenix.ahub.fair.query.vo.ResponseFairPost;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController(value = "queryFairController")
@RequestMapping("/board/fairs")
@Log4j2
public class FairController {

    private final FairService fairService;

    @Autowired
    public FairController(FairService fairService) {
        this.fairService = fairService;
    }

    /* 게시글을 클릭하면 내용을 호출하는 핸들러 메소드 */
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseFairPost> findFairPost(@PathVariable(value = "postId") int postId) {

        FairDTO fairDTO = fairService.getFairPost(postId);


        ResponseFairPost responseFairPost = new ResponseFairPost(
                fairDTO.getFairId(),
                fairDTO.getFairTitle(),
                fairDTO.getFairContent(),
                fairDTO.getFairWritedate(),
                fairDTO.getUseAcceptance(),
                fairDTO.getMemberCode()
        );

        return ResponseEntity
                .ok()
                .body(responseFairPost);

        // update url 포함시키기
    }

//    @GetMapping("/lists")
//    public ResponseEntity<List<FairDTO>> getAllPosts() {
//
//        return ResponseEntity
//                .ok()
//                .body(fairService.getAllPosts());
//    }

    /* 게시글 전체 리스트&검색어를 파라미터로 던질 시 해당 검색어에 해당하는 리스트를 반환하는 핸들러 메소드 */
    @GetMapping("/lists")
    public ResponseEntity<List<FairDTO>> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content) {

        FairDTO searchInfo = new FairDTO(title, content);
        List<FairDTO> resultList = fairService.findPostsByCondition(searchInfo);

        return ResponseEntity
                .ok()
                .body(resultList);
    }
}
