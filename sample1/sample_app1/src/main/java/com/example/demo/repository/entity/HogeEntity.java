package com.example.demo.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@AllArgsConstructor
@DynamoDBTable(tableName = "Hoge")
@DynamoDbBean
@Data
public class HogeEntity {

	@DynamoDBHashKey
	private String id;
	
	@DynamoDBAttribute
	private String name;
	
	@DynamoDBAttribute
	private String description;
	
	public HogeEntity() {
		
	}
	
}
