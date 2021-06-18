package testScenarios;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseMethods.TestBase;
import testPages.CollectionSubMenuPage;
import testPages.DisplayBookShelvesPage;

public class CollectionsMenu extends TestBase{
	
	public int i = 0;
	WebDriver driver = null;
	
	@BeforeClass
	public void initialiseSetUp() throws IOException 
	{
		 //This method is used to invoking driver
		 logger = report.createTest("Collections Menu");
		 Properties prop = TestBase.setProperties();
		 driver=TestBase.driver();
		 driver.get(prop.getProperty("url"));
		 logger.log(Status.INFO, "Browser opened successfully");
		 logger.log(Status.PASS, "Test Passed");
		 driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 1)
	 //This method is use to call the 'validateHomePageTitle' method
	 public void homePageTitleTest() throws Exception 
	 {
		 //Use of Assert Function
		 String title=DisplayBookShelvesPage.validateHomePageTitle();
		 Assert.assertEquals(title, "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder");
		 logger.log(Status.INFO, "home page title is verified");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 2)
	 //This method is use to call the 'closePopup' method
	 public void closePopUpTest() throws Exception 
	 {
		  DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		  homepage.closePopup();
		  logger.log(Status.INFO, "Pop up is closed");
		  logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 3)
	 //This method is use to call the 'clickOnCollection' method
	 public void CollectionButtonTest() throws Exception 
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 CollectionSubMenuPage.clickOnCollection();
		 logger.log(Status.INFO, "Collections menu is displayed");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 4)
	 //This method is use to call the 'displaySubmenu' method
	 public void subMenuTest() throws Exception 
	 {
		 CollectionSubMenuPage.displaySubmenu();
		 logger.log(Status.INFO, "Submenu under collections is extracted to list");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @AfterClass
	 //This method is use to quit the driver
	 public void quitBrowser() 
	 {
	  	  driver.quit();
	 }
	 
	 //custom report
	 @AfterMethod
	 public void afterMyMethod(ITestResult result) throws IOException 
	 {
		i++;
		if(result.getStatus()==ITestResult.FAILURE)
		{
				updateResult(result.getTestClass().getName(),i,result.getName().toString(),"FAIL");
				simplename=result.getClass().getSimpleName();		
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
				updateResult(result.getTestClass().getName(),i,result.getName().toString(),"PASS");
				simplename=result.getClass().getSimpleName();	
		}
	}
	 
	 @AfterTest
	 public void endReport() 
	 {
			report.flush();
	 }
}
