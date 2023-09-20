package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;

import io.restassured.mapper.ObjectMapperType;

import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;


public class ApiTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiTests.class);

    @Test
    public void addProject() throws FileNotFoundException {

        Gson gson = new Gson();

        String endpoint = "/api/v1/projects";

        String pathToFile = ApiTests.class.getClassLoader().getResource("expectedProject.json").getPath();

        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();

        //  Project actualProject = gson.fromJson(response.getBody().asString(), Project.class);

       /* logger.info("Actual project: " + actualProject.toString());
        logger.info("Expected project: " + expectedProject.toString());

        Assert.assertTrue(expectedProject.equals(actualProject));*/

    }
}
