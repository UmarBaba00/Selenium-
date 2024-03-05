//// 1) Open URL ; http://opensource.demo.orangehrmlive.com/
//// 2) Login (Admin/admin)
//// 3) Admin-->UserManagement-->users
//
////  Validation
//
////  Count number of Enabled Users
//
//
//package HandlingWebElements;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class WebTable2 {
//	
//
//	WebDriver driver;
//
//	@Test(priority=0)
//	public void launchbrowser(){
//		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(); //Invoke Chrome Browser
//		driver.manage().window().maximize();
//	}
//
//	@Test(priority=1)
//	public void webTable2() {
//		driver.get("http://opensource.demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin");
//		driver.findElement(By.id("btnLogin")).click();
//		
//		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
//		driver.findElement(By.id("menu_admin_userManagement")).click();
//		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
//		
//		int rowcount = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
//		int statuscount = 0;
//		for(int i=1; 1<rowcount; i++) {
//			String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[5]")).getText();
//			
//			if(status.equals("Enabled")) {
//				statuscount = statuscount + 1;
//			}
//		}
//		System.out.println(" No of Employees Enabled: "+ statuscount);
//		System.out.println("No of Employees Disabled"+ (rowcount-statuscount));
//		driver.close();
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebTable2 wt = new WebTable2();
//		wt.launchbrowser();
//		wt.webTable2();
//
//	}
//
//}
