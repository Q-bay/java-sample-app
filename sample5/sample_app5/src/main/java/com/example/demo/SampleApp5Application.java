package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.domain.repository")
public class SampleApp5Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleApp5Application.class, args);
	}

}
