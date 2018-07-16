import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Links_ThirdExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://shopping.rediff.com/?sc_cid=ushome_icon");
		
		List<WebElement> allLinks= driver.findElements(By.xpath("//*[@id='popular_cat']/h3/a")); 
		System.out.println("Total Num of Links in popular category : "+allLinks.size());
		
		
		for(int i=1; i<=allLinks.size();i++)
		{
			String text= driver.findElement(By.xpath("//*[@id='popular_cat']/h3["+i+"]/a")).getText();
			System.out.println("Link Title : "+text);
			driver.findElement(By.xpath("//*[@id='popular_cat']/h3["+i+"]/a")).click();
			System.out.println(driver.getTitle());
			
			driver.navigate().back();
		}
	}

}
