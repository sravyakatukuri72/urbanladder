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
import testPages.DisplayBookShelvesPage;

public class DisplayBookShelves extends TestBase
{
	
	 static WebDriver driver = null;
	 public int i = 0;
	 @BeforeClass(groups= {"Smoke Test"})
	 //This method is used to invoking driver
	 public void initialiseSetUp() throws IOException 
	 {
		  logger = report.createTest("Display Bookshelves");
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
		  
	 @Test(priority = 3,groups= {"Smoke Test"})
	 //This method is use to call the 'searchBox' method
	 public void searchBoxTest() throws Exception 
	 {
		 DisplayBookShelvesPage.searchBox("BookShelves");
		 logger.log(Status.INFO, "Search data is entered");
	     logger.log(Status.PASS, "Test Passed");
		 
	 }
	 
	 @Test(priority = 4)
	 //This method is use to call the 'clickOnSearchButton' method
	 public void searchButtonTest() throws Exception 
	 {
		 DisplayBookShelvesPage.clickOnSearchButton(); 
		 logger.log(Status.INFO, "Search action performed");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 5)
	 //This method is use to call the 'setCategory' method
	 public void categoryTest() throws Exception 
	 {
		 DisplayBookShelvesPage.setCategory();
		 logger.log(Status.INFO, "Category is set");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 6,groups= {"Regression Test"})
	 //This method is use to call the 'setStorageType' method
	 public void storageTypeTest() throws Exception 
	 {
		 DisplayBookShelvesPage.setStorageType();	
		 logger.log(Status.INFO, "Storage type is selected");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 7,groups= {"Regression Test"})
	 //This method is use to call the 'clickOutOfStock' method
	 public void outOfStockTest() throws Exception 
	 {
		 DisplayBookShelvesPage.clickOutOfStock();
		 logger.log(Status.INFO, "out of box check box checked");
		 logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @Test(priority = 8,groups= {"Regression Test"})
	 //This method is use to call the 'setRecommandation' method
	 public void RecommandationTest() throws Exception 
	 {
		 DisplayBookShelvesPage.setRecommandation();
		 logger.log(Status.INFO, "Recommendation is set");
		 logger.log(Status.PASS, "Test Passed");
		 
	 }
	 
	 @Test(priority = 9)
	 //This method is use to call the 'getBookDetails' method
	 public void bookDetailsTest() throws Exception 
	 {
		 DisplayBookShelvesPage.getBookDetails();
		 logger.log(Status.INFO, "Bookshelves details are extracted");
		 logger.log(Status.PASS, "Test Passed");
     }
	 
	 @AfterClass
	 //This method is use to quit the driver
	 public void quitBrowser() 
	 {
		 driver.quit();
	 }
	 
	 //create custom report
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
