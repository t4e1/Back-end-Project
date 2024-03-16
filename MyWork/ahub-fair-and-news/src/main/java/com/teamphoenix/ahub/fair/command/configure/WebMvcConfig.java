package com.teamphoenix.ahub.fair.command.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final BearerTokenInterceptor bearerTokenInterceptor;

    @Autowired
    public WebMvcConfig(BearerTokenInterceptor bearerTokenInterceptor) {
        this.bearerTokenInterceptor = bearerTokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bearerTokenInterceptor)
<<<<<<< HEAD
                .addPathPatterns("/fairs/new")
                .addPathPatterns("/news/new");
=======
                .addPathPatterns("/fairs/new");
>>>>>>> 899d144edbf7259f98b26faf7980e774ce8ba659
    }
}
