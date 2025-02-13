package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TextPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(TextPage.class);

    private static final By BTN_LOGTEXTBOX = By.xpath("//android.widget.TextView[@content-desc='LogTextBox']");

    @Step("\"LogTextBox\" text is clicked.")
    public void openLogTextBoxPage() {
        LOGGER.info("\"LogTextBox\" text is clicked.");
        clickElement(BTN_LOGTEXTBOX);
    }

}
