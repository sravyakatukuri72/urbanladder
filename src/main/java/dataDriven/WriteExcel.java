package dataDriven;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
public class WriteExcel 
{
		public int size=3;//we have to display the first 3 data available
		
		//Extracting data of first 3 study chairs
		public void displayStudyChairs(List<WebElement> name, List<WebElement> price) throws Exception
		{
			//create a blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook(); 
		    // Create a blank sheet 
		    XSSFSheet sheet = workbook.createSheet("StudyChairs");
		    
		    // This data needs to be written (Object[]) 
		    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
		    data.put("1", new Object[]{ "Name", "Price (Rs)"}); 
		    for(int i=0; i<size; i++)
		    	data.put(Integer.toString(i+2), new Object[]{name.get(i).getText(), price.get(i).getText()}); 

		    // Iterate over data and write to sheet 
		    Set<String> keyset = data.keySet(); 
		    int rownum = 0; 
		    for (String key : keyset)
		    { 
		        // this creates a new row in the sheet 
		        XSSFRow row = sheet.createRow(rownum++); 
		        Object[] objArr = data.get(key); 
		        int cellnum = 0; 
		        for (Object obj : objArr) 
		        { 
		            // this line creates a cell in the next column of that row 
		            XSSFCell cell = row.createCell(cellnum++); 
		            if (obj instanceof String) 
		                cell.setCellValue((String)obj); 
		            else if (obj instanceof Integer) 
		                cell.setCellValue((Integer)obj); 
		        } 
		    }   
		    try 
		    { 
		        // this Writes the workbook
		    	FileOutputStream out=new FileOutputStream(System.getProperty("user.dir")+"//Output_Excel//StudyChairsDetails.xlsx"); 
		        workbook.write(out); 
		        out.close(); 
		        System.out.println("StudyChairsDetails.xlsx written successfully on disk."); 
		        workbook.close();
		    } 
		    catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		}
		
		//extracting the data of first 3 bookshelves after filters applied
		public void displayBookshelves(List<WebElement> name, List<WebElement> price) throws Exception
		{
			XSSFWorkbook workbook = new XSSFWorkbook(); 
		    // Create a blank sheet 
		    XSSFSheet sheet = workbook.createSheet("Bookshelves");
		    
		    // This data needs to be written (Object[]) 
		    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
		    data.put("1", new Object[]{ "Name",  "Price (Rs)"}); 
		    for(int i=0; i<size; i++)
		    	data.put(Integer.toString(i+1), new Object[]{name.get(i).getText(), price.get(i).getText()}); 

		    // Iterate over data and write to sheet 
		    Set<String> keyset = data.keySet(); 
		    int rownum = 0; 
		    for (String key : keyset)
		    { 
		        // this creates a new row in the sheet 
		        XSSFRow row = sheet.createRow(rownum++); 
		        Object[] objArr = data.get(key); 
		        int cellnum = 0; 
		        for (Object obj : objArr) 
		        { 
		            // this line creates a cell in the next column of that row 
		            XSSFCell cell = row.createCell(cellnum++); 
		            if (obj instanceof String) 
		                cell.setCellValue((String)obj); 
		            else if (obj instanceof Integer) 
		                cell.setCellValue((Integer)obj); 
		        } 
		    }   
		    try 
		    { 
		        // this Writes the workbook
		    	FileOutputStream out=new FileOutputStream(System.getProperty("user.dir")+"//Output_Excel//BookShelvesDetails.xlsx");
		        workbook.write(out); 
		        out.close(); 
		        System.out.println("BookShelvesDetails.xlsx written successfully on disk."); 
		        workbook.close();
		    } 
		    catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		}
		
		//extracting submenu as a list and storing data
		public void displaySubMenu(List<String> listitem)
		{
			XSSFWorkbook workbook = new XSSFWorkbook(); 
		    // Create a blank sheet 
		    XSSFSheet sheet = workbook.createSheet("MenuList"); 
		    
		    // This data needs to be written (Object[]) 
		    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
		    data.put("1", new Object[]{ "ListItems"}); 
		    for(int i=0; i<13; i++)
		    	data.put(Integer.toString(i+2), new Object[]{listitem.get(i)}); 

		    // Iterate over data and write to sheet 
		    Set<String> keyset = data.keySet(); 
		    int rownum = 0; 
		    for (String key : keyset)
		    { 
		        // this creates a new row in the sheet 
		        XSSFRow row = sheet.createRow(rownum++); 
		        Object[] objArr = data.get(key); 
		        int cellnum = 0; 
		        for (Object obj : objArr) 
		        { 
		            // this line creates a cell in the next column of that row 
		            XSSFCell cell = row.createCell(cellnum++); 
		            if (obj instanceof String) 
		                cell.setCellValue((String)obj); 
		            else if (obj instanceof Integer) 
		                cell.setCellValue((Integer)obj); 
		        } 
		    }   
		    try 
		    { 
		        // this Writes the workbook
		    	FileOutputStream out=new FileOutputStream(System.getProperty("user.dir")+"//Output_Excel//MenuList.xlsx");
		        workbook.write(out); 
		        out.close(); 
		        System.out.println("MenuList.xlsx written successfully on disk."); 
		        workbook.close();
		    } 
		    catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		}
}
