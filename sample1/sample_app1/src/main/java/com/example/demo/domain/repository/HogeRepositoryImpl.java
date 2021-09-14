package com.example.demo.domain.repository;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.repository.entity.HogeEntity;
import com.example.demo.utils.DynamoDBUtils;

@Repository
public class HogeRepositoryImpl implements HogeRepository{
		
	DynamoDBMapper client = DynamoDBUtils.getDynamoDBClient();
	
	public HogeEntity findById(String id) {
		return client.load(HogeEntity.class, id);
	}
	
	public HogeEntity insert(HogeEntity hoge) {
		client.save(hoge);
		return client.load(HogeEntity.class, hoge.getId());
	}
	
}
