package miniProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators 
{
	public static WebElement getSeating(WebDriver driver)
	{
		return driver.findElement(By.xpath("//h4[text()= 'Seating']"));		
	}
	
	public static WebElement closepopup(WebDriver driver)
	{
		return driver.findElement(By.linkText("Close"));
	}
	
	public static WebElement getRecliners(WebDriver driver)
	{
		return driver.findElement(By.linkText("All Recliners"));
	}
	
	public static List<WebElement> getReclinersCount(WebDriver driver)
	{
		return driver.findElements(By.xpath("//span[@class='name']"));
	}
	
	public static WebElement getBenches(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[text() = 'Benches']"));
	}
	
	public static List<WebElement> getBenchesCount(WebDriver driver)
	{
		return driver.findElements(By.xpath("//span[@class='name']"));
	}
	
	public static WebElement getLoungeChairs(WebDriver driver)
	{
		return driver.findElement(By.linkText("Lounge Chairs"));
	}
	
	public static List<WebElement> getLoungeChairsCount(WebDriver driver)
	{
		return driver.findElements(By.xpath("//span[@class='name']"));
	}
	
	public static WebElement getMaterial(WebDriver driver)
	{
		return driver.findElement(By.xpath("//li[@data-group='material']"));
	}
	
	public static WebElement getLeatherette(WebDriver driver)
	{
		return driver.findElement(By.xpath("//input[@value='Leatherette']"));
	}
	
	public static List<WebElement> getLeatheretteBenches(WebDriver driver)
	{
		return driver.findElements(By.xpath("//span[@class='name']"));
	}
}
