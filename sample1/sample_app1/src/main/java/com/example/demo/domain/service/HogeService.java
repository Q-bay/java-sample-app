package com.example.demo.service;

import com.example.demo.domain.model.FindHogeInput;
import com.example.demo.domain.model.FindHogeOutput;
import com.example.demo.domain.model.InsertHogeInput;
import com.example.demo.domain.model.InsertHogeOutput;

import lombok.NonNull;

public interface HogeService {
	
	FindHogeOutput findHoge(@NonNull FindHogeInput findHogeInput);
	
	InsertHogeOutput insertHoge(@NonNull InsertHogeInput insertHogeInput);
}
