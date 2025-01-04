package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	
	@Test(description ="Verify if forgot password API is working")
	public void forgotpasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("dhanush2819kottary@gmail.com");
		
		System.out.println(response.asPrettyString());
	}
	
	


}
