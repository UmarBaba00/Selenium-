package HandlingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calander {
	
	WebDriver driver;
	
	
	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	public void calander() {
		driver.get("https://goo.gl/kNZ6Sr");
		driver.findElement(By.xpath("html/body/form/div[2]/div[19]/img")).click();   //Xpath of Calender
		
		Select y = new Select(driver.findElement(By.xpath("html/body/div[1]/div/div/select"))); // xpath of year
		y.selectByVisibleText("2017");
		
		// Future mount & date
		for(int i=6; i>=1; i--) {   // for selecting mounts after 6 mount
			driver.findElement(By.xpath("html/body/div[1]/div/a[2]/span")).click(); //xpath of next mounth > button
			String m = driver.findElement(By.xpath("html/body/div[1]/div/div/span")).getText(); //xpath of mounth
			
			if(m.equals("December")) {
				driver.findElement(By.linkText("10")).click();  //xpth is not used beacuse the value is changed again 
				break;
			}
			
		}
		
//		// Past mounts & date
//		for(int i=5; i>=1; i--) {   // for selecting mounts after 6 mount
//			driver.findElement(By.xpath("html/body/div[1]/div/a[1]/span")).click(); //xpath of next mounth > button
//			String m = driver.findElement(By.xpath("html/body/div[1]/div/div/span")).getText(); //xpath of mounth
//			
//			if(m.equals("May")) {
//				driver.findElement(By.linkText("1")).click();  //xpth is not used beacuse the value is changed again 
//				break;
//			}
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calander c = new Calander();
		c.launchbrowser();

	}

}
