package tests.api;

import baseEntities.BaseApiTest;

import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ApiGetTestUsers extends BaseApiTest {
static Logger logger = LogManager.getLogger(ApiGetTestUsers.class);
   //Gson gson = new Gson();
    @Test
    public void GetUsers(){
        String endpoint = "/api/v1/users";

        given()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

   /* @Test
    public void GetUser(){

        String endpoint = "/api/v1/users/{userId}";

        //int userID = 1;

        User expectedUser = User.builder()
                .firstName("Hanna").lastName("Behanskaya")
                .email("atrostyanko@gmail.com")
                .password("Julia+Anna1")
                .userId(1)
                .admin(true)
                .build();

        User actualUser = given()
                .pathParam("userId", 1)
                .get(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUser.toString());
        Assert.assertNotEquals(expectedUser, actualUser);
    }*/
    }

