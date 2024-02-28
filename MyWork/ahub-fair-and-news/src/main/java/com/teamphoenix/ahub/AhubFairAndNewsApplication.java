package com.teamphoenix.ahub;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AhubFairAndNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhubFairAndNewsApplication.class, args);
    }

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
