package org.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
@Epic("Test API Responses")
@Feature("Test Places")
public class APiWithDP {

	@DataProvider(name= "zipCodesWithPlaces")
	public static Object[][] zipCodesWithPlaces() {
        return new Object[][] {
            { "us", "90210", "Beverly Hills" },
            { "us", "12345", "Schenectady" },
            { "ca", "B2R", "Waverley"},
            {"nl", "1001", "Amsterdam"}
        };
    }
	
	@Step("Check place Name for: {0} & {1}")
	@Test(dataProvider = "zipCodesWithPlaces")
	public void checkplaceName(String Countrycode, String ZipCode, String ExpectedPlaceName) {
		given().
		pathParam("CountryCode", Countrycode).pathParam("ZipCode", ZipCode).
		when().
		 get("http://zippopotam.us/{CountryCode}/{ZipCode}").
		then().assertThat().
		  body("places[0].'place name'", equalTo(ExpectedPlaceName));
	}
	
}
