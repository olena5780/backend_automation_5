package api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APIAutomationSample {
    public static void main(String[] args) {

        /**
         * Response is an interface coming from the RestAssured Library
         * The Response variable "response" store all thr components of API calls
         * including the request and response
         *
         * RestAssured is written with BDD flow
         */
        Response response;
        Faker faker = new Faker();

        //Creating POST request
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .body("{\n" +
                        "    \"name\": \"" + faker.name().fullName() + "\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().post("https://gorest.co.in/public/v2/users")
                .then().log().all().extract().response();

        //System.out.println(response.asString());

        int postId = response.jsonPath().getInt("id");

        //Creating GET request for fetch specific user
        response =  RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .when().get("https://gorest.co.in/public/v2/users/"+ postId)
                .then().log().all().extract().response();

        // System.out.println(response.asString());

        //Creating GET request all users
        response =  RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .when().get("https://gorest.co.in/public/v2/users")
                .then().log().all().extract().response();

        // System.out.println(response.asString());

        //Creating PUT request to update existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .body("{\n" +
                        "    \"name\": \"" + faker.name().fullName() + "\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().put("https://gorest.co.in/public/v2/users/" + postId)
                .then().log().all().extract().response();


        //Creating PATCH request to update existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .body("{\n" +
                        "    \"name\": \"" + faker.name().fullName() + "\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().patch("https://gorest.co.in/public/v2/users/" + postId)
                .then().log().all().extract().response();

        int patchId = response.jsonPath().getInt("id");
        Assert.assertEquals(postId, patchId, "Expected id " + postId  + "we found " + patchId);


        //Creating DELETE request to delete existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer e00e5579f7601d1ea38d6caf977bf08d9e6100b2f61974d9ede925e8814aa3b6")
                .when().delete("https://gorest.co.in/public/v2/users/" + postId)
                .then().log().all().extract().response();

    }
}
