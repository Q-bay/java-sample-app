package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.RoomEntity;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class CheckDbPerformanceResponse {
	
	private List<HogeEntity> hogeEntityList;
	
	private List<BuildingEntity> buildingEntityList;
	
	private List<RoomEntity> roomEntityList;
}
