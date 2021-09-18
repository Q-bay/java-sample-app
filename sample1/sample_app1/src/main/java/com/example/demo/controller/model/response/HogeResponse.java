package com.example.demo.controller.model.response;

import org.springframework.http.HttpStatus;

import com.example.demo.repository.entity.HogeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HogeResponse {
	
	private HogeEntity hogeEntity;
	
	private HttpStatus statusCode;
	
}
