package com.teamphoenix.fairandnews.news.common;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.fairandnews.news", annotationClass = Mapper.class)
public class NewsConfiguration {
}
