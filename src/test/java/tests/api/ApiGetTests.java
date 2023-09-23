package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class ApiGetTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetTests.class);

    @Test
    public void getAllProjects() throws FileNotFoundException {

        Gson gson = new Gson();

        String endpoint = "/api/v1/projects";

        String pathToFile = ApiTests.class.getClassLoader().getResource("expectedProject.json").getPath();
        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Type listType = new TypeToken<ArrayList<Project>>() {
        }.getType();
        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);
        JsonArray respAsJsonArray = respAsJsonObject.getAsJsonArray("data");

        List<Project> actualProjects = gson.fromJson(respAsJsonArray, listType);

        logger.info("List of all projects: ");
        for (Project p :
                actualProjects) {
            logger.info(p);
        }

        Assert.assertEquals(actualProjects.get(2), expectedProject);
        logger.info("Last added project is in the list");

    }

}
