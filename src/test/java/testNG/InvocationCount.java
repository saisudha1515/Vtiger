package testNG;

import org.testng.annotations.Test;

/* If you want to run @Test more than one time then we have to use "invocationCount" flag
 * this invocationCount flag will not accept 0 or negative values because it is count so we have to give positive values only.
 * by default the invocation count is 1
 * when you do not give the invocation count by default it is 1 and the @Test will execute for 1 time.
 */
public class InvocationCount {
	@Test(invocationCount = 5)
	public void createCustomer() {
		System.out.println("Create");
	}

	@Test(invocationCount = 2)
	public void ModifyCustomer() {
		System.out.println("Modify");
	}

	@Test(priority = 1)
	public void updateCustomer() {
		System.out.println("update");
	}

	@Test
	public void AddCustomer() {
		System.out.println("add");
	}

	@Test
	public void removeCustomer() {
		System.out.println("remove");
	}

}
