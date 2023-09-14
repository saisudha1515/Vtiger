package com.vtiger.GenericUtilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of reusable methods related to Java
 * 
 * @author Saisudha D
 */
public class JavaUtility {
	/**
	 * This method will return a random number for every execution
	 * @return 
	 */
	public int getRandomNumber() {
		Random r = new Random();  // if you parameterize the bound value you can do but for every time we no need to give the bounds so, i am not parameterizing the bound value.
		return r.nextInt(1000);   // i am directly returning the value not storing the reference..

	}
	/**
	 * This method will generate the current system date in specified format
	 * @return DATE 
	 */
	public String getSystemDate() {
		Date date = new Date();  // this Date class will capture the current/system date 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");// in SimpleDateFormat class we need to pass the your required date format..  Small M is minute, and Capital M is Month
		String DATE = formatter.format(date); //format()method will format/convert the captured date into the specified date format
		return DATE;
	}
}
