package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest3 {
	
	
	@Test(description ="Verify if login API is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("dhanushpk","dhanush2819kottary");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
	}
	
	
	@Test(description ="Verify if signup API is working")
	public void signUpTest() {
		
		SignupRequest signupRequest = new SignupRequest("dhanush123", "dhanush123", "dhanush123@gmail.com", "dhanush", "kottary", "1234561234");
		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);
		
		System.out.println(response.asPrettyString());
	}

}
