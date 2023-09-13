package steps;

import baseEntities.BaseStep;
import pages.MyProjectsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoginStep extends BaseStep {
    Logger logger = LogManager.getLogger(LoginStep.class);
    public LoginStep() {
        super();
    }

    public MyProjectsPage successLogin(String email, String password) {
        loginPage.login(email, password);

        logger.info("Success login is finished");

        return myProjectsPage;
    }
}
