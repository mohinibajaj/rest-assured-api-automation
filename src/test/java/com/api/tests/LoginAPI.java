package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPI{

    @Test(description = "verify login")
    public void loginApi(){

        LoginRequest loginRequest = new LoginRequest("Mohini Bajaj","Jatin2025@");
        AuthService auth = new AuthService();

//      Response response = auth.login(("{ \"username\" : \"Mohini Bajaj\", \"password\": \"Jatin2025@\"}"));
        Response response = auth.login(loginRequest);
//        String json = mapper.writeValueAsString(loginRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getId());

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getUsername(), "Mohini Bajaj");
        Assert.assertEquals(loginResponse.getEmail(), "mohinibajajmb5@gmail.com");
    }
}
