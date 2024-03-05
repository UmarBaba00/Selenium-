package RobotAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotAPIDemo {

	
WebDriver driver;
	
	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void RobotApiDemo() throws AWTException, InterruptedException {
		driver.get("http://spreadssheetpage.com/index.php/site/file/yearly_calender_workbook");
		driver.findElement(By.xpath("/html/body/div/section/div/div[1]/ul/ui[3]/a")).clear();  //XPath of downloaded excel file
		
		// When Download Excel file through FireFox Browser then a popup will appear first and we can handle this popup using Robot class
		//But in Chrome we can directly download the file
		
		Robot robot = new Robot();  //Robot class is used to handle Mouse over and Keyboard events, or to upload & Download files
		
		/*Dpwn Arrow key
		 * 3 Times tab key
		 * enter
		 */
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);  // Press Down Arrow Key in KeyBoard
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	
	
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		RobotAPIDemo r = new RobotAPIDemo();
		r.launchbrowser();
		r.RobotApiDemo();

	}

}
