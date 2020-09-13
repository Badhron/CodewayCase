package com.berkin.base;

import com.berkin.Listener.Listener;
import com.berkin.utilities.DriverThread;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


@Listeners({Listener.class})
public class BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);


    @Parameters({"platformName", "deviceName", "udid", "app"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String platformName, String deviceName, String udid, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid); // adb devices
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, new File("APKFiles/" + app).getAbsolutePath());

        AndroidDriver<AndroidElement> androidDriver = null;
        try {
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOGGER.error("Driver could not be created! ErrorMessage: " + e.getMessage());
        }

        DriverThread.setDriver(androidDriver);
    }

    @BeforeMethod //Her case öncesinde programı kapatıp açar. AfterMethod olarakta yapılabilirdi.
    public void beforeMethod() {
        DriverThread.getDriver().closeApp();
        DriverThread.getDriver().launchApp();

    }

    @AfterClass // Her class sonrasında driver kapatılıp temizlenir.
    public void afterClass() {
        DriverThread.getDriver().quit();
        DriverThread.setDriver(null);
    }


}
