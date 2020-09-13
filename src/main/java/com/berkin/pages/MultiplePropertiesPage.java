package com.berkin.pages;

import com.berkin.base.BaseStepMethod;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class MultiplePropertiesPage extends BaseStepMethod {
    private static final Logger LOGGER = Logger.getLogger(MultiplePropertiesPage.class);

    private static final By BTN_RUN = By.id("io.appium.android.apis:id/startButton");

    @Step("Press \"Run\" button.")
    public MultiplePropertiesPage runAnimation() {
        LOGGER.info("Press \"Run\" button.");

        clickElement(BTN_RUN);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    @Step("Check animation.")
    public void checkAnimation() {
        LOGGER.info("Check animation.");
        resultTakeScreenShot("checkAnimation");
        LOGGER.info("Animation test sonucu ekran görüntüsü alındı => ScreenshotFile\\ApiDemos\\Test");
    }

    @Override
    public void errorMessage(String scenarioName, String message) {
        LOGGER.error(message);
        super.errorMessage(scenarioName, message);
    }
}
