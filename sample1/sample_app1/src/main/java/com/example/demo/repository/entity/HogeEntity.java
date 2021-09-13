package com.example.demo.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@DynamoDBTable(tableName = "hoge")
@Data
public class HogeEntity {

	@DynamoDBHashKey
	private String id;
	
	@DynamoDBAttribute
	private String name;
	
	
	
}
