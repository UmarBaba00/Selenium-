package Authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupAuthentication {

	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void popupAuthentication() {

//		driver.get("http://the-internet.herokuapp.com/basic_auth");

		// http://username:password@test.com
		// By providing username and password into URL we can bypass the poopup window
		
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");//by using this url formate we can skip the popup window
		String text =driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopupAuthentication a = new PopupAuthentication();
		a.launchbrowser();
		a.popupAuthentication();

	}

}
