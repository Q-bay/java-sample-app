package com.example.demo.domain.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;

@Repository
public class BuildingRepository {

	// 検証用として数秒待機する
	
	@Autowired
	BuildingMapper buildingMapper;
	
	@Async
	public CompletableFuture<List<BuildingEntity>> selectBuildings() throws InterruptedException {
		Thread.sleep(2000);
		return CompletableFuture.completedFuture(buildingMapper.selectBuildings());
	}

}
