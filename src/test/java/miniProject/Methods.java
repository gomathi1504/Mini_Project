package miniProject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Methods 
{
	public static FileInputStream file;
	public static Properties p = new Properties();
	
	//1)Launch Website and Validate Title
	public Boolean launchWebsite(WebDriver driver)
	{
		try
		{
			file = new FileInputStream("C:\\Users\\2318582\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\UrbanLadder\\Properties.properties");
			p.load(file);
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
		driver.get(p.getProperty("baseUrl"));
		driver.manage().window().maximize();
		
		String actual_title = driver.getTitle();
		String expected_title = "Buy Furniture Online";
		if(actual_title.contains(expected_title))
		{
			System.out.println("Title is Valid");
			return true;
		}
		else
		{
			System.out.println("Title is not Valid");
			return false;
		}
	}
	
	//2)Open Seating and Recliners
	public void openSeating(WebDriver driver)
	{
		Locators.getSeating(driver).click();
		Locators.closepopup(driver).click();
	}
	
	//3)Counting Recliners
	public int countRecliners(WebDriver driver) throws InterruptedException
	{
		int count = 0;
		Locators.getRecliners(driver).click();
		Set<String> windowID1 = driver.getWindowHandles();
		List<String> windowID1s = new ArrayList<String>(windowID1);
		String childWindowID1 = windowID1s.get(1);
		
		driver.switchTo().window(childWindowID1);
		//Locators.closepopup(driver).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		List <WebElement> recliner = Locators.getReclinersCount(driver);
		count = recliner.size();
		System.out.println("Number of Recliners: "+count);
		return count;
	}
	
	//4)Counting Benches
	public int countBenches(WebDriver driver) throws InterruptedException
	{
		int count = 0;
		Set<String> windowID = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<String>(windowID);
		String parentWindowID = windowIDs.get(0);
		
		driver.switchTo().window(parentWindowID);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement bench = Locators.getBenches(driver);
		js.executeScript("arguments[0].click();", bench);
		Set<String> windowID2 = driver.getWindowHandles();
		List<String> windowID2s = new ArrayList<String>(windowID2);
		String childWindowID2 = windowID2s.get(2);
		
		driver.switchTo().window(childWindowID2);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		List <WebElement> benches = Locators.getBenchesCount(driver);
		count = benches.size();
		System.out.println("Number of Benches: "+count);
		return count;
	}
	
	//5)Counting Lounge Chairs
	public int countLoungeChairs(WebDriver driver) throws InterruptedException
	{
		int count = 0;
		Set<String> windowID = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<String>(windowID);
		String parentWindowID = windowIDs.get(0);
		
		driver.switchTo().window(parentWindowID);
		Locators.getLoungeChairs(driver).click();
		Set<String> windowID3 = driver.getWindowHandles();
		List<String> windowID3s = new ArrayList<String>(windowID3);
		String childWindowID3 = windowID3s.get(3);
		
		driver.switchTo().window(childWindowID3);
		Thread.sleep(5000);
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(12000);
		List <WebElement> lounge_chairs = Locators.getLoungeChairsCount(driver);
		count = lounge_chairs.size();
		System.out.println("Number of Lounge Chairs: "+count);
		return count;
	}
	
	//6)Counting Leatherette Benches
	public int countLeatheretteBenches(WebDriver driver) throws InterruptedException
	{
		int count = 0;
		Set<String> windowID = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<String>(windowID);
		String childWindowID2 = windowIDs.get(2);
		
		driver.switchTo().window(childWindowID2);
		Actions act = new Actions(driver);
		WebElement material = Locators.getMaterial(driver);
		WebElement leatherette = Locators.getLeatherette(driver);
		act.moveToElement(material).moveToElement(leatherette).click().perform();
		Thread.sleep(5000);
		List<WebElement> leatherette_benches = Locators.getLeatheretteBenches(driver);
		count = leatherette_benches.size();
		System.out.println("Number of Leatherette Benches: "+count);
		return count;
	}
	
	//7)Displaying Filtered Benches
	public List <String> diaplayBenches(WebDriver driver)
	{
		List<WebElement> display_benches = Locators.getLeatheretteBenches(driver);
		List<String> leatherette_benches = new ArrayList<String>();
		for(int i=0; i<display_benches.size(); i++)
		{
			leatherette_benches.add(display_benches.get(i).getText());
		}
		System.out.println("List of Leatherette Benches");
		for(String bench : leatherette_benches)
		{
			System.out.println(bench);
		}
		return leatherette_benches;
	}
	
	//8)Close Browser
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
