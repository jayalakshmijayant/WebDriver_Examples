import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown_SelectClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://qtpselenium.com/home/contact_trainer");
		
		WebElement dropList =	driver.findElement(By.name("country_id"));
		dropList.sendKeys("India");
		List<WebElement> allElem= dropList.findElements(By.tagName("option"));
		System.out.println("Total no of countries in list : "+ allElem.size());
		
		
		Select s=new Select(dropList);
		s.selectByValue("108");
		s.selectByVisibleText("Bangladesh");
		s.getFirstSelectedOption();
		
		for(int i =0; i<allElem.size();i++){
			System.out.println(allElem.get(i).getText()+ "__________" + allElem.get(i).getAttribute("selected"));
			
		}
		
	}

}
