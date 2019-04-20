package Execution_Suite;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

public class Velocity_WithLicence_Supplier {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	
	
	@BeforeTest
	
	public void setup(){
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/VelocityWithLicenceSupplier"+".html");
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
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
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
    driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberStage);
    
    //Insert the username
    driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameStage);
    
    //Insert the Password
    driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordStage);
    }
    else if(driver.getCurrentUrl().contains("uat")){
    	
    	//Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberUAT);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameUAT);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordUAT);	
    }
    
    else{
    	
    	//Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberProd);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameProd);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordProd);	
    }
    
    //Press the login Button
    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
    
  
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation)));
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation)).isDisplayed()){
    System.out.println("Login Successfull");
    test = extent.createTest("Login");
	
	test.log(Status.PASS, "Login to Esp Updates Successfully");
    }
    else{
    	 System.out.println("Login UnSuccessfull");
    	    test = extent.createTest("Login");
    		
    		test.log(Status.FAIL, "Login to Esp Updates UnSuccessfully");
    }
	
    
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
    
    }
  }  
   
  @Test(priority=1)
  public void SupplierSearch(){
	  try{
	  //Wait for supplier asi insertion field to appear
	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_asi_Insertion)));
      //Send info into asi field
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
      //Click the search for supplier serach
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
      if(driver.findElement(By.cssSelector(Testelements.Supplier_selection)).isDisplayed()){
      	 System.out.println("Supplier Searched Successfully");
      	 test = extent.createTest("SupplierSearch");
      	 
      	 test.log(Status.PASS, "Supplier Searched Successfully"); 
       }
       else{
      	 
     	  System.out.print("Supplier Searched Unsuccessfull");
     	  test = extent.createTest("SupplierSearch");
      	  
      	 test.log(Status.FAIL, "Supplier Searched UnSuccessfully");
      	 
       }
       //Select the supplier through clicking
       driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
       
 	  }catch(NoSuchElementException e){
 	  e.getStackTrace();
 	 
   }
   
   }
  
  @Test(priority=2)
  public void ScoreboardViewed() throws InterruptedException{
	  try{
	  
		  wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ScorecardScreenDisplay_SuccessfullyValidation)));
		  
		  
		  Thread.sleep(2000);
		  
	      if(driver.findElement(By.xpath(Testelements.ScorecardScreenDisplay_SuccessfullyValidation)).getText().contains("TOTAL ACTIVE PRODUCTS")){
	    	  System.out.println("Scoreboard Displayed Successfully");
	    	  
	    	  test = extent.createTest("ScoreboardViewed");
			  
			  test.log(Status.PASS, "Scoreboard Displayed Successfully");  
	      }
	      else{
	    	  System.out.println("Scoreboard Displayed UnSuccessfully");
	    	  
	    	  test = extent.createTest("ScoreboardViewed");
			  
			  test.log(Status.FAIL, "Scoreboard Displayed UnSuccessfully"); 
	      }
	      
	      
	      wait = new WebDriverWait(driver, 120);
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.RecentProducts)));
		 
		 //Click the Recent Product from ScoreCard Screen
		 driver.findElement(By.cssSelector(Testelements.RecentProducts)).click();
		 
		 waitForPageLoad();
		 

		 if(driver.findElement(By.xpath(Testelements.BasicdetailsTextValidation)).getText().contains("Basic Details") & driver.findElement(By.xpath(Testelements.ProductType_BasicdetailsScreen_Validation)).getText().contains("What type of product are you entering?") )
		 {
			 System.out.println("Basic Details screen and Product Type Displayed successfully so Recent Product Searched Successfully from scorecard screen ");
			 
			 test = extent.createTest("RecentProduct_Searching_WithNavigationBack");
			  	
			  test.log(Status.PASS, "Basic Details screen and Product Type Displayed successfully so Recent Product Searched Successfully from scorecard screen");	 
		 }
		 else{
			 
             System.out.println("Basic Details screen and Product Type Displayed unsuccessfully so Recent Product Searched UnSuccessfully from scorecard screen ");
			 
			 test = extent.createTest("RecentProduct_Searching_WithNavigationBack");
			  	
			  test.log(Status.FAIL, "Basic Details screen and Product Type Displayed unsuccessfully so Recent Product Searched UnSuccessfully from scorecard screen");	  
		 }
		 
		 //Press the Manage Products Tab to go back to manage Products
		 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  
	     Thread.sleep(1000);
	     
	     //Press the scorecard screen
	     driver.findElement(By.cssSelector(Testelements.ScorecardTab)).click();
	     
	     wait = new WebDriverWait(driver, 120);
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.RecentProducts)));
	  
  
		  
		  }catch(NoSuchElementException e){
		  e.getStackTrace();
		 
	  }
	  
	  }
  
  @Test(priority=3)
  public void EspUpdatesUrlHTTPS() throws InterruptedException{
	  try{
	  
	  
      if(driver.getCurrentUrl().contains("https")){
    	  
           System.out.print("Https url displayed sucessfully");
	       test = extent.createTest("EspUpdatesURLHTTPS");
	     test.log(Status.PASS, "Esp Updates Url in HTTPS is verified");
      }
      else{
    	  
    	   System.out.print("Https url displayed unsucessfull");
    		test = extent.createTest("EspUpdatesURLHTTPS");
    	   test.log(Status.FAIL, "Esp Updates Url in HTTPS is verified Unsucessfull");
      }
     
		  }catch(NoSuchElementException e){
		  e.getStackTrace();
		 
	  }
	  
	  }
  
  @Test(priority=4)
  public void SupplierRatings_ToScorecard() throws InterruptedException{
	  try{
	  //Supplier Performance rating Column existance validation
	  if(driver.findElement(By.xpath(Testelements.SupplierRatingOption_Scorecard)).getText().equals("Supplier Performance Rating")){
		  
		  System.out.print("Performance rating column displayed successfully");
		  test = extent.createTest("Supplier Performance Ratings On Scorecard");
		  test.log(Status.PASS, "Supplier Performance Ratings On Scorecard Displayed Sucessfully");
		  
	  }
	  else{
		  
		  System.out.print("Performance rating column displayed unsuccessfully");
		  
		  test = extent.createTest("Supplier Performance Ratings On Scorecard");
		  	
		  test.log(Status.FAIL, "Supplier Performance Ratings On Scorecard Displayed Unsuccessfull");
	  }
  
    //Now Validate Improvement center text on scorecard
	  if(driver.findElement(By.xpath(Testelements.ImprovementCenter_TextChangeValidation)).isDisplayed()){
		  
		  System.out.print("Improvement Center Text Displayed and shown Sucessfully");
		  test = extent.createTest("IMPROVEMENT CENTER text validation");
		  test.log(Status.PASS, "Improvement Center Text Displayed and shown Sucessfully");
		  
	  }
	  
	  else{
		  
		  System.out.print("Improvement Center Text Displayed and shown UnSucessfully");
		  
		  test = extent.createTest("IMPROVEMENT CENTER text validation");
		  
       	test.log(Status.FAIL, "Improvement Center Text Displayed and shown Unsucessfull");
	  }
  
    
	  Thread.sleep(5000);
	  //Now validate after clicking the supplier rating option on scorecard screen,it should take user to Supplier Info Page
	  driver.findElement(By.xpath(Testelements.SupplierRatingOption_Scorecard)).click();
	  
	  //Wait for Performance Rating Text on supplier info page
	Thread.sleep(3000);
      
      if(driver.findElement(By.cssSelector(Testelements.PerformanceRatingText_SupplierInfoScreen)).getText().equals("Performance Ratings")){
    	  
    	  System.out.print("Performance Rating Text Validation on Supplier Info Page Successfully");
		  test = extent.createTest("Performance Rating Text Validation on Supplier Info Page ");
		  test.log(Status.PASS, "Performance Rating Text Validation on Supplier Info Page Successfully");
    	  
      }
      else{
    	  
    	  System.out.print("Performance Rating Text Validation on Supplier Info Page UnSuccessfully");
		  test = extent.createTest("Performance Rating Text Validation on Supplier Info Page");
		 test.log(Status.FAIL, "Performance Rating Text Validation on Supplier Info Page Unsucessfull");
    	  
      }
	  
  	//Press the Scorecard Tab
      driver.findElement(By.cssSelector(Testelements.ScorecardTab)).click();
      
	  }
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
      
  }
  
  
  
  @Test(priority=5)
  public void HelpandSupportsSanity() throws InterruptedException{
 	 try{
	  //Wait for supplier asi insertion field to appear
 	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Helpandsupport_Button)));
 	 
 	 
 	 //Press the Help&Support Button
 	 driver.findElement(By.xpath(Testelements.Helpandsupport_Button)).click();
 	 
 	 //Wait
 	 Thread.sleep(1000);
 	 
 	 //First store parent window to switch back
 	    String parentWindow = driver.getWindowHandle();

 	    //Switch to new window opened
 	  	for(String winHandle : driver.getWindowHandles()){
 	  	    if(!winHandle.equals(parentWindow)) {
 	  	        driver.switchTo().window(winHandle);
 	  	    }
 	  	}
 	 
 	 
 	 //Click the More to load all data first
 	 driver.findElement(By.xpath(Testelements.MoreOptions_Helpcenter)).click();
 	 
 	 //Wait
 	 Thread.sleep(3000);
 	 
 	 //Go to espHome page
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_EspUpdatesTraining)).click();
 	 
 	 //Wait for few sec
 	 Thread.sleep(3000);
 	 
 	//Go back to previous screen
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 	 
  	
  	//Wait
  	Thread.sleep(2000);
  	
  	 //Go to espHome page
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_BasicdetailsPage)).click();
 	 
 	 //Wait for few sec
 	 Thread.sleep(3000);
 	 
 	//Go back to previous screen
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 	 
 	
 	//Wait
 	Thread.sleep(2000);
 	
 	 //Go to espHome page
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_AttributesTab)).click();
 	 
 	 //Wait for few sec
 	 Thread.sleep(3000);
 	 
 	//Go back to previous screen
 	 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 	 
 	
 	//Wait
 	Thread.sleep(2000);
  	
  	
 	//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_ImprintingTab)).click();
 		 
 		 //Wait for few sec
 		Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_PricingTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_ImagesTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_SKUInventryTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_AvailabilityTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_SupplierInfoTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_MediaLibraryTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_ManageProductsTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_SpecialsTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_CopyProduct)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_CatalogandComplainceTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_DataCenterESP)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_ImageRequirement)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_EditSingleProduct)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_SummaryTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_AddNewproduct)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 	 	
 		//Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_SearchfilterSortProductsTab)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(2000);
 		
 		 //Go to espHome page
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_ESPSpecialsFAQS)).click();
 		 
 		 //Wait for few sec
 		 Thread.sleep(3000);
 		 
 		//Go back to previous screen
 		 driver.findElement(By.cssSelector(Testelements.HelpCenter_BackButton)).click();
 		 
 		
 		//Wait
 		Thread.sleep(7000);
 	 	
 		//Go to contacts tab
 		driver.findElement(By.cssSelector(Testelements.HelpCenter_ContactsTab)).click();
 		
 		Thread.sleep(15000);
 		
 		//Go back
 		driver.findElement(By.cssSelector(Testelements.ContactsTab_BackButton)).click();
 		
 		Thread.sleep(4000);
 	 	
 		//Go training tab
 		driver.findElement(By.cssSelector(Testelements.HelpCenter_TrainingTab)).click();
 		
 		//Wait 
 		Thread.sleep(8000);
 		
 		if(driver.findElement(By.xpath(Testelements.HelpandSupportSanity_ValidationCheck)).getText().contains("Was this helpful?")){
 			System.out.println("Help and support is functional and verified Successfully");
 			
 			test = extent.createTest("HelpandSupportSanity");
  			
  			test.log(Status.PASS, "Help and support is functional and verified Successfully");
 		}
 		else{
 			
            System.out.println("Help and support is functional and verified UnSuccessfully");
 			
 			test = extent.createTest("HelpandSupportSanity");
  			
  			test.log(Status.FAIL, "Help and support is functional and verified UnSuccessfully");
 		}
 		
 		driver.switchTo().frame(driver.findElement(By.xpath(Testelements.Iframe_SwitchingHelpSupport)));
 		
 		Thread.sleep(2000);
 		
 		driver.findElement(By.xpath(Testelements.TrainingOptions_HelpSupport)).click();
 		
 		Thread.sleep(10000);
 		
 		driver.switchTo().defaultContent();
 		
 		driver.findElement(By.cssSelector(Testelements.Finish_HelpSupport)).click();
 			 
 			//Switch back to parent window 
 	    driver.switchTo().window(parentWindow);
 		      
 		Thread.sleep(1000);
 		    
  }
 	catch(NoSuchElementException e){
		  e.getStackTrace();
		 
	  }
        
 	 }
   
 
  @Test(priority=6)
  public void Scorecard_ProductMissingSize() throws Exception{
	  
	//Scroll Down      
      JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	  jse70.executeScript("window.scrollBy(0,250)", "");
	  
	  Thread.sleep(1000);
        
          driver.findElement(By.xpath(Testelements.ProductNumber_Link_Scorecard)).click();
          
          //Scroll Down      
          JavascriptExecutor jse701 = (JavascriptExecutor)driver;
    	  jse701.executeScript("window.scrollBy(0,-250)", "");
    	  
    	  Thread.sleep(1000);
    	  
    	  wait = new WebDriverWait(driver, 120);
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accordion2']/div[2]/div[1]/label/span")));
    	    	  
    		Thread.sleep(3000);
    	    	  
    		driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
    	
    		waitForPageLoad();
    	
    		Thread.sleep(2000);
    		if(driver.findElement(By.xpath(Testelements.ProductNumberValidation_Basicdetails_Screen)).getText().contains("Product Number"))
    		{
    			
    			System.out.println("Product Number Existence on Basic Details Screen Through Scorecard Search Successfully");
    			test = extent.createTest("Product Number Existence on Basic Details Screen Through Scorecard Search");
    	    	
    	    	test.log(Status.PASS, "Product Number Existence on Basic Details Screen Through Scorecard Search Successfully");
    	    	
    		}
    		else{
    			
    			System.out.println("Product Number Existence on Basic Details Screen Through Scorecard Search UnSuccessfully");
    			test = extent.createTest("Product Number Existence on Basic Details Screen Through Scorecard Search");
    	    	
    	    	test.log(Status.FAIL, "Product Number Existence on Basic Details Screen Through Scorecard Search UnSuccessfully");
    		
    		}
    		//Insert the product number
    	    driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber);
    	    
    	    
    	    
           driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Keys.ENTER);
    	    
    	    Thread.sleep(1000);
    	    
    	    //Manane product listing
    	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
    		 
    	    wait = new WebDriverWait(driver, 180);
    	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
    	   
    	    
    			Thread.sleep(2000);
    		 //Make chnages Active
    	   driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
    	  
    	   //Wait for the button to appear
    		 wait = new WebDriverWait(driver, 180);
    	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
    	     
    	     Thread.sleep(1000);
    	     
    	     if(driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).isDisplayed()){
    	    	 
    	    	 System.out.println("Scorecard Search Link Product Number Product Editing Verification Successfully");
    	    	 test = extent.createTest("Scorecard Search Link Product Number Product Editing Verification");
    	     	
    	     	test.log(Status.PASS, "Scorecard Search Link Product Number Product Editing Verification Successfully");
    	     
    	     }
    	     else{
    	    	 System.out.println("Scorecard Search Link Product Number Product Editing Verification UnSuccessfully");
    	    	 test = extent.createTest("Scorecard Search Link Product Number Product Editing Verification");
    	     	
    	     	test.log(Status.FAIL, "Scorecard Search Link Product Number Product Editing Verification UnSuccessfully");
    	     }
    	     
    	    driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
    	     
    	    Thread.sleep(10000);

     
    	    
    	    //Press the scorecard screen
	     driver.findElement(By.cssSelector(Testelements.ScorecardTab)).click();
	     
	     
	     wait = new WebDriverWait(driver, 120);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SKU_Link_Scorecard)));
      
		 Thread.sleep(2000);
		 
		 //Press the order details
		 driver.findElement(By.xpath(Testelements.SKU_Link_Scorecard)).click();
		 
		  wait = new WebDriverWait(driver, 120);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accordion2']/div[2]/div[1]/label/span")));
		    	  
		  Thread.sleep(2000);
		    	  
		//Scroll Up
		    JavascriptExecutor jse704 = (JavascriptExecutor)driver;
		    jse704.executeScript("window.scrollBy(0,-250)", "");
		    
		    Thread.sleep(3000);
		    
		    JavascriptExecutor jse71 = (JavascriptExecutor)driver;
		    jse71.executeScript("window.scrollBy(-250,-500)", "");
		    
		    Thread.sleep(1000);	
		  
		  driver.findElement(By.cssSelector(Testelements.EditProduct)).click();

			// waitForElementNotVisible(30000,driver,"//div[contains(@class,'loading-backdrop fade in')]");
			
			//waitForPageLoad();
		  waitForPageLoad();
		  
		  Thread.sleep(3000);
		 
		 if(driver.findElement(By.cssSelector(Testelements.SKUScorecardLinkToProductDetails_ValidationCheck)).getText().contains("SKU & Inventory based on Product Variations"))
		 {
			 System.out.println("Scorecard Search Link for Order Details for SKU Screen Sucessfully Verified");
			 test = extent.createTest("Scorecard OrderDetails Link Verification");
		     test.log(Status.PASS, "Scorecard Search Link for Order Details for SKU Screen Sucessfully Verified");	 
		 }
		 else{
			 System.out.println("Scorecard Search Link for Order Details for SKU Screen UnSucessfully Verified");
			 
			 test = extent.createTest("Scorecard OrderDetails Link Verification");
		    
		     test.log(Status.FAIL, "Scorecard Search Link for Order Details for SKU Screen UnSucessfully Verified");
		 }
		 
		 
		 //Press the Manage Products Tab to go back to manage Products
		 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  
	     Thread.sleep(1000);
	  
	  
	  
	  //Press the scorecard screen
        driver.findElement(By.cssSelector(Testelements.ScorecardTab)).click();
	     
	     
	     wait = new WebDriverWait(driver, 120);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'scoreLink')]//strong[contains(text(),'Size')]")));
      
		 Thread.sleep(2000);
	     
	 //Select the missing size link on scorecard
	     driver.findElement(By.xpath("//a[contains(@class,'scoreLink')]//strong[contains(text(),'Size')]")).click();
	     
	     wait = new WebDriverWait(driver, 120);
   	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accordion2']/div[2]/div[1]/label/span")));
   	    	  
   		Thread.sleep(3000);
	     
   	//Scroll Up
	    JavascriptExecutor jse7041 = (JavascriptExecutor)driver;
	    jse7041.executeScript("window.scrollBy(0,-250)", "");
	    
	   
	    
	    JavascriptExecutor jse7111 = (JavascriptExecutor)driver;
	    jse7111.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(1000);	 
   		
   		driver.findElement(By.cssSelector(Testelements.EditProduct)).click();

	    // waitForElementNotVisible(30000,driver,"//div[contains(@class,'loading-backdrop fade in')]");
	     
   		waitForPageLoad();
	
		 if(driver.findElement(By.xpath("//span[contains(text(),'(Select Size)')]")).isDisplayed() & driver.findElement(By.xpath("//span[contains(text(),'(Select Size)')]")).getText().contains("(Select Size)"))
		 {
			 System.out.println("No size selected displayed,so test case is passed");
			 
			 test = extent.createTest("Scorecard_ProductMissingSize");
		     
			 test.log(Status.PASS, "No size selected displayed,so test case is passed");
			 
			 
		 }
		 else{
			 
             System.out.println("size selected displayed,so test case is Failed");
			 
			 test = extent.createTest("Scorecard_ProductMissingSize");
		     
			 test.log(Status.FAIL, "size selected displayed,so test case is Failed");
		 }
  }
 
  
  @Test(priority=7)
  public void EITAdminSanity() throws InterruptedException{
	       try{
		  
	    	
	    	   
	      driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
		  
		  Thread.sleep(1000);
		  
		//Send info into asi field
	      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
	      //Click the search for supplier serach
	      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
	      //Wait for supplier selection option to appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
	      //Select the supplier through clicking
	      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
		  
	     Thread.sleep(1000);
	  
        //Go to EIT Manager
	     driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
	     
	    Thread.sleep(1000);
     //Press the EIT Admin Tab
	    driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
	    
	    Thread.sleep(1000);
	//Press the company level in eit admin
	    driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
	    
	    Thread.sleep(1000);
	
	    
	    WebElement mySelectElement = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
	    Select dropdown= new Select(mySelectElement);

	    dropdown.selectByVisibleText("Enable / Disable Product Scorecard");

	   Thread.sleep(2000);
	    
	    
	    //Enter the customer asi number to disable the scoredboard
	    driver.findElement(By.xpath(Testelements.CustomerByASI_EITAdmin)).sendKeys("30232");
	    
	    
	//Check the radio button
	    driver.findElement(By.xpath(Testelements.DisableScoreboard_EITAdmin)).click();
	    
	 //Wait for 2 sec
	    
	    
	 //Press the apply button
	    driver.findElement(By.xpath(Testelements.DisableScoreboard_Apply)).click();
	    
	 
	 
	 //Disable Scoreboard Confirm
	  driver.findElement(By.xpath(Testelements.DisableScoreboard_Confirm)).click();
	  
	  Thread.sleep(1000);
	  
	  if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
	  {
		  System.out.println("EIT Admin Section sanity for Scorecard Disabling successfully");
		  test = extent.createTest("EITAdminSanity For ScorecardDisableing");
		
		test.log(Status.PASS, "EIT Admin Section sanity for Scorecard Disabling successfully");
	  }
	  else{
		  
		  System.out.println("EIT Admin Section sanity for Scorecard Disabling unsuccessfully");
		  test = extent.createTest("EITAdminSanity For ScorecardDisableing");
		
		test.log(Status.FAIL, "EIT Admin Section sanity for Scorecard Disabling unsuccessfully");
	  }
	 
	 //Move towards admin reports section
	 driver.findElement(By.xpath(Testelements.EITAdmin_AdminReports)).click();
	 
	 Thread.sleep(1000);
	 
	 //Select the checkboxes to generate
	 driver.findElement(By.xpath(Testelements.AdminReports_Supplier_Checkbox)).click();
	 
	 Thread.sleep(1000);
	 
	 driver.findElement(By.xpath(Testelements.AdminReports_Distributor_Checkbox)).click();
	 
	 Thread.sleep(1000);
	 
	 driver.findElement(By.xpath(Testelements.AdminReports_Decorator_Checkbox)).click();
	 
	 Thread.sleep(2000);
	 
    //Press the download button
	 driver.findElement(By.xpath(Testelements.DownloadExcel_AdminReports)).click();
	 
	 //Wait
	 Thread.sleep(80000);
	 
	 File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 if(fileName.contains("ProductsMadeActive"))
	 {
		 System.out.println("Product Made Active File download sucessfully");
			test = extent.createTest("ProductMadeActiveDownload(EIT Admin)");
			
			test.log(Status.PASS, "Product Made Active File download sucessfully");	 
	 }
	 else{
		 System.out.println("Product Made Active File download unsucessfully");
			test = extent.createTest("ProductMadeActiveDownload(EIT Admin)");
			
			test.log(Status.FAIL, "Product Made Active File download unsucessfully"); 
	 }
	 
	 
	 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	  jse70.executeScript("window.scrollBy(0,-250)", "");
	  
	  JavascriptExecutor jse71 = (JavascriptExecutor)driver;
	    jse71.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(1000);
	 
  }catch(NoSuchElementException e){
	    	   e.getStackTrace();
	       }
	       
	       }
  
  
  

  
  

  
  @Test(priority=8)
  public void SGRSearch() throws InterruptedException{
	  
	  try{
		  driver.findElement(By.cssSelector(Testelements.Dist_ManageProducts)).click();
			
			Thread.sleep(4000);
		  
		  
		  //driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
	  
	  
	  
	//Send info into asi field
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("1502");
      //Click the search for supplier serach
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
      //Select the supplier through clicking
      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
	  
      waitForPageLoad();
  
     if(driver.findElement(By.xpath(Testelements.SGREITUser_SearchValidation)).getText().contains("1502"))
     {
    	System.out.println("SGR user Searched sucessfully");
    	 
    	 test = extent.createTest("SGRSearch");
 	  	
 	  	test.log(Status.PASS, "SGR user Searched sucessfully ");
     }
     else{
    	 System.out.println("SGR user Searched unsucessfully");
    	 
    	 test = extent.createTest("SGRSearch");
 	    
 	  	test.log(Status.FAIL, "SGR user Searched unsucessfully ");
     }
     
     	  
	  }catch(NoSuchElementException e){
		  e.getStackTrace();
		  
	  }
	  
	  
}
  
  
@Test(priority=9)
public void ZCodeReview() throws InterruptedException{
  
	 try{
		  driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
		  
		  
		  
		//Send info into asi field
	      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
	      //Click the search for supplier serach
	      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
	      //Wait for supplier selection option to appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
	      //Select the supplier through clicking
	      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
		  
	      waitForPageLoad1();
	  
        //Go to EIT Manager
	     driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
	     
	    Thread.sleep(1000);
	    
	    //Press the EIT Reports Tab
	    driver.findElement(By.xpath(Testelements.EITReports_Tab)).click();
	    
	    //Wait for few sec 
	    Thread.sleep(2000);
	     
	    WebElement mySelectElement3 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
	     Select dropdown3= new Select(mySelectElement3);
	    
	     dropdown3.selectByVisibleText("Z code Base Price");
	     
	     Thread.sleep(2000);
	     
	     //Check the boxes for report generation
	     driver.findElement(By.xpath(Testelements.EITReports_Zcodereview1)).click();
	     
	     
	     
	     driver.findElement(By.xpath(Testelements.EITReports_Zcodereview2)).click();
	     
	     
	     
	     driver.findElement(By.xpath(Testelements.EITReports_Download1)).click();
	     
	    
	    
	     Thread.sleep(20000);
	     
	     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
		 String fileName = getLatestFile.getName();
		 if(fileName.contains("ActiveZCodeBasePriceProducts"))
		 {
			 System.out.println("ZCodeReview download successfully");
			 
			 test = extent.createTest("ZCodeReviewDownload");
				
				test.log(Status.PASS, "ZCodeReview download successfully");	 
		 }
		 else{
			 System.out.println("ZCodeReview download unsuccessfully");
			 test = extent.createTest("ZCodeReviewDownload");
				
				test.log(Status.FAIL, "ZCodeReview download unsuccessfully");
		 }
	     
  
  }catch(NoSuchElementException e){
  e.getStackTrace();
  
}
  
} 

  @Test(priority=10)
  public void productmissingImagesReport() throws InterruptedException{
	  try{
	  WebElement mySelectElement4 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
	     Select dropdown4= new Select(mySelectElement4);
	    
	     dropdown4.selectByVisibleText("Suppliers with missing product Images");
	     
	     Thread.sleep(2000);
	     
	     //Check the boxes for report generation
	     driver.findElement(By.xpath(Testelements.EITReports_ProductwithouImages1)).click();
	     
	    
	     
	     driver.findElement(By.xpath(Testelements.EITReports_ProductwithouImages2)).click();
	     
	     
	     driver.findElement(By.xpath(Testelements.EITReports_ProductwithouImages3)).click();
	     
	     
	     
	     
	     driver.findElement(By.xpath(Testelements.EITReports_Download2)).click();
	     
	    // waitForPageLoad();
	    Thread.sleep(60000);
	     
	     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
		 String fileName = getLatestFile.getName();
		 
		 if(fileName.contains("SuppliersWithMissingImages")){
			 System.out.println("ProductsWithMissingImageReports is downloaded successfully");
			 
			 test = extent.createTest("ProductsWithMissingImageReports");
			 
			 test.log(Status.PASS, "ProductsWithMissingImageReports is downloaded successfully");
			   
		 }
		 else{
             System.out.println("ProductsWithMissingImageReports is downloaded unsuccessfully");
			 
			 test = extent.createTest("ProductsWithMissingImageReports");
			 
			 test.log(Status.FAIL, "ProductsWithMissingImageReports is downloaded unsuccessfully");
			   
		 }
	      
	   }catch(NoSuchElementException e){
	   e.getStackTrace();
	  
	 }
	   
	 } 

 @Test(priority=11)
 public void ProductsInreviewReport() throws InterruptedException{
	 try{
	 WebElement mySelectElement5 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown5= new Select(mySelectElement5);
    
     dropdown5.selectByVisibleText("Products in review by supplier");
     
     Thread.sleep(2000);
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_ProductsinReview1)).click();
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_ProductsinReview2)).click();
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_ProductsinReview3)).click();
     
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_Download3)).click();
     
     
     
    Thread.sleep(60000);
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("SuppliersWithProductsInReview")){
		 System.out.println("ProductsInreviewReports downloaded sucessfully");
		 
		 test = extent.createTest("ProductsInreviewReports");
		 	
		 test.log(Status.PASS, "ProductsInreviewReports downloaded sucessfully"); 
	 }
	 else{
          System.out.println("ProductsInreviewReports downloaded unsucessfully");
		 
		 test = extent.createTest("ProductsInreviewReports");
		 	
		 test.log(Status.FAIL, "ProductsInreviewReports downloaded unsucessfully"); 
	 }
         
   }catch(NoSuchElementException e){
   e.getStackTrace();
   
 }
   
 } 
 
 @Test(priority=12)
 public void ActiveCatalogReport() throws InterruptedException{
	 try{
	 WebElement mySelectElement6 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown6= new Select(mySelectElement6);
    
     dropdown6.selectByVisibleText("Active Catalog");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_Activecatalog1)).click();
     
    
     
     driver.findElement(By.xpath(Testelements.EITReports_Activecatalog2)).click();
     
     
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_Download4)).click();
     
     
     
     Thread.sleep(30000);
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("ActiveCatalog")){
		 System.out.println("ActiveCatalogReports downloaded sucessfully");
		 
		 test = extent.createTest("ActiveCatalogReports");
		 
		 test.log(Status.PASS, "ActiveCatalogReports downloaded sucessfully");
	 }
	 else{
		 
         System.out.println("ActiveCatalogReports downloaded unsucessfully");
		 
		 test = extent.createTest("ActiveCatalogReports");
		 
		 test.log(Status.FAIL, "ActiveCatalogReports downloaded unsucessfully");
	 }
      
   }catch(NoSuchElementException e){
   e.getStackTrace();
  
 }
   
 } 


 @Test(priority=13)
 public void ActiveSuppliersReport() throws InterruptedException{
	 try{
	 WebElement mySelectElement7 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown7= new Select(mySelectElement7);
    
     dropdown7.selectByVisibleText("Active Suppliers");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_ActiveSuppliers1)).click();
     
     
     driver.findElement(By.xpath(Testelements.EITReports_ActiveSuppliers2)).click();
     
     
     driver.findElement(By.xpath(Testelements.EITReports_Download5)).click();
     
    
     
     Thread.sleep(34000);
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("ActiveSuppliers")){
		 System.out.println("ActiveSuppliersReports downloaded sucessfully");
		 
		 test = extent.createTest("ActiveSuppliersReports");
		 	
		 test.log(Status.PASS, "ActiveSuppliersReports downloaded sucessfully");
		   
	 }
	 else{
		 
		 System.out.println("ActiveSuppliersReports downloaded unsucessfully");
		 test = extent.createTest("ActiveSuppliersReports");
		 	
		 test.log(Status.FAIL, "ActiveSuppliersReports downloaded unsucessfully");
		    
	 }
      
   }catch(NoSuchElementException e){
   e.getStackTrace();
  
 }
   
 } 
  
 @Test(priority=14)
 public void ActiveQURReports() throws InterruptedException{
	 try{
	 WebElement mySelectElement8 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown8= new Select(mySelectElement8);
    
     dropdown8.selectByVisibleText("Active QUR Products");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_ActiveQURReports1)).click();
     
   
     driver.findElement(By.xpath(Testelements.EITReports_ActiveQURReports2)).click();
     
    
     driver.findElement(By.xpath(Testelements.EITReports_Download6)).click();
     
     
     
     Thread.sleep(40000);
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("ActiveQURProducts")){
		 System.out.println("ActiveQURReports downloaded successfully");
		 
		 test = extent.createTest("ActiveQURReports");
		 
		 test.log(Status.PASS, "ActiveQURReports downloaded successfully");
	 }
	 else{
         System.out.println("ActiveQURReports downloaded unsuccessfully");
		 
		 test = extent.createTest("ActiveQURReports");
		 
		 test.log(Status.FAIL, "ActiveQURReports downloaded unsuccessfully"); 
	 }
       
   }catch(NoSuchElementException e){
   e.getStackTrace();
   
 }
   
 } 
  
  
 @Test(priority=15)
 public void OrphanReports() throws InterruptedException{
	 try{
	 WebElement mySelectElement9 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown9= new Select(mySelectElement9);
    
     dropdown9.selectByVisibleText("Orphan Products");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_OrphanReports1)).click();
     
     driver.findElement(By.xpath(Testelements.EITReports_OrphanReports2)).click();
     
     
     driver.findElement(By.xpath(Testelements.EITReports_Download7)).click();
   
    Thread.sleep(40000);
     
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("OrphanProducts")){
		System.out.println("OrphanReports downloaded sucessfull");
		 test = extent.createTest("OrphanReports");
		 	
		 test.log(Status.PASS, "OrphanReports downloaded sucessfully");
	 }
	 else{
		 
		 System.out.println("OrphanReports downloaded unsucessfull");
		 
		 test = extent.createTest("OrphanReports");
		 	
		 test.log(Status.FAIL, "OrphanReports downloaded unsucessfully");
	 }
     	
   
   }catch(NoSuchElementException e){
   e.getStackTrace();
  
 }
   
 } 
  
  
  
 @Test(priority=16)
 public void ConfirmAccurateReport() throws InterruptedException{
	 try{
	 WebElement mySelectElement6 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown6= new Select(mySelectElement6);
    
     dropdown6.selectByVisibleText("Confirmed Accurate Detail");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_ConfirmAccurate1)).click();
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_ConfirmAccurate2)).click();
     
      
     driver.findElement(By.xpath(Testelements.EITReports_Download8)).click();
     
     Thread.sleep(40000);
     
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("ConfirmedAccurateDetail")){
		 System.out.println("ConfirmAccurateDetailReports downloaded sucessfully");
		 
		 test = extent.createTest("ConfirmAccurateDetailReports");
		 
		 test.log(Status.PASS, "ConfirmAccurateDetailReports downloaded sucessfully");
	 }
	 else{
		 System.out.println("ConfirmAccurateDetailReports downloaded unsucessfully");
		 
		 test = extent.createTest("ConfirmAccurateDetailReports");
		 	
		 test.log(Status.FAIL, "ConfirmAccurateDetailReports downloaded sucessfully");
	 }
     
   
   }catch(NoSuchElementException e){
   e.getStackTrace();
   
 }
   
 } 
  
 @Test(priority=17)
 public void InactiveProductsReports() throws InterruptedException, AWTException{
	 try{
	 WebElement mySelectElement6 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown6= new Select(mySelectElement6);
    
     dropdown6.selectByVisibleText("Inactive Products");
     
     //Check the boxes for report generation
     driver.findElement(By.xpath(Testelements.EITReports_InactiveProduct_field)).sendKeys("30232");
     
     
     
     driver.findElement(By.xpath(Testelements.EITReports_InactiveProduct_field)).sendKeys(Keys.ENTER);
     
     
     driver.findElement(By.xpath(Testelements.EITReports_Download9)).click();
     
     waitForPageLoad1();
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("InActiveProducts")){
		 System.out.println("InactiveProductsReports downloaded sucessfully");
		 
		 test = extent.createTest("InactiveProductsReports");
		 	
		 test.log(Status.PASS, "InactiveProductsReports downloaded sucessfully"); 
	 }
	 else{
		 System.out.println("InactiveProductsReports downloaded unsucessfully");
		 
		 test = extent.createTest("InactiveProductsReports");
		 
		 test.log(Status.FAIL, "InactiveProductsReports downloaded unsucessfully"); 
	 }
     	
   }catch(NoSuchElementException e){
   e.getStackTrace();
   
 }
   
 } 
 
 @Test(priority=18)
 public void ExportImport_Buttons_Enable_SupplierCustomerLevel() throws InterruptedException{
	 try{
		 driver.findElement(By.xpath(Testelements.EITAdminTab)).click();
		 
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel)));
	      
	     Thread.sleep(2000);
	     
	     driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
	     
	     Thread.sleep(2000);
	     
	     WebElement mySelectElement = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
		 Select dropdown= new Select(mySelectElement);

		 dropdown.selectByVisibleText("Enable / Disable Import and Export");

		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EnableDisableImportExportButton_ASINo_Field)));
		 
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath(Testelements.EnableDisableImportExportButton_ASINo_Field)).sendKeys("30232");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath(Testelements.ShowOptions_button_ImportExportButton_ASI)).click();
		 
		 waitForPageLoad1();
		 
		 Thread.sleep(2000);
		 
		 if(!driver.findElement(By.xpath(Testelements.EnableProductImportCheckbox)).isSelected() & !driver.findElement(By.xpath(Testelements.EnableProductExportCheckbox)).isSelected())
		 {
			 driver.findElement(By.xpath(Testelements.EnableProductImportCheckbox)).click();
			 
			 driver.findElement(By.xpath(Testelements.EnableProductExportCheckbox)).click();
		
			 driver.findElement(By.xpath(Testelements.ApplyButton_ImportExportButtons_Settings)).click();
			 
			 waitForPageLoad1();
			 
			 Thread.sleep(2000);
		 }
		
		 driver.findElement(By.xpath(Testelements.EITMember_Logout_Toggledropdown)).click();
		 
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath(Testelements.Logoff_EITMember)).click();
		 
		 Thread.sleep(3000);
		 
		 if(driver.getCurrentUrl().contains("stage")){
		        //Insert ASI Number
		        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberStage_Cust);
		        
		        //Insert the username
		        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameStage_Cust);
		        
		        //Insert the Password
		        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordStage_Cust);
		        
		        }
		        else if(driver.getCurrentUrl().contains("uat")){
		        	
		        	//Insert ASI Number
		            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberUAT_Cust);
		            
		            //Insert the username
		            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameUAT_Cust);
		            
		            //Insert the Password
		            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordUAT_Cust);
		        }
		        
		        else{
		        	
		        	//Insert ASI Number
		            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberProd_Cust);
		            
		            //Insert the username
		            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameProd_Cust);
		            
		            //Insert the Password
		            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordProd_Cust);
		        }
		  //Press the login Button
		    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
		    
		    wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)));

		    Thread.sleep(2000);
		    
		    
		    
		    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)).isDisplayed()){
		    System.out.println("Supplier Loggedin Successfully");
		    
		    }
		    else{
		    	 System.out.println("Supplier Loggedin UnSuccessfully");
		    	
		    }
		 
		    driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
	     
		    wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ExportButton_ManageProducts)));
		    
		    Thread.sleep(2000);
		    
		    if(driver.findElement(By.xpath(Testelements.ExportButton_ManageProducts)).isDisplayed() & driver.findElement(By.xpath(Testelements.ImportButton_ManageProducts)).isDisplayed())
		    {
		    	System.out.println("Export and Import Button Display to Supplier Customer after Enabling it from EIT User Successfully");
		    	
		    	 test = extent.createTest("ExportImport_Buttons_Enable_SupplierCustomerLevel");
				 
				 test.log(Status.PASS, "Export and Import Button Display to Supplier Customer after Enabling it from EIT User Successfully");
		    }
		    else{
		    	System.out.println("Export and Import Button Display to Supplier Customer after Enabling it from EIT User UnSuccessfully");
		    	
		    	 test = extent.createTest("ExportImport_Buttons_Enable_SupplierCustomerLevel");
				 
				 test.log(Status.FAIL, "Export and Import Button Display to Supplier Customer after Enabling it from EIT User UnSuccessfully");
		    }
		 
		 
	 }catch(NoSuchElementException e){
		 e.getMessage();
	 }
 }
 
 @Test(priority=19)
 public void ExportImport_Buttons_Disable_SupplierCustomerLevel() throws InterruptedException{
	 try{
		 driver.findElement(By.xpath(Testelements.MyAccount_MenuBar)).click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.Logout_MyAccount)).click();
		    
		    Thread.sleep(5000);
		    
		    if(driver.getCurrentUrl().contains("stage")){
		        //Insert ASI Number
		        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberStage);
		        
		        //Insert the username
		        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameStage);
		        
		        //Insert the Password
		        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordStage);
		        }
		        else if(driver.getCurrentUrl().contains("uat")){
		        	
		        	//Insert ASI Number
		            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberUAT);
		            
		            //Insert the username
		            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameUAT);
		            
		            //Insert the Password
		            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordUAT);	
		        }
		        
		        else{
		        	
		        	//Insert ASI Number
		            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vEASINumberProd);
		            
		            //Insert the username
		            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vEUserNameProd);
		            
		            //Insert the Password
		            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vEPasswordProd);	
		        }
		        
		    //Press the login Button
		    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
		    
		    wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation)));

		    Thread.sleep(2000);
		    
		    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation)).isDisplayed()){
		    System.out.println("Login Successfull");
		   
		    }
		    else{
		    	 System.out.println("Login UnSuccessfull");
		    	    
		    }
		    //Go to Admin Tab
			wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));

		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
		    
		    wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel)));

		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
		    
		    WebElement mySelectElement = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
			 Select dropdown= new Select(mySelectElement);

			 dropdown.selectByVisibleText("Enable / Disable Import and Export");

			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EnableDisableImportExportButton_ASINo_Field)));
			 
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(Testelements.EnableDisableImportExportButton_ASINo_Field)).sendKeys("30232");
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(Testelements.ShowOptions_button_ImportExportButton_ASI)).click();
			 
			 waitForPageLoad1();
			 
			 Thread.sleep(2000);
			 
			 if(driver.findElement(By.xpath(Testelements.EnableProductImportCheckbox)).isSelected() & driver.findElement(By.xpath(Testelements.EnableProductExportCheckbox)).isSelected())
			 {
				 driver.findElement(By.xpath(Testelements.EnableProductImportCheckbox)).click();
				 
				 driver.findElement(By.xpath(Testelements.EnableProductExportCheckbox)).click();
			
				 driver.findElement(By.xpath(Testelements.ApplyButton_ImportExportButtons_Settings)).click();
				 
				 waitForPageLoad1();
				 
				 Thread.sleep(2000);
			 }
			
			 driver.findElement(By.xpath(Testelements.EITMember_Logout_Toggledropdown)).click();
			 
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath(Testelements.Logoff_EITMember)).click();
			 
			 Thread.sleep(3000);
			 
			 if(driver.getCurrentUrl().contains("stage")){
			        //Insert ASI Number
			        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberStage_Cust);
			        
			        //Insert the username
			        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameStage_Cust);
			        
			        //Insert the Password
			        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordStage_Cust);
			        
			        }
			        else if(driver.getCurrentUrl().contains("uat")){
			        	
			        	//Insert ASI Number
			            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberUAT_Cust);
			            
			            //Insert the username
			            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameUAT_Cust);
			            
			            //Insert the Password
			            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordUAT_Cust);
			        }
			        
			        else{
			        	
			        	//Insert ASI Number
			            driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberProd_Cust);
			            
			            //Insert the username
			            driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameProd_Cust);
			            
			            //Insert the Password
			            driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordProd_Cust);
			        }
			  //Press the login Button
			    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
			    
			    wait = new WebDriverWait(driver, 120);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)));

			    Thread.sleep(2000);
			    
			    
			    
			    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)).isDisplayed()){
			    System.out.println("Supplier Loggedin Successfully");
			    
			    }
			    else{
			    	 System.out.println("Supplier Loggedin UnSuccessfully");
			    	
			    }
			 
			    driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
		     
			    wait = new WebDriverWait(driver, 120);
			    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Search_ManageProducts)));
			    
			    Thread.sleep(2000);
			    
			    List<WebElement> ExportButton_CustomerSupplier=driver.findElements(By.xpath(Testelements.ExportButton_ManageProducts));
			    
			    int ExportButton_Size=ExportButton_CustomerSupplier.size();
			    
			    System.out.println("The Size Of Export Button is:"+""+ExportButton_Size);
			    
                List<WebElement> ImportButton_CustomerSupplier=driver.findElements(By.xpath(Testelements.ExportButton_ManageProducts));
			    
			    int ImportButton_Size=ImportButton_CustomerSupplier.size();
			    
			    System.out.println("The Size Of Import Button is:"+""+ImportButton_Size);
			    
			    
			    if(ExportButton_Size==0 & ImportButton_Size==0)
			    {
			    	System.out.println("Export and Import Button not Display to Supplier Customer after Disabling it from EIT User Successfully");
			    	
			    	 test = extent.createTest("ExportImport_Buttons_Disable_SupplierCustomerLevel");
					 
					 test.log(Status.PASS, "Export and Import Button not Display to Supplier Customer after Disabling it from EIT User Successfully");
			    }
			    else{
			    	System.out.println("Export and Import Button not Display to Supplier Customer after Disabling it from EIT User UnSuccessfully");
			    	
			    	 test = extent.createTest("ExportImport_Buttons_Disable_SupplierCustomerLevel");
					 
					 test.log(Status.FAIL, "Export and Import Button not Display to Supplier Customer after Disabling it from EIT User UnSuccessfully");
			    }
			 
		 
		 
	 }catch(NoSuchElementException e){
		 e.getMessage();
	 }
 }
 

 public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath) {
	    if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

	        return "Wrong usage of WaitforElementNotVisible()";
	    }
	    try {
	        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
	                .xpath(elementXPath)));
	        return null;
	    } catch (TimeoutException e) {
	        return "Build your own errormessage...";
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
 public static void waitForPageLoad1() throws InterruptedException {
		
	   Thread.sleep(2000);	
	 
	   wait = new WebDriverWait(driver, 120);
	       
	    pageLoaded = new Predicate<WebDriver>() {

	        public boolean apply(WebDriver input) {
	            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
	        }

	    };
	   
	   System.out.println("Page Loaded Successfully");  
     Thread.sleep(2000);
     if( driver.findElement(By.xpath("//div[contains(@id,'busyindicator')]")).isDisplayed()){
		  
  	   waitForPageLoad1();
	   }


}
 
 public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
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


