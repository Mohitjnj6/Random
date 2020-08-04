package DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import excelPractice.Xls_Reader;

public class DataDriven1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Samsung\\Downloads\\rediffmail.xlsx");
		String sheetname = "Sheet1";
		int rowcnt = reader.getRowCount(sheetname);
		System.out.println(rowcnt);
		System.out.println(reader.getCellData(sheetname, 0, 2));
		
		for(int rownmbr = 2; rownmbr<=rowcnt; rownmbr++)
		{
			String fullName = reader.getCellData(sheetname, 0, rownmbr);

			String rediffid = reader.getCellData(sheetname, 1, rownmbr);

			String password = reader.getCellData(sheetname, 2, rownmbr);

			String rePassword = reader.getCellData(sheetname, 3, rownmbr);

			String altEmail = reader.getCellData(sheetname, 4, rownmbr);

			String mobile = reader.getCellData(sheetname, 5, rownmbr);

			String days = reader.getCellData(sheetname, 6, rownmbr);

			String months = reader.getCellData(sheetname, 7, rownmbr);

			String years = reader.getCellData(sheetname, 8, rownmbr);

			String countrys = reader.getCellData(sheetname, 9, rownmbr);

			String captcha = reader.getCellData(sheetname, 10, rownmbr);
			
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

	}

}
