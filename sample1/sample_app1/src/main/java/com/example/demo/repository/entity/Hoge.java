package com.example.demo.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@DynamoDBTable(tableName = "hoge")
@Data
public class Hoge {

	@DynamoDBHashKey
	private String id;
	
	@DynamoDBRangeKey
	private String name;
	
}
