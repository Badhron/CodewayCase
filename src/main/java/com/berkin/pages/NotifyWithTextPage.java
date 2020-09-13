package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class NotifyWithTextPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(NotificationPage.class);

    private static final By BTN_SHOWSHORTNOTIFICATION = By.id("io.appium.android.apis:id/short_notify");

    @Step("Press \"Show Short Notification\" button.")
    public NotifyWithTextPage runShowShortNotification() {
        LOGGER.info("Press \"Show Short Notification\" button.");

        clickElement(BTN_SHOWSHORTNOTIFICATION);
        return this;
    }
    @Step("Check \"Show Short Notification\" toast message.")
    public void checkShowShortNotification() {
        LOGGER.info("Check \"Show Short Notification\" toast message.");

        String toastMessage = getToastMessage();

        if (!"Short notification".equals(toastMessage)) {
            errorMessage("checkShowShortNotification", "Toast message did not match \nExpected: \"Short notification\" Actual: \"" + toastMessage + "\"");
        }

    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }

}