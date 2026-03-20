package samples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Sample: REST API testing with RestAssured.
 * Uses https://jsonplaceholder.typicode.com as a public test API.
 */
public class RestApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test(description = "GET request - fetch all users")
    public void testGetUsers() {
        given()
            .when()
                .get("/users")
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0))
                .body("[0].name", notNullValue());

        Reporter.log("GET /users returned successfully", true);
    }

    @Test(description = "GET request - fetch single user by ID")
    public void testGetUserById() {
        given()
            .pathParam("id", 1)
            .when()
                .get("/users/{id}")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("email", notNullValue());
    }

    @Test(description = "POST request - create a new post")
    public void testCreatePost() {
        String requestBody = "{"
                + "\"title\": \"Test Post\","
                + "\"body\": \"This is a test post body\","
                + "\"userId\": 1"
                + "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post("/posts")
            .then()
                .statusCode(201)
                .body("title", equalTo("Test Post"))
                .body("id", notNullValue())
                .extract().response();

        Reporter.log("Created post with ID: " + response.jsonPath().getInt("id"), true);
    }

    @Test(description = "PUT request - update a post")
    public void testUpdatePost() {
        String requestBody = "{"
                + "\"id\": 1,"
                + "\"title\": \"Updated Title\","
                + "\"body\": \"Updated body content\","
                + "\"userId\": 1"
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
                .put("/posts/1")
            .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title"));
    }

    @Test(description = "DELETE request - delete a post")
    public void testDeletePost() {
        given()
            .when()
                .delete("/posts/1")
            .then()
                .statusCode(200);

        Reporter.log("DELETE /posts/1 returned 200", true);
    }

    @Test(description = "Query parameters - filter posts by userId")
    public void testQueryParams() {
        given()
            .queryParam("userId", 1)
            .when()
                .get("/posts")
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("userId", everyItem(equalTo(1)));
    }

    @Test(description = "Response time validation")
    public void testResponseTime() {
        long responseTime = given()
            .when()
                .get("/users")
            .then()
                .statusCode(200)
                .extract().time();

        Assert.assertTrue(responseTime < 5000, "Response should be under 5 seconds");
        Reporter.log("Response time: " + responseTime + "ms", true);
    }
}
