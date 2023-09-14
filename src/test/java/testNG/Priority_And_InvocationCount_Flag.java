package testNG;

import org.testng.annotations.Test;

/**
 * Always "Priority" flag will be given first priority if you combine any 2/3/4
 * Flags in @Test annotation here we are combining Priority and invocationCount
 * flags so from these 2 flags 1st Priority will be executed and 2nd invocation
 * count will be executed.
 * 
 */
public class Priority_And_InvocationCount_Flag {
	@Test(priority = 6, invocationCount = 3)
	public void createCustomer() {
		System.out.println("Create");
	}

	@Test(invocationCount = 5, priority = -10)
	public void ModifyCustomer() {
		System.out.println("Modify");
	}

	@Test(invocationTimeOut = 2, priority = -19)
	public void updateCustomer() {
		System.out.println("update");
	}

	@Test(priority = 2)
	public void AddCustomer() {
		System.out.println("add");
	}

	@Test(priority = 1)
	public void removeCustomer() {
		System.out.println("remove");
	}

	@Test(invocationCount = 4)
	public void closeCustomer() {
		System.out.println("close");
	}
}
