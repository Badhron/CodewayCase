package com.berkin.base;

import com.berkin.data.XpathType;
import com.berkin.pages.AudioFxPage;
import com.berkin.utilities.DriverThread;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(AudioFxPage.class);

    protected AndroidDriver<AndroidElement> androidDriver = DriverThread.getDriver();
    private final WebDriverWait wait;

    public BaseStepMethod() {
        this.wait = new WebDriverWait(androidDriver, 30);

        if (androidDriver.isDeviceLocked())
            androidDriver.unlockDevice();
    }

    protected MobileElement waitVisibleByLocator(By locator) {
        MobileElement element = null;

        try {
            element = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LOGGER.error("Web element is not visible!");
        }
        return element;
    }

    protected List<AndroidElement> waitAllVisibleByLocator(By locator) {
        List<AndroidElement> element = null;

        try {
            element = androidDriver.findElements(locator);
        } catch (Exception e) {
            LOGGER.error("Web element is not visible!");
        }
        return element;
    }

    protected MobileElement waitClickableByOfElement(MobileElement mobileElement) {
        MobileElement element = null;

        try {
            element = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
        } catch (Exception e) {
            LOGGER.error("Web element is not clickable!");
        }
        return element;
    }

    protected MobileElement waitPresenceOfElementByLocator(By locator) {
        MobileElement element = null;

        try {
            element = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            LOGGER.error("Web element not found in document!");
        }
        return element;
    }

    protected void clickElement(By locator) {
        MobileElement element = this.waitVisibleByLocator(locator);
        waitClickableByOfElement(element).click();
    }


    protected String getTextElement(By locator) {
        return waitPresenceOfElementByLocator(locator).getText();
    }

    protected String getAttributeElement(By locator, XpathType attributeType) {
        return waitPresenceOfElementByLocator(locator).getAttribute(attributeType.getValue());
    }

    protected boolean isDisableElement(By locator) {
        String isDisable = getAttributeElement(locator, XpathType.CHECKED);
        return isDisable.equals("false");
    }

    protected void setTextElement(By locator, String text) {
        MobileElement element = waitPresenceOfElementByLocator(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void backClick() {
        //androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void testSeekBarToEnd(By locator) {
        //Locating seekbar using resource id
        MobileElement seek_bar_element = waitVisibleByLocator(locator);
        // get start co-ordinate of seekbar
        int start = seek_bar_element.getLocation().getX();
        //Get width of seekbar
        int padding = 250;// Couldn't scroll to the last part because of padding.
        int end = seek_bar_element.getSize().getWidth() + padding;
        //get location of seekbar vertically
        int y = seek_bar_element.getLocation().getY();

        // Select till which position you want to scroll the seekbar
        TouchAction action = new TouchAction(androidDriver);

        //Move it will the end
        action.longPress(PointOption.point(start, y)).moveTo(PointOption.point(end, y)).release().perform();
    }


    public String getToastMessage() {
        WebElement toastView = androidDriver.findElement(By.xpath("//android.widget.Toast[1]"));
        return toastView.getAttribute("name");
    }

    public void resultTakeScreenShot(String scenarioName) {
        takeScreenShot(scenarioName, false);
    }

    public void errorMessage(String scenarioName, String message) {
        takeScreenShot(scenarioName, true);
        Assert.fail(message);
    }

    public void takeScreenShot(String methodName, boolean isFail) {
        AtomicBoolean isFinish = new AtomicBoolean(false);
        new Thread(() -> {
            try {
                String fail = isFail ? "FailTest" : "TestResult";
                SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
                Date date = new Date(System.currentTimeMillis());
                String time = formatterDate.format(date);

                String screenshotLoc = System.getProperty("user.dir") + "\\ScreenshotFile\\ApiDemos\\" + fail + "\\" +
                        time + "_" + methodName.replaceAll(" ", "") + ".png";

                File srcFiler = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFiler, new File(screenshotLoc));
                isFinish.set(true);
            } catch (IOException e) {
                LOGGER.error("Error occurred in screenshot file operations!", e);
            }
        }).start();

        while (true) {
            if (isFinish.get())
                break;
        }
    }
}
