/*My Listener implementation class is somewhere and my TestScrit is somewhere so we need to configuration b/w these two then only the Listeners will going to monitor the TestScript..
 Do the configuration between Listener implementation class and TestScript for this we need to use @Listener annotation from TestNG and @Listener annotation will accept fully qualified class name with .class extension.. because it can accept class path file..
 We can give @Listener annotation at class level
*/
package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.ListenersImplementation.class)
public class ListenerPractice {
	@Test
	public void demo() {
		Assert.fail();
		System.out.println("HI");
	}

	// It is to Skip the TestMethod..
	@Test(dependsOnMethods = "demo")
	public void demo1() {
		System.out.println("Hello");
	}
}

/*
 * if TestScript is pass then onTestFailure() and onTestSkipped() will not get
 * executed.. if TestScript is fail then onTestSuccess() and onTestSkipped()
 * will not get executed.. Based on the status of the TetsScript the Listeners
 * or Listeners methods are going to execute..
 * 
 */
