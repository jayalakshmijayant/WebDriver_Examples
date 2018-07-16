import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class FB_FriendsName {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.facebook.com");
		Set<String> s= driver.getWindowHandles();
		
		String passwordEncoded="amFja2llY2hhbg==";
		driver.findElement(By.id("email")).sendKeys("jayav.2007@gmail.com");
		driver.findElement(By.id("pass")).sendKeys(decodePwd(passwordEncoded));
		
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.cssSelector("div[id='userNav'] a[href*='jayalakshmi.vijayakumar.9']")).click();
		//*[@id="u_jsonp_2_7"]/li[3]/a
		driver.findElement(By.xpath("//a[text()='Friends']")).click();
		//*[@id="collection_wrapper_2356318349"]
		
		WebElement box=driver.findElement(By.cssSelector("div[id='pagelet_timeline_medley_friends']"));
		//*[@id="pagelet_timeline_medley_friends"]
		
		//Actions a =new Actions(driver);
		
		//WebElement element=driver.findElement(By.xpath("//div[@class='pagelet_timeline_medley_movies']"));
		for(int i=0;i<15;i++){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		//File f=((TakesScreenshot)driver).getScreenshotAs(target)
		}
		List<WebElement> frndsList= box.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
		//*[@id="pagelet_timeline_app_collection_1352150882:2356318349:2"]/ul[1]/li[1]/div
		//*[@id="pagelet_timeline_app_collection_1352150882:2356318349:2"]/ul[1]/li[1]/div/div/div[2]/div/div[2]/div/a
		//*[@id="pagelet_timeline_app_collection_1352150882:2356318349:2"]/ul[1]/li[1]/div/div/div[2]
		System.out.println("Total friends: "+ frndsList.size());
		
		for(int j=0;j<frndsList.size();j++){
			String name=frndsList.get(j).getText();
			System.out.println(name);
		}
		
		
		
		
		
	}
		public static String decodePwd(String password){
			
			byte[] decodedpwd=Base64.decodeBase64(password);
			return new String(decodedpwd);
	
		}
		

}
