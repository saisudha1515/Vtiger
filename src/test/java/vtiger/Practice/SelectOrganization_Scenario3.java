package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOrganization_Scenario3 {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(1000); // inside nextInt()method we need to give the bound value and here the bound
									// value is 1000 so upto 1000 times we can run the testcase with different org
									// name..
		String orgName = "abc";
		String organizationName = orgName + num;
		// Step1 : Launch the Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// Step2 : Login to Application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Step3 : Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// Step4 : Click on create Organization look up Image
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();

		// Step5 : Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		System.out.println("organizationName : " + organizationName);
		driver.findElement(By.cssSelector("input[value='T']")).click();
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Support Group");

		// Step6 : Select "Chemicals" in the industry drop down
		WebElement dropdown1 = driver.findElement(By.name("industry"));
		Select ss = new Select(dropdown1);
		ss.selectByValue("Chemicals");
		// Step7 : Save and Verify
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		String msg = driver.findElement(By.className("dvHeaderText")).getText();
		if (msg.contains("abc")) {
			System.out.println("PASS");
			System.out.println(msg);
		}
		// Step8 : Logout of Application
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout done successfully");

		// Step : Close the browser
		driver.quit();

	}
}
