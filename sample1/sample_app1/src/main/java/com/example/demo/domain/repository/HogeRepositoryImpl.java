package com.example.demo.domain.repository;

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

	private final DynamoDbTable<HogeEntity> hogeTable;
	
	@Autowired
	public HogeRepositoryImpl(DynamoDBUtils dynamoDBUtils,
			@Value("${aws.dynamodb.endpoint}") String endpoint,		
			@Value("${aws.dynamodb.region}") String region) {
		
		System.out.println(endpoint + " : " + region);
		
		DynamoDbEnhancedClient dynamoDbEnhancedClient
			= dynamoDBUtils.getDynamoDBClient(endpoint, region);
		
		hogeTable = dynamoDbEnhancedClient.table("Hoge", TableSchema.fromBean(HogeEntity.class));
	}
	
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
