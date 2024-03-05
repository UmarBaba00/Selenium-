package SwitchBetweenAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithTextBox {
	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void alertWithTextBox() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		//Alert With TextBox Link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		
		//Alert with TextBox Button
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Umar");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String expTextOK = "Hello Umar How are you today";
		String actTxtOK = driver.findElement(By.id("demo1")).getText();
		
		if(expTextOK.equals(actTxtOK)==true) {
			System.out.println("Test is Passed");
		}
		
		
		//Second time Click
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Umar");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		String txtCancle = driver.findElement(By.id("demo1")).getText();
		System.out.println(txtCancle);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AlertWithTextBox a = new AlertWithTextBox();
		a.launchbrowser();
		a.alertWithTextBox();

	}

}
