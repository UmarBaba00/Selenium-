package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	
	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void resizable() throws InterruptedException {
		driver.get("https://jqueryui.com/resizable/");
		
		driver.switchTo().frame(0);  //Switch to the Frame first beacuse resizable is located witnin the frame
		WebElement resizable =driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(resizable).dragAndDropBy(resizable, 50, 50).build().perform();
		
		Thread.sleep(3000);
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Resizable r = new Resizable();
		r.launchbrowser();
		r.resizable();

	}

}
