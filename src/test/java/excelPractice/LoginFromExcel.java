package excelPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFromExcel {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		WebElement username = driver.findElement(By.name("login"));
		
		WebElement password = driver.findElement(By.name("passwd"));
		
		Xls_Reader reader = new Xls_Reader("C:/Users/Samsung/Downloads/rediffmail.xlsx");
		String sheetname = "Sheet1";
		
		int rwcount = reader.getRowCount(sheetname);
		
		for(int rownum = 2; rownum<= rwcount; rownum++)
		{
			String user = reader.getCellData(sheetname, 1, rownum);
			
			String pwd = reader.getCellData(sheetname, 2, rownum);
			
			Thread.sleep(3000);
			
			username.clear();
			username.sendKeys(user);
			
			password.clear();
			password.sendKeys(pwd);
			
		}
	
	}

}
