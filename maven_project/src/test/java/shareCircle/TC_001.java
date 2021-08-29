package shareCircle;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommenFunctions;
import com.utilities.StaticVariables;

import com_objectreposiltory.Locaters;

public class TC_001 extends StaticVariables {
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
			
			driver.get("https://shearcircle.com/");
			Thread.sleep(3000);
			cfn.clickByAnyLocator(bb.Register_AS_Partner_button);
			Thread.sleep(3000);
			cfn.sendkeyByAnyLocator(bb.Bessinus_Name_Textbox, p.getProperty("Business_Name"));
			Thread.sleep(3000);
			cfn.sendkeyByAnyLocator(bb.City_Textbox, p.getProperty("City"));
			cfn.sendkeyByAnyLocator(bb.ShareCircle_Mail_Textbox, p.getProperty("Mail"));
			cfn.sendkeyByAnyLocator(bb.Phone_Number_Textbox, p.getProperty("PhoneNumeber"));
			cfn.sendkeyByAnyLocator(bb.Enter_Massege_Textbox, p.getProperty("Enter_Data"));
			cfn.clickByAnyLocator(bb.Sent_Massege_Button);
			Thread.sleep(5000);
			
}

@AfterClass
public void cc() {
	driver.quit();
}}
