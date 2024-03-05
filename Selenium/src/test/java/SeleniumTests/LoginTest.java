package SeleniumTests;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class LoginTest extends LaunchBrowser {
	
	@Test
	public void login() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(200);
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		Thread.sleep(200);
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		Thread.sleep(200);
//		driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
		
		String Expected = "Login";
		String Actual = driver.getTitle();     // Returns the title of the Page
		
		if(Actual.equalsIgnoreCase(Expected)) {
			System.out.println("Title Matched");
		}else {
			System.out.println("Title not Matched");
		}
	}
	
	
//	@Test
//	public void CloseBrowser() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.close();
//	}
	

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		LoginTest obj = new LoginTest();
		obj.login();
//		obj.CloseBrowser();
		
	}
}
