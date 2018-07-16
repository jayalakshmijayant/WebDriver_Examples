import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BigBasket_XSLData {

	static WebDriver driver ;
	static FileInputStream fs;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileOutputStream fileOut;
	@BeforeTest
	public void openUrl() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		 driver = new ChromeDriver(opt);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.bigbasket.com/");
		
		driver.findElement(By.linkText("Login")).click();
		//driver.wait(3000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("jayav.2007@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("jayasiri89");
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		if(driver.findElement(By.xpath("//div[@class='dropdown-menu loc-drop']")).isDisplayed()){
			driver.findElement(By.xpath("//a[@qa='continueBtn']")).click();
		}
	}
	@Test(dataProvider="getBigData")
	public void addProducts(String categoryName,String productName,String quantity) throws InterruptedException{
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"))).build().perform();
	if(categoryName.contains(" ")){
		String[] categoryName1=categoryName.split("\\ ");
		String cat=categoryName1[0].toLowerCase();
		categoryName=cat;
	}
	categoryName=categoryName.toLowerCase();
	Thread.sleep(2000);
	WebElement box=driver.findElement(By.xpath("//ul[@id='navBarMegaNav' and @class='nav nav-tabs nav-stacked col-md-3 bdr-viewall']"));
	List<WebElement> links=box.findElements(By.cssSelector("li[ng-repeat^='item in vm.leftmenu']"));
	//System.out.println(links.size());
	for(int j=0;j<links.size();j++){
		String str=links.get(j).getText();
		//System.out.println(str);
		//System.out.println(categoryName);
	//	#navBarMegaNav
		if((str.toLowerCase()).contains(categoryName)){
			WebElement category=links.get(j);
				//	box.findElement(By.cssSelector("li[data-submenu-id^='"+categoryName+"']"));
			a.moveToElement(category).click().build().perform();
			//Thread.sleep(1000);
			//a.click().build().perform(); 
			break;
		}
	}
		WebElement box2=driver.findElement(By.xpath("//div[@class='items']"));
		//List<WebElement> prods=box2.findElements(By.cssSelector("div[qa='product']"));
		List<WebElement> prods=box2.findElements(By.cssSelector("div.col-sm-12.col-xs-7.prod-name"));
		System.out.println(prods.size());
		for(int k=0;k<prods.size();k++){
		System.out.println(k);
			String str1=prods.get(k).getText();
		//	System.out.println(prods.get(k).getText());
			//String str1=prods.get(k).findElement(By.xpath("//div[@qa='product_name']")).getText();
			//String str1=prods.get(k).findElement(By.xpath("//h6[@ng-bind='vm.selectedProduct.p_brand']")).getText();
			//String str2=prods.get(k).findElement(By.xpath("//a[@ng-bind='vm.selectedProduct.p_desc']")).getText();
			//System.out.println(str1);
			str1=str1.replace("\n","");
			str1=str1.replace(" ","");
			String productName1=productName.replace(" ","");
			System.out.println("str1 is: "+str1);
			//String str3=str1+str2;
			//*[@id="dynamicDirective"]/product-deck/section/div[2]/div[4]/div[1]/div/div[1]/div[2]/div/div[2]/product-template/div/div[4]/div[1]
			if(str1.contains(productName1)){
			System.out.println("xl data is: "+productName1);
		//prods.get(k).findElement(By.xpath("div[@qa='product_name' and contains(@text(),'"+productName+"')]")).click();
		//	prods.get(k).findElement(By.linkText(productName)).click();
		//	prods.get(k).click();
			//a.moveToElement(prods.get(k).findElement(By.tagName("a"))).click().build().perform();
			a.moveToElement(prods.get(k).findElement(By.tagName("a")), 203, 418).click().build().perform();
			break;
			}
		}
		//driver.findElement(By.xpath("//div[class='col-sm-12 col-xs-7 prod-name' and @text()='"+productName+"']")).click();	
		WebElement qtyBox=driver.findElement(By.xpath("//div[@class='uiv2-add-product-it-basket']"));
		qtyBox.findElement(By.cssSelector("input[id$='_qty']")).clear();
		qtyBox.findElement(By.cssSelector("input[id$='_qty']")).sendKeys(quantity);
		qtyBox.findElement(By.xpath("//a[@class='uiv2-add-button a2c']")).click();
		//div.col-sm-12.col-xs-7.prod-name
		a.moveToElement(driver.findElement(By.xpath("//div[@class='my-basket-btn']"))).build().perform();
		WebElement box1=driver.findElement(By.xpath("//*[@id='navbar-main']/div/div/div[4]/div/div[2]/div/ul"));
		
		List<WebElement>	prodlist=box1.findElements(By.cssSelector("li[ng-repeat='cartItem in vm.cart.items'] div[class='prod-name']"));
		List<WebElement> quantityList=box1.findElements(By.cssSelector("li[ng-repeat='cartItem in vm.cart.items'] div[class='prod-qty ng-binding']"));
		
		for(int i=0;i<prodlist.size();i++){
			String product = prodlist.get(i).getText();
			if(product.contains(productName)){
			//	System.out.println(product);
			//	System.out.println(productName);
				String price= quantityList.get(i).getText();
				String[] newPrice=price.split("\\x");
				String price1=newPrice[0];
				price1=price1.replace(" ","");
				int price2=Integer.parseInt(price1);
				int	quantityInt=Integer.parseInt(quantity);
				if(price2==quantityInt){
					System.out.println("Item : "+ productName+" added to cart. With right Quantity : "+quantity);
					break;
				}
			}
		}
		
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getBigData() throws IOException{
		
		fs=new FileInputStream("C:\\JayaFileHandling\\BigBasket.xlsx");
		wb=new XSSFWorkbook(fs);
		sheet=wb.getSheet("Sheet1");
		int lastRow=sheet.getLastRowNum();
		int cols=sheet.getRow(lastRow).getLastCellNum();
		Object[][] obj=new Object[lastRow][cols];
		for(int row=1;row<=sheet.getLastRowNum();row++){
			XSSFRow rows=sheet.getRow(row);
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
	
}
