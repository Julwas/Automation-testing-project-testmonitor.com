package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;


public class ApiGetUserTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetUserTest.class);
    private User actualUser;
    @Test
    public void getUser() throws FileNotFoundException {

        int userId = 1;

        Gson gson = new Gson();

        String endpoint = "/api/v1/users/{userId}";

        String pathToFile = ApiGetUserTest.class.getClassLoader().getResource("expectedUser.json").getPath();
        FileReader reader = new FileReader(pathToFile);
        User expectedUser = gson.fromJson(reader, User.class);

        String json = gson.toJson(expectedUser);
        System.out.println(json);


        Response response = given()
                .pathParams("userId", userId)
                .body(expectedUser, ObjectMapperType.GSON)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);

        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");
        actualUser = gson.fromJson(respAsJsonElement, User.class);


     System.out.println(actualUser.toString());
        logger.info("actual User : " + actualUser.toString());
        logger.info("Expected User : " + expectedUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }
}
