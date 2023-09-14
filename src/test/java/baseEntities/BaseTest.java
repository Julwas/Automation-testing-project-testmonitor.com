package baseEntities;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MyProjectsPage;
import steps.LoginStep;
import utils.configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected LoginStep loginStep;
    protected MyProjectsPage myProjectsPage;


    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;

        loginStep = new LoginStep();
        myProjectsPage = new MyProjectsPage();

        open(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {// сloses the browser in case of an error
        closeWebDriver();
    }
}
