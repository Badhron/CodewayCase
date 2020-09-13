package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import com.berkin.base.BaseTest;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MainPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(MainPage.class);

    private static final By BTN_TEXT = By.xpath("//android.widget.TextView[@content-desc='Text']");
    private static final By BTN_OS = By.xpath("//android.widget.TextView[@content-desc='OS']");
    private static final By BTN_PREFERENCE = By.xpath("//android.widget.TextView[@content-desc='Preference']");
    private static final By BTN_MEDIA = By.xpath("//android.widget.TextView[@content-desc='Media']");
    private static final By BTN_ANIMATION = By.xpath("//android.widget.TextView[@content-desc='Animation']");
    private static final By BTN_APP = By.xpath("//android.widget.TextView[@content-desc='App']");

    @Step("\"Text\" text is clicked.")
    public void openTextPage() {
        LOGGER.info("\"Text\" text is clicked.");

        clickElement(BTN_TEXT);
    }

    @Step("\"OS\" text is clicked.")
    public void openOSPage() {
        LOGGER.info("\"OS\" text is clicked.");

        clickElement(BTN_OS);
    }

    @Step("\"Preference\" text is clicked.")
    public void openPreferencePage() {
        LOGGER.info("\"Preference\" text is clicked.");

        clickElement(BTN_PREFERENCE);
    }

    @Step("\"Media\" text is clicked.")
    public void openMediaPage() {
        LOGGER.info("\"Media\" text is clicked.");

        clickElement(BTN_MEDIA);
    }
    @Step("\"Animation\" text is clicked.")
    public void openAnimationPage() {
        LOGGER.info("\"Animation\" text is clicked.");

        clickElement(BTN_ANIMATION);
    }
    @Step("\"App\" text is clicked.")
    public void openAppPage() {
        LOGGER.info("\"App\" text is clicked.");

        clickElement(BTN_APP);
    }

}
