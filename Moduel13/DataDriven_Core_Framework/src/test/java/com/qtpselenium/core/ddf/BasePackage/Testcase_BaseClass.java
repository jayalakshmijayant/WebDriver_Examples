package com.qtpselenium.core.ddf.BasePackage;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.qtpselenium.core.ddf.util.ExtentManager;
import com.qtpselenium.core.ddf.util.XLS_reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testcase_BaseClass {
	public static WebDriver driver;
	public Properties prop;
	public 	ExtentReports rep=ExtentManager.getInstance();;
	public ExtentTest test;
	public XLS_reader xls;	
	
	public void initiate() throws IOException{
		if(prop==null){
			prop=new Properties();
			FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//ProjectConfig.properties");
			prop.load(input);
		}
	}
	public void openBrowser(String browser) throws IOException{
		//System.out.println(prop.getProperty("AppURL"));
		//System.out.println(System.getProperty("user.dir"));
		if(browser.equals("GeckoDriver")){
			System.setProperty("webdriver.gecko.driver",prop.getProperty("GeckoDriver"));
			driver=new FirefoxDriver();
		}else if(browser.equals("IE_DriverExe")){
			System.setProperty("webdriver.ie.driver", prop.getProperty("IE_DriverExe"));
			driver=new InternetExplorerDriver();
		}else if(browser.equals("ChromeDriver")){
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriver"));
			driver=new ChromeDriver();
		}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		//initiate the prop file
	
	}
	public void navigatetoURL(String url){
		driver.navigate().to(prop.getProperty(url));
	}
	public void click(String locator){
		getElement(locator).click();
	}
	public void typeinField(String xpathofField ,String data){
		getElement(xpathofField).sendKeys(data);
	}
	public WebElement getElement(String locator){
		WebElement elem=null;
		try{
		if(locator.endsWith("_xpath")){
			elem=driver.findElement(By.xpath(prop.getProperty(locator)));
		}else if(locator.endsWith("_id")){
			elem=driver.findElement(By.id(prop.getProperty(locator)));
		}else if(locator.endsWith("_name")){
			elem=driver.findElement(By.name(prop.getProperty(locator)));
		}else if(locator.endsWith("_css")){
			elem=driver.findElement(By.cssSelector(prop.getProperty(locator)));
		}else{
			reportFail("Element locator incorrect."+ locator);
			Assert.fail();
		}
	
		}catch(Exception e){
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("Failed the test : "+ e.getMessage());
		}
		return elem;
	}
	public void quitBrowser(){
		driver.quit();
	}
	
	/******Validations***************/
	public boolean isElementPresent(String locator){
		List<WebElement> elemList=null;
		if(locator.endsWith("_xpath")){
			elemList=driver.findElements(By.xpath(prop.getProperty(locator)));
		}else if(locator.endsWith("_id")){
			elemList=driver.findElements(By.id(prop.getProperty(locator)));
		}else if(locator.endsWith("_name")){
			elemList=driver.findElements(By.name(prop.getProperty(locator)));
		}else if(locator.endsWith("_css")){
			elemList=driver.findElements(By.cssSelector(prop.getProperty(locator)));
		}else{
			reportFail("Element locator incorrect."+ locator);
			Assert.fail("Locator incorrect : "+ locator);
		}
		
		if(elemList.size()==0)
			return false;
		else
			return true;
	}
	public boolean verifyText(String locator,String texttobeVerified){
	 String actualText= getElement(locator).getText().trim();
	 String tobeVerified=prop.getProperty(texttobeVerified);
	 if(actualText.equalsIgnoreCase(tobeVerified))
		return true;
	else
		return false;
	}
	public boolean verifyTitle(){
		return false;
		
	}
	/******Reporting***************/
	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}
	public void reportFail(String msg){
		takeScreenshot();	
		test.log(LogStatus.FAIL,msg);	
			
		Assert.fail(msg);
		}
	public void reportSkip(String msg){
		test.log(LogStatus.SKIP, msg);
	}
	public void takeScreenshot(){
		Date d=new Date();
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
		FileUtils.copyFile(screen, new File(System.getProperty("user.dir")+"//Screenshots//"+fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		//put screenshots in report
		test.log(LogStatus.INFO, "Screenshot : "+test.addScreenCapture(System.getProperty("user.dir")+"//Screenshots//"+fileName));
	}
}
