package baseEntities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utils.configuration.ReadProperties;

public class BaseApiTest {
    @BeforeTest
    public void setUpApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

    }
}
