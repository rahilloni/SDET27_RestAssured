package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	@Test
	public void pathAndQueryParam() {
		
		//we can add multiple path and query parameters
		given()
				.pathParams("username", "Rahil")	
				.queryParam("sort","created")
				.queryParams("type", "all")
		.when()
				.get("https://api.github.com/users/{username}/repos")
		
		.then()
				.assertThat().statusCode(200)
				.log().all();
		
		
	}

}
