package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilters implements Filter {


    // for generating logs
    private  static  final Logger logger = LogManager.getLogger(LoggingFilters.class);

    //mandatory method to be implemented

    //filters is used to intercept request so we can log the details before request is sent to server
    //filter is given in base class
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
   logRequest(requestSpec);  //
  Response response =  ctx.next(requestSpec, responseSpec);  //next method is to execute the request
  logResponse(response);
        return response;  // return response for further assertions
    }

     // create two methods to log request and repsonse to print logs
    public  void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("BASE URI:" + requestSpec.getBaseUri() );
        logger.info("REQUEST HEADERS" + requestSpec.getHeaders() );
        logger.info("REQUEST PAYLOAD:" + requestSpec.getBody() );
    }

    public  void logResponse(Response response){
        logger.info("STATUS CODE:" + response.getStatusCode() );
        logger.info("RESPONSE HEADERS" + response.headers() );
        logger.info("RESPONSE BODY:" + response.getBody().prettyPrint() );
    }

}
