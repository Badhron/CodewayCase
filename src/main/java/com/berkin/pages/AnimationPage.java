package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class AnimationPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(AnimationPage.class);

    private static final By BTN_MULTIPLEPROPERTIES = By.xpath("//android.widget.TextView[@content-desc='Multiple Properties']");

    public void openMultiplePropertiesPage() {
        LOGGER.info("\"Multiple Properties\" text is clicked.");

        clickElement(BTN_MULTIPLEPROPERTIES);
    }

}
