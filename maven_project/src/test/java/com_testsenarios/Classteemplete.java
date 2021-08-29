package com_testsenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilities.CommenFunctions;

import com_objectreposiltory.Locaters;

public class Classteemplete {
	Locaters bb = new Locaters();
	CommenFunctions cfn = new CommenFunctions();
@BeforeClass
   public void cc() {
	   
   }
   @Parameters("browserName")
  @BeforeMethod
  public void vv(@Optional("Edge") String browserName) {
	   if( browserName.equalsIgnoreCase("Chrome")) {
		   cfn.ChromeBrowserLunch();
	   }else if( browserName.equalsIgnoreCase("firefox")) {
		   cfn.FirefoxeBrowserLunch();
	   }else if( browserName.equalsIgnoreCase("edge")) {
		   cfn.EdgeBrowserLunch();
	   }else {
		   System.out.println("Please give valia browserName");
	   }
	
}
 @Test
 public void screenshot() throws Exception {
	 Properties p = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		p.load(fi);
	 
 }
 @AfterMethod
  public void ss() throws Exception {
	 cfn.Screenshot("nameOfTheClass");
	 
	
	}
 @AfterClass 
 public void gg() {
	 
 }
 }
