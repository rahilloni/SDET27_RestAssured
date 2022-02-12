package ResponseVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void verify() {
		
	String expectedResp="Wipro";
	Response resp = when()
		.get("http://localhost:8084/projects");
	
	
	String actualResp = resp.jsonPath().get("[0].projectName");
	
	resp.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	
	Assert.assertEquals(expectedResp, actualResp);
	
	}

}
