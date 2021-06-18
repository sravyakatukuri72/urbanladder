package testPages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import baseMethods.TestBase;
import dataDriven.WriteExcel;
import locators.StudyChairLocators;

public class DisplayStudyChairsPage extends TestBase{

	//Searching for item:
	public static void searchBox() throws InterruptedException 
	{
		try 
		{
			StudyChairLocators.search().sendKeys("Study Chairs");
			Thread.sleep(2000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
			
	//For searching:
	public static void clickOnSearchButton() throws InterruptedException 
	{
		try 
		{
			StudyChairLocators.clicking().click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
			
	static List<String> priceList = new ArrayList<>();
	 
	//Element Locators:
	static By priceListElements = By.xpath("//div[@class='price-number']/span");
	static By nameListElements = By.xpath("//span[@class='name']");
		
	//Getting ChairsDetails:
	public static void getChairsDetails() 
	{
			
		try 
		{
			List <WebElement> allPrice =  driver.findElements(priceListElements);
			List <WebElement> allName =  driver.findElements(nameListElements);
			System.out.println("Study Chairs");
			System.out.println("\n"+ "3 study chair details with highest recommendation");
			Reporter.log("\n"+ "The price of the first three study chair");
	
   	        String pric, name;
		       
			int size = allPrice.size();
			for(int i=0;i<size;i++)
			{ 
				pric = allPrice.get(i).getText();
			    name= allName.get(i).getText();
			    pric = pric.replaceAll("₹","");
			    pric = pric.replaceAll(",","");
			    priceList.add(name+":");
			    priceList.add("Rs."+Integer.parseInt(pric));
			}
			for(int i=0;i<6;i++)
			{
		    	System.out.println(priceList.get(i).toString());
		    	Reporter.log(priceList.get(i).toString());
			}
			WriteExcel soie = new WriteExcel();
			soie.displayStudyChairs(allName,allPrice);

		}
		catch(Exception e) 
		{
		    	 System.out.println(e);
		}
	}
}
