package Execution_Suite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestData.Testdata;
import TestData.Testelements;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Predicate;


public class Velocity_Distributor_WithoutLicence {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	
	Robot rb;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		
           if(browser.equalsIgnoreCase("firefox")) {
			
        	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/VelocityDistributorWithoutLicenceReport"+".html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("HostName", "Bilal Mubarik");
			extent.setSystemInfo("Environment", Testdata.VelocityURL);
			htmlReporter.config().setDocumentTitle("Automation Testing Report");
			htmlReporter.config().setReportName("Velocity");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.getStartTime();
			htmlReporter.getEndTime();	
						
	  }
		

		
		 
				
			else if (browser.equalsIgnoreCase("chrome")){
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/VelocityDistributorWithoutLicenceReport"+".html");
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				extent.setSystemInfo("HostName", "Bilal Mubarik");
				extent.setSystemInfo("Environment", Testdata.VelocityURL);
				htmlReporter.config().setDocumentTitle("Automation Testing Report");
				htmlReporter.config().setReportName("Velocity");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTheme(Theme.DARK);
				htmlReporter.getStartTime();
				htmlReporter.getEndTime();
				}
		
			
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/VelocityDistributorWithoutLicenceReport"+".html");
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				extent.setSystemInfo("HostName", "Bilal Mubarik");
				extent.setSystemInfo("Environment", Testdata.VelocityURL);
				htmlReporter.config().setDocumentTitle("Automation Testing Report");
				htmlReporter.config().setReportName("Velocity");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTheme(Theme.DARK);
				htmlReporter.getStartTime();
				htmlReporter.getEndTime();
					
			}
			 
        driver.get(Testdata.VelocityURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	
  @Test(priority=0)
  public void login() throws InterruptedException {
    try{
    	
    	driver.manage().window().maximize();
    	 
	//Wait for the login buttons to be appear 
	
	wait = new WebDriverWait(driver, 120);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ASI_Num)));
    
    if(driver.getCurrentUrl().contains("stage")){
    
    //Insert ASI Number
    driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDASINumberStage);
    
    //Insert the username
    driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDUsernameStage);
    
    //Insert the Password
    driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDPasswordStage);
    }
    else if(driver.getCurrentUrl().contains("uat")){
    	
    	 //Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDASINumberUAT);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDUsernameUAT);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDPasswordUAT);
    }
    
    else{
    	 //Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDASINumberProd);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDUsernameProd);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDPasswordProd);
    	
    }
    
    //Press the login Button
    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
    
    wait = new WebDriverWait(driver, 120);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DistributorLoginSuccess_Validation)));
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.xpath(Testelements.DistributorLoginSuccess_Validation)).isDisplayed()){
    System.out.println("Loggedin with Distributor Successfully");
   
    test = extent.createTest("LoginDistributor");
	
	test.log(Status.PASS, "Distributor Loggedin Successfully");
    }
    else{
    	 System.out.println("Loggedin with Distributor UnSuccessfully");
    	   
    	    test = extent.createTest("LoginDistributor");
    		
    		test.log(Status.FAIL, "Distributor Loggedin UnSuccessfully");
    
    }
    
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
    }
    
  }
   @Test(priority=1)
  public void HelpLicenceAgreement() throws InterruptedException{
	     try{
	  
	    	 wait = new WebDriverWait(driver, 120);
	    	 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.top-route-tab:nth-child(2) > a:nth-child(1)")));	 
	    	 
	    	 Thread.sleep(2000);
	    	 
	    	 //Press the help tab at top right corner
	  
	  driver.findElement(By.cssSelector(Testelements.Help)).click();
	  
	 driver.findElement(By.cssSelector(Testelements.LicenceAgreement)).click();
    
     Thread.sleep(2000);
	
 
     if(driver.findElement(By.xpath(Testelements.LicenceAgreementText)).isDisplayed()){
    	 
    	 System.out.println(" Help Licence Agreement Note displayed Sucessfully");
    	 test = extent.createTest("HelpLicenceAgreement");
    		
    	test.log(Status.PASS, "Help Licence Agreement Note displayed Sucessfully");
     }
     else{
    	 
    	 System.out.println("Licence Agreement Note displayed Unsuccessfull");
    	 test = extent.createTest("HelpLicenceAgreement");
    		
    	test.log(Status.PASS, "Help Licence Agreement Note displayed Unsuccessful");
     }
    
    
    driver.findElement(By.cssSelector(Testelements.Licenceclosed)).click();
  }    
  //Catch the exception if any
  catch(NoSuchElementException e){
  	e.getStackTrace();
  	
    
  }
  }
 
  @Test(priority=2)
  public void EspWebsiteLogoCheck() throws InterruptedException{
	  
	  try{
	  
		  if(driver.findElement(By.cssSelector("#shellTop-view > div.container-fluid > div.espHeader.row-fluid > div.span7.hidden-print > a")).isDisplayed()){
			  
			  System.out.print("Websites Changed Logo displayed sucessfully");
		      
			  test = extent.createTest("WebsiteLogo");
				Assert.assertFalse(false);
				test.log(Status.PASS, "WebsiteLogo Displayed and verified");
			  
		  
		  
		  }
		  else{
			  
			  System.out.print("Websites Changed Logo displayed unsucessfully");
			  test = extent.createTest("WebsiteLogo");
				Assert.assertFalse(false);
				test.log(Status.FAIL, "WebsiteLogo Displayed and verified unsucessfull");
		  
		  }
	  
	  
	  
	  
		
	  
	  }    
	  //Catch the exception if any
	  catch(NoSuchElementException e){
	  	e.getStackTrace();
	  	
		     
		     }
	    
	  
	  
	  
	  }
  
  
  
  @Test(priority=3)
  public void NoSupplierInfo() throws InterruptedException{
	     
	 
		
	
      if(driver.findElement(By.xpath(Testelements.SupplierInfo_Invisible)).isDisplayed()){
    	 System.out.println(" Supplier Info tab displayed");
    	 test = extent.createTest("NoSupplierInfoPage");
 		Assert.assertFalse(false);
 		test.log(Status.FAIL, " Supplier Info tab displayed");
      }
      else{
	    System.out.println("No Supplier Info page Displayed");
    	
    	test = extent.createTest("NoSupplierInfoPage");
		Assert.assertFalse(false);
		test.log(Status.PASS, "No Supplier Info Page displayed");
      }
		
	    
	     }
  
  @Test(priority=4)
  public void NoCatalogandComplainceTab() throws InterruptedException{
	     
	  
		
	
  
	  if(driver.findElement(By.cssSelector(Testelements.CatalogAndComplaince_Invisible)).isDisplayed()){
	    	 System.out.println(" CatalogAndCompliance tab displayed");
	    	 test = extent.createTest("NoCatalogAndCompliance Tab");
	 		Assert.assertFalse(false);
	 		test.log(Status.FAIL, " CatalogAndCompliance tab displayed");
	      }
	      else{
		    System.out.println("No CatalogAndCompliance tab Displayed");
	    	
	    	test = extent.createTest("NoCatalogAndCompliance tab");
			Assert.assertFalse(false);
			test.log(Status.PASS, "No CatalogAndCompliance tab displayed");
	      }
			
	  
	
	    
	     }
  
  @Test(priority=5)
  public void NoImportExportTab() throws InterruptedException{
	     
	  try{
		
	
	  
		List<WebElement> ImportExportInvisible= driver.findElements(By.xpath(Testelements.NoImportExport_Invisible));
		
		if(ImportExportInvisible.get(9).isDisplayed()){
	    	 System.out.println(" Import and Export buttons displayed");
	    	 test = extent.createTest("NoImportExport Button");
	 		
	 		test.log(Status.FAIL, "Import and Export buttons displayed");
	      }
	      else{
		    System.out.println("No Import and Export buttons displayed");
	    	
	    	test = extent.createTest("NoImportExport Buttons");
			
			test.log(Status.PASS, "No Import and Export buttons displayed");
	      }
			
	  
	    
	     }
  catch(NoSuchElementException e){
	   	
	}
  }
  
  @Test(priority=6)
  public void NoBulkEdit() throws InterruptedException{
	     
	  
		
	
  
	  if(driver.findElement(By.xpath(Testelements.BulkEdit_Button)).isDisplayed()){
	    	 System.out.println(" Bulk Edit Button displayed");
	    	 test = extent.createTest("BulkEdit Option");
	 		Assert.assertFalse(false);
	 		test.log(Status.FAIL, " BulkEdit Button displayed");
	      }
	      else{
		    System.out.println("No BulkEdit Button Displayed");
	    	
	    	test = extent.createTest("NoBulkEdit Button");
			Assert.assertFalse(false);
			test.log(Status.PASS, "No BulkEdit Button displayed");
	      }
			
	
		}  
	    
	     
  
  
  @Test(priority=7)
  
  public void AddSharedProduct() throws InterruptedException{
  	
  	try{
  		
  		wait = new WebDriverWait(driver, 120);
  	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddProduct_Dist)));
  		
      
      //First store parent window to switch back
      String parentWindow = driver.getWindowHandle();

        
        driver.findElement(By.xpath(Testelements.AddProduct_Dist)).click();
    
      //Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    	    if(!winHandle.equals(parentWindow)) {
    	        driver.switchTo().window(winHandle);
    	    }
    	}
    	  
    	
		
    

        //Insert the product name
    	driver.findElement(By.cssSelector(Testelements.Product_Name)).sendKeys(Testdata.Productname);
    	
    	//Insert Product description
    	driver.findElement(By.cssSelector(Testelements.Product_description)).sendKeys("Description: Our most popular bottle, available in a variety of colors to help brighten up anybodys gear. The large opening on our wide-mouth bottles easily accommodates ice cubes, fits most water purifiers and filters, and makes hand washing a breeze. The attached loop-top never gets lost and screws on and off easily. Printed graduations let keep track of your hydration. Dishwasher safe Please make sure the top does not touch the heating element, or it will melt.");
    
        driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
        
        Thread.sleep(1000);
    	
    	//Select the product type
    	//driver.findElement(By.cssSelector(Testelements.Product_type)).click();
    	
    	 //Creating a robot instance to select option in 2nd place in dropdown
    	WebElement mySelectElement = driver.findElement(By.xpath(Testelements.ProductType));
        Select dropdown= new Select(mySelectElement);
       
        dropdown.selectByVisibleText("Automotive Accessories");
    
        
        
        
        driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
         
        Thread.sleep(1000);
        
        
        
        
        //Press the apply button to add the product
        driver.findElement(By.cssSelector(Testelements.AddProduct_Applybutton)).click();
    
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Basicdetails)));
        
        //Wait all tabs to be enabled
        driver.findElement(By.cssSelector(Testelements.Product_Basicdetails)).isEnabled();
        
        
        
        //Switch back to parent window 
        driver.switchTo().window(parentWindow);
        
       
			waitForPageLoad();
		
         //Insert the product number
        driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber);
        
      //Insert UPC code
        driver.findElement(By.cssSelector(Testelements.UPCCode)).sendKeys(Testdata.UPCCode);
        
      //Insert the product summary
        driver.findElement(By.cssSelector(Testelements.Product_Summary)).sendKeys("This is a velocity Test Product");
        
      
        //First store parent window to switch back
        String parentWindow1 = driver.getWindowHandle(); 
        
        //Open the category popup
        driver.findElement(By.cssSelector(Testelements.Productcategory_dropdown)).click();
        
      //Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    	    if(!winHandle.equals(parentWindow1)) {
    	        driver.switchTo().window(winHandle);
    	    }
    	}
        
        
		Thread.sleep(2000);
	 
      
     //Search the category
        driver.findElement(By.cssSelector(Testelements.Category_Searchfield)).sendKeys("Frames");
        
       Thread.sleep(2000);
	
        
        //Select 2  categories of frames 
        driver.findElement(By.cssSelector(Testelements.Product_category1)).click();
        
    //Select the 2nd 1 
        driver.findElement(By.cssSelector(Testelements.Product_category2)).click();
        
    //Press the apply on category product popup
        driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton)).click();
        
      //Switch back to parent window 
        driver.switchTo().window(parentWindow1);
       
        
        //Wait for 2 sec
       Thread.sleep(2000);
		
        //Select the pricing tab for SPG
      
        driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
        
        waitForPageLoad();
      
       // Wait for attributes to appear
        
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
        
        Thread.sleep(2000);
		
        
        driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
        
        //Select the 2nd attribute
        driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
        
        //Save the attributes details
       // driver.findElement(By.cssSelector(Testelements.Product_Save_Button)).click();
        
        //Wait for few sec
       Thread.sleep(2000);
		
        
      //Goto imprinting tab and select imprinting
        driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
        
        waitForPageLoad();
        
       //Select an option
        
        WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.ImprintingMethodSelection));
        Select dropdown70= new Select(mySelectElement70);
       
        dropdown70.selectByVisibleText("Silkscreen");
        
        
        
        WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
       
        
        
        //Open the pricing tab
        driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
        
        //Wait for all the fields to be appeared
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
        
        
		Thread.sleep(2000);
		
        
        //Insert the details
        driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys("1");
        
        driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1)).sendKeys("20");
        
        //driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1)).click();
        
        WebElement mySelectElement170 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
        Select dropdown170= new Select(mySelectElement170);
       
        dropdown170.selectByVisibleText("L 70%");
        
        
		driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("2");
		
		driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
		
		  
		
		WebElement mySelectElement71 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
        Select dropdown71= new Select(mySelectElement71);
       
        dropdown71.selectByVisibleText("L 70%");
		
      
      //Move to Images tab
		driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
		
     //Wait for the button to appear
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
	        
	     
	     
	     //First store parent window to switch back
	     String parentWindow2 = driver.getWindowHandle(); 
	     
	     //Press the medialibrary button select image
	     driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	     
	   //Switch to new window opened
	    	for(String winHandle : driver.getWindowHandles()){
	    	    if(!winHandle.equals(parentWindow2)) {
	    	        driver.switchTo().window(winHandle);
	    	    }
	    	}
	        
	        waitForPageLoad();
	    	
			Thread.sleep(1000);
		 
	     
      //Select the images to upload
	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
	     
		Thread.sleep(3000);
	
	     
	   
	//Scroll down
    JavascriptExecutor jse110 = (JavascriptExecutor)driver;
    jse110.executeScript("window.scrollBy(0,250)", "");
    
	Thread.sleep(1000);
	
	//Confirm the images uploading details
	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
	     
	 
	     //Switch back to parent window 
	        driver.switchTo().window(parentWindow2);
	      
		waitForPageLoad();
		
		Thread.sleep(1000);
	
	        
	       
	  //Goto Summary Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	        
	   //Wait for some time
	    
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
		
    
      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
      
    //Wait for all the fields to be appeared
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
      
      JavascriptExecutor jse300 = (JavascriptExecutor)driver;
      jse300.executeScript("window.scrollBy(0,-250)", "");
      
      
      Thread.sleep(3000);
	
      
      //Active the product
      driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
      //Wait for the alert to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
      //Press the ok button from alert
      driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
      
     Thread.sleep(10000);
	
      
     driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
     
     waitForPageLoad();
     
     Thread.sleep(1000);
     
     waitForPageLoad();
     
     Thread.sleep(1000);
	
     
     //Scroll down
     JavascriptExecutor jse78 = (JavascriptExecutor)driver;
     jse78.executeScript("window.scrollBy(0,250)", "");
     
     //Wait
     
     
	Thread.sleep(1000);
	
     
     driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame1");
     
    
     
     driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);
	 
	 
     driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame2");
     
	 
      
	 driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER); 
	 
	 
	
	
      driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
      
      
	  waitForPageLoad();
	  
	  Thread.sleep(1000);
	  
      waitForPageLoad();
	  
	  Thread.sleep(3000);
	
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
      
      Thread.sleep(1000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
      
      Thread.sleep(1000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
      
      Thread.sleep(1000);
      
   
      
	
	
      driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
      
      try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
      driver.findElement(By.xpath(Testelements.SKURequired1)).sendKeys("3");
      
      driver.findElement(By.xpath(Testelements.SKURequired2)).sendKeys("2");
      
      
      if(driver.getCurrentUrl().contains("stage")){
    	     
    	  WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1));
          Select dropdown10= new Select(mySelectElement10);
         
          dropdown10.selectByVisibleText("In Stock");
          
          driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
          
          
          
          driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
          
                    
          WebElement mySelectElement11 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus2));
          Select dropdown11= new Select(mySelectElement11);
          
        
          dropdown11.selectByVisibleText("In Stock");  
      }
         
      
      
      else{
    	  
    	  WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1));
          Select dropdown10= new Select(mySelectElement10);
         
          dropdown10.selectByVisibleText("In Stock");
          
          driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1)).click();
          
          
          
          driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1)).click();
          
         
          
          WebElement mySelectElement11 = driver.findElement(By.xpath(Testelements.DistSKU_InvStatus2));
          Select dropdown11= new Select(mySelectElement11);
          
        
          dropdown11.selectByVisibleText("In Stock");  
      }
      
      
	
      if(driver.getCurrentUrl().contains("stage")){
     	 
    	  driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity1)).sendKeys("2");
    	   	 
    	   	 driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity2)).sendKeys("3");
      }
      else{
      driver.findElement(By.xpath(Testelements.DistSKU_Quantity1)).sendKeys("2");
   	 
   	 driver.findElement(By.xpath(Testelements.DistSKU_Quantity2)).sendKeys("3");
     
      }
   	 
   	 
	
	
   	 //Goto Summary Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	    
	    waitForPageLoad();
	    
		Thread.sleep(1000);
		
	    //Manane product listing
	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
   	 
	  //Wait for the button to appear
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
	     
       Thread.sleep(1000);
	     
	     //Make chnages Active
       driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
      
       //Wait for the button to appear
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
	     
	     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
	     
	   //Scroll Page Up
         JavascriptExecutor jse1 = (JavascriptExecutor)driver;
         jse1.executeScript("window.scrollBy(0,-250)", "");
	     
         wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductActiveValidation))); 
	    
	     Thread.sleep(1000);
		
	 	if(driver.findElement(By.xpath(Testelements.ProductActiveValidation)).isDisplayed()){
	 		  System.out.println("Shared Product Add & Updated Successfully");
	 		  test = extent.createTest("AddUpdateSharedProduct");
	 		 
	 		  	test.log(Status.PASS, "Shared Product add & Updated Sucessfully");
	 		    
	 		  	}
	 		  	else{
	 		  		
	 		  		System.out.println("Shared Product Add & Updated UnSuccessfully");
	 		  	  test = extent.createTest("AddUpdateSharedProduct");
	 		  	 
	 		  	  	test.log(Status.FAIL, "Product add & Updated UnSucessfully");
	 		  	}
      	
    	} catch(NoSuchElementException e){
        	e.getStackTrace();
        		}
      
  } 
      
     @Test(priority=8)
     public void PrivateProductAdd() throws InterruptedException{
    	 
    	 try{
   		
    	 
    	 //First store parent window to switch back
         String parentWindow = driver.getWindowHandle();

           
           driver.findElement(By.xpath(Testelements.AddProduct_Dist)).click();
       
         //Switch to new window opened
       	for(String winHandle : driver.getWindowHandles()){
       	    if(!winHandle.equals(parentWindow)) {
       	        driver.switchTo().window(winHandle);
       	    }
       	}
       	  
   			
   		
      //Insert the product name
       	driver.findElement(By.cssSelector(Testelements.Product_Name)).sendKeys(Testdata.Productname);
       	
       	//Insert Product description
       	driver.findElement(By.cssSelector(Testelements.Product_description)).sendKeys("Description: Our most popular bottle, available in a variety of colors to help brighten up anybodys gear. The large opening on our wide-mouth bottles easily accommodates ice cubes, fits most water purifiers and filters, and makes hand washing a breeze. The attached loop-top never gets lost and screws on and off easily. Printed graduations let keep track of your hydration. Dishwasher safe Please make sure the top does not touch the heating element, or it will melt.");
       
          //Select the product type
       	//driver.findElement(By.cssSelector(Testelements.Product_type)).click();
       	
       	 //Creating a robot instance to select option in 2nd place in dropdown
       	WebElement mySelectElement5 = driver.findElement(By.xpath(Testelements.ProductType));
        Select dropdown5= new Select(mySelectElement5);
       
        dropdown5.selectByVisibleText("Automotive Accessories");
       
           
      driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
         
        Thread.sleep(1000);
        
        
        //Press the apply button to add the product
           driver.findElement(By.cssSelector(Testelements.AddProduct_Applybutton)).click();
       
           wait = new WebDriverWait(driver, 180);
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Basicdetails)));
           
           //Wait all tabs to be enabled
           driver.findElement(By.cssSelector(Testelements.Product_Basicdetails)).isEnabled();
           
           
           
           //Switch back to parent window 
           driver.switchTo().window(parentWindow);
          
           waitForPageLoad();
   		
          
           //Check the private product Checkbox
           driver.findElement(By.xpath(Testelements.PrivateProduct_Checkbox)).click();
           
           
           //Insert the product number
           driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber);
           
         //Insert UPC code
           driver.findElement(By.cssSelector(Testelements.UPCCode)).sendKeys(Testdata.UPCCode);
           
         //Insert the product summary
           driver.findElement(By.cssSelector(Testelements.Product_Summary)).sendKeys("This is a velocity Test Product");
           
          
           //First store parent window to switch back
           String parentWindow1 = driver.getWindowHandle(); 
           
         //Open the category popup
           driver.findElement(By.cssSelector(Testelements.Productcategory_dropdown)).click();
           
         //Switch to new window opened
       	for(String winHandle : driver.getWindowHandles()){
       	    if(!winHandle.equals(parentWindow1)) {
       	        driver.switchTo().window(winHandle);
       	    }
       	}
          
   		Thread.sleep(2000);
   	
         
        //Search the category
           driver.findElement(By.cssSelector(Testelements.Category_Searchfield)).sendKeys("Frames");
           
        
   		Thread.sleep(2000);
   	
           
           //Select 2  categories of frames 
           driver.findElement(By.cssSelector(Testelements.Product_category1)).click();
           
       //Select the 2nd 1 
           driver.findElement(By.cssSelector(Testelements.Product_category2)).click();
           
       //Press the apply on category product popup
           driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton)).click();
           
         //Switch back to parent window 
           driver.switchTo().window(parentWindow1);
          
           
           //Wait for 2 sec
           
   			Thread.sleep(2000);
   		
           //Select the pricing tab for SPG
         
           driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
           
           waitForPageLoad();
         
          // Wait for attributes to appear
           
           wait = new WebDriverWait(driver, 180);
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
           
           
   			Thread.sleep(2000);
   		
           
           driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
           
           //Select the 2nd attribute
           driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
           
          
           
           //Wait for few sec
          
   			Thread.sleep(2000);
   		
           
         //Goto imprinting tab and select imprinting
           driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
           
          waitForPageLoad();
           
          //Select an option
           
           WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.ImprintingMethodSelection));
           Select dropdown70= new Select(mySelectElement70);
          
           dropdown70.selectByVisibleText("Silkscreen");
           
           
           
           WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
           JavascriptExecutor executor = (JavascriptExecutor)driver;
           executor.executeScript("arguments[0].click();", element);
     
           
           //Open the pricing tab
           driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
           
           waitForPageLoad();
           
           //Wait for all the fields to be appeared
           wait = new WebDriverWait(driver, 180);
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
           
           try {
   			Thread.sleep(2000);
   		} catch (InterruptedException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
           
           //Insert the details
           driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys("1");
           
           driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1)).sendKeys("20");
           
          // driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1)).click();
           
           //Selection from dropdown
           
           WebElement mySelectElement170 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
           Select dropdown170= new Select(mySelectElement170);
          
           dropdown170.selectByVisibleText("L 70%");
           
          	
   		driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("2");
   		
   		driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
   		
   		//driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2)).click();
   		//Selection from through robots   
   		
   		
   		WebElement mySelectElement71 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
        Select dropdown71= new Select(mySelectElement71);
       
        dropdown71.selectByVisibleText("L 70%");
   		
   		
  		Thread.sleep(2000);
   		
         
       
         //Move to Images tab
   		driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
   		
   		waitForPageLoad();
   		
   		Thread.sleep(1000);
   		
        //Wait for the button to appear
   		 wait = new WebDriverWait(driver, 180);
   	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
   	        
		Thread.sleep(1000);
		
   	     
   	     //First store parent window to switch back
   	     String parentWindow2 = driver.getWindowHandle(); 
   	     
   	     //Press the medialibrary button select image
   	     driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
   	     
   	   //Switch to new window opened
   	    	for(String winHandle : driver.getWindowHandles()){
   	    	    if(!winHandle.equals(parentWindow2)) {
   	    	        driver.switchTo().window(winHandle);
   	    	    }
   	    	}
   	        
   	       
   			waitForPageLoad();
   			
   			Thread.sleep(1000);
   		
   	     
         //Select the images to upload
   	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
   	     
   	    
   	
   	     
  //Scroll up
	    JavascriptExecutor jse110 = (JavascriptExecutor)driver;
	    jse110.executeScript("window.scrollBy(0,250)", "");
	    
	   	Thread.sleep(1000);
		
   //Confirm the images uploading details
   	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
   	     
   	 
   	     //Switch back to parent window 
   	        driver.switchTo().window(parentWindow2);
   	       
   		    waitForPageLoad();
   	        
   	        Thread.sleep(1000);
   	
   	        
   	       
   	  //Goto Summary Tab
   	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
   	        
   	   //Wait for some time
   	   	waitForPageLoad();
   	    
   	    Thread.sleep(1000);
   		
       
         driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
         
       //Wait for all the fields to be appeared
         wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
         
         JavascriptExecutor jse300 = (JavascriptExecutor)driver;
         jse300.executeScript("window.scrollBy(0,-250)", "");
         
   		 Thread.sleep(1000);
   
         
         //Active the product
         driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
         //Wait for the alert to appear
         wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
         //Press the ok button from alert
         driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
         
        
   		Thread.sleep(8000);
   	
         
        driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
        
        
        waitForPageLoad();
        
        Thread.sleep(1000);
        
        waitForPageLoad();
        
        Thread.sleep(1000);
   
        
        //Scroll down
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        
        //Wait
   		Thread.sleep(1000);
   
        
        driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame1");
        
       
       	Thread.sleep(1000);
		
        driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);
        
        
      Thread.sleep(1000);
   
   	 
   	 driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame2");
    
     Thread.sleep(1000);
	
   	 Robot r1;
   	 try {
   		r1 = new Robot();
   		 r1.keyPress(KeyEvent.VK_ENTER);
   	     r1.keyRelease(KeyEvent.VK_ENTER);
   	      
   	} catch (AWTException e1) {
   		// TODO Auto-generated catch block
   		e1.printStackTrace();
   	 }
   	driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);  
         
   		Thread.sleep(2000);
   	
         driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
         
         waitForPageLoad();
         
   		Thread.sleep(1000);
   		
   		waitForPageLoad();
        
   		Thread.sleep(3000);
   
         driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
         
         Thread.sleep(1000);
         
         driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
         
         Thread.sleep(1000);
         
         driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
         
         Thread.sleep(1000);
         
         driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
         
         
   		Thread.sleep(2000);
   
         
         driver.findElement(By.xpath(Testelements.SKURequired1)).sendKeys("3");
         
         driver.findElement(By.xpath(Testelements.SKURequired2)).sendKeys("2");
         
         
         if(driver.getCurrentUrl().contains("stage")){
             
       	  WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1));
             Select dropdown10= new Select(mySelectElement10);
            
             dropdown10.selectByVisibleText("In Stock");
             
             driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
             
            
             
             driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
             
             
             
             WebElement mySelectElement11 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus2));
             Select dropdown11= new Select(mySelectElement11);
             
           
             dropdown11.selectByVisibleText("In Stock");  
         }
            
         
         
         else{
       	  
       	  WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1));
             Select dropdown10= new Select(mySelectElement10);
            
             dropdown10.selectByVisibleText("In Stock");
             
             driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1)).click();
             
             
             
             driver.findElement(By.xpath(Testelements.DistSKU_InvStatus1)).click();
             
             
             
             WebElement mySelectElement11 = driver.findElement(By.xpath(Testelements.DistSKU_InvStatus2));
             Select dropdown11= new Select(mySelectElement11);
             
           
             dropdown11.selectByVisibleText("In Stock");  
         }
         
         
   		
         if(driver.getCurrentUrl().contains("stage")){
        	 
       	  driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity1)).sendKeys("2");
       	   	 
       	   	 driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity2)).sendKeys("3");
         }
         else{
         driver.findElement(By.xpath(Testelements.DistSKU_Quantity1)).sendKeys("2");
      	 
      	 driver.findElement(By.xpath(Testelements.DistSKU_Quantity2)).sendKeys("3");
        
         }
      	 
   		
   
      	 //Goto Summary Tab
   	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
   	    
   	   	waitForPageLoad();
   	   	
   	   	Thread.sleep(1000);
   		
   	    //Manane product listing
   	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
      	 
        Thread.sleep(2000);
   
          //Wait for the button to appear
    		 wait = new WebDriverWait(driver, 180);
    	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
          
         
			Thread.sleep(1000);
		
    	     
          //Make chnages Active
          driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
         
          //Wait for the button to appear
   		 wait = new WebDriverWait(driver, 180);
   	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
   	     
   	     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
   	     
   	//Scroll Page Up
         JavascriptExecutor jse2 = (JavascriptExecutor)driver;
         jse2.executeScript("window.scrollBy(0,-250)", "");
   	     
         wait = new WebDriverWait(driver, 180);
   	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductActiveValidation)));
         
         
         Thread.sleep(2000);
   		
       
   	  if(driver.findElement(By.xpath(Testelements.ProductActiveValidation)).isDisplayed()){
 		  System.out.println("Private Product Add & Updated Successfully");
 		  test = extent.createTest("AddUpdatePrivateProduct");
 		 
 		  	test.log(Status.PASS, "Shared Product add & Updated Sucessfully");
 		    
 		  	}
 		  	else{
 		  		
 		  		System.out.println("Private Product Add & Updated UnSuccessfully");
 		  	  test = extent.createTest("AddUpdatePrivateProduct");
 		  	 
 		  	  	test.log(Status.FAIL, "Private Product add & Updated UnSucessfully");
 		  	}
   	     
   	     
   	     
   	     
   	    
     
     	
    	 }catch(NoSuchElementException e){
        	e.getStackTrace();
        	
	}
       	
     
    	 
   } 	
       	
     @Test(priority=9)
     
     public void CopyProductAndUpdate() throws InterruptedException{
  	   
  	   try{
  	   
  		   Thread.sleep(3000);
  	 //First store parent window to switch back
  	     String parentWindow5 = driver.getWindowHandle(); 
  	   //Click the copy button
  	   
  	   driver.findElement(By.xpath(Testelements.Copy_Button)).click();
  	  
  	 //Switch to new window opened
     	for(String winHandle : driver.getWindowHandles()){
     	    if(!winHandle.equals(parentWindow5)) {
     	        driver.switchTo().window(winHandle);
     	    }
     	}
  	   
  	   //Wait for few sec 
  	
     	
     	 wait = new WebDriverWait(driver, 180);
   	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Copy_Product_field)));
         
         
         Thread.sleep(3000);
  		
  	
  	   WebElement toClear = driver.findElement(By.xpath(Testelements.Copy_Product_field));
  	   toClear.sendKeys(Keys.CONTROL + "a");
  	   toClear.sendKeys(Keys.DELETE); 
  	   //Insert a new name
  	   driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
  	   //Save the copy product 
  	   
  	   driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
  	   
  	   
  		waitForPageLoad();
  	
  		Thread.sleep(1000);
  	   

  	     //Wait for screen to reload
  	waitForPageLoad();
  	
  	Thread.sleep(1000);
  	
    waitForPageLoad();
  	
  	Thread.sleep(3000);
  			
  	driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
  	    	
  	    	Thread.sleep(3000);
  	   
  	    	 //Wait for the alert to appear
    	      wait = new WebDriverWait(driver, 180);
    	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
    	      //Press the ok button from alert   
    	      
    	      Thread.sleep(3000);
    
  	     //Active the product
  	      driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
  	      //Wait for the alert to appear
  	      wait = new WebDriverWait(driver, 180);
  	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
  	      //Press the ok button from alert
  	      driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
  	      
  	      Thread.sleep(2000);
  			
  		  wait = new WebDriverWait(driver, 180);
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductActiveValidation)));
  		
 if(driver.findElement(By.xpath(Testelements.ProductActiveValidation)).isDisplayed()){
        	
        	System.out.println("Copied Product Active Successfully");
       	 test = extent.createTest("Copy Product Activation");
           
            test.log(Status.PASS, "Copied Product Active Successfully");
        
        }
        else{
        	
        	 System.out.println("Copied Product Active UnSuccessfully");
        	 test = extent.createTest("Copy Product Activation");
            
             test.log(Status.FAIL, "Copied Product Active UnSuccessfully ");

       
        
        }  
  	         	
  	  	}catch(NoSuchElementException e){
  	      	e.getStackTrace();
  	      
  	 	}
  	   
  	   
  	   
  	   }
     
     
      @Test(priority=10)
      public void CreateCustomProducts() throws InterruptedException{
    	  try{
    	  //Press the Search and Copy Button
    	  
    	driver.findElement(By.xpath(Testelements.SearchCopy_Button)).click();
    	
    	//Wait for the alert to appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.QuickSearch_Product)));
	      
	   //Enter the product keyword
	      driver.findElement(By.xpath(Testelements.QuickSearch_Product)).sendKeys("frames");
	      
	    Thread.sleep(1000);
	    
	  //Press the go button
	    driver.findElement(By.xpath(Testelements.QuickSearch_Go)).click();
	    
	  //Wait for the products to appear and press create customs
	    
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CreateCustom_Products)));
	    
	    Thread.sleep(2000);
	    //Press the create custom button
	      driver.findElement(By.xpath(Testelements.CreateCustom_Products)).click();
	     
	      wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Summary_Tab)));
		    
		    Thread.sleep(2000);
	      
	       
	       
	       if( driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).isDisplayed()){
	    	   System.out.println("Custom Product Created sucessfully");
	    	   
	    	   test = extent.createTest("CreateCustomProducts");
		    	
		    test.log(Status.PASS, "Custom Product Created sucessfully"); 
	       
	       }
	       else{
	    	   
                System.out.println("Custom Product Created unsucessfully");
	    	   
	    	   test = extent.createTest("CreateCustomProducts");
		    	
		      test.log(Status.FAIL, "Custom Product Created unsucessfully"); 
	       }
	       
	      Thread.sleep(3000);
	       
	       //GoTo Basic Details Screen
	      driver.findElement(By.xpath(Testelements.BasicdetailsTextValidation)).click();
	      
	      waitForPageLoad();
	    	
	      Thread.sleep(2000);
	      
	      if(driver.findElement(By.xpath(Testelements.MarketSegmentBulkEditAdd_Verification)).isDisplayed())
	  	   {
	  		   System.out.println("Market Segment Assign to Custom Products after Copying Product Successfully");
	  	   
	  		 test = extent.createTest("MarketSegment_Assign_CustomProducts_Verification");
     	 
	       	  test.log(Status.PASS, "Market Segment Assign to Custom Products after Copying Product Successfully");
	  	   
	  	   }
	  	   else{
	  		 System.out.println("Market Segment Assign to Custom Products after Copying Product UnSuccessfully");
	  	   
	  		  test = extent.createTest("MarketSegment_Assign_CustomProducts_AfterCopyingProduct_Verification");
    	 
	       	  test.log(Status.FAIL, "Market Segment Assign to Custom Products after Copying Product UnSuccessfully");
	  	   
	  	   }  
	    	
	      //Select the other market segment as well
	      driver.findElement(By.xpath(Testelements.MarketSegmentBulkEditAdd_Verification)).click();
	      
	      if(driver.findElement(By.xpath(Testelements.Canada_MarketSegment_CustomProductVerification)).isDisplayed() & driver.findElement(By.xpath(Testelements.USA_MarketSegment_CustomProductVerification)).isDisplayed())
	      {
	    	System.out.println("After Copying Custom Products Canada & and USA Market Segment Displayed on Basic Details Of Product Successfully");
	    	
	    	test = extent.createTest("CAN_USA_MarketSegment_CustomProducts_Verification");
	     	 
	       	test.log(Status.PASS, "After Copying Custom Products Canada & and USA Market Segment Displayed on Basic Details Of Product Successfully");
	      }
	      else{
	    	  System.out.println("After Copying Custom Products Canada & and USA Market Segment Displayed on Basic Details Of Product UnSuccessfully");
		    	
		    	test = extent.createTest("CAN_USA_MarketSegment_CustomProducts_Verification");
		     	 
		       	  test.log(Status.FAIL, "After Copying Custom Products Canada & and USA Market Segment Displayed on Basic Details Of Product UnSuccessfully"); 
	      }
	      
	      //Now Select Market Segment Canada Also
	      driver.findElement(By.xpath(Testelements.Canada_MarketSegment_Selection)).click();
	      
	      Thread.sleep(2000);
	      
	      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();   
	      
	       //Wait for all the fields to be appeared
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
	       
	       Thread.sleep(2000);
	      
	       //Active the product
	       driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
	       //Wait for the alert to appear
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
	       //Press the ok button from alert
	       driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
	       
	       
	     	Thread.sleep(10000);
	     	
	     	driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	        
	        waitForPageLoad();
	        
	        Thread.sleep(1000);
	        
	        waitForPageLoad();
	        
	        Thread.sleep(1000);
	        
	        if(driver.findElement(By.xpath(Testelements.MarketSegmentMultiCountry_Verification_BasicDetails_Screen)).isDisplayed())
	        {
	        	System.out.println("Custom Product Updated with Multi Market Segment Successfully");
	        	
	        	test = extent.createTest("CAN_USA_MarketSegment_CustomProducts_Verification_AfterUpdatingMarketSegement");
		     	 
		       	  test.log(Status.PASS, "Custom Product Updated with Multi Market Segment Successfully");
	        	
	        }
	        else{
                 System.out.println("Custom Product Updated with Multi Market Segment UnSuccessfully");
	        	
	        	test = extent.createTest("CAN_USA_MarketSegment_CustomProducts_Verification_AfterUpdatingMarketSegement");
		     	 
		       	 test.log(Status.FAIL, "Custom Product Updated with Multi Market Segment UnSuccessfully");
	        }
	     	
	       
	      
	 	}catch(NoSuchElementException e){
	      	e.getStackTrace();
	      	
	 	}
      
    	  
    	  
    	  }
      
      @Test(priority=11)
      public void NavigationfromWebsitesToCustomProducts() throws InterruptedException{
    	  try{
         
    		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();   
		      
		       //Wait for all the fields to be appeared
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BackToWebsiteButton)));
		       
		       Thread.sleep(3000);
    		  
    	//Press the back to websites button
    	  driver.findElement(By.xpath(Testelements.BackToWebsiteButton)).click();
    	  
    	  //Wait for next element to appear
    	  wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Websites_GlobalFeaturesTab)));
     
        //Click the global features tab
		    driver.findElement(By.xpath(Testelements.Websites_GlobalFeaturesTab)).click();
		    
		 Thread.sleep(1000);   
      //Press the custom products from dropdown
		 driver.findElement(By.xpath(Testelements.Globalfeatures_CustomProducts)).click();
		 
		 wait = new WebDriverWait(driver, 180);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DistributorLoginSuccess_Validation)));
		
		 Thread.sleep(2000);
		 
		 if(driver.findElement(By.xpath(Testelements.DistributorLoginSuccess_Validation)).isDisplayed()){
			    System.out.println("Navigate from website to custom product sucessfully");
			   
			    test = extent.createTest("NavigationfromWebsitesToCustomProducts");
				
				test.log(Status.PASS, "Navigate from website to custom product sucessfully");
			    }
			    else{
			    	 System.out.println("Navigate from website to custom product UnSuccessfully");
			    	   
			    	    test = extent.createTest("NavigationfromWebsitesToCustomProducts");
			    		
			    		test.log(Status.FAIL, "Navigate from website to custom product UnSuccessfully");
			    
			    }
		 
		  	
	  	
	  	}catch(NoSuchElementException e){
	      	e.getStackTrace();
	      	
	 	}
      
      }
     
      public static void waitForPageLoad() throws InterruptedException {
  		
  		
   	   wait = new WebDriverWait(driver, 120);
   	       
   	    pageLoaded = new Predicate<WebDriver>() {

   	        public boolean apply(WebDriver input) {
   	            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
   	        }

   	    };
   	   
   	   System.out.println("Page Loaded Successfully");
   	   
   	   Thread.sleep(2000);
   	   
   	   if(driver.findElement(By.xpath("//div[contains(@id,'info_pibusyindicator')]")).isDisplayed()){
   		   waitForPageLoad();
   	   }
   }     
      
      
 
 @AfterMethod
  public void getResult(ITestResult result){
  	
  	if(result.getStatus()==ITestResult.FAILURE){
  		
  		test.log(Status.FAIL, result.getThrowable());
  	}
  	extent.flush();
  }

   
   
   
   
   
   @AfterTest
  public void teardown(){
   	
	   driver.close();
   	
  }



}
    
