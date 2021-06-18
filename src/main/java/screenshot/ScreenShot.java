package screenshot;


import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import baseMethods.TestBase;

import org.openqa.selenium.OutputType;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenShot extends TestBase
{
	
	public static int i=0;
	public static void screenShot() throws IOException 
	{
		//Converting WebDriver object to takeScreenshoot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		//Calling the getScreenshotAs() method to create an image file
		File Src=scrShot.getScreenshotAs(OutputType.FILE);
		
		//Giving the location
		String filePath = System.getProperty("user.dir")+"//Screenshot//Screenshot"+i+".png";
		i++;
		
		//Moving image file to new destination
		File Dest=new File(filePath);
		
		//copying file at destination
		FileUtils.copyFile(Src, Dest);				
	}
}
	

