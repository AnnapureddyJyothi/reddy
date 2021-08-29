package com_testsenarios;

import java.io.FileInputStream;
import java.util.Properties;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommenFunctions;
import com.utilities.StaticVariables;

import com_objectreposiltory.Locaters;

public class FB_Login2 extends StaticVariables{

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
			driver.get(p.getProperty("FB_URL"));
		cfn.sendkeyByAnyLocator(bb.FB_LOGIN_USERNANE_EDITBOX, p.getProperty("FB_USERNAME"));
		cfn.sendkeyByAnyLocator(bb.FB_LOGIN_PASSWORD_EDITBOX, p.getProperty("FB_PASSSWORD"));
		cfn.clickByAnyLocator(bb.FB_LOGIN__BUTTON);
		Thread.sleep(3000);
			
		 
	 }
	 
	 @AfterClass
	 public void ffff() {
		 driver.quit();
		 
	 }
	 }