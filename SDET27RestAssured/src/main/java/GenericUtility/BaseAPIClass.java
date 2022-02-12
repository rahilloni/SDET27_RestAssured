package GenericUtility;
/**
 * 
 * @author Rahil
 *
 */

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseAPIClass {
	
	public DatabaseUtility dlib=new DatabaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		baseURI="http://localhost";
		port=8084;
		
		dlib.connectToDB();
		System.out.println("====Connection Established=====");
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
	
		dlib.closeConnectionToDB();
		
		System.out.println("===DB connection closed===");
		
	}

}
