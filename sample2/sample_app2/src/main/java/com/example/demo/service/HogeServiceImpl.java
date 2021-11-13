package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.demo.domain.JoinedResponse;
import com.example.demo.domain.model.CheckSelectPerformanceOutput;
import com.example.demo.domain.model.GetInnerJoinOutput;
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

	// LeftJoinして取得
	@Override
	public GetLeftJoinOutput getLeftJoin() {
		GetLeftJoinOutput getLeftJoinOutput = new GetLeftJoinOutput();
		List<JoinedEntity> joinedEntityList = joinedMapper.selectLeftJoin();
		getLeftJoinOutput.setJoinedEntityList(joinedEntityList);
		return getLeftJoinOutput;
	}

	// joinして取得ではなくロジックで頑張る
	@Override
	public GetLeftJoinOutput logicLeftJoin() {		
		GetLeftJoinOutput getLeftJoinOutput = new GetLeftJoinOutput();
		
		List<HogeEntity> hogeEntityList = hogeMapper.selectHoge();
		List<BuildingEntity> buildingEntityList = buildingMapper.selectBuildings();
		List<RoomEntity> roomEntityList = roomMapper.selectRooms();		
		
		List<JoinedEntity> joinedEntityList = 
				hogeEntityList.stream()
				.map(hogeEntity -> {
					JoinedEntity joinedEntity = new JoinedEntity();
					joinedEntity.setId(hogeEntity.getId());
					joinedEntity.setName(hogeEntity.getName());
					joinedEntity.setExplanation(hogeEntity.getExplanation());
					return joinedEntity;
				})
				.map(joinedEntity -> {
					buildingEntityList.stream()
					.filter(buildingEntity -> joinedEntity.getId().equals(buildingEntity.getId()))
					.peek(buildingEntity -> {
						joinedEntity.setBuildingName(buildingEntity.getBuildingName());
						joinedEntity.setBuildingDetail(buildingEntity.getBuildingDetail());						
					})
					.collect(Collectors.toList());
					return joinedEntity;
				})
				.map(joinedEntity -> {
					roomEntityList.stream()
					.filter(roomEntity -> joinedEntity.getId().equals(roomEntity.getId()))
					.peek(roomEntity -> {
						joinedEntity.setRoomName(roomEntity.getRoomName());
						joinedEntity.setRoomDetail(roomEntity.getRoomDetail());
					})
					.collect(Collectors.toList());
					return joinedEntity;
				})
				.collect(Collectors.toList());
		
			getLeftJoinOutput.setJoinedEntityList(joinedEntityList);
			
			return getLeftJoinOutput;
	}
	

	// joinして取得ではなくロジックで頑張る
	@Override
	public GetInnerJoinOutput logicInnerJoin() {		
		GetInnerJoinOutput getInnerJoinOutput = new GetInnerJoinOutput();
		
		List<HogeEntity> hogeEntityList = hogeMapper.selectHoge();
		List<BuildingEntity> buildingEntityList = buildingMapper.selectBuildings();
		List<RoomEntity> roomEntityList = roomMapper.selectRooms();		
				
		List<JoinedEntity> joinedEntityList = 
				hogeEntityList.stream()
				.map(hogeEntity -> {
					JoinedEntity joinedEntity = new JoinedEntity();
					joinedEntity.setId(hogeEntity.getId());
					joinedEntity.setName(hogeEntity.getName());
					joinedEntity.setExplanation(hogeEntity.getExplanation());
					return joinedEntity;
				})
				.map(joinedEntity -> {
					buildingEntityList.stream()
					.filter(buildingEntity -> joinedEntity.getId().equals(buildingEntity.getId()))
					.peek(buildingEntity -> {
						joinedEntity.setBuildingName(buildingEntity.getBuildingName());
						joinedEntity.setBuildingDetail(buildingEntity.getBuildingDetail());						
					})
					.collect(Collectors.toList());
					return joinedEntity;
				})
				.filter(joinedEntity -> !Objects.isNull(joinedEntity.getBuildingName()))
				.map(joinedEntity -> {
					roomEntityList.stream()
					.filter(roomEntity -> joinedEntity.getId().equals(roomEntity.getId()))
					.peek(roomEntity -> {
						joinedEntity.setRoomName(roomEntity.getRoomName());
						joinedEntity.setRoomDetail(roomEntity.getRoomDetail());
					})
					.collect(Collectors.toList());
					return joinedEntity;
				})
				.filter(joinedEntity -> !Objects.isNull(joinedEntity.getRoomName()))
				.collect(Collectors.toList());
			
		
			getInnerJoinOutput.setJoinedEntityList(joinedEntityList);
			
			return getInnerJoinOutput;
	}
}
