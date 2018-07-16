import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class rediff_company_search {
	static 	String currentPrice;
	public static void main(String[] args) {
		
		String companyName="Reliance Inds.";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://money.rediff.com/gainers/bse");
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[1]
		//*[@id="leftcontainer"]/table
		List<WebElement> compsName = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> curprice=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		for(int i=0;i<compsName.size();i++){
			String compName=compsName.get(i).getText();
			//String rate=rowsName.get(i).getText();
			if(compName.equals(companyName)){
				 currentPrice=curprice.get(i).getText();
				System.out.println("Current price of : "+companyName+" is : "+currentPrice);
				//currentPrice=currentPrice1;
			}
		
		}
		//Reliance Industries Ltd.
		driver.findElement(By.xpath("//*[@id='srchword']")).sendKeys("Reliance Industries Ltd.");
		driver.findElement(By.xpath("//*[@id='srchword']")).sendKeys(Keys.ENTER);
		
		String pageTitle=driver.getTitle();
		if(pageTitle.contains("Reliance Industries Ltd")){
			System.out.println("Right page displayed upon searching for : "+companyName);
			String curPricefromPage= driver.findElement(By.xpath("//*[@id='ltpid']")).getText();
			if(curPricefromPage.equals(currentPrice)){
				System.out.println("Value of current price same in both pages.");
			}
		}
	}

}
