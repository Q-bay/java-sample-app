package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.request.HogeRequest;
import com.example.demo.controller.model.response.HogeResponse;
import com.example.demo.domain.model.FindHogeInput;
import com.example.demo.domain.model.FindHogeOutput;
import com.example.demo.domain.model.InsertHogeInput;
import com.example.demo.domain.model.InsertHogeOutput;
import com.example.demo.domain.service.HogeService;
import com.example.demo.repository.entity.HogeEntity;

@RestController
@RequestMapping("/api/users")
public class Sample1Controller {
	
	@Autowired
	HogeService hogeService;
	
	@GetMapping
	public ResponseEntity<HogeResponse> getHoge(
			@RequestParam(name = "id") String id,
			@RequestParam(name = "name") String name){
		
		if(Objects.isNull(id) || Objects.isNull(name)) {
			return new ResponseEntity<>(this.setHogeResponse(new HogeEntity(), HttpStatus.BAD_REQUEST) , new HttpHeaders(), HttpStatus.OK);
		}
		
		FindHogeInput findHogeInput = new FindHogeInput(id, name);
		
		FindHogeOutput findHogeOutput = hogeService.findHoge(findHogeInput);

		return new ResponseEntity<>(this.setHogeResponse(findHogeOutput.getHogeEntity(), HttpStatus.OK), new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/test")
	public ResponseEntity<HogeResponse> getTest(){
		
		HogeEntity hogeEntity = new HogeEntity("1", "hoge", "fuga");
		
		HogeResponse hogeResponse = new HogeResponse(hogeEntity, HttpStatus.OK);
		
		return new ResponseEntity<>(hogeResponse, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	
	@PostMapping
	public ResponseEntity<HogeResponse> postHoge(
			@RequestBody @Validated HogeRequest hogeRequest,
			BindingResult bindingResult 
			){
		
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		InsertHogeInput insertHogeInput = new InsertHogeInput(
				new HogeEntity(hogeRequest.getId(), hogeRequest.getName(), hogeRequest.getDescription()));
		
		InsertHogeOutput insertHogeOutput = hogeService.insertHoge(insertHogeInput);
		
		return new ResponseEntity<>(this.setHogeResponse(insertHogeOutput.getHogeEntity(), HttpStatus.BAD_REQUEST), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	private HogeResponse setHogeResponse(HogeEntity hogeEntity, HttpStatus statusCode) {
		
		return new HogeResponse(hogeEntity, statusCode);
		
	}
}
