package excelPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws IOException 
	{
		File file = new File("C:/Users/Samsung/Downloads/rediffmail.xlsx");
		FileInputStream fis = new FileInputStream(file);
		 Workbook wb = WorkbookFactory.create(fis); 
		Sheet sh = wb.getSheet("Sheet1");
				 Row rw = sh.getRow(1);
				 Cell cl = rw.getCell(2);
				 cl.getCellType();
				  //String value = cl.getStringCellValue();
				 long abc = (long)cl.getNumericCellValue();
				 System.out.println(abc);
	}

}
