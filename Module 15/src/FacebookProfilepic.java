import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FacebookProfilepic {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.facebook.com");
		Set<String> s= driver.getWindowHandles();
		driver.findElement(By.id("email")).sendKeys("jayav.2007@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("jackiechan");
		
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		//*[@id="u_0_a"]/div[1]/div[1]/div/a/span/span
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//alert.accept();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("div[id='userNav'] a[href*='jayalakshmi.vijayakumar.9']")));
		driver.findElement(By.cssSelector("div[id='userNav'] a[href*='jayalakshmi.vijayakumar.9']")).click();
			
			Actions a=new Actions(driver);
			
			a.moveToElement(driver.findElement(By.cssSelector("img[class='profilePic img'")));
			driver.findElement(By.xpath("//*[@id='u_jsonp_2_b']")).click();
			//*[@id="u_jsonp_2_b"]
			s= driver.getWindowHandles();
			Iterator<String> it=s.iterator();
			String mainWindow=it.next();
			//String popUP=it.next();
			//it.next();
			driver.switchTo().window(mainWindow);
			a.moveToElement(driver.findElement(By.xpath("//input[@class='_n _5f0v']")), 18909, 300).click().build().perform();
			
			//driver.findElement(By.xpath("//input[@class='_n _5f0v']")).click();
			Process p=new ProcessBuilder(System.getProperty("user.dir")+"\\src\\Temp2.exe"," ","Open").start(); //temp2 for canceling upload
	}

}
