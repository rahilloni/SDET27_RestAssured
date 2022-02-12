package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameters {
	
	@Test
	public void pathParam() {
		
		given()
				.pathParam("projectId", "TY_PROJ_414")
				
		.when()
				.get("http://localhost:8084/projects/{projectId}")   
				
		.then()
				.log().all();
	
	}

}
