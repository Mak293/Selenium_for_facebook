package Extent_report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Extent_report_er {
	
	public ExtentReports report;
	public ExtentTest logger;
	
	public void setExtent()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/test-output/Z_1.html",true);
		
	}
	
	public void endReport()
	{
		
		report.flush();
		report.close();
	}
	
	public void getResult(ITestResult result,ChromeDriver driver) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE )
		{
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getThrowable());
			logger.log(LogStatus.INFO, "Test Case Failed");
			
			String screenshotPath = getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String screenshotPath = getScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getThrowable());
		}
		report.endTest(logger);			
	}
	
	public String getScreenshot(ChromeDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
	}

}
