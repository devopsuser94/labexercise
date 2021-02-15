package sp_webdriverlabexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	static String actTitle;


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
		actTitle=driver.getTitle();
		if(actTitle.contentEquals("Account Login")) {
			System.out.println("Displayed Page Title is:"+ actTitle);
		}
		driver.findElement(By.xpath("//*[@class='btn btn-primary' and text()='Continue']")).click();
		
		actTitle=driver.getTitle();
		if(actTitle.contentEquals("Register Account")) {
			System.out.println("Displayed Page Title is:"+ actTitle);

	    }
		
		WebElement element=driver.findElement(By.xpath("//*[@class='btn btn-primary' and @value='Continue']"));
		element.click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
		String actdenMessage= driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText();
		String expdenMessage= "Warning: You must agree to the Privacy Policy!";
		if(actdenMessage.equalsIgnoreCase(expdenMessage)) {
			System.out.println("Displayed Error Message:"+actdenMessage);
		}
		
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("Data");
		driver.findElement(By.name("email")).sendKeys("abc1@test.com");
		driver.findElement(By.name("telephone")).sendKeys("1234567890");
		
		driver.findElement(By.name("password")).sendKeys("testing123");
		driver.findElement(By.name("confirm")).sendKeys("testing123");
		driver.findElement(By.name("agree")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary' and @value='Continue']")).click();;
		
		actTitle= driver.getTitle();
		if(actTitle.equalsIgnoreCase("Your Account Has Been Created!")) {
			System.out.println("Your Account Has Been Created!");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='btn btn-primary' and text()='Continue']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='View your order history']")).click();
			actTitle= driver.getTitle();
			if(actTitle.equalsIgnoreCase("Order History")) {
				System.out.println(actTitle+ " is successfully opened");
			}
		}
		else if(actTitle.equalsIgnoreCase("Register Account")) {
			String error=driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText();
			System.out.println("Error displayed "+ error);
			
		}
		driver.close();

  }
}
