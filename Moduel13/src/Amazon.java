import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;


public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&switch_account=");
		driver.findElement(By.id("ap_email")).sendKeys("jayav.2007@gmail.com");
		
		try{
			if(driver.findElement(By.id("continue")).isDisplayed()){
			driver.findElement(By.id("continue")).click();
			}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	
		
		driver.findElement(By.id("ap_password")).sendKeys("jayasiri89");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(5000);
		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Green tea");
			driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			Thread.sleep(5000);
		
				driver.findElement(By.xpath("//*[@id='result_0']/div/div[2]/div/div/a/img")).click();
				
				String productTitle=driver.findElement(By.id("productTitle")).getText();
			productTitle = productTitle.replace("...","");
				driver.findElement(By.xpath("//*[@id='onetimeOption']/label/span/span")).click();
				driver.findElement(By.id("add-to-cart-button")).click();
				
				driver.findElement(By.xpath("//*[@id='nav-cart']")).click();
				List<WebElement> cartContent= driver.findElements(By.xpath("//*[@id='activeCartViewForm']/div[2]/div"));
				for(int i=1;i<=cartContent.size();i++){
					String str= driver.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div["+i+"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span")).getText();
					//System.out.println(str);
					if(str.contains(productTitle)){
						System.out.println(productTitle+" verified in cart");
						break;
					}else{
						System.out.println(str+ " does not contain "+ productTitle);
					}
				}
				//*[@id='activeCartViewForm']/div[2]/div[2]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span
			
			
	}

}
