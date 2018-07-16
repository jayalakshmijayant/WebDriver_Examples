import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Lists_MSN {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://msn.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links inn MSN home page : " + allLinks.size());
		String str= allLinks.get(10).getText();
		String str1=allLinks.get(10).getAttribute("href");
		System.out.println("The 10th link is : "+ str );
		System.out.println("The 10th link is : "+ str1 );
		
		for(int i=0; i<allLinks.size();i++){
			System.out.println(allLinks.get(i).getText()+ " ..............  "+ allLinks.get(i).isDisplayed());
			allLinks = driver.findElements(By.tagName("a")); //this line will prevent a stale element refrerfce exception
		}
		
		
	}

}
