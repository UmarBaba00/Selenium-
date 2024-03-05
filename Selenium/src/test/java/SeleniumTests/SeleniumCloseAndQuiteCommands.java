package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumCloseAndQuiteCommands extends LaunchBrowser {
	
	@Test(priority=4)
	public void CloseAndQuiteCommand() { //used to close and Quite the Browsers
		driver.get("https://www.dummysoftware.com/popupdummy_testpage.html");
		driver.close();  // Close Current Window
//		driver.quit();  // Close All Window
		
	}
//	
	@Test(priority=0)
	public void NavigationCommands() throws InterruptedException {  //Used to Navigate between the Windows
		driver.get("https://www.google.com.pk/");
		System.out.println("Title of the Page: "+ driver.getTitle());
		Thread.sleep(200);
		driver.navigate().to("https://www.facebook.com/");
		System.out.println("Title of the Page: "+ driver.getTitle());
		Thread.sleep(200);
		driver.navigate().back();
		System.out.println("Title of the Page: "+ driver.getTitle());
		Thread.sleep(200);
		driver.navigate().forward();
		System.out.println("Title of the Page: "+ driver.getTitle());
		Thread.sleep(200);
		driver.navigate().refresh();
		System.out.println("Title of the Page: "+ driver.getTitle());
		driver.close();
	}
	
	@Test(priority=1)
	public void ConditionalCommands() {   //Used to check WebElement is Displayed and Enabled on Webpage
		driver.get("https://www.facebook.com/");
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		
		if(email.isDisplayed() && email.isEnabled()) {
			email.sendKeys("bumar1209@gmail.com");
		}
		
		if(pass.isDisplayed() && pass.isEnabled()) {
			pass.sendKeys("Doctor@123");
		}
		
		else {
			System.out.println("WebElement is not present on WebPage");
		}
		
		WebElement btn = driver.findElement(By.name("login"));
		btn.click();
	}
	
	@Test(priority=2)
	public void isSelected() {   // My Method
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=1653377901&extra_1=s%7Cc%7C358050429248%7Ce%7Cfacebook%20sign%20up%7C&placement=&creative=358050429248&keyword=facebook%20sign%20up&partner_id=googlesem&extra_2=campaignid%3D1653377901%26adgroupid%3D65139789722%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-5066597374%26loc_physical_ms%3D9060968%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIkMCpnNnPggMVXJFoCR3CvAbiEAAYASAAEgJRi_D_BwE");
//		WebElement btn = driver.findElement(By.xpath("//*[@id=\"u_0_0_g7\"]"));
//		btn.click();
		
		//fmail
		WebElement female = driver.findElement(By.id("//*[@id=\"u_0_4_Qv\"]"));
		WebElement male = driver.findElement(By.id("u_0_5_j0"));
		WebElement custom = driver.findElement(By.id("u_0_6_Ww"));
		
		//Select Female Radio button
		if(female.isSelected()==false) {
			female.click();
		}
		System.out.println(female);
		
		if(male.isSelected()==false) {
			male.click();
		}
		System.out.println(male);
		
		if(custom.isSelected()==false) {
			custom.click();
		}
	System.out.println(custom);
	}
	
	
	@Test(priority=3)
	public void isSelected2() {    //Used to Select Radio Buttons
		driver.get("https://www.facebook.com/");
		
		//first select SignUp Button 
		
		//female
		System.out.println(driver.findElement(By.xpath(".//*[@id='u_0_g']")).isSelected());
		//male
		System.out.println(driver.findElement(By.xpath(".//*[@id='u_0_h']")).isSelected());
		
		//Select female Radio Button
		if(driver.findElement(By.xpath(".//*[@id='u_0_g']")).isSelected()==false) {
			driver.findElement(By.xpath(".//*[@id='u_0_g']")).click();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SeleniumCloseAndQuiteCommands c = new SeleniumCloseAndQuiteCommands();
		c.CloseAndQuiteCommand();
		c.NavigationCommands();
		c.ConditionalCommands();
		c.isSelected();
		c.isSelected2();

	}

}
