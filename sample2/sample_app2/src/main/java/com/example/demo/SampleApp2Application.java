package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example")
public class SampleApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleApp2Application.class, args);
	}

}
