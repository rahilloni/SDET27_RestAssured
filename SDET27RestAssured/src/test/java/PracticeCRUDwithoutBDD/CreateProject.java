package PracticeCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
	
		//create test data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rozik2");
		jobj.put("projectName", "Nykaa2");
		jobj.put("status", "Created");
		jobj.put("teamSize", 50);
		
		//provide request specification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//perform action
		Response res = req.post("http://localhost:8084/addProject");
		
		//print on the console and verify
		System.out.println(res.prettyPrint());
		System.out.println(res.getStatusCode());
		
		//verify
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		}

}
