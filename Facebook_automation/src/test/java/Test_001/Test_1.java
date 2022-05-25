package Test_001;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Drivers.Driver_d;
import Extent_report.Extent_report_er;
import Locators.Locate_l;

public class Test_1 {								

	public ChromeDriver driver;
	Driver_d obj=new Driver_d();
	Locate_l adr=new Locate_l();
	Extent_report_er rep=new Extent_report_er();
	
	public String username="chauhanmohit293@gmail.com";
	public String password="123456@m";
	
	public Test_1()
	{
		obj.main(null);
		driver=obj.driver;
	}
	
	@Test
	public void login()
	{
		rep.logger=rep.report.startTest("Login");
		WebElement user=driver.findElement(adr.user_a);
		user.sendKeys(username);
		WebElement pass=driver.findElement(adr.pass_a);
		pass.sendKeys(password);
		driver.findElement(adr.login_botton_a).click();
		
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		
		rep.logger.log(LogStatus.INFO, "Check the Login page"); 
	}
	
	@Test
	public void post_status() throws InterruptedException
	{
		rep.logger=rep.report.startTest("Post Status");
		driver.findElement(adr.status_a).click();
		Thread.sleep(3000);
		WebElement Textarea = driver.findElement(adr.text_area_a);
		Textarea.click();
		Textarea.sendKeys("Hello World");
		WebElement PostBtn = driver.findElement(adr.post_bn_a);
		PostBtn.click();
		rep.logger.log(LogStatus.PASS, "Test CAse Passed");
		
		rep.logger.log(LogStatus.INFO, "Check for Status update"); 
	}
	
	@BeforeClass
	public void setExtent_e()
	{
		rep.setExtent();
	}
	@AfterClass
	public void endReport_e()
	{
		rep.endReport();
	}
	
	@AfterMethod
	public void getResult_e(ITestResult result) throws IOException
	{
		rep.getResult(result,driver);
	}
}
