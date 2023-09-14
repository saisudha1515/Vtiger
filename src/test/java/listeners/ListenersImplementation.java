package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.reporters.SuiteHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.GenericUtilities.BaseClass;
import com.vtiger.GenericUtilities.BaseClassForListeners;
import com.vtiger.GenericUtilities.JavaUtility;
import com.vtiger.GenericUtilities.WebDriverUtility;

/** This class will provide implementation to ITestListener interface.
 * author : Saisudha D
 */
// All ITestInterface interface methods are abstract Methods so we need to provide the implementation(does not matter whether you provide logic or not in the implementation but you must provide the implementation i.e, we have to call all the abstract methods of ITestListener) to the all abstract methods of ITestListeners..
// In eclips we have a shortcut for creation of all implementation methods. We no need to create implementation methods manually..
// How to create Implementation methods : rightClick on Editor --> Source -->click on "Override/implement Methods"
// Skip Implementation for Object Class and you can remove the logic/suggestion of Super class i.e, Object Class and we have to call all implementation methods of ITestListerners no matter whether you provide implementation or not but we have to call other wise it will not work for some times..
// empty implementation is also fine but we must call all methods in side your ITestListener implementation class..
public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
	String methodName =	result.getMethod().getMethodName();
	  test = report.createTest(methodName); // it will execute for each execution and it giving hint to the Extent reports that @Test Execution is started.. in our extent report every time the test is getting created.. that test may be passed or failed or skipped..
	//System.out.println(methodName+"--------- TetsScript execution started --------");
	
	}
// TestScript execution is started that script may be pass/fail/skip..
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName =	result.getMethod().getMethodName(); //result will get the status of the @Test or TestScript.. getMethod() method will capture the method name and  getMethodName() method will capture the method name.. we are capturing the method name just to know/ read the status of the method..for better readability/ approachability..
		//System.out.println(methodName+"-------- PASS --------");
		test.log(Status.PASS, methodName+"-------- PASS --------"); // logs will log everything in our extent reports..
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		String methodName =	result.getMethod().getMethodName();
		String screenShotNameHere = methodName+jUtil.getSystemDate();
		try {
			String path = wUtil.captureScreenShot(BaseClassForListeners.sdriver, screenShotNameHere); //captureScreenShot() method will return the getAbsolutePath and this path i am gonna attaching into the extent report..
		// attach the Screen shot into the Report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(methodName+"------- FAIL --------");
		//System.out.println(result.getThrowable());   // getThrowable() method will print the reason for exception occurred.. in extent reports no where we can make use of this Print Statements..
		test.log(Status.FAIL, methodName+"-------- FAIL --------");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName =	result.getMethod().getMethodName();
		//System.out.println(methodName+"-------------- SKIP ---------------");
		//System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodName+"-------- SKIP --------");
		test.log(Status.INFO, result.getThrowable());// info is nothing but the Exception information
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override   // report configuration has to do at onStart()method..
	public void onStart(ITestContext context) { 
		//configure the extent reports
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDate()+".html"); //here Report is name (it will come in report) and i am appending date to the Screenshot and ".html" is the extension..
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("Automation Execution");
		htmlReport.config().setTheme(Theme.DARK);
		
		 report  = new ExtentReports();
		 report.attachReporter(htmlReport);
		 report.setSystemInfo("BasePlatform", "Windows");
		 report.setSystemInfo("BaseBrowser", "Chrome");
		 report.setSystemInfo("BaseURL", "http://localhost:8888");
		 report.setSystemInfo("BaseEnvironment", "Testing");
		 report.setSystemInfo("ReporterName", "Saisudha");

		System.out.println("---------------- Suite execution started -----------------");
	}

	@Override  // report generation has to do at onFinish() method..
	public void onFinish(ITestContext context) {
		System.out.println("---------------- Suite execution finished ---------------");
		
		// generate the report after execution
		report.flush();
		
	}
	

}
