package ResponseVerification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingDataProvider {
	
	@Test(dataProvider = "getData")
	public void create(String createdBy, String projectName, String status, int teamSize) {
		PojoClass pobj=new PojoClass(createdBy, projectName, status, teamSize);
		given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[2][4];
		
		objArr[0][0]="Priya darshini";
		objArr[0][1]="CCD22";
		objArr[0][2]="completed";
		objArr[0][3]=50;
		
		objArr[1][0]="Abdul basit";
		objArr[1][1]="Aspire 5";
		objArr[1][2]="completed";
		objArr[1][3]=66;
		
		return objArr;
		
	}

}


