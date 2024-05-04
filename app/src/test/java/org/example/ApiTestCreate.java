package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;;

public class ApiTestCreate {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        RestAssured.basePath = "/user";
    }

    // TC01: Input data valid dan belum ada di sistem, dengan input field title "mr"
    @Test
    public void testCreateUserWithTitleMr() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Alex\",\n" +
                "  \"lastName\": \"Gonzales\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"alex.gonzales1@example.com\",\n" +
                "  \"dateOfBirth\": \"1990-01-01\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"picture\": \"http://example.com/picture.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"+7:00\"\n" +
                "  }\n" +
                "}";

        given()
                .header("app-id", "662718606cae037669dee7b6")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/create")
        .then()
                .statusCode(200);
    }

    // TC02: Input data valid dan belum ada di sistem, dengan input field firstName berupa string dengan length 2 - 50
    @Test
    public void testCreateUserWithValidFirstNameLength() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Johnathan\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"johnathandoe1@example.com\",\n" +
                "  \"dateOfBirth\": \"1985-07-15\",\n" +
                "  \"phone\": \"777777777\",\n" +
                "  \"picture\": \"http://example.com/picture6.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"303 Oak St\",\n" +
                "    \"city\": \"San Francisco\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"-7:00\"\n" +
                "  }\n" +
                "}";

        given()
                .header("app-id", "662718606cae037669dee7b6")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/create")
        .then()
                .statusCode(200);
    }

    // TC03: Input data valid dan belum ada di sistem, dengan input field email berupa string
    @Test
    public void testCreateUserWithValidEmail() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Johnie\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"johniedoe1@example.com\",\n" +
                "  \"dateOfBirth\": \"1987-11-20\",\n" +
                "  \"phone\": \"666666666\",\n" +
                "  \"picture\": \"http://example.com/picture8.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"505 Maple St\",\n" +
                "    \"city\": \"Miami\",\n" +
                "    \"state\": \"FL\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"-5:00\"\n" +
                "  }\n" +
                "}";

        given()
                .header("app-id", "662718606cae037669dee7b6")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/create")
        .then()
                .statusCode(200);
    }

    // TC04: Input data valid dan belum ada di sistem dengan email sudah terdaftar dalam sistem
    @Test
    public void testCreateUserWithExistingEmail() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"johndoe1@example.com\",\n" +
                "  \"dateOfBirth\": \"1990-01-01\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"picture\": \"http://example.com/picture.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"+7:00\"\n" +
                "  }\n" +
                "}";

        given()
                .header("app-id", "662718606cae037669dee7b6")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/create")
        .then()
                .statusCode(400)
                .body("error", equalTo("BODY_NOT_VALID"))
                .body("data.email", equalTo("Email already used"));
    }

    // TC05: Input data valid dan belum ada di sistem, dengan input field phone berupa string (phone number - any format)
    @Test
    public void testCreateUserWithValidPhoneNumber() {
        String requestBody = "{\n" +
                "  \"title\": \"miss\",\n" +
                "  \"firstName\": \"Janneth\",\n" +
                "  \"lastName\": \"Stuart\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"janneth.stuart1@example.com\",\n" +
                "  \"dateOfBirth\": \"1990-01-01\",\n" +
                "  \"phone\": \"123-456-7890\",\n" +
                "  \"picture\": \"http://example.com/picture1.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"+7:00\"\n" +
                "  }\n" +
                "}";

        given()
                .header("app-id", "662718606cae037669dee7b6")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/create")
        .then()
                .statusCode(200)
                .body("title", equalTo("miss"))
                .body("firstName", equalTo("Janneth"))
                .body("lastName", equalTo("Stuart"))
                .body("email", equalTo("janneth.stuart1@example.com"))
                .body("phone", equalTo("123-456-7890"));
    }
}