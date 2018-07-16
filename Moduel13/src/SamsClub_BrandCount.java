import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SamsClub_BrandCount {

	public static void main(String[] args) {
		//https://www.samsclub.com/sams/baby-savings/15190259.cp?xid=cat_sub&navAction=jump
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.samsclub.com/sams/baby-savings/15190259.cp?xid=cat_sub&navAction=jump");
		
		List<WebElement> li= driver.findElements(By.cssSelector("label[id^='navLabels brand'] span:nth-child(2)"));
		System.out.println(li.size());
		int sum=0;
	for(int i=0;i<li.size();i++){
		int m=0;
		System.out.println(li.get(i).getText());
		String brandName=li.get(i).getText();
		String[] str=brandName.split("\\(");
		String newStr=str[1].replace(")", "");
		//System.out.println(str[0]+"____"+ str[1]);
		//sum=sum+Integer.parseInt(str[1].replace(")", ""));
			 m=Integer.parseInt(newStr);
			 sum=sum+m;
			 System.out.println(m);
		
	}
		System.out.println("Total no of items in all brands: "+sum);
	}
	
	

}
