package com.example.demo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.repository.entity.HogeEntity;
import com.example.demo.utils.DynamoDBUtils;

@Repository
public class HogeRepositoryImpl implements HogeRepository{
	
	@Autowired
	HogeEntity hoge;
	
	DynamoDBMapper client = DynamoDBUtils.getDynamoDBClient();
	
	
	public HogeEntity findById(String id) {
		return client.load(HogeEntity.class, id);
	}
	
	public void insert(HogeEntity hoge) {
		client.save(hoge);
	}
	
}
