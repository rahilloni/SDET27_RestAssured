package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChaining {
	
	@Test
	public void requestChaining()
	{
		
		//getting the response
		Response resp = when()
			.get("http://localhost:8084/projects");
		
			//getting the project ID suing json path
		String proID=resp.jsonPath().get("[1].projectId");
		
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
