package com_testsenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommenFunctions;
import com.utilities.StaticVariables;

import com_objectreposiltory.Locaters;

public class Apple_assign25 extends StaticVariables {
	

	Locaters bb = new Locaters();
	 CommenFunctions cfn =new   CommenFunctions();
	 
	 @BeforeClass
	 public void fff() {
		 cfn.ChromeBrowserLunch();	 
	 }

@Test
public void endToEndProsess() throws Exception {
	 Properties p = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		p.load(fi);
		
		driver.get("https://www.applevacations.com/brands/#!/");
		Thread.sleep(8000);
		cfn.clickByAnyLocator(bb.LEAVING_FROM);
		cfn.sendkeyByAnyLocator(bb.LEAVING_FROM, p.getProperty("APPLE_FROM_ADRESS"));
}
@AfterClass
public void ffff() {
	 driver.quit();
	 
}
}
