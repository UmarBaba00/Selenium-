package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumCommands extends LaunchBrowser {

	@Test
	public void GetCommands() throws InterruptedException {

		driver.get("http://demo.nopcommerce.com/");
		Thread.sleep(200);
		System.out.println("Title of the Page is: "+ driver.getTitle());
		Thread.sleep(200);
		System.out.println("Current URL of the Page: " + driver.getCurrentUrl());
		Thread.sleep(200);
		WebElement text = driver.findElement
				(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[3]/div/div[1]/div/h2/a"));
		System.out.println("Text of the Element is: " + text.getText());
		Thread.sleep(400);
		driver.close();  // Close current Window
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SeleniumCommands c = new SeleniumCommands();
		c.GetCommands();
	}

}
