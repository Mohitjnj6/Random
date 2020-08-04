package excelPractice;


public class ExcelFunctionallity {

	public static void main(String[] args) 
	{
	
		
		Xls_Reader reader = new Xls_Reader("C:/Users/Samsung/Downloads/rediffmail.xlsx");
		String sheetname = "Sheet1";
		String data = reader.getCellData(sheetname, 11, 2);//to get cell data
		System.out.println(data);
		int rwCnt = reader.getRowCount(sheetname); // to get row count
		System.out.println(rwCnt);
		
		int clCnt = reader.getColumnCount(sheetname); // to get column count
		System.out.println(clCnt);
		
		//reader.addSheet("sheet4"); // to add new sheet
		
		if (!reader.isSheetExist("sheet4"))
		{
			reader.addSheet("sheet4");
		}
		
		//reader.addColumn("Sheet1", "Status"); // to add new column 
		
		//reader.setCellData(sheetname, "Status", 2, "Pass");// to add data in cell
		
		//reader.removeColumn("sheet4", 0);

	}

}
