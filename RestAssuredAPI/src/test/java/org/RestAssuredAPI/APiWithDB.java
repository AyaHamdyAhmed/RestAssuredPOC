package org.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class APiWithDB {

	@DataProvider(name= "zipCodesWithPlaces")
	public static Object[][] zipCodesWithPlaces() {
        return new Object[][] {
            { "us", "90210", "Beverly Hills" },
            { "us", "12345", "Schenectady" },
            { "ca", "B2R", "Waverley"},
            {"nl", "1001", "Amsterdam"}
        };
    }
	
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
