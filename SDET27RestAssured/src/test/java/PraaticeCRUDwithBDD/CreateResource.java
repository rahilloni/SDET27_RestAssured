package PraaticeCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResource {
	
	@Test
	public void createResouce() {
		
		Random ran= new Random();
		int randomNumber = ran.nextInt(1000);
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Zuber");
		jobj.put("projectName", "Sparks"+randomNumber);
		jobj.put("status", "Created");
		jobj.put("teamSize", 70);
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
		
		.when()
				.post("http://localhost:8084/addProject")
				
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
	}

}
