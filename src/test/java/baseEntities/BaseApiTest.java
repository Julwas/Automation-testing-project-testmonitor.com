package baseEntities;


import io.restassured.http.ContentType;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import utils.configuration.ReadProperties;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class BaseApiTest {
    Logger logger = LogManager.getLogger(BaseApiTest.class);

    @BeforeTest
    public void setUpApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + ReadProperties.getToken());

        logger.info("Success autorization is finished");
    }
}
