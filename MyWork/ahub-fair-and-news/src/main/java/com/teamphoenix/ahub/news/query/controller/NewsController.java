package com.teamphoenix.ahub.news.query.controller;

import com.teamphoenix.ahub.news.query.vo.ResponseList;
import com.teamphoenix.ahub.news.query.vo.ResponseSearchList;
import com.teamphoenix.ahub.news.query.vo.ResponseFindPost;
import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import com.teamphoenix.ahub.news.query.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "queryNewsController")
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponseFindPost> findNewsPost(@PathVariable(value = "postId") int postId) {

        NewsDTO newsDTO = newsService.getNewsPost(postId);

        ResponseFindPost result = new ResponseFindPost();
        result.setCode("200, OK");
        result.setMessage("Success to Read [" + postId + "] fair post.");
        result.setUrl("http://localhost:8000/board/news/lists");
        result.setResult(newsDTO);

        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/lists")
    public ResponseEntity<ResponseSearchList> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content,
            @RequestParam(value = "id", required = false) String id) {

        NewsDTO searchInfo = new NewsDTO(title, content, id);

        List<NewsDTO> resultList = newsService.findPostsByCondition(searchInfo);

        List<ResponseList> responseLists = doDTOToList(resultList);

        ResponseSearchList result = new ResponseSearchList();
        result.setCode("200, OK");
        result.setMessage("Success to Read list.");
        result.setUrl("http://localhost:8000/board/news/{postId}");
        result.setResult(responseLists);

        return ResponseEntity
                .ok()
                .body(result);
    }

    private List<ResponseList> doDTOToList(List<NewsDTO> newsList) {
        List<ResponseList> responseLists = new ArrayList<>();
        for (NewsDTO newsDTO : newsList) {
            ResponseList responseList = new ResponseList();
            responseList.setFairId(newsDTO.getNewsId());
            responseList.setFairTitle(newsDTO.getNewsTitle());
            responseList.setFairWritedate(newsDTO.getNewsWritedate());
            responseList.setWriteId(newsDTO.getWriterId());

            responseLists.add(responseList);
        }

        return responseLists;
    }


}