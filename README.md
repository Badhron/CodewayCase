# Codeway Recuitment Case

In this project, test automation was created for ApiDemos application using the scenarios provided by Codeway. The project was written in java using Maven, Page Object Model (POM),TestNG and Allure.


## Proje Özellikleri

2 different log records are kept.

* The first of these is kept under `Logs/` in the form of info and error.
* The other is kept under the `Allure-results/` folder.
* In addition, the `FailTest/` and `TestResult/` folders are opened under the `screenshotFile/`. These folders contain screenshots that need to be tested manually and screenshots of the test case(s) with error(s).

In order to view the reports obtained with Allure, allure should be installed on the computer that will be used and  

        allure serve <Allure-results path>
  
 should be written in the command prompt. Such as
  
        C:\Users\User>allure serve C:\Users\User\IdeaProjects\Codeway\allure-results
        
For detailed information, it can be obtained from https://www.swtestacademy.com/allure-testng/.

* The information of the device(s) to be tested is in the `TestFile.xml`. The parameters of the device(s) to be tested are kept as follows.

         <suite data-provider-thread-count="1" name="CodewayTest" parallel="tests">
            <test name="ApiDemosDebug">
                <parameter name="platformName" value="Android"/>
                <parameter name="deviceName" value="Android Emulator"/>
                <parameter name="udid" value="emulator-5554"/> 
                <parameter name="app" value="ApiDemos-debug.apk"/> 
                <classes>
                    <class name="com.berkin.test.ApiDemos"/>
                </classes>
             </test>
         </suite>
          
* The udid information of the device to be tested is obtained by typing <adb devices> in the command prompt.
* Since suite is set as parallel="tests", multiple device testing can be done by adding parameter of different devices.

For detailed information, it can be obtained from http://appium.io/docs/en/writing-running-appium/caps/.

            
