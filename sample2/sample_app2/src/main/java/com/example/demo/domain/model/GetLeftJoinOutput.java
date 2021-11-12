package com.example.demo.domain.model;

import java.util.List;

import com.example.demo.domain.model.entity.BuildingEntity;
import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.model.entity.JoinedEntity;
import com.example.demo.domain.model.entity.RoomEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLeftJoinOutput {

	private List<JoinedEntity> joinedEntityList;
	
}
