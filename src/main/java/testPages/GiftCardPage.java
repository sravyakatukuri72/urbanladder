package testPages;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import baseMethods.TestBase;
import dataDriven.ReadExcel;
import locators.GiftCardsLocators;
import screenshot.ScreenShot;

public class GiftCardPage extends TestBase 
{
	
	//For clicking on GiftCard menu:
	public static void clickOnGiftCard() throws InterruptedException 
	{
		try
		{
			System.out.println("Gift Cards");
			GiftCardsLocators.gift().click();
			//waitLoad(2);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//For clicking on Birthday/Anniversary (choosen):
	public static void selectCard() throws InterruptedException  {
		try {
			GiftCardsLocators.customizeGift().click();	
			//waitLoad(2);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//For entering the amount value:
	public static void setAmount() throws InterruptedException 
	{
		try 
		{
			GiftCardsLocators.amount().sendKeys(ReadExcel.readExcel1());
			//Thread.sleep(3000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//For clicking Next Button:
	public static void clickNext() throws InterruptedException 
	{
		try 
		{
			GiftCardsLocators.giftEnter().click();	
			//Thread.sleep(3000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//For entering Recipient Name:
	public static void enterRecipientName() throws InterruptedException 
	{
		try
		{
			GiftCardsLocators.recipientName().sendKeys(ReadExcel.readExcel5());
			//Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//For entering Recipient Email:
	public static void enterRecipientEmail() throws InterruptedException
	{
		try 
		{
			GiftCardsLocators.recipientMail().sendKeys(ReadExcel.readExcel3());	
			//Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//For entering Sender Name:
	public static void enterSenderName() throws InterruptedException 
	{
		try 
		{
			GiftCardsLocators.senderName().sendKeys(ReadExcel.readExcel2());	
			//Thread.sleep(3000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//For entering Sender Number: 
	public static void enterSenderNo() throws InterruptedException
	{
		try 
		{
			GiftCardsLocators.senderPhNo().sendKeys(String.valueOf(ReadExcel.readExcel4()));
			//Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//For getting error message while entering invalid Sender Email:
	public static void displayErrorMessage() throws InterruptedException
	{
		try
		{
			WebElement mail = GiftCardsLocators.mailEnter1();
			mail.sendKeys(ReadExcel.readExcel6());
			//Thread.sleep(2000);
			GiftCardsLocators.mailEnter().click();
			String f= mail.getAttribute("validationMessage");
			GiftCardsLocators.submit().click();
			System.out.println("\n"+"The error message appeared for invalid e-mail: " +f +"\n");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
				
	}
	    
	//For Taking ScreenShot of the error alert message:
	public static void takeScreennShot()
	{
		try
		{
		    ScreenShot.screenShot();	
		    System.out.println("ScreenShot Successfully Captured.");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}

}
