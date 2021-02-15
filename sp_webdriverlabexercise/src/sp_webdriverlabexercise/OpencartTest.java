package sp_webdriverlabexercise;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpencartTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action= new Actions(driver);
		//
		WebElement ele= driver.findElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]"));
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]")).click();
		
		//Short by price
		Select dropdown= new Select(driver.findElement(By.id("input-sort")));
		dropdown.selectByIndex(4);
		Thread.sleep(3000);
		
		//Add to cart
		String cartitem= driver.findElement(By.xpath("(//*[@class='caption']//a)[1]")).getText();
		System.out.println("Cart item is: "+cartitem);
		driver.findElement(By.xpath("(//*[contains(text(), 'Add to Cart')])[1]")).click();
		
		//Validate cart
		String expMessage= " Success: You have added "+cartitem+" to your shopping cart!";
		String actMessage= driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println("Expected Success message is:"+expMessage);
		System.out.println("Actual Success message is: "+actMessage);

		if(expMessage.equalsIgnoreCase(actMessage)) {
			System.out.println(cartitem+" is successfully added to cart");
		}
		
		WebElement search= driver.findElement(By.name("search"));
		search.sendKeys("Mobile");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		driver.getTitle();
		if(driver.getTitle().equalsIgnoreCase("Search - Mobile")) {
			System.out.println("Search successful!");
		}
		
		WebElement inputSearch = driver.findElement(By.id("input-search"));
		inputSearch.clear();
		inputSearch.sendKeys("Monitors");
		Thread.sleep(2000);
		driver.findElement(By.id("button-search")).click();
		
		driver.getTitle();
		if(driver.getTitle().equalsIgnoreCase("Search - Monitors")) {
			System.out.println("Search successful!");
		}
		
		
		

	}

}
