package GenericUtilityImplementation;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class CreateResourceAndVerify extends BaseAPIClass{
	
	@Test
	public void createResourceAndVerify() throws SQLException{
		//create test data
		PojoClass pojo=new PojoClass("Rahil", "Amazon"+jlib.getRandomNum(), "Created", 50);
		
		//execute post request
		Response resp = given()
				.body(pojo)
				.contentType(ContentType.JSON)
		.when()
				.post(EndPoints.createProjects);
		//capture the project id form response
		String expData = rlib.getJSONdata(resp, "projectId");
		System.out.println(expData);
		
		//verify in db
		String query="select * from project;";
		String actualData = dlib.executeQueryAndGetData(query, 1, expData);

		Reporter.log(actualData,true);
		
		//validate
		Assert.assertEquals(expData, actualData);
		Reporter.log("data verified",true);
	}

}
