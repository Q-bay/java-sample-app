package com.example.demo.utils;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBUtils {
		
	public static DynamoDBMapper getDynamoDBClient() {

		String region = "";
		
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
	            .withRegion(region)
	            .build();		
		
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		
		return mapper;
	}

}
