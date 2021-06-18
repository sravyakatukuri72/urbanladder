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
import testPages.DisplayStudyChairsPage;

public class DisplayStudyChairs extends TestBase{
	
	public int i = 0;
	  WebDriver driver =null;
	  @BeforeClass(groups="Smoke Test")
	  public void initialiseSetUp() throws IOException 
	  {
		  //This method is used to invoking driver
		  logger = report.createTest("Display Study Chairs");
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
		  
	 @Test(priority = 3,groups="Smoke Test")
	 //This method is use to call the 'searchBox' method
	  public void searchBoxTest() throws Exception 
	 {
		  DisplayBookShelvesPage.searchBox("Study Chairs");
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
	 //This method is use to call the 'getChairsDetails' method
	 public void chairDetailsTest() throws Exception 
	 {
		  DisplayStudyChairsPage.getChairsDetails();
		  logger.log(Status.INFO, "Study chair details are extracted");
		  logger.log(Status.PASS, "Test Passed");
	 }
	 
	 @AfterClass
	 //This method is used to quit the driver
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
