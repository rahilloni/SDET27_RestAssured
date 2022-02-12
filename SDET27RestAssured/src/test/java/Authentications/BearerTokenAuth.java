package Authentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerTokenAuth {
	
	@Test
	public void bearerToken() {
		
		given()
			.auth().oauth2("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")
		
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
	}

}
