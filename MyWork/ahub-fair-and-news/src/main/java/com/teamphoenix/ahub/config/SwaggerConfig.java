package com.teamphoenix.ahub.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/* 설명. http://localhost:11110/swagger-ui/index.html */
@OpenAPIDefinition(
        info = @Info(title = "Project API 명세서",
                description = "Ahub API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}
