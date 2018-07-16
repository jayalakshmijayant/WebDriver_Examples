import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FB_PasswordEncode {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.facebook.com");
		Set<String> s= driver.getWindowHandles();
		
		String passwordEncoded="amFja2llY2hhbg==";
		driver.findElement(By.id("email")).sendKeys("jayav.2007@gmail.com");
		driver.findElement(By.id("pass")).sendKeys(decodePwd(passwordEncoded));
		
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);

	}
		public static String decodePwd(String password){
			
			byte[] decodedpwd=Base64.decodeBase64(password);
			return new String(decodedpwd);
	
		}
}
