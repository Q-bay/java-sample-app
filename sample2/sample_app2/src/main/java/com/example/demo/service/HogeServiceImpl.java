package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;
import com.example.demo.domain.repository.HogeMapper;

@Service
public class HogeServiceImpl implements HogeService{

	@Autowired
	HogeMapper hogeMapper;
	
	public HogeOutput getHoge() {
		System.out.println("2222222222222222");
		return new HogeOutput(hogeMapper.selectHoge());
	}
	
	public CheckSelectPerformanceOutput checkSelectPerformance() {
		long currentMills = System.currentTimeMillis();
		List<HogeEntity> hogeEntityList = hogeMapper.selectHoge();
		List<BuildingEntity> buildingEntityList = hogeMapper.selectBuildings();
		List<RoomEntity> roomEntityList = hogeMapper.selectRooms();
		long elapsedTime = System.currentTimeMillis() - currentMills;
		System.out.println("elapsedTime: " + elapsedTime);
		return new CheckSelectPerformanceOutput(hogeEntityList, buildingEntityList, roomEntityList);
	}
}
