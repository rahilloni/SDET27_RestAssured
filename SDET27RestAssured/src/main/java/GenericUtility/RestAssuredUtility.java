package GenericUtility;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

/**
 * This class contains generic methods specific to Rest Assured
 * @author Rahil
 *
 */

public class RestAssuredUtility {
	
	/**
	 * This method will return the JSON data for the given Json path
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	
	public String getJSONdata(Response resp, String jsonPath) {
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
	}
	

}
