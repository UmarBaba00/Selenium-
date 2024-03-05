package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void dragAndDrop() {
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement source =driver.findElement(By.id("box1"));   //Source Element
		WebElement target =driver.findElement(By.id("box103"));     //Target Element
		
		Actions act = new Actions(driver);
		
		/*act.clickAndHold(source).moveToElement(target).release().build().perform();  //clickAndHold() is used to click the element and hold it
		                                                                            //moveToElement() is used to move element to target place
		                                                                           //release() is used to release the element at target place*/
		
		act.dragAndDrop(source, target).build().perform();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DragAndDrop d = new DragAndDrop();
		d.launchbrowser();
		d.dragAndDrop();

	}

}
