package com.example.demo.service;

import com.example.demo.domain.model.FindHogeInput;
import com.example.demo.domain.model.FindHogeOutput;
import com.example.demo.domain.model.InsertHogeInput;
import com.example.demo.domain.model.InsertHogeOutput;

import lombok.NonNull;

public class HogeServiceImpl implements HogeService {
	
	@Override
	public FindHogeOutput findHoge(@NonNull FindHogeInput findHogeInput) {
		
		FindHogeOutput findHogeOutput = new FindHogeOutput(); 
		
		return findHogeOutput;
	};
	
	@Override
	public InsertHogeOutput insertHoge(@NonNull InsertHogeInput insertHogeInput) {
		
		InsertHogeOutput insertHogeOutput = new InsertHogeOutput();
		
		return insertHogeOutput;
	};
}
