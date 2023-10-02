package baseEntities;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MyProjectsPage;
import steps.LoginStep;
import utils.configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    protected LoginStep loginStep;
    protected MyProjectsPage myProjectsPage;


    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).savePageSource(true));
        open();

        loginStep = new LoginStep();

        myProjectsPage = new MyProjectsPage();

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 25000;
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        open(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {// сloses the browser in case of an error
        closeWebDriver();
    }

    public abstract void onTestFailure(ITestResult result);
}
