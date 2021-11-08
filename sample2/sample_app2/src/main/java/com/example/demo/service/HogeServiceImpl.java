package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.CheckSelectPerformanceOutput2;
import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;
import com.example.demo.domain.repository.HogeMapper;
import com.example.demo.domain.repository.HogeRepository;

@Service
@EnableAsync
public class HogeServiceImpl implements HogeService{

	@Autowired
	HogeMapper hogeMapper;
	
	@Autowired
	HogeRepository hogeRepository; 
	
	public HogeOutput getHoge() {
		return new HogeOutput(hogeMapper.selectHoge());
	}
	
	public CheckSelectPerformanceOutput checkSelectPerformance() {
		System.out.println("checkSelectPerformance");
		long currentMills = System.currentTimeMillis();

		List<HogeEntity> hogeEntityList = hogeMapper.selectHoge();
		List<BuildingEntity> buildingEntityList = hogeMapper.selectBuildings();
		List<RoomEntity> roomEntityList = hogeMapper.selectRooms();
		
		long elapsedTime = System.currentTimeMillis() - currentMills;
		System.out.println("elapsedTime: " + elapsedTime);
		return new CheckSelectPerformanceOutput(hogeEntityList, buildingEntityList, roomEntityList);
	}
	
	public CheckSelectPerformanceOutput checkSelectAsyncPerformance() throws InterruptedException, ExecutionException {
		System.out.println("checkSelectAsyncPerformance");
		long currentMills = System.currentTimeMillis();
		
		CompletableFuture<List<HogeEntity>> hogeEntityList = hogeRepository.selectHoge();
		CompletableFuture<List<BuildingEntity>> buildingEntityList = hogeRepository.selectBuildings(); 
		CompletableFuture<List<RoomEntity>> roomEntityList = hogeRepository.selectRooms();
		
		//　待ち受け
		CompletableFuture.allOf(hogeEntityList, buildingEntityList, roomEntityList).join();
		long elapsedTime = System.currentTimeMillis() - currentMills;
		System.out.println("elapsedTime: " + elapsedTime);
		return new CheckSelectPerformanceOutput(hogeEntityList.get(), buildingEntityList.get(), roomEntityList.get());
	}

	// SQLで条件分岐あり
	@Override
	public CheckSelectPerformanceOutput2 checkSelectPerformance2() {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setBuildingId("100002");
//		System.out.println(buildingEntity.getBuildingName());
		buildingEntity.setBuildingDetail("ohnuki building");
		System.out.println("ppp1");
		List<BuildingEntity> buildingEntityList = hogeMapper.selectBuildings2(buildingEntity);
		System.out.println("ppp2");
		return new CheckSelectPerformanceOutput2(buildingEntityList);
	}

	// 取得した結果からロジックで分岐かける
	@Override
	public CheckSelectPerformanceOutput2 checkSelectPerformance3() {
		
		List<BuildingEntity> buildingEntityList = hogeMapper.selectBuildings();
		// ごにょごにょ
		return new CheckSelectPerformanceOutput2(buildingEntityList);
		
	}
	
	
}
