import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WIndow_Handles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://jobserve.com");
		Set<String> s= driver.getWindowHandles();
		System.out.println("Total windows opened: "+ s.size());
		Iterator<String> it=s.iterator();
		System.out.println(it.next());
		System.out.println("..........................................");
		driver.findElement(By.linkText("Aspire Media Group")).click();
		s= driver.getWindowHandles();
		System.out.println("Total windows opened: "+ s.size());
		it=s.iterator();
		String mainWindow=it.next();
		String popUP=it.next();
		
		driver.switchTo().window(popUP);
		driver.close();
		
		
		
	}

}
