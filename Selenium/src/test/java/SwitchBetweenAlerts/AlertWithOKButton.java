package SwitchBetweenAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithOKButton {
	
	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void alertWithOkButton() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		//Alert with OK Link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		//Alert with OK button
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		//Switch to Alert box
		String altText = driver.switchTo().alert().getText();
		System.out.println(altText);
		driver.switchTo().alert().accept(); //accepts will close the window by clicking on Ok button
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlertWithOKButton s = new AlertWithOKButton();
		s.launchbrowser();
		s.alertWithOkButton();
	}

}
