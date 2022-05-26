package Drivers;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_d {

public static ChromeDriver driver;
	
	public static void main(String []args)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
}
