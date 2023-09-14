/* Scenario5 :
 * Navigate to Organizations page
 * Click on 8th check box and capture the organization name and delete the organization
 */
package dynamicWebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {
	@Test
	public void clickOn8thCheckBoxSelectAndDeleteOrgName() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//click on 8th check box
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[1]/input")).click();
		// capture organization name
		String orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[3]/a")).getText();
		System.out.println("Organization Name :"+orgName);
		// delete organization name
	}
}
