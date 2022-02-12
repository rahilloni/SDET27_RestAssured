package PracticeCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rozik2");
		jobj.put("projectName", "Nykaa2");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 50);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_203");
		
		//print on the console and verify
		System.out.println(res.prettyPrint());
		System.out.println(res.getStatusCode());
		
		//verify
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
