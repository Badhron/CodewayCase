package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LogTextBoxPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(LogTextBoxPage.class);

    private static final By BTN_ADD = By.id("io.appium.android.apis:id/add");
    private static final By TEXTBOX = By.id("io.appium.android.apis:id/text");

    public LogTextBoxPage addTestText() {
        LOGGER.info("Press \"ADD\" button.");

        clickElement(BTN_ADD);
        return this;
    }

    public void checkTextBox() {
        LOGGER.info("Textbox is checked.");

        String getTextBox = getTextElement(TEXTBOX);
        if (!"This is a test\n".equals(getTextBox)){
            errorMessage("checkTextBox","Did not add text or texts did not match");
        }
    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }

}
