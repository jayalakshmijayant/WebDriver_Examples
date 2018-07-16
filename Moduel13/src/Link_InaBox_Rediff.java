import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Link_InaBox_Rediff {

	public static void main(String[] args) {
		// http://shopping.rediff.com/?sc_cid=ushome_icon
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.navigate helps us use the back and forward buttons in the browser. it remembers the history of execution.
		driver.navigate().to("https://shopping.rediff.com/?sc_cid=ushome_icon");
		
		String part1="//*[@id='popular_cat']/h3["; 
		String part2="]/a";
		
		// this for loop can be used only if we know exactly how many links are there inside the box.
		for(int i=1;i<=14;i++){
			String text=driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			System.out.println("clicking the link : "+text);
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			
			driver.navigate().back();
		}
	}

}
