package com.teamphoenix.ahub.news.query;

import com.teamphoenix.ahub.news.query.common.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    NewsDTO getNewsPost(int postNum);
}
