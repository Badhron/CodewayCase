package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class NotificationPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(NotificationPage.class);

    private static final By BTN_NOTIFYWITHTEXT= By.xpath("//android.widget.TextView[@content-desc='NotifyWithText']");

    @Step("\"NotifyWithText\" text is clicked.")
    public void openNotifyWithTextPage() {
        LOGGER.info("\"NotifyWithText\" text is clicked.");
        clickElement(BTN_NOTIFYWITHTEXT);
    }

}
