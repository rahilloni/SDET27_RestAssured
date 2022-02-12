package ResponseVerification;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseUsingHamcrest {
	
	@Test 
	public void verify() {
		
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
