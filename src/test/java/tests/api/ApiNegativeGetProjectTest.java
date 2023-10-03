package tests.api;

import baseEntities.BaseApiTest;
import adapters.ProjectAdapter;

import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class ApiNegativeGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiNegativeGetProjectTest.class);

    @Test
    public void negativeGetTest() {

        Response response = new ProjectAdapter().getNegativeProject();

        logger.info("Project with this ID Not Found" + response.statusCode());
    }
}
