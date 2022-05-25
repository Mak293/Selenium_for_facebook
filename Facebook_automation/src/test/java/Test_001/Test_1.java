package Test_001;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Drivers.Driver_d;
import Extent_report.Extent_report_er;
import Login_page.Login_fun;
import Login_page.Profile_fun;

public class Test_1 {								

	public ChromeDriver driver;
	Driver_d obj=new Driver_d();
	Extent_report_er rep=new Extent_report_er();
	Login_fun lo=new Login_fun();
	Profile_fun pro=new Profile_fun();
	Properties prop;
	
	String expt_titl="(20+) Facebook";
	
	public Test_1()
	{
		obj.main(null);
		driver=obj.driver;
	}
	
	@Test
	public void login()
	{
		rep.logger=rep.report.startTest("Login");
		driver.get(prop.getProperty("url"));
		lo.login(driver,prop.getProperty("username"),prop.getProperty("password"));
		String urll=driver.getCurrentUrl();
		Assert.assertEquals(urll, prop.getProperty("url"));
		
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		rep.logger.log(LogStatus.INFO, "Check the Login page"); 
	}
	
	@Test
	public void post_status() throws InterruptedException
	{
		rep.logger=rep.report.startTest("Post Status");
		pro.profile(driver);
		String user=driver.getTitle();
		
		Assert.assertEquals(user, expt_titl);
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		rep.logger.log(LogStatus.INFO, "Check for Status update"); 
	}
	
	@BeforeClass
	public void readProperties() throws FileNotFoundException
	{
		prop=new Properties();
		try {
				InputStream input=new FileInputStream("C:\\Users\\GL63\\git\\Selenium_for_facebook\\Facebook_automation\\src\\main\\java\\config\\config.properties");
				prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void setExtent_e()
	{
		rep.setExtent();
	}
	@AfterClass
	public void endReport_e() throws InterruptedException
	{
		rep.endReport();
		Thread.sleep(3000);
		//driver.quit();
	}
	
	@AfterMethod
	public void getResult_e(ITestResult result) throws IOException
	{
		rep.getResult(result,driver);
	}
}
