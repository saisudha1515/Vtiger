//Write the order of execution for basic configuration annotations with 2 @Test inside a class
package baseClassPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConfiguration1 { // here we have 2 @Test so @BeforeMethod and @AfterMethod annotation methods will execute 2 times

	@AfterClass
	public void ac() {
		System.out.println("AfterClass");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("BeforeMethod");
	}
	@Test
	public void test1() {
		System.out.println("@Test1");
	}

	@Test
	public void test2() {
		System.out.println("@Test2");
	}

	@BeforeSuite
	public void bs() {
		System.out.println("BeforeSuite");
	}

	@AfterSuite
	public void as() {
		System.out.println("AfterSuite");
	}

	@BeforeTest
	public void bt() {
		System.out.println("BeforeTest");
	}

	@AfterTest
	public void at() {
		System.out.println("AfterTest");
	}

	@BeforeClass
	public void bc() {
		System.out.println("BeforeClass");
	}

	@AfterMethod
	public void am() {
		System.out.println("AfterMethod");
	}
}

/** DEFAULT ORDER OF EXECUTION (Script lo ELA RASINA DEFAULT ORDER LO EXECUTE AVUTHAI)
 * ANSWER :: ignore @BeforeTest and @AfterTest because they act as a replacement of @BeforeClass and @AfterClass
 *@BeforeSuite
 *@BeforeClass
 *@BeforeMethod
 *@Test
 *@AfterMethod
 *@BeforeMethod
 *@Test
 *@AfterMethod
 *@AfterClass
 *@AfterSuite
 */
