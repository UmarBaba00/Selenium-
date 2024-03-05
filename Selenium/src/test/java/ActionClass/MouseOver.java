package ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

		WebDriver driver;

		@Test(priority=0)
		public void launchbrowser(){
			//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); //Invoke Chrome Browser
			driver.manage().window().maximize();
		}

		@Test(priority=1)
		public void mouseOver() {
			driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
			
			//Login
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			driver.findElement(By.id("btnLogin")).click();
			
			Actions act = new Actions(driver);
			
			
			WebElement admin =driver.findElement(By.id("menu_admin_viewAdminModule"));
			WebElement userManagement = driver.findElement(By.id("menu_admin_userManagement"));
			WebElement users =driver.findElement(By.id("menu_admin_viewSystemUsers"));
			
//			act.moveToElement(admin).build().perform();    //MoveOver to admin tab
//			act.moveToElement(userManagement).build().perform();  //MouseOver to User Management tab
//			act.moveToElement(users).click().build().perform();  //MouseOver to Users tab and click on it
//			
			
			act.moveToElement(admin).moveToElement(userManagement).moveToElement(users).click().build().perform();
			
			/*int rowcount = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
			int statuscount = 0;
			for(int i=1; 1<rowcount; i++) {
				String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[5]")).getText();
				
				if(status.equals("Enabled")) {
					statuscount = statuscount + 1;
				}
			}
			System.out.println(" No of Employees Enabled: "+ statuscount);
			System.out.println("No of Employees Disabled"+ (rowcount-statuscount));
			driver.close();*/
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MouseOver m = new MouseOver();
			m.launchbrowser();
			m.mouseOver();

		}

	}
