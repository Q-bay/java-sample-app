package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Async;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;

@Mapper
public interface HogeMapper {
	
	public List<HogeEntity> selectHoge();
	
	public List<BuildingEntity> selectBuildings();
	
	public List<RoomEntity> selectRooms();
	
}
