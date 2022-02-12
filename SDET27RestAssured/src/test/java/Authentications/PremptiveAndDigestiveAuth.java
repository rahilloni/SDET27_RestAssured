package Authentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PremptiveAndDigestiveAuth {
	@Test
	public void premptiveAuth() {
		
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.log().all();	
	}
	
	@Test
	public void digestiveAuth() {
		
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
			
			.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.log().all();	
	}

}
