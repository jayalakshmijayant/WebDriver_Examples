import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HandlingAjax_GoogleSrch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://google.com");
			
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("todays weather");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='sbsb_a']"))));
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='sbsb_a']"))).build().perform();
		WebElement box= driver.findElement(By.xpath("//div[@class='sbsb_a']"));
		List<WebElement> list= box.findElements(By.cssSelector("div[id^='sbse']"));
				//*[@id="sbtc"]/div[2]/div[2]/div[1]/div/ul/li[1]
		System.out.println("No of suggestion links : "+ list.size());
		for(int i=0;i<list.size();i++){
			String linkName= driver.findElement(By.cssSelector("div[id='sbse"+i+"']")).getText();
			System.out.println(linkName);
		}
		//clicking on a random link
		
		Random r=new Random();
		int num=r.nextInt(list.size());
		System.out.println("clicking on the "+num+" th link");
		a.moveToElement(driver.findElement(By.cssSelector("div[id='sbse"+num+"']"))).click().build().perform();
	} 

}
