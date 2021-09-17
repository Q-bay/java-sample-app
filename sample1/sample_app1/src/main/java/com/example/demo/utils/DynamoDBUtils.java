package com.example.demo.utils;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DynamoDBUtils {
			
	private DynamoDbClient getDynamoDbClient(String endpoint, String region) {
		
		System.out.println(endpoint + " : " + region);

		DynamoDbClientBuilder dynamoDbClientBuilder = DynamoDbClient.builder()
				.region(Region.of(region))
				.endpointOverride(URI.create(endpoint));		

		return dynamoDbClientBuilder
				.credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
				.build();
	}
		
	
	public DynamoDbEnhancedClient getDynamoDBClient(String endpoint, String region) {
		
		DynamoDbEnhancedClient enhancedClient = 
			    DynamoDbEnhancedClient.builder()
			                          .dynamoDbClient(getDynamoDbClient(endpoint, region))
			                          .build();
		
		return enhancedClient;
	}
	

}
