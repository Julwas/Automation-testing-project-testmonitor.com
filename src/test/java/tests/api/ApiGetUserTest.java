package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;


public class ApiGetUserTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetUserTest.class);

    @Test
    public void getUser() throws FileNotFoundException {

        int userId = 2;

        Gson gson = new Gson();

        String endpoint = "/api/v1/users/{userId}";

        String pathToFile = ApiGetUserTest.class.getClassLoader().getResource("expectedUser.json").getPath();
        FileReader reader = new FileReader(pathToFile);
        User expectedUser = gson.fromJson(reader, User.class);

        String json = gson.toJson(expectedUser);
        System.out.println(json);


        Response response = given()
                .pathParam("userId", userId)
                .get(endpoint);

        User actualUser = gson.fromJson(response.getBody().asString(), User.class);//то же самое

     System.out.println(actualUser.toString());
       // Assert.assertTrue(expectedUser.equals(actualUser));
    }
}
