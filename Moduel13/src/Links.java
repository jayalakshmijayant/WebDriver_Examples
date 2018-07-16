import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Links {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://bbc.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='orb-nav-links']/ul/li[2]/a")).click();
		Thread.sleep(10000);
		String str1=driver.findElement(By.xpath("//*[@id='orb-nav-links']/ul/li[1]/a")).getAttribute("href");
		System.out.println(str1);
		
		String str2=driver.findElement(By.cssSelector("div[id='orb-nav-links'] ul li:nth-child(3)")).getText();
		System.out.println(str2);
		
		driver.findElement(By.xpath("//a[text()='News']")).click();
	}

}
