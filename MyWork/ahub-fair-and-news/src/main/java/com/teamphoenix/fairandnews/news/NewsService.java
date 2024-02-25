package com.teamphoenix.fairandnews.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsMapper newsMapper;

    @Autowired
    public NewsService(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    

}
