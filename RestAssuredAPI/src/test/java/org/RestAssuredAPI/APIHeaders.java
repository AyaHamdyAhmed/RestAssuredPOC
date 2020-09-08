package org.RestAssuredAPI;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import classes.API;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
@Epic("Test API Responses")
@Feature("Test Places")
public class APIHeaders {

	@Story("Check staus code based on zipcode")
	@Description("Verify get method status code")
    @Test
    public void requestUsZipCode90210_checkStatusCode() {

        given().
        when().
            get(API.url).
        then().
            assertThat().
               statusCode(200);
    }
    
	@Story("Check content type")
	@Description("verify API content Type")
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
