package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseMethods.TestBase;

public class CollectionsMenuLocators extends TestBase 
{
	//Locating elements for CollectionsMenu 
	public CollectionsMenuLocators() throws Exception
	{
		super();
	}
	
	public static WebElement collectionsElements() 
	{
		return driver.findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[10]/span"));
	}
}
