package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClick {
	
	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void mouseRightClick() {
		driver.get("http://swisnl.github.io/jQuery-conntextMenu/demo.html");
		
		Actions act = new Actions(driver);
		
		WebElement button =driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));  //Xpath of right click button
		act.contextClick(button).build().perform();     //contextClick() is used to right click on button
		
		driver.findElement(By.xpath("/html/body/ul/li[3]")).click();    //After clicking on this option an alert window is open
		String alert = driver.switchTo().alert().getText();   //Capture Text from Alert Box
		System.out.println(alert);
		
		driver.switchTo().alert().accept();  //Click on OK button of Alert Box & Close it
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MouseRightClick m = new MouseRightClick();
		m.launchbrowser();
		m.mouseRightClick();

	}

}
