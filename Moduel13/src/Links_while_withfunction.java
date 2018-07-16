import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Links_while_withfunction {
	static WebDriver driver=null;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.navigate helps us use the back and forward buttons in the browser. it remembers the history of execution.
		driver.navigate().to("https://shopping.rediff.com/?sc_cid=ushome_icon");
		
		String part1="//*[@id='popular_cat']/h3["; 
		String part2="]/a";
		int i=1;
		while(isElementPresent(part1+i+part2)){
			String text=driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			System.out.println("clicking the link : "+text);
			driver.findElement(By.xpath(part1+i+part2)).click();
		
			System.out.println(driver.getTitle());
			
			driver.navigate().back();
			i++;
		}
		}

	
	public static boolean isElementPresent(String xpath1){
	List<WebElement> li= driver.findElements(By.xpath(xpath1));
	if(li.size()==0){
		return false;
	}else
		return true;
	}
}
