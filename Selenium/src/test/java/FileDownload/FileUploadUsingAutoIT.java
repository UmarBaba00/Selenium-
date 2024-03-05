package FileDownload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingAutoIT {
	
WebDriver driver;
	
	@Test(priority=0)
	public void launchbrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	
	public void FileUploadusingAutoIT() throws IOException {
		driver.get("https://goo.gl/kNZ6Sr");
		
		driver.findElement(By.xpath(".//*[@id='RESULT_FileUpload-9']")).click();  //Clicked on BrowsFile Button
		
		Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\fileupload.exe");  //path of the exe file generated through AutoIt Editor
		                                                                        //Execute AutoIT exe file
		driver.findElement(By.xpath(".//*[@id='q21']/div/input[2]")).click();  //Clicked on upload button
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileUploadUsingAutoIT f = new FileUploadUsingAutoIT();
		f.launchbrowser();
		f.FileUploadusingAutoIT();

	}

}
