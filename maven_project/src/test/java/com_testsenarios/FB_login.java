package com_testsenarios;
import org.testng.annotations.Test;

import com.utilities.StaticVariables;

import com_objectreposiltory.Locaters;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FB_login extends StaticVariables{

	Locaters bb = new Locaters();
@BeforeClass
public void ff() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
@Test	
	public void login() throws Exception {
	Properties p = new Properties();
	FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
	p.load(fi);	
	
	driver.get(p.getProperty("FB_URL"));
	driver.findElement(bb.FB_LOGIN_USERNANE_EDITBOX).sendKeys(p.getProperty("FB_USERNAME"));
	driver.findElement(bb.FB_LOGIN_PASSWORD_EDITBOX).sendKeys(p.getProperty("FB_PASSSWORD"));
	driver.findElement(bb.FB_LOGIN__BUTTON).click();
	Thread.sleep(3000);
		
	
}
@AfterClass
public void cc() {
	driver.quit();
}
}
