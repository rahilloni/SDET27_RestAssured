package PracticeCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	public void getAllProjects() {
		
		Response resp = RestAssured.get("http://localhost:8084/projects");
		int expectedStatus = 200;
		
		System.out.println(resp.prettyPrint());
		int actualStatus = resp.getStatusCode();
		Assert.assertEquals(expectedStatus, actualStatus);
	}

}
