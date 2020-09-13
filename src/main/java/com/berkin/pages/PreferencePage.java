package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class PreferencePage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(PreferencePage.class);

    private static final By BTN_PREFERENCE_DEPENDENCIES = By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']");

    @Step("\"Preference dependencies\" text is clicked.")
    public void openPreferenceDependenciesPage() {
        LOGGER.info("\"Preference dependencies\" text is clicked.");
        clickElement(BTN_PREFERENCE_DEPENDENCIES);
    }

}
