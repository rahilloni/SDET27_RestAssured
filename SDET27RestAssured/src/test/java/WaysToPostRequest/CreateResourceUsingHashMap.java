package WaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingHashMap {

	@Test
	public void createResourceUSingHashMap() {
	
		
		HashMap map=new HashMap();
		
		map.put("createdBy", "NIhal");
		map.put("projectName", "Renew Power");
		map.put("status","completed");
		map.put("teamSize", 25);

		given()
				.contentType(ContentType.JSON)
				.body(map)
		.when()
				.post("http://localhost:8084/addProject")
		
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
		
	}
}
