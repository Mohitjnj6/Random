package DataDriven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import excelPractice.Xls_Reader;

public class CopyWebTableIntoExcel {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Samsung\\eclipse-workspace\\Ramdom\\src\\test\\java\\TestData\\Webtable.xlsx");
		String sheet = "WebTable";
		
		if(!reader.isSheetExist(sheet))
		{
			reader.addSheet(sheet);
			reader.addColumn(sheet, "Company");
			reader.addColumn(sheet, "Contact");
			reader.addColumn(sheet, "Country");

			
		}
		//Sample Xpath for this table
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//Lets break it
		//*[@id="customers"]/tbody/tr[ + ]/th[1]
		
		String preXpath_Company ="//*[@id=\"customers\"]/tbody/tr[";
		String postXpath_Company="]/td[1]";
		
		String preXpath_Contact ="//*[@id=\"customers\"]/tbody/tr[";
		String postXpath_Contact="]/td[2]";
		
		String preXpath_Country ="//*[@id=\"customers\"]/tbody/tr[";
		String postXpath_Country="]/td[3]";
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowLength = rowCount.size();
	
		
		
		for(int i= 2; i <= rowLength; i++)
		{
			String actualXpath_Company = preXpath_Company+i+postXpath_Company;
			String company = driver.findElement(By.xpath(actualXpath_Company)).getText();
			System.out.println(company);
			reader.setCellData(sheet, "Company", i, company);
			
			String actualXpath_Contact = preXpath_Contact+i+postXpath_Contact;
			String contact = driver.findElement(By.xpath(actualXpath_Contact)).getText();
			System.out.println(contact);
			reader.setCellData(sheet, "Contact", i, contact);
			
			String actualXpath_Country = preXpath_Country+i+postXpath_Country;
			String country = driver.findElement(By.xpath(actualXpath_Country)).getText();
			System.out.println(country);
			reader.setCellData(sheet, "Country", i, contact);
			
		}
		
		

		
		
		driver.quit();
		
	}
	
}
