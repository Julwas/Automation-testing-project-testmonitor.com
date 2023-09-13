package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyProjectsPage extends BasePage {
    private final static String pagePath = "/settings/projects";
    //private final By headerTitleLocator = By.className("Settings");
    //private final By createButtonLocator = By.xpath("//button[contains(text(),'Create project...')]");
    private final By menageButtonLocator = By.xpath("//a[contains(text(),'Manage Projects')]");
    private final By createButtonLocator = By.xpath("//button[contains(text(),'Create project...')]");
    private final By nameInputLocator = By.id("field-37");
    private final By buttonFeaturesLocator = By.xpath("//span[contains(text(),'Features')]");
    private final By buttonTemplateLocator = By.xpath("//button//span[contains(text(),'Template')]");
    private final By buttonCreateLocator = By.xpath("//span[contains(text(),'Create')]");
    private final By projectLocator = By.xpath("//h3[contains(text(),'myProject')]");

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
    public SelenideElement getNameInput() {
        return $(nameInputLocator);
    }
     public SelenideElement getButtonFeatures() {
        return $(buttonFeaturesLocator);
    }
     public SelenideElement getButtonTemplate() {
        return $(buttonTemplateLocator);
    }
     public SelenideElement getButtonCreate() {
        return $(buttonCreateLocator);
    }
     public SelenideElement getProject() {
        return $(projectLocator);
    }
    public void createProject(String name) {
        getMenageButton().click();
        getCreateButton().click();
        getNameInput().setValue(name);
        getButtonFeatures().click();
        getButtonTemplate().click();
        getButtonCreate().click();
    }
}
