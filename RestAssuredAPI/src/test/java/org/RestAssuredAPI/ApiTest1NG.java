package org.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import classes.API;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import org.testng.annotations.Test;
@Epic("Test API Responses")
@Feature("Test Places")
public class ApiTest1NG {
	
	@Test
	public void requestUsZipCode90210_logRequestAndResponseDetails() {
		given().log().all().
		when().
		 get(API.url).
		then().log().
		  body();
	}
	
	@Test
	public void requestUsZipCode90210_checkCountryName() {
		given().
		when().
		 get(API.url).
		then().assertThat().
		  body("country", equalTo("United States"));
	}
	
	@Test
	public void requestUsZipCode90210_checkListOfPlacesName() {
		given().
		when().
		 get(API.url).
		then().
		 assertThat().
		  body("places.'place name'", hasItem("Beverly Hills"));
	}
	
	@Test
	public void requestUsZipCode90210_checkTheNumberOfPlaces() {
		given().
		when().
		 get(API.url).
		then().
		 assertThat().
		  body("places.'place name'", hasSize(1));
	}
	
	@Test
	public void requestUsZipCode90210_checkPlaceState() {
		given().
		when().
		 get(API.url).
		then().
		 assertThat().
		  body("places[0].'state'", equalTo("California"));
	}

}
