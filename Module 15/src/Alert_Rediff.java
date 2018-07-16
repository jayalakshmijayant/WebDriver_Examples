import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Alert_Rediff {

	public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
			
			driver.findElement(By.xpath("//input[@name='proceed']")).click();
			Alert a=driver.switchTo().alert();
			System.out.println("Alert detected : "+ a.getText());
			a.accept();
		
	}
}
