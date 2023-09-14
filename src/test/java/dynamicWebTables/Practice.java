package dynamicWebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
@Test
public void verifyTable() {
	WebDriverManager.chromedriver().setup(); // this statement will download the driver and set the path 
	WebDriver driver = new ChromeDriver();// this statement will invoke/launch the browser..
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://seleniumpractise.blogspot.com/2021/08");
	
	//**** Table Headers:
	
	List<WebElement> allHeaders = driver.findElements(By.xpath("//table[contains(@id,'customers')]/tbody/tr[1]/th"));
	int headersCount = allHeaders.size();
	System.out.println(headersCount);
	Assert.assertEquals(headersCount, 5,"Column header count is not same ");
	boolean flag = false;
	for (WebElement eachHeader : allHeaders) {
		String eachHeaderValue = eachHeader.getText();
		System.out.println(eachHeaderValue);
		if(eachHeaderValue.contains("Contact")) {
			flag = true;
			break; // as soon as it found the record/value just terminate the loop..
		}
	 }
	Assert.assertTrue(flag,"Header is not present");

	System.out.println("======= Table total rows and data of columns =======");
	List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[contains(@id,'customers')]/tbody/tr"));
	int totalNoOfRows = numberOfRows.size();
	System.out.println(totalNoOfRows);
	Assert.assertEquals(numberOfRows.size(), 7,"Table rows count is mismatched");
	for (WebElement eachRow : numberOfRows) {
		String eachRow1 = eachRow.getText();	
		System.out.println(eachRow1);
		if(eachRow1.contains("Ola")) {
			flag = true;
			break; // as soon as it found the record/value just terminate the loop..
		}
	}
	Assert.assertTrue(flag,"Record is not found");
	System.out.println("===============================================");
	
	driver.findElement(By.xpath("//td[text()='Java']//preceding-sibling::td//input")).click(); // it will click on the check box just before(so travel in backword direction) the java
	driver.findElement(By.xpath("//td[text()='Ola']//following-sibling::td[3]//a")).click(); // it will click on know more link which is just following to "Ola"
	
	
	driver.quit();
  }

}
