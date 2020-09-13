# Codeway Recuitment Case

In this project, test automation was created for ApiDemos application using the scenarios provided by Codeway. The project was written in java using Maven, Page Object Model (POM) and Allure.


## Proje Özellikleri

2 different log records are kept.

* The first of these is kept under `Logs/` in the form of info and error.
* The other is kept under the `Allure-results/` folder.
* In addition, the `FailTest/` and `TestResult/` folders are opened under the `screenshotFile/` file. These folders contain screenshots that need to be tested manually and screenshots of the test case(s) with error(s).

In order to view the reports obtained with Allure, allure should be installed on the computer that will be used and  

        allure serve <Allure-results path>
  
 should be written in the command prompt. Such as
  
        C:\Users\User>allure serve C:\Users\User\IdeaProjects\Codeway\allure-results
        
For detailed information, you can check https://www.swtestacademy.com/allure-testng/.
