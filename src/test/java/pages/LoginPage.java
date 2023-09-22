package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final By emailInputLocator = By.id("email");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.tagName("button");

    public LoginPage() {

        super();
    }
    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }
    //блок атомарных методов

    public SelenideElement getEmailInput() {
        return $(emailInputLocator);
    }

    public SelenideElement getPswInput() {
        return $(pswInputLocator);
    }

    public SelenideElement getLogInButton() {
        return $(logInButtonLocator);
    }

    public void login(String email, String password) {
        getEmailInput().setValue(email);
        getPswInput().setValue(password);
        getLogInButton().click();
    }
}
