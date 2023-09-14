package JDBC;
// for security reasons we should not pass the username and password directly in the script itself..1st we need to encrypt(convert String into Byte) and then we need to decrypt(convert Byte into String) and then pass in the test Script.. 
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Encrypt_And_Decrypt {
	public static void main(String[] args) {
		// Encryption of String into Byte.. with the help of Base64 and this Base64 is coming from java.util package..
		String encryptedUserName = new String(Base64.getEncoder().encode("admin".getBytes()));
		String encryptedPassword = new String(Base64.getEncoder().encode("admin".getBytes()));
		System.out.println("encryptedUserName : " + encryptedUserName);
		System.out.println("encryptedPassword : " + encryptedPassword);

		// Decryption of String into Byte.. with the help of Base64
		String decryptedUsername = new String(Base64.getDecoder().decode(encryptedUserName.getBytes()));
		String decryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword.getBytes()));

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(decryptedUsername);
		driver.findElement(By.name("user_password")).sendKeys(decryptedPassword);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login done Successfully");

	}
}
