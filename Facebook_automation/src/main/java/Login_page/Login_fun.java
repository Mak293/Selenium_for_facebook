package Login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import Drivers.Driver_d;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_fun {
	
	Driver_d obj=new Driver_d();
	
	public By user_a=By.xpath("//*[@id='email']");
	public By pass_a=By.xpath("//*[@id='pass']");
	public By login_botton_a=By.xpath("//*[@id='loginbutton']");
	
	
	public void login(ChromeDriver driver,String username,String password)
	{
		WebElement user=driver.findElement(user_a);
		user.sendKeys(username);
		WebElement pass=driver.findElement(pass_a);
		pass.sendKeys(password);
		driver.findElement(login_botton_a).click();
	}
	
}
