import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://jqueryui.com/droppable/");
		//WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(0);
		WebElement src= driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).build().perform();
	
		driver.switchTo().defaultContent();
	}

}
