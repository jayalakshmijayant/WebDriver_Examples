import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseMove {
	public static void main(String[] args){
	System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://www.americangolf.co.uk/");
	
	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(By.linkText("Golf Clubs"))).build().perform();
	
	WebElement box= driver.findElement(By.xpath("//*[@id='CLUBS_1']"));
	List<WebElement> listLinks=box.findElements(By.tagName("a"));
	int linkNums=listLinks.size();
	System.out.println(linkNums);
	Random r=new Random();
	int randomNum=r.nextInt(linkNums);
	System.out.println(randomNum);
	
	//WebElement link=listLinks.get(randomNum);
	//System.out.println(link.getText());
	//link.click();
	
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(listLinks.get(randomNum).getText())));
	
	WebElement targetLink = driver.findElement(By.linkText(listLinks.get(randomNum).getText()));
	a.moveToElement(targetLink).click().build().perform();
	}
}