package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Hoge;
import com.example.demo.domain.model.response.SampleResponse;
import com.example.demo.domain.service.HogeService;

@RestController
@RequestMapping("/sample4")
public class Sample4Controller {

	@Autowired
	HogeService service;
	
	@GetMapping("/hoges")
	public ResponseEntity<SampleResponse> getHogeResponses() {
		SampleResponse response = new SampleResponse();
		
		List<Hoge> hogeList = new ArrayList<>();
		hogeList.add(new Hoge("1", "hoge1", "explanation1"));
		hogeList.add(new Hoge("2", "hoge2", "explanation2"));
		response.setHogeList(hogeList);
		
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/hoges/db")
	public ResponseEntity<SampleResponse> getHogeFromDBResponses() {
		SampleResponse response = new SampleResponse();
		
		List<Hoge> hogeList = service.getHoge();	
		response.setHogeList(hogeList);
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}
