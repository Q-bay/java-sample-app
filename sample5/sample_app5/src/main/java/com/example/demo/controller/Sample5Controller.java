package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sample5")
public class Sample5Controller {
		
	/**
	   * 疎通確認用
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getHogeResponsess() {
		System.out.println("0");
		return new ResponseEntity<>("test_sample5", new HttpHeaders(), HttpStatus.OK);
	} 
	
	
}
