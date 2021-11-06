package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.HogeOutput;

public interface HogeService {

	public HogeOutput getHoge();
	
	public CheckSelectPerformanceOutput checkSelectPerformance();
	
}
