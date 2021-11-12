package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.model.entity.JoinedEntity;

import lombok.Data;

@Data
public class JoinedResponse {

	private List<JoinedEntity> joinedEntityList;
}
