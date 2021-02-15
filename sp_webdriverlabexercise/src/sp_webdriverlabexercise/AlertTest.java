package sp_webdriverlabexercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///F:/Selenium_Handson/Sample/AlertBoxDemos.html");
		
		//Simple Alert
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		Alert confirm= driver.switchTo().alert();
		System.out.println("Alert Message:"+ confirm.getText());
		confirm.accept();
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(1000);
		Alert prompt= driver.switchTo().alert();
		System.out.println("Alert Message:"+ prompt.getText());
		prompt.sendKeys("Testing");
		prompt.accept();
		
		
		
		
	}

}
