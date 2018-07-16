import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class File_UPload1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://qtpselenium.com/test/uploadform/contactform.php");
		
		//*[@id="photo"]
		//driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\Users\\jayav\\OneDrive\\Pictures\\Saved Pictures\\B.jpg");
		driver.findElement(By.xpath("//input[@id='photo']")).click();
		
		//Process p=new ProcessBuilder(System.getProperty("user.dir")+"\\src\\Temp1.exe"," ","Open").start();
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\Temp1.exe");
	}

}
