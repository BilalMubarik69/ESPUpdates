package Execution_Suite;




import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class Velocity_Distributor_WithLicence {
 
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/VelocityDistributorWithLicenceReport"+".html");
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
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/VelocityDistributorWithLicenceReport"+".html");
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
		
		else if(browser.equalsIgnoreCase("firefox")){
				
				
			    WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/VelocityDistributorWithLicenceReport"+".html");
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
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDEASINumberStage);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDEUsernameStage);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDEPasswordStage);
        }
        else if(driver.getCurrentUrl().contains("uat")){
        	
        	 //Insert ASI Number
            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDEASINumberUAT);
            
            //Insert the username
            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDEUsernameUAT);
            
            //Insert the Password
            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDEPasswordUAT);
        }
        
        else{
        	 //Insert ASI Number
            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDEASINumberProd);
            
            //Insert the username
            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDEUsernameProd);
            
            //Insert the Password
            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDEPasswordProd);
        	
        }
        
    //Press the login Button
    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation)));
    
    
    Thread.sleep(2000);
    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation)).isDisplayed()){
        System.out.println("Login Successfull");
        test = extent.createTest("Login");
    	
    	test.log(Status.PASS, "Distributor loggedin sucessfully");
        }
        else{
        	 System.out.println("Login UnSuccessfull");
        	    test = extent.createTest("Login");
        		
        		test.log(Status.FAIL, "Distributor loggedin sucessfully");
        }
    
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
    
    }
  }  
  
  @Test(priority=1)
  public void DistributorSearch() throws InterruptedException{
	  try{
	  //Wait for supplier asi insertion field to appear
	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_asi_Insertion)));
      //Send info into asi field
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("101574");
      //Click the search for supplier serach
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
      //Select the supplier through clicking
      Thread.sleep(2000);
     
      if(driver.findElement(By.cssSelector(Testelements.Supplier_selection)).isDisplayed()){
       	 System.out.println("Distributor Searched Successfully");
       	 test = extent.createTest("DistributorSearch");
       	 
       	 test.log(Status.PASS, "Distributor Searched Successfully"); 
        }
        else{
       	 
      	  System.out.print("Distributor Searched Unsuccessfull");
      	  test = extent.createTest("DistributorSearch");
       	  
       	 test.log(Status.FAIL, "Distributor Searched UnSuccessfully");
       	 
        }  
      
      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
      	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
  }
  
  }
  
  
  @Test(priority=2)
  
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
        
        driver.findElement(By.xpath(Testelements.ProductCategory_Product_Button_Selection_Option)).click();
      //Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    	    if(!winHandle.equals(parentWindow1)) {
    	        driver.switchTo().window(winHandle);
    	    }
    	}
        
        
		Thread.sleep(1000);
	
      
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
       
        //Scroll down
        JavascriptExecutor jse50 = (JavascriptExecutor)driver;
        jse50.executeScript("window.scrollBy(0,-250)", "");
        
        Thread.sleep(2000);
        //Wait for 2 sec
        
		
		
        //Select the pricing tab for SPG
      
        driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
        
        waitForPageLoad();
      
       // Wait for attributes to appear
        
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
        
        
		Thread.sleep(2000);
		
		//Scroll down
	    JavascriptExecutor jse400 = (JavascriptExecutor)driver;
	    jse400.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll down
	    JavascriptExecutor jse409 = (JavascriptExecutor)driver;
	    jse409.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(1000);
        
        driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
        
        //Select the 2nd attribute
        driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
        
        //Save the attributes details
       // driver.findElement(By.cssSelector(Testelements.Product_Save_Button)).click();
        
        //Wait for few sec
        
		Thread.sleep(2000);
		  
        //Open the pricing tab
        driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
        
        waitForPageLoad();
        
        //Wait for all the fields to be appeared
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
        
        
		Thread.sleep(2000);
		
        
        //Insert the details
        driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys("1");
        
        driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1)).sendKeys("20");
        
        
        //Selection from dropdown
        	
        WebElement mySelectElement170 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
        Select dropdown170= new Select(mySelectElement170);
       
        dropdown170.selectByVisibleText("L 70%");
        	
		driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("2");
		
		driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
		
		
		
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
	     
	      
	 //Scroll down
    JavascriptExecutor jse410 = (JavascriptExecutor)driver;
    jse410.executeScript("window.scrollBy(0,250)", "");
    
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
      
      
     
      
      try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
      //Active the product
      driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
      //Wait for the alert to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
      
      
      
	  Thread.sleep(2000);
	  
	  if(driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).isDisplayed()){
	
      System.out.print("Productcreated and Active without Imprint for distributor Successfully");
      test = extent.createTest("Productcreated and Active without Imprint for distributor");
      test.log(Status.PASS, "Relax Imprint Method Validation rule for Distributors sucessfully");
	  }
	  else{
		  
		  System.out.print("Productcreated and Active without Imprint for distributor unsuccessfully");
	      test = extent.createTest("Productcreated and Active without Imprint for distributor");
	      test.log(Status.FAIL, "Relax Imprint Method Validation rule for Distributors unsucessfully");
	  }
    	//Press the ok button from alert
        driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
        
        Thread.sleep(7000);
    	
      
      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
     
      waitForPageLoad();
      
      Thread.sleep(1000);
      
      waitForPageLoad();
      
      Thread.sleep(1000);
      
	
     
     //Scroll down
     JavascriptExecutor jse3000 = (JavascriptExecutor)driver;
     jse3000.executeScript("window.scrollBy(0,250)", "");
     
     //Wait
   	Thread.sleep(1000);
	
     
     driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame1");
     
     
     
     driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);
     
  
	 driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame2");
     
	 
	 
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
      
      
      Thread.sleep(2000);
	
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
      
      
      try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	
      if(driver.getCurrentUrl().contains("stage")){
    	 
    	  driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity1)).sendKeys("2");
    	   	 
    	   	 driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity2)).sendKeys("3");
      }
      else{
      driver.findElement(By.xpath(Testelements.DistSKU_Quantity1)).sendKeys("2");
   	 
   	 driver.findElement(By.xpath(Testelements.DistSKU_Quantity2)).sendKeys("3");
     
      }
   	 Thread.sleep(1000);
	
   	 //Goto Summary Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	    
	    
		waitForPageLoad();
		
		Thread.sleep(1000);
		
	    //Manane product listing
	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
   	 
	  //Wait for the button to appear
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
	     
       Thread.sleep(2000);
	     
     //Scroll Up
       JavascriptExecutor jse411 = (JavascriptExecutor)driver;
       jse411.executeScript("window.scrollBy(0,-250)", "");
       
     //Scroll Up
       JavascriptExecutor jse412 = (JavascriptExecutor)driver;
       jse412.executeScript("window.scrollBy(-250,-500)", "");
       
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
	     
	     
	     Thread.sleep(10000);
		
    
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
  	@Test(priority=3)
    
    public void SEO_DistributorCommenets_ImporsonationToSupplier_FromDistributor() throws InterruptedException{
    	
    	try{    
  
    		//Go to EIT Dashboard tab 
    		driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();

    		 //Wait for supplier asi insertion field to appear
    		  wait = new WebDriverWait(driver, 180);
    	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_asi_Insertion)));
    	    //Send info into asi field
    	    driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
    	    //Click the search for supplier serach
    	    driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
    	    
    	    wait = new WebDriverWait(driver, 180);
    	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
    	    
    	    Thread.sleep(1000);
    	    
    	    driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
    	    
    	  
    	    wait = new WebDriverWait(driver, 180);
   	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
    	    
   	        Thread.sleep(2000);
    	    
    	    //Click the manage product tab
    	  	driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
    	  	
    	    wait = new WebDriverWait(driver, 180);
   	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
   	      
   	      Thread.sleep(2000);
   	      
   	      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
   	      
   	      waitForPageLoad();
   	      
   	      Thread.sleep(2000);
   	      
          waitForPageLoad();
   	      
   	      Thread.sleep(2000);
    	
    	  if(driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).isSelected())
    	  {
    		  driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).click();
    		  
    		  //Press the Save Button
    		  driver.findElement(By.xpath(Testelements.SaveButton_ProductCreation)).click();
    		  
    		  waitForPageLoad();
       	      
       	      Thread.sleep(9000);
       	      
       	      if(!driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).isSelected())
       	      {
       	    	  System.out.println("SEO UnSelect Successfully after Saving");
       	    	  
       	    	test = extent.createTest("SEOProduct_Update_Verification_AfterImpersonating_SupplierFrom_Distributor");
   	 		 
	 		  	test.log(Status.PASS, "SEO UnSelect Successfully from impersonate supplier from Distributor after Saving ");
       	      }
       	      else{
       	    	System.out.println("SEO UnSelect UnSuccessfully after Saving");
       	      
       	    	test = extent.createTest("SEOProduct_Update_Verification_AfterImpersonating_SupplierFrom_Distributor");
      	 		 
	 		  	test.log(Status.FAIL, "SEO UnSelect UnSuccessfully from impersonate supplier from Distributor after Saving ");
       	      
       	      }
    	  
    	  
    	  }
    	  else{
    		  driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).click(); 
    		  
    		  //Press the Save Button
    		  driver.findElement(By.xpath(Testelements.SaveButton_ProductCreation)).click();
    		  
    		  waitForPageLoad();
       	      
       	      Thread.sleep(9000);
       	      
       	      if(driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).isSelected())
       	      {
       	    	  System.out.println("SEO Select Successfully from impersonate supplier from Distributor after Saving");
       	    	  
       	    	test = extent.createTest("SEOProduct_Update_Verification_AfterImpersonating_SupplierFrom_Distributor");
      	 		 
	 		  	test.log(Status.PASS, "SEO Select Successfully from impersonate supplier from Distributor after Saving ");
       	      }
       	      else{
       	    	System.out.println("SEO Select UnSuccessfully from impersonate supplier from Distributor after Saving");
       	      
       	    	test = extent.createTest("SEOProduct_Update_Verification_AfterImpersonating_SupplierFrom_Distributor");
     	 		 
	 		  	test.log(Status.FAIL, "SEO Select UnSuccessfully from impersonate supplier from Distributor after Saving ");
       	      
       	      }
    	  }
    	
    	  //Update Distributor Comments
    	  driver.findElement(By.xpath(Testelements.DistributorCommentsField_ProductLevel)).clear();
    	  
    	  Thread.sleep(1000);
    	  
    	  driver.findElement(By.xpath(Testelements.DistributorCommentsField_ProductLevel)).sendKeys("Updated Distributor Comments");
    	
    	  driver.findElement(By.xpath(Testelements.OuterareaClickBasicDetail_ToEnableSaveButton)).click();
    	  
    	  Thread.sleep(2000);
    	  
    	  //Press the Save Button
		  driver.findElement(By.xpath(Testelements.SaveButton_ProductCreation)).click();
		  
		  waitForPageLoad();
   	      
   	      Thread.sleep(7000);
   	      
   	   WebElement DistributorText=driver.findElement(By.xpath(Testelements.DistributorCommentsField_ProductLevel));
 	  String DistributorTextVerify=DistributorText.getAttribute("value");
 	  
 	   System.out.println(DistributorTextVerify);
 	   
 	   if(DistributorTextVerify.contains("Updated Distributor Comments"))
 	   {
 		   System.out.println("Distributor Comments Field Text Updated after Saving Successfully with impersonate form distributor to supplier");
 		   
 		   test = extent.createTest("DistributorCommentsField_TextUpdation_AfterSaving");
 		   	
 		   test.log(Status.PASS, "Distributor Comments Field Text Updated after Saving Successfully with impersonate form distributor to supplier ");
 	   }
 	   else{
 		  System.out.println("Distributor Comments Field Text Updated after Saving UnSuccessfully with impersonate form distributor to supplier");
		   
		   test = extent.createTest("DistributorCommentsField_TextUpdation_AfterSaving");
		   	
		   test.log(Status.FAIL, "Distributor Comments Field Text Updated after Saving UnSuccessfully with impersonate form distributor to supplier ");
 		   
 	   }
       
 	  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
 	  
 	 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
     jse70.executeScript("window.scrollBy(0,-250)", "");
     
     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
     jse71.executeScript("window.scrollBy(-250,-500)", "");
     
     JavascriptExecutor jse72 = (JavascriptExecutor)driver;
     jse72.executeScript("window.scrollBy(-500,-750)", "");
     
     Thread.sleep(1000);
		
		//Now Press the changes Save effect link
		
	   wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
     
      
  	Thread.sleep(2000);
  	
     
     //Make chnages Active
     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
    
     //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
       
       driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
       
       
  	 Thread.sleep(8000);
  	 
  	driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	
    
	 Thread.sleep(1000);
		
		
       //First store parent window to switch back
       String parentWindow17 = driver.getWindowHandle();

      //Press the bulk edit button
      driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	        
	       //Switch to new window opened
	     	for(String winHandle : driver.getWindowHandles()){
	     	    if(!winHandle.equals(parentWindow17)) {
	     	        driver.switchTo().window(winHandle);
	     	    }
	     	}
	     	  
	     	
			Thread.sleep(3000);
			
			//Press the selected product radio button on bulk edit popup
	 		 List<WebElement> li20= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 		 li20.get(2).click();
	 		 
	 	 //Now Select the Distributor Comments Only Option from list
	 		 driver.findElement(By.xpath(Testelements.Bulk_UpdateDistributorOnlyComments)).click();
	 		 
	 		 Thread.sleep(1000);
	 		 
	 		 //Press the Bulk Edit Button
	 		//Press the bulk edit poup button
			 	List<WebElement> li72= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
				li72.get(8).click();
				
				Thread.sleep(3000);
				
				 WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistributorComments_OperationsSelections));
		          Select dropdown10= new Select(mySelectElement10);
		         
		          dropdown10.selectByVisibleText("Replace");
		          
		      //Now Add the Replaceable comments
		          driver.findElement(By.xpath(Testelements.DistributorComments_BulkField_TextArea)).sendKeys("Test");
		          
		          //Press the Save and Apply button
		          driver.findElement(By.xpath(Testelements.DistributorCommentsBulk_SaveandApply_Button)).click();
		          
		          Thread.sleep(2000);
		          
		          //Press ok from Success Message
		          driver.findElement(By.xpath(Testelements.DistributorCommentsBulk_SuccessMessage_OkButton)).click();
		          
		          Thread.sleep(2000);
		          
		          //Edit and Validate if the change taken place or not
		          driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		   	      
		   	      waitForPageLoad();
		   	      
		   	      Thread.sleep(2000);
		   	      
		          waitForPageLoad();
		   	      
		   	      Thread.sleep(2000);
		   	      
		   	   WebElement DistributorTextBulk=driver.findElement(By.xpath(Testelements.DistributorCommentsField_ProductLevel));
		  	  String DistributorTextVerifyBulk=DistributorTextBulk.getAttribute("value");
		  	  
		  	   System.out.println(DistributorTextVerifyBulk);
		  	   
		  	   if(DistributorTextVerifyBulk.contains("Test"))
		  	   {
		  		   System.out.println("Distributor Comments Field Text Updated after Bulk Successfully with impersonate form distributor to supplier");
		  		   
		  		   test = extent.createTest("DistributorCommentsField_TextUpdation_AfterSaving_Bulk");
		  		   	
		  		   test.log(Status.PASS, "Distributor Comments Field Text Updated after Bulk Successfully with impersonate form distributor to supplier ");
		  	   }
		  	   else{
		  		  System.out.println("Distributor Comments Field Text Updated after Bulk Saving UnSuccessfully with impersonate form distributor to supplier");
		 		   
		 		   test = extent.createTest("DistributorCommentsField_TextUpdation_AfterSaving_Bulk");
		 		   	
		 		   test.log(Status.FAIL, "Distributor Comments Field Text Updated after Bulk Saving UnSuccessfully with impersonate form distributor to supplier ");
		  		   
		  	   } 
				
		  	 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  	 
		  	 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		     
		     Thread.sleep(4000);
		  	
		  	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		  	
		  	Thread.sleep(1000);
		  	
		  //First store parent window to switch back
	 	       String parentWindow9 = driver.getWindowHandle();

	 	     //Press the bulk edit button
	 			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	 	        
	 	       //Switch to new window opened
	 	     	for(String winHandle : driver.getWindowHandles()){
	 	     	    if(!winHandle.equals(parentWindow9)) {
	 	     	        driver.switchTo().window(winHandle);
	 	     	    }
	 	     	}
	 	     	  
	 			   Thread.sleep(2000);
	 				
	 	 			List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 	 		  	li1.get(2).click();
	 	
	 			   Thread.sleep(1000);
	 			   
	 			   //Slect the remove seo flag
	 			   driver.findElement(By.xpath(Testelements.BulkEdit_RemoveSEOFlag)).click();
	 			   
	 			   
	 			 //Now Press the bulk Edit Button
	 		  		List<WebElement> li7= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	 				li7.get(8).click();
	 				
	 			    Thread.sleep(2000);
	 		  //Press the Apply button
	 			    driver.findElement(By.xpath(Testelements.BulkRemove_ApplyButton)).click();
	 			    
	 			    Thread.sleep(3000);
	 			    
	 		 //Press the email confirmation alert ok button
	 			    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();
	 			    
	 			  //Press the Edit Button
	 				
	 				driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	 			    
	 			    waitForPageLoad();
	 			    
	 			    Thread.sleep(2000);
	 			    
	 			    waitForPageLoad();
	 			 	
	 			     Thread.sleep(7000);
	 				
	 			   //Checked the SEO Flag
	 			  if(!driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).isSelected())
	 			  {
	 				  System.out.println("Bulk SEO Operation Successfully done after impersonating Distributor with Supplier");
	 				  
	 				  test = extent.createTest("SEOFlag_BulkRemove_AfterImpersonating_SupplierFromDistributor ");
	 		  		     
	 		  		  test.log(Status.PASS, "Bulk SEO Operation Successfully done after impersonating Distributor with Supplier");
	 			  }

	 			  else{
	                  System.out.println("Bulk SEO Operation UnSuccessfully done after impersonating Distributor with Supplier");
	 				  
	 				  test = extent.createTest("SEOFlag_BulkRemove_AfterImpersonating_SupplierFromDistributor ");
	 		  		     
	 		  		  test.log(Status.FAIL, "Bulk SEO Operation UnSuccessfully done after impersonating Distributor with Supplier");
	 				  
	 			  }
		  	
		  	 
		  	 
    	
    	}
    	catch(NoSuchElementException e)
    	{
    		e.getStackTrace();
    	}
  
  } 
  
  
  
  
  
  
  
  
  
  
  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

      //Convert web driver object to TakeScreenshot

      TakesScreenshot scrShot =((TakesScreenshot)webdriver);

      //Call getScreenshotAs method to create image file

              File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

          //Move image file to new destination

              File DestFile=new File(fileWithPath);

              //Copy file at destination

              FileUtils.copyFile(SrcFile, DestFile);

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



