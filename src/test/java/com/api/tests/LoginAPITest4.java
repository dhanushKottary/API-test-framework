package com.api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.filters.LoggingFilter;
import com.api.listeners.TestListener;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(TestListener.class)
public class LoginAPITest4 {
	
	public static final Logger logger = LogManager.getLogger(LoginAPITest4.class);
	
	@Test(description ="Verify if login API is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("dhanushpk","dhanush2819kottary");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
	}
	
	
	@Test(description ="Verify if signup API is working using builder design pattern", enabled = false)
	public void signUpTest() {
		
		SignupRequest signupRequest = new SignupRequest.Builder().email("jerico12345@gmail.com")
				.username("jerico12345")
				.password("jerico12345")
				.firstName("chriss")
				.lastName("jericoo")
				.mobileNumber("1234567882").build();
		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}

}
