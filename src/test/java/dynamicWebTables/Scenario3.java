/*Scenario3 :
 * Navigate to Vtiger Application
 * Navigate to Organizations page
 * Capture all the organization names and print in console
 */

//table[@class='lvt small']/tbody/tr[*]/td[3]/a
package dynamicWebTables;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {
	@Test
	public void printAllOrgNames() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> allOrgNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for (WebElement eachOrgName : allOrgNames) {
			System.out.println(eachOrgName.getText());
		}
	}
}
