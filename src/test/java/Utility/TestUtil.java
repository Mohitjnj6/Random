package Utility;

import java.util.ArrayList;

import excelPractice.Xls_Reader;

public class TestUtil 
{
	static Xls_Reader reader;
	static String sheetname = "Sheet1";
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try 
		{
			reader = new Xls_Reader("C:\\Users\\Samsung\\Downloads\\rediffmail.xlsx");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int rownmbr=2; rownmbr <= reader.getRowCount(sheetname); rownmbr++)
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
			
			Object[] obj = {fullName,rediffid,password,rePassword,altEmail,mobile,days,months,years,countrys,captcha};
			myData.add(obj);

		}
		return myData;
		
	}

	
}
