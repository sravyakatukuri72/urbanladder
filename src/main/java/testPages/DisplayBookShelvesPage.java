package testPages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import baseMethods.TestBase;
import dataDriven.WriteExcel;
import locators.BookShelvesLocators;

public class DisplayBookShelvesPage extends TestBase 
{

	//Element Locators:
	static By priceListElements = By.xpath("//div[@class='price-number']/span");
	static By nameListElements = By.xpath("//span[@class='name']");
		
	public DisplayBookShelvesPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		TestBase.driver=driver;
	}

	//Getting HomePageTitle:
	public static String validateHomePageTitle() throws InterruptedException 
	{
			return driver.getTitle();
	}
	
	
	public void closePopup() throws InterruptedException 
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='authentication_popup']/div[1]/div/div[2]/a[1]")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Searching for item:
	public static void searchBox(String input) throws InterruptedException 
	{
		
		try 
		{	
			BookShelvesLocators.search().sendKeys(input);
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
			BookShelvesLocators.clicking().click();
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
		
	//Selecting category:
	public static void setCategory() throws InterruptedException
	{
		try
		{
			BookShelvesLocators.category().click();
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			BookShelvesLocators.bookshelves().click();
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
	//Selecting storageType:
	public static void setStorageType() throws InterruptedException 
	{
		try
		{
			BookShelvesLocators.storageType().click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			BookShelvesLocators.typeOpen().click();  
			Thread.sleep(2000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//Selecting ExcludeOutOfStock:
	public static void clickOutOfStock() throws InterruptedException 
	{
			BookShelvesLocators.outofstockCheckbox().click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	//Selecting Recommendation:
	public static void setRecommandation() throws InterruptedException
	{
		try 
		{
			BookShelvesLocators.recommendation().click();
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			BookShelvesLocators.low().click();
			Thread.sleep(1000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
		
	//Getting BookDetails:
	public static void getBookDetails() throws InterruptedException 
	{
		try 
		{
			List <WebElement> allPrice =  driver.findElements(priceListElements);
			List <WebElement> allName =  driver.findElements(nameListElements);
		    
			System.out.print("BookShelves");
		    System.out.println("\n"+ "The price of the first three bookshelves below Rs.15000:");
		    Reporter.log("\n"+ "The price of the first three bookshelves below Rs.15000:");
		    String pric, name;
		 
		    List<String> priceList = new ArrayList<>();
		    int price;
	
		    int size = allPrice.size();
		    for(int i=0;i<size;i++)
		    { 
		    	 pric = allPrice.get(i).getText();
		    	 name= allName.get(i).getText();
		    	 pric = pric.replaceAll("₹","");
		    	 pric = pric.replaceAll(",","");
		    	 price = Integer.parseInt(pric);
		     
			     if(price < 15000)
			     {
			    	priceList.add(name+":");
				 	priceList.add("Rs."+pric);
				 } 
			     
		    }
		     
		    for(int i=0;i<6;i++)
		    {
		    	System.out.println(priceList.get(i).toString());
		    	Reporter.log(priceList.get(i).toString());
		    }
		    WriteExcel soie2 = new WriteExcel();
			soie2.displayBookshelves(allName,allPrice);	// Show output Excels
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}  
	}
}
