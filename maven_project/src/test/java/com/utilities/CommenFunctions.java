package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommenFunctions  extends StaticVariables{
      
	 /******************** Browser driver methods *********************/
	
	public void ChromeBrowserLunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
    public void FirefoxeBrowserLunch() {
    	WebDriverManager.edgedriver().setup();
    	driver = new EdgeDriver();
	}
    public void EdgeBrowserLunch() {
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
    	
	}
    
     /******************** Sendkeys using any locator **********************/
    
 // check the editbox displayed or not
    	//check the  editbox enabled/disabled or not
    	//clear if any existing data presents on editbox
    public void sendkeyByAnyLocator(By locator,String inputdata) {
    	WebElement ele =driver.findElement(locator);
    	if (ele.isEnabled() && ele.isDisplayed()) {
    		ele.clear();
    		ele.sendKeys(inputdata);
    	}else {
    		System.out.println("wbelement is not displyed on DOM or disable status");
    			
    		}
			
		}
    public void sendkeyerByAnyLocator(By locator,String inputdata) {
    	WebElement ele =driver.findElement(locator);
    	if (ele.isEnabled()) {
    		if (ele.isDisplayed()) {
    		ele.clear();
    		ele.sendKeys(inputdata);
    		}
    	}else {
    		System.out.println("wbelement is not displyed on DOM or disable status");
    			
    		}
			
		}
    
    
      /******************** Click using any locator **********************/
    
    public void clickByAnyLocator(By locator) {
    	WebElement ele =driver.findElement(locator);
    	if (ele.isEnabled() && ele.isDisplayed()) {
    		ele.click();
    	}else {
    		System.out.println("wbelement is not displyed on DOM or disable status");
    			
    		}
    }
    
     /******************* Timestamp **********************/
    
 public String timestamp() {
	 Date d = new Date();
	 System.out.println("d");
	 
	 DateFormat df = new SimpleDateFormat("yyyymmmddhhss");
	 String timeStamp = df.format(d);
	 return timeStamp;
     
 }

      /********************** Screenshot * @throws Exception *********************/

   public void Screenshot(String fileName) throws Exception {
	   File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(f1, new File("./Screen shot/"+fileName+ timestamp()+".JPEG"));
	   
   }
	 
  /************************** Convert string to integer********************/
   
 public void convertStringToInteger() {
	 int a = 97;
	 String b ="03";
	 int f = Integer.parseInt(b);
	 System.out.println(a+f);
	 
	 //or
	 int d = 97;
	 String e ="03";
	 System.out.println(d+e);
	 System.out.println(d+Integer.parseInt(e));
 }
 
    /**************************** IFRAM **************************/
 
 public int iframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);
		return numberOfFrames;
	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesForElement(By locator) {

		int elementpresenceCount = 0;
		int loop = 0;
		int maxFramaecount = iframeCount();// 6
		// if given locater has present on webpage, then the element size would be '1'
		// else '0'
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && loop < maxFramaecount) {
			try {
				switchToFrameByInt(loop);
				elementpresenceCount = driver.findElements(locator).size();// 1
				System.out.println("Try Loop frames and the Results of webelement : " + loop + ": "+ elementpresenceCount);
				if (elementpresenceCount > 0 || loop > maxFramaecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL Old: " + loop + "; " + ex);
			}
			loop++;//1
		}
		return elementpresenceCount;
	}	

	/***** Alert Handle **********/
	
	public void alertHandleByAccept() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		alert.accept();	
	}

	public void alertHandleByDismiss() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		alert.dismiss();
	}

	/********* Actions ****/

	public void moveToOnElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println("Error in description: " + e.getStackTrace());
		}
	}

	public void mouseHoverClickandHold(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.clickAndHold(element).build().perform();
		} catch (Exception e) {
			System.out.println("Error in description: " + e.getStackTrace());
		}

	
		
	}
	
	/********************* Mousehour *******************/

	public void mouseHoverContextClick(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.contextClick(element).build().perform();

		} catch (Exception e) {
			System.out.println("Error in description: " + e.getStackTrace());
		}
    	}
	
     /********************** Double click ***********************/
		
    	public void doubleClick(By locator) {
    		try {
    			WebElement element = driver.findElement(locator);
    			Actions actions = new Actions(driver);
    			actions.doubleClick(element).build().perform();

    		} catch (Exception e) {
    			System.out.println("Error in description: " + e.getStackTrace());
    		}
    	}
    	
    /***************************** Dropdown **************************/
    	
    	public void dragandDrop(By sourceelementLocator, By destinationelementLocator) {
    		try {
    			WebElement sourceElement = driver.findElement(sourceelementLocator);
    			WebElement destinationElement = driver.findElement(destinationelementLocator);

    			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
    				Actions action = new Actions(driver);
    				action.dragAndDrop(sourceElement, destinationElement).build().perform();
    			} else {
    				System.out.println("Element(s) was not displayed to drag / drop");
    			}
    		} catch (StaleElementReferenceException e) {
    			System.out.println("Element with " + sourceelementLocator + "or" + destinationelementLocator
    					+ "is not attached to the page document " + e.getStackTrace());
    		} catch (NoSuchElementException e) {
    			System.out.println("Element " + sourceelementLocator + "or" + destinationelementLocator
    					+ " was not found in DOM " + e.getStackTrace());
    		} catch (Exception e) {
    			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
    		}
    	}
    	
    	/************* popupHandle ***********/
    	
    	public void popupHandleToCloseTheChildWindow() throws InterruptedException {
    		// get the main windown name
    		String mainWindowName = driver.getWindowHandle();
    		System.out.println("mainWindowName:" + mainWindowName);

    		Set<String> allWindowNames = driver.getWindowHandles();
    		System.out.println("allWindowNames:" + allWindowNames);

    		// Close the child window (popups)
    		for (String abc : allWindowNames) {//2
    			// validate the window name is parent window /Child window?
    			if (!mainWindowName.equals(abc)) {
    				// switch to child window
    				driver.switchTo().window(abc);
    				Thread.sleep(3000);
    				// Close my child window
    				driver.close();
    			}
    		}
    		// move cursor point to back to mainwindow
    		driver.switchTo().window(mainWindowName);
    	}

    	public void navigateToPopupWindow() throws InterruptedException {
    		// get the main windown name
    		String mainWindowName = driver.getWindowHandle();
    		System.out.println("mainWindowName:" + mainWindowName);

    		Set<String> allWindowNames = driver.getWindowHandles();// 4
    		System.out.println("allWindowNames:" + allWindowNames);
    		
    		for (String string : allWindowNames) {
    			// validate the window name is parent window /Child window?
    			if (!mainWindowName.equals(string)) {
    				// switch to child window
    				driver.switchTo().window(string);
    				Thread.sleep(3000);
    			}
    		}

    	}
    	
    	/**** SwithchToWindow using Tab **********/
    	
    	public void switchToNewTab(int tabIndex) {
    		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
    		driver.switchTo().window(allTabs.get(tabIndex));

    		// Switch back to original window
    		// driver.switchTo().window(windowHandle);
    	}

    /****** SwithchToWindow using Tab then close the ChildTab againg comeback to ParentWindow(Main TAB)*********/
    	
    	public void switchAndCloseNewTab(int tabIndex) {
    		// Get the current window handle
    		String mainTab = driver.getWindowHandle();
    		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
    		driver.switchTo().window(allTabs.get(tabIndex));
    		// Close the newly Opened Window
    		driver.close();
    		// Switch back to original window
    		driver.switchTo().window(mainTab);
    	}	
    	
    	/****** Dropdown selection **************/

    	public void selectByVisibleText(By locater, String visibleText) {

    		WebElement element = driver.findElement(locater);
    		if (element.isDisplayed()) {
    			if (element.isEnabled()) {
    				Select dropdown = new Select(element);
    				dropdown.selectByVisibleText(visibleText);
    			} else {
    				System.out.println("The webelement is NOT Enabled, please check******");
    			}
    		} else {
    			System.out.println("The webelement is NOT displayed, please check******");
    		}

	} 	
	

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check******");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check******");
		}

	}
	
	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check******");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check******");
		}

	}

	
		public void printAllDropdownValues(By locater) {
    		WebElement element = driver.findElement(locater);
    		if (element.isDisplayed() && element.isEnabled()) {
    			Select dropdown = new Select(element);
    			List<WebElement> dropdownValues = dropdown.getOptions();
    			// Print the size of dropdown values
    			System.out.println(dropdownValues.size());
    			// Print the dropdown values
    			for (WebElement allvalue : dropdownValues) {
    				System.out.println(allvalue.getText());
    			}
    		}

    	}
		public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
    		WebElement element = driver.findElement(locater);
    		if (element.isDisplayed() && element.isEnabled()) {
    			Select dropdown = new Select(element);
    			List<WebElement> dropdownValues = dropdown.getOptions();
    			// Print the size of dropdown values
    			System.out.println(dropdownValues.size());
    			// Print the dropdown values
    			for (int i = 0; i < dropdownValues.size(); i++) {
    				System.out.println(dropdownValues.get(i).getText());

    				// Select India option from the dropdown
    				if (dropdownValues.get(i).getText().equals(visibleText)) {
    					dropdown.selectByIndex(i);
    					break;
    				}
    			}
    		}

		}
		
		/**** Random number *****/
    	public int randomNumber(int maxRange) {
    		Random r = new Random();
    		int rNum = r.nextInt(maxRange);
    		return rNum;

    	}
    	

	
	}
	
	
	
	
	
	
	