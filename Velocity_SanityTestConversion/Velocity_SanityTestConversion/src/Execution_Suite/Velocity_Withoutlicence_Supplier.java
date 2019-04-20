package Execution_Suite;


import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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



public class Velocity_Withoutlicence_Supplier {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	Robot rb;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	JavascriptExecutor js;
	WebElement toClear;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		
           if(browser.equalsIgnoreCase("firefox")) {
			
        	FirefoxBinary binary=new FirefoxBinary();
        	binary.addCommandLineOptions("--headless");
        	WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.setBinary(binary);
			driver = new FirefoxDriver(fo);
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/VelocityWithoutLicenceSupplierReport"+".html");
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
   			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/VelocityWithoutLicenceSupplierReport"+".html");
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
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/VelocityWithoutLicenceSupplierReport"+".html");
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
		   driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		
		
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
    driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberStage);
    
    //Insert the username
    driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameStage);
    
    //Insert the Password
    driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordStage);
    
    }
    else if(driver.getCurrentUrl().contains("uat")){
    	
    	//Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberUAT);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameUAT);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordUAT);
    }
    
    else{
    	
    	//Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vASINumberProd);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vUserNameProd);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vPasswordProd);
    }
    
    //Press the login Button
    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
    
    wait = new WebDriverWait(driver, 120);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)));
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.xpath(Testelements.LoginSuccessfullValidation_Supplier)).isDisplayed()){
    System.out.println("Supplier Loggedin Successfully");
    test = extent.createTest("Login");
   
   	test.log(Status.PASS, "Supplier Loggedin Successfully");
    }
    else{
    	 System.out.println("Supplier Loggedin UnSuccessfully");
    	test = extent.createTest("Login");
    	   
       	test.log(Status.FAIL, "Supplier Loggedin UnSuccessfully");
    }
	
    
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace(); 
    }
  }  
   
  @Test(priority=1)
  public void EspLogoCheck() throws InterruptedException{
  	
  	try{
  		
  	//Wait for the logo to appear
  	
  	wait = new WebDriverWait(driver, 240);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EspLogo)));
      
      Thread.sleep(1000);
     if(driver.findElement(By.cssSelector(Testelements.EspLogo)).isDisplayed()){
      System.out.println("ESP Logo Displayed Successfully");
      
      test = extent.createTest("EspLogoCheck");
    
  	  test.log(Status.PASS, "Esp Logo Displayed sucessfully");
     }
     else{
    	 System.out.println("ESP Logo Displayed Unsuccessfully");
    	 
    	 test = extent.createTest("EspLogoCheck");
        
     	test.log(Status.FAIL, "Esp Logo Displayed unsucessfully");

     }
      
  	
      
      }    
      //Catch the exception if any
      catch(NoSuchElementException e){
      	e.getStackTrace();
      	
      }
  	
  	}
 
 @Test(priority=2)
  public void SupplierInfo() throws InterruptedException{
    try{
    wait = new WebDriverWait(driver, 240);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SupplierInfo_page)));
    
    //Click the supplier info page tab
    driver.findElement(By.xpath(Testelements.SupplierInfo_page)).click();
    
   //Wait
    
  	 Thread.sleep(1000);
 
    
    if(driver.findElement(By.cssSelector(Testelements.PerformanceRatingText_SupplierInfoScreen)).isDisplayed()){
   
    	System.out.println("Supplier Page Displayed Successfully"); 
    	
    	test = extent.createTest("SupplierInfoPage");
    	    
    	test.log(Status.PASS, "Supplier Info page Displayed sucessfully");
    }
    else{
    	
    	System.out.println("Supplier Page Displayed UnSuccessfully"); 
    	 
    	test = extent.createTest("SupplierInfoPage");
 	    
 	  	test.log(Status.FAIL, "Supplier Info page Displayed unsucessfully");
    }
    	
    	
    	
    	//Scroll down
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)", "");
    
  
  	Thread.sleep(1000);
  	
    
    //Scroll Page Up
    JavascriptExecutor jse20 = (JavascriptExecutor)driver;
    jse20.executeScript("window.scrollBy(0,-250)", "");
    
   
  	Thread.sleep(1000);
 
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
  }
  }

  @Test(priority=3)
  public void HelpLicenceAgreement() throws InterruptedException{
       try{
    //Press the help tab at top right corner
    
    driver.findElement(By.cssSelector(Testelements.Help)).click();
    
    
  	Thread.sleep(1000);
  

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
 		
 	 test.log(Status.FAIL, "Help Licence Agreement Note displayed Unsuccessful");
  }
  
  
  driver.findElement(By.cssSelector(Testelements.Licenceclosed)).click();

  }    
  //Catch the exception if any
  catch(NoSuchElementException e){
  	e.getStackTrace();
  	
      
  
  }

  }

  @Test(priority=4)
  public void HelpandSupport() throws InterruptedException{
	  try{
	  Thread.sleep(1000);
	  
	//Press the help again
	  driver.findElement(By.cssSelector(Testelements.Help)).click();
	  
    //Press the prodcut support option
	  driver.findElement(By.xpath(Testelements.ProductSupport)).click();
	  
	//Opens the product support in new tab
	  //First store parent window to switch back
	    Set<String> handles= driver.getWindowHandles();
	    
	   Iterator<String> it= handles.iterator();
	   
	   String parentwindow= it.next();
	  
	   System.out.println("Parent Window ID:"+parentwindow);
	  
	   String childwindow =it.next();
	 
	   System.out.println("Child Window ID:"+childwindow);
	   
	   driver.switchTo().window(childwindow);
	   
	   wait = new WebDriverWait(driver, 240);
	   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ProductSupportValidationCheck)));
	  	
	  	Thread.sleep(2000);
	  if(driver.findElement(By.cssSelector(Testelements.ProductSupportValidationCheck)).isDisplayed()){
		  System.out.println("Product Support Page Displayed Successfully");
		  
		  test = extent.createTest("HelpandSupport");
		   	
		   test.log(Status.PASS, "Help page Sucessfully opened ");
		  
	  }
	  else{
		  
         System.out.println("Product Support Page Displayed UnSuccessfully");
		  
		  test = extent.createTest("HelpandSupport");
		   	
		   test.log(Status.FAIL, "Help page not Sucessfully opened "); 
	  }
	  	
	  	
	  	driver.close();
	  	
	  	//Switch back to parent window 
	      driver.switchTo().window(parentwindow);
 
       Thread.sleep(2000);
	 
      }catch(NoSuchElementException e){
		  e.getStackTrace();
		
	  }
	  
	  }
  @Test(priority=5)
  public void AddUpdate_Product() throws InterruptedException{
  	try{
  	
  		
  	//Click the manage product tab
  	driver.findElement(By.xpath(Testelements.Manage_Product_Tab)).click();
      //Wait for the process to complete	    	
  	wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProduct_button)));
      
    //First store parent window to switch back
    String parentWindow = driver.getWindowHandle();

    Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.AddProduct_button)).click();
      
      String[] expected = {"Select a product type","- tes !. /","Automotive Accessories", "Awards & Trophies", "Baby, Toddler, & Child Items", "Bags & Luggage", "Caps & Hats", "Drinkware", "Electronics & Tech Products","Equipment and Business Services","Food, Beverage, & Tobacco","Health, Beauty & Wellness","Holiday & Religious Items","Home & Garden","Jewelry and Accessories","Key Chains","Kitchen & Dining","Lanyards, Badges, & Badge Holders","Magnets & Buttons, Stickers & Decals","Party Supplies","Pet Supplies","Publications","School, Office, & Craft Supplies","Signs, Banners, Flags, & Displays","Sports, Fitness, & Outdoors","Storage & Organization","Tools & Hardware","Toys, Games, & Novelties","Writing Instruments","e type","period, ., ?, colon, ;, !, - , /","test 1","Other"};
     
      Select select=new Select(driver.findElement(By.xpath(Testelements.ProductType)));
      
      List<WebElement>dropdownvalues=select.getOptions();
      
      System.out.println(dropdownvalues.size());
      
      for(int j=0;j<dropdownvalues.size();j++)
      {
    	  if(expected[j].equals(dropdownvalues.get(j).getText()))
    	  {	  
    	   
    	  
    	  System.out.println("Verification of values at Position"+dropdownvalues.get(j).getText()+"Matches Successfully");
      
      }
      else{
    	  System.out.println("Verification of values at Position"+dropdownvalues.get(j).getText()+"Matches UnSuccessfully"); 
      }
      
      } 
    
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
  	WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.ProductType));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Automotive Accessories");

      Thread.sleep(1000);
      
      driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
       
      Thread.sleep(2000);
      
      
      
      //Press the apply button to add the product
      driver.findElement(By.cssSelector(Testelements.AddProduct_Applybutton)).click();

      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Basicdetails)));
      
      //Wait all tabs to be enabled
      driver.findElement(By.cssSelector(Testelements.Product_Basicdetails)).isEnabled();
      
      waitForPageLoad();
      
      Thread.sleep(3000);
      
      //Validate New Flag should be displayed to customer type supplier
     
      if(driver.getPageSource().contains("Inventory Not Applicable"))
      {
    	  System.out.println("Inventory Not Applicable Option Displayed Successfully");
      
    	  test = extent.createTest("InventoryNotApplicable_OptionVerification");
		   	
		 test.log(Status.PASS, "Inventory Not Applicable Option Displayed Successfully");
      }
      else{
    	  System.out.println("Inventory Not Applicable Option Displayed UnSuccessfully");
          
    	  test = extent.createTest("InventoryNotApplicable_OptionVerification");
		   	
		 test.log(Status.FAIL, "Inventory Not Applicable Option Displayed UnSuccessfully");
      }
     
      //Switch back to parent window 
      driver.switchTo().window(parentWindow);
      
      waitForPageLoad();
  		//Thread.sleep(40000);
  	  //Update Product Name with special Characters
  		
  		
  	  driver.findElement(By.xpath(Testelements.ProductName_BasicDetails)).sendKeys("(R)(C)(TM)");
  	  
  	  driver.findElement(By.cssSelector(Testelements.Product_Number)).click();
  	  
  	  WebElement ProductNumber_SpecialCharacters=driver.findElement(By.xpath(Testelements.ProductName_BasicDetails));
	  String SpecialCharacter=ProductNumber_SpecialCharacters.getAttribute("value");
	  
	   System.out.println(SpecialCharacter);
  	  
	   if(SpecialCharacter.contains("®©™"))
	   {
		   System.out.println("Product Name Convert to Special Characters Successfully");
		   
		   test = extent.createTest("ProductName_SpecialCharacters_Verification");
		   	
		   test.log(Status.PASS, "Product Name Convert to Special Characters Successfully ");
	   }
	   else{
          System.out.println("Product Name Convert to Special Characters UnSuccessfully");
		   
		   test = extent.createTest("ProductName_SpecialCharacters_Verification");
		   	
		   test.log(Status.FAIL, "Product Name Convert to Special Characters UnSuccessfully ");
		   
	   }
     //Insert the product number
      driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber+""+"®©™");
      
      Thread.sleep(1000);
      
      driver.findElement(By.xpath(Testelements.ProductNumberTextClick)).click();
      
      if(driver.findElement(By.xpath(Testelements.PreventSpecialCharactersVerification)).getText().contains("Cannot use the symbol(s): [©®™]"))
      {
    	  System.out.println("Special Characters are restricted in Product Number Field Successfully");
    	  
    	  test = extent.createTest("ProductNumber_SpecialCharacters_Restriction Verification");
		   	
		   test.log(Status.PASS, "Special Characters are restricted in Product Number Field Successfully ");
    	  
      }
      else{
    	  
          System.out.println("Special Characters are restricted in Product Number Field UnSuccessfully");
    	  
    	  test = extent.createTest("ProductNumber_SpecialCharacters_Restriction Verification");
		   	
		   test.log(Status.FAIL, "Product Name Convert to Special Characters UnSuccessfully ");
      }
      
      //Insert UPC code
      driver.findElement(By.cssSelector(Testelements.UPCCode)).sendKeys(Testdata.UPCCode);
      
      driver.findElement(By.cssSelector(Testelements.BasicDetails_SKUField)).sendKeys("12"+""+"®©™");
	   
	   Thread.sleep(1000);
	   
	   driver.findElement(By.cssSelector(Testelements.SKUField_BasicDetails_Displayed)).click();
	   
	   Thread.sleep(1000);
	   
	   if(driver.findElement(By.xpath(Testelements.SpecialCharactersSKU_RestrictionVerification)).getText().contains("Cannot use the symbol(s): [©®™]"))
	      {
	    	  System.out.println("Special Characters are restricted in SKU Field Successfully");
	    	  
	    	  test = extent.createTest("SKU_SpecialCharacters_Restriction Verification");
			   	
			   test.log(Status.PASS, "Special Characters are restricted in SKU Field Successfully ");
	    	  
	      }
	      else{
	    	  
	          System.out.println("Special Characters are restricted in SKU Field UnSuccessfully");
	    	  
	    	  test = extent.createTest("SKU_SpecialCharacters_Restriction Verification");
			   	
			   test.log(Status.FAIL, "SKU Convert to Special Characters UnSuccessfully ");
	      }
      
     
	   
		   //Update summary field with special characters and validate it
      driver.findElement(By.xpath(Testelements.Product_FullDescription_BasicDetails)).sendKeys("(R)(C)(TM)");
      
      driver.findElement(By.cssSelector(Testelements.Product_Summary)).click();
      
      WebElement ProductFullDescription_SpecialCharacters=driver.findElement(By.xpath(Testelements.Product_FullDescription_BasicDetails));
	  String ProductFullDescription_SpecialCharConv=ProductFullDescription_SpecialCharacters.getAttribute("value");
	  
	   System.out.println(ProductFullDescription_SpecialCharConv);
	   
	   if(ProductFullDescription_SpecialCharConv.contains("®©™"))
	   {
		   System.out.println("Product FullDesciption Convert to Special Characters Successfully");
		   
		   test = extent.createTest("ProductFullDesciption_SpecialCharacters_Verification");
		   	
		   test.log(Status.PASS, "Product FullDesciption Convert to Special Characters Successfully ");
	   }
	   else{
          System.out.println("Product FullDesciption Convert to Special Characters UnSuccessfully");
		   
		   test = extent.createTest("ProductFullDesciption_SpecialCharacters_Verification");
		   	
		   test.log(Status.FAIL, "Product FullDesciption Convert to Special Characters UnSuccessfully ");
		   
	   }
	   
	   
	   
      //Insert the product summary
      driver.findElement(By.cssSelector(Testelements.Product_Summary)).sendKeys("This is a velocity Test Product (R)(C)(TM) ");
      
      driver.findElement(By.xpath(Testelements.Summary_OuterArea)).click();
      
      WebElement ProductSummary_SpecialCharacters=driver.findElement(By.cssSelector(Testelements.Product_Summary));
	  String ProductFullSummary_SpecialCharConv=ProductSummary_SpecialCharacters.getAttribute("value");
	  
	   System.out.println(ProductFullSummary_SpecialCharConv);
	   
	   if(ProductFullSummary_SpecialCharConv.contains("®©™"))
	   {
		   System.out.println("Product Summary Convert to Special Characters Successfully");
		   
		   test = extent.createTest("ProductSummary_SpecialCharacters_Verification");
		   	
		   test.log(Status.PASS, "Product Summary Convert to Special Characters Successfully ");
	   }
	   else{
          System.out.println("Product Summary Convert to Special Characters UnSuccessfully");
		   
		   test = extent.createTest("ProductSummary_SpecialCharacters_Verification");
		   	
		   test.log(Status.FAIL, "Product Summary Convert to Special Characters UnSuccessfully ");
		   
	   }
      
     //Select the Inventory status to Back Order/Out of stock
	   WebElement StatusInfo = driver.findElement(By.xpath(Testelements.InventoryStatus_BasicDetail));
	    Select StatusInfoValue= new Select(StatusInfo);
	     
	    StatusInfoValue.selectByVisibleText("Back Order/Temporarily Out Of Stock");
	   
	    WebElement QuantityForStatus=driver.findElement(By.xpath(Testelements.InventoryQuantity_BasicDetail));
		String QuantityValue=QuantityForStatus.getAttribute("value");
		  
		   System.out.println(QuantityValue);
		   
		   if(QuantityValue.contains("0"))
		   {
			   System.out.println("Back Order/Temporarily Out Of Stock quantity displayed 0 Successfully");
			   
			   test = extent.createTest("Back Order/Temporarily Out Of Stock_Quantity_Verification");
			   	
			   test.log(Status.PASS, "Back Order/Temporarily Out Of Stock quantity displayed 0 Successfully ");
		   }
		   else{
	          System.out.println("Back Order/Temporarily Out Of Stock quantity displayed 0  UnSuccessfully");
			   
			   test = extent.createTest("Back Order/Temporarily Out Of Stock_Quantity_Verification");
			   	
			   test.log(Status.FAIL, "Back Order/Temporarily Out Of Stock quantity displayed 0  UnSuccessfully ");
			   
		   }
	   //First store parent window to switch back
      String parentWindow1 = driver.getWindowHandle(); 
      
    //Scroll down
      JavascriptExecutor jse80 = (JavascriptExecutor)driver;
      jse80.executeScript("window.scrollBy(0,250)", "");
      
      Thread.sleep(1000);
      //Open the category popup
      driver.findElement(By.cssSelector(Testelements.Productcategory_dropdown)).click();
      
    //Switch to new window opened
  	for(String winHandle : driver.getWindowHandles()){
  	    if(!winHandle.equals(parentWindow1)) {
  	        driver.switchTo().window(winHandle);
  	    }
  	}
      
     Thread.sleep(3000);
    
    
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
     
      
      Thread.sleep(1000);
      
     //Insert compliance and safety name
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys("ANSI");
      
      Thread.sleep(4000);
      
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys(Keys.ENTER);
      
      Thread.sleep(1000);
      
      //Insert compliance and safety name
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys("FLA");
      
      Thread.sleep(4000);
      
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys(Keys.ENTER);
      
      Thread.sleep(1000);
      
      //Insert compliance and safety name
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys("QCA");
      
      Thread.sleep(4000);
      
      driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails)).sendKeys(Keys.ENTER);
      
      Thread.sleep(1000);
      
      WebElement NoQCAAdded_InComplainceField=driver.findElement(By.xpath(Testelements.ComplianceField_BasicDetails));
      String Complaince_QCA_Value_Verification=NoQCAAdded_InComplainceField.getAttribute("value");
      
      System.out.println(Complaince_QCA_Value_Verification);
      
      if(!Complaince_QCA_Value_Verification.contains("QCA"))
      {
    	  System.out.println("QCA Value is not displayed in Safety&Compliance so it is not added into field");
    	  
    	  test = extent.createTest("No_QCA_Value_Verification_Safety&Compliance");
		   	
		  test.log(Status.PASS, "QCA Value is not displayed in Safety&Compliance so it is not added into field ");
    	  
      }
      else{
          System.out.println("QCA Value is displayed in Safety&Compliance so it is added into field");
    	  
    	  test = extent.createTest("No_QCA_Value_Verification_Safety&Compliance");
		   	
		  test.log(Status.FAIL, "QCA Value is displayed in Safety&Compliance so it is added into field ");
      }
      //Select the Prop65 for warnings
      driver.findElement(By.xpath(Testelements.Prop65_basicDetails_Checkbox)).click();
      
      Thread.sleep(2000);
      
      //Press the Make Active Button
      driver.findElement(By.xpath(Testelements.MakeAciveProduct_From_BasicDetails)).click();
      
      waitForPageLoad();
      
      Thread.sleep(3000);
      
      
      if(driver.findElement(By.xpath(Testelements.Prop65_basicDetails_Validation_AfterMakeActive)).getText().contains("The Prop65 field is missing required information.") & driver.findElement(By.xpath(Testelements.Prop65_basicDetails_Validation_AfterMakeActive)).getText().contains("Please select the appropriate Warning(s) and provide the requested data") & driver.findElement(By.xpath(Testelements.Prop65_basicDetails_Validation_AfterMakeActive)).getText().contains("OR unselect Prop65 in order to make active."))
      {
    	  System.out.println("Prop65 Validation UI After Making Active Product Button Display Successfully");
    	  
    	  test = extent.createTest("Prop65 Validation UI After Making Active Product_Verification");
		   	
		  test.log(Status.PASS, "Prop65 Validation UI After Making Active Product Button Display Successfully ");
      }
      else{
          System.out.println("Prop65 Validation UI After Making Active Product Button Display UnSuccessfully");
    	  
    	  test = extent.createTest("Prop65 Validation UI After Making Active Product_Verification");
		   	
		  test.log(Status.PASS, "Prop65 Validation UI After Making Active Product Button Display UnSuccessfully "); 
      }
      
      driver.findElement(By.xpath(Testelements.Pro65_basicDetails_Validation_OK_Button)).click();
      
      Thread.sleep(2000);
      //Check the warning checkbox and Insert warning name
      driver.findElement(By.xpath(Testelements.WarningCheckbox_prop65)).click();
      
      Thread.sleep(2000);
      
      //Scroll Up
      
      JavascriptExecutor jse70 = (JavascriptExecutor)driver;
      jse70.executeScript("window.scrollBy(0,-250)", "");
      
      JavascriptExecutor jse71 = (JavascriptExecutor)driver;
      jse71.executeScript("window.scrollBy(-250,-500)", "");
      
      JavascriptExecutor jse72 = (JavascriptExecutor)driver;
      jse72.executeScript("window.scrollBy(-500,-750)", "");
      
      Thread.sleep(1000);
      
      
      
      //Press the save button
      driver.findElement(By.xpath(Testelements.SaveButton_ProductCreation)).click();
      
      Thread.sleep(5000);
      
      
      // Switching to Alert        
      Alert alert = driver.switchTo().alert();		
      		
      // Capturing alert message.    
      String alertMessage= driver.switchTo().alert().getText();		
      		
      // Displaying alert message		
      System.out.println(alertMessage);	
      Thread.sleep(2000);
      		
      if(alertMessage.contains("Cannot save due to following errors:"))
      {
    	  System.out.println("Alert Error Message Displayed Successfully i.e Please enter a warning for the immediate container or wrapper of the product");
     
    	  test = extent.createTest("Prop65 Error Alert Message Without Inserting warning");
		   	
		  test.log(Status.PASS, "Alert Error Message Displayed Successfully i.e Please enter a warning for the immediate container or wrapper of the product ");
      }
      else{
    	  
    	  System.out.println("Alert Error Message Displayed UnSuccessfully i.e Please enter a warning for the immediate container or wrapper of the product");
    	     
    	  test = extent.createTest("Prop65 Error Alert Message Without Inserting warning");
		   	
		  test.log(Status.FAIL, "Alert Error Message Displayed UnSuccessfully i.e Please enter a warning for the immediate container or wrapper of the product ");      
      }
      
      // Accepting alert		
      alert.accept();	
      
      driver.findElement(By.xpath(Testelements.WarningInputfield1)).sendKeys("AutomationWarning");
      
      Thread.sleep(1000);
      
     //Validating as if the Menu Bar On Product Details Screen Displaying after Scrolling or not
      if(driver.findElement(By.xpath(Testelements.ProductDetails_MenuBar_Verification_WhileScrolling)).isDisplayed())
      {
    	  System.out.println("Menu Bar on Product Details Screen Display After Scrolling Successfully");
    	  
    	  test = extent.createTest("Menu Bar on Product Details Screen Display After Scrolling Successfully");
		   	
		  test.log(Status.PASS, "Shipping Estimates Fields Cleared Successfully ");
      }
      else{
           System.out.println("Menu Bar on Product Details Screen Display After Scrolling UnSuccessfully");
    	  
    	  test = extent.createTest("MenuBarDisplaying_WhileScrolling");
		   	
		  test.log(Status.FAIL, "Menu Bar on Product Details Screen Display After Scrolling UnSuccessfully ");
      }
      
      //Validating the shipping estimates ClearAll Button functionality for field data removal
      driver.findElement(By.xpath(Testelements.NumberofItemsField_ShippingEstimates)).sendKeys("23");
      
      driver.findElement(By.xpath(Testelements.EnableClearAllButton)).click();
      
      Thread.sleep(1000);
      
      driver.findElement(By.xpath(Testelements.ClearAllButton_ShippingEstimates)).click();
      
      Thread.sleep(1000);
      
      if(driver.findElement(By.xpath(Testelements.ClearAllFields_ShippingEstimates_Verification)).isDisplayed())
      {
    	  System.out.println("Shipping Estimates Fields Cleared Successfully");
    	  
    	  test = extent.createTest("ShippingEstimates_Fields_ClearAll");
		   	
		  test.log(Status.PASS, "Shipping Estimates Fields Cleared Successfully ");
      }
      else{
          System.out.println("Shipping Estimates Fields Cleared UnSuccessfully");
    	  
    	  test = extent.createTest("ShippingEstimates_Fields_ClearAll");
		   	
		  test.log(Status.FAIL, "Shipping Estimates Fields Cleared Unsuccessfully ");
      }
  		
      //Now Verifying the shipping info special Characters Conversion
      driver.findElement(By.xpath(Testelements.AdditionalShippingInfo_BasicDetails)).sendKeys("Test"+"(R)(C)(TM)");
      
      Thread.sleep(1000);
      
      driver.findElement(By.xpath(Testelements.AdditionShippingInfo_BasicDetailsText)).click();
      
      Thread.sleep(2000);
      
      WebElement ShippingInfo_SpecialCharacters=driver.findElement(By.xpath(Testelements.AdditionalShippingInfo_BasicDetails));
	  String ShippingInfo_SpecialCharConv=ShippingInfo_SpecialCharacters.getAttribute("value");
	  
	   System.out.println(ShippingInfo_SpecialCharConv);
	   
	   if(ShippingInfo_SpecialCharConv.contains("(R)(C)™"))
	   {
		   System.out.println("Shipping Info (TM) Convert to Special Characters Successfully");
		   
		   test = extent.createTest("ShippingInfo(TM)_SpecialCharacters_Verification");
		   	
		   test.log(Status.PASS, "Shipping Info (TM) Convert to Special Characters Successfully ");
	   }
	   else{
          System.out.println("Shipping Info (TM) Convert to Special Characters UnSuccessfully");
		   
		   test = extent.createTest("ShippingInfo(TM)_SpecialCharacters_Verification");
		   	
		   test.log(Status.FAIL, "Shipping Info (TM) Convert to Special Characters UnSuccessfully ");
		   
	   }
      
      
      JavascriptExecutor jse89 = (JavascriptExecutor)driver;
      jse89.executeScript("window.scrollBy(0,-250)", "");
      
      JavascriptExecutor jse90 = (JavascriptExecutor)driver;
      jse90.executeScript("window.scrollBy(-250,-500)", "");
      
      JavascriptExecutor jse91 = (JavascriptExecutor)driver;
      jse91.executeScript("window.scrollBy(-500,-750)", "");
      
      JavascriptExecutor jse92 = (JavascriptExecutor)driver;
      jse92.executeScript("window.scrollBy(-750,-1000)", "");
      
      
      Thread.sleep(2000);
      
      //Press the Make Active Button
	   driver.findElement(By.xpath(Testelements.MakeActiveButton_BasicDetails)).click();
	   
	   wait = new WebDriverWait(driver, 180);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MakeActiveProduct_RestrictionVerification1)));
     
	   Thread.sleep(2000);
	   
	   
	   if(driver.findElement(By.xpath(Testelements.MakeActiveProduct_RestrictionVerification1)).isDisplayed() & driver.findElement(By.xpath(Testelements.MakeActiveProduct_RestrictionVerification2)).isDisplayed())
	   {
		   System.out.println("Prevent Product Publish when Special Characters are in certain fields Successfully");
		   
		   test = extent.createTest("PreventProductPublish_CertainFields_Verification");
		   	
		   test.log(Status.PASS, "Prevent Product Publish when Special Characters are in certain fields Successfully ");
		   
	   }
	   else{
          System.out.println("Prevent Product Publish when Special Characters are in certain fields UnSuccessfully");
		   
		   test = extent.createTest("PreventProductPublish_CertainFields_Verification");
		   	
		   test.log(Status.FAIL, "Prevent Product Publish when Special Characters are in certain fields UnSuccessfully ");
		   
	   }
	   driver.findElement(By.xpath(Testelements.PublishProductRestriction_OkButton)).click();
	   
	   Thread.sleep(2000);
	   
	   toClear = driver.findElement(By.cssSelector(Testelements.Product_Number));
      toClear.sendKeys(Keys.CONTROL + "a");
      toClear.sendKeys(Keys.DELETE);
      
      Thread.sleep(2000);
      
      toClear = driver.findElement(By.cssSelector(Testelements.BasicDetails_SKUField));
      toClear.sendKeys(Keys.CONTROL + "a");
      toClear.sendKeys(Keys.DELETE);
      
      Thread.sleep(2000);
      
      //Validating the Pricing Scenarios in different fields
      driver.findElement(By.xpath(Testelements.ProductName_BasicDetails)).sendKeys(""+"$12.0(D)");
  
      //Press the Make Active button for Validation Verification
      driver.findElement(By.xpath(Testelements.MakeActiveButton_BasicDetails)).click();
	   
	   wait = new WebDriverWait(driver, 180);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.PricingDecimalNumber_ErrorVerification)));
    
	   Thread.sleep(2000);
	   
      //Select the pricing tab for SPG
	   if(driver.findElement(By.xpath(Testelements.PricingDecimalNumber_ErrorVerification)).isDisplayed())
	   {
		   System.out.println("check for pricing in specific fields Successfully");
		   
		   test = extent.createTest("PreventProductPublish_Pricing_CertainFields_Verification");
		   	
		   test.log(Status.PASS, "check for pricing in specific fields Successfully ");
		   
	   }
	   else{
            System.out.println("check for pricing in specific fields UnSuccessfully");
		   
		   test = extent.createTest("PreventProductPublish_Pricing_CertainFields_Verification");
		   	
		   test.log(Status.FAIL, "check for pricing in specific fields UnSuccessfully ");
	   }
    
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath(Testelements.PublishProductRestriction_OkButton)).click();
	   
	   Thread.sleep(1000);
	   
	   toClear = driver.findElement(By.xpath(Testelements.ProductName_BasicDetails));
	      toClear.sendKeys(Keys.CONTROL + "a");
	      toClear.sendKeys(Keys.DELETE);
	      
	      Thread.sleep(2000);
	      
	      driver.findElement(By.xpath(Testelements.ProductName_BasicDetails)).sendKeys(Testdata.Productname);
	      
	      driver.findElement(By.xpath(Testelements.ProductName_TextClick_BasicDetails)).click();
	      
	      Thread.sleep(2000);
	      
	   
      driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
    
      waitForPageLoad();
      
      // Wait for attributes to appear
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
      
      
  	Thread.sleep(1000);
  	
      
      driver.findElement(By.xpath(Testelements.Product_Atrribute_Pink)).click();
      
      //Select the 2nd attribute
      driver.findElement(By.xpath(Testelements.Product_Attribute_Green)).click();
      
    //Press the New color template button
      driver.findElement(By.xpath(Testelements.ColorTemplateMenu)).click();
      
      driver.findElement(By.xpath(Testelements.ColorTemplateMenu_SaveTemplateOption)).click();
      
      Thread.sleep(1000);
      
      //Insert the new color template Name
      driver.findElement(By.xpath(Testelements.ColorTemplateNameField)).sendKeys(Testdata.ColorTemplateName);
      
      driver.findElement(By.xpath(Testelements.ColorTemplateSaveButton)).click();
      
      if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
		{
			System.out.println("New Color Template Added and Saved Successfully");
			
			test = extent.createTest("NewColorTemplateCreation");
		   	
			 test.log(Status.PASS, "New Color Template Added and Saved Successfully");
		}
		else{
			System.out.println("New Color Template Added and Saved UnSuccessfully");
			
			 test = extent.createTest("NewColorTemplateCreation");
		   	
			  test.log(Status.FAIL, "New Color Template Added and Saved UnSuccessfully");
			
		}
      
      
      //Wait for few sec
      JavascriptExecutor jse150 = (JavascriptExecutor)driver;
      jse150.executeScript("window.scrollBy(0,250)", "");
      
      JavascriptExecutor jse151 = (JavascriptExecutor)driver;
      jse151.executeScript("window.scrollBy(250,500)", "");
      
      JavascriptExecutor jse153 = (JavascriptExecutor)driver;
      jse153.executeScript("window.scrollBy(500,750)", "");
  		
      Thread.sleep(2000);
  	
     //Add the Sizes in attributes
  		driver.findElement(By.xpath(Testelements.SelectSize_Attributes)).click();
  		
  		Thread.sleep(1000);
  		
    //Click the View All sizes 
  		driver.findElement(By.xpath(Testelements.ViewAllSizes)).click();
  		
  		Thread.sleep(1000);
  		
  		//Select the Size Option
  		driver.findElement(By.cssSelector(Testelements.SizeSelection)).click();
  		
  		Thread.sleep(1000);
  		
  		//Press the checkbox
  		driver.findElement(By.xpath(Testelements.Apparel_CheckboxSelection)).click();
  		
  		Thread.sleep(1000);
  		
  		 JavascriptExecutor jse701 = (JavascriptExecutor)driver;
         jse701.executeScript("window.scrollBy(0,-250)", "");
         
         Thread.sleep(1000);
  		
  		//Now goto Submenu and apply the new size template
  		driver.findElement(By.xpath(Testelements.SizeTemplateMenu)).click();
  		
  		//Select the Save Option
  		driver.findElement(By.xpath(Testelements.SaveTemplateOption_SizeTemplateMenu)).click();
  		
  		//Insert the new sixe Template Name
  		driver.findElement(By.xpath(Testelements.SizeTemplateName)).sendKeys(Testdata.SizeTemplateName);
  		
  		//Press the save button to save the size template
  		driver.findElement(By.xpath(Testelements.SaveSizeTemplate)).click();
  		
  		if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
  		{
  			System.out.println("New Size Template Added and Saved Successfully");
  			
  			test = extent.createTest("NewSizeTemplateCreation");
 		   	
  			 test.log(Status.PASS, "New Size Template Added and Saved Successfully");
  		}
  		else{
  			System.out.println("New Size Template Added and Saved UnSuccessfully");
  			
 			 test = extent.createTest("NewSizeTemplateCreation");
		   	
 			  test.log(Status.FAIL, "New Size Template Added and Saved UnSuccessfully");
  			
  		}
  		 JavascriptExecutor jse900 = (JavascriptExecutor)driver;
         jse900.executeScript("window.scrollBy(0,-250)", "");
  		
         JavascriptExecutor jse901 = (JavascriptExecutor)driver;
         jse901.executeScript("window.scrollBy(-250,-500)", "");
         
         Thread.sleep(2000);
  		
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
      
      //Thread.sleep(3000);
      
      //Open the pricing tab
      driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
      
      //Wait for all the fields to be appeared
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
      
      Thread.sleep(5000);
  	
      
      //Insert the details
      driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys("10");
      
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys(Keys.TAB);
      
      driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("9");
      
      Thread.sleep(1000);
      
      
    //Press the save button on pricing
    		driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
    		
    		waitForPageLoad();
    		
    		Thread.sleep(7000);
    		
    	List<WebElement> ListPriceGrid1_Val1_BeforeEnteringListPrice=driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
   		 String ListPriceGrid1Verification_BeforePriceEntering_Quantity1=ListPriceGrid1_Val1_BeforeEnteringListPrice.get(0).getAttribute("value");
   		 System.out.println(ListPriceGrid1Verification_BeforePriceEntering_Quantity1);	
   		 
   		List<WebElement> ListPriceGrid1_Val2_BeforeEnteringListPrice=driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
  		 String ListPriceGrid1Verification_BeforePriceEntering_Quantity2=ListPriceGrid1_Val2_BeforeEnteringListPrice.get(1).getAttribute("value");
  		 System.out.println(ListPriceGrid1Verification_BeforePriceEntering_Quantity2);	
   		 
   		 if(ListPriceGrid1Verification_BeforePriceEntering_Quantity1.contains("10") & ListPriceGrid1Verification_BeforePriceEntering_Quantity2.contains("9"))
   		 {
   			 System.out.println("Price grid quantities are not being cleared when saved, without pricing");
   			 
   			 test = extent.createTest("QuantitiesExistence_BeforePriceEnter_Verification");
 		   	
			 test.log(Status.PASS, "Price grid quantities are not being cleared when saved, without pricing");
   		 }
   		 else{
   			 
   			System.out.println("Price grid quantities are being cleared when saved, without pricing");
  			 
  			 test = extent.createTest("QuantitiesExistence_BeforePriceEnter_Verification");
		   	
			 test.log(Status.FAIL, "Price grid quantities are being cleared when saved, without pricing"); 
   		 }
      
      driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1)).sendKeys("20");
      
      //driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1)).click();
      
      WebElement mySelectElement100 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
      Select dropdown100= new Select(mySelectElement100);
     
      dropdown100.selectByVisibleText("L 70%");
      
      //Selection from dropdown
      
  		
  	//driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("9");
  	
  	driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
  	
  	//driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2)).click();
  	//Selection from through robots   
  	
  	
  	 WebElement mySelectElement71 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
          Select dropdown71= new Select(mySelectElement71);
         
          dropdown71.selectByVisibleText("L 70%");
  	
  	   Thread.sleep(2000);
  	   
  	 JavascriptExecutor jse7072 = (JavascriptExecutor)driver;
     jse7072.executeScript("window.scrollBy(0,-250)", "");
     
     JavascriptExecutor jse70712 = (JavascriptExecutor)driver;
     jse70712.executeScript("window.scrollBy(-250,-500)", "");
     
     JavascriptExecutor jse707112 = (JavascriptExecutor)driver;
     jse707112.executeScript("window.scrollBy(-500,-750)", "");
     
     Thread.sleep(1000);
  	   
  	 driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).click();
  	   
  	 driver.findElement(By.xpath(Testelements.OuterAreaPricingClick)).click();
  	 
  	 Thread.sleep(2000);
  	   
  	 if(driver.findElement(By.xpath(Testelements.QuantityDesending_ValidationError_Pricing)).getText().contains("Quantities must increase in the pricing grid from left to right."))
     {
   	  System.out.println("Descending quantity validation displayed Successfully");
   	  
   	  test = extent.createTest("DescendingQuantity_Validation_Verification");
		   	
			 test.log(Status.PASS, "Descending quantity validation displayed Successfully");
   	  
   	  
     }
     else{
   	  
         System.out.println("Descending quantity validation displayed Successfully");
   	  
   	  test = extent.createTest("DescendingQuantity_Validation_Verification");
		   	
			 test.log(Status.FAIL, "Descending quantity validation displayed Successfully");
     }
  	driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).clear();
  	
  	Thread.sleep(1000);
  	
  	driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("20");
  	
  	//Now chnage the List Type to Both
  	WebElement mySelectElement721 = driver.findElement(By.xpath(Testelements.DefaultPriceType_ProductLevel));
		Select dropdown721= new Select(mySelectElement721);

		dropdown721.selectByVisibleText("Both");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(Testelements.ChangingPriceGrids_PriceType_ProductLevel_Confirm)).click();
		
		Thread.sleep(2000);
		
	   //Press the save button on pricing
		driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
		
		waitForPageLoad();
		
		Thread.sleep(7000);
		
		
		driver.findElement(By.xpath(Testelements.Netcost_USCurrency_Grid1)).clear();
		
		driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys(Keys.TAB);
		
		
		List<WebElement> ListPriceGrid1=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
		 String ListPriceGrid1Verification=ListPriceGrid1.get(0).getAttribute("value");
		 System.out.println(ListPriceGrid1Verification);
		 
		 if(ListPriceGrid1Verification.contains("20"))
		 {
			 System.out.println("ListPrice Value remain Intact after removing net cost and and hitting tab Successfully");
			 
			 test = extent.createTest("Removing Net Cost from a cell and hitting tab automatically removes List Price above it");
			   	
			 test.log(Status.PASS, "ListPrice Value remain Intact after removing net cost and and hitting tab Successfully");
			 
		 }
		 else{
            System.out.println("ListPrice Value remain Intact after removing net cost and and hitting tab UnSuccessfully");
			 
			 test = extent.createTest("Removing Net Cost from a cell and hitting tab automatically removes List Price above it");
			   	
			 test.log(Status.FAIL, "ListPrice Value remain Intact after removing net cost and and hitting tab UnSuccessfully");
		 }

		 
		 WebElement mySelectElement7212 = driver.findElement(By.xpath(Testelements.DefaultPriceType_ProductLevel));
			Select dropdown7212= new Select(mySelectElement7212);

			dropdown7212.selectByVisibleText("List Price");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(Testelements.ChangingPriceGrids_PriceType_ProductLevel_Confirm)).click();
			
			Thread.sleep(5000);
		 
			 
			 List<WebElement> Pricing_Quantity3 = driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
			 Pricing_Quantity3.get(2).sendKeys("30");
			
			 List<WebElement> Pricing_ListPricing3 = driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 Pricing_ListPricing3.get(2).sendKeys("5");
			
			 List<WebElement> Pricing_Quantity2_Clear = driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
			 Pricing_Quantity2_Clear.get(1).clear();
			
			 List<WebElement> Pricing_ListPricing2_Clear = driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 Pricing_ListPricing2_Clear.get(1).clear();
			
			 Thread.sleep(4000);
			 
			 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
				
				waitForPageLoad();
				
				Thread.sleep(7000);
				
				List<WebElement> QuantityValue_Verify=driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
				 String QuantityValue_VerifyDetails=QuantityValue_Verify.get(1).getAttribute("value");
				 System.out.println(QuantityValue_VerifyDetails);
				 
				 List<WebElement> ListValue_Verify=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
				 String ListValue_VerifyDetails=ListValue_Verify.get(1).getAttribute("value");
				 System.out.println(ListValue_VerifyDetails);
				 	
			if(QuantityValue_VerifyDetails.contains("30") & ListValue_VerifyDetails.contains("5"))
			{
				System.out.println("Removing QTY and Price at the same time when List Price is selected does not remove the column Successfully");
			
				test = extent.createTest("Removing QTY and Price at the same time when List Price is selected does not remove the column");
			   	
				 test.log(Status.PASS, "Removing QTY and Price at the same time when List Price is selected does not remove the column Successfully");
				 
			}
			else{
				
				System.out.println("Removing QTY and Price at the same time when List Price is selected does not remove the column UnSuccessfully");
				
				test = extent.createTest("Removing QTY and Price at the same time when List Price is selected does not remove the column");
			   	
				 test.log(Status.FAIL, "Removing QTY and Price at the same time when List Price is selected does not remove the column UnSuccessfully");
			}
			
			List<WebElement> Pricing_ListPricing2QUR_Clear = driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			Pricing_ListPricing2QUR_Clear.get(1).clear();
			
			//Press the save button
			 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
				
			 waitForPageLoad();
				
			 Thread.sleep(7000);
				
			 List<WebElement> ListValue_QURVerify=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 String ListValue_QURVerifyDetails=ListValue_QURVerify.get(1).getAttribute("value");
			 System.out.println(ListValue_QURVerifyDetails);
			 
			 if(ListValue_QURVerifyDetails.contains("QUR"))
					 {
				      System.out.println("QUR Updated in list price field after removing the value from field and pressing save button Successfully");
					 
				      test = extent.createTest("QURText_Verification_AfterRemovingvalueandSave");
					   	
					test.log(Status.PASS, "QUR Updated in list price field after removing the value from field and pressing save button Successfully");
					 }
			 else{
				 System.out.println("QUR Updated in list price field after removing the value from field and pressing save button UnSuccessfully");
				 
			      test = extent.createTest("QURText_Verification_AfterRemovingvalueandSave");
				   	
				test.log(Status.FAIL, "QUR Updated in list price field after removing the value from field and pressing save button UnSuccessfully"); 
			 }
			
			 driver.findElement(By.xpath(Testelements.CurrencyMenu_Pricing_ProductLevel)).click();
			   
			 Thread.sleep(1000);
			   
			 driver.findElement(By.xpath(Testelements.Can_CurrencySelection__Pricing_ProductLevel)).click();
			
			 Thread.sleep(2000);
			 
			 List<WebElement> ListValue_Grid2ValueVerification=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 String ListValue_Grid2ValueVerifyDetails=ListValue_Grid2ValueVerification.get(10).getAttribute("value");
			 System.out.println(ListValue_Grid2ValueVerifyDetails);
			 
			 List<WebElement> ListValue_Grid2ValueVerificatio2=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 String ListValue_Grid2ValueVerifyDetail2=ListValue_Grid2ValueVerificatio2.get(11).getAttribute("value");
			 System.out.println(ListValue_Grid2ValueVerifyDetail2);
			 
			 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
				
			waitForPageLoad();
				
			Thread.sleep(7000);
			 
			 if(!ListValue_Grid2ValueVerifyDetails.contains("0") & !ListValue_Grid2ValueVerifyDetail2.contains("0"))
			 {
				 System.out.println("Canadian Price Grid is being not set to 0 automatically Successfully ");
			 
				 test = extent.createTest("Canadian Price Grid is being not set to 0 automatically");
				   	
				 test.log(Status.PASS, "Canadian Price Grid is being not set to 0 automatically Successfully");
			 }
			 else{
				 System.out.println("Canadian Price Grid is being not set to 0 automatically UnSuccessfully ");
				 
				 test = extent.createTest("Canadian Price Grid is being not set to 0 automatically");
				   	
				 test.log(Status.FAIL, "Canadian Price Grid is being not set to 0 automatically UnSuccessfully"); 
			 }
			 
			 JavascriptExecutor jse707 = (JavascriptExecutor)driver;
		      jse707.executeScript("window.scrollBy(0,-250)", "");
		      
		      JavascriptExecutor jse7071 = (JavascriptExecutor)driver;
		      jse7071.executeScript("window.scrollBy(-250,-500)", "");
		      
		      JavascriptExecutor jse70711 = (JavascriptExecutor)driver;
		      jse70711.executeScript("window.scrollBy(-500,-750)", "");
		      
		      Thread.sleep(1000);
			 
			 
			 driver.findElement(By.xpath(Testelements.CurrencyMenu_Pricing_ProductLevel)).click();
			   
			 Thread.sleep(1000);
			   
			 driver.findElement(By.xpath(Testelements.Can_CurrencySelection__Pricing_ProductLevel)).click();
			
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(Testelements.CurrencyUnCheck_Confirm)).click();
			 
			 Thread.sleep(2000);
			 
			 
			 
			 List<WebElement> Pricing_ListPricing2QUR_Clearvalue = driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 Pricing_ListPricing2QUR_Clearvalue.get(1).clear();
			 
			 Thread.sleep(1000);
			 
			 List<WebElement> Pricing_ListPricing2QUR_sendingvalue = driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
			 Pricing_ListPricing2QUR_sendingvalue.get(1).sendKeys("5");
				
			 
			 
			 WebElement mySelectElement1001 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
		      Select dropdown1001= new Select(mySelectElement1001);
		     
		      dropdown1001.selectByVisibleText("L 70%");
		      
		      Thread.sleep(2000);
		      
		      WebElement mySelectElement1002 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
		      Select dropdown1002= new Select(mySelectElement1002);
		     
		      dropdown1002.selectByVisibleText("L 70%");
		      
		      Thread.sleep(2000);
		      
		     driver.findElement(By.xpath(Testelements.ApplyAllcodes_PricingCheckbox)).click();
		     
		     Thread.sleep(1000);
		      
		      
		      WebElement mySelectElement10012 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
		      Select dropdown10012= new Select(mySelectElement10012);
		     
		      dropdown10012.selectByVisibleText("C/R 40%");
		      
		      Thread.sleep(2000);
		      
		      driver.findElement(By.xpath(Testelements.ApplyAllcodes_PricingCheckbox)).click();
			     
			     Thread.sleep(1000);
			     
			     WebElement mySelectElement10023 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
			     Select dropdown10023= new Select(mySelectElement10023);
			     
			    WebElement option=dropdown10023.getFirstSelectedOption();
			    
			    String DropdownUpdatedPricecode=option.getText();
			    
			    System.out.println(DropdownUpdatedPricecode);
			    
			    if(DropdownUpdatedPricecode.contains("C/R 40%"))
			    {
			    	System.out.println("Price code apply to all grids successfully");
			    	
			    	test = extent.createTest("PriceCodeApplyall_GridsVerification");
				   	
					test.log(Status.PASS, "Price code apply to all grids successfully");
			    }
			    else{
                    System.out.println("Price code apply to all grids unsuccessfully");
			    	
			    	test = extent.createTest("PriceCodeApplyall_GridsVerification");
				   	
					test.log(Status.FAIL, "Price code apply to all grids unsuccessfully");
			    	
			    }
		 //Move to Images tab
  	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
  	
  	waitForPageLoad();
  	
   //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
          
       
       
       //First store parent window to switch back
       String parentWindow2 = driver.getWindowHandle(); 
       
      Thread.sleep(2000);
       
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
       
       JavascriptExecutor jse891 = (JavascriptExecutor)driver;
       jse891.executeScript("window.scrollBy(0,250)", "");
	   	
      
		Thread.sleep(1000);
	
        //Confirm the images uploading details
       driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
       
       waitForPageLoad();
       //Switch back to parent window 
          driver.switchTo().window(parentWindow2);
          
     
  	Thread.sleep(1000);
  
    //Validating the Background color of attribute is red before dragging
  	if(driver.findElement(By.xpath(Testelements.AttributeColor_BeforeDrag)).isDisplayed())
  	{
  		System.out.println("Attribute color red before drag is displayed red Successfully");
  		
  		test = extent.createTest("BeforeDragging_AttribueBackgroundColorRed_Verification");
        
        test.log(Status.PASS, "Attribute color red before drag is displayed red Successfully");
  	}
  	else{
        System.out.println("Attribute color red before drag is displayed red UnSuccessfully");
  		
  		test = extent.createTest("BeforeDragging_AttribueBackgroundColorRed_Verification");
        
        test.log(Status.FAIL, "Attribute color red before drag is displayed red UnSuccessfully");
  	}
         
   //Tagging the colors to image in creteria section
     Actions act=new Actions(driver);
     //1st Color(White) tagging  
    // find element which we need to drag
    WebElement drag=driver.findElement(By.xpath("//span[contains(@data-bind,'text: getValue(true)')]"));
     
    
    
    
    
    // find element which we need to drop
    WebElement drop=driver.findElement(By.xpath("//ul[contains(@class,'selected-criteria-sets token-input-list-facebook ui-droppable')]"));
     
    // this will drag element to destination
    act.dragAndDrop(drag, drop).build().perform();
     
   
  	Thread.sleep(1000);
  	
  //Validating the Background color of attribute is green after dragging
  	if(driver.findElement(By.xpath(Testelements.AtributeColor_AfterDrag)).isDisplayed())
  	{
  		System.out.println("Attribute color red before drag is displayed Green Successfully");
  		
  		test = extent.createTest("BeforeDragging_AttribueBackgroundColorGreen_Verification");
        
        test.log(Status.PASS, "Attribute color red before drag is displayed Green Successfully");
  	}
  	else{
        System.out.println("Attribute color red before drag is displayed Green UnSuccessfully");
  		
  		test = extent.createTest("BeforeDragging_AttribueBackgroundColorGreen_Verification");
        
        test.log(Status.FAIL, "Attribute color red before drag is displayed Green UnSuccessfully");
  	}
  
    
  	JavascriptExecutor jse7011 = (JavascriptExecutor)driver;
  	 jse7011.executeScript("window.scrollBy(0,-250)", "");
  	 
  	JavascriptExecutor jse711 = (JavascriptExecutor)driver;
  	 jse711.executeScript("window.scrollBy(0,-250)", "");
  	 
     Thread.sleep(1000);
    //Goto Summary Tab
      driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
        
      waitForPageLoad();
     //Wait for some time
      //Thread.sleep(5000);
  	

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
  
  	if(driver.findElement(By.xpath(Testelements.ManageProductListing_ProductDescription)).getText().contains("®©™"))
  	{
  		System.out.println("Special Characters on Manage Product Listing Description Displayed Successfully");
  		
         test = extent.createTest("ManageProductsListing_SpecialCharacters_Verification");
        
        test.log(Status.PASS, "Special Characters on Manage Product Listing Description Displayed Successfully");
  	}
  	else{
  		System.out.println("Special Characters on Manage Product Listing Description Displayed UnSuccessfully");
  		
        test = extent.createTest("ManageProductsListing_SpecialCharacters_Verification");
       
       test.log(Status.FAIL, "Special Characters on Manage Product Listing Description Displayed UnSuccessfully");
  	}
    
   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
   
   waitForPageLoad();
   
   Thread.sleep(1000);
   
   waitForPageLoad();
   
   Thread.sleep(1000);
   
   //Thread.sleep(40000);
  
   
   //Scroll down
   JavascriptExecutor jse801 = (JavascriptExecutor)driver;
   jse801.executeScript("window.scrollBy(0,250)", "");
   
   //Wait
   Thread.sleep(1000);
 
   
   driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame1");
   
   Thread.sleep(1000);
  
   driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);
   
   Thread.sleep(1000);
 
   
   driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys("frame2");
   
  	Thread.sleep(2000);
 

   driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);
   
   Thread.sleep(1000);
 
   
    
    
    if(driver.findElement(By.xpath(Testelements.KeywordCount)).getText().contains("Total Keywords: 2")){
    	
    	System.out.print("Total Number of keywords shown sucessfully on product i.e 2");
    	
    	test = extent.createTest("DisplayKeywordCount_OnProductDetails");
    	  
    	test.log(Status.PASS, "Display number of keywords on a product is successfull");
    	
    }
    else{
    	
    	System.out.print("Total Number of keywords shown unsucessfully on product i.e 2");
    	
    	test = extent.createTest("DisplayKeywordCount_OnProductDetails");
    	 
    	test.log(Status.FAIL, "Display number of keywords on a product is unsucessfull");
    }
    
    //Validate as the compliance exist or not after adding
    if(driver.findElement(By.xpath(Testelements.ComplianceandSafety_Verification)).getText().contains("ANSI") & driver.findElement(By.xpath(Testelements.ComplianceandSafety_Verification_FLA)).getText().contains("FLA") )
    {
      System.out.println("Compliance and safety(ANSI and FLA) display Change Successfully");
    	
    	test = extent.createTest("DisplayChange_ComplianceandSafety_ANSI_FLA");
  	  
    	test.log(Status.PASS, "Compliance and safety (ANSI and FLA) display Change Successfully");
    }
    else{
        System.out.println("Compliance and safety (ANSI and FLA) display Change Unsuccessfully");
    	
    	test = extent.createTest("DisplayChange_ComplianceandSafety_ANSI_FLA");
   	 
    	test.log(Status.FAIL, "Compliance and safety (ANSI and FLA) display Change unsucessfull");
    
    }
    WebElement Prop65Warningverification=driver.findElement(By.xpath(Testelements.WarningInputfield1));
	String value3=Prop65Warningverification.getAttribute("value");
	  
	 System.out.println(value3);
    
    //Validate As if the Prop65 Warning exist or not
    if(value3.contains("AutomationWarning"))
    {
    	System.out.println("Prop65 Verified Successfully");
    	
    	test = extent.createTest("Prop65_Verification");
  	  
    	test.log(Status.PASS, "Prop65 Verified Successfully");
    }
    else{
    	System.out.println("Prop65 Verified Unsuccessfully");
    	
    	test = extent.createTest("Prop65_Verification");
   	 
    	test.log(Status.FAIL, "Prop65 Verified unsucessfull");
    }
    
    driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
    
    // Wait for attributes to appear
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SizeVerification_AfterActive)));
     
     
 	Thread.sleep(2000);

 	if(driver.findElement(By.xpath(Testelements.SizeVerification_AfterActive)).isDisplayed())
 	{
 		System.out.println("Size Exist successfully after product Activation");
 		
 		test = extent.createTest("RenameSizeGroup_AfterProduct_Activation");
 	  	  
    	test.log(Status.PASS, "Size Exist successfully after product Activation");
 		
 	}
 	else{
 		
         System.out.println("Size Exist unsuccessfully after product Activation");
 		
 		test = extent.createTest("RenameSizeGroup_AfterProduct_Activation");
 	  	  
    	test.log(Status.FAIL, "Size Exist unsuccessfully after product Activation");
 	}
 	
 	 //Open the pricing tab
    driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
    
    //Wait for all the fields to be appeared
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
    
    Thread.sleep(2000);
    
    driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).click();
    
  //Press the save button
	 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
		
	 waitForPageLoad();
		
	 Thread.sleep(7000);
	 
	 
	 
	 List<WebElement> QuantityValue_VerifyEdit=driver.findElements(By.cssSelector(Testelements.SPG_Quantity_1));
	 String QuantityValue_VerifyDetailsEdit=QuantityValue_VerifyEdit.get(1).getAttribute("value");
	 System.out.println(QuantityValue_VerifyDetailsEdit);
	 
	 List<WebElement> ListValue_VerifyEdit=driver.findElements(By.cssSelector(Testelements.SPG_Listprice_1));
	 String ListValue_VerifyDetailsEdit=ListValue_VerifyEdit.get(1).getAttribute("value");
	 System.out.println(ListValue_VerifyDetailsEdit);
	 
	 if(!QuantityValue_VerifyDetailsEdit.isEmpty() & !ListValue_VerifyDetailsEdit.isEmpty())
	 {
		 System.out.println("Setting a Base Price or Upcharge Price Grid to QUR doesn't Clears Out the Price Grid  ");
		 
		 test = extent.createTest("PriceGridToQUR_AfterSave_ClearsOutFields_Verification");
	  	  
	     test.log(Status.PASS, "Setting a Base Price or Upcharge Price Grid to QUR doesn't Clears Out the Price Grid");
	 }
	 else{
         System.out.println("Setting a Base Price or Upcharge Price Grid to QUR Clears Out the Price Grid UnSuccessfully ");
		 
		 test = extent.createTest("PriceGridToQUR_AfterSave_ClearsOutFields_Verification");
	  	  
	     test.log(Status.FAIL, "Setting a Base Price or Upcharge Price Grid to QUR Clears Out the Price Grid Successfully");
	 }
    
	 driver.findElement(By.xpath(Testelements.BasePricing_ProductLevel_QURGrid_Verification_USD1)).click();
	    
	  //Press the save button
		 driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
			
		 waitForPageLoad();
			
		 Thread.sleep(7000);
	 
	 
	 driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
    
    
    waitForPageLoad();
  	//Thread.sleep(12000);
 
   
    //Validate the tool tip message
    driver.findElement(By.xpath(Testelements.SKU_ToolTip)).click();
    
    Thread.sleep(2000);
    
    if(driver.getPageSource().contains("Note – In order to make changes to the criteria of an existing table; click on the" )){
    	
    	System.out.print("Tool Tip Text Message validated successfull");
    	
    	test = extent.createTest("SKU ToolTip Message Validation");
    	  
    	test.log(Status.PASS, " SKU Tool Tip Message  displayed and validated successfull");
    	
    }
    else{
    	
    	  	System.out.print("Tool Tip Text Message validated unsuccessfully");
        	
    	  	test = extent.createTest("SKU ToolTip Message Validation");
        	  
        	test.log(Status.FAIL, "SKU Tool Tip Message  displayed and validated unsucessfully.");
    }
    
    //Thread.sleep(5000);
    
    
    
    //Validate the tool tip message
    driver.findElement(By.xpath(Testelements.SKU_ToolTip)).click();
    
    Thread.sleep(1000);
    
    
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
    
    Thread.sleep(2000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
    
    Thread.sleep(2000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
    
    Thread.sleep(2000);

    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
    
    Thread.sleep(2000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
    
    
  	Thread.sleep(2000);
 
    
    driver.findElement(By.xpath(Testelements.SKURequired1)).sendKeys("3");
    
    driver.findElement(By.xpath(Testelements.SKURequired2)).sendKeys("2");
    
    
    WebElement mySelectElement = driver.findElement(By.xpath(Testelements.Invstatus1));
    Select dropdown= new Select(mySelectElement);
   
    dropdown.selectByVisibleText("In Stock");
    
    driver.findElement(By.xpath(Testelements.Invstatus1)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.Invstatus1)).click();
    
    Thread.sleep(1000);
    
    WebElement mySelectElement1 = driver.findElement(By.xpath(Testelements.Invstatus2));
    Select dropdown1= new Select(mySelectElement1);
    
    dropdown1.selectByVisibleText("In Stock");
    
    
    
  	Thread.sleep(2000);
    
  	//String[] InventoryStatus = {"choose...","Back Order/Temporarily Out Of Stock","In Stock","Made To Order","Out of Stock"};
    
    
    WebElement mySelectElement2 = driver.findElement(By.xpath(Testelements.Invstatus2));
    Select dropdown2= new Select(mySelectElement2);
    
    List <WebElement> elementcount = dropdown2.getOptions();
    System.out.println(elementcount.size());
    for(int i=0 ;i<elementcount.size();i++)
    {
        String value = elementcount.get(i).getText();
        
        if(!value.isEmpty())
        {
        
        System.out.println(value+""+"Does Exist");
        
        test = extent.createTest("InventoryStatuses"+""+value);
  	  
  	  	test.log(Status.PASS, "InventoryStatuses"+""+value+""+"Does Exist");      
    
        }
        else{
        	
        	System.out.println(value+""+"Does not Exist");
            
            test = extent.createTest("InventoryStatuses"+""+value);
      	  
      	  	test.log(Status.FAIL, "InventoryStatuses"+""+value+""+"Does not Exist");    
        }
        
        
        
        }
    
   
     Thread.sleep(2000);
 
  	 driver.findElement(By.xpath(Testelements.SKUquantity1)).sendKeys("2");
  	 
  	 driver.findElement(By.xpath(Testelements.SKUquantity2)).sendKeys("3");
  	 
  	 
  	Thread.sleep(2000);
  
  	 //Goto Summary Tab
      driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
      
      waitForPageLoad();
      
      Thread.sleep(6000);
  	
      //Manane product listing
      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
      
    //Scroll Up
	     
 	   JavascriptExecutor jse705 = (JavascriptExecutor)driver;
      jse705.executeScript("window.scrollBy(0,-250)", "");
      
      Thread.sleep(1000);
      

  	 
      wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
     
      
  		Thread.sleep(4000);
  	
      //Make chnages Active
     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
    
     //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
       
       driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
       
       
  		Thread.sleep(15000);
  	if(driver.findElement(By.xpath(Testelements.ProductActiveValidation)).isDisplayed()){
       System.out.println("Product Add & Updated Successfully");
 
        test = extent.createTest("AddUpdateProduct");
 
  	    test.log(Status.PASS, "Product add & Updated Sucessfully");
    
  	}
  	else{
  		
  		System.out.println("Product Add & Updated UnSuccessfully");
  	 
  		test = extent.createTest("AddUpdateProduct");
  	 
  	  	test.log(Status.FAIL, "Product add & Updated UnSucessfully");
  	}
  //Now Validate the username and date after updation
  	if(driver.getCurrentUrl().contains("stage")){
  	
  	if(driver.findElement(By.xpath(Testelements.LastUpdatedNameandDate_Validation)).getText().contains("Last updated by 30003fa")){
  		
           System.out.println("Last Updated username displayed successfully");
           
           test = extent.createTest("Username displayed");
           
           test.log(Status.PASS, "Last Updated username displayed successfully");
         	
           GetDate();
  	}
  	else{
  		
  		 System.out.println("Last Updated username displayed unsuccessfully");
         
  		 test = extent.createTest("Username displayed");
         
       	 test.log(Status.FAIL, "Last Updated username displayed unsuccessfully");
        
       	  GetDate();
  	}
  	
  	}
  	if(driver.getCurrentUrl().contains("uat")){
  	
  		if(driver.findElement(By.xpath(Testelements.LastUpdatedNameandDate_Validation)).getText().contains("Last updated by 12917")){
  		
  		System.out.println("Last Updated username displayed successfully");
        
  		test = extent.createTest("Username displayed");
        
      	test.log(Status.PASS, "Last Updated username displayed successfully");
      	
      	GetDate();
  	
  	}
  		else{
  			 System.out.println("Last Updated username displayed unsuccessfully");
  	         
  			 test = extent.createTest("Username displayed");
  	         
  	       	test.log(Status.FAIL, "Last Updated username displayed unsuccessfully");
  	     
  	       	GetDate();
  		}
  	}
  	if(driver.getCurrentUrl().contains("https://espupdates.asicentral.com/")){
  	  	
  		if(driver.findElement(By.xpath(Testelements.LastUpdatedNameandDate_Validation)).getText().contains("Last updated by 22dec")){
  		
  		System.out.println("Last Updated username displayed successfully");
        
  		test = extent.createTest("Username displayed");
        
      	test.log(Status.PASS, "Last Updated username displayed successfully");
      	
      	GetDate();
  	
  	}
  		else{
  			 System.out.println("Last Updated username displayed unsuccessfully");
  	         
  			 test = extent.createTest("Username displayed");
  	         
  	       	test.log(Status.FAIL, "Last Updated username displayed unsuccessfully");
  	     
  	       	GetDate();
  		}
  	}	
  	
  	} catch(NoSuchElementException e){
      	e.getStackTrace();
      	
  }
    
  }




@Test(priority=6)
  public void ProductInActivation() throws InterruptedException{
  	try{
  	//Click the manage product tab
  	  	driver.findElement(By.xpath(Testelements.Manage_Product_Tab)).click();
  	  	
  	  	Thread.sleep(2000);
  		//First store parent window to switch back
  	     String parentWindow3 = driver.getWindowHandle(); 
  		
  		//Click the inactive button to inactive the product
  	driver.findElement(By.cssSelector(Testelements.Product_Inactive)).click();
  	
  	//Switch to new window opened
  	for(String winHandle : driver.getWindowHandles()){
  	    if(!winHandle.equals(parentWindow3)) {
  	        driver.switchTo().window(winHandle);
  	    }
  	}
  	
  	//Wait for few sec for popup to appear
  
  	Thread.sleep(2000);
  	
 
	 
  	List<WebElement> li = driver.findElements(By.id(Testelements.Product_Inactive_Popup_Radio));;
  	li.get(2).click();
  	

  	
   Thread.sleep(1000);
  	
  	  
  	  //Confirm the inactivation by pressing the ok button
  	driver.findElement(By.cssSelector(Testelements.Product_Inactive_Confirm)).click();
  	
  	//Switch back to parent window 
      driver.switchTo().window(parentWindow3);
  	
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.InactivationNowValidation)));
 
      Thread.sleep(2000);
  		
      //Thread.sleep(22000);
  	if(driver.findElement(By.xpath(Testelements.InactivationNowValidation)).isDisplayed()){
        System.out.println("Product Inactivation NOW Successfull");
  	    
        test = extent.createTest("ProductInactivation");
    	
    	test.log(Status.PASS, "Product Inactivation for now is passed");
  	}
  	else{
  		 System.out.println("Product Inactivation NOW UnSuccessfull");
       
  		 test = extent.createTest("ProductInactivation");
    	
    	test.log(Status.FAIL, "Product Inactivation for now is passed");
  	}
      	
  	}catch(NoSuchElementException e){
      	e.getStackTrace();
      	
  }
  	
  	}

  @Test(priority=7)
  public void ScheduledProductActivation() throws InterruptedException{
  	try{
  	
      
    //First store parent window to switch back
  	     String parentWindow4 = driver.getWindowHandle(); 
      
      
      //Press again to active product
    //Click the inactive button to inactive the product
  	driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
  	
  	wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
      //Press the ok button from alert
      driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
  	
      Thread.sleep(10000);
  
  //Click the inactive button to inactive the product
  	driver.findElement(By.cssSelector(Testelements.Product_Inactive)).click();
  	
  	
  	//Switch to new window opened
  	for(String winHandle : driver.getWindowHandles()){
  	    if(!winHandle.equals(parentWindow4)) {
  	        driver.switchTo().window(winHandle);
  	    }
  	}
  	
  	Thread.sleep(5000);
  	
  	//Get the Radiobutton as WebElement using it's value attribute
  	List<WebElement> li1= driver.findElements(By.id(Testelements.Product_Inactive_Scheduled));
  	li1.get(2).click();
  	   
  	   //Check if its already selected? otherwise select the Radiobutton 
  	   //by calling click() method 
  	  
  	   
  	   
  	Thread.sleep(1000);
  
  	//Confirm the inactivation by pressing the ok button
  	driver.findElement(By.cssSelector(Testelements.Product_Inactive_Confirm)).click();
  	
  	
  	Thread.sleep(6000);
  
  	 driver.findElement(By.xpath(Testelements.Product_Inactive_Scheduled_Confirm)).click();
  	
  	
  	//driver.findElement(By.xpath(Testelements.Product_Inactive_Scheduled_Confirm)).click();
  	
  	//Switch back to parent window 
   driver.switchTo().window(parentWindow4);
  	
   waitForPageLoad();
   
   Thread.sleep(1000);
  	//Thread.sleep(12000);
  	
    if(driver.findElement(By.xpath(Testelements.ScheduledInActivationValidation)).isDisplayed()){
  	System.out.println("Product Scheduled Inactivation Successfull");
  	
  	test = extent.createTest("ProductScheduledInactivation");
  	
  	test.log(Status.PASS, "Product Scheduled inactivation is successfull ");
    }
    else{
    	System.out.println("Product Scheduled Inactivation UnSuccessfull");
      	test = extent.createTest("ProductScheduledInactivation");
      
      	test.log(Status.FAIL, "Product Scheduled inactivation is Unsuccessfull ");	
    }
  	
  	
  	
  	}catch(NoSuchElementException e){
   	e.getStackTrace();
   	
  }
  	

  }

  @Test(priority=8)

  public void CopyProduct() throws InterruptedException{
     
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
    
     if(driver.findElement(By.xpath(Testelements.CopyProductValidation)).isDisplayed()){
    	 
    	 System.out.println("Product Copy Successfully");
    	
    	 test = extent.createTest("Copyproduct ");
        
         test.log(Status.PASS, "Product Copy Successfully done");
     }
     else{
    	 
    	 System.out.println("Product Copy UnSuccessfull");
    	 
    	 test = extent.createTest("Copyproduct");
        
         test.log(Status.FAIL, "Product Copy UnSuccessfull ");
     }
     
     
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

    @Test(priority=9)
    
    public void DeleteImageFromProduct() throws InterruptedException{
  	  try{
  	  //Click the edit button
  	  driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
  	  //Wait for few sec
  	  
  	 waitForPageLoad();
     
     Thread.sleep(1000);
     
     waitForPageLoad();
     
     Thread.sleep(1000);
  	
    
  	//Move to Images tab
  		driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
  		
     //Wait for the button to appear
  		 wait = new WebDriverWait(driver, 180);
  	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
    
  	     Thread.sleep(1000);
  	 //First store parent window to switch back
       String parentWindow6 = driver.getWindowHandle(); 
       
       //Press the medialibrary button select image
       driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
       
     //Switch to new window opened
      	for(String winHandle : driver.getWindowHandles()){
      	    if(!winHandle.equals(parentWindow6)) {
      	        driver.switchTo().window(winHandle);
      	    }
      	}
          
          
      	waitForPageLoad();
      	
      	Thread.sleep(1000);
      	//Thread.sleep(15000);
  	
          driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image2)).click();
          
       	Thread.sleep(1000);
      	
      	     
      	 //Scroll Page down
        JavascriptExecutor jse7 = (JavascriptExecutor)driver;
        jse7.executeScript("window.scrollBy(0,250)", "");
        
        Thread.sleep(1000);
      	
      	
      	
      	//Confirm the images uploading details
      	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
      	     
      	 //Scroll Up
      	     
      	   JavascriptExecutor jse70 = (JavascriptExecutor)driver;
           jse70.executeScript("window.scrollBy(0,-250)", "");
           
           Thread.sleep(1000);
      	     //Switch back to parent window 
      	        driver.switchTo().window(parentWindow6);
      	        
      	      waitForPageLoad();
      	        
      	       Thread.sleep(1000);
      	
      	        
      driver.findElement(By.xpath(Testelements.Imagedelete)).click();
      
      Thread.sleep(1000);
      
      List<WebElement> li12= driver.findElements(By.xpath(Testelements.MediaLibrarySaveButton));
  	
      Thread.sleep(1000);
      
      if(li12.get(2).isEnabled())
      {
    	  System.out.println("Image deleted from product successfully as Save button gets enabled");
    	  
    	  test = extent.createTest("DeleteProductImage");
    	   
    	  test.log(Status.PASS, "Image deleted from product successfully as Save button gets enabled");
      
      }
      else{
    	  
          System.out.println("Image deleted from product unsuccessfully as Save button doesn't gets enabled");
    	  
    	  test = extent.createTest("DeleteProductImage");
    	   
    	  test.log(Status.FAIL, "Image deleted from product unsuccessfully as Save doesn't gets enabled"); 
          
       }
   
    //Goto Summary Tab
      driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
          
     //Wait for some time
      waitForPageLoad(); 
  	//Thread.sleep(10000);
  

    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
    
    wait = new WebDriverWait(driver, 180);
  	 
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
       
    Thread.sleep(6000);
  
    
    //Press the make changes active button after editing
    driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
    
  //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
  	 
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
       
       driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
       
       Thread.sleep(10000);

       //Wait for the product to be deleted
  	 wait = new WebDriverWait(driver, 120);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteProduct_Button)));
  	  
  	   
  	   //Press the sort By button
  	   driver.findElement(By.xpath(Testelements.DeleteProduct_Button)).click();
  	   
  	   //Wait
  		
  			Thread.sleep(2000);
  		
        driver.findElement(By.xpath(Testelements.DeleteAlert_Confirm)).click();
        
        waitForPageLoad();
  		
  		Thread.sleep(8000);
  		 //Press the sort By button
   	   driver.findElement(By.xpath(Testelements.DeleteProduct_Button)).click();
   	   
   	   //Wait
   		
   			Thread.sleep(2000);
   		
         driver.findElement(By.xpath(Testelements.DeleteAlert_Confirm)).click();
         
         waitForPageLoad();
   		
         Thread.sleep(8000);
  
  	  
  	  
  }catch(NoSuchElementException e){
  	e.getStackTrace();
  	
  }

  	  }
  	  
    @Test(priority=10)
    public void AddUpdate_Product_MultiplePriceGrid() throws InterruptedException{
     	try{
     	
     		wait = new WebDriverWait(driver, 120);
     	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProduct_button)));	
         
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
         
        // driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
         
         //Select the 2nd attribute
        // driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
         
         //Apply the New created color template
         driver.findElement(By.xpath(Testelements.ColorTemplateMenu)).click();
         
         driver.findElement(By.xpath(Testelements.ColorTemplateMenu_ApplyTemplateOption)).click();
         
         Thread.sleep(1000);
         
       //Select the NewLy created Size Template
    		WebElement ColorTemplateSelection = driver.findElement(By.xpath(Testelements.ColorTemplateSelection));
    	    Select dropdown34= new Select(ColorTemplateSelection);
          
    	   
    	    dropdown34.selectByVisibleText(Testdata.ColorTemplateName);
    	    
    	    Thread.sleep(2000);
    	    
    	    //Press the Apply Button
    	    driver.findElement(By.xpath(Testelements.ColorTemplateApplyButton)).click();
         
    	    Thread.sleep(3000);
    	    
    	    if(driver.findElement(By.xpath(Testelements.ColorTemplateApplyVerification1)).isDisplayed() & driver.findElement(By.xpath(Testelements.ColorTemplateApplyVerification2)).isDisplayed())
    	    {
    	    	System.out.println("New Color Template Applied Successfully");
    	    	
    	    	test = extent.createTest("NewColorTemplateApply");
    	     	   
          	    test.log(Status.PASS, "New Color Template Applied Successfully");
    	    }
    	    else{
    	  
                System.out.println("New Color Template Applied UnSuccessfully");
    	    	
    	    	test = extent.createTest("NewColorTemplateApply");
    	     	   
          	    test.log(Status.FAIL, "New Color Template Applied Successfully");
    	    }
    	    
    	    //Now Delete the Color Template
    	    driver.findElement(By.xpath(Testelements.ColorTemplateMenu)).click();
            
            driver.findElement(By.xpath(Testelements.ColorTemplateMenu_DeleteTemplateOption)).click();
            
            Thread.sleep(1000);
            
          //Select the NewLy created Size Template
       		WebElement ColorTemplateSelection45 = driver.findElement(By.xpath(Testelements.ColorTemplateSelection));
       	    Select dropdown341= new Select(ColorTemplateSelection45);
             
       	   
       	    dropdown341.selectByVisibleText(Testdata.ColorTemplateName);
       	    
       	    Thread.sleep(2000);
       	    
       	    //Press the Apply Button
       	    driver.findElement(By.xpath(Testelements.ColorTemplateApplyButton)).click();
            
       	    Thread.sleep(3000);
       	    
       	    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
       	    {
       	    	System.out.println("New Color Template Deleted Successfully");
       	    	
       	    	test = extent.createTest("NewColorTemplateDelete");
       	     	   
             	    test.log(Status.PASS, "New Color Template Deleted Successfully");
       	    }
       	    else{
       	  
                   System.out.println("New Color Template Deleted UnSuccessfully");
       	    	
       	    	    test = extent.createTest("NewColorTemplateDelete");
       	     	   
             	    test.log(Status.FAIL, "New Color Template Deleted Successfully");
       	    }
       	    
       	
         //Wait for few sec
         try {
  			Thread.sleep(2000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
         
         driver.findElement(By.xpath(Testelements.SizeTemplateMenu)).click();
   		
   		 Thread.sleep(2000);
         
         driver.findElement(By.xpath(Testelements.ApplyTemplateOption_SizeTemplateMenu)).click();
   		
   		//Select the NewLy created Size Template
   		WebElement SizeTemplateSelection = driver.findElement(By.xpath(Testelements.SizeTemplateSelection_Dropdown));
   	    Select dropdown3= new Select(SizeTemplateSelection);
         
   	   
   	    dropdown3.selectByVisibleText(Testdata.SizeTemplateName);
   	    
   	    Thread.sleep(2000);
   	    
   	    //Press the Apply Button
   	    driver.findElement(By.xpath(Testelements.SizeTemplateApplyButton)).click();
   	    
   	    if(driver.findElement(By.xpath(Testelements.SizeTemplateApply_Verification)).isDisplayed())
   	    {
   	    	System.out.println("Size Template Applied Successfully");
   	    	
   	    	test = extent.createTest("NewSizeTemplateApply");
     	   
      	    test.log(Status.PASS, "Size Template Applied Successfully");
   	    }
   	    else{
   	    	
            System.out.println("Size Template Applied UnSuccessfully");
   	    	
   	    	test = extent.createTest("NewSizeTemplateApply");
     	   
      	    test.log(Status.FAIL, "Size Template Applied UnSuccessfully");
   	    }
   		
   	 driver.findElement(By.xpath(Testelements.SizeTemplateMenu)).click();
		
		 Thread.sleep(2000);
     
     driver.findElement(By.xpath(Testelements.DeleteTemplateOption_SizeTemplateMenu)).click();
		
		//Select the NewLy created Size Template
		WebElement SizeTemplateSelection1 = driver.findElement(By.xpath(Testelements.SizeTemplateSelection_Dropdown));
	    Select dropdown13= new Select(SizeTemplateSelection1);
     
	   
	    dropdown13.selectByVisibleText(Testdata.SizeTemplateName);
	    
	    Thread.sleep(2000); 
   	    
	  //Press the Apply Button
   	    driver.findElement(By.xpath(Testelements.SizeTemplateApplyButton)).click();
   	    
   	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
		{
			System.out.println("New Size Template Deleted Successfully");
			
			test = extent.createTest("NewSizeTemplateDeletion");
		   	
			 test.log(Status.PASS, "New Size Template Deleted Successfully");
		}
		else{
			System.out.println("New Size Template Deleted UnSuccessfully");
			
			 test = extent.createTest("NewSizeTemplateDeletion");
		   	
			  test.log(Status.FAIL, "New Size Template Deleted UnSuccessfully");
			
		}
   	    //CLear the size area and validate
   	    driver.findElement(By.xpath(Testelements.ClearSizeButton)).click();
   	    
   	    if(driver.findElement(By.xpath(Testelements.SelectSize_Attributes)).getText().contains("(Select Size)"))
   	    {
   	    	System.out.println("Selected size Clear Successfully");
   	    	
   	    	test = extent.createTest("ClearSelectedSize");
		   	
			 test.log(Status.PASS, "Selected size Clear Successfully");
   	    	
   	    }
   	    else{
             System.out.println("Selected size Clear UnSuccessfully");
   	    	
   	    	test = extent.createTest("ClearSelectedSize");
		   	
			 test.log(Status.PASS, "Selected size Clear Successfully");
   	    }
   	 
   	 
   	      JavascriptExecutor jse900 = (JavascriptExecutor)driver;
          jse900.executeScript("window.scrollBy(0,-250)", "");
   		
          JavascriptExecutor jse901 = (JavascriptExecutor)driver;
          jse901.executeScript("window.scrollBy(-250,-500)", "");
          
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
         
     	
  		Thread.sleep(5000);
  		
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
  	
  	Thread.sleep(3000);
  	
    driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
  	
  	Thread.sleep(3000);
  	
  	driver.findElement(By.xpath(Testelements.MG_ListPrice1)).sendKeys("20");
  	
  	//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();
  	Thread.sleep(2000);
  	
   WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.MGP_PriceCode1));
   Select dropdown72= new Select(mySelectElement72);

   dropdown72.selectByVisibleText("L 70%");
   
   Thread.sleep(2000);
  		
    List<WebElement> ResetButtonPricing= driver.findElements(By.xpath(Testelements.ResetButtonValidation_Upcharges));
         
         if(ResetButtonPricing.get(0).isDisplayed()){
         	
         	System.out.print("Reset Button on bottom right side displayed successfully");
         	
         	test = extent.createTest("Reset Button Validation On Pricing");
            
           	test.log(Status.PASS, "Reset Button Validation On Pricing successfully");
         }
         else{
         	
         	System.out.print("Reset Button on bottom right side displayed unsuccessfully");
         	
         	test = extent.createTest("Reset Button Validation On Pricing");
            
           	test.log(Status.FAIL, "Reset Button Validation On Pricing unsuccessfully");
         }
       
         List<WebElement> DeleteButtonPricing= driver.findElements(By.xpath(Testelements.DeleteButtonValidation_Upcharges));
         
         //Validating Delete Button on upcharge 
         if(DeleteButtonPricing.get(0).isDisplayed()){
         	
         	System.out.print("Delete Button on bottom right side displayed successfully");
         	
         	test = extent.createTest("Delete Button Validation On Pricing");
            
           	test.log(Status.PASS, "Delete Button Validation On Pricing successfully");
         }
         else{
         	
         	System.out.print("Delete Button on bottom right side displayed unsuccessfully");
         	
         	test = extent.createTest("Delete Button Validation On Pricing");
            
           	test.log(Status.FAIL, "Delete Button Validation On Pricing unsuccessfully");
         }
         
        
      	//Validating the glyphicon icon
     List<WebElement> GlyphiconIconPricing= driver.findElements(By.xpath(Testelements.ResetButtonValidation_Upcharges));
         
         if(GlyphiconIconPricing.get(0).isDisplayed()){
         	
         	System.out.print("GlyphiconIcon on bottom right side displayed successfully");
         	
         	test = extent.createTest("GlyphiconIcon Validation On Pricing");
            
           	test.log(Status.PASS, "GlyphiconIcon Validation On Pricing successfully");
         }
         else{
         	
         	System.out.print("GlyphiconIcon on bottom right side displayed unsuccessfully");
         	
         	test = extent.createTest("GlyphiconIcon Validation On Pricing");
            
           	test.log(Status.FAIL, "GlyphiconIcon Validation On Pricing unsuccessfully");
         }
      	  	
     	
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
  	
  	Thread.sleep(2000);
  	
  	 WebElement mySelectElement100 = driver.findElement(By.xpath(Testelements.MGP_PriceCode2));
	    Select dropdown100= new Select(mySelectElement100);
	   
	    dropdown100.selectByVisibleText("L 70%");

	  	Thread.sleep(2000);
  	
  //Scroll up
    JavascriptExecutor jse110 = (JavascriptExecutor)driver;
    jse110.executeScript("window.scrollBy(0,-250)", "");
    
  //Scroll up
    JavascriptExecutor jse111 = (JavascriptExecutor)driver;
    jse111.executeScript("window.scrollBy(-250,-500)", "");
    
    JavascriptExecutor jse112 = (JavascriptExecutor)driver;
    jse112.executeScript("window.scrollBy(-500,-750)", "");
    
    JavascriptExecutor jse113 = (JavascriptExecutor)driver;
    jse113.executeScript("window.scrollBy(-750,-1000)", "");
    
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
	
 	
 	//Switch back to parent window 
    driver.switchTo().window(parentWindow17);
	  
 	
 	//Expand the first grid
 	driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
 	
    
	Thread.sleep(2000);
	
 //Validating Reset Button on upcharge	
    
    List<WebElement> ResetButtonUpcharge= driver.findElements(By.xpath(Testelements.ResetButtonValidation_Upcharges));
    
    if(ResetButtonUpcharge.get(5).isDisplayed()){
    	
    	System.out.print("Reset Button on bottom right side displayed successfully");
    	test = extent.createTest("Reset Button Validation On Upcharges");
       
      	test.log(Status.PASS, "Reset Button Validation On Upcharges successfully");
    }
    else{
    	
    	System.out.print("Reset Button on bottom right side displayed unsuccessfully");
    	test = extent.createTest("Reset Button Validation On Upcharges");
       
      	test.log(Status.FAIL, "Reset Button Validation On Upcharges unsuccessfully");
    }
  
    List<WebElement> DeleteButtonUpcharge= driver.findElements(By.xpath(Testelements.DeleteButtonValidation_Upcharges));
    
    //Validating Delete Button on upcharge 
    if(DeleteButtonUpcharge.get(5).isDisplayed()){
    	
    	System.out.print("Delete Button on bottom right side displayed successfully");
    	test = extent.createTest("Delete Button Validation On Upcharges");
       
      	test.log(Status.PASS, "Delete Button Validation On Upcharges successfully");
    }
    else{
    	
    	System.out.print("Delete Button on bottom right side displayed unsuccessfully");
    	
    	test = extent.createTest("Delete Button Validation On Upcharges");
       
      	test.log(Status.FAIL, "Delete Button Validation On Upcharges unsuccessfully");
    }
    
  
	//Validating the glyphicon icon
 List<WebElement> GlyphiconIconUpcharges= driver.findElements(By.xpath(Testelements.ResetButtonValidation_Upcharges));
     
     if(GlyphiconIconUpcharges.get(5).isDisplayed()){
     	
     	System.out.print("GlyphiconIcon on bottom right side displayed successfully");
     	
     	test = extent.createTest("GlyphiconIcon Validation On Upcharges");
        
       	test.log(Status.PASS, "GlyphiconIcon Validation On Upcharges successfully");
     }
     else{
     	
     	System.out.print("GlyphiconIcon on bottom right side displayed unsuccessfully");
     	
     	test = extent.createTest("GlyphiconIcon Validation On Upcharges");
        
       	test.log(Status.FAIL, "GlyphiconIcon Validation On Upcharges unsuccessfully");
     }
    
     //Enter details into fields
     List<WebElement> QuantityUpcharge1 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
     QuantityUpcharge1.get(20).sendKeys("2");
 
  	
  	Thread.sleep(2000);
  	
  	
  	List<WebElement> PriceUpcharge1=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
  	PriceUpcharge1.get(20).sendKeys("10");
  	
  	Thread.sleep(2000);
    
   List<WebElement> mySelectElement92 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
   Select dropdown79= new Select(mySelectElement92.get(23));

    dropdown79.selectByVisibleText("G/V 20%");
    
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
  	
  	//driver.findElement(By.xpath(Testelements.UpchargeGrid2_Expand)).click();
   	
    
  	//Thread.sleep(2000);
  	
  	//driver.findElement(By.xpath(Testelements.UpchargeGrid2_Expand)).click();
   	
    
  	//Thread.sleep(2000);
  	
  	
   	
      //Enter quantity
  	 //Enter details into fields
    List<WebElement> QuantityUpcharge2 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Quantity));
    QuantityUpcharge2.get(30).sendKeys("2");

 	
 	Thread.sleep(2000);
 	
 	
 	List<WebElement> PriceUpcharge2=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
 	PriceUpcharge2.get(30).sendKeys("10");
 	
 	Thread.sleep(2000);
   
  List<WebElement> mySelectElement93 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Pricecodes));
  Select dropdown93= new Select(mySelectElement93.get(33));

   dropdown93.selectByVisibleText("G/V 20%");
   
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
	   
	   if(driver.findElement(By.cssSelector(Testelements.SaveButton_AfterImageDragandDrop_Change)).isEnabled()){
    	   
       
	   System.out.println("Drag Image from one Position to another with save button enabled Sucessfully ");
	   test = extent.createTest("Drag Image from one Position to another with save button enabled");
	   test.log(Status.PASS, "Drag Image from one Position to another with save button enabled Sucessfully");
   
       }
       else{
    	   
    	   System.out.println("Drag Image from one Position to another with save button enabled UnSucessfully ");
    	   test = extent.createTest("Drag Image from one Position to another with save button enabled");
    	    test.log(Status.FAIL, "Drag Image from one Position to another with save button enabled UnSucessfully");
    	   
       }
   //Go to sku inventory
   driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
   
  
   waitForPageLoad();
   
   //Thread.sleep(12000);
  	
   
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
     	   	
    	
        //Goto to Upcharge again by editing the details
        driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	       
	       waitForPageLoad();
	       
	       Thread.sleep(1000);
	       
	       waitForPageLoad();
	       
	       Thread.sleep(1000);
	       
	   //Go to Attributes Tab first
	       driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
	       
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
	         
	       Thread.sleep(2000);
	       
	       //Select the attribute Brown this time
	       driver.findElement(By.xpath(Testelements.Bulkcolor_Brown)).click();
	       
	       Thread.sleep(3000);
	       
	       // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        alert.accept();		
	        
	        Thread.sleep(2000);
	       
	       
	       //Open the pricing tab
	       driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	         
	       waitForPageLoad();
	         
	       Thread.sleep(2000);
	       
	       //Press the Click to Continue button to another color attribute
	       driver.findElement(By.xpath(Testelements.ClickToContinue_Button_Pricing)).click();
	       
	       Thread.sleep(2000);
	       
	       //Select another color
	       driver.findElement(By.xpath(Testelements.BrownColor_Selection_Multipricing)).click();
	       
	       //Press save configuration
	       driver.findElement(By.xpath(Testelements.SaveConfig)).click();
	       
	       waitForPageLoad();
	         
	       Thread.sleep(4000);
	       
	       WebElement NewColorAdded_MultiGrid=driver.findElement(By.xpath(Testelements.NewAttributeAddedAtPricing_AfterEditing_Verification));
	 	  String  NewAttribute_Verification=NewColorAdded_MultiGrid.getAttribute("value");
	 	  
	 	   System.out.println(NewAttribute_Verification);
	 	   
	 	   if(NewAttribute_Verification.contains("Brown"))
	 	   {
	 		   System.out.println("Price Grids are displaying for Criteria Values that are added later Successfully");
	 		   
	 		   test = extent.createTest("PriceGridsCriteria_AddedLater");
	 		   	
	 		   test.log(Status.PASS, "Price Grids are displaying for Criteria Values that are added later Successfully ");
	 	   }
	 	   else{
	           System.out.println("Price Grids are displaying for Criteria Values that are added later UnSuccessfully");
	 		   
	 		   test = extent.createTest("PriceGridsCriteria_AddedLater");
	 		   	
	 		   test.log(Status.FAIL, "Price Grids are displaying for Criteria Values that are added later UnSuccessfully ");
	 		   
	 	   }
	         
	       driver.findElement(By.xpath(Testelements.DeleteGridButton_Multipricing)).click();
	       
	       waitForPageLoad();
	         
	       Thread.sleep(2000);
	       
	       waitForPageLoad();
	         
	       Thread.sleep(7000);
	       
	       
	       
	       WebElement mySelectElement7212 = driver.findElement(By.xpath(Testelements.Copy_SecondGrid_DropdownValue));
			Select dropdown7212= new Select(mySelectElement7212);

			dropdown7212.selectByVisibleText("Pink");
			
			//Press the Copy Button
			driver.findElement(By.xpath(Testelements.Copy_SecondGrid_Button)).click();
			
			Thread.sleep(2000);
			
			 List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.CollapseGridVerification_AfterCopyingGrid));
		       
		       int count=elementcount.size();
		       
		       System.out.println(count);
		       
		       if(count==0)
		       {
		          System.out.println("Price Grid doesn't collapses after copying another grid Successfully");
		          
		          test = extent.createTest("PriceGridAfterCopyAnotherGrid");
		 		   	
		 		 test.log(Status.PASS, "Price Grid doesn't collapses after copying another grid Successfully");
		     	  
		        }
		       else{
		    	   System.out.println("Price Grid doesn't collapses after copying another grid Successfully");
			          
			        test = extent.createTest("PriceGridAfterCopyAnotherGrid");
			 		   	
			 	test.log(Status.FAIL, "Price Grid doesn't collapses after copying another grid UnSuccessfully");
		       }
	       
	       JavascriptExecutor jse701 = (JavascriptExecutor)driver;
	       jse701.executeScript("window.scrollBy(0,-250)", "");
	       
	       JavascriptExecutor jse711 = (JavascriptExecutor)driver;
	       jse711.executeScript("window.scrollBy(-250,-500)", "");
	       
	       JavascriptExecutor jse721 = (JavascriptExecutor)driver;
	       jse721.executeScript("window.scrollBy(-500,-750)", "");
	       
	       Thread.sleep(1000);
	 	   
	 	   
	 	   driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
	    	
	    	
	   	   Thread.sleep(2000);
	   	   
	   	driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
	   	
	   	Thread.sleep(3000);
	  	
	   	List<WebElement> Pricing_ListPricing2QUR_Clear = driver.findElements(By.xpath(Testelements.ResetGrid));
		Pricing_ListPricing2QUR_Clear.get(5).click();
		
		driver.findElement(By.xpath(Testelements.ConfirmResetGrid)).click();
		
		Thread.sleep(2000);
		
		List<WebElement> QuantityValue_Verify=driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
		String QuantityValue_VerifyDetails=QuantityValue_Verify.get(20).getAttribute("value");
		System.out.println(QuantityValue_VerifyDetails);
		
		if(QuantityValue_VerifyDetails.isEmpty())
		{
			System.out.println("Quantity value gets empty after resetting grid successfully");
			
			test = extent.createTest("QuantityFieldResetting_ResetApply");
        	 
       	  test.log(Status.PASS, "Quantity value gets empty after resetting grid successfully");
		}
		else{
           System.out.println("Quantity value gets empty after resetting grid unsuccessfully");
			
			test = extent.createTest("QuantityFieldResetting_ResetApply");
        	 
       	   test.log(Status.FAIL, "Quantity value gets empty after resetting grid unsuccessfully");
		}
		
		//Enter details into fields
	     List<WebElement> QuantityUpcharge12 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
	     QuantityUpcharge12.get(20).sendKeys("2");
	 
	  	
	  	Thread.sleep(2000);
	  	
	  	
	  	List<WebElement> PriceUpcharge12=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	  	PriceUpcharge12.get(20).sendKeys("10");
	  	
	  	Thread.sleep(2000);
	    
	   List<WebElement> mySelectElement922 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
	   Select dropdown792= new Select(mySelectElement922.get(23));

	    dropdown792.selectByVisibleText("G/V 20%");
	    
	    Thread.sleep(4000);
		
	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
  		
  		//Now Press the changes Save effect link
  		
  		 wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
       
        
    	Thread.sleep(4000);
    	
       
       //Make chnages Active
       driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
      
       //Wait for the button to appear
    	 wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
         
         driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
         
         
    	 Thread.sleep(8000);
		
	    
        
    	} catch(NoSuchElementException e){
        	e.getStackTrace();
        	
  	}
      	  
    }

    @Test(priority=11)
  	public void BulKEdit() throws InterruptedException {
  		try{
  		
  			waitForPageLoad();
  			
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
  	     	  
  			   Thread.sleep(3000);
  				
  	 			List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  	 		  	li1.get(2).click();
  	
  			   Thread.sleep(1000);
  		
  		
  			 //Select the Market Segment Option from Bulk Edit
  			   driver.findElement(By.xpath(Testelements.MarketSegment_BulkEdit_Option)).click();
  			   
  			   
  			//Now Press the bulk Edit Button
  		  		List<WebElement> li17= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
  				li17.get(8).click();
  				
  		    Thread.sleep(1000);
  		    
  		    driver.findElement(By.xpath(Testelements.MarketSegment_RemoveButton_BulkEdit)).click();
  		    
  		    Thread.sleep(1000);
  		    
  		    if(driver.getCurrentUrl().contains("stage")){
  		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
  		    
  		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_BulkEdit)).click();
  		    
  		    Thread.sleep(1000);
  		    }
  		    else{
  		 
  		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
		    
		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_BulkEdit)).click();
		    
		    Thread.sleep(1000);
		    
            driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
		    
		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Second)).click();
		    
		    Thread.sleep(1000);
		    
		    
  		    }
  		    
  		    //Press the Save and Apply Button
  		    driver.findElement(By.xpath(Testelements.BulkEdit_MarketSegment_SaveandApply)).click();
  				
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
	  	   
	  	   if(driver.findElement(By.xpath(Testelements.MarketSegmentBulkEditRemove_Verification)).isDisplayed())
	  	   {
	  		   System.out.println("Market Bulk Edit Remove done Successfully");
	  	   
	  		 test = extent.createTest("BulkEdit_MarketSegment_Remove");
        	 
	       	  test.log(Status.PASS, "Market Bulk Edit Remove done Successfully");
	  	   
	  	   }
	  	   else{
	  		 System.out.println("Market Bulk Edit Remove done UnSuccessfully");
	  	   
	  		test = extent.createTest("BulkEdit_MarketSegment_Remove");
       	 
	       	  test.log(Status.FAIL, "Market Bulk Edit Remove done UnSuccessfully");
	  	   
	  	   }
  			   
	  	 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();  
	  	 
	  	 
	  	 //Wait for the alert to appear
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
	       
	       Thread.sleep(2000);
	  
	       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		   Thread.sleep(1000);
		    
		 //First store parent window to switch back
  	       String parentWindow91 = driver.getWindowHandle();

  	     //Press the bulk edit button
  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
  	        
  	       //Switch to new window opened
  	     	for(String winHandle : driver.getWindowHandles()){
  	     	    if(!winHandle.equals(parentWindow91)) {
  	     	        driver.switchTo().window(winHandle);
  	     	    }
  	     	}
  	     	  
  			   Thread.sleep(3000);
  				
  	 			List<WebElement> li111= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  	 		  	li111.get(2).click();
  	
  			   Thread.sleep(1000);
  		
  		
  			 //Select the Market Segment Option from Bulk Edit
  			   driver.findElement(By.xpath(Testelements.MarketSegment_BulkEdit_Option)).click();
  			   
  			   
  			//Now Press the bulk Edit Button
  		  		List<WebElement> li117= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
  				li117.get(8).click();
  				
  		    Thread.sleep(1000);
  		    
  		    driver.findElement(By.xpath(Testelements.MarketSegment_AddMarketSegment_BulkEdit)).click();
  		    
  		    Thread.sleep(1000);
  		    if(driver.getCurrentUrl().contains("stage"))
  		    {	
  		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
  		    
  		    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_BulkEdit)).click();
  		    
  		    Thread.sleep(1000);
  		    }
  		    else{
  		    	driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
  			    
  			    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_BulkEdit)).click();
  			    
  			    Thread.sleep(1000);
  			    
  	            driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Dropdown)).click();
  			    
  			    driver.findElement(By.xpath(Testelements.MarketSegmentSelection_Second)).click();
  			    
  			    Thread.sleep(1000);
  		    }
  		    //Press the Save and Apply Button
  		    driver.findElement(By.xpath(Testelements.BulkEdit_MarketSegment_SaveandApply)).click();
  				
  		  wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)));
		     
		    Thread.sleep(3000);
	  		    
	  		    driver.findElement(By.xpath(Testelements.BulkRemove_SEOFlag_EmailConfirm)).click();	 	  		    
	  		    
	  		Thread.sleep(2000);
	  		
	  		driver.navigate().refresh();
	  		
	  		 wait = new WebDriverWait(driver, 180);
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
	  		
	  		Thread.sleep(3000);
	  	//Press the Edit button from first product and validate Bulk Base pricing for QUR on usd grids
	  	   driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  	   
	  	   waitForPageLoad();
	  	   
	  	   Thread.sleep(1000);
	  	   
	  	   if(driver.getCurrentUrl().contains("stage"))
	  	   {
	  	 if(driver.findElement(By.xpath(Testelements.MarketSegmentBulkEditAdd_Verification)).isDisplayed())
	  	   {
	  		   System.out.println("Market Bulk Edit Add done Successfully");
	  	   
	  		 test = extent.createTest("BulkEdit_MarketSegment_Add");
      	 
	       	  test.log(Status.PASS, "Market Bulk Edit Remove done Successfully");
	  	   
	  	   }
	  	   else{
	  		 System.out.println("Market Bulk Edit Remove done UnSuccessfully");
	  	   
	  		  test = extent.createTest("BulkEdit_MarketSegment_Add");
     	 
	       	  test.log(Status.FAIL, "Market Bulk Edit Add done UnSuccessfully");
	  	   
	  	   }  
	  	   }
	  	   else if(driver.getCurrentUrl().contains("uat"))
	  		   
	  	   {
          
	  		 if(driver.findElement(By.xpath(Testelements.MarketSegmentMultiCountry_Verification_BasicDetails_Screen)).isDisplayed())
		  	   {
		  		   System.out.println("Market Bulk Edit Add done Successfully");
		  	   
		  		 test = extent.createTest("BulkEdit_MarketSegment_Add");
	      	 
		       	  test.log(Status.PASS, "Market Bulk Edit Remove done Successfully");
		  	   
		  	   }
		  	   else{
		  		 System.out.println("Market Bulk Edit Remove done UnSuccessfully");
		  	   
		  		  test = extent.createTest("BulkEdit_MarketSegment_Add");
	     	 
		       	  test.log(Status.FAIL, "Market Bulk Edit Add done UnSuccessfully");
		  	   
		  	   }     
	  	   }  
	  	   else{
	  		 if(driver.findElement(By.xpath(Testelements.MarketSegmentMultiCountry_Verification_BasicDetails_Screen)).isDisplayed())
		  	   {
		  		   System.out.println("Market Bulk Edit Add done Successfully");
		  	   
		  		 test = extent.createTest("BulkEdit_MarketSegment_Add");
	      	 
		       	  test.log(Status.PASS, "Market Bulk Edit Remove done Successfully");
		  	   
		  	   }
		  	   else{
		  		 System.out.println("Market Bulk Edit Remove done UnSuccessfully");
		  	   
		  		  test = extent.createTest("BulkEdit_MarketSegment_Add");
	     	 
		       	  test.log(Status.FAIL, "Market Bulk Edit Add done UnSuccessfully");
		  	   
		  	   }     
	  		   
	  	   }
	  		   
	  	   driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
          
         //Wait for the alert to appear
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
	       
	       Thread.sleep(2000);
	  
	       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		   Thread.sleep(1000);   
  			   
		   //Press the bulk edit button
 			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();    
 			
 			  Thread.sleep(3000);
				
	 			List<WebElement> li1111= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 		  	li1111.get(2).click();
	
			   Thread.sleep(1000);
			   
			   //Now scroll inside the popup of bulk edit to go to that element
  		EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(driver);
  		
  		eventFiringWebDriver.executeScript("document.querySelector('#bulkEditOptionsModal > div.modal-body').scrollTop=500");
  		
  		Thread.sleep(2000);
  		
  		//Press the Add Catalog Source
  		driver.findElement(By.xpath(Testelements.AddCatalogSource_BulkEdit)).click();
  		
  		Thread.sleep(1000);
  		
  		//Now Press the bulk Edit Button
  		List<WebElement> li7= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
		li7.get(8).click();
		
		
		waitForPageLoad();
		
		//Thread.sleep(15000);
  		
  		//Now press the Catalog dropdown
  		driver.findElement(By.xpath(Testelements.CatalogSelectionDropdown)).click();
  		
  		Thread.sleep(1000);
  		
  		//Select the option now
  		driver.findElement(By.xpath(Testelements.CatalogSelection)).click();
  		
  		//Press the Bulk Save button
  		driver.findElement(By.xpath(Testelements.CatalogSaveButton)).click();
  		
  		Thread.sleep(3000);
  		
  		//Wait for the confirmation message to be appear
  		driver.findElement(By.cssSelector(Testelements.CatalogSaveMailAlert)).click();
  		
  		Thread.sleep(3000);
  		
  	   //Refresh the Page
  		driver.navigate().refresh();
  		
  		waitForPageLoad();
  		
  		Thread.sleep(7000);
  		
  		
  		
  		//Make the changes Active
  		driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
  		
  		Thread.sleep(8000);
  		if(driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).isDisplayed()){
  			
  		
  		//Now select the ok to confirm the details
  		driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
        
  		System.out.println("Catalog Added successfully to the Product");
  		test = extent.createTest("Add Catalog Source");
  	    test.log(Status.PASS, "Catalog Added successfully to the Product");
  	  	
  		}
  		else{
  			
  			System.out.println("Catalog Added unsuccessfully to the Product");
  			test = extent.createTest("Add Catalog Source");
  	  	    test.log(Status.FAIL, "Catalog Added Unsuccessfull to the Product");
  	  	  	}
        Thread.sleep(15000);
  	   //Now delete the added catalog from the products
    
  		
  	  driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	
  	  Thread.sleep(1000);
		
  		//First store parent window to switch back
  	  String parentWindow90 = driver.getWindowHandle();

  	    //Press the bulk edit button
  	   driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
  	        
  	       //Switch to new window opened
  	     	for(String winHandle : driver.getWindowHandles()){
  	     	    if(!winHandle.equals(parentWindow90)) {
  	     	        driver.switchTo().window(winHandle);
  	     	    }
  	     	}
  	     	  
  			Thread.sleep(3000);
  				
  			List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  	 		 li9.get(2).click();
  		

  			Thread.sleep(2000);
  		
  		//Now scroll inside the popup of bulk edit to go to that element
  		EventFiringWebDriver eventFiringWebDriver1=new EventFiringWebDriver(driver);
  		
  		eventFiringWebDriver1.executeScript("document.querySelector('#bulkEditOptionsModal > div.modal-body').scrollTop=500");
  		
  		Thread.sleep(2000);
  		
  		//Now Press the delete catalog option from bulk Edit Popup
  		driver.findElement(By.xpath(Testelements.DeleteCatalogSource_BulkEdit)).click();
  		
  		Thread.sleep(1000);
  		
  		 
  	//Now Press the bulk Edit Button
  		List<WebElement> li10= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
		li10.get(8).click();
		
		Thread.sleep(4000);
		
		//Insert the catlog which want you to delete
	WebElement CatalogSource=driver.findElement(By.xpath(Testelements.CatalogSource_InsertionField));
		
	CatalogSource.sendKeys("CAT link on 8 sept");
	
	Thread.sleep(5000);
	
	CatalogSource.sendKeys(Keys.ENTER);
	
	Thread.sleep(5000);
	
	//Press the save button
	driver.findElement(By.cssSelector(Testelements.CatalogDelete_SaveButton)).click();
	
	Thread.sleep(5000);
	
	//Press the email alert message
	driver.findElement(By.cssSelector(Testelements.EmailNotificationalert_Confirm)).click();
	
	//Refresh the Page
	driver.navigate().refresh();
	
	Thread.sleep(8000);
	
	//Make the changes Active
		driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		
		Thread.sleep(8000);
		if(driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).isDisplayed()){
			
		
		//Now select the ok to confirm the details
		driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
      		
		System.out.println("Catalog Source Deleted successfully from the Product");
		
		test = extent.createTest("Delete Catalog Source");
	    
	  	test.log(Status.PASS, "Catalog Source Deleted successfully from the Product");
	  	
		}
		else{
		
		System.out.println("Catalog Source Deleted unsuccessfully from the Product");
		
		test = extent.createTest("Delete Catalog Source");
	  	    
	  	test.log(Status.FAIL, "Catalog Source deletion Unsuccessfull from the Product");
	  	  	
			
		}
		
        Thread.sleep(10000);
		
		driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
  		
        Thread.sleep(1000);
  		
  		//First store parent window to switch back
  	       String parentWindow92 = driver.getWindowHandle();

  	     //Press the bulk edit button
  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
  	        
  	       //Switch to new window opened
  	     	for(String winHandle : driver.getWindowHandles()){
  	     	    if(!winHandle.equals(parentWindow92)) {
  	     	        driver.switchTo().window(winHandle);
  	     	    }
  	     	}
  	     	  
  	           Thread.sleep(10000);
  				
  	 			List<WebElement> li11= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  	 		  	li11.get(2).click();
  		
  		       Thread.sleep(4000);
  		
		//Press the keyword option
  		 driver.findElement(By.xpath(Testelements.Bulk_keyword)).click();
		  
		 Thread.sleep(1000);
		
  		//Press the bulk edit poup button
  		
		  //Press the keyword option
	  		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
			li8.get(8).click();
	  		
  			Thread.sleep(2000);
  		
  		//Press the keyword option
  	    driver.findElement(By.xpath(Testelements.BulkEdit_AddKeyword)).click();
  	    
  	    //Wait 
  		Thread.sleep(2000);
  		
  	    
  	    //Enter Keyword
  	    driver.findElement(By.xpath(Testelements.BulkEdit_AddKeywordInsert)).sendKeys("Pro1");
  	   
  	    Thread.sleep(1000);
  		
  	    driver.findElement(By.xpath(Testelements.BulkEdit_AddKeywordInsert)).sendKeys(Keys.ENTER);
  	   
  	    //Wait
  		    
  		 Thread.sleep(2000);
  			
  		 //Enter Keyword
  		  driver.findElement(By.xpath(Testelements.BulkEdit_AddKeywordInsert)).sendKeys("Pro2");
  		    
  		  Thread.sleep(1000);
  			
  		  //Enter Keyword
  		    driver.findElement(By.xpath(Testelements.BulkEdit_AddKeywordInsert)).sendKeys(Keys.ENTER);
  		    
  		    //Wait 
  	 	  Thread.sleep(1000);
  			
  	 	//Press the Add button
  	 		  driver.findElement(By.cssSelector(Testelements.Addkeywordpopbutton)).click();
  	 		  
  	   //Wait
  	 		  
  		 Thread.sleep(6000);
  			
    //Press oK on success message
  	 		  driver.findElement(By.xpath(Testelements.KeywordAdd_OK)).click();
  	 		  
  	   //Wait
  	        Thread.sleep(3000);
  			
  	    
  	 		//Switch back to parent window 
  		      driver.switchTo().window(parentWindow9);
  				
  	      	driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
  			
  	        Thread.sleep(1000);
  			
  			//First store parent window to switch back
  		    String parentWindow11 = driver.getWindowHandle();

  		     //Press the bulk edit button
  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
  		        
  		       //Switch to new window opened
  		     	for(String winHandle : driver.getWindowHandles()){
  		     	    if(!winHandle.equals(parentWindow11)) {
  		     	        driver.switchTo().window(winHandle);
  		     	    }
  		     	}
  		     	 Thread.sleep(3000);
  					
  		 		//Press the selected product radio button on bulk edit popup
  		 		 List<WebElement> li2= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  		 		 li2.get(2).click();
  		
  				 Thread.sleep(1000);
  			
  			
  			//Press the keyword option
  			 driver.findElement(By.xpath(Testelements.Bulk_Addcolor)).click();
		 	 
  			//Press the bulk edit poup button
		 	List<WebElement> li70= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
			li70.get(8).click();
	  			
			waitForPageLoad();
			
			Thread.sleep(1000);

			waitForPageLoad();
			
			Thread.sleep(1000);
  			
  	    
  		   // Wait for attributes to appear
          
    		Thread.sleep(2000);
    		
            driver.findElement(By.xpath(Testelements.Bulkcolor_Brown)).click();
            
            
  			Thread.sleep(2000);
  			
            
            driver.findElement(By.xpath(Testelements.BulkColor_ApplyButton)).click();
            
            
  			Thread.sleep(5000);
  			
           //Press the OK button after selection of color
            driver.findElement(By.xpath(Testelements.ColorOk_BulkEdit)).click();
            //Wait
            
			Thread.sleep(6000);
			
			if(driver.findElement(By.cssSelector(Testelements.BulkColorSaveSuccess_Validation)).getText().contains("Success"))
            
			{
			 System.out.println("Bulk Edit For Add Color successfull");
				
			 test = extent.createTest("BulkEdit For Add Color");
			      
			 test.log(Status.PASS, "Bulk Edit For Add Color successfull");
			}
			else{
				
			System.out.println("Bulk Edit For Add Color unsuccessfull");
				
			test = extent.createTest("BulkEdit For Add Color");
			     
		    test.log(Status.FAIL, "Bulk Edit For Add Color unsuccessfull");
			}
            driver.findElement(By.cssSelector(Testelements.BulkColor_Success)).click();
            
            Thread.sleep(30000);
  			
  	    
          //Switch back to parent window 
  		      driver.switchTo().window(parentWindow11);
            
     
  	 	
  	//Now Adding Custom Options new values to the existing product
  	 	
  	 	driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			
	        
		Thread.sleep(1000);
			
	 //First store parent window to switch back
	   String parentWindow16 = driver.getWindowHandle();

		 //Press the bulk edit button
		driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
		        
		       //Switch to new window opened
		     	for(String winHandle : driver.getWindowHandles()){
		     	    if(!winHandle.equals(parentWindow16)) {
		     	        driver.switchTo().window(winHandle);
		     	    }
		     	}
		     	  
		     	
		 			
				Thread.sleep(2000);
					
		 		
		 		//Press the selected product radio button on bulk edit popup
		 		 List<WebElement> li13= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
		 		 li13.get(2).click();
  	 	
  	          
		 		//Now scroll inside the popup of bulk edit to go to that element
		   		EventFiringWebDriver eventFiringWebDriver2=new EventFiringWebDriver(driver);
		   		
		   		eventFiringWebDriver2.executeScript("document.querySelector('#bulkEditOptionsModal > div.modal-body').scrollTop=500");
		   		
		   		Thread.sleep(1000);
  		
		   		//Select the Add Option from bulkEdit Popup
		   		driver.findElement(By.xpath(Testelements.AddOption_BulkEdit)).click();
		   		
		   		//Press the bulkEdit Button
		   	//Press the bulk edit poup button
			 	List<WebElement> li71= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
				li71.get(8).click();
				
				Thread.sleep(2000);
				
				 //First store parent window to switch back
			       String parentWindow19 = driver.getWindowHandle();
				
				
				//Now Press Yes Button for adding Option
			       driver.findElement(By.cssSelector(Testelements.AddCustomOptionAlert_Yes_Click)).click();
		         
		         
		  		Thread.sleep(2000);
		  
		         
		         //Switch to new window opened
		     	for(String winHandle : driver.getWindowHandles()){
		     	    if(!winHandle.equals(parentWindow19)) {
		     	        driver.switchTo().window(winHandle);
		     	    }
		     	}
		         
		         
		       Thread.sleep(3000);
		  		
		         //Select the option type
		       Select OptionType= new Select(driver.findElement(By.cssSelector(Testelements.CustomOption_OptionType)));
		       OptionType.selectByVisibleText("Product");
		       
		       //Now Enter the Product Name
		       driver.findElement(By.cssSelector(Testelements.CustomOption_OptionName)).sendKeys("Product 3");
		       
		       //Enter the Customk Option Value
		       WebElement OptionValue=driver.findElement(By.cssSelector(Testelements.CustomOption_OptionValue));
		       OptionValue.sendKeys("4");
		       OptionValue.sendKeys(Keys.ENTER);
		       
		       Thread.sleep(3000);
		       
		       //Press the Bulk Save Button
		       driver.findElement(By.cssSelector(Testelements.CustomOption_BulkSaveButton)).click();
		       
		       Thread.sleep(8000);
		       
		       //Accept the windows based alert
		    // Switching to Alert        
		        Alert alert = driver.switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage= driver.switchTo().alert().getText();		
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);	
		        Thread.sleep(5000);
		        		
		        // Accepting alert		
		        alert.accept();		
		        
		        Thread.sleep(2000);
		       
		       
		       
		       
		       //Press the cancel Button
		       driver.findElement(By.cssSelector(Testelements.CustomOption_CancelOption)).click();
		       
		       Thread.sleep(2000);
		       
		       //Go to Edit Product
		       
		       driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		       
		       waitForPageLoad();
		       
		       Thread.sleep(1000);
		       
		       waitForPageLoad();
		       
		       Thread.sleep(1000);
		       
		       //Press the Attributes Tab
		       
		       driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
		       
		       wait = new WebDriverWait(driver, 180);
		         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
		         
		         
		  		Thread.sleep(2000);
		  		
		  		if(driver.findElement(By.xpath(Testelements.CustomOptions_NewOptionValidation)).getText().equals("Product 3")){
		  			
		  			System.out.println("New Custom Option Added Sucessfully");
		  			 
		  			test = extent.createTest("BulkEdit Add New Custom Option");
		  		     
		  			test.log(Status.PASS, "New Custom Option Added Successfully");
		  			
		  		}
		  		
		  		else{
		  			System.out.println("New Custom Option Unsuccessfull");
		  			 
		  			test = extent.createTest("BulkEdit Add New Custom Option");
		  		     
		  		  	 test.log(Status.FAIL, "New Custom Option Added Unsuccessfull");
		  			
		  			
		  		}
		  		//Now goto Manage Product Screen Again
		  		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  		
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
		    	 
		    //Now Add values to Option
		    	 
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
		  	 	
		  	          
				 		//Now scroll inside the popup of bulk edit to go to that element
				   		EventFiringWebDriver eventFiringWebDriver3=new EventFiringWebDriver(driver);
				   		
				   		eventFiringWebDriver3.executeScript("document.querySelector('#bulkEditOptionsModal > div.modal-body').scrollTop=500");
				   		
				   		Thread.sleep(1000);
				   		
				   		//Now select value Add value to Options
				   		driver.findElement(By.xpath(Testelements.AddValuesToOption_BulkEdit)).click();
				   		
				   	//Press the bulk edit poup button
					 	List<WebElement> li72= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
						li72.get(8).click();
						
						Thread.sleep(1000);
						
				  //Now add the new option value details
						Select UpdatedOption=new Select(driver.findElement(By.cssSelector(Testelements.BulkAddValuesToOptions_OptionType)));
						UpdatedOption.selectByVisibleText("Product");
						
						Thread.sleep(8000);
						
				 //Now Enter the Product Name
						//Press the selected product radio button on bulk edit popup
				 		 List<WebElement> li16= driver.findElements(By.xpath(Testelements.BulkAddValuesToOptions_OptionName));
				 		 li16.get(8).sendKeys("Product 3");
						
						Thread.sleep(9000);
						
						li16.get(8).sendKeys(Keys.ENTER);
				//Now Enter the new value
						WebElement NewValue=driver.findElement(By.cssSelector(Testelements.BulkAddValuesToOptions_Value));
						NewValue.sendKeys("Test");
						NewValue.sendKeys(Keys.ENTER);
						
			   //Press the save Button
						driver.findElement(By.cssSelector(Testelements.BulkAddValuesToOptions_SaveButton)).click();
						
						Thread.sleep(2000);
						
			  //Press the email notification ok button
						driver.findElement(By.cssSelector(Testelements.EmailNotificationalert_Confirm)).click();
						
			 //Refresh the Page
						
				 driver.navigate().refresh();	
		  		
				 Thread.sleep(7000);
			  //Press the take Changes effect link  	
			       
			       //Make chnages Active
			       driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
			      
			       //Wait for the button to appear
			    	 wait = new WebDriverWait(driver, 180);
			         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
			         
			         Thread.sleep(2000);
			         
			         driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
			         
			         
			    	 Thread.sleep(10000);
			    	 
			//Now Press the Edit Button for validation
			    	 
			    	 driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
				       
			    	 waitForPageLoad();
			    	   
			    	   Thread.sleep(1000);
			    	   
			    	   waitForPageLoad();
			    	   
			    	   Thread.sleep(1000);
				       //Press the Attributes Tab
				       
				       driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
				       
				       waitForPageLoad();
				       
				       Thread.sleep(2000);
				       
				       wait = new WebDriverWait(driver, 180);
				         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.OptionsEditButton)));
				         
				         
				  		Thread.sleep(2000);	 
				  		
				  		driver.findElement(By.cssSelector(Testelements.OptionsEditButton)).click();
				  		
				  		Thread.sleep(3000);
				  		
				  		if(driver.findElement(By.xpath(Testelements.NewOptionValueValidation)).getText().contains("Test")){
				  			
				  			System.out.println("New option Value Added Successfully");
				  			
				  		     test = extent.createTest("New Option Value Bulk Edit ");
				  		     
				  		  	 test.log(Status.PASS, "New Option Value Added Successfully");
				  		}
				  		else{
				  			System.out.println("New option Value Added Unsuccessfull");
				  			
				  			test = extent.createTest("New Option Value Bulk Edit ");
				  		     
				  		  	test.log(Status.FAIL, "New Option Value Added Unsuccessfull");
				  			
				  		}
				  		
				  		if(driver.findElement(By.cssSelector(Testelements.EditOption_ApplyButtonValidation)).isDisplayed()){
				  			
				  			System.out.println("Apply Button displayed successfully");
				  			
				  			
				  			 test = extent.createTest("Apply Button on Edit Option ");
				  		     
				  		  	 test.log(Status.PASS, "Apply Button displayed successfully");
				  		}
				  		else{
				  			
				  			System.out.println("Apply Button displayed Unsuccessfully");
				  			
				  			
				  			 test = extent.createTest("Apply Button on Edit Option ");
				  		     
				  		  	 test.log(Status.FAIL, "Apply Button displayed Unsuccessfull");
				  		}
				  		
				  		if(driver.findElement(By.cssSelector(Testelements.EditOption_ApplyandAddButtonValidation)).isDisplayed()){
				  			System.out.println("Apply&Add Button displayed successfully");
				  			
				  			
				  			 test = extent.createTest("Apply&Add Button on Edit Option ");
				  		     
				  		  	 test.log(Status.PASS, "Apply&Add Button displayed successfully");
				  			
				  		}
				  		else{
				  			System.out.println("Apply&Add Button displayed Unsuccessfully");
				  			
				  			
				  			 test = extent.createTest("Apply&Add Button on Edit Option ");
				  		     
				  		  	 test.log(Status.FAIL, "Apply&Add Button displayed Unsuccessfull");
				  			
				  		}
				  		
				  	Thread.sleep(5000);
				  	
				  	//Now press the Cancel Button
				  	driver.findElement(By.cssSelector(Testelements.NewOptionValue_cancelButton)).click();
				  	
				  	Thread.sleep(2000);
		//Now delete the newly created custom option for it press the delete button on attribute screen
				  	driver.findElement(By.cssSelector(Testelements.NewOptionDeleteButton)).click();
				  	
				  	Thread.sleep(1000);
				  	
		//Now Press the yes button to delete the custom option
				  	driver.findElement(By.xpath(Testelements.NewOptionDeleteConfirm)).click();
				  	
				  	Thread.sleep(10000);
				  	
				  //Now goto Manage Product Screen Again
			  		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
				
		   		   Thread.sleep(10000);
		   		   
		   		//Make chnages Active
			       driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
			      
			       //Wait for the button to appear
			     wait = new WebDriverWait(driver, 180);
			     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
			         
			    driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
			         
			     Thread.sleep(10000);
		   		   
		   
  		}catch(NoSuchElementException e){
  	   e.getStackTrace();
  	  
  	 }
  		
  		}


    @Test(priority=12)
    public void SearchWithKeyword() throws InterruptedException{
    	try{
    		
    	driver.findElement(By.xpath(Testelements.SearchProduct_field)).sendKeys("Pro1");
    	
    	driver.findElement(By.xpath(Testelements.SearchProduct_Button)).click();
    	
    	Thread.sleep(8000);
    	
    	//Go to Edit Product For Verification for keyword existence
    	driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
    	   
    	 waitForPageLoad();
    	   
    	   Thread.sleep(1000);
    	   
    	   waitForPageLoad();
    	   
    	   Thread.sleep(1000);
    	
    	if(driver.findElement(By.xpath(Testelements.SearchKeywordVerification_BasicDetailScreen)).getText().contains("Pro1"))
    	{
    		System.out.println("Search with Keyword successfull");
    		
    		test = extent.createTest("SearchWithKeyword");
        
        	test.log(Status.PASS, "Search with Keyword successfull");
    	}
    	else{
    		
           System.out.println("Search with Keyword unsuccessfull");
    		
    		test = extent.createTest("SearchWithKeyword");
        
        	test.log(Status.FAIL, "Search with Keyword unsuccessfull");
    	}
     	
    	   
      }catch(NoSuchElementException e){
    	   e.getStackTrace();
    	   
    	 }

    }

    @Test(priority=13)
    public void DefaultSearch() throws InterruptedException{
    	try{
    		waitForPageLoad();
    	
    	driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath(Testelements.RemoveSearched1)).click();
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath(Testelements.SeeAll_Categories_ManageProducts)).click();
    	
    	Thread.sleep(2000);
    	
    	if(driver.getCurrentUrl().contains("stage"))
    	{
    		driver.findElement(By.xpath(Testelements.DefaultSearchedoptionStage)).click();	
    	}
    	else{
    	driver.findElement(By.xpath(Testelements.DefaultSearchedoption)).click();
    	}
        Thread.sleep(8000);
    	
      //Go to Edit Product For Verification for keyword existence
    	driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
    	   
    	   waitForPageLoad();
    	   
    	   Thread.sleep(1000);
    	   
    	   waitForPageLoad();
    	   
    	   Thread.sleep(1000);
    	
    	if(driver.getPageSource().contains("Frames"))
    	{
    		System.out.println("Default Search Successfull");
    		
    		test = extent.createTest("DefaultSearch");
        	
        	test.log(Status.PASS, "Default Search Successfull");
    	}
    	else{
    		System.out.println("Default Search UnSuccessfull");
    		
    		test = extent.createTest("DefaultSearch");
        	
        	test.log(Status.FAIL, "Default Search UnSuccessfull");
    	}
    	
    	waitForPageLoad();
    	
        driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
    	
    	Thread.sleep(2000);
    	
    	
    	//Remove previous Search
    	driver.findElement(By.xpath(Testelements.RemoveSearched2)).click();
    	
        Thread.sleep(2000);
			
    	}catch(NoSuchElementException e){
    	   e.getStackTrace();
    	   
    	 }
    }
    @Test(priority=14)
    public void ProductSortByNumber() throws InterruptedException{
    	    try{
    	  
    	   
		   Thread.sleep(2000);
		
    	   //Press the sort By button
    	   driver.findElement(By.xpath(Testelements.SortBy_Button)).click();
    	   
    	   //Wait
 		  Thread.sleep(2000);
    		
          driver.findElement(By.xpath(Testelements.SortBy_ProductNumber)).click();
          
          wait = new WebDriverWait(driver, 180);
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductNameSortValidation)));
          
          Thread.sleep(2000);
    	

          if(driver.findElement(By.xpath(Testelements.ProductNameSortValidation)).isDisplayed()){
              System.out.println("Product sort by number successfull");
              
              test = extent.createTest("ProductSortByNumber");
        	  
              test.log(Status.PASS, "Product sort by number successfull");
              }
              else{
            	  
            	 System.out.println("Product sort by number unsuccessfull");
                  
            	 test = extent.createTest("ProductSortByNumber");
            		
           	 	test.log(Status.FAIL, "Product sort by number unsuccessfull");
              }
   	 	
   	   
   	   }catch(NoSuchElementException e){
   	   e.getStackTrace();
   	   
    	   
    	   }
    	    
    	    
    	   }

    @Test(priority=15)
    public void ProductSortByName() throws InterruptedException{
    	   try{
    	   //Press the sort By button
    	   driver.findElement(By.xpath(Testelements.SortBy_Button)).click();
    	   
    	   //Wait
    		
    	Thread.sleep(2000);
    		
          driver.findElement(By.xpath(Testelements.SortBy_ProductName)).click();
          
          
          wait = new WebDriverWait(driver, 180);
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductNameSortValidation)));
          
          Thread.sleep(2000);
    	
    		
          if(driver.findElement(By.xpath(Testelements.ProductNameSortValidation)).isDisplayed()){
          System.out.println("Product sort by name successfull");
          test = extent.createTest("ProductSortByName");
    	  test.log(Status.PASS, "Product sort by name successfull");
          }
          else{
        	  
        	  System.out.println("Product sort by name unsuccessfull");
              test = extent.createTest("ProductSortByName");
        		
       	 	test.log(Status.FAIL, "Product sort by name unsuccessfull");
          }
   	   
   	   }catch(NoSuchElementException e){
   	   e.getStackTrace();
   	  
      }
    	    
     }
    @Test(priority=16)
    public void ProductSortByCatalog() throws InterruptedException{
    	   try{
    	   //Press the sort By button
    	   driver.findElement(By.xpath(Testelements.SortBy_Button)).click();
    	   
    	   //Wait
    		
    	  Thread.sleep(2000);
    		
          driver.findElement(By.xpath(Testelements.SortBy_Catalog)).click();
          
          
          wait = new WebDriverWait(driver, 180);
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogSortValidation)));
          
          Thread.sleep(2000);
    	 
    	 if(driver.findElement(By.xpath(Testelements.CatalogSortValidation)).isDisplayed()){
    	    System.out.print("Products sort by Catalog successfull");
    		test = extent.createTest("ProductSortByCatalog");
    		
   	 	   test.log(Status.PASS, "Products sort by Catalog successfull");
    	 }
    	 else{
    		 System.out.print("Products sort by Catalog unsuccessfull");
    		 test = extent.createTest("ProductSortByCatalog");
     		test.log(Status.FAIL, "Products sort by Catalog successfull"); 
    		 
    	 }
   	 	
   	   
   	   }catch(NoSuchElementException e){
   	   e.getStackTrace();
   	  
       }
    	    
     }
    
    @Test(priority=17)
    public void ProductSortByLastUpdated() throws InterruptedException{
    	   try{
    	   //Press the sort By button
    	   driver.findElement(By.xpath(Testelements.SortBy_Button)).click();
    	   
    	   //Wait
    		
    	 Thread.sleep(2000);
    		
          driver.findElement(By.xpath(Testelements.SortBy_LastUpdated)).click();
          
         
          wait = new WebDriverWait(driver, 180);
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LastUpdatedNameandDate_Validation)));
          
          Thread.sleep(2000);
    	
    		if(driver.findElement(By.xpath(Testelements.LastUpdatedNameandDate_Validation)).isDisplayed()){
          
          System.out.println("Products sort by Last Updated successfull");
          test = extent.createTest("ProductSortByLastUpdated");
    	  test.log(Status.PASS, "Products sort by Last Updated successfull");
    		}
    		else{
    			
    			 System.out.println("Products sort by Last Updated unsuccessfull");
    	          test = extent.createTest("ProductSortByLastUpdated");
    	    	test.log(Status.FAIL, "Products sort by Last Updated unsuccessfull");
    		} 	 	
   	   
   	   }catch(NoSuchElementException e){
   	   e.getStackTrace();
   	  
       }
    	    
     }
   @Test(priority=18)
    public void ProductDelete() throws InterruptedException{
    	       try{
    	   //Search the product with keyword to delete
    	   driver.findElement(By.xpath(Testelements.SearchProduct_field)).sendKeys("Pro1");
    	      	
    	   driver.findElement(By.xpath(Testelements.SearchProduct_Button)).click();	   
    	    	   
    	   //Wait for the product to be deleted
    	 wait = new WebDriverWait(driver, 120);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteProduct_Button)));
    	  
    	   
    	   //Press the sort By button
    	   driver.findElement(By.xpath(Testelements.DeleteProduct_Button)).click();
    	   
    	   //Wait
    		
    			Thread.sleep(4000);
    		
          driver.findElement(By.xpath(Testelements.DeleteAlert_Confirm)).click();
          
          
    		Thread.sleep(1000);
    		
    		if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).isDisplayed()){
    	  
              System.out.println("Product Deletion Successfull");
    	      test = extent.createTest("ProductDelete");
              test.log(Status.PASS, "Product Deletion Successfull");
    		}
    		else{
    			System.out.println("Product Deletion UnSuccessfull");
    			test = extent.createTest("ProductDelete");
    	          test.log(Status.FAIL, "Product Deletion UnSuccessfull");
    			
    		}
   	 	 waitForPageLoad();
   	 	 
   	 	 Thread.sleep(2000);
   	    }catch(NoSuchElementException e){
   	   e.getStackTrace();
   	  
       }
   
    	       
       }
    
    public void GetDate(){
   	 
    	// Create object of SimpleDateFormat class and decide the format
    	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	 
    	 //get current date time with Date()
    	 Date date = new Date();
    	 
    	 // Now format the date
    	 String date1= dateFormat.format(date);
    	 
    	 // Print the Date
    	 System.out.println(date1);
     }
  
   public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
  
    
   
   
   
   }
   public static boolean stringContainsItemFromList(String inputStr, String[] items)
   {
       for(int i =0; i < items.length; i++)
       {
           if(inputStr.contains(items[i]))
           {
               return true;
           }
       }
       return false;
   }  
  
  
  public static boolean isElementDisplayed(WebElement element,WebDriver driver) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException
	            | org.openqa.selenium.StaleElementReferenceException
	            | org.openqa.selenium.TimeoutException e) {
	        return false;
	    }
	}

public static void waitForElementToBeGone(WebElement element, int timeout,WebDriver driver) {
	    if (isElementDisplayed(element,driver)) {
	        new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
	    }
	}
  
  public void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	    
  }
  
  
  public static boolean checkIfExists(String[] myStringArray, String stringToLocate) {
	    for (String element:myStringArray ) {
	        if ( element.equals( stringToLocate)) {
	            return true;
	        }
	    }
	    return false;
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
