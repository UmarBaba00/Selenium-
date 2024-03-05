package HandlingWebElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void brokenLinks() throws InterruptedException, IOException {
		//Implicit wait for 10sec
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");
		
		Thread.sleep(5000);
		//Capture Links from a webpage
		List <WebElement>links =(List<WebElement>) driver.findElement(By.tagName("a"));
		
		//Number of Links
		int s =links.size();
		System.out.println(s);
		
		for(int i=0; i<s; i++) {
			
			// By using herf attribute we can get URL of required link
			WebElement element =links.get(i);   //Capture the first WebElement
			String url =element.getAttribute("herf"); //CApture the herf
			
			URL link = new URL(url);
			
			//Create Connection using url object 'link'
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection(); //Make connection with Links
			Thread.sleep(2000);
			//Establish Connection
			httpConn.connect();
			
			int respcode = httpConn.getResponseCode();  //Return Response Code
			
			if(respcode>=400) {
				System.out.println(url +" - "+ " is Broken Link");
			}
			else {
				System.out.println(url +" - "+ " is Valid Link");
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		BrokenLinks b = new BrokenLinks();
		b.launchbrowser();
		b.brokenLinks();
		

	}

}
