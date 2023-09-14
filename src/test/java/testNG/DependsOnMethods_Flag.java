package testNG;

import org.testng.Assert;
/**
 * dependsOnMethods flag is used to skip a particular test case for avoid the time wastage of checking the dependent methods execution..
 * If the dependent method is got failed then the @Test which are dependent on this will also get skipped.. If you run those test cases also unnecessarily the time is getting wasted..so, if any one dependent method got failed the its dependent methods should not be executed it has to be skipped in order to save the execution time..
 * Skipped means, the @Test will be included in the current total @Test execution..and it will give the status as Skipped but in case of disabled @Test methods those will not be included in the total @Test runs..particular test case will not get executed..here we never get the status as skipped like that..
 */
import org.testng.annotations.Test;

public class DependsOnMethods_Flag {
	@Test
	public void createCustomer() {
		System.out.println("create");
	}

	@Test(dependsOnMethods = "createCustomer") // modifyCustomer()execution is depending on the createCustomer() method execution
	public void modifyCustomer() {
		Assert.fail();  // Intentionally if you want to fail your @Test(in this you will get "Assertion Exception") in order to analyze the behavior of the application and the remaining @Test ( because we do not create a bug and then can't identify the behavior of the application)
		System.out.println("modify");
	}

	@Test
	public void deleteCustomer() {
		System.out.println("delete");
	}
	
	@Test(dependsOnMethods = {"modifyCustomer","deleteCustomer"})  // dependsOnMethods flag is accepting String[] array.. which means the execution of one @Test depends on another one/multiple @Test methods..
	public void addCustomer() {
		System.out.println("add");
	}

}
