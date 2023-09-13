package tests;


import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.open;

public class testsAPI extends BaseTest {
    Logger logger = LogManager.getLogger(testsAPI.class);
    @Test(description = "Тест на создание сущности")
    public void addProject(){
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());

        myProjectsPage.createProject(ReadProperties.name());
        Assert.assertTrue(myProjectsPage.getProject().isEnabled());

        logger.info(" Myproject was created");
    }
}
