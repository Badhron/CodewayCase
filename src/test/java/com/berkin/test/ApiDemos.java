package com.berkin.test;

import com.berkin.base.BaseTest;
import com.berkin.pages.*;
import org.testng.annotations.Test;

public class ApiDemos extends BaseTest {

    @Test(enabled = true, description = "2. Add text “This is a test” on textbox.")
    public void TestScenario_02() {
        MainPage mainPage = new MainPage();
        TextPage textPage = new TextPage();
        LogTextBoxPage logTextBoxPage = new LogTextBoxPage();

        mainPage
                .openTextPage();

        textPage
                .openLogTextBoxPage();

        logTextBoxPage
                .addTestText()
                .checkTextBox();
    }

    @Test(enabled = true, description = "3. Go to the preferences and enable Wifi.")
    public void TestScenario_03() {
        MainPage mainPage = new MainPage();
        PreferencePage preferencePage = new PreferencePage();
        PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage();

        mainPage
                .openPreferencePage();

        preferencePage
                .openPreferenceDependenciesPage();

        preferenceDependenciesPage
                .enableWifi()
                .checkIsWifiEnabled();
    }

    @Test(enabled = true, description = "4. Go to AudioFX and change 60 Hz equalizer set value 15 dB.")
    public void TestScenario_04() {
        MainPage mainPage = new MainPage();
        MediaPage mediaPage = new MediaPage();
        AudioFxPage audioFxPage = new AudioFxPage();

        mainPage
                .openMediaPage();

        mediaPage
                .openAudioFxPage();

        audioFxPage
                .set60HzEqualizerTo15dB()
                .is60HzEqualizer15dB();
    }

    @Test(enabled = true, description = "5. Go to Animation Page and select multiple properties. After click run verify that one of the balls is below the screen and others up.")
    public void TestScenario_05() {
        MainPage mainPage = new MainPage();
        AnimationPage animationPage = new AnimationPage();
        MultiplePropertiesPage multiplePropertiesPage = new MultiplePropertiesPage();

        mainPage
                .openAnimationPage();

        animationPage
                .openMultiplePropertiesPage();

        multiplePropertiesPage
                .runAnimation()
                .checkAnimation();

    }

    @Test(enabled = true, description = "6. Go to Notification menu and sen short notification. Verify that text appear on screen temporarily.")
    public void TestScenario_06() {
        MainPage mainPage = new MainPage();
        AppPage appPage = new AppPage();
        NotificationPage notificationPage = new NotificationPage();
        NotifyWithTextPage notifyWithTextPage = new NotifyWithTextPage();

        mainPage
                .openAppPage();

        appPage
                .openNotificationPage();

        notificationPage
                .openNotifyWithTextPage();

        notifyWithTextPage
                .runShowShortNotification()
                .checkShowShortNotification();

    }

    @Test(enabled = true, description = "7. ERROR Case: Try to send SMS. Go to OS Page. Open SMS Messaging page and click send after enter beloved text.")
    public void TestScenario_07() {
        MainPage mainPage = new MainPage();
        OSPage osPage = new OSPage();
        SMSMessagingPage smsMessagingPage = new SMSMessagingPage();

        mainPage
                .openOSPage();

        osPage
                .openSMSMessagingPage();

        smsMessagingPage
                .writeRecipient()
                .writeMessageContent()
                .sendSMS()
                .checkSMSStatus();

    }
}
