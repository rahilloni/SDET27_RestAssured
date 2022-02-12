package ResponseVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	public void verify() {
		
		String ExpectedProjectName="Wipro";
		Response resp = when()
		.get("http://localhost:8084/projects");
		
		List<String> proNames = resp.jsonPath().get("projectName");
		boolean flag=false;
		for( String names:proNames)
		{
			if(names.equals(ExpectedProjectName))
			{
				flag=true;
			}
		}
		
		resp.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		Assert.assertEquals(flag, true);
		
	}

}
