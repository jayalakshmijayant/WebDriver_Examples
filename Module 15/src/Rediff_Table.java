import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Rediff_Table {

	public static void main(String[] args) {
		String companyName="Rallis India";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[1]
		//*[@id="leftcontainer"]/table
		List<WebElement> rowsName = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> price=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		for(int i=0;i<rowsName.size();i++){
			String compName=rowsName.get(i).getText();
			//String rate=rowsName.get(i).getText();
			if(companyName.equals(compName)){
				System.out.println("the company : "+companyName+" --------------   current price : "+price.get(i).getText());
			}
		}
		System.out.println("Companies with current price greater than 600 : ");
		for(int i=0;i<price.size();i++){
			String priceEachRow=price.get(i).getText();
			//System.out.println(priceEachRow);
			String[] priceFull= priceEachRow.split("\\.");
			String part1=priceFull[0];
			//double num= Double.parseDouble(priceEachRow);
			if(part1.contains(",")){
				part1=part1.replace(",","");
			}
			//System.out.println(part1);
			int num1=Integer.parseInt(part1);
			if(num1>600){
				System.out.println(rowsName.get(i).getText());
			}
		}
		
	}

}
