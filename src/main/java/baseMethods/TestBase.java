package baseMethods;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReports.DateUtil;
import extentReports.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	
	@SuppressWarnings("unused")
	private static final Logger log = LogManager
			.getLogger(baseMethods.TestBase.class);

	public ExtentReports report = ExtentReport.getReportInstance();
	public ExtentTest logger;
	protected static WebDriver driver;
	public static Properties prop;
	static String projectPath = System.getProperty("user.dir");
	public static String simplename;

	//To load Properties File
	public static Properties setProperties() throws IOException 
	{
		prop = new Properties();
		FileInputStream input = new FileInputStream(projectPath+"\\Property\\Configure.properties");
		prop.load(input);
		
		return prop;
	}
	
	//Getting the browser from key value in propfile
	public static WebDriver driver () 
	{
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		        
		if(browserName.equals("chrome")) 
		{
			//To launch is Chrome Browser
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options=new ChromeOptions();
		            
		    options.addArguments("--disable-notification");
		    driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) 
		{ 
			//To launch in Edge Browser
			WebDriverManager.edgedriver().setup();
			new EdgeOptions();
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{ 
			//To launch in Firefox Browser
			WebDriverManager.firefoxdriver().setup();
			new FirefoxOptions();
			driver = new FirefoxDriver();
		}
		else
		{
			Reporter.log("Browser not exist");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	//Close Browser
	public void closeDriver()
	{
		driver.close();
	}
	
	//Custom Html Report creation
	public static void updateResult(String classname,int i,String methodname,String responsemsg) throws IOException
	{
		//gives date and time for report
		String startDateTime=new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
		//System.out.println("StartDateTime----"+startDateTime);
	
		//Location of report
		String resultFile=System.getProperty("user.dir")+"\\CustomReports\\customReport.html";
		File file=new File(resultFile);//object of file
		
		//if file does not exist it has to create one for frst time execution
		if(!file.exists())
		{
			FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw= new BufferedWriter(fw);
				
			bw.write("<html>"+"\n");
			bw.write("<head><title>"+ "Test Execution Report"+ "</title>"+"\n");
			bw.write("</head>"+"\n");
			bw.write("<body>");
			bw.write("<font face='Tahoma' size='2'>"+"\n");
			bw.write("<u><h1 align='center'>"+ "Test Execution Report"+"</h1></u>"+"\n");
			bw.flush();
			bw.close();
				
		}
		//creating table for first test
		BufferedWriter bw1= new BufferedWriter(new FileWriter(file,true));
		if(i==1) 
		{
			bw1.write("<table align='center' border='0' width='70%' height='10'>"+"\n");
			bw1.write("<tr><td width='70%'> </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>"+"\n");
			bw1.write("<tr>");
			bw1.write("<td colspan='1' align='center'><b><font color='#00000' face='Tahoma' size='2'>"+simplename+"</font></b></td>");
			bw1.write("<td colspan='2' align='left'><b><font color='#00000' face='Tahoma' size='2'>"+"StartDateTime"+startDateTime+"</font></b></td>");
			bw1.write("</tr>");
			bw1.write("</tr>");
			bw1.write("<td bgcolor='#CCCCFF' align='center'><b><font color='#00000' face='Tahoma' size='2'>S.No</font></b></td>");
			bw1.write("<td bgcolor='#CCCCFF' align='left'><b><font color='#00000' face='Tahoma' size='2'>Class Name</font></b></td>");
			bw1.write("<td bgcolor='#CCCCFF' align='left'><b><font color='#00000' face='Tahoma' size='2'>Test Name</font></b></td>");
			bw1.write("<td bgcolor='#CCCCFF' align='center'><b><font color='#00000' face='Tahoma' size='2'>Response</font></b></td>");
			bw1.write("</tr>");
		}
		
		//for remaining tests it will only enter records
		bw1.write("</tr>"+"\n");
		bw1.write("<td bgcolor='#FFFFDC' align='center'><b><font color='#00000' face='Tahoma' size='2'>" +i+" </font></b></td>");
		bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#00000' face='Tahoma' size='2'>" +classname+"</font></b></td>");
		bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#00000' face='Tahoma' size='2'>"+methodname+"</font></b></td>");
		bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#00000' face='Tahoma' size='2'>"+responsemsg+"</font></b></td>");
		bw1.write("</tr>"+"\n");
		bw1.write("</tbody>"+"\n");
		bw1.write("</html>");
		bw1.flush();
		bw1.close();
	}
	
	//Reporting Functions
	public void reportFail(String reportString) 
	{
		logger.log(Status.FAIL, reportString);
		takeScreenShot();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) 
	{
		logger.log(Status.PASS, reportString);
	}
		
	//Capture ScreenShot
	public void takeScreenShot() 
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("user.dir" + "/Screenshots/" + DateUtil.getTimeStamp() + ".png");
		try 
		{
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath("user.dir"+ "/Screenshots/" + DateUtil.getTimeStamp() + ".png");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}