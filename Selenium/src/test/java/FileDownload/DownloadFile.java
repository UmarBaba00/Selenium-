package FileDownload;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void launchbrowser(){
		
		/*//Download files in required location using Chrome
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		
		chromePreferences.put("profile.default_content_setting.popups", 0);
		chromePreferences.put("download.prompt_for_download", false);
		chromePreferences.put("download.default_directory", "C:\\Users\\admin\\Downloads\\ChromeDownloadFiles");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePreferences);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(cap); //Invoke Chrome Browser*/
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void downloadFile() {
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		//Download Text File
		//id of TextBox
		driver.findElement(By.id("textbox")).sendKeys("Selenium Automation Testing");
		
		//id of Generate File Button
		driver.findElement(By.id("createTxt")).click(); //Generate Txt file
		
		//id of Download link
		driver.findElement(By.id("link-to-download")).click(); //Display download and click
		
//		driver.quit();
		
		//Download PDF File
		driver.findElement(By.id("pdfbox")).sendKeys("Selenium Automation Testing PDF Download");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
	}
	
	@Test(priority=2)
	public void isFileExist() {
	
		//Check File Availability in Folder
		String path1 = "C:\\Users\\admin\\Downloads\\info.pdf";
//		String path2 = "C:\\\\Users\\\\admin\\\\Downloads\\\\ChromeDownloadFiles"; // IF want to download file into Specified location
		File f = new File(path1);
		
		if(f.exists()) {
		System.out.println("File Exist");
		}		
		else {
			System.out.println("File Not Exist");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DownloadFile d = new DownloadFile();
		d.launchbrowser();
		d.downloadFile();
		d.isFileExist();
	}

}
