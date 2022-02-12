package WaysToPostRequest;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingPOJOclass {
	
	@Test
	public void createResourceUsingPOJO() {
		
		PojoClass pobj=new PojoClass("Deepak", "intel", "completed", 15);
		
		
		given()
		      .body(pobj)
		      .contentType(ContentType.JSON)
		 
		.when()
				.post("http://localhost:8084/addProject")
		
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
	}

}
