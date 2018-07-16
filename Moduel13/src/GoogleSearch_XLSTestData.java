import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;


public class GoogleSearch_XLSTestData {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream input= new FileInputStream("C:\\JayaFileHandling\\TestSearch.xls");
			HSSFWorkbook wb=new HSSFWorkbook(input);
			HSSFSheet sheet=wb.getSheet("Sheet1");
			for(int count=1;count<=sheet.getLastRowNum();count++){
				HSSFRow row=sheet.getRow(count);
				gSearch(row.getCell(0).toString(),row.getCell(1).toString());
			}
			input.close();
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void gSearch(String searchText,String pageTitle){
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://google.com");
		driver.findElement(By.name("q")).sendKeys(searchText);
		driver.findElement(By.name("q")).submit();
	if(driver.getTitle().equals(pageTitle)){
		System.out.println("Page title: "+ pageTitle +" as Expected");
	}else{
		System.out.println("Page title : "+ driver.getTitle()+" not as expcted: ");
	}
	driver.close();
	}

}
