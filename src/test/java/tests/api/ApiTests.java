package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.mapper.ObjectMapperType;

import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ApiTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiTests.class);

    private Project actualProject;

    @Test
    public void addProject() throws FileNotFoundException {

        Gson gson = new Gson();

        String pathToFile = ApiTests.class.getClassLoader().getResource("expectedProject.json").getPath();

        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);
        Response response = new ProjectAdapter().add(expectedProject);


        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);
        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");

        actualProject = gson.fromJson(respAsJsonElement, Project.class);

        logger.info("Actual project: " + actualProject.toString());
        logger.info("Expected project: " + expectedProject.toString());

        Assert.assertEquals(actualProject, expectedProject);
    }
}
