import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Exercise1_Salesforce {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("jayant.cts24@gmail.com");
		driver.findElement(By.id("password")).sendKeys("jayasiri89");
		driver.findElement(By.id("Login")).click();
		
		if(driver.getTitle()=="Home | Salesforce"){
			System.out.println("home page displayed");
		}else{
			System.out.println("Home page not didplayed.");
		}
		
		
	}

}
