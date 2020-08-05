package DataDriven;

import excelPractice.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) 
	{

		Xls_Reader reader = new Xls_Reader("C:\\Users\\Samsung\\Downloads\\rediffmail.xlsx");
		
		
		//its a good practice
		//To add a new sheet after confirming that new sheet already exist or note
		if(!reader.isSheetExist("HomePage"))
		{
			reader.addSheet("HomePage");
		}
		
		
		//To gat the row number of specific call.
		int cellNmbr = reader.getCellRowNum("Sheet1", "month", "MAY");
		System.out.println(cellNmbr);
	}

}
