package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseMethods.TestBase;

public class GiftCardsLocators extends TestBase 
{
	
	//Locating elements for GiftCards Page
	public GiftCardsLocators() throws Exception
	{
		super();
	}
	   
	public static WebElement gift() 
	{
		return driver.findElement(By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a"));
	}
	
	public static WebElement customizeGift()
	{
		return driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]"));
	}
	
	public static WebElement amount() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_2251506436\"]"));		
	}
	
	public static WebElement giftEnter() 
	{
		return driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button"));
	}
	
	public static WebElement senderName() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_1082986083\"]"));
	}
	
	public static WebElement recipientName() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_4036288348\"]"));		
	}
	
	public static WebElement recipientMail() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_4081352456\"]"));	
	}
	
	public static WebElement senderPhNo() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_2121573464\"]"));
	}
	
	public static WebElement mailEnter1() 
	{
		return driver.findElement(By.id("ip_137656023"));
	}
	
	public static WebElement mailEnter() 
	{
		return driver.findElement(By.xpath("//*[@id=\"ip_4081352456\"]"));
	}
	
	public static WebElement submit() 
	{
		return driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button"));
	}
}
