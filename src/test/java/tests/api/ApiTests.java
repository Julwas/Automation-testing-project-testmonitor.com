package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;

public class ApiTests extends BaseApiTest {
    // static Logger logger = LogManager.getLogger(ApiTests.class);
    @Test
    public void Test() {
        String endpoint = "/api/v1/users";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void TestAdd() {

        String endpoint = "/api/v1/projects";

        given().body(String.format("{\n" +
                        "\"name\": \"Project T\",\n" +
                        "\"description\": \"testing project\",\n" +
                        "\"starts_at\": \"2022-01-01\",\n" +
                        "\"ends_at\": \"2022-01-01\",\n" +
                        "\"uses_applications\": true,\n" +
                        "\"uses_requirements\": true,\n" +
                        "\"uses_risks\": true,\n" +
                        "\"uses_issues\": true,\n" +
                        "\"uses_messages\": true,\n" +
                        "\"completed\": true,\n" +
                        "\"symbol_id\": 42\n" +
                        "}"))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

}
