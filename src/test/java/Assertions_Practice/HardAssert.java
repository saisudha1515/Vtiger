/**
 * ifelse does not have the capability to fail the TestScript whenever the condition is failed so due to which we can't use ifelse for validations(validation means comparing actual and expected results)
 * ifelse will print fail but it will not fail the TestCase when the condition is failed..
 * But Assertions have the capability to fail the TestScript when ever the condition is not satisfied.
 * Assertions are of 2 types
 *   -- 1. HardAssert
 *   --2. SoftAssert
 *   
 * HardAssert:
 * It is a static class so we can access the methods of this class by using it's class name and the methods available in this class are 
 *   -- Assert.assertEquals()
 *   --.assertNotEquals()
 *   --.assertSame()
 *   --.assertNotSame()
 *   --.asseryNull()
 *   --.assertNotNull()
 *   --.assertTrue()
 *   --.assertFalse()
 *   --Assert.fail()
 * In HardAssert whenever the assertion failure occurs, three things will happen 
 *   --1. It will stop the execution
 *   --2. Throw the Assertion Error
 *   --3. Point to the failure line (i.e, in which line the assertion got failed)
 * Use HardAssert for Critical/Mandatory fields validations..
 * 
 */
package Assertions_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void hardAssertPractice() {
		// By Using ifelse:

//		System.out.println("Execution Started ");
//		if (1 == 0) {
//			System.out.println("Condition is satisfied ");
//		}
////		else {
////			System.out.println("Condition is failed ");
////		}
//		System.out.println("Execution ended ");

	//=======================================	
		
		String name = "SaisudhaSreevasthava";
//		System.out.println("Execution is started ");
//		if (name.contains("Sreesai")) {
//			System.out.println("condition is satisfied ");
////		} else {
////		System.out.println("conditon is failed");
////		}
//		System.out.println("Execution is ended ");
		
		// By Using HardAssert
//		if (name.contains("Sree")) {
//			System.out.println("condition is satisfied ");
//			Assert.assertEquals("Sai", "saii");
//			System.out.println("Hi i am here ");
//			System.out.println("I am in ATP");
//		} 
////		else {
////			System.out.println("conditon is failed");
////		}
//		System.out.println("Execution is ended ");
//------------------------------
		if (name.contains("Sree")) {
			System.out.println("condition is satisfied ");
			Assert.assertEquals("sai", "sai");
			System.out.println("Hi i am here ");
			System.out.println("I am in ATP");
		} 
		System.out.println("Execution is ended ");

	}
}
