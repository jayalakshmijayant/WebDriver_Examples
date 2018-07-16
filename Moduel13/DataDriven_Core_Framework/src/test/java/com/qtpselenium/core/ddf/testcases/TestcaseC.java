package com.qtpselenium.core.ddf.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.BasePackage.Testcase_BaseClass;
import com.qtpselenium.core.ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestcaseC extends Testcase_BaseClass {

	
	@Test
	public void testC() throws IOException, InterruptedException{
		test=rep.startTest("TestcaseC");
		test.log(LogStatus.INFO, "started test c");
		openBrowser("IE_DriverExe");
		navigatetoURL("AppURL1");
	//	
		//Thread.sleep(5000);
	//	takeScreenshot();
		test.log(LogStatus.FAIL, "Test failed");
		quitBrowser();
		reportFail("Testcase Failed");
		
		
		
	}
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
	}
}
