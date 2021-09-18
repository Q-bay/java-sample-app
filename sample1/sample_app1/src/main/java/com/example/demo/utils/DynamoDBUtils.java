package com.example.demo.utils;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
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
			
	@Value("${aws.dynamodb.endpoint}") 
	String endpoint;
	
	@Value("${aws.dynamodb.region}") 
	String region;	
	
	private AmazonDynamoDB getAmazonDynamoDB(String endpoint, String region) {
				
		EndpointConfiguration endpointConfiguration = new EndpointConfiguration(endpoint, region);
				
		return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration)
                .build();
	}
	
	public DynamoDBMapper getDynamoDBMapper() {
		return new DynamoDBMapper(this.getAmazonDynamoDB(endpoint, region));
	}

}
