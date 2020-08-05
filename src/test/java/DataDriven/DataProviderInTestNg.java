package DataDriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.TestUtil;

public class DataProviderInTestNg 
{
	WebDriver driver;
	
		@BeforeMethod
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
			driver  = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.get("https://register.rediff.com/register/register.php?FormName=user_details");	
		}
		
		@DataProvider
		public Iterator<Object[]> getTestData()
		{
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
		}
		
		
		@Test(dataProvider="getTestData")
		public void abc(String fullName, String rediffid, String password, String rePassword, String altEmail, String mobile, String days, String months, String years, String countrys, String captcha)
		{
			driver.findElement(By.cssSelector("input[name^='name']")).clear();
			driver.findElement(By.cssSelector("input[name^='name']")).sendKeys(fullName);

			driver.findElement(By.cssSelector("input[name^='login']")).clear();
			driver.findElement(By.cssSelector("input[name^='login']")).sendKeys(rediffid);

			driver.findElement(By.cssSelector("input[name^='passwd']")).clear();
			driver.findElement(By.cssSelector("input[name^='passwd']")).sendKeys(password);

			driver.findElement(By.cssSelector("input[name^='confirm_passwd']")).clear();
			driver.findElement(By.cssSelector("input[name^='confirm_passwd']")).sendKeys(rePassword);

			driver.findElement(By.cssSelector("input[name^='altemail']")).clear();
			driver.findElement(By.cssSelector("input[name^='altemail']")).sendKeys(altEmail);

			driver.findElement(By.cssSelector("input[name^='mobno']")).clear();
			driver.findElement(By.cssSelector("input[name^='mobno']")).sendKeys(mobile);
			
			WebElement day = driver.findElement(By.cssSelector("select[name^='DOB_Day']"));
			Select select = new Select(day);
			select.selectByVisibleText(days);

			WebElement month = driver.findElement(By.cssSelector("select[name^='DOB_Month']"));
			Select select2 = new Select(month);
			select2.selectByVisibleText(months);
			
			WebElement year = driver.findElement(By.cssSelector("select[name^='DOB_Year']"));
			Select select3 = new Select(year);
			select3.selectByVisibleText(years);
			
			
			WebElement country = driver.findElement(By.cssSelector("select[name^='country']"));
			Select select4 = new Select(country);
			select4.selectByVisibleText(countrys);

			driver.findElement(By.cssSelector("input[class='captcha']")).clear();
			driver.findElement(By.cssSelector("input[class='captcha']")).sendKeys(captcha);
		}
	
		
		@AfterMethod
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(7000);
			
			driver.quit();
		}

}
