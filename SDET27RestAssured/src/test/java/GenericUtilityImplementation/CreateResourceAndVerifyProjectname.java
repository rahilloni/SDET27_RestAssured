package GenericUtilityImplementation;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateResourceAndVerifyProjectname extends BaseAPIClass{
	
	@Test
	public void VerifyProjectname() throws SQLException {
		
		//create test data
				PojoClass pojo=new PojoClass("Rahil", "Flipkart"+jlib.getRandomNum(), "Created", 70);
				
				//execute post request
				Response resp = given()
						.body(pojo)
						.contentType(ContentType.JSON)
				.when()
						.post(EndPoints.createProjects);
				
				//capture the project name from response
				String expData = rlib.getJSONdata(resp, "projectName");
				System.out.println(expData);
				
				//verify in db
				String query="select * from project;";
				String actualData = dlib.executeQueryAndGetData(query, 4, expData);

				Reporter.log(actualData,true);
				
				//validate
				Assert.assertEquals(expData, actualData);
				Reporter.log("data verified",true);
	}

}
