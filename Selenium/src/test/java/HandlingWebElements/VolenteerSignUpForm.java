package HandlingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VolenteerSignUpForm {


	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void SignUp() {
		driver.get("https://goo.gl/kNZ6Sr");
		
		//Name,City,Email,Phone
		driver.findElement(By.id("RESULT_TestField-2")).sendKeys("Umar");
		driver.findElement(By.id("RESULT_TestField-3")).sendKeys("Gujranwala");
		driver.findElement(By.id("RESULT_TestField-4")).sendKeys("doctorumar1209@gmail.com");
		driver.findElement(By.id("RESULT_TestField-5")).sendKeys("12345678");
		
		//DropDown
		WebElement drptime = driver.findElement(By.id("RESULT_RadioButton-6")); //id of DropDown
		Select t = new Select(drptime); //DropDown contains too mant WebElements thats why we used Select variable
//		t.selectByIndex(2);  //by Index
//		t.selectByValue("Radio-2"); // by Value
		t.selectByVisibleText("Evening");  //by VisibleText
		
		//Check how many WebElements present inti DropDown
		System.out.println(t.getOptions().size());
		                            //In DropDown Space is also contains as WebElement
		
		//Radio Button
		System.out.println(driver.findElement(By.id("RESULT_RadioButton-7_0")).isSelected());  //Check where the Radio Button is selected or not
		driver.findElement(By.id("RESULT_RadioButton-7_0")).click();
		
		//CheckBoxes
		driver.findElement(By.id("RESULT_CheckBox-8_0")).click();
		driver.findElement(By.id("RESULT_CheckBox-8_6")).click();
		
		
		//Bigger TextBox/TextArea
		driver.findElement(By.id("RESULT_TextArea-11")).sendKeys("Selenium Automation");
		
		//Link Validation
		if(driver.findElement(By.linkText("Flight Reservation")).isDisplayed()==true) {
			driver.findElement(By.linkText("Flight Reservation")).click();
			driver.navigate().back();  // Navigate to Previous Page
		}else {
			driver.close();
		}
		
		
		//Button
		driver.findElement(By.id("FSsubmit")).click();
		if(driver.getTitle().contains("Successful Submission | Formsite")==true) {
			System.out.println("Test is Passed");
		}
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VolenteerSignUpForm v = new VolenteerSignUpForm();
		v.launchbrowser();
		v.SignUp();
	}

}
