package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MediaPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(MediaPage.class);

    private static final By BTN_AUDIOFX = By.xpath("//android.widget.TextView[@content-desc='AudioFx']");

    public void openAudioFxPage() {
        LOGGER.info("\"AudioFx\" text is clicked.");
        clickElement(BTN_AUDIOFX);
    }
}
