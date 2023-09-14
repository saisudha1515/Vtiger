package testNG;
/*
 *  enabled flag by default value is "true"
 *  we can disable the @Test in 2 ways(disable means we don not want to particular @Test right now and it will not included in the current execution/ total @Test runs)
 *    1.by giving invocationCount as 0 or negative value 
 *    2.by giving "enabled = false"---> @Test(enabled = false)
 *  If you do not specify anything the default value of enabled is "true"
 */

import org.testng.annotations.Test;

public class EnabledFlag {
	@Test
	public void createCustomer() {
		System.out.println("create");
	}

	@Test(enabled = false)
	public void modifyCustomer() {
		System.out.println("modify");
	}

	@Test(enabled = false)
	public void deleteCustomer() {
		System.out.println("delete");
	}

	@Test(enabled = true) // even you do not give "enabled = true" also it will considered as enabled as "true" because the default value of enabled is "true"..
	public void updateCustome() {
		System.out.println("update");
	}
}
