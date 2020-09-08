package org.RestAssuredAPI;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

@Epic("Test API Responses")
@Feature("Test Places")
public class APIsTestWithCleanCode {

	private static RequestSpecification reqSpec;
	
  @BeforeClass
  private static void createRequestSpecs() {
	  reqSpec = new RequestSpecBuilder().setBaseUri("http://zippopotam.us").build();
  }

  @Test
  public void CheckReqestStatusCode() {
	given().
     spec(reqSpec).
    when().
     get("us/90210").
    then().
     assertThat().
      statusCode(200);
   }

  private static ResponseSpecification responseSpec;

  @Test
  public static void createResponseSpecification() {

      responseSpec = new ResponseSpecBuilder().
          expectStatusCode(200).
          expectContentType(ContentType.JSON).
          build();
  }

  @Test
  public void checkPlaceNameInResponseBody_withResponseSpec() {

      given().
          spec(reqSpec).
      when().
          get("http://zippopotam.us/us/90210").
      then().
          spec(responseSpec).
      and().
          assertThat().
          body("places[0].'place name'", equalTo("Beverly Hills"));
  }

  @Test
  public void extractPlaceNameFromResponseBody() {

      String placeName =

      given().
          spec(reqSpec).
      when().
          get("http://zippopotam.us/us/90210").
      then().
          extract().
          path("places[0].'place name'");
      // here after the API response extraction i can compare it with the DB values after opening a connection with it
      Assert.assertEquals("Beverly Hills", placeName);
}
}
