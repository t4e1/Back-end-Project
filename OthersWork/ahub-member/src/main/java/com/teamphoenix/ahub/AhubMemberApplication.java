package com.teamphoenix.ahub;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Key;
import java.util.Base64;

@EnableDiscoveryClient
@SpringBootApplication
public class AhubMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhubMemberApplication.class, args);

//		// Secret Key 생성
//		Key secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
//
//		// 생성된 Secret Key 출력
//		System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
