package Authentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2 {
	
	@Test
	public void oauth() {
		
		Response resp = given()
				.formParam("client_id", "Rahil'sApp2")
				.formParam("client_secret", "8f8252f1a089c8391b9fef42d8b132bf")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
		.when()
				.post("http://coop.apps.symfonycasts.com/token");
				String token = resp.jsonPath().get("access_token");
				
		given()
				.auth().oauth2(token)
				.pathParam("USER_ID", "2779")
		.when()
				.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
				.log().all();
				
	}

}
