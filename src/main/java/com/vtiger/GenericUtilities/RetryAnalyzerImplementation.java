package com.vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyzer interface of TestNg
 * @author Saisudha D
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer{   // here we have only one unimplemented method..i.e, retry() method

	@Override
	public boolean retry(ITestResult result) {
		int count = 0;
		int retryCount = 2;
		while(count < retryCount) {  //if the condition is satisfied then loop will run else loop will not run.. 
			count++;
			return true;
		}
		return false;  // loop will be terminated..
	}

}
