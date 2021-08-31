package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.response.HogeResponse;

@RestController
@RequestMapping("/v1/users")
public class Sample1Controller {
	
	@GetMapping
	public ResponseEntity<HogeResponse> getHoge(){
		
		HogeResponse hoge = new HogeResponse();
		hoge.setId(1);
		hoge.setName("hoge");
		
		return new ResponseEntity<>(hoge, new HttpHeaders(), HttpStatus.OK);
		
	}
}
