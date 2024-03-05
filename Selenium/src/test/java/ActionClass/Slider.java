package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
	
	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	public void slider() {
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(0);   //Switch to the Frame first beacuse slider is located witnin the frame
		WebElement slider =driver.findElement(By.id("slider")); 
		
		
		Actions act = new Actions(driver);
		
		act.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Slider s = new Slider();
		s.launchbrowser();
		s.slider();
		

	}

}
