package com.userservice.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.userservice.entity.User;

@Repository
public class UserRepo {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public User createUser(User user) {
		dynamoDBMapper.save(user);
		return user;
	}
	
	public User getUserById(String userId) {
		return dynamoDBMapper.load(User.class, userId);
	}
	
	public String deleteUser(String userId) {
		dynamoDBMapper.delete(dynamoDBMapper.load(User.class, userId));
		return userId + "deleted!!";
	}
	
	 public String updateCustomer(User user) {
	        dynamoDBMapper.save(user, buildExpression(user));
	        return "record updated ...";
	    }
	 
	 private DynamoDBSaveExpression buildExpression(User user) {
	        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
	        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
	        expectedMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(user.getUserId())));
	        dynamoDBSaveExpression.setExpected(expectedMap);
	        return dynamoDBSaveExpression;
	    }
}
