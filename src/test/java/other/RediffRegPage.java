package other;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RediffRegPage {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.findElement(By.cssSelector("input[name^='name']")).sendKeys("Mohan Kumar");

		driver.findElement(By.cssSelector("input[name^='login']")).sendKeys("Mohan123");
		
		driver.findElement(By.cssSelector("input[name^='passwd']")).sendKeys("mohin@123");
		
		driver.findElement(By.cssSelector("input[name^='confirm_passwd']")).sendKeys("mohan@123");
		
		driver.findElement(By.cssSelector("input[name^='altemail']")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.cssSelector("input[name^='mobno']")).sendKeys("9874563217");
		
		WebElement day = driver.findElement(By.cssSelector("select[name^='DOB_Day']"));
		Select select = new Select(day);
		select.selectByVisibleText("12");

		WebElement month = driver.findElement(By.cssSelector("select[name^='DOB_Month']"));
		Select select2 = new Select(month);
		select2.selectByVisibleText("JAN");
		
		WebElement year = driver.findElement(By.cssSelector("select[name^='DOB_Year']"));
		Select select3 = new Select(year);
		select3.selectByVisibleText("1995");
		
		driver.findElement(By.cssSelector("input[name^='gender'][value^='f']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[name^='gender'][value^='m']")).click();
		
		WebElement country = driver.findElement(By.cssSelector("select[name^='country']"));
		Select select4 = new Select(country);
		select4.selectByVisibleText("Canada");
		
		driver.findElement(By.cssSelector("input[class='captcha']")).sendKeys("Y7PC");
		
		
		
		
		Thread.sleep(7000);
		
		driver.quit();
		
		
		
		

	}

}
