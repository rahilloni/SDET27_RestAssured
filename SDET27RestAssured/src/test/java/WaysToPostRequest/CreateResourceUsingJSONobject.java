package WaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJSONobject {
	
	@Test
	public void createResource() {
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rahilloni");
		jobj.put("projectName", "Nike");
		jobj.put("status", "completed");
		jobj.put("teamSize", 15);
		
		given()
				.contentType(ContentType.JSON)
				.body(jobj)
		.when()
				.post("http://localhost:8084/addProject")
		.then()
				.assertThat().contentType(ContentType.JSON)
				.statusCode(201)
				.log().all();
		
				
		
		
	}

}
