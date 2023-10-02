package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

public class ApiGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetProjectTest.class);
    private Project actualProject;
    @Test
    public void getProject() throws FileNotFoundException {
        int projectId = 3;
        Gson gson = new Gson();



        String pathToFile = ApiGetProjectTest.class.getClassLoader().getResource("expectedProject.json").getPath();
        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);

        String json = gson.toJson(expectedProject);
        System.out.println(json);

        Response response = given()
                .pathParams("projectId", projectId)
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);

        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");
        actualProject = gson.fromJson(respAsJsonElement, Project.class);

        logger.info("actualProject : " + actualProject.toString());
        logger.info("Expected project : " + expectedProject.toString());

        Assert.assertEquals(actualProject, expectedProject);
    }
}
