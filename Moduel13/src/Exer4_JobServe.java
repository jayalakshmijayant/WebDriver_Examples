import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Exer4_JobServe {
	
	static WebDriver driver=null;
	static List<WebElement> checkBoxes =null;
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.jobserve.com/us/en/Job-Search/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='ddcl-selInd']/span/span")).click();
		clearIndustry();
		
		FileInputStream inputFile=new FileInputStream("C:\\JayaFileHandling\\TestData_JobServe.xls");
		HSSFWorkbook wb=new HSSFWorkbook(inputFile);
		HSSFSheet sheet1= wb.getSheet("Sheet1");
		for(int row=1;row<=sheet1.getLastRowNum();row++){
			HSSFRow rows=sheet1.getRow(row);
			System.out.println(rows.getLastCellNum());
			for(int col=0;col<rows.getLastCellNum();col++){
				HSSFCell cell=rows.getCell(col);
				if(cell.toString()==""){
					System.out.println("No testData");
				break;
				}else
				{
					selectIndustry(cell.toString());			
				}				
			}
		}		
	}
	public static void clearIndustry(){
		checkBoxes = driver.findElements(By.cssSelector("input[id^='ddcl-selInd-i']"));
		for(int i=0;i<checkBoxes.size();i++){
			String option = driver.findElement(By.xpath("//label[@for='ddcl-selInd-i"+i+"']")).getText();
			if(option.equals("Select All Industries")){
				driver.findElement(By.xpath("//label[@for='ddcl-selInd-i"+i+"']")).click();
				break;
			}
		}
	}
	public static void selectIndustry(String industryName){
	checkBoxes = driver.findElements(By.cssSelector("input[id^='ddcl-selInd-i']"));
		for(int i=0;i<checkBoxes.size();i++){
			String option = driver.findElement(By.xpath("//label[@for='ddcl-selInd-i"+i+"']")).getText();
			if(option.equals(industryName)){
				driver.findElement(By.xpath("//label[@for='ddcl-selInd-i"+i+"']")).click();
				break;
			}
		}
	}
}
