package Login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Profile_fun {
	
	public By status_a=By.cssSelector("div[role=\"button\"] > div > span[style*=\"webkit-box-orient\"]");
	public By text_area_a=By.cssSelector("div[aria-describedby*='placeholder']");
	public By post_bn_a=By.cssSelector("div[aria-label='Post']");
	
	public void profile(ChromeDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(status_a).click();
		Thread.sleep(3000);
		WebElement Textarea = driver.findElement(text_area_a);
		Textarea.click();
		Textarea.sendKeys("Hello World");
		WebElement PostBtn = driver.findElement(post_bn_a);
		PostBtn.click();
	}

}
