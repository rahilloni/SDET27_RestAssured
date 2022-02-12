package GenericUtility;

import java.util.Random;

/**
 * This class contains Java specific generic methods
 * @author Rahil
 *
 */
public class JavaUtility {
	/**
	 * Generate random number
	 * @return
	 */
	
	public int getRandomNum() {
		
		Random ran=new Random();
		int randomNum = ran.nextInt(1000);
		return randomNum;
	}
	

}
