package org.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import classes.API;

import org.testng.annotations.Test;

public class ApiTest1NG {
	@Test
	public void requestUsZipCode90210_checkPlaceName() {
		given().
		when().
		 get(API.url).
		then().
		 assertThat().
		  body("places[0].'place name'", equalTo("Beverly Hills"));

	}
}
