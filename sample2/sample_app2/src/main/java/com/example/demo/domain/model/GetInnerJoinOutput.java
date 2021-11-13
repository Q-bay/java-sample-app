package com.example.demo.domain.model;

import java.util.List;

import com.example.demo.domain.model.entity.JoinedEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInnerJoinOutput {
	
	private List<JoinedEntity> joinedEntityList;

}
