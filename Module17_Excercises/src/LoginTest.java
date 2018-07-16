import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest {
	static WebDriver driver ;
		@BeforeTest
		public void beforeLogin(){
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--disable-notifications");
			
			 driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}

		@Test(dataProvider="getLoginData")
		public void doLogin(String username,String password,String expectedMsg){
			driver.navigate().to("https://www.facebook.com");
			String actual=null;
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			
			driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
	//	System.out.println(driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).isDisplayed());
		if(!(driver.findElements(By.xpath("//div[@class='_4rbf _53ij']")).isEmpty())){
			actual=driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
			Assert.assertEquals(actual, expectedMsg);
		}else{
			String title=driver.getTitle();
			Assert.assertEquals(title,expectedMsg);
		}
		}
		@AfterTest
		public void close(){
			driver.quit();
		}
		
		@DataProvider
		public Object[][] getLoginData() throws IOException{
			Object[][] obj=null;
			//String cellData[][]=null;
			FileInputStream fs=new FileInputStream("C:\\JayaFileHandling\\Login_Test.xls");
			HSSFWorkbook wb=new HSSFWorkbook(fs);
			HSSFSheet sheet=wb.getSheet("Login");
			int lastRow=sheet.getLastRowNum();
			int rows=lastRow+1;
			System.out.println(lastRow);
			
			int cols=sheet.getRow(lastRow).getLastCellNum();
			System.out.println(cols);
			obj= new Object[lastRow][cols];
			for(int i=1;i<=lastRow;i++){
				HSSFRow row=sheet.getRow(i);
				//System.out.println(row.getCell(1));
				int lastCol=row.getLastCellNum();
				//System.out.println(lastCol);
				 //obj= new Object[rows][lastCol-1];
				for(int j=0;j<lastCol;j++){
					//HSSFCell cell=row.getCell(j);
					System.out.println(row.getCell(j).toString());
					obj[i-1][j]=(row.getCell(j).toString());
					
					
				}
			}
			wb.close();
			fs.close();
			return obj;
			
		}

	

}
