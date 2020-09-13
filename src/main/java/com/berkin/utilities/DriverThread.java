package com.berkin.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverThread {
    private static ThreadLocal<AndroidDriver<AndroidElement>> driverThreadLocal = new ThreadLocal();

    public DriverThread() {

    }

    public static synchronized AndroidDriver<AndroidElement> getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(AndroidDriver<AndroidElement> driver) {
        DriverThread.driverThreadLocal.set(driver);
    }
}
