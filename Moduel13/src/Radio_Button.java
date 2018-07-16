import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Radio_Button {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.echoecho.com/htmlforms10.htm");
		List<WebElement> radios= driver.findElements(By.name("group1"));
		System.out.println(radios.size());
		System.out.println(radios.get(0).getAttribute("checked"));
		System.out.println(radios.get(1).getAttribute("checked"));
		
		radios.get(0).click();
	}

}
