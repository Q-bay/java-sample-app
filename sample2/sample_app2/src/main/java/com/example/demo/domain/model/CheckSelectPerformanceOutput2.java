package com.example.demo.domain.model;

import java.util.List;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckSelectPerformanceOutput2 {

	private List<BuildingEntity> buildingEntityList;
	
}
