package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LaunchBrowser {

	WebDriver driver;

	@Test
	public void launchbrowser(){
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		LaunchBrowser obj = new LaunchBrowser();
		obj.launchbrowser();
	}

}

