package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SMSMessagingPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(SMSMessagingPage.class);

    private static final By TEXTBOX_RECIPIENT = By.id("io.appium.android.apis:id/sms_recipient");
    private static final By TEXTBOX_MESSAGEBODY = By.id("io.appium.android.apis:id/sms_content");
    private static final By BTN_SEND = By.id("io.appium.android.apis:id/sms_send_message");
    private static final By TEXT_SMSSTATUS = By.id("io.appium.android.apis:id/sms_status");

    public SMSMessagingPage writeRecipient() {
        LOGGER.info("\"Recipient\" information written.");
        setTextElement(TEXTBOX_RECIPIENT, "Telekom");
        return this;
    }

    public SMSMessagingPage writeMessageContent() {
        LOGGER.info("\"Message Body\" written.");
        setTextElement(TEXTBOX_MESSAGEBODY, " Houston, we have a problem.");
        return this;
    }

    public SMSMessagingPage sendSMS() {
        LOGGER.info("Press \"SEND\" button.");
        clickElement(BTN_SEND);
        return this;
    }

    public SMSMessagingPage checkSMSStatus() {
        LOGGER.info("\"SMS Status\" checked.");

        String getSMSStatus = getTextElement(TEXT_SMSSTATUS);

        if ("Error: Null PDU.".equals(getSMSStatus)) {
            errorMessage("checkSMSStatus","SMS could not be sent ErrorMessage: " + getSMSStatus);
        }
        return this;
    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }
}
