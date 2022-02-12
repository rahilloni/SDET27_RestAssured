package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains methods required to connect to DB
 * @author Rahil
 *
 */
public class DatabaseUtility {
	
	/**
	 * this method will establish connection with DB
	 */
	Connection con=null;
	public void connectToDB() throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		con=DriverManager.getConnection(IConstants.DbURL, IConstants.DbUserName, IConstants.DbPass);
	}
	
	
	/***
	 * This method will execute query and return the data present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws SQLException {
		
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData+"===> Data Verified ");
			return expData;
		}
		else {
			System.out.println("Data not present");
			return "";
		}
	}
	
	public void closeConnectionToDB() throws SQLException {
		con.close();
	

	}
}
