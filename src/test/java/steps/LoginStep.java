package steps;

import baseEntities.BaseStep;
import pages.MyProjectsPage;

public class LoginStep extends BaseStep {
    public LoginStep() {
        super();
    }

    public MyProjectsPage succesLogin(String email, String password) {
        loginPage.login(email, password);
        return myProjectsPage;
    }


}
