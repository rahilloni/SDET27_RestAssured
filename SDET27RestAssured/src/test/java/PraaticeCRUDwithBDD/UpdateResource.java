package PraaticeCRUDwithBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateResource {
	
	@Test
	public void updateResouce() {
		
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Zuber");
		jobj.put("projectName", "acer");
		jobj.put("status", "Created");
		jobj.put("teamSize", 70);
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
		
		.when()
				.put("http://localhost:8084/projects/TY_PROJ_405")
				
		.then()
				.assertThat().statusCode(200)
				.contentType(ContentType.JSON)
				.log().all();
	}

}
