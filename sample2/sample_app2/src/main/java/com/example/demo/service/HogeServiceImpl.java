package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.GetLeftJoinOutput;
import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.JoinedEntity;
import com.example.demo.domain.model.entity.RoomEntity;
import com.example.demo.domain.repository.BuildingMapper;
import com.example.demo.domain.repository.BuildingRepository;
import com.example.demo.domain.repository.HogeMapper;
import com.example.demo.domain.repository.HogeRepository;
import com.example.demo.domain.repository.JoinedMapper;
import com.example.demo.domain.repository.RoomMapper;
import com.example.demo.domain.repository.RoomRepository;

@Service
@EnableAsync
public class HogeServiceImpl implements HogeService{

	@Autowired
	HogeMapper hogeMapper;
	
	@Autowired
	BuildingMapper buildingMapper;
	
	@Autowired
	RoomMapper roomMapper;
	
	@Autowired
	JoinedMapper joinedMapper; 

	@Autowired
	HogeRepository hogeRepository; 
		
	@Autowired
	BuildingRepository buildingRepository; 
	
	@Autowired
	RoomRepository roomRepository; 
	
	public HogeOutput getHoge() {
		return new HogeOutput(hogeMapper.selectHoge());
	}
	
	public CheckSelectPerformanceOutput checkSelectPerformance() {
		System.out.println("checkSelectPerformance");
		long currentMills = System.currentTimeMillis();

		List<HogeEntity> hogeEntityList = hogeMapper.selectHoge();
		List<BuildingEntity> buildingEntityList = buildingMapper.selectBuildings();
		List<RoomEntity> roomEntityList = roomMapper.selectRooms();
		
		long elapsedTime = System.currentTimeMillis() - currentMills;
		System.out.println("elapsedTime: " + elapsedTime);
		return new CheckSelectPerformanceOutput(hogeEntityList, buildingEntityList, roomEntityList);
	}
	
	public CheckSelectPerformanceOutput checkSelectAsyncPerformance() throws InterruptedException, ExecutionException {
		System.out.println("checkSelectAsyncPerformance");
		long currentMills = System.currentTimeMillis();
		
		CompletableFuture<List<HogeEntity>> hogeEntityList = hogeRepository.selectHoge();
		CompletableFuture<List<BuildingEntity>> buildingEntityList = buildingRepository.selectBuildings(); 
		CompletableFuture<List<RoomEntity>> roomEntityList = roomRepository.selectRooms();
		
		//　待ち受け
		CompletableFuture.allOf(hogeEntityList, buildingEntityList, roomEntityList).join();
		long elapsedTime = System.currentTimeMillis() - currentMills;
		System.out.println("elapsedTime: " + elapsedTime);
		return new CheckSelectPerformanceOutput(hogeEntityList.get(), buildingEntityList.get(), roomEntityList.get());
	}

	// joinして取得
	@Override
	public GetLeftJoinOutput getLeftJoin() {
		GetLeftJoinOutput getLeftJoinOutput = new GetLeftJoinOutput();
		List<JoinedEntity> joinedEntityList = joinedMapper.selectLeftJoin();
		getLeftJoinOutput.setJoinedEntityList(joinedEntityList);
		return getLeftJoinOutput;
	}
//
//	// LIMIT
//	@Override
//	public CheckSelectPerformanceOutput2 checkSelectPerformance3() {		
//		
//	}
	
	
}
