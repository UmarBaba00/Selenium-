package SwitchBetweenAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithOKandCancleButton {
	
	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void alertWithOkandCancleButton() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		//Alert with OK and Cancle Link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		//Alert with Ok and Cancle Button
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		
		
		String expTextOK = "You pressed OK";
		
		
		driver.switchTo().alert().accept();
		String actTextOK = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText(); //Xpath of both OK and Canle Button is same 
		                                                                             // But displayed massege is different
		
		if(expTextOK.equals(actTextOK)==true) {
			System.out.println("OK Test is Passed");
		}
		
		Thread.sleep(2000);
		//Alert with Ok and Cancle Button
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		
		String expTextCancle = "You Pressed Cancel";
		driver.switchTo().alert().dismiss();
		String actTextCancle = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		if(expTextCancle.equals(actTextCancle)==true) {
			System.out.println("Cancle Test is Passed");
		
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AlertWithOKandCancleButton a = new AlertWithOKandCancleButton();
		a.launchbrowser();
		a.alertWithOkandCancleButton();

	}

}
