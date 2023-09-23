package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.json.TypeToken;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class ApiGetName extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetName.class);

    @Test
    public void getAllProjects() throws FileNotFoundException {

       Gson gson = new Gson();

        String endpoint = "/api/v1/projects";


        String pathToFile = ApiTests.class.getClassLoader().getResource("expectedProject1.json").getPath();
        FileReader reader = new FileReader(pathToFile);


    Project expectedProject = gson.fromJson(reader, Project.class);

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .body("get(1).name", is(expectedProject.getName()))
                .statusCode(HttpStatus.SC_OK);
                //.extract().response();

      //  logger.info("name is :" + expectedProject.getName());

    }

}
