package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseMethods.TestBase;

public class BookShelvesLocators extends TestBase 
{
	
	//Locating elements for Bookshelves Page
	public BookShelvesLocators() throws Exception
	{
		super();
	}
	
	public static WebElement search() 
	{
		return driver.findElement(By.id("search"));
	}
	
	public static WebElement clicking() 
	{
		return driver.findElement(By.xpath("//*[@id='search_button']"));
	}
	
	public static WebElement category() 
	{
		return driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]"));
	}
	
	public static WebElement bookshelves() 
	{
		return driver.findElement(By.xpath("//input[@id='filters_primary_category_Bookshelves']"));
	}
	
	public static WebElement storageType() 
	{
		return driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[1]"));
	}
	
	public static WebElement typeOpen() 
	{
		return driver.findElement(By.xpath("//input[@id='filters_storage_type_Open']"));
	}
	
	public static WebElement outofstockCheckbox() 
	{
		return driver.findElement(By.xpath("//input[@id='filters_availability_In_Stock_Only']"));
	}
	
	public static WebElement recommendation() 
	{
		return driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span"));
	}
	
	public static WebElement low() 
	{
		return driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[2]"));
	}

}
