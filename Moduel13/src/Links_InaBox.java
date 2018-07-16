import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Links_InaBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://msn.com/");
		WebElement Trendbox= driver.findElement(By.xpath("//*[@id='main']/div[5]/ul/li[11]/div"));
		List<WebElement> lists=Trendbox.findElements(By.tagName("a"));
		System.out.println("Total Links in Trending now box : "+ lists.size());
		
		
		for(int i=0;i<lists.size();i++){
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Link " + i +" is "+ lists.get(i).getText());
			lists.get(i).click();
			System.out.println("Page Title: "+ driver.getTitle());
			
	
		//	driver.findElement(By.xpath("//*[@id='header-common']/a[1]")).click();
			//*[@id='header-common']/h1/a[1]/span
			//this avoids stale element ref exception..
			
			driver.get("https://msn.com/");
			
			Trendbox= driver.findElement(By.xpath("//*[@id='main']/div[5]/ul/li[11]/div"));
			lists=Trendbox.findElements(By.tagName("a"));
			
		}
	}

}
