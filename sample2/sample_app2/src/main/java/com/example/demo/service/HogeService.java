package com.example.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.GetInnerJoinOutput;
import com.example.demo.domain.model.GetLeftJoinOutput;
import com.example.demo.domain.model.HogeOutput;

public interface HogeService {

	HogeOutput getHoge();
	
	CheckSelectPerformanceOutput checkSelectPerformance();
	
	CheckSelectPerformanceOutput checkSelectAsyncPerformance() throws InterruptedException, ExecutionException;

	GetLeftJoinOutput getLeftJoin();

	GetLeftJoinOutput logicLeftJoin();

	GetInnerJoinOutput logicInnerJoin();
	
}
