package PracticeCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_203");
		int exptStatus=204;
		
		int actualStatus = resp.getStatusCode();
		
		Assert.assertEquals(exptStatus, actualStatus);
		System.out.println(resp.prettyPrint());
	}

}
