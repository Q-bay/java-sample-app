package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.entity.HogeEntity;

@Mapper
public interface HogeMapper {
	
	public List<HogeEntity> selectHoge();
	
}
