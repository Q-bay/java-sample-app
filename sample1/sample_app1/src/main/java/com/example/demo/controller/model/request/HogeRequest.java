package com.example.demo.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HogeRequest {

	@JsonProperty
	private String id;
	
	@JsonProperty	
	private String name;

}
