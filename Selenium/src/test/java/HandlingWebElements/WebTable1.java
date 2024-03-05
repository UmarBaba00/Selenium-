//package HandlingWebElements;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
////import SeleniumTests.LaunchBrowser;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class WebTable1 {
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
//	public void webTable() {
//		driver.get("file:///C:/SeleniumPractice.html");
//		int r = driver.findElement(By.xpath("html/body/table/tbody/tr")).size();  // get the size of rows present in webTable 
//		//Note: int is used at place of Dimenstion & Size() is used at place getSize();
//		System.out.println(r);
//		int c = driver.findElement(By.xpath("html/body/table/tbody/tr/th")).size(); //get size of columns
//		System.out.println(c);
//
//		for(int i=2; i<=r; i++) {     //Start from 2nd row
//			for(int j=1; j<=c; j++) {
//				System.out.println(driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+ " "); //+ "" is used for space 
//			}
//			System.out.println();  //only used to jump on next line
//		}
//	}
//
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		WebTable1 wt = new WebTable1();
//		wt.launchbrowser();
//		wt.webTable();
//
//	}
//
//}
