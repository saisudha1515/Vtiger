/*
If you declare the WebDriver driver as global variable for ever the driver value will be null and it will not take any updated driver value. If you make parameterize the driver value. The caller calls this method he has to give the updated driver so that the driver value will never be null.The Parameterization only reason is to give updated value to the driver during method calling at run time..
After browser launching whatever the session id driver holds that is the updated driver. and after browser launching only we do maximize the screen and put waits..etc
Initially getSession id will be null only when we launch the browser, a specific session id  will be created for the driver and by using that session id only we can access all our driver related methods..otherwise driver value is null. When driver value is null you can't perform any operations on driver or you can't use any WedDriver methods.. 
WebDriver driver = new ChromeDriver();--> it will launch the browser..when you launch the browser then only a specific session id will be created for the driver. If you don;t launch the browser then driver value will be null. and you can't perform any action in the null..
Here in Utility class we are not launching the browser.. so by default the driver value will be null if you declare WebDriver as Global Variable..so to over come that issue pass the driver value during method calling.. other wise it will throw you StaleElementReferance Exception..
*/
package com.vtiger.GenericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/** This class consists of reusable methods related to WebDriver
 * @author Saisudha D
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {   // when you call this method the caller should give the updated driver reference variable..Don't declare driver as Global variable..because when you don't launch the browser/ don't use the browser/don't create object for WebDriver i.e, when you don't do up-casting by-default driver value will become null.On null you can't perform any operation/action.. 
		driver.manage().window().maximize();         // here the called method is holding nothing to return to caller so, here the return type is void..and we don't have return statement here..
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver ){
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will open the window in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will wait 10 seconds for all web elements to load
	 * @param driver
	 */
    public void waitForPageLoad(WebDriver driver ) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // you can parameterize this implicitly Wait also but 10,15,20 seconds are optimal time duration.. so no need to use parameterization here. can do hardcode..
      }
    
    /**
     * This method will wait for 10 seconds for particular element to be visible
     * @param driver
     * @param element
     */
    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // provide duration for how long it has to wait..
    	wait.until(ExpectedConditions.visibilityOf(element)); // whatever you want any external information/data just parameterize it.. parameterize WebElement
    }
    
    /**
     * This method will wait for 10 seconds for particular element to be clickable
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    // handleDropdown() is overloaded method this method is not capturing any information/data so no need of return statement.. this method is not returning anything to caller. It is just handling the drop down..it is just performing the action
    /**
     * This method will handle drop down using index
     * @param element
     * @param index
     */
    public void handleDropdown(WebElement element, int index) {
    	Select sel = new Select(element);
    	sel.selectByIndex(index);
    }
    
    /**
     * This method will handle drop down using value
     * @param element
     * @param value
     */
    public void handleDropdown(WebElement element, String value) {
    	Select sel = new Select(element);
    	sel.selectByValue(value);
    }
    
    /**
     * This method will handle drop down using Visible text
     * @param text
     * @param element
     */
    public void handleDropdown( String text, WebElement element) {
    	Select sel = new Select(element);
    	sel.selectByVisibleText(text);
    }
    
    /**
     * This method will perform mouse hover action on a web element
     * @param driver
     * @param element
     */
    public void mouseHoverAction(WebDriver driver, WebElement element) {
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * This method will perform right click anywhere on the web page
     * @param element
     * @param driver
     */
    public void rightClickAction(WebDriver driver) {
    	Actions act = new Actions(driver);
    	act.contextClick().perform();
    }
    
    /**
     * This method will perform right click on a particular web element
     * @param driver
     * @param element
     */
    public void rightClickAction(WebDriver driver, WebElement element ) {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    /**
     * This method will perform double click anywhere on the web page
     * @param element
     * @param driver
     */
    public void doubleClickAction(WebDriver driver) {
    	Actions act = new Actions(driver);
    	act.contextClick().perform();
    }
    
    /**
     * This method will perform double click on a particular web element
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver, WebElement element ) {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    /**
     * This function will perform drag and drop operation
     * @param driver
     * @param source
     * @param destination
     */
    public void dragAndDropAction(WebDriver driver, WebElement source, WebElement destination) {   // destination or target both are same..
    	Actions act = new Actions(driver);
    	act.dragAndDrop(source, destination).perform();
    }
    
    /**
     * This method will move the cursor by offset and click
     * @param driver
     * @param x
     * @param y
     */
    
    // moveToElement() will help us to move to a particular web element in the wed page.. moveByOffSet()will be used to move any where in the web page you can move irrespective of the web element (if you want to avoid any adds or any unexpected pop ups you can use this moveByOffSet())
    public void moveTheCursorAndClick(WebDriver driver, int x, int y) { // i need x offset and y offset
    	Actions act = new Actions(driver);
    	act.moveByOffset(x, y).click().perform();
    }
    
    /**
     * This method will scroll down for 500 units.
     * @param driver
     */
    public void scrollAction(WebDriver driver) {
    	JavascriptExecutor jse = (JavascriptExecutor) driver;  // cast your driver to JavascriptExecutor executor
    	jse.executeScript("window.ScrollBy(0,500);", ""); // give null or empty String            // which will ask you script which is a String argument
    }
   
    // When you have more than one or multiple scroll bars in your web page it is better to use arguments of index nbr of scroll bar (arguments[0])so that you can keep of increase the index based on no. scroll bars.. with the help of JavascriptExecutor you can handle anything and every thing. Sendkeys() method is there to send input to textbox. and if you wish you can make use of JavascriptExecutor. it is an option..
    // we don't have direct methods in selenium to handle Scroll bars so, we use an interface called JavaScriptExecutor and have to caste this interface to our driver and we are writing a small java script code this java script will handle this Scroll bar. If you don't handle anything in selenium directly you can make use this java Script Executor. arguments[0] which will handle first scroll bar in you web page.. basically arguments[0] depends on your method what you are using.. you can provide sendKeys(),click(), element etc .....0 index means first very starting ELEMENT you can consider.
    public void scrollAction(WebDriver driver, WebElement element) {
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("arguments[0].scrollIntoView()", element); // scroll until this element is reached/viewed/visible....arguments[0] which indicates first drop down in our web page. Suppose if you want to handle 5th scroll bar in your web page then you should give the index as argument[4].. index starts from 0.
    }
    
    /**
     * This method will accept the alert pop up
     * @param driver
     */
    public void acceptAlert(WebDriver driver) {
    	driver.switchTo().alert().accept();      // accept() means OK..
    }
    
    /**
     * This method will cancel the alert pop up
     * @param driver
     */
    public void dismissAlert(WebDriver driver) {
    	driver.switchTo().alert().dismiss();
    }
    
   /**
    * This method will return 
    * @param driver
    * @return alertText
    */
    //when you feel the data/information which the called function is holding/capturing is necessary for the caller, you can use return statement.if it is not returning anything means the function is just performing the action there is nothing to return.in such cases the default return type is "void"
    public String getAlertText(WebDriver driver) {
//    String alertText = driver.switchTo().alert().getText();
//    return alertText;
      return driver.switchTo().alert().getText();      //it will reduce code
    }
    
    /**
     * This method will handle Frame using index
     * @param driver
     * @param index
     */
    // Frames it self is an overloaded method and all these frame overloaded methods are coming from Target Interface
    public void handleFrame(WebDriver driver, int index) {
    	driver.switchTo().frame(index);
    }
    
    /**
     * This method will handle Frame using name or ID
     * @param driver
     * @param nameOrID
     */
    public void hanleFrame(WebDriver driver, String nameOrID) {
    	driver.switchTo().frame(nameOrID);
    }
    
    /**
     * This method will handle Frame using frame element
     * @param driver
     * @param frameName
     */
    public void handleFrame(WebDriver driver, WebElement element) {   // element means frameName
    	driver.switchTo().frame(element);
    }
   
    /**
     * This method will switch to immediate parent frame
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver) {
    	driver.switchTo().parentFrame();
    }
    
    /**
     * This method will switch to default page 
     * @param driver
     */
    public void switchToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    
    /**
     * This method will help to switch the control from one window to another by using Window's Title
     * @param driver
     * @param partialWindowTitle
     */
    
//  we can check the frame in the web page with the help of "iframe" tag 
//  Nested Frame means frame inside a frame... when you have single frame in such case both defaultContent() and parentFrame() methods will behave in a same manner..
//  When you have nested frames, then if you want to go to main frame use defaultContent()method and if you want to switch your driver instance/ go to immediate parent frame only then use "parentFrame()"
//  defaultContent() will come out of from all the existing frames and land you in a main frame. Once you load URL we will get main frame
//  Frames are embedded in the web page it does not have any URL, title etc. only after inspection you will get to know whether you have frames or not in the web page other wise just looking at by page you never get to know about frame.. it is the main drawback of frames
//  Window/web page  will be having specific title and url and minimize, maximize and close buttons, it will give a separate page.. but these  will not happen in case of Frames ..defaultContent()method will be applicable only for frames..frames don't have url and title, minimize, maximize and close buttons,full screen and don't have separate pages
//  Frames are not known until you inspect.Frames are embedded inside a web page
//  now the driver control is in 6th child window and now you want to switch to main window then again you no need to use getWindowHandle(). you just pass the main window title by calling this method..and if you are in main window and you want to switch the driver control back to child then pass the title of child window by calling this method simple

    public void switchToWindow(WebDriver driver, String partialWindowTitle) {
    	//Step1 : Capture all the window ID
    	Set<String> allWindowIDs = driver.getWindowHandles();
    	//Step2 : Navigate through each window  // how ? by using forEachLoop
    	for(String eachWindowId : allWindowIDs) {
    	//Step3 : Switch to each window and capture the title
    	String actualEachWinowTitle = driver.switchTo().window(eachWindowId).getTitle();
    	System.out.println(actualEachWinowTitle);
    	//Step4 : Compare the title with required
    	if(actualEachWinowTitle.contains(partialWindowTitle)) {
    		break;
    	     }
         }
    }
    
    
    /**
     * This method will help to switch the control from one window to another using Window's URL
     * @param partialWindowUrl
     * @param driver
     */
    public void switchToWindow( String partialWindowUrl,WebDriver driver) {
    	//Step1 : Capture all the window ID
    	Set<String> allWindowIDs = driver.getWindowHandles();
    	//Step2 : Navigate through each window  // how ? by using forEachLoop
    	for(String eachWindowId : allWindowIDs) {
    	//Step3 : Switch to each window and capture the title
    	String actualEachWinowUrl = driver.switchTo().window(eachWindowId).getCurrentUrl();
    	System.out.println(actualEachWinowUrl);
    	//Step4 : Compare the title with required
    	if(actualEachWinowUrl.contains(partialWindowUrl)) {
    		break;
    	     }
         }
    }
    
    
    /**
     * This method will take screenshot and store it in required folder and return get absolute path
     * @param driver
     * @param screenShotName
     * @return path
     * @throws IOException
     */
     public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
     	TakesScreenshot tsh = (TakesScreenshot) driver;
     	File source = tsh.getScreenshotAs(OutputType.FILE);  // what is the type you want to capture, in FILE format i want to capture the screen shot.. OutputType is an Interface.. this source is a temporary location to store the screen shot. for longer period of time you can't store the screen shot the reason is if you take another screen shot the existing screen shot will be overridden. so we can't keep the screen shot in the temporary location/file i.e,Source so as soon as we take screen shot we need to copy that screen shot to our required location.
     	File destination = new File(".\\ScreenShots\\"+screenShotName+".png");       // "ScreenShots" is Folder name i want this Screen shots file to be  stored in side this Folder..... \\ or / this means the control will go inside the given folder.. here in this method the caller will give the screen shot name during calling..... if you forget to put "\\" after folder name then the entire will be considered as file not as Folder because  ".png"  extension is there. the screen shot name will not go inside this ScreenShots Folder and sit in this folder
         Files.copy(source, destination); // Now i need to copy the file from temporary location i.e, source to permanent location i.e, destination... how? for this we require one third party tool i.e," commans.io " jar. Which is used to handle all third party file related actions...To perform/handle all file related actions (like copy file, paste file, formatting the file etc)  "commons.io"  is the one stop solution..
         return destination.getAbsolutePath();  /////////// it is used for Extent reporting.. because i want to attach the screenshot in the report also, not onlt storing in the ScreenShot Folder.......so that my debugging process will be easy..  getAbsolutePath() method will give the complete path of the file.... because dot(.)will be understood by JVM but Extends reports will not understand dot(.) so for this we require complete path of file so we are returning the complete path of the captured Screenshots..... our Extends reports will go to this specified location and pick the captured screenshot..
     }   
}
