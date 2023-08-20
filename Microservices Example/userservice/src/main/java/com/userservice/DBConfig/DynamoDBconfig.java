package com.userservice.DBConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBconfig {

	
    private String dynamodbEndpoint= "https://dynamodb.eu-north-1.amazonaws.com";

    
    private String awsRegion = "eu-north-1";

   
    private String dynamodbAccessKey="AKIAUHZOTEWGX5JZ7DPQ\r\n";

   
    private String dynamodbSecretKey= "AiQULBsUK7dQmSZEWtAWpIyOq/ooUrLTwPlvVrnd";


    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                   new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint,awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(
                   new BasicAWSCredentials(dynamodbAccessKey,dynamodbSecretKey)))
                .build();
    }
}
