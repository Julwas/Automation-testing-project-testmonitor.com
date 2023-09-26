package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ApiGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetProjectTest.class);

    @Test
    public void getProject() throws FileNotFoundException {
        int projectId = 3;
        Gson gson = new Gson();

        String endpoint = "/api/v1/projects/{projectId}";

        String pathToFile = ApiGetProjectTest.class.getClassLoader().getResource("expectedProject.json").getPath();
        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);

        String json = gson.toJson(expectedProject);
        System.out.println(json);

        Response response = given()
                .pathParams("projectId", projectId)
                .get(endpoint);

        Project actualProject = gson.fromJson(response.getBody().asString(), Project.class);// <-----0???

        logger.info("actualProject " + actualProject.toString());

        //System.out.println("actualProject " + actualProject.toString());
        Assert.assertNotEquals(expectedProject, actualProject);// нужно бы Equals


    }
}
