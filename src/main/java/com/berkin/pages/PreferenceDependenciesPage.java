package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import com.berkin.data.XpathType;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PreferenceDependenciesPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(PreferenceDependenciesPage.class);

    private static final By BTN_Checkbox = By.id("android:id/checkbox");

    @Step("\"Checkbox\" marked.")
    public PreferenceDependenciesPage enableWifi() {
        LOGGER.info("\"Checkbox\" marked.");
        if (isDisableElement(BTN_Checkbox))
            clickElement(BTN_Checkbox);
        return this;
    }

    @Step("Is \"Wifi\" enabled?.")
    public void checkIsWifiEnabled() {
        LOGGER.info("Is \"Wifi\" enabled?.");
        String isEnable = getAttributeElement(BTN_Checkbox, XpathType.CHECKED);
        if (!"true".equals(isEnable)) {
            errorMessage("checkIsWifiEnabled", "Wifi is not enabled");
        }
    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }

}

