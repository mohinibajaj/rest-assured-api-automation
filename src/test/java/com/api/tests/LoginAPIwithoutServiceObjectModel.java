package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPIwithoutServiceObjectModel {

    @Test(description = "verify login")
    public void loginApi(){

//        RestAssured.baseURI = "http://64.227.160.186:8080";
//        RequestSpecification x = RestAssured.given().log().all();
//        RequestSpecification y   = x.header("Content-Type", "application/json");
//        RequestSpecification z =   y.body("{ \"username\" : \"Mohini Bajaj\", \"password\": \"Jatin2025@\"}");
//        Response response = z.post("/api/auth/login");
//        System.out.println(response.asPrettyString());

        //Method chaining
        Response response = given().baseUri("http://64.227.160.186:8080").
                log().all().header("Content-Type", "application/json").body("{ \"username\" : \"Mohini Bajaj\", \"password\": \"Jatin2025@\"}").post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
