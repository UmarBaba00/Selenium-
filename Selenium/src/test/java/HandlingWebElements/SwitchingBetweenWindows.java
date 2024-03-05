package HandlingWebElements;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingBetweenWindows {

	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void SwitchingWindows() {
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		
//		System.out.println(driver.getTitle());  //Title of Parent Window
		
		Set <String> s = driver.getWindowHandles(); //Set is used for storing multiplt things
		                                           // s contains all windows id's
		                                          // getWindowHandles return id/key valuw of browser/window
		
		for(String i:s) { //for loop is used to reach all windows ids and store into i veriable
			             // i contains id of the browser
			
			System.out.println(i);  //09BB48573BC42BFC70652D6324C7B786
			                       //22D2A05C2182D09BD671A3333C2F1CA3
			                      // i store these two id's of browsers and based on thses id's its switch btweeen the browsers
			
			
			String t =driver.switchTo().window(i).getTitle();  //Store windoes title into t veriable
			System.out.println(t);      // s gets all available windows id's and store into i 
			                           // There are two available windows and for loop runs for 2 times 
			                          // and get the title of both available windows.
			
			if(t.contains("Frames & windows")) {  
				driver.close();  //close perent window
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwitchingBetweenWindows s = new SwitchingBetweenWindows();
		s.launchbrowser();
		s.SwitchingWindows();
	}

}
