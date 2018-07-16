import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.jna.platform.FileUtils;






public class CheckBox {

	public static void main(String[] args) {
		//https://www.dominos.com/en/pages/order/#/section/Food/category/AllEntrees/
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.dominos.com/en/pages/order/#/section/Food/category/AllEntrees/");
		//File dominos= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//dominos.
		//FileUtils.copyFile(dominos,new File("C:\\xyz.jpg"));
	driver.findElement(By.xpath("//*[@id='toppingsWrapper']/div[3]/div/div[2]/div/div[1]/div[3]/label/input")).click();

}
}