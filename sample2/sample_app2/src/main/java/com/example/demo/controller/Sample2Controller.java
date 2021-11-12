package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SampleConfig;
import com.example.demo.domain.CheckDbPerformanceResponse;
import com.example.demo.domain.CheckDbPerformanceResponse2;
import com.example.demo.domain.HogeResponse;
import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.CheckSelectPerformanceOutput2;
import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.service.HogeService;
import com.example.demo.service.HogeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample2")
public class Sample2Controller {

	@Autowired
	HogeService hogeService;
	
	@Autowired
	SampleConfig sampleConfig;
		
	@GetMapping
	public ResponseEntity<HogeResponse> getHogeResponsess() {
		System.out.println("0");
		HogeResponse hogeResponse = new HogeResponse();
		List<HogeEntity> hogeEntityList = new ArrayList<>();
		hogeResponse.setHogeList(hogeEntityList);
		return new ResponseEntity<>(hogeResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	
	@GetMapping("/db_get")
	public ResponseEntity<CheckDbPerformanceResponse> checkDbPerformance() {
		CheckDbPerformanceResponse checkDbPerformanceResponse = new CheckDbPerformanceResponse();
		CheckSelectPerformanceOutput checkSelectPerformanceOutput = hogeService.checkSelectPerformance();
		checkDbPerformanceResponse.setHogeEntityList(checkSelectPerformanceOutput.getHogeEntityList());
		checkDbPerformanceResponse.setBuildingEntityList(checkSelectPerformanceOutput.getBuildingEntityList());
		checkDbPerformanceResponse.setRoomEntityList(checkSelectPerformanceOutput.getRoomEntityList());
		return new ResponseEntity<>(checkDbPerformanceResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@GetMapping("/db_get2")
	public ResponseEntity<CheckDbPerformanceResponse> checkDbPerformance2() throws InterruptedException, ExecutionException {
		CheckDbPerformanceResponse checkDbPerformanceResponse = new CheckDbPerformanceResponse();
		CheckSelectPerformanceOutput checkSelectPerformanceOutput = hogeService.checkSelectAsyncPerformance();
		checkDbPerformanceResponse.setHogeEntityList(checkSelectPerformanceOutput.getHogeEntityList());
		checkDbPerformanceResponse.setBuildingEntityList(checkSelectPerformanceOutput.getBuildingEntityList());
		checkDbPerformanceResponse.setRoomEntityList(checkSelectPerformanceOutput.getRoomEntityList());
		return new ResponseEntity<>(checkDbPerformanceResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@GetMapping("/db_get3")
	public ResponseEntity<CheckDbPerformanceResponse2> checkDbPerformance3() throws InterruptedException, ExecutionException {
		CheckDbPerformanceResponse2 checkDbPerformanceResponse2 = new CheckDbPerformanceResponse2();
		CheckSelectPerformanceOutput2 checkSelectPerformanceOutput2 = hogeService.checkSelectPerformance2();
		checkDbPerformanceResponse2.setBuildingEntityList(checkSelectPerformanceOutput2.getBuildingEntityList());
		return new ResponseEntity<>(checkDbPerformanceResponse2, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/db_get4")
	public ResponseEntity<CheckDbPerformanceResponse2> checkDbPerformance4() throws InterruptedException, ExecutionException {
		CheckDbPerformanceResponse2 checkDbPerformanceResponse2 = new CheckDbPerformanceResponse2();
		System.out.println("unko1");
		CheckSelectPerformanceOutput2 checkSelectPerformanceOutput2 = hogeService.checkSelectPerformance3();
		System.out.println("unko2");
		checkDbPerformanceResponse2.setBuildingEntityList(checkSelectPerformanceOutput2.getBuildingEntityList());
		return new ResponseEntity<>(checkDbPerformanceResponse2, new HttpHeaders(), HttpStatus.OK);
	}

}
