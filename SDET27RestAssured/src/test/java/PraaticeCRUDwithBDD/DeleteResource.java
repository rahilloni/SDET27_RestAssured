package PraaticeCRUDwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteResource {
	
	@Test
	public void deleteResource() {
		
		when()
				.delete("http://localhost:8084/projects/TY_PROJ_405")
		
		.then()
				.assertThat().statusCode(204)
				.log().all();
		
				}

}
