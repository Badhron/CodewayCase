package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class OSPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(OSPage.class);

    private static final By BTN_SMSMESSAGING = By.xpath("//android.widget.TextView[@content-desc='SMS Messaging']");

    public void openSMSMessagingPage() {
        LOGGER.info("\"SMS Messaging\" text is clicked.");
        clickElement(BTN_SMSMESSAGING);
    }

}
