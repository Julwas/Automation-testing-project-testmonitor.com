package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;



public class ApiGetName extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetName.class);

    @Test
    public void getNameProject() throws FileNotFoundException {
        int projectId = 3;
        Gson gson = new Gson();

        String endpoint = "/api/v1/projects/{projectId}";

        String pathToFile = ApiTests.class.getClassLoader().getResource("expectedProject.json").getPath();
        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);
        String json = gson.toJson(expectedProject);
        System.out.println(json);

        Response response = given()
                .pathParams("id", projectId)
                .get(endpoint);

      Project actualProject = gson.fromJson(response.getBody().asString(), Project.class);
        //Project actualProject = gson.fromJson(reader, Project.class);
        System.out.println(actualProject.toString());
        Assert.assertTrue(expectedProject.equals(actualProject));

        //logger.info("name is :" + expectedProject.getName());
    }

}
