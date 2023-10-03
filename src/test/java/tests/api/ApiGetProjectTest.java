package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(ApiGetProjectTest.class);
    private Project actualProject;
    public Project getActualProject() {
        return actualProject;}
    @Test
    public void getProject() throws FileNotFoundException {

        Gson gson = new Gson();

        String pathToFile = ApiGetProjectTest.class.getClassLoader().getResource("expectedProject.json").getPath();
        FileReader reader = new FileReader(pathToFile);

        Project expectedProject = gson.fromJson(reader, Project.class);

        String json = gson.toJson(expectedProject);
        System.out.println(json);

        Response response = new ProjectAdapter().get(expectedProject);

        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);

        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");
        actualProject = gson.fromJson(respAsJsonElement, Project.class);

        logger.info("actualProject : " + actualProject.toString());
        logger.info("Expected project : " + expectedProject.toString());

        Assert.assertEquals(actualProject, expectedProject);
    }
}
