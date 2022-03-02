package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HogeService;


@RestController
@RequestMapping("/sample5")
public class Sample5Controller {
		
	@Autowired
	HogeService hogeService;
	
	/**
	   * 疎通確認用
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getHogeResponsess() {
		
		return new ResponseEntity<>(hogeService.getHoges(), new HttpHeaders(), HttpStatus.OK);
	} 
	
	
}
