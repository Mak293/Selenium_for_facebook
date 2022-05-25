package Locators;

import org.openqa.selenium.By;

public class Locate_l {

	public By user_a=By.xpath("//*[@id='email']");
	public By pass_a=By.xpath("//*[@id='pass']");
	public By login_botton_a=By.xpath("//*[@id='loginbutton']");
	public By status_a=By.cssSelector("div[role=\"button\"] > div > span[style*=\"webkit-box-orient\"]");
	public By text_area_a=By.cssSelector("div[aria-describedby*='placeholder']");
	public By post_bn_a=By.cssSelector("div[aria-label='Post']");
}
