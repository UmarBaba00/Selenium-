package HandlingWebElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	WebDriver driver;


	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void verifyDropDownStoredOptions() {
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement element = driver.findElement(By.id("country"));  // Get DropDown
		Select s = new Select(element); //Stored DropDown values into an element

		List originalList = new ArrayList();  // Create new Original ArrayList
		//		List tempList = new ArrayList(); // Create new Temporary List

		List <WebElement> option = s.getOptions();  // Get stored option into DropDown
		for(WebElement e:option) {

			originalList.add(e.getText()); // Get text of stored options available into DropDown
			//			tempList.add(e.getText()); // Stored into Temp List
			System.out.println("Original List: "+originalList);
		}
		System.out.println("Before Sorting Original List:"+originalList);

		List tempList = new ArrayList();  //Create Temporary list from Original List

		tempList=originalList; // Create Copy of Original List or stored original list into temp list

		System.out.println("Before Sorting Temporary List: "+tempList);


		Collections.sort(tempList);   //Sort the Temporary List

		System.out.println("After Sorting Temporary List: "+tempList);
		System.out.println("After Sorting the Original List: "+originalList);


		if(originalList==tempList) {
			System.out.println("DropDown is Sorted");
		}
		else {
			System.out.println("DropDown is not Sorted");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DropDownTest d = new DropDownTest();
		d.launchbrowser();
		d.verifyDropDownStoredOptions();
	}

}
