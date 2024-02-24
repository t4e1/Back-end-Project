package com.teamphoenix.fairandnews.fair.common;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.fairandnews.fair", annotationClass = Mapper.class )
public class FairConfiguration {
}
