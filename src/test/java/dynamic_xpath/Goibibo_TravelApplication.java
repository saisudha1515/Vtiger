package dynamic_xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_TravelApplication {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//*[.='Departure']")).click();  // instead of html tag we can write * it will matches with all the tags  and instead of text() we can write dot(.)
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		String month = "September 2023";
		String date = "31";
		//dynamicXpath    ------>      '"+do concate your variable here +"'
	//	Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
	//	driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//span[text()='Return']")).click();
//		String month1 = "October 2023";
//		String date1 = "31";
		driver.findElement(By.xpath("//*[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='30']")).click();
//		driver.findElement(By.xpath("//*[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date1+"']")).click();
//		driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
//		
//		driver.findElement(By.xpath("//*[.='Done']")).click();
		System.out.println("done..");
		
		

	}
}
