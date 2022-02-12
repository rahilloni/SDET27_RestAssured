package WaysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJSONfile {
	
	@Test
	public void createResourceUsingJSONfile() {
		
		File f=new File("./restAssured.json");
		
		given()
				.body(f)
				.contentType(ContentType.JSON)
		
		.when()
				.post("http://localhost:8084/addProject")
		.then()
			    .assertThat().statusCode(201)
			    .contentType(ContentType.JSON)
			    .log().all();
	}

}
