package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_Scenario1 {
	public static void main(String[] args) throws InterruptedException {
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
		
		
		// Step3 : Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		
		// Step4 : Click on Create contact look up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		// Step5 : Create Contact With Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Sudha1");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		Select s = new Select(dropDown);
		s.selectByVisibleText("Team Selling");
		
		
		// Step6 : Save and verify
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		String contactName = driver.findElement(By.className("dvHeaderText")).getText();
		if (contactName.contains("Sudha")) {
			System.out.println("Testcase is passed ");
			System.out.println(contactName);
		}
		
		
		// Step7 : Logout of Application
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout done successfully");
		
		
		// Step8 : Close the browser..
		driver.quit();

	}
}
