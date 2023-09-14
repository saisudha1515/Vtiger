/* Scenario2 :
 * Navigate to Vtiger Application
 * Navigate to Organizations page
 * Check on the 5th check boxes 
 */

package dynamicWebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {
	@Test
	public void checkOn5thCheckBox() {
		WebDriverManager.chromedriver().setup();//  this statement will download the driver (driver executable files) and set the path..
		WebDriver driver = new ChromeDriver();  // this statement will invoke the browser..
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]/input")).click();
	}
}
