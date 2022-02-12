package Parameters;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingPostAndDelete {
	
	@Test
	public void postAndDelete() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Alina");
		jobj.put("projectName", "Suki");
		jobj.put("status", "created");
		jobj.put("teamSize", 25);
		
		given()
				.body(jobj);
		
		//Creating the response
		Response resp = when()
				.post("http://localhost:8084/addProject");

		//getting the project ID suing json path
		String proID=resp.jsonPath().get(".projectId");
				
		//deleting using pathparam
				given()
						.pathParam("projectId", proID)
				.when()
						.delete("http://localhost:8084/projects/{projectId}")
				.then()
						.assertThat().statusCode(204)
						.log().all();
		
	
	}

}
