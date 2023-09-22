package tests.gui;


import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.*;
import static utils.TestUtils.generateString;


public class UItests extends BaseTest {
    Logger logger = LogManager.getLogger(UItests.class);

    @Test(description = "Тест на проверку всплывающего сообщения.")
    public void PopUpMessageTest() {
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(), ReadProperties.password());

        myProjectsPage.checkPopUpMessage();

        String expectedText = "View comments";
        SelenideElement elementText = $
                (By.xpath("//*[contains(text(),'View comments')]"));
        String actualText = elementText.getText();
        Assert.assertEquals(actualText.contains(actualText),
                expectedText.contains(expectedText), "There is no symbols View comments");

        logger.info("PopUpMessageTest. The 'View comments' pop-up message is present.");
    }

    @Test(description = "Тест на создание сущности.")
    public void CreationEntityTest  () {
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(), ReadProperties.password());

        myProjectsPage.createProject(ReadProperties.name());
        Assert.assertTrue(myProjectsPage.getProject().isEnabled());

        logger.info(" CreationEntityTest. Entity Myproject was created.");
    }
    @Test(description = "Тест на проверку поля для ввода на граничные значения.")
    public void BoundaryValuesTest (){

        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());
        myProjectsPage.openProject();
        myProjectsPage.setProjectName(generateString(101));
        int actualLength = myProjectsPage.getProjectName().length();
        Assert.assertEquals(actualLength, 100);
        myProjectsPage.setProjectName(generateString(100));
        actualLength = myProjectsPage.getProjectName().length();
        Assert.assertEquals(actualLength, 100);
        myProjectsPage.setProjectName(generateString(50));
        actualLength = myProjectsPage.getProjectName().length();
        Assert.assertEquals(actualLength, 50);

        logger.info("BoundaryValuesTest. The maximum number of input characters field is 100.");
    }
    @Test(description = "Тест на ввод данных превышающих допустимые.")
    public void ExceedingMaxTest (){
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());
        myProjectsPage.openProject();
        String inputNAme = generateString(110);
        myProjectsPage.setProjectName(inputNAme);
        String actualNAme = myProjectsPage.getProjectName();
        Assert.assertNotEquals(actualNAme,inputNAme);

        logger.info("ExceedingMaxTest. There is impossible to enter more characters than 100.");
    }

    @Test(description = "Тест на загрузку файла.")
    public void LoadFileTest()
    {
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());
        myProjectsPage.loadFile();
        Assert.assertTrue(myProjectsPage.getDownloadedPicture().isEnabled());
        logger.info("LoadFileTest. File is load.");
    }
    @Test(description = "Тест на отображение диалогового окна.")
    public void DialogBoxTest()
    {
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());
        myProjectsPage.showDialog();
        Assert.assertTrue(myProjectsPage.getDialogBox().isEnabled());
        logger.info("DialogBoxTest. Dialog box is displayed.");
    }
    //Не понятно как сделать локатор, так как поле для вставки появляется после клика на поле и id поля меняется каждый раз
    //@Test(description = "Тест на использование некорректных данных.")
    /*public void IncorrectDataTest()
    {
        open(ReadProperties.getUrl());
        loginStep.successLogin(ReadProperties.email(),ReadProperties.password());
        open(ReadProperties.getMyAccountUrl());
        String inputEmail = "abeganskaya98gmail.com";
        myProjectsPage.setIncorrectEmail(inputEmail);
        Assert.assertTrue(myProjectsPage.saveChangesButton().isEnabled());
        logger.info("IncorrectDataTest.");

    }*/
}
