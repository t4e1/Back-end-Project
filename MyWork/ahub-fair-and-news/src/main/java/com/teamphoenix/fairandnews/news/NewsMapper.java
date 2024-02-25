package com.teamphoenix.fairandnews.news;

import com.teamphoenix.fairandnews.news.common.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    NewsDTO getNewsPost(int postNum);
}
