package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    public Response add(Project expectedProject) {

        return given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();
    }

    public Response getAllProjects() {

        return given()
                .get(Endpoints.GET_AllPROJECTS)
                .then()
                .log().body()
                .extract().response();
    }

    public Response get(Project expectedProject){
        int projectId = 3;
        return given()
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
    }
}
