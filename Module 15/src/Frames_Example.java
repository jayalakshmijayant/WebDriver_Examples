import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Frames_Example {

	public static void main(String[] args) {
		// 
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://paytm.com/");
		
		driver.findElement(By.xpath("//div[@class='_1Vt1']")).click();
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='input_0']")).sendKeys("xxx");
		//*[@id="input_0"]
	}

}
