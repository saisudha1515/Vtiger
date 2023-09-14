package testNG;

/**   PRIORITY  FLAG/TEST PARAMETER
 * By default the test cases will be executed in alphabetical order i.e, based on ASCII values. Capital letters have the lower values and smaller values have the higher values.
 * we can give negative values are as priority. By default the priority is 0.
 * always the lowest priority will be executed first
 * we can execute the test cases based on our priority by using "Priority" flag.. we have to use this flag with "@Test" annotation
 * If you want to run all @Test(TestMethods) click on "Run All" at class level then all TestMethods of that class will run..
 */
import org.testng.annotations.Test;

public class PriorityFlag {    // click on "Run All" to run all TestMethods of the class
	@Test(priority = 6)
	public void createCustomer() {
		System.out.println("Create");
	}

	@Test(priority = -10)
	public void ModifyCustomer() {
		System.out.println("Modify");
	}

	@Test(priority = -19)
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
	@Test
	public void closeCustomer() {
		System.out.println("close");
	}
}
