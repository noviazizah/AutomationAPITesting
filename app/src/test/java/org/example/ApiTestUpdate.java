package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;;

public class ApiTestUpdate {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        RestAssured.basePath = "/user";
    }

    //TC1 Update data tanpa authorization dengan id valid
    @Test
    public void testUpdateValidUserIdAndNullAppId() {
        given()
                .header("app-id", "")
                .pathParam("userId", "60d0fe4f5311236168a109ca") // User ID valid dan terdaftar
        .when()
                .put("/{userId}")
        .then()
                .statusCode(403); // Unauthorized
    }

    //TC2 Update data tanpa authorization dengan id tidak valid
    @Test
    public void testUpdateInvalidUserIdAndNullAppId() {
        given()
                .header("app-id", "")
                .pathParam("userId", "60d0fe4f5311236168a109ca") // User ID valid dan terdaftar
        .when()
                .put("/{userId}")
        .then()
                .statusCode(403); // Unauthorized
    }

    //TC3 Update data dengan field 'title' valid
    @Test
    public void testUpdateFieldTitleValid() {
        String requestBody = "{\n" +
                "  \"title\": \"miss\"\n" +
                "}";

        given()
                .header("app-id", "66271b536cae0377a3dee7c6")
                .pathParam("userId", "60d0fe4f5311236168a109ca")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .put("/{userId}")
        .then()
                .statusCode(200)
                .body("id", equalTo("60d0fe4f5311236168a109ca"))
                .body("title", equalTo("miss"));
    }

    //TC4 Update data dengan field 'firstName' valid
    @Test
    public void testUpdateFieldFirstNameValid() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Suzy\"\n" +
                "}";

        given()
                .header("app-id", "66271b536cae0377a3dee7c6")
                .pathParam("userId", "60d0fe4f5311236168a109ca")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .put("/{userId}")
        .then()
                .statusCode(200)
                .body("id", equalTo("60d0fe4f5311236168a109ca"))
                .body("title", equalTo("miss"))
                .body("firstName", equalTo("Suzy"));
    }

    //TC5 Update data dengan field ' lastName' valid
    @Test
    public void testUpdateFieldLastNameValid() {
        String requestBody = "{\n" +
                "  \"lastName\": \"Bae\"\n" +
                "}";

        given()
                .header("app-id", "66271b536cae0377a3dee7c6")
                .pathParam("userId", "60d0fe4f5311236168a109ca")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .put("/{userId}")
        .then()
                .statusCode(200)
                .body("id", equalTo("60d0fe4f5311236168a109ca"))
                .body("title", equalTo("miss"))
                .body("firstName", equalTo("Suzy"))
                .body("lastName", equalTo("Bae"));
    }
}