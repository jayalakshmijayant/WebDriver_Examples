package Grid1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Calculator_Google {
	static WebDriver driver ;
	static FileInputStream fs;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileOutputStream fileOut;
	@BeforeTest
	public void before() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		//DesiredCapabilities cap= DesiredCapabilities.chrome();
		//cap.setPlatform(Platform.ANY);
		//cap.setBrowserName("Chrome");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		 driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.bing.com/search?q=calculator&qs=n&form=QBLH&sp=-1&pq=calculator&sc=9-10&sk=&cvid=540472E91C4A4BB699F3A9A368949A95");
		
		//RemoteWebDriver driver= new RemoteWebDriver(new URL("http://192.168.1.10:4444/grid/wd/hub"),cap);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.navigate().to("https://www.bing.com/search?q=calculator&qs=n&form=QBLH&sp=-1&pq=calculator&sc=9-10&sk=&cvid=540472E91C4A4BB699F3A9A368949A95");
		
	
	}
	
	@Test(dataProvider="getData")
	public void doCalculation(String num1,String num2, String operation, String expResult) throws IOException, InterruptedException{
		String result=null;
		String ops=null;
		if(operation.equals("+")){
			ops="rcAdd";
		}else if(operation.equals("-")){
			ops="rcSub";
		}else if(operation.equals("*")){
			ops="rcMul";
		}else if(operation.equals("/")){
			ops="rcDiv";
		}
		
		driver.findElement(By.xpath("//*[@id='rcClD']")).click();
		
		driver.findElement(By.cssSelector("input[class='rcOpdB b_xlText'][value='"+num1+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='"+ops+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[class='rcOpdB b_xlText'][value='"+num2+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='rcEquals']")).click();
		Thread.sleep(1000);
		String actual=driver.findElement(By.xpath("//span[@id='rcTB']")).getText();
		//System.out.println(actual);
		//Set<String> s= new HashSet<String>();
	//	s.add(actual);
		//Iterator<String> it=s.iterator();
		//System.out.println(s.size());
		//System.out.println(it.next());
		try{
		Assert.assertEquals(actual, expResult);
		result="pass";
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
			
		}
	//	while(it.hasNext()){
			writeData(actual,operation,result);
		//}
		//writeResult(result);
	}
	@AfterTest
	public void after(){
		driver.close();
	}
	@DataProvider
	public Object[][] getData() throws IOException{
		fs=new FileInputStream("C:\\JayaFileHandling1\\Calculator1.xlsx");
		wb=new XSSFWorkbook(fs);
		sheet=wb.getSheet("Addition");
		int lastRow=sheet.getLastRowNum();
		//int rows=lastRow+1;
		//System.out.println(lastRow);
		int cols=sheet.getRow(lastRow).getLastCellNum();
		Object[][] obj=new Object[lastRow][cols];
		for(int row=1;row<=sheet.getLastRowNum();row++){
			XSSFRow rows=sheet.getRow(row);
			//System.out.println(rows.getLastCellNum());
			for(int col=0;col<rows.getLastCellNum();col++){
				XSSFCell cell=rows.getCell(col);
				if(cell.toString()==""){
				break;
				}else
				{
					obj[row-1][col]=rows.getCell(col).toString();			
				}				
			}
		}		wb.close();
		fs.close();
		return obj;
}
	public void writeData(String actualResult,String operation,String result) throws IOException{
		fs=new FileInputStream("C:\\JayaFileHandling1\\Calculator1.xlsx");
		wb=new XSSFWorkbook(fs);
		fileOut = new FileOutputStream("C:\\JayaFileHandling1\\Calculator1.xlsx");
	//	fs=new FileInputStream("C:\\JayaFileHandling\\Calculator1.xls");
		
		sheet=wb.getSheet("Addition");
		//System.out.println(sheet.getLastRowNum());
		for(int i=1;i<=sheet.getLastRowNum();i++){
			if(sheet.getRow(i).getCell(2).toString().equalsIgnoreCase(operation)){
					sheet.getRow(i).createCell(4).setCellValue(actualResult);
					sheet.getRow(i).createCell(5).setCellValue(result);
					break;
			}
		}
		wb.write(fileOut);
		wb.close();
		fs.close();
		fileOut.close();
	}
}