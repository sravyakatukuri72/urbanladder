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
import testPages.GiftCardPage;

public class GiftCard extends TestBase
{
	
	  public int i = 0;
	  WebDriver driver = null;
	  @BeforeClass
	  public void initialiseSetUp() throws IOException 
	  {
		  //This method is used to invoking driver
		  logger = report.createTest("GiftCards");
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
	  //This method is use to call the 'clickOnGiftCard' method
	  public void GiftCardButtonTest() throws Exception 
	  {
		  GiftCardPage.clickOnGiftCard();
		  logger.log(Status.INFO, "GiftCard page is opened");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 4,groups="Regression Test")
	  //This method is use to call the 'selectCard' method
	  public void selectCardTest() throws Exception 
	  {
		  GiftCardPage.selectCard();
		  logger.log(Status.INFO, "Card is selected");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 5)
	  //This method is use to call the 'setAmount' method
	  public void AmountTextBoxTest() throws Exception 
	  {
		  GiftCardPage.setAmount();
		  logger.log(Status.INFO, "Amount is entered");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 6)
	  //This method is use to call the 'enterRecipientName' method
	  public void RecipientNameTest() throws Exception 
	  {
		  GiftCardPage.enterRecipientName();
		  logger.log(Status.INFO, "Recepient name is entered");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 7)
	  //This method is use to call the 'enterSenderName' method
	  public void senderNameTest() throws Exception 
	  {
		  GiftCardPage.enterSenderName();
		  logger.log(Status.INFO, "Sender name is entered");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 8)
	  //This method is use to call the 'enterRecipientEmail' method
	  public void RecipientEmailTest() throws Exception 
	  {
		  GiftCardPage.enterRecipientEmail();
		  logger.log(Status.INFO, "Recepient mail is entered");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 9)
	  //This method is use to call the 'enterSenderNo' method
	  public void senderNoTest() throws Exception 
	  {
		  GiftCardPage.enterSenderNo();
		  logger.log(Status.INFO, "Sender mobile number is entered");
			 logger.log(Status.PASS, "Test Passed");
		  
	  }
	  
	  @Test(priority = 10)
	  //This method is use to call the 'displayErrorMessage' method
	  public void errorMessageTest() throws Exception 
	  {
		  GiftCardPage.displayErrorMessage();
		  logger.log(Status.INFO, "error message is displayed");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @Test(priority = 11)
	  //This method is use to call the 'takeScreenShot' method
	  public void screenShotTest() throws Exception 
	  {
		   GiftCardPage.takeScreennShot();
		   logger.log(Status.INFO, "screenshot is taken");
			 logger.log(Status.PASS, "Test Passed");
	  }
	  
	  @AfterClass
	  //This method is use for quit the driver
	  public void quitBrowser() 
	  {
	  	  driver.quit();
	  }
	  
	  //custom reports
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
