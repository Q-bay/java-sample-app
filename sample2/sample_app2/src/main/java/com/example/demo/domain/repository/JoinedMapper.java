package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.JoinedEntity;

@Mapper
public interface JoinedMapper {
	
	public List<JoinedEntity> selectLeftJoin();

}
