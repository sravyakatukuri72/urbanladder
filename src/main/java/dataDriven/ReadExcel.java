package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

public class ReadExcel 
{
	//getting data from excel for giftcard
	public static XSSFSheet readExcel() throws IOException
	{
		//Getting the Relative path for excel from Source Excel folder
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath+"\\Input_Excel\\ULGiftCardEntry.xlsx");
		FileInputStream stream = new FileInputStream(file);
		//loading workbook, sheet
		XSSFWorkbook book = new XSSFWorkbook(stream);
		XSSFSheet sheet = book.getSheet("Sheet1");  
		book.close();
		return sheet;
	}
	
	//Getting data from excel file:
	public static String readExcel1() throws IOException 
	{
		String Amount = String.valueOf(readExcel().getRow(1).getCell(0));
	    return Amount;
	}
	public static String readExcel2() throws IOException 
	{
	    String Your_Name = String.valueOf(readExcel().getRow(1).getCell(1));
	    return Your_Name;
	}
	public static String readExcel3() throws IOException 
	{ 
	    String Your_Email = String.valueOf(readExcel().getRow(1).getCell(2));
	    return Your_Email;
	}
	public static long readExcel4() throws IOException 
	{
		long Your_Mobile = (long) readExcel().getRow(1).getCell(3).getNumericCellValue();
	    return Your_Mobile;
	}
	
	public static String readExcel5() throws IOException 
	{
	    String Recipient_Name =String.valueOf(readExcel().getRow(1).getCell(4));  
	    return Recipient_Name;
	}
	public static String readExcel6() throws IOException 
	{
	    String Recipient_Email =String.valueOf(readExcel().getRow(1).getCell(5));
	    return Recipient_Email;
	}

}
