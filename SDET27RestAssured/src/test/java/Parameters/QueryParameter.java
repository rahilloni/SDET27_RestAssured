package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {
	
	@Test
	public void queryParam() {
		
	
		given()
				.queryParams("page","2")
		.when()
				.get("https://reqres.in/api/users")
				
		.then()
				.assertThat().statusCode(200)
				.log().all();
		}

}
