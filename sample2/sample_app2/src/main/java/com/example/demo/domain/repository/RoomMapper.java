package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.entity.RoomEntity;

@Mapper
public interface RoomMapper {
	public List<RoomEntity> selectRooms();
}
