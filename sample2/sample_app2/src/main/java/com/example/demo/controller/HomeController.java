package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SampleConfig;
import com.example.demo.domain.HogeResponse;
import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.service.HogeService;
import com.example.demo.service.HogeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/a")
public class HomeController {

	@Autowired
	HogeService hogeService;
	
	@Autowired
	SampleConfig sampleConfig;
	
//	@GetMapping("/home")
//	public String getHome(Model model, @AuthenticationPrincipal User user) {
//		
//		log.info("HomeController start.");
//		log.info(user.toString());
//		log.info("HomeController end.");
//		return "home";
//	}
	
	@GetMapping
	public ResponseEntity<HogeResponse> getHogeResponsess() {
		System.out.println("0");
		HogeResponse hogeResponse = new HogeResponse();
		List<HogeEntity> hogeEntityList = new ArrayList<>();
		hogeResponse.setHogeList(hogeEntityList);
		return new ResponseEntity<>(hogeResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	
	
	@GetMapping("/get")
	public HogeResponse getHogeResponse() {
		System.out.println("1");
		System.out.println(sampleConfig.getFuga());
		HogeResponse hogeResponse = new HogeResponse();
		HogeOutput hogeOutput = hogeService.getHoge();
		hogeResponse.setHogeList(hogeOutput.getHogeEntityList());
		return hogeResponse;
	} 
}
