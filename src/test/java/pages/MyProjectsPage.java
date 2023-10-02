package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MyProjectsPage extends BasePage {
    private final static String pagePath = "/settings/projects";
    private final By menageButtonLocator = By.xpath("//a[contains(text(),'Manage Projects')]");
    private final By projectPageLocator = By.xpath("//h1[contains(text(), 'Projects')]");
    private final By manageButtonLocator = By.xpath("//a[contains(text(),'Manage Projects')]");
    private final By createButtonLocator = By.xpath("//button[contains(text(),'Create project...')]");
    private final By nameInputLocator = By.xpath("//input[starts-with(@id, 'field')]");
    private final By buttonFeaturesLocator = By.xpath("//span[contains(text(),'Features')]");
    private final By buttonTemplateLocator = By.xpath("//button//span[contains(text(),'Template')]");
    private final By buttonCreateLocator = By.xpath("//span[contains(text(),'Create')]");
    private final By projectLocator = By.xpath("//h3[contains(text(),'myProject')]");
    private final By projectDefectLocator = By.xpath("//h3[contains(text(),'myProjectNew')]");
    private final By buttonLocator = By.xpath("//a[@class='button is-primary has-icon is-small']");
    private final By myWorkLocator = By.xpath("//a[contains(text(),'My Work')]");
    private final By downloadLocator = By.xpath("//input[@class='dz-hidden-input']");
    private final By downloadedPictureLocator = By.xpath("//p[contains(text(),'test.jpg')]");
    private final By dialogBoxLocator = By.xpath("//div[@class='modal-card']");
    private final By emailInputLocator = By.xpath("//input[@type = 'email']");
    private final By logInButtonLocator = By.tagName("button");
    private final By callDropDownLocator = By.xpath("//div[@class='dropdown-component']");
    private final By dropDownItemLocator = By.xpath("//*[@class='dropdown-menu']//*[contains(text(),'Archive...')]");
    private final By archiveAcceptButtonLocator = By.xpath("//button[@class='button is-danger']");
    private final By  elementTextLocator = (By.xpath("//*[contains(text(),'View comments')]"));
    @Override
    protected By getPageIdentifier() {
        return null;
    }
    public SelenideElement getManageButton() {
        return $(manageButtonLocator);
    }
    public SelenideElement getProjectsPage(){return $(projectPageLocator);}
    public SelenideElement getDefectProject() {return $(projectDefectLocator);}
    public SelenideElement getCreateButton() {
        return $(createButtonLocator);
    }
    public SelenideElement getNameInput() {return $(nameInputLocator).shouldBe(visible, Duration.ofSeconds(20));}
     public SelenideElement getButtonFeatures() {
        return $(buttonFeaturesLocator);
    }
     public SelenideElement getButtonTemplate() {
        return $(buttonTemplateLocator);
    }
     public SelenideElement getButtonCreate() {
        return $(buttonCreateLocator);
    }
    public SelenideElement getProject() {return $(projectLocator);}
    public SelenideElement getButton() {return $(buttonLocator);}

    public SelenideElement getMyWorkButton(){return $(myWorkLocator).shouldBe(visible, Duration.ofSeconds(60));}
    public SelenideElement getDownloadFileButton(){return $(downloadLocator);}
    public SelenideElement getDownloadedPicture(){return $(downloadedPictureLocator);}
    public SelenideElement getDialogBox(){return $(dialogBoxLocator);}
    public SelenideElement getEmailInputBox() { return $(emailInputLocator);}
    public SelenideElement getDropDownButton() {return $(callDropDownLocator);}
    public SelenideElement getDropDownItem() {return  $(dropDownItemLocator);}
    public SelenideElement getAcceptArchiveButton() {return $(archiveAcceptButtonLocator);}
    public SelenideElement getElementText() {return $(elementTextLocator);}


    public void createProject(String name) {
        getManageButton().click();
        getCreateButton().click();
        getNameInput().setValue(name);
        getButtonFeatures().click();
        getButtonTemplate().click();
        getButtonCreate().click();
    }
    public void checkPopUpMessage(){
        getMyWorkButton().click();
        getButton().click();
    }
    public void openProject(){
        getManageButton().click();
        getCreateButton().click();
    }
    public void showDialog ()
    {
        getManageButton().click();
        getCreateButton().click();
    }
    public static String getPathToFile() {
        String pathToFile;
        if (SystemUtils.IS_OS_WINDOWS) {
            pathToFile = MyProjectsPage.class.getClassLoader().getResource("test.jpg").getPath()
                    .replace("/", "\\").substring(1);
        } else {
            pathToFile = MyProjectsPage.class.getClassLoader().getResource("test.jpg").getPath();
        }
        return pathToFile;
    }
    public void loadFile(String path)
    {
        getMyWorkButton().click();
        getButton().click();

        getDownloadFileButton().sendKeys(path);


    }
    public void deleteProject()
    {
        getManageButton().click();
        getProject().click();
        getDropDownButton().click();
        getDropDownItem().click();
        getAcceptArchiveButton().click();

    }
    public void setIncorrectEmail (String email)
    {
        getEmailInputBox().setValue(email);


    }
    public String getProjectName() {
        return getNameInput().getValue();
    }

    public void setProjectName(String name) {
        getNameInput().setValue(name);
    }

}
