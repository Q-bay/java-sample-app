package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.entity.BuildingEntity;

@Mapper
public interface BuildingMapper {
	
	List<BuildingEntity> selectBuildings();

}
