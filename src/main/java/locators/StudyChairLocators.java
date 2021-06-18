package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseMethods.TestBase;

public class StudyChairLocators extends TestBase 
{
	//Locating elements for StudyChairs Page
	public StudyChairLocators() throws Exception
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
}
