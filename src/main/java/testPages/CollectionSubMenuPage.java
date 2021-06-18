package testPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.testng.Reporter;

import baseMethods.TestBase;
import dataDriven.WriteExcel;
import locators.CollectionsMenuLocators;

public class CollectionSubMenuPage extends TestBase
{
	
	//Element Locators:	
	static By submenuElements = By.xpath("//ul[@class='taxonslist']/li/a/span");
	
	//For Clicking on Collection menu:
	public static void clickOnCollection() throws InterruptedException 
	{
		try 
		{
			System.out.println("Collections SubMenu");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement collection = CollectionsMenuLocators.collectionsElements();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			collection.click();
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
		
	//To store the Submenus of Bring At Home:
	public static void displaySubmenu() throws Exception
	{
		try {
			  List<WebElement>allMenu = driver.findElements(submenuElements);
			  
		      System.out.println("\n"+"The submenu list from 'Being at home' column:");
		      Reporter.log("\n"+"The submenu list from 'Being at home' column:");

		  
		      List<String> submenuList = new ArrayList<>();
		      int submenuSize = allMenu.size();
		      
		      for(int i=0;i<submenuSize;i++)
			  { 
		     	 String menu = allMenu.get(i).getText();
		     	 submenuList.add(menu);
			  }
		      submenuList.removeAll(Arrays.asList("", null));
		      for(int i=0;i<13;i++)
			  {
			      System.out.println(submenuList.get(i).toString());
			      Reporter.log(submenuList.get(i).toString());
			      
			  }
		      WriteExcel output = new WriteExcel();
				output.displaySubMenu(submenuList);		
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}
