import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Google_Results {
  static 	WebDriver driver;
 // static List<WebElement> linksRes;
  static Set<String> handles;
  static Iterator<String> it;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
		handles=driver.getWindowHandles();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Todays news");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		System.out.println("Result Links in page-1: ");
		displayResults();
	
		List<WebElement> tds= driver.findElements(By.cssSelector("a[aria-label^='Page']"));
		//System.out.println(tds.size());
		for(int i=1;i<5;i++){
			System.out.println("Result Links in Page :"+(i+1));
			driver.findElement(By.cssSelector("a[aria-label^='Page "+(i+1)+"']")).click();
			displayResults();
		}

	}
	public static void displayResults(){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@class='r']/a"))));
		
		
		List<WebElement> linksRes= driver.findElements(By.xpath("//h3[@class='r']/a"));
		System.out.println(linksRes.size());
		for(int i=0;i<linksRes.size();i++){
			String linkText=linksRes.get(i).getText();
			System.out.println(linkText);
			//WebElement resLink=linksRes.get(i);
			clickResLink(linkText);
		}
		System.out.println("____________________________________________________________________________");
		System.out.println();
	}
	public static void clickResLink(String linkText){
		String text=Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText(linkText)).sendKeys(text);
		handles=driver.getWindowHandles();
		it=handles.iterator();
		String first =it.next();
		String tab=it.next();
		
		driver.switchTo().window(tab);
		
		String pageTitle=driver.getTitle();
		pageTitle=pageTitle.substring(0, 15);
		linkText=linkText.substring(0, 15);
		if(pageTitle.contains(linkText)){
			System.out.println("Link : "+ linkText +" opened the right page.");
			driver.close();
			driver.switchTo().window(first);
		}else{
			System.out.println("Correct page not opened.");
			driver.close();
			driver.switchTo().window(first);
		}
		
	}
}
