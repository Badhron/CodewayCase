package com.berkin.Listener;

import com.berkin.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener extends BaseTest implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(Listener.class);

    public Listener() {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test Started: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Test Passed: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("Test Failed: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test Skipped: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info("Test Failed Within Success Percentage: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
