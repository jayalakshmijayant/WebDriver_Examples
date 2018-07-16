package com.qtpselenium.core.ddf.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestcaseA {
@Test(priority=1)
public void testA1(){
	System.out.println("Testcase A : Method A1 passed");
}
@Test(priority=2,dependsOnMethods={"testA1"})
public void testA2(){
	
}
@Test(priority=3,dependsOnMethods={"testA2","testA1"})
public void testA3(){
	
}
}
