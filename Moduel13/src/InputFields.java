import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InputFields {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://gmail.com/");
		
		//getText() is used to retrieve the value of a value already present in the web page.
		System.out.println(driver.findElement(By.id("headingText")).getText());
		System.out.println(driver.findElement(By.id("headingSubtext")).getText());
		
		
		driver.findElement(By.id("identifierId")).sendKeys("jayav.2007@gmail.com");
	String str=	driver.findElement(By.id("identifierId")).getAttribute("value");
		System.out.println(str);
		
		System.out.println(driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).getText());

	}

}
