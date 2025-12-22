package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class GetUserProfile {

    private static final Logger log = LoggerFactory.getLogger(GetUserProfile.class);

    @Test(description = "get profile")
    public void getProfileAPI(){


        AuthService authService = new AuthService();
        Response response =  authService.login(new LoginRequest("Mohini Bajaj","Jatin2025@"));

         LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println("Print login token:"  +loginResponse.getToken());

          UserService userService = new UserService();

         response =  userService.getProfile(loginResponse.getToken());
        System.out.println ("Response for get profile: " +  response.asPrettyString());
//
        GetProfileResponse getProfileResponse = response.as(GetProfileResponse.class);
        System.out.println ("User FirstName: " + getProfileResponse.getFirstName());
        System.out.println ("User LastName: " + getProfileResponse.getLastName());
    }
}


