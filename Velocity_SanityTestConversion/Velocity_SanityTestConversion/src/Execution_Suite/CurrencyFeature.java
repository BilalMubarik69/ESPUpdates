package Execution_Suite;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.interactions.Actions;


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



public class CurrencyFeature {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	String Parentwindow;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	
	//Pricing variables
	 public static WebElement ListPriceValue_Grid1;
	 public static String ListPriceValueVerification_Grid1;
	 public static WebElement ListPriceValue_Grid2;
	 public static String ListPriceValueVerification_Grid2;
	 public static WebElement NetCost_Grid1;
	 public static String NetCostVerification_Grid1;
	 public static WebElement NetCost_Grid2;
	 public static String NetCostVerification_Grid2;
	 
	 public static double ListPrice;
	 public static NumberFormat ListPriceFormat;
	 public static Number ListPriceNumber;
	 public static double NetCost;
	 public static NumberFormat NetCostFormat;
	 public static Number NetCostNumber;
	 public static double a;
	 public static double b;
	 public static BigDecimal bd;
	 public static BigDecimal bd2;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/CurrencyFeature"+".html");
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
		 else if(browser.equalsIgnoreCase("chrome")) {
				
			    WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/CurrencyFeature"+".html");
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
	   			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/CurrencyFeature"+".html");
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
		driver.manage().window().maximize();
		
		}
	
  @Test(priority=0)
  public void login() throws InterruptedException {
    try{
    			 
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
    
    Thread.sleep(1000);
   
    
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
  public void SupplierSearch() throws InterruptedException{
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
      //Select the supplier through clicking
      Thread.sleep(1000);
      
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
      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
      	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
  }
  
  }

@Test(priority=2)
 public void AddUpdate_Product_MultiplePriceGrid() throws InterruptedException{
  	try{
  	
  		//Click the manage product tab
  	  	driver.findElement(By.xpath(Testelements.Manage_Product_Tab)).click();
  		
  		wait = new WebDriverWait(driver, 120);
  	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProduct_button)));
  	    
  	    Thread.sleep(3000);
      
    //First store parent window to switch back
    String parentWindow = driver.getWindowHandle();

      
      driver.findElement(By.cssSelector(Testelements.AddProduct_button)).click();
  
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
  //	driver.findElement(By.cssSelector(Testelements.Product_type)).click();
  	
  	driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
     
     Thread.sleep(1000);
  	
  	
  	//Creating a robot instance to select option in 2nd place in dropdown
  	WebElement mySelectElement21 = driver.findElement(By.xpath(Testelements.ProductType));
   Select dropdown21= new Select(mySelectElement21);
  
   dropdown21.selectByVisibleText("Automotive Accessories");
  
      
   Thread.sleep(1000);
   
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
      
      //Thread.sleep(40000);
		
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
      try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //Select the pricing tab for SPG
    
      driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
    
     // Wait for attributes to appear
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
      
      try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
      JavascriptExecutor jse900 = (JavascriptExecutor)driver;
      jse900.executeScript("window.scrollBy(0,-250)", "");
		
      JavascriptExecutor jse901 = (JavascriptExecutor)driver;
      jse901.executeScript("window.scrollBy(-250,-500)", "");
      
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
      
      //Select the 2nd attribute
     driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
      
     
	 
	 
	      JavascriptExecutor jse9001 = (JavascriptExecutor)driver;
       jse9001.executeScript("window.scrollBy(0,-250)", "");
		
       JavascriptExecutor jse9011 = (JavascriptExecutor)driver;
       jse9011.executeScript("window.scrollBy(-250,-500)", "");
       
       Thread.sleep(1000);
      
       //Scroll down to the pricing options
      
      //Scroll down
      JavascriptExecutor jse600 = (JavascriptExecutor)driver;
      jse600.executeScript("window.scrollBy(0,250)", "");
      
      //Scroll down
      JavascriptExecutor jse1 = (JavascriptExecutor)driver;
      jse1.executeScript("window.scrollBy(0,250)", "");
      
      
		 Thread.sleep(1000);
		
      
    //First store parent window to switch back
	     String parentWindow10 = driver.getWindowHandle(); 
      
      //Press the custom option
      driver.findElement(By.xpath(Testelements.MPGOptions)).click();
      
      
		 Thread.sleep(1000);
	
      driver.findElement(By.xpath(Testelements.Orderingoption_alert_Yes)).click();
      
      try {
		Thread.sleep(2000);
	} catch (InterruptedException e6) {
		// TODO Auto-generated catch block
		e6.printStackTrace();
	}
      
      //Switch to new window opened
  	for(String winHandle : driver.getWindowHandles()){
  	    if(!winHandle.equals(parentWindow10)) {
  	        driver.switchTo().window(winHandle);
  	    }
  	}
      
  	waitForPageLoad();
  	//Thread.sleep(6000);
		
      
      //Insert the options name
      driver.findElement(By.xpath(Testelements.OptionName)).sendKeys("Product 1");
      
      //Insert product value
      driver.findElement(By.xpath(Testelements.OptionValue)).sendKeys("3");
      
      //Press enter
      //Selection from dropdown
      driver.findElement(By.xpath(Testelements.OptionValue)).sendKeys(Keys.ENTER);
      
      Thread.sleep(2000);
		
      //Apply and add
      
     driver.findElement(By.xpath(Testelements.ApplyAddButton)).click();
      
     Thread.sleep(2000);
		
     //Add once again
    //Insert the options name
      driver.findElement(By.xpath(Testelements.OptionName)).sendKeys("Product 2");
      
      //Insert product value
      driver.findElement(By.xpath(Testelements.OptionValue)).sendKeys("2");
      
      //Press enter
      //Selection from dropdown
      driver.findElement(By.xpath(Testelements.OptionValue)).sendKeys(Keys.ENTER);
      
      
      
    	Thread.sleep(2000);
		
      
      driver.findElement(By.xpath(Testelements.Apply)).click();
      
      Thread.sleep(4000);
		
      
    //Goto imprinting tab and select imprinting
      driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
      
      waitForPageLoad();
      
      //Thread.sleep(18000);
      
     //Select an option
      
      WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.ImprintingMethodSelection));
      Select dropdown70= new Select(mySelectElement70);
     
      dropdown70.selectByVisibleText("Silkscreen");
      
      Thread.sleep(1000);
      
      WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click();", element);
     
      waitForPageLoad();
      //Thread.sleep(12000);
       
      //Switch back to parent window 
      driver.switchTo().window(parentWindow10);
      
      //Open the pricing tab
      driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
      
     
      waitForPageLoad();
      //Thread.sleep(10000);
	
	    
	//First store parent window to switch back
	     String parentWindow16 = driver.getWindowHandle(); 
  	
  	driver.findElement(By.xpath(Testelements.MultipleGridRadio)).click();
  	
  	//Switch to new window opened
  	for(String winHandle : driver.getWindowHandles()){
  	    if(!winHandle.equals(parentWindow16)) {
  	        driver.switchTo().window(winHandle);
  	    }
  	}
      
  	
		Thread.sleep(7000);
		
  	driver.findElement(By.xpath(Testelements.MultipleGridSetup_Color)).click();
  	
		Thread.sleep(2000);
		
  	driver.findElement(By.xpath(Testelements.MultipleGridSetup_option)).click();
  	
  	driver.findElement(By.xpath(Testelements.MultipleGridSetup_Next)).click();
  	
		Thread.sleep(2000);
		
	   driver.findElement(By.xpath(Testelements.MultipleGridcriteria_White)).click();
	    
  	Thread.sleep(2000);
		
	   driver.findElement(By.xpath(Testelements.SaveandAdd)).click();
	  
	  
	 waitForPageLoad();
	   //Thread.sleep(15000);
	
	  driver.findElement(By.xpath(Testelements.MultipleGridcriteria_Blue)).click();
	 
	  Thread.sleep(2000);
	
	  driver.findElement(By.xpath(Testelements.SaveConfig)).click();
	  
	 
	//Switch back to parent window 
   driver.switchTo().window(parentWindow16);
	  
   waitForPageLoad();
   
   Thread.sleep(5000);
   
   //Add the Aus and Canadian Currency grids to Existing grids
   driver.findElement(By.xpath(Testelements.CurrencyMenu_Pricing_ProductLevel)).click();
   
   Thread.sleep(1000);
   
   driver.findElement(By.xpath(Testelements.Aus_CurrencySelection__Pricing_ProductLevel)).click();
   
    driver.findElement(By.xpath(Testelements.CurrencyMenu_Pricing_ProductLevel)).click();
   
   Thread.sleep(1000);
   
   driver.findElement(By.xpath(Testelements.Can_CurrencySelection__Pricing_ProductLevel)).click();
   
   
   
   //Thread.sleep(11000);
	
   driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	
	  Thread.sleep(2000);
	
	   WebElement HoverEdit=driver.findElement(By.xpath(Testelements.HoverBasePriceField));
	   Hover(HoverEdit);
	   
	   Thread.sleep(2000);
	   
	   if(driver.findElement(By.xpath(Testelements.Pricegrid_HoverToolTip)).isDisplayed())
	   {
		   System.out.println("ToolTip Displayed Successfully on BasePrice and Upcharge Price Field");
		   
		     test = extent.createTest("ToolTip_Verification_PricingField");
       
      	test.log(Status.PASS, "ToolTip Displayed Successfully on BasePrice and Upcharge Price Field");
	   }
	   else{
		  System.out.println("ToolTip Displayed UnSuccessfully on BasePrice and Upcharge Price Field");
		   
		   test = extent.createTest("ToolTip_Verification_PricingField");
    
   	  test.log(Status.FAIL, "ToolTip Displayed UnSuccessfully on BasePrice and Upcharge Price Field");
	   }
	  
	  
	  //Enter the Product no for White
	  driver.findElement(By.cssSelector(Testelements.ProductNo_White)).sendKeys(Testdata.Productnumber1);
	  
	  Thread.sleep(2000);
	//Enter details into fields
	driver.findElement(By.xpath(Testelements.MG_Quantity1)).sendKeys("1");
	
	Thread.sleep(2000);
	
	 //Scroll up
 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
 jse1102.executeScript("window.scrollBy(0,-250)", "");
 
//Scroll up
 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
 jse1113.executeScript("window.scrollBy(-250,-500)", "");
 
 Thread.sleep(2000);
	
	driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	
	Thread.sleep(2000);
	
    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath(Testelements.MG_ListPrice1)).sendKeys("10");
	
	//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();
	
	 WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.MGP_PriceCode1));
Select dropdown72= new Select(mySelectElement72);

dropdown72.selectByVisibleText("L 70%");

 Thread.sleep(2000);
		
 
 driver.findElement(By.xpath(Testelements.Aus_CurrencyListPrice_Grid1)).sendKeys("11");
	
	//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();
	
	 WebElement mySelectElement723 = driver.findElement(By.xpath(Testelements.Aus_CurrencyPriceCode_Grid1));
Select dropdown723= new Select(mySelectElement723);

dropdown723.selectByVisibleText("L 70%");

Thread.sleep(2000);

driver.findElement(By.xpath(Testelements.Can_CurrencyListPrice_Grid1)).sendKeys("12");

//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();

 WebElement mySelectElement729 = driver.findElement(By.xpath(Testelements.Can_CurrencyPriceCode_Grid1));
Select dropdown729= new Select(mySelectElement729);

dropdown729.selectByVisibleText("L 70%");

Thread.sleep(2000);
 
 //Enter details into 2nd grid
  	
driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
  
Thread.sleep(2000);
	
  //Enter the Product number for 2nd
 driver.findElement(By.cssSelector(Testelements.ProductNo_Blue)).sendKeys(Testdata.Productnumber2);
  
  Thread.sleep(2000);
  
  
  
  
  
//Enter details into fields
  driver.findElement(By.xpath(Testelements.MG_Quantity2)).sendKeys("2");

	
	Thread.sleep(2000);
	
//Scroll up
 JavascriptExecutor jse1100 = (JavascriptExecutor)driver;
 jse1100.executeScript("window.scrollBy(0,-250)", "");
 
//Scroll up
 JavascriptExecutor jse1110 = (JavascriptExecutor)driver;
 jse1110.executeScript("window.scrollBy(-250,-500)", "");
 
 Thread.sleep(2000);
	
	 driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	 
	 Thread.sleep(2000);
	 
     driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	 
	 Thread.sleep(2000);
	
	driver.findElement(By.xpath(Testelements.MG_ListPrice2)).sendKeys("10");
	
	 WebElement mySelectElement100 = driver.findElement(By.xpath(Testelements.MGP_PriceCode2));
	    Select dropdown100= new Select(mySelectElement100);
	   
	    dropdown100.selectByVisibleText("L 70%");

	  	Thread.sleep(2000);
	  	
	  	driver.findElement(By.xpath(Testelements.Aus_CurrencyListPrice_Grid2)).sendKeys("11");
		
		 WebElement mySelectElement1000 = driver.findElement(By.xpath(Testelements.Aus_CurrencyPriceCode_Grid2));
		    Select dropdown1000= new Select(mySelectElement1000);
		   
		    dropdown1000.selectByVisibleText("L 70%");

		  	Thread.sleep(2000);
		  	
		  	
		  	driver.findElement(By.xpath(Testelements.Can_CurrencyListPrice_Grid2)).sendKeys("12");
			
			 WebElement mySelectElement1001 = driver.findElement(By.xpath(Testelements.Can_CurrencyPriceCode_Grid2));
			    Select dropdown1001= new Select(mySelectElement1001);
			   
			    dropdown1001.selectByVisibleText("L 70%");

			  	Thread.sleep(2000);
	  	
//Scroll up
 JavascriptExecutor jse110 = (JavascriptExecutor)driver;
 jse110.executeScript("window.scrollBy(0,-250)", "");
 
//Scroll up
 JavascriptExecutor jse111 = (JavascriptExecutor)driver;
 jse111.executeScript("window.scrollBy(-250,-500)", "");
 
//Scroll up
JavascriptExecutor jse112 = (JavascriptExecutor)driver;
jse112.executeScript("window.scrollBy(-500,-750)", "");

//Scroll up
JavascriptExecutor jse113 = (JavascriptExecutor)driver;
jse113.executeScript("window.scrollBy(-750,-1000)", "");

//Scroll up
JavascriptExecutor jse114 = (JavascriptExecutor)driver;
jse114.executeScript("window.scrollBy(-1000,-1250)", "");

//Move to upcharges section
 
 
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
	
	
	Thread.sleep(2000);
	
	
	//First store parent window to switch back
 String parentWindow17 = driver.getWindowHandle();
	//Press the add Upcharge Button
	driver.findElement(By.xpath(Testelements.AddUpcharge_Button)).click();
	
	
	Thread.sleep(3000);
	
	//Switch to new window opened
	for(String winHandle : driver.getWindowHandles()){
	    if(!winHandle.equals(parentWindow17)) {
	        driver.switchTo().window(winHandle);
	    }
	}
	
	
	
	//Press the product color checkbox
	driver.findElement(By.xpath(Testelements.Upcharge_ProductColor)).click();
	

	Thread.sleep(2000);
	
	//Press the next step button
	driver.findElement(By.xpath(Testelements.UpchargeSetup_NextButton)).click();
	
	
	Thread.sleep(2000);
	
	
	//Press the indivdual grid checkbox
	driver.findElement(By.xpath(Testelements.IndividualGrid_Checkbox)).click();
	
	
	Thread.sleep(2000);
	
	//Press the colors checkboxes
	driver.findElement(By.xpath(Testelements.UpchargeColorWhite)).click();
	

	Thread.sleep(2000);
	
 driver.findElement(By.xpath(Testelements.UpchargeColorBlue)).click();
	
	
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath(Testelements.UpchargeApplyButton)).click();
	
	waitForPageLoad();	
	
	Thread.sleep(3000);
	
	//Scroll up
	 JavascriptExecutor jse1104 = (JavascriptExecutor)driver;
	 jse1104.executeScript("window.scrollBy(0,-250)", "");
	 
	//Scroll up
	 JavascriptExecutor jse1112 = (JavascriptExecutor)driver;
	 jse1112.executeScript("window.scrollBy(-250,-500)", "");
	
	 Thread.sleep(2000);
	
	//Switch back to parent window 
 driver.switchTo().window(parentWindow17);
	  
	
	
 
 //Expand the first grid
	driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
	
	//Enter details into fields
    List<WebElement> QuantityUpcharge1 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
    QuantityUpcharge1.get(20).sendKeys("2");

 	
 	Thread.sleep(2000);
//Us Currency(Grid 1)	
List<WebElement> PriceUpcharge1=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	PriceUpcharge1.get(60).sendKeys("10");
 
List<WebElement> mySelectElement92 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
Select dropdown79= new Select(mySelectElement92.get(63));

 dropdown79.selectByVisibleText("L 70%");
 
 Thread.sleep(4000);
 
 //Aus Currency (Grid 1)
 List<WebElement> PriceUpcharge2=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
 PriceUpcharge2.get(70).sendKeys("11");

List<WebElement> mySelectElement95 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
Select dropdown95= new Select(mySelectElement95.get(73));

dropdown95.selectByVisibleText("L 70%");

Thread.sleep(4000);

//Canadian Currency(Grid 1)

List<WebElement> PriceUpcharge3=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
PriceUpcharge3.get(80).sendKeys("12");

List<WebElement> mySelectElement96 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
Select dropdown96= new Select(mySelectElement96.get(83));

dropdown96.selectByVisibleText("L 70%");

Thread.sleep(4000);
	
 //Scroll up
 JavascriptExecutor jse200 = (JavascriptExecutor)driver;
 jse200.executeScript("window.scrollBy(0,-250)", "");

 //Scroll up
 JavascriptExecutor jse201 = (JavascriptExecutor)driver;
 jse201.executeScript("window.scrollBy(-250,-500)", "");
 
 //Press the save button
 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
 
 
 waitForPageLoad();
 //Thread.sleep(25000);
 Thread.sleep(3000);
 
//Scroll up
JavascriptExecutor jse2000 = (JavascriptExecutor)driver;
jse2000.executeScript("window.scrollBy(0,-250)", "");

//Scroll up
JavascriptExecutor jse2010 = (JavascriptExecutor)driver;
jse2010.executeScript("window.scrollBy(-250,-500)", "");

Thread.sleep(1000);

waitForPageLoad();
//Thread.sleep(25000);
Thread.sleep(3000);

//Expand the first grid again to validate the net cost which is equal to 16
	driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
	
	Thread.sleep(3000);
	
//Expand the grid
	//Scroll down
 JavascriptExecutor jse100 = (JavascriptExecutor)driver;
 jse100.executeScript("window.scrollBy(0,250)", "");
 
//Scroll down
 JavascriptExecutor jse101 = (JavascriptExecutor)driver;
 jse101.executeScript("window.scrollBy(0,250)", "");
 
 //Expand the first grid
	driver.findElement(By.xpath(Testelements.UpchargeGrid2_Expand)).click();
	
   
	Thread.sleep(2000);
	
	
	
   //Enter quantity
	 //Enter details into fields
 List<WebElement> QuantityUpcharge2 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Quantity));
 QuantityUpcharge2.get(30).sendKeys("2");

	
	Thread.sleep(2000);
	
//Us Currency(Grid 2)	
	List<WebElement> PriceUpcharge4=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
	PriceUpcharge4.get(90).sendKeys("10");

List<WebElement> mySelectElement93 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Pricecodes));
Select dropdown93= new Select(mySelectElement93.get(93));

dropdown93.selectByVisibleText("L 70%");

Thread.sleep(2000);

List<WebElement> PriceUpcharge5=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
PriceUpcharge5.get(100).sendKeys("11");

List<WebElement> mySelectElement931 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Pricecodes));
Select dropdown931= new Select(mySelectElement931.get(103));

dropdown931.selectByVisibleText("L 70%");

Thread.sleep(2000);

List<WebElement> PriceUpcharge6=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
PriceUpcharge6.get(110).sendKeys("12");

List<WebElement> mySelectElement932 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Pricecodes));
Select dropdown932= new Select(mySelectElement932.get(113));

dropdown932.selectByVisibleText("L 70%");

Thread.sleep(2000);
	 	
	//Move to Images tab
	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
	
	Thread.sleep(1000);
	
	if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).isDisplayed()){
		test = extent.createTest("AddingUpchargesIntoProduct");
    
     test.log(Status.PASS, "Adding Upcharges to Multiple Values when user checks the Create individual grids for each value checkbox is successfull");
	
	}
	else{
		
		test = extent.createTest("AddingUpchargesIntoProduct");
     
     test.log(Status.FAIL, "Adding Upcharges to Multiple Values when user checks the Create individual grids for each value checkbox is unsuccessfull");
	}
	
	//Scroll down
 JavascriptExecutor jse1008 = (JavascriptExecutor)driver;
 jse1008.executeScript("window.scrollBy(0,-250)", "");
 
//Scroll down
 JavascriptExecutor jse1010 = (JavascriptExecutor)driver;
 jse1010.executeScript("window.scrollBy(-250,-500)", "");
	
Thread.sleep(2000);	
	
	//Wait for the button to appear
	 wait = new WebDriverWait(driver, 180);
  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
     
  
  
  //First store parent window to switch back
  String parentWindow2 = driver.getWindowHandle(); 
  
  Thread.sleep(3000);

  
  //Press the medialibrary button select image
  driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
  
//Switch to new window opened
 	for(String winHandle : driver.getWindowHandles()){
 	    if(!winHandle.equals(parentWindow2)) {
 	        driver.switchTo().window(winHandle);
 	    }
 	}
     
 	waitForPageLoad();
 	
 	
 	
 	//Thread.sleep(12000);

   //Select the 1st image from Library to upload
  driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
  
  //Scroll down
  JavascriptExecutor jse70 = (JavascriptExecutor)driver;
  jse70.executeScript("window.scrollBy(0,250)", "");
	
  
	 Thread.sleep(2000);

 //Confirm the images uploading details
  driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
  
 //Switch back to parent window 
     driver.switchTo().window(parentWindow2);
     
     waitForPageLoad();
     
     Thread.sleep(3000);
     
//Scroll Up
     JavascriptExecutor jse72 = (JavascriptExecutor)driver;
     jse72.executeScript("window.scrollBy(0,-250)", "");
     
     Thread.sleep(3000);


driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();

//Switch to new window opened
 	for(String winHandle : driver.getWindowHandles()){
 	    if(!winHandle.equals(parentWindow2)) {
 	        driver.switchTo().window(winHandle);
 	    }
 	}
     
 	waitForPageLoad();
 	
 	Thread.sleep(2000);
 	
 	// Thread.sleep(12000);
	
//Select the 1st image from Library to upload
driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
//Scroll Down
JavascriptExecutor jse71 = (JavascriptExecutor)driver;
jse71.executeScript("window.scrollBy(0,250)", "");
	
Thread.sleep(2000);

//Confirm the images uploading details
driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();


//Switch back to parent window 
   driver.switchTo().window(parentWindow2);
   
   waitForPageLoad();
   
   Thread.sleep(3000);
   
	//Scroll Up
   JavascriptExecutor jse = (JavascriptExecutor)driver;
   jse.executeScript("window.scrollBy(0,-250)", "");
   
	//Scroll Up
   JavascriptExecutor jse30 = (JavascriptExecutor)driver;
   jse30.executeScript("window.scrollBy(-250,-500)", "");
   
 //Scroll Up
   JavascriptExecutor jse31 = (JavascriptExecutor)driver;
   jse31.executeScript("window.scrollBy(-500,-750)", "");
  
   Thread.sleep(2000);
   
   //Press the save Button
   driver.findElement(By.xpath(Testelements.SaveButton_MediaLibrary)).click();

   
   waitForPageLoad();
   
   Thread.sleep(3000);
   //Thread.sleep(12000);
	
//Drag the 2nd placed Image to first and then drop it 
  Actions act=new Actions(driver);
	    //1st Media tagging  
	   // find element which we need to drag
	   WebElement drag=driver.findElement(By.cssSelector("#image-import-container > ul > li:nth-child(2) > div.row-fluid > div.span2 > div.pull-left.marginR10 > i"));
	    
	    // find element which we need to drop
	   WebElement drop=driver.findElement(By.cssSelector("#image-import-container > ul > li:nth-child(1) > div:nth-child(2) > strong"));
	    
	   // this will drag element to destination
	   act.dragAndDrop(drag, drop).build().perform();
	    
	   Thread.sleep(3000);
    
	 //Scroll Up
	      JavascriptExecutor jse32 = (JavascriptExecutor)driver;
	      jse32.executeScript("window.scrollBy(0,-250)", "");
	   
	      Thread.sleep(1000);
	   
	  
//Go to sku inventory
driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();


waitForPageLoad();

Thread.sleep(3000);

driver.findElement(By.xpath(Testelements.SKUInv_Sel1)).click();
 
 Thread.sleep(2000);
 
 driver.findElement(By.xpath(Testelements.SKUInv_Sel1)).click();
 
 Thread.sleep(2000);
 
WebElement mySelectElement3 = driver.findElement(By.xpath(Testelements.SKUInv_Sel1));
Select dropdown41= new Select(mySelectElement3);


dropdown41.selectByVisibleText("Product Option: Product 1");

driver.findElement(By.xpath(Testelements.SKUInv_Sel2)).click();

Thread.sleep(2000);

driver.findElement(By.xpath(Testelements.SKUInv_Sel2)).click();

Thread.sleep(2000);

WebElement mySelectElement4 = driver.findElement(By.xpath(Testelements.SKUInv_Sel2));
Select dropdown4= new Select(mySelectElement4);

dropdown4.selectByVisibleText("Product Option: Product 2"); 	
  	

	Thread.sleep(2000);


driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();


	Thread.sleep(2000);
		
 driver.findElement(By.xpath(Testelements.SKUQuantityReq)).sendKeys("3");
 

	Thread.sleep(2000);
	
  	//Move to availability tab
driver.findElement(By.xpath(Testelements.Availability_Tab)).click();


waitForPageLoad();

Thread.sleep(2000);

//Thread.sleep(13000);

 driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).click();
 

	Thread.sleep(1000);
	
 driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).click();
 
 Thread.sleep(1000);

 driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).sendKeys(Keys.DOWN);
 
 
	Thread.sleep(5000);
	

driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).click();


Thread.sleep(1000);
	

driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).click();

Thread.sleep(1000);


driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).sendKeys(Keys.DOWN);


	Thread.sleep(1000);
	

driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).sendKeys(Keys.DOWN);


	Thread.sleep(3000);
	

driver.findElement(By.xpath(Testelements.Availability_showbutton)).click();	
  	
  	
	Thread.sleep(4000);
		
  	
   //Goto Summary Tab
	 driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	        
	   //Wait for some time
	waitForPageLoad();
	 
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
     
     Thread.sleep(8000);
	
     if(driver.findElement(By.xpath(Testelements.ProductActiveValidation)).isDisplayed()){
     	  System.out.println("Multiple Grid Product add and update Sucessfully");
     	  
     	  test = extent.createTest("AddUpdate_Product_MultiplePriceGrid");
     	 
     	  test.log(Status.PASS, "Multiple Grid Product add and update Sucessfully");
     	    
     	  	}
     	  	else{
     	  		
     	  		System.out.println("Multiple Grid Product add and update UnSucessfully");
     	  	  
     	  		test = extent.createTest("AddUpdate_Product_MultiplePriceGrid");
     	  	 
     	  	  	test.log(Status.FAIL, "Multiple Grid Product add and update UnSucessfully");
     	  	}
  	   	
 	
 	} catch(NoSuchElementException e){
     	e.getStackTrace();
     	
	}
   	  
 }
     
 @Test(priority=3)

 public void SetandRemoveQUR_FromProducts_CurrencyGrid_BulkEdit() throws InterruptedException{
    
    try{
    
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
    
 	Thread.sleep(2000);
 
    WebElement toClear = driver.findElement(By.xpath(Testelements.Copy_Product_field));
    toClear.sendKeys(Keys.CONTROL + "a");
    toClear.sendKeys(Keys.DELETE); 
    //Insert a new name
    driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
    //Save the copy product 
    
    driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
    
    waitForPageLoad();
    
    Thread.sleep(2000);
   
   
    
    waitForPageLoad();
    
    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
   
   //Switch back to parent window 
      driver.switchTo().window(parentWindow5);
      
  //Refresh the page
     // driver.navigate().refresh();
      //Wait for screen to reload
     
     
  	
      //Wait for the alert to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
     
      try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
     
      
      //Active the product
       driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
       //Wait for the alert to appear
       wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
       //Press the ok button from alert
       driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
       
       
 		Thread.sleep(12000);
 		
 		 driver.findElement(By.xpath(Testelements.Copy_Button)).click();
 		   
 		  //Switch to new window opened
 		 	for(String winHandle : driver.getWindowHandles()){
 		 	    if(!winHandle.equals(parentWindow5)) {
 		 	        driver.switchTo().window(winHandle);
 		 	    }
 		 	}
 		    
 		    //Wait for few sec 
 		    
 		 	Thread.sleep(2000);
 		 
 		    WebElement toClear1 = driver.findElement(By.xpath(Testelements.Copy_Product_field));
 		    toClear1.sendKeys(Keys.CONTROL + "a");
 		    toClear1.sendKeys(Keys.DELETE); 
 		    //Insert a new name
 		    driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
 		    //Save the copy product 
 		    
 		    driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
 		    
 		    waitForPageLoad();
 		    
 		    Thread.sleep(2000);
 		   
 		   
 		    
 		    waitForPageLoad();
 		    
 		    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
 		   
 		   //Switch back to parent window 
 		      driver.switchTo().window(parentWindow5);
 		      
 		  //Refresh the page
 		     // driver.navigate().refresh();
 		      //Wait for screen to reload
 		     
 		     
 		  	
 		      //Wait for the alert to appear
 		      wait = new WebDriverWait(driver, 180);
 		      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
 		     
 		      try {
 		    		Thread.sleep(2000);
 		    	} catch (InterruptedException e1) {
 		    		// TODO Auto-generated catch block
 		    		e1.printStackTrace();
 		    	}
 		     
 		      
 		      //Active the product
 		       driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
 		       //Wait for the alert to appear
 		       wait = new WebDriverWait(driver, 180);
 		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
 		       //Press the ok button from alert
 		       driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
 		       
 		       
 		 		Thread.sleep(12000);
 		 		
 		 		
 		 		 	//Select the First Two Products Checkboxes
 		 			    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
 		 			    
 		 			    Thread.sleep(1000);
 		 			    
 		 			    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
 		 			    
 		 			    Thread.sleep(1000);
 		 			    
 		 			  //Press the bulk edit button
 		 	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
 		 	  	        
 		 	  	        Thread.sleep(3000);
 		 	  				
 		 	  	 		List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
 		 	  	 		li1.get(2).click();
 		 	  	
 		 	  			Thread.sleep(1000);
 		 	  			
 		 	  		//Select the Base Pricing
 		 	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
 		 	  			
 		 	  	   
 		 	  		//Now Press the bulk Edit Button
 		 	    		List<WebElement> li7= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
 		 	  		    li7.get(8).click();
 		 	  			
 		 	  		    Thread.sleep(2000);
 		 	  		    
 		 	  		//Select the currency and bulk option to make usd grid QUR
 		 	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
 		 	  		    
 		 	  		    Thread.sleep(1000);
 		 	  		    
 		 	  		 //Select the usd currency from base pricing and Set QUR option
 		 	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
 		 	  		    
 		 	  		    Thread.sleep(1000);
 		 	  		    
 		 	  		    driver.findElement(By.xpath(Testelements.MakeCurrencyGrid_QUR_RadioButton_BulkEditBasePricing)).click();
 		 	  		    
 		 	  		    Thread.sleep(2000);
 		 	  		    
 		 	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
 		 	  		    
 		 	  		wait = new WebDriverWait(driver, 180);
 				    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
 				     
 				    Thread.sleep(3000);
 		 	  		    
 		 	  		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
 		 	  		    
 		 	  		Thread.sleep(2000);
 		 	  	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
 		 	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
 		 	  	   
 		 	  	   waitForPageLoad();
 		 	  	   
 		 	  	   Thread.sleep(1000);
 		 	  	   
 		 	  	   waitForPageLoad();
 		 	  	   
 		 	  	   Thread.sleep(1000);
 		 	  //Press the pricing tab
 		 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
 		 	      
 		 	     
 		 	      waitForPageLoad();
 		 	      
 		 	      Thread.sleep(1000);
 		 	      
 		 	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
 		 		
 		 	    Thread.sleep(2000); 
 		 	    
 		 	  //Validate if the checkbox for QUR is checked or not for usd grid
 		 	    if(driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).isSelected())
 		 	    {
 		 	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Successfully");
 		 	    	
 		 	    	 test = extent.createTest("QURSet_ThroughBulkEdit_On_USDCurrency_Grid1");
 		 	     	 
 		 	     	  test.log(Status.PASS, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Successfully");
 		 	    	
 		 	    }
 		 	    else{
 		 	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR UnSuccessfully");
 		 	    
 		 	    	 test = extent.createTest("QURSet_ThroughBulkEdit_On_USDCurrency_Grid1");
 		 	     	 
 		 	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR UnSuccessfully");
 		 	    
 		 	    }
 		 	
 		 	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
		 		
		 	  Thread.sleep(2000); 
 	
		 	 if(driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD2)).isSelected())
		 	    {
		 	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Successfully");
		 	   
		 	    	 test = extent.createTest("QURSet_ThroughBulkEdit_On_USDCurrency_Grid2");
		 	     	 
		 	     	 test.log(Status.PASS, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Successfully");
		 	    }
		 	    else{
		 	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR UnSuccessfully");
		 	    
		 	    	test = extent.createTest("QURSet_ThroughBulkEdit_On_USDCurrency_Grid2");
		 	     	 
		 	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR UnSuccessfully");
		 	    }
   	
		 	driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	
		 	
		 	//Switch back to parent window 
		       driver.switchTo().window(parentWindow5);
		       
		       //Wait for the alert to appear
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		       
		       Thread.sleep(2000);
		  
		       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
 			    
 			    Thread.sleep(1000);
 			    
 			    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
 			    
 			    Thread.sleep(1000);
 			    
 			  //Press the bulk edit button
 	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
 	  	        
 	  	        Thread.sleep(3000);
 	  				
 	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
 	  	 		li9.get(2).click();
 	  	
 	  			Thread.sleep(1000);
 	  			
 	  		//Select the Base Pricing
 	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
 	  			
 	  	   
 	  		//Now Press the bulk Edit Button
 	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
 	  		    li8.get(8).click();
 	  			
 	  		    Thread.sleep(2000);
 	  		    
 	  		//Select the currency and bulk option to make usd grid QUR
 	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
 	  		    
 	  		    Thread.sleep(1000);
 	  		    
 	  		 //Select the usd currency from base pricing and Set QUR option
 	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
 	  		    
 	  		    Thread.sleep(1000);
 	  		    
 	  		    driver.findElement(By.xpath(Testelements.MakeCurrencyGrid_NonQUR_RadioButton_BulkEditBasePricing)).click();
 	  		    
 	  		    Thread.sleep(2000);
 	  		    
 	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
 	  		    
 	  		 wait = new WebDriverWait(driver, 180);
 		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
 		     
 		    Thread.sleep(3000);
 	  		    
 	  		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
 	  		    
 	  		Thread.sleep(2000);
 	  	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
 	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
 	  	   
 	  	   waitForPageLoad();
 	  	   
 	  	   Thread.sleep(1000);
 	  	   
 	  	   waitForPageLoad();
 	  	   
 	  	   Thread.sleep(1000);
 	  //Press the pricing tab
 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
 	      
 	     
 	      waitForPageLoad();
 	      
 	      Thread.sleep(1000);
 	      
 	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
 		
 	    Thread.sleep(2000); 
 	    
 	  //Validate if the checkbox for QUR is checked or not for usd grid
 	    if(!driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).isSelected())
 	    {
 	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove Successfully");
 	    	
 	    	 test = extent.createTest("QURRemove_ThroughBulkEdit_On_USDCurrency_Grid1");
 	     	 
 	     	  test.log(Status.PASS, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Successfully");
 	    	
 	    }
 	    else{
 	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR UnSuccessfully");
 	    
 	    	 test = extent.createTest("QURRemove_ThroughBulkEdit_On_USDCurrency_Grid1");
 	     	 
 	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove UnSuccessfully");
 	    
 	    }
 	
 	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
		
	  Thread.sleep(2000); 

	 if(!driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD2)).isSelected())
	    {
	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove Successfully");
	   
	    	 test = extent.createTest("QURRemove_ThroughBulkEdit_On_USDCurrency_Grid2");
	     	 
	     	 test.log(Status.PASS, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove Successfully");
	    }
	    else{
	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove UnSuccessfully");
	    
	    	test = extent.createTest("QURRemove_ThroughBulkEdit_On_USDCurrency_Grid2");
	     	 
	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove UnSuccessfully");
	    }

		       
		      
   	}catch(NoSuchElementException e){
       	e.getStackTrace();
       	
  	}
    
    
    }
 @Test(priority=4)
 public void QUR_ProductLevelandBulkLevelCombo() throws InterruptedException{
	  try{
	  
		  JavascriptExecutor jse900 = (JavascriptExecutor)driver;
	      jse900.executeScript("window.scrollBy(0,-250)", "");
			
	      JavascriptExecutor jse901 = (JavascriptExecutor)driver;
	      jse901.executeScript("window.scrollBy(-250,-500)", "");
	      
	      JavascriptExecutor jse902 = (JavascriptExecutor)driver;
	      jse902.executeScript("window.scrollBy(-500,-750)", "");
	      
	      Thread.sleep(5000);
	      
	      //Check the QUR for blue and white color on product level and save changes
	      driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).click();
	      
	      Thread.sleep(1000);
	      
	      driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD2)).click();
	      
	      Thread.sleep(1000);
	      
	      //Press the save button
	      driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
	      
	      waitForPageLoad();
	      
	      Thread.sleep(2000);
	      
	      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	 wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		     
		      
		  		Thread.sleep(3000);
		  	
		      //Make chnages Active
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		    
		     //Wait for the button to appear
		  	 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
		       
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
		       
		     Thread.sleep(7000);
		     
		     driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			  Thread.sleep(1000);
			    
			 //Press the bulk edit button
	  		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		//Select the currency and bulk option to make usd grid QUR
	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		 //Select the usd currency from base pricing and Set QUR option
	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.MakeCurrencyGrid_NonQUR_RadioButton_BulkEditBasePricing)).click();
	  		    
	  		    Thread.sleep(2000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
	  		    
	  		  wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			    Thread.sleep(3000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
	  		    
	  		Thread.sleep(2000);
	  	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  //Press the pricing tab
	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	      
	     
	      waitForPageLoad();
	      
	      Thread.sleep(1000);
	      
	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
		
	    Thread.sleep(2000); 
	    
	  //Validate if the checkbox for QUR is checked or not for usd grid
	    if(!driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).isSelected())
	    {
	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove after selecting QUR at Product Level Successfully");
	    	
	    	 test = extent.createTest("QURRemove_AfterSelectingAtProductLevel_ThroughBulkEdit_On_USDCurrency_Grid1");
	     	 
	     	  test.log(Status.PASS, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove after selecting QUR at Product Level Successfully");
	    	
	    }
	    else{
	    	System.out.println("Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove after selecting QUR at Product Level UnSuccessfully");
	    
	    	 test = extent.createTest("QURRemove_AfterSelectingAtProductLevel_ThroughBulkEdit_On_USDCurrency_Grid1");
	     	 
	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From First Base Pricing Column QUR Remove after selecting QUR at Product Level UnSuccessfully");
	    
	    }
	
	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
		
	  Thread.sleep(2000); 

	 if(!driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD2)).isSelected())
	    {
	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove after selecting QUR at Product Level Successfully");
	   
	    	 test = extent.createTest("QURRemove_AfterSelectingAtProductLevel_ThroughBulkEdit_On_USDCurrency_Grid2");
	     	 
	     	 test.log(Status.PASS, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove after selecting QUR at Product Level Successfully");
	    }
	    else{
	    	System.out.println("Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove after selecting QUR at Product Level UnSuccessfully");
	    
	    	test = extent.createTest("QURRemove_AfterSelectingAtProductLevel_ThroughBulkEdit_On_USDCurrency_Grid2");
	     	 
	     	test.log(Status.FAIL, "Grid USD Currency is Bulk Edit From Second Base Pricing Column QUR Remove after selecting QUR at Product Level UnSuccessfully");
	    }

		       
		     
		     
		  
		  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }

 @Test(priority=5)
 public void BulkEdit_Currency_ListPrice_AddSubtract() throws InterruptedException, ParseException{
	  try{
	  
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		     
		    Thread.sleep(3000);
		 	 
		 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			  Thread.sleep(1000);
			    
			 //Press the bulk edit button
	  		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		//Add the Percentage of add
	  		    driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).clear();
	  		    
	  		  driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).sendKeys("2");
	  		  
	  		  Thread.sleep(2000);
	  		  
	  		driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
  		    
  		    Thread.sleep(2000);
	  		  
	  		//Select the currency and bulk option to make usd grid QUR
	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		 //Select the usd currency from base pricing and Set QUR option
	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
	  		    
	  		    Thread.sleep(2000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
	  		    
	  		  wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			    Thread.sleep(3000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
	  		    
	  		Thread.sleep(2000);
	  	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  //Press the pricing tab
	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	      
	     
	      waitForPageLoad();
	      
	      Thread.sleep(3000);
	      
	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
		
	    Thread.sleep(3000); 
	    
	    //ListPriceValue_Grid1=driver.findElement(By.xpath(Testelements.MG_ListPrice1));
		//ListPriceValueVerification_Grid1=ListPriceValue_Grid1.getAttribute("value");
		  
		   //System.out.println(ListPriceValueVerification_Grid1);
	    
	    ListPrice_Grid1_String_To_Integer();
	    
	    NetCost_Grid1_String_To_Integer();
	    
	    ListPrice_Calculation_70Percent();
	    
	    NetCost_Calculation_70Percent();
	    
	    RoundingOffTotalAmount_ListPrice();
	    
	    RoundingOffTotalAmount_NetCost();
	    
	    ListPrice_Grid1_String_To_Integer();
	    
	    NetCost_Grid1_String_To_Integer();
		   
		   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
		   {
			   System.out.println("List Price and NetCost Bulk Percentage Add for US Currency for Grid 1 Successfully");
			   
			   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageAdd_To_USCurrency_Grid1");
			   	
			   test.log(Status.PASS, "List Price and NetCost Bulk Percentage Add for US Currency for Grid 1 Successfully ");
		   }
		   else{
	          System.out.println("List Price and NetCost Bulk Percentage Add for US Currency for Grid 1 UnSuccessfully");
			   
			   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageAdd_To_USCurrency_Grid1");
			   	
			   test.log(Status.FAIL, "List Price and NetCost Bulk Percentage Add for US Currency for Grid 1 UnSuccessfully ");
			   
		   }
	    
	 
	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
		
	  Thread.sleep(2000); 
	  
	  //ListPriceValue_Grid2=driver.findElement(By.xpath(Testelements.MG_ListPrice2));
	   //ListPriceValueVerification_Grid2=ListPriceValue_Grid2.getAttribute("value");
		  //  System.out.println(ListPriceValueVerification_Grid2);
		
	  ListPrice_Grid2_String_To_Integer();
	    
	    NetCost_Grid2_String_To_Integer();
	    
	    ListPrice_Calculation_70Percent();
	    
	    NetCost_Calculation_70Percent();
	    
	    RoundingOffTotalAmount_ListPrice();
	    
	    RoundingOffTotalAmount_NetCost();;
	    
	    ListPrice_Grid2_String_To_Integer();
	    
	    NetCost_Grid2_String_To_Integer();
	  
		   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
		   {
			   System.out.println("List Price and NetCost Bulk Percentage Add for US Currency for Grid 2 Successfully");
			   
			   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageAdd_To_USCurrency_Grid2");
			   	
			   test.log(Status.PASS, "List Price and NetCost Bulk Percentage Add for US Currency for Grid 2 Successfully ");
		   }
		   else{
	          System.out.println("List Price and NetCost Bulk Percentage Add for US Currency for Grid 2 UnSuccessfully");
			   
			   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageAdd_To_USCurrency_Grid2");
			   	
			   test.log(Status.FAIL, "List Price and NetCost Bulk Percentage Add for US Currency for Grid 2 UnSuccessfully ");
			   
		   }

	
	 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	    
	 //Scroll up
 	 JavascriptExecutor jse1108 = (JavascriptExecutor)driver;
 	 jse1108.executeScript("window.scrollBy(0,-250)", "");
 	 
 	//Scroll up
 	 JavascriptExecutor jse1119 = (JavascriptExecutor)driver;
 	 jse1119.executeScript("window.scrollBy(-250,-500)", "");
 	 
 	
 	JavascriptExecutor jse11101 = (JavascriptExecutor)driver;
 	 jse11101.executeScript("window.scrollBy(-500,-750)", "");
 	 
 	 Thread.sleep(2000);
 	 
 	wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
     
    Thread.sleep(3000);
 	 
 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	  Thread.sleep(1000);
	    
	 //Press the bulk edit button
		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	        
	        Thread.sleep(3000);
				
	 		List<WebElement> li10= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 		li10.get(2).click();
	
			Thread.sleep(1000);
			
		//Select the Base Pricing
			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
			
	   
		//Now Press the bulk Edit Button
		List<WebElement> li11= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
		    li11.get(8).click();
			
		    Thread.sleep(2000);
		    
		
		    
		    //Select the subtract option
		    driver.findElement(By.xpath(Testelements.SubtractValue_BulkEdit_BasePricing_RadioOption)).click();
		    
		    //Add the Percentage of add
		    driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).clear();
		    
		  driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).sendKeys("2");
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
		    
		    Thread.sleep(2000);
		    
		//Select the currency and bulk option to make usd grid QUR
		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
		    
		    Thread.sleep(1000);
		    
		 //Select the usd currency from base pricing and Set QUR option
		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
		    
		    Thread.sleep(1000);  
		    
		    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
  		    
  		    Thread.sleep(2000);
		  
		  
		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
		    
		    wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
		     
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
		    
		Thread.sleep(2000);
	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	   
	   waitForPageLoad();
	   
	   Thread.sleep(1000);
	   
	   waitForPageLoad();
	   
	   Thread.sleep(1000);
//Press the pricing tab
	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
  
 
  waitForPageLoad();
  
  Thread.sleep(1000);
  
driver.findElement(By.xpath(Testelements.PriceExpand1)).click();

Thread.sleep(2000); 

 //ListPriceValue_Grid1=driver.findElement(By.xpath(Testelements.MG_ListPrice1));
 //ListPriceValueVerification_Grid1=ListPriceValue_Grid1.getAttribute("value");
  
   //System.out.println(ListPriceValueVerification_Grid1);
ListPrice_Grid1_String_To_Integer();

NetCost_Grid1_String_To_Integer();

ListPrice_Calculation_70Percent();

NetCost_Calculation_70Percent();

RoundingOffTotalAmount_ListPrice();

RoundingOffTotalAmount_NetCost();

ListPrice_Grid1_String_To_Integer();

NetCost_Grid1_String_To_Integer();
   
   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
   {
	   System.out.println("List&NetCost Bulk Price Percentage Subtract for US Currency for Grid 1 Successfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageSubtract_To_USCurrency_Grid1");
	   	
	   test.log(Status.PASS, "List&NetCost Bulk Price Percentage Subtract for US Currency for Grid 1 Successfully ");
   }
   else{
      System.out.println("List&NetCost Bulk Price Subtract for US Currency for Grid 1 UnSuccessfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageSubtract_To_USCurrency_Grid1");
	   	
	   test.log(Status.FAIL, "List&NetCost Bulk Price Percentage Subtract for US Currency for Grid 1 UnSuccessfully ");
	   
   }


driver.findElement(By.xpath(Testelements.PriceExpand2)).click();

Thread.sleep(2000); 

//ListPriceValue_Grid2=driver.findElement(By.xpath(Testelements.MG_ListPrice2));
//ListPriceValueVerification_Grid2=ListPriceValue_Grid2.getAttribute("value");
  
  // System.out.println(ListPriceValueVerification_Grid2);
ListPrice_Grid2_String_To_Integer();

NetCost_Grid2_String_To_Integer();

ListPrice_Calculation_70Percent();

NetCost_Calculation_70Percent();

RoundingOffTotalAmount_ListPrice();

RoundingOffTotalAmount_NetCost();;

ListPrice_Grid2_String_To_Integer();

NetCost_Grid2_String_To_Integer();
   
   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost )
   {
	   System.out.println("ListPrice&NeCost Bulk Price Percentage Subtract for US Currency for Grid 2 Successfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageSubtract_To_USCurrency_Grid2");
	   	
	   test.log(Status.PASS, "ListPrice&NeCost Bulk Price Percentage Subtract for US Currency for Grid 2 Successfully ");
   }
   else{
      System.out.println("ListPrice&NeCost Bulk Price Percentage Subtract for US Currency for Grid 2 UnSuccessfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_PercentageSubtract_To_USCurrency_Grid2");
	   	
	   test.log(Status.FAIL, "ListPrice&NeCost Bulk Price Percentage Subtract for US Currency for Grid 2 UnSuccessfully ");
	   
   }

   
		       
		  
     	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=6)
 public void NetCost_BulkEdit_Validation_Verification_ListPriceAtProductLevel() throws InterruptedException{
	  try{
	  
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		     
		    Thread.sleep(3000);
		 	 
		 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		     
		 	//Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  	        
	  	      List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 	  li9.get(2).click();
	  	
	  		  Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.PriceTypeUpdate_BulkEdit));
	  		Select dropdown72= new Select(mySelectElement72);

	  		dropdown72.selectByVisibleText("Net Cost");
	  		
	  		Thread.sleep(1000);
	  		    
        
	  	//Add the Percentage of add
	  		    driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).clear();
	  		    
	  		  driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).sendKeys("3");
	  		  
	  		  Thread.sleep(2000);
	  		  
	  		driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
		    
		    Thread.sleep(2000);
	  		  
	  		//Select the currency and bulk option to make usd grid QUR
	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		 //Select the usd currency from base pricing and Set QUR option
	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
	  		    
	  		    Thread.sleep(2000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
	  		    
	  		  wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.NetCost_BulkEdit_Validation_Verification_WhenListPriceAtProductLevel)));
			     
			    Thread.sleep(3000);
	  		    
	  		   if(driver.findElement(By.xpath(Testelements.NetCost_BulkEdit_Validation_Verification_WhenListPriceAtProductLevel)).getText().contains("will not be updated as they don't have pricing in net cost")) 
	  		   {
	  			   System.out.println("Net Cost Bulk Edit Failed as there no value for Net Cost at Product Level validation displayed Successfully");
	  			   
	  			 test = extent.createTest("NetCost_BulkEdit_Validation_Verification_ListPriceAtProductLevel");
			 	   	
			 	   test.log(Status.PASS, "Net Cost Bulk Edit Failed as there no value for Net Cost at Product Level validation displayed Successfully");
	  			   
	  			   
	  		   }
	  		   else{
	  			 System.out.println("Net Cost Bulk Edit Failed as there no value for Net Cost at Product Level validation displayed UnSuccessfully");
	  			   
	  			 test = extent.createTest("NetCost_BulkEdit_Validation_Verification_ListPriceAtProductLevel");
			 	   	
			 	   test.log(Status.FAIL, "Net Cost Bulk Edit Failed as there no value for Net Cost at Product Level validation displayed UnSuccessfully"); 
	  		   }
			    
			    
	  		   driver.findElement(By.xpath(Testelements.NetCost_BulkEdit_ConfirmOKButton)).click();	 	  		    
	  		    
	  		   Thread.sleep(2000);

	  		 Alert alert = driver.switchTo().alert();		
	 		
	  	      // Accepting alert		
	  	        alert.accept();
	  	        
	  	        Thread.sleep(3000);
		 	 
     	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }

 
 @Test(priority=7)
 public void BulkEditListpriceandNetCost_AddSubtractWithFixedAmountBasePricing_ToUSCurrencyApply() throws InterruptedException, ParseException{
	  try{
	  
		  //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	//Press the bulk edit button
	  		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		//Now Select Add and Fixed amount checbox and validate the values after bulk at product level
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_RadioButton)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_Field)).clear();
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_Field)).sendKeys("2");
	  		    
	  		  driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
			    
			    Thread.sleep(2000);
			    
			//Select the currency and bulk option to make usd grid QUR
			    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
			    
			    Thread.sleep(1000);
			    
			 //Select the usd currency from base pricing and Set QUR option
			    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
			    
			    Thread.sleep(1000);  
			    
			    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
	  		    
	  		    Thread.sleep(2000);
			  
			  
			    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
			    
			    wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			    Thread.sleep(3000);
			    
			    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
			    
			Thread.sleep(2000);
		//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
		   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
	//Press the pricing tab
		 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	  
	 
	  waitForPageLoad();
	  
	  Thread.sleep(1000);
	  
	driver.findElement(By.xpath(Testelements.PriceExpand1)).click();

	Thread.sleep(2000); 

	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();

	ListPrice_Calculation_70Percent();

	NetCost_Calculation_70Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();

	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
	   {
		   System.out.println("ListPrice&NeCost Bulk Fixed amount Price Add for US Currency for Grid 1 Successfully");
		   
		   test = extent.createTest("ListPrice&NeCost_BulkEdit_FixedAmountAdd_To_USCurrency_Grid1");
		   	
		   test.log(Status.PASS, "ListPrice&NeCost Bulk Fixed amount Price Add for US Currency for Grid 1 Successfully ");
	   }
	   else{
	      System.out.println("ListPrice&NeCost Bulk Fixed amount Price Add for US Currency for Grid 1 UnSuccessfully");
		   
		   test = extent.createTest("ListPrice&NeCost_BulkEdit_FixedAmountAdd_To_USCurrency_Grid1");
		   	
		   test.log(Status.FAIL, "ListPrice&NeCost Bulk Fixed amount Price Add for US Currency for Grid 1 UnSuccessfully ");
		   
	   }


	driver.findElement(By.xpath(Testelements.PriceExpand2)).click();

	Thread.sleep(2000); 

	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();

	ListPrice_Calculation_70Percent();

	NetCost_Calculation_70Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();;

	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost )
	   {
		   System.out.println("ListPrice&NetCost Bulk Fixed amount Price Add for US Currency for Grid 2 Successfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_FixedAmountAdd_To_USCurrency_Grid2");
		   	
		   test.log(Status.PASS, "ListPrice&NetCost Bulk Fixed amount Price Add for US Currency for Grid 2 Successfully ");
	   }
	   else{
	      System.out.println("ListPrice&NetCost Bulk Fixed amount Price Add for US Currency for Grid 2 UnSuccessfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_FixedAmountAdd_To_USCurrency_Grid2");
		   	
		   test.log(Status.FAIL, "ListPrice&NetCost Bulk Fixed amount Price Add for US Currency for Grid 2 UnSuccessfully ");
		   
	   }

	   driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	    
		 //Scroll up
	 	 JavascriptExecutor jse1107 = (JavascriptExecutor)driver;
	 	 jse1107.executeScript("window.scrollBy(0,-250)", "");
	 	 
	 	//Scroll up
	 	 JavascriptExecutor jse1118 = (JavascriptExecutor)driver;
	 	 jse1118.executeScript("window.scrollBy(-250,-500)", "");
	 	 
	 	
	 	JavascriptExecutor jse1119 = (JavascriptExecutor)driver;
	 	 jse1119.executeScript("window.scrollBy(-500,-750)", "");
	 	 
	 	 Thread.sleep(2000);
	 	 
	 	wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
	     
	    Thread.sleep(3000);
	 	 
	 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		  Thread.sleep(1000);
		    
		 //Press the bulk edit button
		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	        
	        Thread.sleep(3000);
				
	 		List<WebElement> li91= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 		li91.get(2).click();
	
			Thread.sleep(1000);
			
		//Select the Base Pricing
			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
			
	   
		//Now Press the bulk Edit Button
  		List<WebElement> li100= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
		    li100.get(8).click();
			
		    Thread.sleep(2000);
		    
		  driver.findElement(By.xpath(Testelements.SubtractValue_BulkEdit_BasePricing_RadioOption)).click();
		  
		  Thread.sleep(1000);
		    
		//Now Select Add and Fixed amount checbox and validate the values after bulk at product level
		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_RadioButton)).click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_Field)).clear();
		    
		    driver.findElement(By.xpath(Testelements.BulkEdit_FixedAmount_Field)).sendKeys("2");
		    
		  driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
		    
		    Thread.sleep(2000);
		    
		//Select the currency and bulk option to make usd grid QUR
		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
		    
		    Thread.sleep(1000);
		    
		 //Select the usd currency from base pricing and Set QUR option
		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
		    
		    Thread.sleep(1000);  
		    
		    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
		    
		    Thread.sleep(2000);
		  
		  
		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
		    
		    wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
		     
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
		    
		Thread.sleep(2000);
	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	   
	   waitForPageLoad();
	   
	   Thread.sleep(1000);
	   
	   waitForPageLoad();
	   
	   Thread.sleep(1000);
//Press the pricing tab
	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();


waitForPageLoad();

Thread.sleep(1000);

driver.findElement(By.xpath(Testelements.PriceExpand1)).click();

Thread.sleep(2000); 

ListPrice_Grid1_String_To_Integer();

NetCost_Grid1_String_To_Integer();

ListPrice_Calculation_70Percent();

NetCost_Calculation_70Percent();

RoundingOffTotalAmount_ListPrice();

RoundingOffTotalAmount_NetCost();

ListPrice_Grid1_String_To_Integer();

NetCost_Grid1_String_To_Integer();
   
   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
 
 {
	   System.out.println("ListPrice&NeCost Bulk Fixed amount Price Subtract for US Currency for Grid 1 Successfully");
	   
	   test = extent.createTest("ListPrice&NeCost_BulkEdit_FixedAmountSubtract_To_USCurrency_Grid1");
	   	
	   test.log(Status.PASS, "ListPrice&NeCost Bulk Fixed amount Price Subtract for US Currency for Grid 1 Successfully ");
 }
 else{
    System.out.println("ListPrice&NeCost Bulk Fixed amount Price Subtract for US Currency for Grid 1 UnSuccessfully");
	   
	   test = extent.createTest("ListPrice&NeCost_BulkEdit_FixedAmountSubtract_To_USCurrency_Grid1");
	   	
	   test.log(Status.FAIL, "ListPrice&NeCost Bulk Fixed amount Price Subtract for US Currency for Grid 1 UnSuccessfully ");
	   
 }


driver.findElement(By.xpath(Testelements.PriceExpand2)).click();

Thread.sleep(2000); 

ListPrice_Grid2_String_To_Integer();

NetCost_Grid2_String_To_Integer();

ListPrice_Calculation_70Percent();

NetCost_Calculation_70Percent();

RoundingOffTotalAmount_ListPrice();

RoundingOffTotalAmount_NetCost();;

ListPrice_Grid2_String_To_Integer();

NetCost_Grid2_String_To_Integer();
   
   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost )
 {
	   System.out.println("ListPrice&NetCost Bulk Fixed amount Price Subtract for US Currency for Grid 2 Successfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_FixedAmountSubtract_To_USCurrency_Grid2");
	   	
	   test.log(Status.PASS, "ListPrice&NetCost Bulk Fixed amount Price Subtract for US Currency for Grid 2 Successfully ");
 }
 else{
    System.out.println("ListPrice&NetCost Bulk Fixed amount Price Subtract for US Currency for Grid 2 UnSuccessfully");
	   
	   test = extent.createTest("ListPrice&NetCost_BulkEdit_FixedAmountSubtract_To_USCurrency_Grid2");
	   	
	   test.log(Status.FAIL, "ListPrice&NetCost Bulk Fixed amount Price Subtract for US Currency for Grid 2 UnSuccessfully ");
	   
 }

	  		    
	  		    
     	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=8)
 public void BulkEditListprice_ThroughPriceCode() throws InterruptedException, ParseException{
	  try{
	  
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		     
		    Thread.sleep(3000);
		 	 
		 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			  Thread.sleep(1000);
			    
			 //Press the bulk edit button
	  		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		//Now Select Add and Fixed amount checbox and validate the values after bulk at product level
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_Pricecode_RadioButton)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		  WebElement mySelectElement100 = driver.findElement(By.xpath(Testelements.BulkEdit_PriceCode_Selection));
	  	      Select dropdown100= new Select(mySelectElement100);
	  	     
	  	      dropdown100.selectByVisibleText("A/P 50%");
	  		    
	  		  driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
			    
			    Thread.sleep(2000);
			    
			//Select the currency and bulk option to make usd grid QUR
			    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
			    
			    Thread.sleep(1000);
			    
			 //Select the usd currency from base pricing and Set QUR option
			    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
			    
			    Thread.sleep(1000);  
			    
			    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
	  		    
	  		    Thread.sleep(2000);
			  
			  
			    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
			    
			    wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			    Thread.sleep(3000);
			    
			    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
			    
			Thread.sleep(2000);
		//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
		   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
	//Press the pricing tab
		 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	  
	 
	  waitForPageLoad();
	  
	  Thread.sleep(1000);
	  
	driver.findElement(By.xpath(Testelements.PriceExpand1)).click();

	Thread.sleep(2000); 

	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();

	ListPrice_Calculation_50Percent();

	NetCost_Calculation_50Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();

	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
	   {
		   System.out.println("ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 1 Successfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_ThroughPriceCode_To_USCurrency_Grid1");
		   	
		   test.log(Status.PASS, "ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 1 Successfully ");
	   }
	   else{
	      System.out.println("ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 1 UnSuccessfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_ThroughPriceCode_To_USCurrency_Grid1");
		   	
		   test.log(Status.FAIL, "ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 1 UnSuccessfully ");
		   
	   }


	driver.findElement(By.xpath(Testelements.PriceExpand2)).click();

	Thread.sleep(2000); 

	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();

	ListPrice_Calculation_50Percent();

	NetCost_Calculation_50Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();;

	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost )
	   {
		   System.out.println("ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 2 Successfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_PriceCode_To_USCurrency_Grid2");
		   	
		   test.log(Status.PASS, "ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 2 Successfully ");
	   }
	   else{
	      System.out.println("ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 2 UnSuccessfully");
		   
		   test = extent.createTest("ListPrice&NetCost_BulkEdit_PriceCode_To_USCurrency_Grid2");
		   	
		   test.log(Status.FAIL, "ListPrice&NetCost Bulk through Price code updated for US Currency for Grid 2 UnSuccessfully ");
		   
	   }

	   
	  		    
	  		    
     	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=9)
 public void CopyBasePricing() throws InterruptedException, ParseException{
	  try{
	  
		  driver.findElement(By.xpath(Testelements.MG_ListPrice1)).clear();
		  
		  driver.findElement(By.xpath(Testelements.MG_ListPrice1)).sendKeys("10");
			
			//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();
			
	    WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.MGP_PriceCode1));
		Select dropdown72= new Select(mySelectElement72);

		dropdown72.selectByVisibleText("L 70%");

		 Thread.sleep(2000);
		 
		 ListPrice_Grid1_String_To_Integer();

		 NetCost_Grid1_String_To_Integer();

		 ListPrice_Calculation_70Percent();

		 NetCost_Calculation_70Percent();

		 RoundingOffTotalAmount_ListPrice();

		 RoundingOffTotalAmount_NetCost();

		 ListPrice_Grid1_String_To_Integer();

		 NetCost_Grid1_String_To_Integer();
		    
		    if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
		  
		  {
		 	   System.out.println("ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 Successfully");
		 	   
		 	   test = extent.createTest("ListPrice&NeCost_PriceCodeUpdate_AtProductLevel_To_USCurrency_Grid1");
		 	   	
		 	   test.log(Status.PASS, "ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 Successfully ");
		  }
		  else{
		     System.out.println("ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 UnSuccessfully");
		 	   
		 	   test = extent.createTest("ListPrice&NeCost_PriceCodeUpdate_AtProductLevel_To_USCurrency_Grid1");
		 	   	
		 	   test.log(Status.FAIL, "ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 UnSuccessfully ");
		 	   
		  }
      
		    //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		    
		    //Now Copy the Blue Grid Data into White
		    
		    WebElement mySelectElement73 = driver.findElement(By.xpath(Testelements.PriceGridCopyValueSelection));
			Select dropdown73= new Select(mySelectElement73);

			dropdown73.selectByVisibleText("Blue");
			
			Thread.sleep(2000);
			
	//Now Press the Copy Button
			driver.findElement(By.xpath(Testelements.CopyPriceGridButton_BasePricing)).click();
			
			Thread.sleep(2000);
			
			ListPrice_Grid1_String_To_Integer();

			NetCost_Grid1_String_To_Integer();

			ListPrice_Calculation_50Percent();

			NetCost_Calculation_50Percent();

		   RoundingOffTotalAmount_ListPrice();

		   RoundingOffTotalAmount_NetCost();

		   ListPrice_Grid1_String_To_Integer();

		   NetCost_Grid1_String_To_Integer();
			    
			    if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
			  
			  {
			 	   System.out.println("ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 after copying price grids Successfully");
			 	   
			 	   test = extent.createTest("ListPrice&NeCost_PriceGridCopy_AtProductLevel_To_USCurrency_Grid1");
			 	   	
			 	   test.log(Status.PASS, "ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 after copying price grids Successfully ");
			  }
			  else{
			     System.out.println("ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 after copying price grids UnSuccessfully");
			 	   
			 	   test = extent.createTest("ListPrice&NeCost_PriceCodeUpdate_AtProductLevel_To_USCurrency_Grid1");
			 	   	
			 	   test.log(Status.FAIL, "ListPrice&NeCost Change Price Code Update at product Level Calculated Correct for US Currency for Grid 1 after copying price grids UnSuccessfully ");
			 	   
			  }

		 
		 
		  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 
 @Test(priority=10)
 public void NetCostBulkEdit_WithNetCostAtProductLevel () throws InterruptedException, ParseException{
	  try{
		  
		  WebElement mySelectElement721 = driver.findElement(By.xpath(Testelements.DefaultPriceType_ProductLevel));
	  		Select dropdown721= new Select(mySelectElement721);

	  		dropdown721.selectByVisibleText("Net Cost");
	  		
	  		Thread.sleep(2000);
	  		
	  		driver.findElement(By.xpath(Testelements.ChangingPriceGrids_PriceType_ProductLevel_Confirm)).click();
	  		
	  		Thread.sleep(2000);
		  
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		     
		     Thread.sleep(2000);
			
		    //Active the product
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		     //Wait for the alert to appear
		     wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
		     //Press the ok button from alert
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
		     
		     Thread.sleep(8000);
		     
		 	//Select the First Two Products Checkboxes
			    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			    Thread.sleep(1000);
			    
			  //Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  	        
	  	      List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 	  li9.get(2).click();
	  	
	  		  Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.PriceTypeUpdate_BulkEdit));
	  		Select dropdown72= new Select(mySelectElement72);

	  		dropdown72.selectByVisibleText("Net Cost");
	  		
	  		Thread.sleep(1000);
	  		    
     
	  	//Add the Percentage of add
	  		    driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).clear();
	  		    
	  		  driver.findElement(By.xpath(Testelements.PercentageField_BulkEditPricing)).sendKeys("1");
	  		  
	  		  Thread.sleep(2000);
	  		  
	  		driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
		    
		    Thread.sleep(2000);
	  		  
	  		//Select the currency and bulk option to make usd grid QUR
	  		    driver.findElement(By.xpath(Testelements.BasePricing_BulkEdit_SelectCurrencyDropdown)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		 //Select the usd currency from base pricing and Set QUR option
	  		    driver.findElement(By.xpath(Testelements.BasePricing_USD_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkEdit_outerAreaClick_ToEnableApplyButton)).click();
	  		    
	  		    Thread.sleep(2000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BasePricing_ApplyPriceChanges_Button)).click();
	  		    
	  		  wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			    Thread.sleep(3000);
			    
			    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
			    
			Thread.sleep(2000);
		//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
		   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
		   
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
	//Press the pricing tab
		 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	  
	 
	  waitForPageLoad();
	  
	  Thread.sleep(1000);
	  
	driver.findElement(By.xpath(Testelements.PriceExpand1)).click();

	Thread.sleep(2000); 

	 //ListPriceValue_Grid1=driver.findElement(By.xpath(Testelements.MG_ListPrice1));
	 //ListPriceValueVerification_Grid1=ListPriceValue_Grid1.getAttribute("value");
	  
	   //System.out.println(ListPriceValueVerification_Grid1);
	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();

	ListPrice_Calculation_50Percent();

	NetCost_Calculation_50Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();

	ListPrice_Grid1_String_To_Integer();

	NetCost_Grid1_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost)
	   {
		   System.out.println("List&NetCost Bulk Price Percentage  for US Currency for Grid 1 Successfully");
		   
		   test = extent.createTest("NetCostBulkEdit_WithNetCostAtProductLevel_To_USCurrency_Grid1");
		   	
		   test.log(Status.PASS, "List&NetCost Bulk Price Percentage for US Currency for Grid 1 Successfully ");
	   }
	   else{
	      System.out.println("List&NetCost Bulk Price Subtract for US Currency for Grid 1 UnSuccessfully");
		   
		   test = extent.createTest("NetCostBulkEdit_WithNetCostAtProductLevel_To_USCurrency_Grid1");
		   	
		   test.log(Status.FAIL, "List&NetCost Bulk Price Percentage for US Currency for Grid 1 UnSuccessfully ");
		   
	   }


	driver.findElement(By.xpath(Testelements.PriceExpand2)).click();

	Thread.sleep(2000); 

	//ListPriceValue_Grid2=driver.findElement(By.xpath(Testelements.MG_ListPrice2));
	//ListPriceValueVerification_Grid2=ListPriceValue_Grid2.getAttribute("value");
	  
	  // System.out.println(ListPriceValueVerification_Grid2);
	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();

	ListPrice_Calculation_50Percent();

	NetCost_Calculation_50Percent();

	RoundingOffTotalAmount_ListPrice();

	RoundingOffTotalAmount_NetCost();;

	ListPrice_Grid2_String_To_Integer();

	NetCost_Grid2_String_To_Integer();
	   
	   if(bd.doubleValue()==ListPrice & bd2.doubleValue()==NetCost )
	   {
		   System.out.println("List&NetCost Bulk Price Percentage Add for US Currency for Grid 2 Successfully");
		   
		   test = extent.createTest("NetCostBulkEdit_WithNetCostAtProductLevel_To_USCurrency_Grid2");
		   	
		   test.log(Status.PASS, "List&NetCost Bulk Price Percentage Add for US Currency for Grid 2 Successfully ");
	   }
	   else{
	      System.out.println("List&NetCost Bulk Price Percentage Add for US Currency for Grid 2 UnSuccessfully");
		   
		   test = extent.createTest("NetCostBulkEdit_WithNetCostAtProductLevel_To_USCurrency_Grid2");
		   	
		   test.log(Status.FAIL, "List&NetCost Bulk Price Percentage Add for US Currency for Grid 2 UnSuccessfully ");
		   
	   }

	  		    
	  
	  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=11)
 public void AddUpcharge_ThroughBulkEdit() throws InterruptedException{
	  try{
	  
		  WebElement mySelectElement721 = driver.findElement(By.xpath(Testelements.DefaultPriceType_ProductLevel));
	  		Select dropdown721= new Select(mySelectElement721);

	  		dropdown721.selectByVisibleText("List Price");
	  		
	  		Thread.sleep(2000);
	  		
	  		driver.findElement(By.xpath(Testelements.ChangingPriceGrids_PriceType_ProductLevel_Confirm)).click();
	  		
	  		Thread.sleep(2000);
	  		
	  		//Go to Attributes again to add another color
	  		 driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
	  	    
	  	      waitForPageLoad();
	  	      
	  	      // Wait for attributes to appear
	  	      
	  	      wait = new WebDriverWait(driver, 180);
	  	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
	  	      
	  	      
	  	  	Thread.sleep(2000);
	  	  	
	  	  	//Add another color
	  	  	driver.findElement(By.xpath(Testelements.BrownAttribute_Color)).click();
	  	  	
	  	  	Thread.sleep(2000);
	  	  	
	  	  Alert alert = driver.switchTo().alert();		
	 		
  	      // Accepting alert		
  	        alert.accept();
  	        
  	        Thread.sleep(3000);
	  	  	
	  	  	//Press the Manage Product linkText
	  	  	
	  	  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		     
		     Thread.sleep(2000);
			
		    //Active the product
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		     //Wait for the alert to appear
		     wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
		     //Press the ok button from alert
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
		     
		     Thread.sleep(8000);
		     
		 	//Select the First Two Products Checkboxes
			    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			    Thread.sleep(1000);
			    
			  //Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  	        
	  	      List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 	  li9.get(2).click();
	  	
	  		  Thread.sleep(1000);
	  			
	  		 //Select Upchage Now
	  		    driver.findElement(By.xpath(Testelements.AddUpcharge_BulkEdit)).click();
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		//Now Select the Product Color Option
	  		    driver.findElement(By.xpath(Testelements.Upcharge_ProductColorSelection)).click();
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkAddUpcharge_NextStep)).click();
	  		    
	  		    waitForPageLoad();
	  		    
	  		    Thread.sleep(3000);
	  		    
	  	  //Select the Brown Color from the Product Color Options
	  		    driver.findElement(By.xpath(Testelements.BulkAddUpcharge_BrownColorSelection)).click();
	  		    
	  		    Thread.sleep(2000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkUpchargeAdd_ApplyButton)).click();
	  		    
	  		    waitForPageLoad();
	  		    
	  		    Thread.sleep(5000);
	  		    
	  	//Now Select Aus and Can Currency in brown Color product Color
	  		    driver.findElement(By.xpath(Testelements.AddUpcharge_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.Aus_CurrencySelection__Pricing_ProductLevel)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.AddUpcharge_CurrencySelection)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		  driver.findElement(By.xpath(Testelements.Can_CurrencySelection__Pricing_ProductLevel)).click();
	  		    
	  		    Thread.sleep(1000);
	  		    
	  		    
	  		//Expand the first grid
	  			driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
	  			
	  			//Enter details into fields
	  		    List<WebElement> QuantityUpcharge1 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
	  		    QuantityUpcharge1.get(0).sendKeys("2");

	  		 	
	  		 	Thread.sleep(2000);
	  		//Us Currency(Grid 1)	
	  		List<WebElement> PriceUpcharge1=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	  			PriceUpcharge1.get(0).sendKeys("15");
	  		 
	  		List<WebElement> mySelectElement92 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
	  		Select dropdown79= new Select(mySelectElement92.get(3));

	  		 dropdown79.selectByVisibleText("L 70%");
	  		 
	  		 Thread.sleep(4000);
	  		 
	  		 //Aus Currency (Grid 1)
	  		 List<WebElement> PriceUpcharge2=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	  		 PriceUpcharge2.get(10).sendKeys("16");

	  		List<WebElement> mySelectElement95 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
	  		Select dropdown95= new Select(mySelectElement95.get(13));

	  		dropdown95.selectByVisibleText("L 70%");

	  		Thread.sleep(4000);

	  		//Canadian Currency(Grid 1)

	  		List<WebElement> PriceUpcharge3=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	  		PriceUpcharge3.get(20).sendKeys("17");

	  		List<WebElement> mySelectElement96 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
	  		Select dropdown96= new Select(mySelectElement96.get(23));

	  		dropdown96.selectByVisibleText("L 70%");

	  		Thread.sleep(4000);
	  			
	  		 //Scroll up
	  		 JavascriptExecutor jse200 = (JavascriptExecutor)driver;
	  		 jse200.executeScript("window.scrollBy(0,-250)", "");

	  		 //Scroll up
	  		 JavascriptExecutor jse201 = (JavascriptExecutor)driver;
	  		 jse201.executeScript("window.scrollBy(-250,-500)", ""); 
	  		    
	  		
	  		 //Press the Apply Bulk Button
	  		 driver.findElement(By.xpath(Testelements.BulkColor_ApplyButton)).click();
	  		 
	  		 waitForPageLoad();

	  		 Thread.sleep(4000);
	  		 
	  		 driver.findElement(By.xpath(Testelements.BulkApply_Addupcharge_Confirm)).click();
	  		 
	  		//Scroll up
		 	 JavascriptExecutor jse11021 = (JavascriptExecutor)driver;
		 	 jse11021.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse11131 = (JavascriptExecutor)driver;
		 	 jse11131.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse11141 = (JavascriptExecutor)driver;
		 	 jse11141.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	 
		 	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
		       
		    Thread.sleep(3000);
		 	 
		    driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  //Press the pricing tab
	 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	 	      
	 	     waitForPageLoad();
	 	      
	 	      Thread.sleep(3000);
	 	      
	 	     driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
	 		
	 	     Thread.sleep(3000);
	 	     
	 	    WebElement NewAddUpcharge_ThroughBulk=driver.findElement(By.xpath(Testelements.BrownAddUpchargeBulk_Verification));
	 		  String AddUpcharge_Verification=NewAddUpcharge_ThroughBulk.getAttribute("value");
	 		  
	 		   System.out.println(AddUpcharge_Verification);
	 	  	  
	 		   if(AddUpcharge_Verification.contains("Brown"))
	 		   {
	 			   System.out.println("Bulk Add Upcharge Done Successfully");
	 			   
	 			   test = extent.createTest("AddUpcharge_Through_BulkEdit");
	 			   	
	 			   test.log(Status.PASS, "Bulk Add Upcharge Done Successfully ");
	 		   }
	 		   else{
	 	          System.out.println("Bulk Add Upcharge Done UnSuccessfully");
	 			   
	 			   test = extent.createTest("AddUpcharge_Through_BulkEdit");
	 			   	
	 			   test.log(Status.FAIL, "Bulk Add Upcharge Done UnSuccessfully ");
	 			   
	 		   }
	  		   
	  		    
	  	  	
	  	  	
		  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=12)
 public void CopyUpchargeGrid() throws InterruptedException{
	  try{
	  
		  driver.findElement(By.xpath(Testelements.Upcharge_AllGridsExpand)).click();
		  
		  Thread.sleep(2000);
		  //Storing values from 2nd grid brown into variables
		  List<WebElement> PriceUpchargeGrid2=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
		  String PriceUpchargeListPriceValueGrid2=PriceUpchargeGrid2.get(90).getAttribute("value");
		  System.out.println(PriceUpchargeListPriceValueGrid2);
		  
		  
		  
		  List<WebElement> NetCostUpchargeGrid2=driver.findElements(By.xpath(Testelements.Netcost_USCurrency_Grid1));
		  String PriceUpchargeListNetCostValueGrid2=NetCostUpchargeGrid2.get(90).getAttribute("value");
		  System.out.println(PriceUpchargeListNetCostValueGrid2);
		  
		  WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.UpchargeCopyGrid_Selection));
	  	  Select dropdown72= new Select(mySelectElement72);
          dropdown72.selectByVisibleText("Brown - Product Color Charge - Othe...");
	  		
	  		Thread.sleep(1000);
	  		
	  		//Press the Copy Button
	  		driver.findElement(By.xpath(Testelements.CopyUpchargeGrid_Button)).click();
	  		
	  		Thread.sleep(2000);
	  		
	  		driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
	  		
	  		waitForPageLoad();
	  		
	  		Thread.sleep(3000);
	  		
	  	//Storing values from 2nd grid brown into variables
			  List<WebElement> PriceUpchargeGrid1=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
			  String PriceUpchargeListPriceValueGrid1=PriceUpchargeGrid1.get(60).getAttribute("value");
			  System.out.println(PriceUpchargeListPriceValueGrid1);
			  
			  List<WebElement> NetCostUpchargeGrid1=driver.findElements(By.xpath(Testelements.Netcost_USCurrency_Grid1));
			  String PriceUpchargeListNetCostValueGrid1=NetCostUpchargeGrid1.get(60).getAttribute("value");
			  System.out.println(PriceUpchargeListNetCostValueGrid1);
			  
			  if(PriceUpchargeListPriceValueGrid1.equals(PriceUpchargeListPriceValueGrid2) & PriceUpchargeListNetCostValueGrid1.equals(PriceUpchargeListNetCostValueGrid2))
			  {
				System.out.println("Grid 2 details Copy into grid 1 Successfully "); 
				
				test = extent.createTest("CopyUpchargeGrid");
 			   	
	 			test.log(Status.PASS, "Grid 2 details Copy into grid 1 Successfully");
				
			  }
			  else{
				  System.out.println("Grid 2 details Copy into grid 1 UnSuccessfully");
				  
				  test = extent.createTest("CopyUpchargeGrid");
	 			   	
	 			  test.log(Status.PASS, "Grid 2 details Copy into grid 1 UnSuccessfully");
			  }
			  
			  
			 driver.findElement(By.xpath(Testelements.MakeActive_ButtonPricingStep)).click();
			  
			  
			  
			  wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MakeActiveConfirm_Pricing)));
		       
		       Thread.sleep(2000);
		       driver.findElement(By.xpath(Testelements.MakeActiveConfirm_Pricing)).click();
		       
		       Thread.sleep(7000);
			  
			  
			  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=13)
 public void BulkEdit_DeleteUpcharge() throws InterruptedException{
	  try{
	  
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1108 = (JavascriptExecutor)driver;
		 	 jse1108.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1119 = (JavascriptExecutor)driver;
		 	 jse1119.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse11101 = (JavascriptExecutor)driver;
		 	 jse11101.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	 
		 	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		     
		    Thread.sleep(3000);
		 	 
		 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			  Thread.sleep(1000);
			    
			 //Press the bulk edit button
				driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
			        
			        Thread.sleep(3000);
						
			 		List<WebElement> li10= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
			 		li10.get(2).click();
			
					Thread.sleep(1000);
					
			//Select Delete Upcharge Option from bulk Edit
					driver.findElement(By.xpath(Testelements.DeleteUpcharge_BulkEditoption)).click();
					
					Thread.sleep(1000);
			  
					//Now Press the bulk Edit Button
		    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
		  		    li8.get(8).click();
		  			
		  		    waitForPageLoad();
		  		    
		  		    Thread.sleep(3000);
		  		    
		  		    driver.findElement(By.xpath(Testelements.BulkEdit_DeleteUpcharge_ProductColorSelection)).click();
		  		    
		  		    Thread.sleep(1000);
		  		    
		  		    driver.findElement(By.xpath(Testelements.BulkEdit_DeleteUpcharge_NextStep_Button)).click();
		  		    
		  		    waitForPageLoad();
		  		    
		  		    Thread.sleep(3000);
		  		    
		  		    driver.findElement(By.xpath(Testelements.ColorSelection_BulkEdit_DeleteUpcharges)).click();
		  		    
		  		    Thread.sleep(1000);
		  		    
		  		  driver.findElement(By.xpath(Testelements.DeleteUpcharge_Type)).sendKeys("Product Color Charge");
		  		  
		  		  Thread.sleep(3000);
		  		  
		  		driver.findElement(By.xpath(Testelements.DeleteUpcharge_Type)).sendKeys(Keys.ENTER);
		  		  
		  		  Thread.sleep(1000);
		  		  
		  		  
		  		  //click the all currency radio option
		  		  driver.findElement(By.xpath(Testelements.DeleteUpcharge_AllCurrencyRadioButton)).click();
		  		  
		  		  Thread.sleep(1000);
		  		  
		  		  driver.findElement(By.xpath(Testelements.DeleteandApply_BulkDeleteUpcharge)).click();
		  		  
		  		wait = new WebDriverWait(driver, 180);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
				     
				Thread.sleep(3000);
		 	  		    
		 	   driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 
		 	   
		 	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
		 	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		 	  	   
		 	  	   waitForPageLoad();
		 	  	   
		 	  	   Thread.sleep(1000);
		 	  	   
		 	  	   waitForPageLoad();
		 	  	   
		 	  	   Thread.sleep(1000);
		 	  //Press the pricing tab
		 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
		 	      
		 	     waitForPageLoad();
		 	      
		 	      Thread.sleep(1000);
		  		  
		 	     driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
		 		
		 	     Thread.sleep(2000);
		 		
		 	   // WebElement NewAddUpcharge_ThroughBulk=driver.findElement(By.xpath(Testelements.BrownAddUpchargeBulk_Verification));
		 		 // String AddUpcharge_Verification=NewAddUpcharge_ThroughBulk.getAttribute("value");
		 		  
		 		   //System.out.println(AddUpcharge_Verification);

		 	     
		 	     List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.DeleteUpcharge_ThroughBulk_Verification));
			       
			       int count=elementcount.size();
			       
			       System.out.println(count);
			       
			       if(count==0)
			       {
			        System.out.println("Bulk Delete Upcharges Operation Done Successfully");   
			     	  
			        test = extent.createTest("BulkEdit_DeleteUpcharge");
	 			   	
		 			test.log(Status.PASS, "Bulk Delete Upcharges Operation Done Successfully");
			       }   
			       else{
			    	   System.out.println("Bulk Delete Upcharges Operation Done UnSuccessfully");   
				     	  
				        test = extent.createTest("BulkEdit_DeleteUpcharge");
		 			   	
			 			test.log(Status.FAIL, "Bulk Delete Upcharges Operation Done UnSuccessfully"); 
			       }
			  
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 
 @Test(priority=14)
 public void ChangeCurrency_ThroughBulkEdit() throws InterruptedException{
	  try{
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	
		 	//Wait for the alert to appear
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		       
		       Thread.sleep(2000);
		  
		       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			    Thread.sleep(1000);
			    
			    
			    //Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BulkEdit_ChangeCurrency)).click();
	  			
	  			Thread.sleep(1000);
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		  WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.CurrencyTypeFrom_BulkEdit_ChangeCurrency));
		  	  Select dropdown72= new Select(mySelectElement72);
	          dropdown72.selectByVisibleText("Canadian Dollar");
	          
	          WebElement mySelectElement73 = driver.findElement(By.xpath(Testelements.CurrencyTypeTo_BulkEdit_ChangeCurrency));
		  	  Select dropdown73= new Select(mySelectElement73);
	          dropdown73.selectByVisibleText("Yen");
	          
	          driver.findElement(By.xpath(Testelements.CurrencySaveandApply_ChangeCurrencyBulkEdit)).click();
	          
	          wait = new WebDriverWait(driver, 180);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			  Thread.sleep(3000);
	 	  		    
	 	  	  driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 
	 	  	  
	 	  	 driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  //Press the pricing tab
	 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	 	      
	 	     
	 	      waitForPageLoad();
	 	      
	 	      Thread.sleep(1000);
	 	      
	 	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	 		
	 	    Thread.sleep(2000); 
	 	    
	 	  //Validate if the checkbox for QUR is checked or not for usd grid
	 	    if(driver.findElement(By.xpath(Testelements.ChangeCurrencyVerification_BasePricing_Grid1)).getText().contains("Yen"))
	 	    {
	 	    	System.out.println("Bulk Edit Change Currency on Base Pricing grid 1 changes Successfully ");
	 	    	
	 	    	 test = extent.createTest("BulkEdit_ChangeCurrency_BasePricing_Grid1");
	 	     	 
	 	     	  test.log(Status.PASS, "Bulk Edit Change Currency on Base Pricing grid 1 changes Successfully");
	 	    	
	 	    }
	 	    else{
	 	    	System.out.println("Bulk Edit Change Currency on Base Pricing grid 1 changes UnSuccessfully");
	 	    
	 	    	 test = extent.createTest("BulkEdit_ChangeCurrency_BasePricing_Grid1");
	 	     	 
	 	     	test.log(Status.FAIL, "Bulk Edit Change Currency on Base Pricing grid 1 changes UnSuccessfully");
	 	    
	 	    }
	 	
	 	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	 		
	 	  Thread.sleep(2000); 

	 	 if(driver.findElement(By.xpath(Testelements.ChangeCurrencyVerification_BasePricing_Grid2)).getText().contains("Yen"))
	 	    {
	 	    	System.out.println("Bulk Edit Change Currency on Base Pricing grid 2 changes Successfully ");
	 	   
	 	    	 test = extent.createTest("BulkEdit_ChangeCurrency_BasePricing_Grid2");
	 	     	 
	 	     	 test.log(Status.PASS, "Bulk Edit Change Currency on Base Pricing grid 2 changes Successfully");
	 	    }
	 	    else{
	 	    	System.out.println("Bulk Edit Change Currency on Base Pricing grid 2 changes UnSuccessfully");
	 	    
	 	    	test = extent.createTest("BulkEdit_ChangeCurrency_BasePricing_Grid2");
	 	     	 
	 	     	test.log(Status.FAIL, "Bulk Edit Change Currency on Base Pricing grid 2 changes UnSuccessfully");
	 	    }
     	  
	 	//Scroll up
	 	 JavascriptExecutor jse11021 = (JavascriptExecutor)driver;
	 	 jse11021.executeScript("window.scrollBy(0,-250)", "");
	 	 
	 	//Scroll up
	 	 JavascriptExecutor jse11131 = (JavascriptExecutor)driver;
	 	 jse11131.executeScript("window.scrollBy(-250,-500)", "");
	 	 
	 	
	 	JavascriptExecutor jse11141 = (JavascriptExecutor)driver;
	 	 jse11141.executeScript("window.scrollBy(-500,-750)", "");
	 	 
	 	JavascriptExecutor jse111412 = (JavascriptExecutor)driver;
	 	 jse111412.executeScript("window.scrollBy(-750,-1000)", "");
	 	 
	 	 
	 	 Thread.sleep(2000);
	 	 
	 	driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
		
		Thread.sleep(2000);
	  
		driver.findElement(By.xpath(Testelements.Upcharge_AllGridsExpand)).click();
		  
		Thread.sleep(2000);
		
		List<WebElement> ChangeCurrencyVerification = driver.findElements(By.xpath(Testelements.ChangeCurrencyVerification_Upcharges));
	    
		if(ChangeCurrencyVerification.get(8).getText().contains("Yen (JPY)") & ChangeCurrencyVerification.get(11).getText().contains("Yen (JPY)"))
		{
			System.out.println("Bulk Edit Change Currency on Upcharge Pricing grid 1 and 2 changes Successfully ");
		 	   
	    	 test = extent.createTest("BulkEdit_ChangeCurrency_UpchargePricing_Grid1&2");
	     	 
	     	 test.log(Status.PASS, "Bulk Edit Change Currency on Upcharge Pricing grid 1 and 2 changes Successfully");	
		}
		else{
			
			System.out.println("Bulk Edit Change Currency on Upcharge Pricing grid 1 and 2 changes Successfully ");
		 	   
	    	 test = extent.createTest("BulkEdit_ChangeCurrency_UpchargePricing_Grid1&2");
	     	 
	     	 test.log(Status.FAIL, "Bulk Edit Change Currency on Upcharge Pricing grid 1 and 2 changes UnSuccessfully");
		}
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
 }
 
 }
 @Test(priority=15)
 public void DeleteCurrency_ThroughBulkEdit() throws InterruptedException{
	  try{
		  driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		    
			 //Scroll up
		 	 JavascriptExecutor jse1102 = (JavascriptExecutor)driver;
		 	 jse1102.executeScript("window.scrollBy(0,-250)", "");
		 	 
		 	//Scroll up
		 	 JavascriptExecutor jse1113 = (JavascriptExecutor)driver;
		 	 jse1113.executeScript("window.scrollBy(-250,-500)", "");
		 	 
		 	
		 	JavascriptExecutor jse1114 = (JavascriptExecutor)driver;
		 	 jse1114.executeScript("window.scrollBy(-500,-750)", "");
		 	 
		 	 Thread.sleep(2000);
		 	
		 	//Wait for the alert to appear
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		       
		       Thread.sleep(2000);
		  
		       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			    Thread.sleep(1000);
			    
			    
			    //Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
	  	        
	  	        Thread.sleep(3000);
	  				
	  	 		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	  	 		li9.get(2).click();
	  	
	  			Thread.sleep(1000);
	  			
	  		//Select the Base Pricing
	  			driver.findElement(By.xpath(Testelements.BulkEdit_RemoveCurrency)).click();
	  			
	  			Thread.sleep(1000);
	  			
	  	   
	  		//Now Press the bulk Edit Button
	    		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
	  		    li8.get(8).click();
	  			
	  		    Thread.sleep(2000);
	  		    
	  		  List<WebElement> SelectCurrencyDropdown = driver.findElements(By.xpath(Testelements.BulkCurrencySelection_RemoveCurrency));
	  		  SelectCurrencyDropdown.get(3).click();
	          
	  		List<WebElement> SelectCurrencySelection = driver.findElements(By.xpath(Testelements.AusCurrencySelection_BulkEditRemoveCurrency));
	  		SelectCurrencySelection.get(3).click();
	          
	          driver.findElement(By.xpath(Testelements.SaveandApply_BulkEdit_RemoveCurrency)).click();
	          
	          wait = new WebDriverWait(driver, 180);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
			     
			  Thread.sleep(3000);
	 	  		    
	 	  	  driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 
	 	  	  
	 	  	 driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  	   
	 	  	   waitForPageLoad();
	 	  	   
	 	  	   Thread.sleep(1000);
	 	  //Press the pricing tab
	 	  	 driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	 	      
	 	     
	 	      waitForPageLoad();
	 	      
	 	      Thread.sleep(1000);
	 	      
	 	    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	 		
	 	    Thread.sleep(2000); 
	 	    
	 	   List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.ChangeCurrencyVerification_BasePricing_Grid1));
	       
	       int count=elementcount.size();
	       
	       System.out.println(count);
	 	    
	 	  //Validate if the checkbox for QUR is checked or not for usd grid
	 	    if(count==0)
	 	    {
	 	    	System.out.println("Bulk Edit Remove Currency on Base Pricing grid 1 changes Successfully ");
	 	    	
	 	    	 test = extent.createTest("BulkEdit_RemoveCurrency_BasePricing_Grid1");
	 	     	 
	 	     	  test.log(Status.PASS, "Bulk Edit Remove Currency on Base Pricing grid 1 changes Successfully");
	 	    	
	 	    }
	 	    else{
	 	    	System.out.println("Bulk Edit Remove Currency on Base Pricing grid 1 changes UnSuccessfully");
	 	    
	 	    	 test = extent.createTest("BulkEdit_RemoveCurrency_BasePricing_Grid1");
	 	     	 
	 	     	test.log(Status.FAIL, "Bulk Edit Remove Currency on Base Pricing grid 1 changes UnSuccessfully");
	 	    
	 	    }
	 	
	 	  driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	 		
	 	  Thread.sleep(2000); 
	 	  
	 	 List <WebElement> elementcount2 = driver.findElements(By.xpath(Testelements.ChangeCurrencyVerification_BasePricing_Grid2));
	       
	       int count2=elementcount2.size();
	       
	       System.out.println(count2);

	 	 if(count2==0)
	 	    {
	 	    	System.out.println("Bulk Edit Remove Currency on Base Pricing grid 2 changes Successfully ");
	 	   
	 	    	 test = extent.createTest("BulkEdit_RemoveCurrency_BasePricing_Grid2");
	 	     	 
	 	     	 test.log(Status.PASS, "Bulk Edit Remove Currency on Base Pricing grid 2 changes Successfully");
	 	    }
	 	    else{
	 	    	System.out.println("Bulk Edit Change Currency on Base Pricing grid 2 changes UnSuccessfully");
	 	    
	 	    	test = extent.createTest("BulkEdit_RemoveCurrency_BasePricing_Grid2");
	 	     	 
	 	     	test.log(Status.FAIL, "Bulk Edit Remove Currency on Base Pricing grid 2 changes UnSuccessfully");
	 	    }
     	  
	 	//Scroll up
	 	 JavascriptExecutor jse11021 = (JavascriptExecutor)driver;
	 	 jse11021.executeScript("window.scrollBy(0,-250)", "");
	 	 
	 	//Scroll up
	 	 JavascriptExecutor jse11131 = (JavascriptExecutor)driver;
	 	 jse11131.executeScript("window.scrollBy(-250,-500)", "");
	 	 
	 	
	 	JavascriptExecutor jse11141 = (JavascriptExecutor)driver;
	 	 jse11141.executeScript("window.scrollBy(-500,-750)", "");
	 	 
	 	JavascriptExecutor jse111412 = (JavascriptExecutor)driver;
	 	 jse111412.executeScript("window.scrollBy(-750,-1000)", "");
	 	 
	 	 
	 	 Thread.sleep(2000);
	 	 
	 	driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
		
		Thread.sleep(2000);
	  
		driver.findElement(By.xpath(Testelements.Upcharge_AllGridsExpand)).click();
		  
		Thread.sleep(2000);
		
		List<WebElement> UpchargeRemoveCurrency=driver.findElements(By.xpath(Testelements.ChangeCurrencyVerification_Upcharges));
		
		int count3=UpchargeRemoveCurrency.size();
	       
	       System.out.println(count3);
		
		//List<WebElement> ChangeCurrencyVerification = driver.findElements(By.xpath(Testelements.ChangeCurrencyVerification_Upcharges));
	    
		if(count3!=12)
		{
			System.out.println("Bulk Edit Remove Currency on Upcharge Pricing grid 1 and 2 changes Successfully ");
		 	   
	    	 test = extent.createTest("BulkEdit_RemoveCurrency_UpchargePricing_Grid1&2");
	     	 
	     	 test.log(Status.PASS, "Bulk Edit Remove Currency on Upcharge Pricing grid 1 and 2 changes Successfully");	
		}
		else{
			
			System.out.println("Bulk Edit Remove Currency on Upcharge Pricing grid 1 and 2 changes Successfully ");
		 	   
	    	 test = extent.createTest("BulkEdit_RemoveCurrency_UpchargePricing_Grid1&2");
	     	 
	     	 test.log(Status.FAIL, "Bulk Edit Remove Currency on Upcharge Pricing grid 1 and 2 changes UnSuccessfully");
		}
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
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

 
public static void Hover(WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
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
 
public static void ListPrice_Grid1_String_To_Integer() throws ParseException{
	   
	//Converting subtotal from string to int
	ListPriceValue_Grid1=driver.findElement(By.xpath(Testelements.MG_ListPrice1));
	ListPriceValueVerification_Grid1=ListPriceValue_Grid1.getAttribute("value");

	System.out.println(ListPriceValueVerification_Grid1);
	   	 
	   ListPrice=Double.parseDouble(ListPriceValueVerification_Grid1.toString());
	   System.out.println(ListPrice);
   }
public static void ListPrice_Grid2_String_To_Integer() throws ParseException{
	   
	
	    
	   //Converting subtotal from string to int
	ListPriceValue_Grid2=driver.findElement(By.xpath(Testelements.MG_ListPrice2));
	ListPriceValueVerification_Grid2=ListPriceValue_Grid2.getAttribute("value");

	System.out.println(ListPriceValueVerification_Grid2);
	   	 
	   	 
	   	 
	   	 ListPrice=Double.parseDouble(ListPriceValueVerification_Grid2.toString());
	   	 System.out.println(ListPrice);
}

public static void NetCost_Grid1_String_To_Integer() throws ParseException{
	   
	
	    
	   //Converting subtotal from string to int
	NetCost_Grid1=driver.findElement(By.xpath(Testelements.Netcost_USCurrency_Grid1));
	NetCostVerification_Grid1=NetCost_Grid1.getAttribute("value");

	System.out.println(NetCostVerification_Grid1);
	   	 
	   	 
	   	 
	   	 NetCost=Double.parseDouble(NetCostVerification_Grid1.toString());
	   	 System.out.println(NetCost);
}
public static void NetCost_Grid2_String_To_Integer() throws ParseException{
	   
	
    
	   //Converting subtotal from string to int
	NetCost_Grid2=driver.findElement(By.xpath(Testelements.Netcost_USCurrency_Grid2));
	NetCostVerification_Grid2=NetCost_Grid2.getAttribute("value");

	System.out.println(NetCostVerification_Grid2);
	   	 
	   	
	   	 NetCost=Double.parseDouble(NetCostVerification_Grid2.toString());
	   	 System.out.println(NetCost);
}

public static void ListPrice_Calculation_70Percent(){
	a=70*0.01;
	bd=new BigDecimal(a);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	b=1-a;
	bd=new BigDecimal(b);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	
	
	
	
	ListPrice = (NetCost/bd.doubleValue());
	System.out.println("List Price with 70% is"+ListPrice);
}

public static void ListPrice_Calculation_50Percent(){
	
	a=50*0.01;
	bd=new BigDecimal(a);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	b=1-a;
	bd=new BigDecimal(b);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	
	
	
	
	ListPrice = (NetCost/bd.doubleValue());
	System.out.println("List Price with 50% is"+ListPrice);
}

public static void NetCost_Calculation_70Percent(){
	
	a=70*0.01;
	bd=new BigDecimal(a);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	b=1-a;
	bd=new BigDecimal(b);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	
	
	
	NetCost = ListPrice * bd.doubleValue();
	System.out.println("NetCost with 70% is"+NetCost);
}
public static void NetCost_Calculation_50Percent(){
	
	a=50*0.01;
	bd=new BigDecimal(a);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	b=1-a;
	bd=new BigDecimal(b);
	bd = bd.setScale(3, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	
	
	
	NetCost = ListPrice * bd.doubleValue();
	System.out.println("NetCost with 50% is"+NetCost);
}

public static void RoundingOffTotalAmount_ListPrice(){
	
	bd=new BigDecimal(ListPrice);
	bd = bd.setScale(3, RoundingMode.FLOOR);
	System.out.println(bd.doubleValue());
	
	
}

public static void RoundingOffTotalAmount_NetCost(){
	
	bd2=new BigDecimal(NetCost);
	bd2 = bd2.setScale(3, RoundingMode.FLOOR);
	System.out.println(bd2.doubleValue());
	
	
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


