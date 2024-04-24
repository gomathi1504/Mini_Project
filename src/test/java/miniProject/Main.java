package miniProject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the Browser\n1.Chrome\n2.Firefox");
		
		//Getting the browser info from the user
		while(sc.hasNext())
		{
			int b = sc.nextInt();
			if(b==1)
			{
				driver = Browsers.chrome_web();
				break;
			}
			else if(b==2)
			{
				driver = Browsers.firefox_web();
				break;
			}
			else
			{
				System.out.println("Enter Valid Input");
				System.out.println("Select the Browser\n1.Chrome\n2.Firefox");
			}
		}
		sc.close();
		
		//Adding Implicit Wait condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Methods obj = new Methods();
		
     	Excel ex = new Excel();
		
		if(obj.launchWebsite(driver)) {
		ex.sendFirstResult("Title is Valid");
		}
		else {
			ex.sendFirstResult("Title is Not Valid");
		}
		obj.openSeating(driver);
		int recliners_count = obj.countRecliners(driver);
		ex.sendSecondfResult("Number of Recliners: "+recliners_count);
		int benches_count = obj.countBenches(driver);
		ex.sendThirdfResult("Number of Benches: "+benches_count);
		int lounge_chairs_count = obj.countLoungeChairs(driver);
		ex.sendFourthfResult("Number of Lounge chairs: "+lounge_chairs_count);
		int leatherette_benches_count = obj.countLeatheretteBenches(driver);
		ex.sendFifthResult("Number of Leatherette Benches: "+leatherette_benches_count);
		List<String> leatherette_benches = obj.diaplayBenches(driver);
		ex.sendSixthResult(leatherette_benches);
		
		Screenshots ss = new Screenshots();
		ss.takeScreenShot(driver);
		
		obj.closeBrowser(driver);
	}

}
