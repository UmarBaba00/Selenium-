package FileDownload;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileUsingSikuli {

	WebDriver driver;

	@Test(priority=0)
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void uploadFile(){
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Umar");

//		driver.findElement(By.xpath("//*[@id=\"imagesrc\"]")).click();  //File Upload Button WebElement location

		driver.findElement(By.xpath("//*[@id=\"imagesrc\"]")).sendKeys("C:\\Users\\admin\\Downloads\\info.pdf");
//		String imagesFilepath = "C:\\Users\\admin\\Documents\\SQA\\Sikuli";  //Location of Image file  
//		String inputFilepath = "C:\\Users\\admin\\Documents\\SQA\\Sikuli";
//		//imagesFilepath is basically captured images file path which sikuli used for pattern matching
//		//inputFilepath is basically actual image file path
//
//		Screen s = new Screen();
//
//		Pattern fileInputTextbox = new Pattern(imagesFilepath+"TextBox.PNG"); //Captured Textbox image path for sikuli image comparison
//		Pattern openButton = new Pattern(imagesFilepath+"OpenButton.PNG");   //Captured Button image path for sikuli image comparison
//		//Create sikuli pattern for image comparison
//
//		Thread.sleep(3000);
//
//		s.wait(fileInputTextbox);  //Wait for certain time before opening image file window
//		s.type(fileInputTextbox, inputFilepath+"1.jpeg");  //type is used to provide perticular image path to textbox
//		s.click(openButton);  //Click on Open Button

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UploadFileUsingSikuli f = new UploadFileUsingSikuli();
		f.launchbrowser();
		f.uploadFile();

	}

}
