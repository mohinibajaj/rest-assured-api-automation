package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassword {

    @Test(description = "Verify forgot password")
    public void forgotPasswordAPI() {

        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("mohinibajaj@gmail.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
