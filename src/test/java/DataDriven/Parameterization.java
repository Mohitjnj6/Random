package DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization 
{

	
	@Test
	@Parameters({"url", "username", "password"})
	public void Rediff(String url, String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(url);
		
		driver.findElement(By.cssSelector("input#useremail")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='passwd']")).sendKeys(password);
		
	}
}
