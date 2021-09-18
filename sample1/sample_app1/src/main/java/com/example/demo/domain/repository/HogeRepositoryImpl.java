package com.example.demo.domain.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.repository.entity.HogeEntity;
import com.example.demo.utils.DynamoDBUtils;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;


@Repository
public class HogeRepositoryImpl implements HogeRepository{
	
	@Autowired
	DynamoDBUtils dynamoDBUtils;
		
	DynamoDBMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = dynamoDBUtils.getDynamoDBMapper();
	}
	
	public HogeEntity findById(String id, String name) {
		
		String hashKey = id;
		String rangeKey = name;
		return mapper.load(HogeEntity.class, hashKey, rangeKey);
	}
	
	public void insert(HogeEntity hogeEntity) {
		mapper.save(hogeEntity);
	}
	
}
