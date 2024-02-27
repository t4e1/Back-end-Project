package com.teamphoenix.ahub.fair.query.common;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub.fair.query", annotationClass = Mapper.class )
public class FairConfiguration {
}
