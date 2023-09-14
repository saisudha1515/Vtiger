package reTryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;
// "iretry analyzer" will be mostly used for B2C applications (i.e, in e-commerce applications)
public class RetryAnalyzerPractice {
	@Test(retryAnalyzer = com.vtiger.GenericUtilities.RetryAnalyzerImplementation.class)
	public void sample() {
		Assert.fail();  // perposefully we are failng the TestScript to invoke the RetryAnalyzer (to know how it will behave when script got failed.)
		System.out.println("Hello");
	}
}
