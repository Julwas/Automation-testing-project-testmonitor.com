package baseEntities;

import pages.LoginPage;
import pages.MyProjectsPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected MyProjectsPage myProjectsPage;

    public BaseStep() {

        loginPage = new LoginPage();
        myProjectsPage = new MyProjectsPage();

    }
}
