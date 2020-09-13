package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class AppPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(AppPage.class);

    private static final By BTN_NOTIFICATION = By.xpath("//android.widget.TextView[@content-desc='Notification']");

    @Step("\"Notification\" text is clicked.")
    public void openNotificationPage() {
        LOGGER.info("\"Notification\" text is clicked.");

        clickElement(BTN_NOTIFICATION);
    }

}
