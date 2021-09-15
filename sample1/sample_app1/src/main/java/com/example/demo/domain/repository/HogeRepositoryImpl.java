package com.example.demo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	DynamoDbEnhancedClient dynamoDbEnhancedClient = dynamoDBUtils.getDynamoDBClient();
	
	private final DynamoDbTable<HogeEntity> hogeTable 
		= dynamoDbEnhancedClient.table("hoge", TableSchema.fromBean(HogeEntity.class));
	
	public HogeEntity findById(String id) {
		
		 Key key = Key.builder()
                 .partitionValue(id)
                 .build();
		 
		 return hogeTable.getItem(r->r.key(key));
	}
	
	public void insert(HogeEntity hogeEntity) {
		hogeTable.putItem(hogeEntity);
	}
	
}
