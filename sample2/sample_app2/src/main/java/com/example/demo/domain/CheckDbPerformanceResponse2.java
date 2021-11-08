package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.model.entity.BuildingEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckDbPerformanceResponse2 {
	
	private List<BuildingEntity> buildingEntityList;

}
