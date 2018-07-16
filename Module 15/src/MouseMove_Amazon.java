import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseMove_Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://amazon.com");
		
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-shopall span.nav-line-2"))).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("span[aria-label='Amazon Video']"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//span[text()='All Videos']"))).click().build().perform();
		
	}

}
