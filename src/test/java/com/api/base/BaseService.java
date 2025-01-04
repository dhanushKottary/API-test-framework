package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.auth().oauth2(token);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

}
