package com.vtiger.GenericUtilities;
// A class can be called as Generic class which consists of Generic methods...
// this is generic class which consists of generic methods

import java.io.FileInputStream;
import java.util.Properties;



/**This class consists of Generic methods related to property file
 * @author Saisudha D
 */
public class PropertyFileUtility {  
	/**
	 * This method will read data from Property file and return the value to caller
	 * @param PropertyFileKey
	 * @return
	 * @throws Throwable
	 */
	public String readFromDataFromPropertyFile(String PropertyFileKey) throws Throwable {  // get PropertyFileKey from the caller 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(PropertyFileKey);
		return value;   // return the value to the caller
	}
}
