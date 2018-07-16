package com.qtpselenium.core.ddf.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.core.ddf.BasePackage.*;
import com.qtpselenium.core.ddf.util.ExtentManager;
import com.qtpselenium.core.ddf.util.XLS_reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestcaseB extends Testcase_BaseClass{
	
	SoftAssert softAssert;
	
	@BeforeMethod
	public void init() throws IOException{
		 softAssert=new SoftAssert();
		initiate();
	}
	
	@Test(dataProvider="getSuiteBData")
	public void testB(String runMode,String testCaseName,String data) throws IOException{
		
		if(runMode.equals("N")){
			//reportSkip("Testcase Skipped");
			test=rep.startTest("TestcaseB -"+testCaseName);
			test.log(LogStatus.SKIP, "Skipped TestB for Testcase : "+testCaseName);
			rep.endTest(test);
			rep.flush();
			throw new SkipException("Skipping testcase as runmode is N :"+testCaseName);
			
			
						
			
		}else if(runMode.equals("Y")){
		
		test=rep.startTest("TestcaseB");
		//test.log(LogStatus.INFO, "Running Test B for : "+testCaseName);
		test.log(LogStatus.INFO, "Starting test B for : "+testCaseName);
		openBrowser("GeckoDriver");
		test.log(LogStatus.INFO, "Opening browser");
		navigatetoURL("AppURL");
		//check if search term field is present
		if(! isElementPresent("searchTextField_xpath"))
			reportFail("Search text field not present"); //critical err
		else
			reportPass("Search text field present");
		
		typeinField("searchTextField_xpath",data);
		click("searchbutton_name");
		
		//verify text
		/*if(! verifyText("Search_res_textVer_xpath", "Text_respage"))
				reportFail("Text does not match");
		else
			reportPass("Text matched");
		*/
	
			//softAssert.assertTrue(verifyText("Search_res_textVer_xpath", "Text_respage"), "Text does not match");
		
			
		
		takeScreenshot();
		//test.log(LogStatus.PASS, "Test B passed");
		quitBrowser();
		reportPass("Testctase Passed");	
		}
	}
	
	
	
	@AfterMethod
	public void quit(){
		try{
			softAssert.assertAll();
		}catch(Error e){
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}
	
	@DataProvider
	public Object[][] getSuiteBData() throws IOException{
	//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
		initiate();
		xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
		return xls.getData() ;
		
	}
}
