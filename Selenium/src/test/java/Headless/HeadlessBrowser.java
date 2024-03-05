package Headless;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
//import SeleniumTests.LaunchBrowser;    // Import class from another Package

public class HeadlessBrowser {
	
	
	public void Headless() {
		WebDriverManager.chromedriver().setup();  // No need to set path of Chrome executeable file
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://demo.nopcommerce.com/");
		System.out.println("Title of the Page is: "+ driver.getTitle()); // Get Title of Page
		System.out.println("Current URL of the Page: " + driver.getCurrentUrl()); // Get Current URL of the Page
		WebElement Text = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[3]/div/div[1]/div/h2/a"));
		Text.getText();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LaunchBrowser l = new LaunchBrowser();   // To use method from imported class you need to declare it first
//		l.launchbrowser();
		HeadlessBrowser h = new HeadlessBrowser();  // This is class
		h.Headless();                              // This is Method
	}

}
