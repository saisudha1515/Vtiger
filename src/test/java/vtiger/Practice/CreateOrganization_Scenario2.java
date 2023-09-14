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

public class CreateOrganization_Scenario2 {
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		int num = r.nextInt(1000);
		String orgName = "abc";
		String organizationName = orgName + num;
		// Step1 : Launch the Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// Step2 : Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Step3 : Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step4 : Click on Create Organization look up Image
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();

		// Step5 : Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		System.out.println("organizationName : " + organizationName);
		driver.findElement(By.cssSelector("input[value='T']")).click();
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Support Group");
		
		// Step6 : Save and verify
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();// when the functionality of web elements
																				// are same then we can take the address
																				// of element even our one is not in the user friendlyness..
		String message = driver.findElement(By.className("dvHeaderText")).getText();
		if (message.contains("abc")) {
			System.out.println("PASS");
			System.out.println(message);
		}
		// Step7 : Logout of Application
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Login done successfully");

		// Close the Browser
		driver.quit();

	}
}
