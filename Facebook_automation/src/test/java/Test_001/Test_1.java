package Test_001;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Constants.Constants_c;
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
	Constants_c cnst=new Constants_c();
	Properties prop;
	
	
	public Test_1()
	{
		obj.main(null);
		driver=obj.driver;
	}
	
	@Test
	public void login() throws InterruptedException
	{
		rep.logger=rep.report.startTest("Login");
		driver.get(prop.getProperty("url"));
		lo.login(driver,prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(1500);
		String urll=driver.getCurrentUrl();
		Assert.assertEquals(urll, cnst.addre);
		
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		rep.logger.log(LogStatus.INFO, "Check the Login page"); 
	}
	
	@Test
	public void post_status() throws InterruptedException
	{
		rep.logger=rep.report.startTest("Post Status");
		pro.profile(driver);
		String user=driver.getTitle();
		
		Assert.assertEquals(user, cnst.expt_titl);
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		rep.logger.log(LogStatus.INFO, "Check for Status update"); 
	}
	
	@BeforeClass
	public void readProperties() throws FileNotFoundException
	{
		prop=new Properties();
		try {
				InputStream input=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
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
		driver.quit();
	}
	
	@AfterMethod
	public void getResult_e(ITestResult result) throws IOException
	{
		rep.getResult(result,driver);
	}
}
