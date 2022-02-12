package PracticeCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test
	public void getSingleProject() {
		
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_203");
		int expStatus=200;
		
		System.out.println(resp.prettyPrint());
		int actualStatus = resp.getStatusCode();
		Assert.assertEquals(expStatus, actualStatus);
		
	}

}
