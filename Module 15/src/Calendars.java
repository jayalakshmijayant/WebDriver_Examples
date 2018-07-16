import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Calendars {
	static WebDriver driver;
	public static void main(String[] args) throws ParseException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		 driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.makemytrip.com/flights/");
		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		//#dp1512667525539 > div > div.ui-datepicker-group.ui-datepicker-group-first > div
		selectDate("14/02/2018");
	//	driver.findElement(By.xpath("//*[@id='hp-widget__return']")).click();
	//	selectDate("14/08/2018");
	}
	public static void selectDate(String date) throws ParseException{
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date datetobeSelected=df.parse(date);
		Date currentDate=new Date();
		//System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(currentDate));
		String monthyearDisplayed= driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-first div:nth-child(2)")).getText();
		//System.out.println(monthyearDisplayed);
		String month=new SimpleDateFormat("MMMM").format(datetobeSelected);
		month=month.toUpperCase();
		String year=new SimpleDateFormat("yyyy").format(datetobeSelected);
		String day=new SimpleDateFormat("d").format(datetobeSelected);
		String monthYeartobeSelected=month+" "+year;
		System.out.println(monthYeartobeSelected);
		while(true){
			if(monthYeartobeSelected.equals(monthyearDisplayed)){

				//System.out.println("month year to be selected : "+monthYeartobeSelected + " same as month displayed.");
				driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
				break;
			}else{
				if(datetobeSelected.after(currentDate)){
					driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-last a span")).click();
				}else{
					driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-first a span")).click();
				}
			}
			monthyearDisplayed=driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-first div:nth-child(2)")).getText();
		}
	}
}
