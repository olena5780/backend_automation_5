package api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class APIAutomationTechGlobal {
    public static void main(String[] args) {

        Response response;
        Faker faker = new Faker();

        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstName\": \"" + faker.name().firstName() + "\",\n" +
                        "    \"lastName\": \"" + faker.name().lastName() + "\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"dob\": \"2020-01-20\"\n" +
                        "}")
                .when().post("https://tech-global-training.com/students")
                .then().log().all().extract().response();





      int postId = response.jsonPath().getInt("id");

        //Creating GET request for fetch specific user

        response =  RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .when().get("https://tech-global-training.com/students/"+ postId)
                .then().log().all().extract().response();



        //Creating GET request all users
        response =  RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .when().get("https://tech-global-training.com/students")
                .then().log().all().extract().response();



       //Creating PUT request to update existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstName\": \"" + faker.name().firstName() + "\",\n" +
                        "    \"lastName\": \"" + faker.name().lastName() + "\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"dob\": \"2020-01-20\"\n" +
                        "}")
                .when().put("https://tech-global-training.com/students/" + postId)
                .then().log().all().extract().response();


        //Creating PATCH request to update existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstName\": \"" + faker.name().firstName() + "\",\n" +
                        "    \"lastName\": \"" + faker.name().lastName() + "\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"dob\": \"2020-01-20\"\n" +
                        "}")
                .when().patch("https://tech-global-training.com/students/" + postId)
                .then().log().all().extract().response();

        int patchId = response.jsonPath().getInt("id");
        Assert.assertEquals(postId, patchId, "Expected id " + postId  + "we found " + patchId);


        //Creating DELETE request to delete existing user
        response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .when().delete("https://tech-global-training.com/students/" + postId)
                .then().log().all().extract().response();



    }



}
