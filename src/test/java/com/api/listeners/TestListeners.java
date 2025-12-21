package com.api.listeners;

import org.testng.log4testng.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.LogManager;


public class TestListeners implements ITestListener {

    private static final Logger logger = Logger.getLogger(TestListeners.class);

    public void onStart(ITestContext context) {

        logger.info("Test Suite Started");
    }

    public void onFinish(ITestContext context) {

        logger.info("Test Suite Completed");
    }

    public void onTestStart(ITestResult result) {
        logger.info("Test started" + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed" + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed" + result.getMethod().getMethodName());
        logger.error("Test Description" + result.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test Suite Skipped");
    }
}
