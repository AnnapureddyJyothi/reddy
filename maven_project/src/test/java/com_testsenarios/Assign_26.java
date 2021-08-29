package com_testsenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommenFunctions;
import com.utilities.StaticVariables;

import com_objectreposiltory.Locaters;

public class Assign_26  extends StaticVariables {

	Locaters bb = new Locaters();
	 CommenFunctions cfn =new   CommenFunctions();
	 
	 @BeforeClass
	 public void fff() {
		 cfn.ChromeBrowserLunch();	 
	 }
	 
	 @Test
	 public void login() throws Exception {
		 Properties p = new Properties();
			FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
			p.load(fi);
			
			driver.navigate().to("https://stqatools.com/demo/WebTable.php");
			Thread.sleep(3000);
			cfn.clickByAnyLocator(bb.DemoWeb_EDit_Button);
			Thread.sleep(3000);
			cfn.sendkeyByAnyLocator(bb.Frist_Name_TextBox, p.getProperty("Frist_Name_EditBox"));
			cfn.sendkeyByAnyLocator(bb.Second_Name_TextBox, p.getProperty("Second_Name_EditBox"));
			cfn.sendkeyByAnyLocator(bb.Demo_Mail_TextBox, p.getProperty("Mail_EditBox"));
			cfn.clickByAnyLocator(bb.Update_Bottom);
			Thread.sleep(3000);
			

} @AfterClass
	 public void ffff() {
	 driver.quit();
}}