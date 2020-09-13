package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AudioFxPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(AudioFxPage.class);

    private static final By SEEKBAR_60HZ = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.SeekBar");

    public AudioFxPage set60HzEqualizerTo15dB() {
        LOGGER.info("\"60Hz Equalizer\" is set to 15 dB.");

        //  setTextElement(SEEKBAR_60HZ, "3000");
        testSeekBarToEnd(SEEKBAR_60HZ);
        return this;
    }

    public void is60HzEqualizer15dB() {
        LOGGER.info("Did \"60Hz Equalizer\" set to 15dB?");

        String get60HzText = getTextElement(SEEKBAR_60HZ);

        if (!"3000.0".equals(get60HzText)) {
            errorMessage("is60HzEqualizer15dB", "Did not set 60Hz equalizer to 15dB");
        }
    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }
}
