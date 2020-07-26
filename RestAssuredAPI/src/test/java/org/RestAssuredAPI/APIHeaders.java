package org.RestAssuredAPI;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import classes.API;
import io.restassured.http.ContentType;

public class APIHeaders {

    @Test
    public void requestUsZipCode90210_checkStatusCode() {

        given().
        when().
            get(API.url).
        then().
            assertThat().
               statusCode(200);
    }
    
    @Test
    public void requestUsZipCode90210_checkContentType() {

        given().
        when().
            get(API.url).
        then().
            assertThat().contentType(ContentType.JSON);
        // we can use  assertThat().contentType("application/json"); as postman
    }
}
