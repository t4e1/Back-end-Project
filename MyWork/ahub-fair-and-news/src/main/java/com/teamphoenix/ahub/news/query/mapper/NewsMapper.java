package com.teamphoenix.ahub.news.query.mapper;

import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    NewsDTO getNewsPost(int postNum);
}