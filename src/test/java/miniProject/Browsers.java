package miniProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers 
{
	public static WebDriver chrome_web()
	{
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver firefox_web()
	{
		WebDriver driver = new FirefoxDriver();
		return driver;		
	}
}
