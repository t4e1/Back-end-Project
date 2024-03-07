package com.teamphoenix.ahub.member.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub", annotationClass = Mapper.class)
public class MemberConfiguration {
}
