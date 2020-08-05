package other;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learnwise {

	public static void main(String[] args) 
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://learnwise.wfglobal.org/#/IN/en/home/login");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rahul@gmail.com");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//button[@type='password']")).sendKeys("rahul123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
