//Write the order of execution for basic configuration annotations with 2 @Test inside a class and 1 @Test in another class..
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

public class AnnotationsConfiguration3 {
	@Test
	public void test4() {
		System.out.println("@Test4");
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

	@AfterClass
	public void ac() {
		System.out.println("AfterClass");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	public void am() {
		System.out.println("AfterMethod");
	}
}
/** DEFAULT ORDER OF EXECUTION (Script lo ELA RASINA DEFAULT ORDER LO EXECUTE AVUTHAI)
 *  ANSWER ::  ignore @BeforeTest and @AfterTest because they act as a replacement of @BeforeClass and @AfterClass
 * @BeforeSuite
 * @BeforeClass
 * @BeforeMethod
 * @Test
 * @Aftermethod
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * @AfterClass
 * @BeforeClass
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * @AfterClass
 * @AfterSuite
 * 
 * 
 */
