/**
 * SoftAssert class is SoftAssert and it is having non static methods which means we have to call them by using reference.
 * What are all methods the HardAssert is having the same methods are available in the SoftAssert but SoftAssert is having one extra method called "assertAll()"
 * In SoftAssertion, it will not stop/ terminates the execution(i.e, TestScript) when ever the Assertion failure has occured.
 * It will log all the assertions failures/errors/issues and fail the TestScript only when we call the assertAll()at the end of all Tests
 * For SoftAssert, assertAll() is mandatory because, then only the all the Assertion Failures got logged .(until then all the failures are recorded i.e, just making note of all failures but those failures are not getting logged..)
 * It will continue with the execution even if the Assertion failure occurs..
 * It is preferred to use for Non mandatory fields in the scence i.e, you want to run your TestScripts even if the assertion failure occurs. 
 * It will not point to the individual Assertion Failure always it will point to the assertAll()method. so again we need to do debugging to find the issue in each and every Assertion failure. So Debugging will be difficult when you go with SoftAssertion.
 * It is recommended to use HardAssert and Don't use -ve Assertions like assertNotEquals(), assertNotNull(), assetNotSame(), assertFalse()... because you will only get Confuse
 * In -ve Assertions will become -ve and vice a versa.
 * when you have 2 arguments use assertEquals() and When you have 1 argument use assertTrue() method..
 * we have to use assertAll() method at the end of all Tests then only it will log all the Assert failures. If you write assertAll() in between the Tests and suppose if the Assertion failures occurs after the assertAll() then those Assertion failures will not be logged..
 * 
 * 
 * We can use HardAssert and SoftAsset in the same program, syntactically it will not give you any error. But what ever you write after HardAsset that will not be executed..and when you do not write assertAll() then it will not log all the Assert failures in the TestScript..
 * assertEquals() method is overloaded method..
 * 
 * we have to use Assertions to perform validations at Scenario level not at Component or Step wise...
 */
package Assertions_Practice;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert_Practice {
	@Test
	public void softAssertPractice() {
		//case1: call assertAll() in between the program
		
//		SoftAssert sa = new SoftAssert();
//		System.out.println("step1");
//		sa.assertEquals('a','b');
//		System.out.println("step2");
//		sa.assertAll();    // All Assert failures are pointing to this assertAll() method.. and after this statement nothing will gonna execute..
//		Assert.assertEquals(1, 2);       
//		System.out.println("step3");
//		sa.assertTrue(false);
//		System.out.println("step4");

		//case2 : call the assertAll() method at the end of all Tests.
		
		SoftAssert sa = new SoftAssert();
		System.out.println("step1");
		sa.assertEquals('a','b');
		System.out.println("step2");
		Assert.assertEquals(1, 2);   // HardAssert and after this statement nothing will gonna execute.. it will stop/ terminates the execution..so assetAll() will not be called hence all Assertion failures will not gonna to be loggeed..there is no meaning of writing of this SoftAssertions then ..     
		System.out.println("step3");
		sa.assertTrue(false);
		System.out.println("step4");
		sa.assertAll();  
	}
}
