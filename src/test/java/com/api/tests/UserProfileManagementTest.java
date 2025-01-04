package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.UserProfileResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UserProfileManagementTest {
	
	
	@Test(description ="Verify if get user profiles API is working")
	public void getUserProfileTest() {
		
		//login
		LoginRequest loginRequest = new LoginRequest("jerico12345","jerico12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse getUserProfileInfoResponse = response.as(UserProfileResponse.class);
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(getUserProfileInfoResponse.getUsername(), "jerico12345");
		Assert.assertEquals(getUserProfileInfoResponse.getMobileNumber(), "1234567882");
	}
	
	
	@Test(description ="Verify if update user profiles API (put request) is working")
	public void updateUserProfileTest() {
		
		//login
		LoginRequest loginRequest = new LoginRequest("jerico12345","jerico12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		//ProfileRequest profileRequest = new ProfileRequest("jerico123456@gmail.com", "chriss", "jericoo", "8888888888");
		ProfileRequest profileRequest = new ProfileRequest.Builder().email("jerico12345678@gmail.com")
				.lastName("jericoo")
				.firstName("chriss")
				.mobileNumber("8888888899").build();
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(userProfileResponse.getEmail(), "jerico12345678@gmail.com");
		Assert.assertEquals(userProfileResponse.getMobileNumber(), "8888888899");
	}
	
	


}
