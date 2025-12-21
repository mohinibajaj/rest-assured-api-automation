package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpAPI {

    @Test(description = "Sign up API")
    public void SignUpAPITest(){

       SignupRequest signupRequest = new SignupRequest.Builder()
        .username("mohini13")
        .firstName("mohini")
        .email("mohinibajajmb5@gmail.com")
        .password("mohini123")
        .lastName("bajaj")
        .mobileNumber("0070878589")
         .build();

        AuthService auth = new AuthService();
        Response response = auth.signUp(signupRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.asPrettyString(), "User created successfully");
    }
}
