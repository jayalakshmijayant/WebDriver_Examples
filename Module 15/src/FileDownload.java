import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class FileDownload {

	public static void main(String[] args) throws AWTException, InterruptedException {
	/*	System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		FirefoxProfile prof=new FirefoxProfile();
		prof.setPreference("browser.download.folderList", 2);
		prof.setPreference("browser.download.manager.showWhenStarting", false);// prevent Download Manager window
		prof.setPreference("browser.download.dir", "C:\\Users\\jayav\\Documents\\Java learning notes");//path
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		prof.setPreference("browser.download.manager.alertOnEXEOpen", false);//warn the user attempting to open an executable from the Download Manager
		
		FirefoxOptions opt=new FirefoxOptions().setProfile(prof);
		
		WebDriver driver = new FirefoxDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://qtpselenium.com/test/testdownload.php");
		
		 driver.findElement(By.xpath("html/body/a[1]")).click();*/
		
		 System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
			WebDriver driver= new InternetExplorerDriver();
			driver.get("http://qtpselenium.com/test/testdownload.php");
		    driver.findElement(By.xpath("//*[text()='Word Doc']")).click();
		    
		    Robot rb = new Robot();
		    rb.keyPress(KeyEvent.VK_LEFT);
		    Thread.sleep(3000);
		    rb.keyPress(KeyEvent.VK_ENTER);
		    Thread.sleep(3000);
		    rb.keyPress(KeyEvent.VK_ENTER);
		    Thread.sleep(3000);
		    rb.keyPress(KeyEvent.VK_ENTER);

	}

}
