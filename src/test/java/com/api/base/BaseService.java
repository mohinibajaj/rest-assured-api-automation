package com.api.base;
import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilters;
import com.api.models.request.LoginRequest;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080";

    private final RequestSpecification requestSpecification;


    //static block is used so we can use the block only once.
    static {
        RestAssured.filters(new LoggingFilters());  //create the object for the loggingfilter class

    }

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

//    protected Response postRequest(Object payload, String endpoint){
//      return  requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
//    }

    protected void setAuthToken(String token){
           requestSpecification.header("Authorization", "Bearer "+token);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return  requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return  requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);
    }

    protected Response getRequest(String endpoint){
        return  requestSpecification.get(endpoint);
    }

}
