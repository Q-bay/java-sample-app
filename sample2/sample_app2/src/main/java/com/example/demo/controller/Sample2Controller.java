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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SampleConfig;
import com.example.demo.domain.CheckDbPerformanceResponse;
import com.example.demo.domain.CheckDbPerformanceResponse2;
import com.example.demo.domain.HogeResponse;
import com.example.demo.domain.JoinedResponse;
import com.example.demo.domain.PostRequest;
import com.example.demo.domain.PostResponse;
import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.GetInnerJoinOutput;
import com.example.demo.domain.model.GetLeftJoinOutput;
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
		
	/*
	 * 疎通確認用
	 */
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
	
	@GetMapping("/db_left_join")
	public ResponseEntity<JoinedResponse> getLeftJoin() throws InterruptedException, ExecutionException {
		JoinedResponse joinedResponse = new JoinedResponse();
		GetLeftJoinOutput getLeftJoinOutput = hogeService.getLeftJoin();
		joinedResponse.setJoinedEntityList(getLeftJoinOutput.getJoinedEntityList());
		return new ResponseEntity<>(joinedResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@GetMapping("/db_logic_left_join")
	public ResponseEntity<JoinedResponse> getLogicLeftJoin() throws InterruptedException, ExecutionException {
		JoinedResponse joinedResponse = new JoinedResponse();
		GetLeftJoinOutput getLeftJoinOutput = hogeService.logicLeftJoin();
		joinedResponse.setJoinedEntityList(getLeftJoinOutput.getJoinedEntityList());
		return new ResponseEntity<>(joinedResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@GetMapping("/db_logic_inner_join")
	public ResponseEntity<JoinedResponse> getLogicInnerJoin() throws InterruptedException, ExecutionException {
		JoinedResponse joinedResponse = new JoinedResponse();
		GetInnerJoinOutput getInnerJoinOutput = hogeService.logicInnerJoin();
		joinedResponse.setJoinedEntityList(getInnerJoinOutput.getJoinedEntityList());
		return new ResponseEntity<>(joinedResponse, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@PostMapping("/post")
	public ResponseEntity<PostResponse> postSample(
			@RequestBody @Validated PostRequest postRequest, 
			BindingResult bindingResult){

		PostResponse postResponse = new PostResponse();
		
        if (bindingResult.hasErrors()) {
        	List<String> errorList = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
        	postResponse.setMessage(errorList);
        }

		return new ResponseEntity<>(postResponse, new HttpHeaders(), HttpStatus.OK);
		
	}

}
