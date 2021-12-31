package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.domain.repository")
public class SampleApp4Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleApp4Application.class, args);
	}

}
