package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyProjectsPage extends BasePage {
    private final static String pagePath = "/settings/projects";
    private final By menageButtonLocator = By.xpath("//a[contains(text(),'Manage Projects')]");
    private final By createButtonLocator = By.xpath("//button[contains(text(),'Create project...')]");
    private final By nameInputLocator = By.id("field-37");
    private final By buttonFeaturesLocator = By.xpath("//span[contains(text(),'Features')]");
    private final By buttonTemplateLocator = By.xpath("//button//span[contains(text(),'Template')]");
    private final By buttonCreateLocator = By.xpath("//span[contains(text(),'Create')]");
    private final By projectLocator = By.xpath("//h3[contains(text(),'myProject')]");
    private final By buttonLocator = By.xpath("//a[@class='button is-primary has-icon is-small']");
    private final By projectWebUpLocator = By.xpath("//h3[contains(text(),'Web Application Starter Kit')]");
    private final By myWorkLocator = By.xpath("//a[contains(text(),'My Work')]");
    private final By playButtonLocator = By.xpath("//a[@class='button is-primary has-icon is-small']");
    private final By downloadLocator = By.xpath("//input[@class='dz-hidden-input']");
    private final By downloadedPictureLocator = By.xpath("//p[contains(text(),'test.jpg')]");
    private final By dialogBoxLocator = By.xpath("//div[@class='modal-card']");
    //private final By emailInputLocator = By.xpath(""); Не понятно как сделать локатор, так как поле для вставки появляется после клика на поле и id поля меняется каждый раз
    private final By saveChangesLocator = By.xpath("//svg[@class='svg-inline--fa fa-floppy-disk']");
    private final By emailIncorrectMessageLocator = By.xpath("//span[contains(text(), 'The email address must be a valid email address.')]");


    @Override
    protected By getPageIdentifier() {
        return null;
    }
    public SelenideElement getMenageButton() {
        return $(menageButtonLocator);
    }
    public SelenideElement getCreateButton() {
        return $(createButtonLocator);
    }
    public SelenideElement getNameInput() {return $(nameInputLocator);}
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
    public SelenideElement getProjectWebUp() {return $(projectWebUpLocator);}
    public SelenideElement getButton() {return $(buttonLocator);}
    public SelenideElement getMyWorkButton(){return $(myWorkLocator);}
    public SelenideElement getPlayButton(){return $(playButtonLocator);}
    public SelenideElement getDownloadFileButton(){return $(downloadLocator);}
    public SelenideElement getDownloadedPicture(){return $(downloadedPictureLocator);}
    public SelenideElement getDialogBox(){return $(dialogBoxLocator);}
    //public SelenideElement getEmailInput() {return $(emailInputLocator);}
    public SelenideElement saveChangesButton() {return $(saveChangesLocator);}


    public void createProject(String name) {
        getMenageButton().click();
        getCreateButton().click();
        getNameInput().setValue(name);
        getButtonFeatures().click();
        getButtonTemplate().click();
        getButtonCreate().click();
    }
    public void checkPopUpMessage(){
        getProjectWebUp().click();
        getButton().click();
    }
    public void openProject(){
        getMenageButton().click();
        getCreateButton().click();
    }

    public String getProjectName() {
        return getNameInput().getValue();
    }

    public void setProjectName(String name) {
        getNameInput().setValue(name);
    }

    public void showDialog ()
    {
        getMenageButton().click();
        getCreateButton().click();
    }
     public void loadFile()
    {
        getMyWorkButton().click();
        getPlayButton().click();
        String pathToFile = MyProjectsPage.class.getClassLoader().getResource("test.jpg").getPath();
        getDownloadFileButton().sendKeys(pathToFile.substring(1));
    }
    /*public void setIncorrectEmail (String email)
    {
        getEmailInput().setValue(email);
        saveChangesButton().click();
    }*/
}
