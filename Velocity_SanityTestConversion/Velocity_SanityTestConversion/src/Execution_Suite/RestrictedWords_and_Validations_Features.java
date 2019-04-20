package Execution_Suite;

import java.awt.AWTException;
import java.io.File;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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



public class RestrictedWords_and_Validations_Features {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	
	public static String SupplierSearchFields_Verification;
	public static String AddToNewGroup_ExternalID;
	public static String GroupName_Product1;
	public static String GroupName_Product2;
	public static String GroupName_Product3;
	public static String ExistingGroup_ExternalID;
	public static String ExternalID_StringRemoval;
	public static String ExternalID_Update_ProductNameGet;
	public static JavascriptExecutor jse89;
	public static String reminder;
	public static String substr;
	public static Dimension OldGetSize;
	public static Dimension NewGetSize;
	public static String OldNumberofProduct_In_Groups;
	public static String NewNumberofProduct_In_Groups;
	public static WebElement mySelectElement10023;
	public static Select dropdown10023;
	public static WebElement option;
	public static String DropDownValueText;
	public static WebElement ListPrice1_Match_For_SummaryDetails;
	public static String ListPrice11_Value;
	public static WebElement Quantity1_Match_For_SummaryDetails;
	public static String Quantity1_Value;
	public static WebElement NetCost1_Match_For_SummaryDetails;
	public static String Netcost11_Value;
		@BeforeTest
		@Parameters("browser")
		public void setup(String browser) throws InterruptedException{
			
			
	           if(browser.equalsIgnoreCase("firefox")) {
				
	        	WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/RestrictedWords_and_Validations_Features"+".html");
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
					htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/RestrictedWords_and_Validations_Features"+".html");
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
					htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/RestrictedWords_and_Validations_Features"+".html");
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
      //driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
      
	  }catch(NoSuchElementException e){
	  e.getStackTrace();
	 
  }
  
  }
@Test(priority=2)
public void API_RepLink_Spotlight_Mapped_TLC_OnSupplierSearch(){
	
	SupplierSearchFields_Verification=driver.findElement(By.xpath(Testelements.SupplierSearchfieldsVerification_SearchSupplierLevel)).getText();
	
	if(SupplierSearchFields_Verification.contains("API") & SupplierSearchFields_Verification.contains("Replink") & SupplierSearchFields_Verification.contains("Spotlight") & SupplierSearchFields_Verification.contains("Mapped") & SupplierSearchFields_Verification.contains("TLC"))
	{
	 System.out.println("API,Replink,Spotlight,Mapped and TLC fields for notes displayed Successfully");	
	
	 test = extent.createTest("API_RepLink_Spotlight_Mapped_TLC_OnSupplierSearch");
 	 
 	 test.log(Status.PASS, "API,Replink,Spotlight,Mapped and TLC fields for notes displayed Successfully"); 
	
	}
	
	else{
		
		System.out.println("API,Replink,Spotlight,Mapped and TLC fields for notes displayed UnSuccessfully");	
		
		 test = extent.createTest("API_RepLink_Spotlight_Mapped_TLC_OnSupplierSearch");
	 	 
	 	 test.log(Status.FAIL, "API,Replink,Spotlight,Mapped and TLC fields for notes displayed UnSuccessfully"); 
	
	}
}
  
  
  

  
@Test(priority=3)
public void AddEITSupplierNote() throws InterruptedException{
	try{
	//Press the View Notes Button after supplier Search
	driver.findElement(By.xpath(Testelements.ViewNotes_Button_AfterSupplierSearch)).click();
	
	Thread.sleep(1000);
	
	if(driver.findElement(By.xpath(Testelements.EITNotesUI_Verification)).isDisplayed())
	{
		System.out.println("Relocate notes related UI elements on EIT Dashboard Successfully");
	
		test = extent.createTest("RelocateNotes_ReleatedUI");
	 	 
	 test.log(Status.PASS, "Relocate notes related UI elements on EIT Dashboard Successfully");
	}
	else{
		System.out.println("Relocate notes related UI elements on EIT Dashboard UnSuccessfully");
	
		test = extent.createTest("RelocateNotes_ReleatedUI");
	 	 
		test.log(Status.FAIL, "Relocate notes related UI elements on EIT Dashboard UnSuccessfully");
	
	}
	//Enter a EIT Supplier Note in textarea
	driver.findElement(By.xpath(Testelements.AddNote_TextArea_Field)).sendKeys("Automation EIT Supplier Note");
	
	Thread.sleep(1000);
	
	//Press the Add Note Button
	driver.findElement(By.xpath(Testelements.AddNote_Button)).click();
	
    
    
    Thread.sleep(3000);
	
	//Validate as if the Note is created or not
	if(driver.findElement(By.xpath(Testelements.NoteCreated_Verification)).isDisplayed())
	{
		
		System.out.println("EIT Note Added Successfully");
    	 test = extent.createTest("EIT Note Add");
    	 
    	 test.log(Status.PASS, "EIT Note Added Successfully"); 
     }
     else{
    	 
   	  System.out.print("EIT Note Added Unsuccessfull");
   	  test = extent.createTest("EIT Note Add");
    	  
    	 test.log(Status.FAIL, "EIT Note Added UnSuccessfully");
    	 
     }
	
	}catch(NoSuchElementException e){
		  e.getStackTrace();
		 
	  }
}

@Test(priority=4)
public void UpdateEITNote() throws InterruptedException{
	try{
	//Change EIT Note details
	WebElement toClear = driver.findElement(By.xpath(Testelements.EditNoteTextArea_Field));
    toClear.sendKeys(Keys.CONTROL + "a");
    toClear.sendKeys(Keys.DELETE); 
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.EditNoteTextArea_Field)).sendKeys("Updated Automation EIT Supplier Note");
    
    Thread.sleep(1000);
    
    //Press the Edit Button
    driver.findElement(By.xpath(Testelements.EditNoteButton)).click();
    
   
    
    Thread.sleep(3000);
    
  //Validate as if the Note is updated or not
  	if(driver.findElement(By.xpath(Testelements.NoteEditing_Verification)).isDisplayed())
  	{
  		
  		System.out.println("EIT Note Updated Successfully");
      	 test = extent.createTest("EIT Note Update");
      	 
      	 test.log(Status.PASS, "EIT Note Updated Successfully"); 
       }
       else{
      	 
     	  System.out.print("EIT Note Updated Unsuccessfull");
     	  test = extent.createTest("EIT Note Update");
      	  
      	 test.log(Status.FAIL, "EIT Note Updated UnSuccessfully");
      	 
       }
  	
  	}catch(NoSuchElementException e){
  		  e.getStackTrace();
  		 
  	  }
    
}
@Test(priority=5)
public void EITNote_ManageProducts_Verification() throws InterruptedException{
	try{
	//Check the read Notes Checkboxes
	driver.findElement(By.xpath(Testelements.ReadNotes_Checkbox)).click();
	
	Thread.sleep(1000);
	
	//Press the Login as Supplier button
	driver.findElement(By.xpath(Testelements.ReadNotes_LoginAsSupplier_Button)).click();
	
	Thread.sleep(1000);
	
	//Wait for supplier selection option to appear
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
	  
    Thread.sleep(2000);
	  
	  //Click the manage product tab
	  driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	  
	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
      
      Thread.sleep(2000);
      
      if(driver.findElement(By.xpath(Testelements.SizeFilter_ManageProducts_Verification)).isDisplayed() & driver.findElement(By.xpath(Testelements.SizeFilter_ManageProducts_Verification)).getText().contains("Size"))
      {
    	  System.out.println("Size Filter Displayed Successfully on Manage Products Screen");
          
    	  test = extent.createTest("SizeFilter_Manageproduct_Verification");
       	 
       	 test.log(Status.PASS, "Size Filter Displayed Successfully on Manage Products Screen"); 
    	  
      }
      else{
    	 
          System.out.println("Size Filter Displayed Successfully on Manage Products Screen");
          
    	  test = extent.createTest("SizeFilter_Manageproduct_Verification");
       	 
       	  test.log(Status.FAIL, "Size Filter Displayed Successfully on Manage Products Screen"); 
    	  
      }
      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
      
      waitForPageLoad();
      
      Thread.sleep(2000);
     
      waitForPageLoad();
   	
      Thread.sleep(2000);
      
      //Press the view Notes Button
      driver.findElement(By.xpath(Testelements.ManageProducts_ViewNotes)).click();
      
      Thread.sleep(1000);
      
      //Validate as if the Note is updated or not
    	if(driver.findElement(By.xpath(Testelements.ManageProducts_Details_ViewNotes_Verification)).isDisplayed())
    	{
    		
    		System.out.println("View EIT Note on product details Successfully");
        	 test = extent.createTest("ViewNote_ProductDetails");
        	 
        	 test.log(Status.PASS, "View EIT Note on product details Successfully"); 
         }
         else{
        	 
       	  System.out.print("View EIT Note on product details Unsuccessfull");
       	  test = extent.createTest("ViewNote_ProductDetails");
        	  
        	 test.log(Status.FAIL, "View EIT Note on product details UnSuccessfully");
        	 
         }
    	
    	}catch(NoSuchElementException e){
    		  e.getStackTrace();
    		 
    	  }
      
	  
	  
}

@Test(priority=6)
public void DeleteEITNote() throws InterruptedException{
	
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
    
   
  //Press the View Notes Button after supplier Search
  	driver.findElement(By.xpath(Testelements.ViewNotes_Button_AfterSupplierSearch)).click();
  	
  	Thread.sleep(1000);
  	
  	//Press the delete button
  	driver.findElement(By.xpath(Testelements.NoteDeleteButton)).click();
  	
  	Thread.sleep(1000);
  	
  	//Validate as if the note is deleted or not successfully
  	if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
  	{
  		System.out.println("EIT Note Deleted Successfully");
  		test = extent.createTest("EIT Note Delete");
   	 
   	 test.log(Status.PASS, "EIT Note Deleted Successfully"); 
    }
    else{
   	 
  	  System.out.print("EIT Note Deleted Unsuccessfull");
  	  test = extent.createTest("EIT Note Delete");
   	  
   	 test.log(Status.FAIL, "EIT Note Deleted UnSuccessfully");
   	 
    }
  	
  	
  	
  	
	
	}catch(NoSuchElementException e){
	  e.getStackTrace();
	 
}
    

}
  @Test(priority=7)
  public void SKUField_BasicDetails_Displayed() throws InterruptedException{
  	try{
	   driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
	  
	  //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
	  
      Thread.sleep(1000);
	  
	  //Click the manage product tab
	  	driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	      //Wait for the process to complete	    	
	  	wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProductButton_EITSupplier)));
	      
	    Thread.sleep(1000);
	      //First store parent window to switch back
	    String parentWindow = driver.getWindowHandle();

	      
	      driver.findElement(By.cssSelector(Testelements.AddProductButton_EITSupplier)).click();

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
	  
	      Thread.sleep(3000);
	   
	  		if(driver.findElement(By.cssSelector(Testelements.SKUField_BasicDetails_Displayed)).isDisplayed()){
	  			
	  			System.out.print("SKU Field Displayed Sucessfully On Basic details screen,so verifaction of field displaying on basic details Passed");
	  			
	  			test = extent.createTest("SKUField_BasicDetails_Displayed");
	  		  
	  		  	test.log(Status.PASS, "SKU Field Displayed Sucessfully On Basic details screen,so verifaction of field displaying on basic details Passed");
	  		
	  		}
	  		else{
	  			
	  			System.out.print("SKU Field Displayed On Basic details screen Unsucessfull,so verifaction of field displaying on basic details Failed");
	  			test = extent.createTest("SKUField_BasicDetails_Displayed");
	  		   
	  		    test.log(Status.FAIL, "SKU Field Displayed On Basic details screen Unsucessfull,so verifaction of field displaying on basic details Failed");
	  		
	  		}
	  		
	  	 //Validate New Flag should be displayed to customer type supplier
      if(driver.findElement(By.cssSelector(Testelements.NewProduct_NewFlag)).isSelected()){
    	  
    	  System.out.println("New product flag displayed on basic detail screen and is checked");
	     	 test = extent.createTest("New Product Flag checked Validation");
	 	 		test.log(Status.PASS, "New product flag displayed on basic detail screen and is checked ");
      
      }
      else{
    	
    	  System.out.println("New product flag displayed on basic detail screen and is unchecked");
	     	 test = extent.createTest("New Product Flag checked Validation");
	 	 		test.log(Status.FAIL, "New product flag displayed on basic detail screen and is unchecked");
      }
      
  	      
  
  
  }
  	catch(NoSuchElementException e){
  	  e.getStackTrace();
  	}
  }

  @Test(priority=8)
public void ColorAttributes_AutoRename() throws InterruptedException{
	try{
	 //Insert the product number
    //driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber);
    
  //Insert UPC code
    driver.findElement(By.cssSelector(Testelements.UPCCode)).sendKeys(Testdata.UPCCode);
    
  //Insert the product summary
    driver.findElement(By.cssSelector(Testelements.Product_Summary)).sendKeys("This is a velocity Test Product ®");
    
    Thread.sleep(1000);
    
    //Click the Outer area in Basic details Screen
    //driver.findElement(By.cssSelector(Testelements.OuterAreaClick_BasicDetails)).click();
    
    Thread.sleep(1000);
    
    WebElement toClear = driver.findElement(By.cssSelector(Testelements.Product_Summary));
     toClear.sendKeys(Keys.CONTROL + "a");
     toClear.sendKeys(Keys.DELETE); 
    
     //Insert the product summary
     driver.findElement(By.cssSelector(Testelements.Product_Summary)).sendKeys("This is a velocity Test Product");
     
     //Click the Outer area in Basic details Screen
    //s driver.findElement(By.cssSelector(Testelements.OuterAreaClick_BasicDetails)).click();
     
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
   
    
    //Wait for 2 sec
    
		Thread.sleep(1000);
	
    //Select the pricing tab for SPG
  
		 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
         jse70.executeScript("window.scrollBy(0,-250)", "");
         
         
         JavascriptExecutor jse71 = (JavascriptExecutor)driver;
         jse71.executeScript("window.scrollBy(-250,-500)", "");
         
         Thread.sleep(1000);
         
		
	driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
  
	waitForPageLoad();
    
    // Wait for attributes to appear
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
    
    
		Thread.sleep(2000);
	
    
    driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
    
    //Select the 2nd attribute
    driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();

    waitForPageLoad();
    
    WebElement mySelectElement = driver.findElement(By.cssSelector(Testelements.WhiteHueColor_Dropdown));
    Select dropdown= new Select(mySelectElement);

    dropdown.selectByVisibleText("LIGHT");

    Thread.sleep(1000);

    if(driver.findElement(By.cssSelector(Testelements.LightWhiteTextColor_Verifiation)).getText().equals("Light White")){
    	
    	System.out.print("Attribute Hue color changes to Light White from Medium Sucessfully");
			
			test = extent.createTest("ColorAttributes_AutoRename_WhiteColor");
		  	
		  	test.log(Status.PASS, "Attribute Hue color of White color changes to Light White from Medium Sucessfully");
   
    
    }
    else{
    	
    	System.out.print("Attribute Hue color changes to Light White from Medium Unsucessfull");
			test = extent.createTest("ColorAttributes_AutoRenam_WhiteColor");
		   
		    test.log(Status.FAIL, "Attribute Hue color of White color changes to Light White from Medium Unsucessfull");
    }

    WebElement mySelectElement1 = driver.findElement(By.cssSelector(Testelements.BlueHueColor_Dropdown));
    Select dropdown1= new Select(mySelectElement1);

    dropdown1.selectByVisibleText("LIGHT");

    Thread.sleep(1000);

    if(driver.findElement(By.cssSelector(Testelements.LightBlueTextColor_Verification)).getText().equals("Light Blue")){
    	
    	System.out.print("Attribute Hue color changes to Light Blue from Medium Sucessfully");
			
			test = extent.createTest("ColorAttributes_AutoRename_BlueColor");
		  	
		  	test.log(Status.PASS, "Attribute Hue color of blue color changes to Light Blue from Medium Sucessfully");
   
    
    }
    else{
    	
    	System.out.print("Attribute Hue color changes to Light Blue from Medium Unsucessfull");
			test = extent.createTest("ColorAttributes_AutoRenam_BlueColor");
		    
		    test.log(Status.FAIL, "Attribute Hue color of Blue Color changes to Light Blue from Medium Unsucessfull");
    }



}

catch(NoSuchElementException e){
	  e.getStackTrace();
	}
}
@Test(priority=9)
public void AddNewColors() throws InterruptedException{
	try{
	
		 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
         jse70.executeScript("window.scrollBy(0,-250)", "");
         
         
         
         JavascriptExecutor jse71 = (JavascriptExecutor)driver;
         jse71.executeScript("window.scrollBy(-250,-500)", "");
         
         Thread.sleep(1000);
		
		
		
		//Click the others color tab in attributes
	WebElement OthersTab=driver.findElement(By.cssSelector(Testelements.OtherColors_Tab_Atributes));
	
	OthersTab.click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.cssSelector(Testelements.AnyOthersAll_Option_Newcolor)).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.cssSelector(Testelements.AnyAllColors_Popup)).click();
	
	Thread.sleep(1000);
	
	//Slect the color
	driver.findElement(By.cssSelector(Testelements.AnyAllColors_Selection)).click();
	Thread.sleep(1000);
	
	//Press the Apply button
	driver.findElement(By.cssSelector(Testelements.ApplySelection)).click();
	
	waitForPageLoad();
	
	Thread.sleep(1000);
	
	if(driver.findElement(By.xpath(Testelements.AnyandAllColorscategory_Existence_Attributes)).getText().contains("Any/All Colors")){
	      System.out.println("Any/All Color Added Sucessfully");
		
		  test = extent.createTest("AddNewColors(Any/All Colors)");
		  
		  test.log(Status.PASS, "Any/All Color Added Sucessfully");
	}
	else{
		
		System.out.println("Any/All Color Added UnSucessfully");
		
		  test = extent.createTest("AddNewColors(Any/All Colors)");
		  
		  test.log(Status.FAIL, "Any/All Color Added UnSucessfully");
	}
	
	JavascriptExecutor jse72 = (JavascriptExecutor)driver;
     jse72.executeScript("window.scrollBy(0,-250)", "");
     
     
     
     JavascriptExecutor jse73 = (JavascriptExecutor)driver;
     jse73.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(1000);
	
	
	
	//Click again others tab in attributes
	OthersTab.click();
	
    Thread.sleep(1000);
	
	driver.findElement(By.cssSelector(Testelements.Custom_NewColor)).click();
	
	Thread.sleep(1000);
	
     driver.findElement(By.cssSelector(Testelements.CustomNewColor_Popup)).click();
	
	Thread.sleep(1000);
	
	//Slect the color
	driver.findElement(By.cssSelector(Testelements.CustomNewColor_Selection)).click();
	Thread.sleep(1000);
	
	//Press the Apply button
	driver.findElement(By.cssSelector(Testelements.ApplySelection)).click();
	
	waitForPageLoad();
	
	Thread.sleep(1000);
	
	if(driver.findElement(By.cssSelector(Testelements.CustomColorCategory_Existence_Attribute)).getText().contains("Custom")){
		System.out.println("Any/All Color Added Sucessfully");
		
		  test = extent.createTest("AddNewColors(Any/All Colors)");
		  
		  test.log(Status.PASS, "Any/All Color Added Sucessfully");
	
	}
	else{
		
		System.out.println("Custom color Added UnSucessfully");
		
		  test = extent.createTest("AddNewColors(Custom color)");
		  
		  test.log(Status.FAIL, "Custom color Added UnSucessfully");
		
	}
	JavascriptExecutor jse74 = (JavascriptExecutor)driver;
     jse74.executeScript("window.scrollBy(0,-250)", "");
     
     
     
     JavascriptExecutor jse75 = (JavascriptExecutor)driver;
     jse75.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(1000);
	
	//Click again others tab in attributes
		OthersTab.click();
		
	    Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(Testelements.Standard_NewColor)).click();
	
		Thread.sleep(1000);

		 driver.findElement(By.cssSelector(Testelements.Standard_Newcolor_Popup)).click();
			
			Thread.sleep(1000);
			
			//Slect the color
			driver.findElement(By.cssSelector(Testelements.Standard_Newcolor_Selection)).click();
			Thread.sleep(1000);
			
			//Press the Apply button
			driver.findElement(By.cssSelector(Testelements.ApplySelection)).click();
			
			waitForPageLoad();
			
			Thread.sleep(1000);
			
		
			if(driver.findElement(By.cssSelector(Testelements.StandardColorCategory_Existence_Attribute)).getText().contains("Standard")){
				System.out.println("Standard Color Added Sucessfully");
				
				  test = extent.createTest("AddNewColors(Standard Colors)");
				  
				  test.log(Status.PASS, "Standard Color Added Sucessfully");
			
			}
			else{
				
				System.out.println("Standard color Added UnSucessfully");
				
				  test = extent.createTest("AddNewColors(Standard color)");
				  
				  test.log(Status.FAIL, "Standard color Added UnSucessfully");
				
			}
			
		//Click again others tab in attributes
		
			 //Scroll Up
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,-250)", "");
		    
		    
			
		    JavascriptExecutor jse76 = (JavascriptExecutor)driver;
	         jse76.executeScript("window.scrollBy(-250,-500)", "");
	         
	         	         
	         JavascriptExecutor jse77 = (JavascriptExecutor)driver;
	         jse77.executeScript("window.scrollBy(-500,-750)", "");
	         
	         Thread.sleep(1000);
		    
		    
		    OthersTab.click();
		
	    Thread.sleep(1000);
		
	    driver.findElement(By.cssSelector(Testelements.Other_Newcolor)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.cssSelector(Testelements.Other_NewColorPopUp)).click();
		
		Thread.sleep(1000);
		
		//Slect the color
		driver.findElement(By.cssSelector(Testelements.Other_NewColorSelection)).click();
		Thread.sleep(1000);
		
		//Press the Apply button
		driver.findElement(By.cssSelector(Testelements.ApplySelection)).click();
		
		waitForPageLoad();
		
		Thread.sleep(1000);
		
		if(driver.findElement(By.cssSelector(Testelements.OtherColorCategory_Existence_Attribute)).getText().contains("Other")){
			System.out.println("Other Color Added Sucessfully");
			
			  test = extent.createTest("AddNewColors(Other Colors)");
			  
			  test.log(Status.PASS, "Other Color Added Sucessfully");
		
		}
		else{
			
			System.out.println("Other color Added UnSucessfully");
			
			  test = extent.createTest("AddNewColors(Other color)");
			  
			  test.log(Status.FAIL, "Other color Added UnSucessfully");
			
		}
	    
		
	   

}

catch(NoSuchElementException e){
	  e.getStackTrace();
	}
}

@Test(priority=10)
public void NewProductsAddedByEIT_Unconfirmed() throws InterruptedException{
	try{
	
		//Scroll Up
	    JavascriptExecutor jse100 = (JavascriptExecutor)driver;
	    jse100.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll Up
	    JavascriptExecutor jse101 = (JavascriptExecutor)driver;
	    jse101.executeScript("window.scrollBy(-250,-500)", "");
	    
	  //Scroll Up
	    JavascriptExecutor jse102 = (JavascriptExecutor)driver;
	    jse102.executeScript("window.scrollBy(-500,-750)", "");
	    
	    Thread.sleep(1000);
	    
		
		//Goto imprinting tab and select imprinting
    driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
    
    waitForPageLoad();
    
  //Scroll Up
    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
    jse1.executeScript("window.scrollBy(0,-250)", "");
    
  //Scroll Up
    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    jse2.executeScript("window.scrollBy(-250,-500)", "");
    
    Thread.sleep(1000);
    
    //Select an option
    
    WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.ImprintingMethodSelection));
    Select dropdown70= new Select(mySelectElement70);
   
    dropdown70.selectByVisibleText("Silkscreen");
    
    
    
    WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", element);
   
    Thread.sleep(1000);
    
    
    
    
    //Open the pricing tab
    driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
    
    //Wait for all the fields to be appeared
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SPG_Quantity_1)));
    
	Thread.sleep(2000);
	
	if(driver.findElement(By.xpath(Testelements.Pricing_DefaultCurrencySelected_With2MarketSegments_Verification)).getText().contains("USD"))
	{
		System.out.println("USD Currency Selected By Default with 2 market segments against Supplier");
		
		test = extent.createTest("USD_Currency_Selection_ByDefault_AtPricing_Verification");
		  
		test.log(Status.PASS, "USD Currency Selected By Default with 2 market segments against Supplier");
		
		
	}
	else{
		
		System.out.println("USD Currency Doesn't Selected By Default with 2 market segments against Supplier");
	
		test = extent.createTest("USD_Currency_Selection_ByDefault_AtPricing_Verification");
		  
		test.log(Status.FAIL, "USD Currency Doesn't Selected By Default with 2 market segments against Supplier");
		
	}
    //Insert the details
    driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1)).sendKeys("1");
    
    //Storing Quantity in string t match it on Summary detail step
     Quantity1_Match_For_SummaryDetails=driver.findElement(By.cssSelector(Testelements.SPG_Quantity_1));
	 Quantity1_Value=Quantity1_Match_For_SummaryDetails.getAttribute("value");
	  
	 System.out.println(Quantity1_Value);
    
    driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1)).sendKeys("20");
    
  //Storing List Price1 in string t match it on Summary detail step
    ListPrice1_Match_For_SummaryDetails=driver.findElement(By.cssSelector(Testelements.SPG_Listprice_1));
    ListPrice11_Value=ListPrice1_Match_For_SummaryDetails.getAttribute("value");
   	  
   System.out.println(ListPrice11_Value);
    
    
    //driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1)).click();
    
    WebElement mySelectElement100 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
    Select dropdown100= new Select(mySelectElement100);
   
    dropdown100.selectByVisibleText("L 70%");
    
   //Now storing values for Drpdown to match on summary details screen
  mySelectElement10023 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
    
   dropdown10023= new Select(mySelectElement10023);
	   
 option=dropdown10023.getFirstSelectedOption();
	    
	  DropDownValueText=option.getText();
	    
	 System.out.println(DropDownValueText);
	 
	//Storing Netcost Pricing value
	 
	 NetCost1_Match_For_SummaryDetails=driver.findElement(By.xpath(Testelements.Netcost_USCurrency_Grid1));
	 Netcost11_Value=NetCost1_Match_For_SummaryDetails.getAttribute("value");
	   	  
	   System.out.println(Netcost11_Value);
	    
    
  
		
	driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("2");
	
	driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
	
	//driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2)).click();
	//Selection from through robots   
	
	
	 WebElement mySelectElement71 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2));
        Select dropdown71= new Select(mySelectElement71);
       
        dropdown71.selectByVisibleText("L 70%");
	
	if(driver.findElement(By.cssSelector(Testelements.PriceConfirmedCheckbox_Pricing)).isSelected()){
		
		System.out.print("New Product Pricing Confirmed check box on pricing screen is checked");
		test = extent.createTest("NewProductsAddedByEIT_Unconfirmed");
	    
	    test.log(Status.FAIL, "New Product Pricing Confirmed check box on pricing screen is checked,So Case Failed");
		
	}
	else{
		
		System.out.print("New Product Pricing Confirmed check box on pricing screen is unchecked");
		
		test = extent.createTest("NewProductsAddedByEIT_Unconfirmed");
	  	
	  	test.log(Status.PASS, "New Product Pricing Confirmed check box on pricing screen is unchecked,So Case Passed Sucessfully");

	}
	
   
}

catch(NoSuchElementException e){
	  e.getStackTrace();
	}
}
@Test(priority=11)
public void Availability_CheckUncheckAll_Verification() throws InterruptedException{
	try{
	//Move to Images tab
  	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
  	
  	waitForPageLoad();
  	
   //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
          
       Thread.sleep(1000);
       
       //First store parent window to switch back
       String parentWindow2 = driver.getWindowHandle(); 
       
       jse89 = (JavascriptExecutor)driver;
       jse89.executeScript("window.scrollBy(0,-250)", "");
       
       jse89 = (JavascriptExecutor)driver;
       jse89.executeScript("window.scrollBy(-250,-500)", "");
       
       Thread.sleep(1000);
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
       
       JavascriptExecutor jse89 = (JavascriptExecutor)driver;
       jse89.executeScript("window.scrollBy(0,250)", "");
	   	
       
		Thread.sleep(1000);
	
     
       //Confirm the images uploading details
       driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
       
   
       //Switch back to parent window 
          driver.switchTo().window(parentWindow2);
          
     
          waitForPageLoad();
  
          
         
   //Tagging the colors to image in creteria section
     Actions act=new Actions(driver);
     //1st Color(White) tagging  
    // find element which we need to drag
    WebElement drag=driver.findElement(By.xpath("//span[contains(@data-bind,'text: getValue(true)')]"));
     
    // find element which we need to drop
    WebElement drop=driver.findElement(By.xpath("//ul[contains(@class,'selected-criteria-sets token-input-list-facebook ui-droppable')]"));
     
    // this will drag element to destination
    act.dragAndDrop(drag, drop).build().perform();
     
    
    waitForPageLoad();
    
    Thread.sleep(1000);
  
    
    
    //2nd Colors(Blue) Tag 
    Actions act1=new Actions(driver);
      
    // find element which we need to drag
    WebElement drag1=driver.findElement(By.xpath("//*[@id='criteriaListToAttachWithImage']/li/ul/li[2]/span"));
     
   // find element which we need to drop
    WebElement drop1=driver.findElement(By.xpath("//ul[contains(@class,'selected-criteria-sets token-input-list-facebook ui-droppable')]"));
     
    // this will drag element to destination
    act1.dragAndDrop(drag1, drop1).build().perform();   
       
    Thread.sleep(1000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
    
 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
 jse70.executeScript("window.scrollBy(0,-250)", "");
 
 JavascriptExecutor jse71 = (JavascriptExecutor)driver;
 jse71.executeScript("window.scrollBy(-250,-500)", "");
 
 Thread.sleep(1000);
  	
 
 
 waitForPageLoad();
  
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
    
    Thread.sleep(1000);
    
    
     driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
    
    
  	Thread.sleep(1000);
 
    
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
    
    
    
  	Thread.sleep(1000);
  
  	 driver.findElement(By.xpath(Testelements.SKUquantity1)).sendKeys("2");
  	 
  	 driver.findElement(By.xpath(Testelements.SKUquantity2)).sendKeys("3");
  	 
  	 
  	Thread.sleep(1000);
  

    	//Move to availability tab
     driver.findElement(By.xpath(Testelements.Availability_Tab)).click();
     
     
     waitForPageLoad();
    
      driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).click();
      
      
      Thread.sleep(1000);
    	
      
      driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).click();
      
      Thread.sleep(1000);
     
      driver.findElement(By.xpath(Testelements.Availability_Firstvalue)).sendKeys(Keys.DOWN);
      
      Thread.sleep(1000);
    	
     
     driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).click();
     
     
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).click();
    
    
    Thread.sleep(1000);
    
    	
     driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).sendKeys(Keys.DOWN);
     
    
    Thread.sleep(1000);
    	
     
     driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).sendKeys(Keys.DOWN);
     
     
     Thread.sleep(1000);
    	
     
     driver.findElement(By.xpath(Testelements.Availability_Secondvalue)).sendKeys(Keys.ENTER);
     
       	
     Thread.sleep(1000);
   
     driver.findElement(By.xpath(Testelements.Availability_showbutton)).click();	
       	
       	
     waitForPageLoad();
     
     //Scroll Up
	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	    jse1.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll Up
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(1000);
     
     //Unselect the selected availability
     driver.findElement(By.cssSelector(Testelements.Availability_Unselect)).click();
     
     waitForPageLoad();
     
     if(!driver.findElement(By.cssSelector(Testelements.Availability_Unselect)).isEnabled() & !driver.findElement(By.cssSelector(Testelements.UnselectCheckboxValidation_Availability)).isSelected())
     {
       
    	 System.out.println("Unselect All Availability takes place sucessfully");
    	 
    	test = extent.createTest("Availability UnselectAll");
 	  
 	  	test.log(Status.PASS, "Unselect All Availability takes place sucessfully ");
    	 
     }
     else{
    	 System.out.println("Unselect All Availability takes place unsucessfully");
    	 
     	test = extent.createTest("Availability UnselectAll");
  	  
  	  	test.log(Status.FAIL, "Unselect All Availability takes place unsucessfully ");
    	 
     }
     
     
	  	 //Unselect the slected avaialability
	     driver.findElement(By.cssSelector(Testelements.Availability_Select)).click();
	     
	     waitForPageLoad();
	     
	     if(!driver.findElement(By.cssSelector(Testelements.Availability_Select)).isEnabled() & driver.findElement(By.cssSelector(Testelements.UnselectCheckboxValidation_Availability)).isSelected())
	     {
	       
	    	 System.out.println("select All Availability takes place sucessfully");
	    	 
	    	 test = extent.createTest("Availability selectAll");
			  	
			 test.log(Status.PASS, "select All Availability takes place sucessfully ");
	    	 
	     }
	     else{
	    	 System.out.println("select All Availability takes place unsucessfully");
	    	 
	    	 test = extent.createTest("Availability selectAll");
			  
			  	test.log(Status.FAIL, "select All Availability takes place unsucessfully ");
	    	 
	     } 
	     
	     
	     
    //Go to basic details screen and verify is sku,inventory status and quantity field are enabled or not
		  	driver.findElement(By.cssSelector(Testelements.BasicDetails_Product)).click();
		  	
		  	waitForPageLoad();
		  	
		  	waitForPageLoad();
		  	
		  	Thread.sleep(3000);
		  	
		 //Now verify the fields now
		  	if(driver.findElement(By.cssSelector(Testelements.BasicDetails_SKUField)).isEnabled()){
		  		System.out.println("On Basic details screen SKU field is enabled");
		  		
		  		test = extent.createTest("Basic Details SKU Field Enabled Verification");
			  
			  	test.log(Status.PASS, "On Basic details screen SKU field is enabled");
		  		
		  	}
		  	else{
		  		System.out.println("On Basic details screen SKU field is not enabled");
		  		
		  		test = extent.createTest("Basic Details SKU Field Enabled Verification");
			  	
			  	test.log(Status.FAIL, "On Basic details screen SKU field is not enabled");
		  	}
		  	
		  	
            if(driver.findElement(By.xpath(Testelements.BasicDetails_InventoryStatus)).isEnabled()){
            	
            	System.out.println("On Basic details screen Inventory Status field is enabled");
            	
            	test = extent.createTest("Basic Details Inventory Status Field Enabled Verification");
			  	
			  	test.log(Status.PASS, "On Basic details screen Inventory Status field is enabled");
            }
		  		
            else{
            	System.out.println("On Basic details screen Inventory Status field is not enabled");
            	
            	test = extent.createTest("Basic Details Inventory Status Field Enabled Verification");
			  	
			  	test.log(Status.FAIL, "On Basic details screen Inventory Status field is not enabled");

            }
		  	
		  	//Goto Summary Tab
      
		  	driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
          
           //Wait for some time
      
		  	waitForPageLoad();
		  	
		  	Thread.sleep(2000);
		  	
		  	String Quantity1_Verification=driver.findElement(By.xpath(Testelements.SummaryDetailsScreen_Quantity1)).getText();
		  	System.out.println(Quantity1_Verification);

		  	String ListPrice1_Verification=driver.findElement(By.xpath(Testelements.SummaryDetailsScreen_ListPrice1)).getText();
		  	System.out.println(ListPrice1_Verification);
		  	
		  	String NetCost1_Verification=driver.findElement(By.xpath(Testelements.NetCost1_SummaryDetails)).getText();
		  	System.out.println(NetCost1_Verification);
		  	
		  	
		  	if(Quantity1_Verification.contains(Quantity1_Value) & ListPrice1_Verification.contains(ListPrice11_Value) & NetCost1_Verification.contains(Netcost11_Value))
		  	{
		  		System.out.println("Pricing Value Matched on Summary details Screen Successfully");
		  		
		  		test = extent.createTest("Summary&Pricing_Verification_OnSummary");
		   	  
		 	  	test.log(Status.PASS, "Pricing Value Matched on Summary details Screen Successfully ");
		  	}
		  	else{
		  		System.out.println("Pricing Value Matched on Summary details Screen UnSuccessfully");
		  		
		  		test = extent.createTest("Summary&Pricing_Verification_OnSummary");
		   	  
		 	  	test.log(Status.FAIL, "Pricing Value Matched on Summary details Screen sucessfully ");
		  	}
		  	
  
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
  
    
  
}
    
catch(NoSuchElementException e){
	  e.getStackTrace();
	}
}  
  
 @Test(priority=12)
 public void Product_InLegalReview() throws InterruptedException{
	 try{
	 
		 
		 //Select the product to sent it in legal review
	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	 
	 Thread.sleep(1000);
	 
	 //Click the bulk Edit Button
	 driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();
	 
	 Thread.sleep(1000);
	 
	 //Press the selected product radio button on bulk edit popup
	 List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 li1.get(2).click();
	 
	 
	 //driver.findElement(By.xpath(Testelements.BulkEdit_SelectProd)).click();
	 
	 Thread.sleep(1000);
	 
	 //Select the Set to review option in popup of bulk edit
	 driver.findElement(By.cssSelector(Testelements.SetToreview_Option)).click();
	 
	 Thread.sleep(1000);
	 
	 //Press the bulk edit button
	 driver.findElement(By.cssSelector(Testelements.BulkEdit_PopupButton)).click();
	 
	 waitForPageLoad();
	 
	 //Select the legal review checkbox
	 driver.findElement(By.cssSelector(Testelements.Legalreview_checkbox)).click();
	 
	 Thread.sleep(1000);
	 
	 //Enter the cooments for legal review section
	 driver.findElement(By.cssSelector(Testelements.Legalreview_Comments)).sendKeys("Set to Legal Review");
	 
	 Thread.sleep(1000);
	 
	
	 
	 
	 //Press the outer area to make the button enable for set to review
	 driver.findElement(By.cssSelector(Testelements.legalreview_Clickbalearea_ButtonEnable)).click();
	 
	 Thread.sleep(1000);
	 
	 //Press the set to review button for legal
	 driver.findElement(By.cssSelector(Testelements.SelectedProductInreview_Button)).click();
	 
	 waitForPageLoad();
	 
	 //Press the ok to confirm email
	 driver.findElement(By.cssSelector(Testelements.EmailNotificationalert_Confirm)).click();
	 
	 Thread.sleep(1000);
	 
	 driver.navigate().refresh();
	 
	 wait = new WebDriverWait(driver, 120);
	 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ProductLegalreviewText)));
	 
	 Thread.sleep(4000);
	 if(driver.findElement(By.cssSelector(Testelements.ProductLegalreviewText)).getText().equals("Your product is in review because of Legal Review")){
		 
	       System.out.print("Product becomes inactive sucessfully and changes to legal review");
	       test = extent.createTest("Product_InLegalReview");
		  	test.log(Status.PASS, "Product becomes inactive sucessfully and changes to legal review");
	 
	 
	 }
	 else{
		 
		 System.out.print("Product becomes inactive unsucessfull and changes to legal review is also unsucessfull");
	       test = extent.createTest("Product_InLegalReview");
		  test.log(Status.FAIL, "Product becomes inactive unsucessfull and changes to legal review is also unsucessfull");
	 }
	 
     
 
 }
  
 catch(NoSuchElementException e){
	  e.getStackTrace();
	} 
  
}
  
 @Test(priority=13)
 public void SupplierInReview_LegalReviewProduct_Download() throws InterruptedException{
	 try{
	 //Press the EIT Dashboard from action bar
	 driver.findElement(By.xpath(Testelements.EITDashboardButton)).click();
	 
	 //Wait for the EIt Reports tab to appear
	 //Wait for supplier selection option to appear
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITReports_Tab)));
     
     Thread.sleep(1000);
     
     //PRess the EIT Admin tab
     driver.findElement(By.xpath(Testelements.EITReports_Tab)).click();
     
     //Wait for supplier selection option to appear
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITReports_Selectreport_dropdown)));
     
     Thread.sleep(1000);
     
 	WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
    Select dropdown20= new Select(mySelectElement20);
   
    dropdown20.selectByVisibleText("Products in review by supplier");
    
    Thread.sleep(1000);
    
    //Select the supplier checkbox
    driver.findElement(By.xpath(Testelements.EITReports_ProductsinReview3)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.LegalCheckbox_SupplierInreview)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.EITReports_Download3)).click();
    
    Thread.sleep(10000);
    
    File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("SuppliersWithProductsInReview")){
		 System.out.println("Supplier Product with legal review downloaded sucessfully");
		 
		 
		    test = extent.createTest("SupplierInReview_LegalReviewProduct_Download");
		  	
		  	test.log(Status.PASS, "Supplier Product with legal review downloaded sucessfully"); 
	 }
	 else{
		 System.out.println("InactiveProductsReports downloaded unsucessfully");
		     System.out.println("Supplier Product with legal review downloaded unsucessfully");
		 
		    test = extent.createTest("SupplierInReview_LegalReviewProduct_Download");
		  	
		  	test.log(Status.FAIL, "Supplier Product with legal review downloaded unsucessfully");
	 }
        
    
 }
 
 catch(NoSuchElementException e){
	  e.getStackTrace();
	} 
  
}
  
  @Test(priority=14)
  public void Product_WithRestrictedWords() throws InterruptedException{
	  
	  //Press the manage products tab on eit dashboard
	  driver.findElement(By.xpath(Testelements.EITManageProducts)).click();
	  
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
      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
 
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ManageProducts_Tab)));
      
      Thread.sleep(2000);
      
      //Click the manage products tab
      driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));

      Thread.sleep(1000);
      
      driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
      
      Thread.sleep(2000);
      
      //Press the ok button to active the product
      driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
      
      Thread.sleep(10000);
      
      //Select the product to sent it in legal review
 	 driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Click the bulk Edit Button
 	 driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Press the selected product radio button on bulk edit popup
 	//Press the selected product radio button on bulk edit popup
 		 List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
 		 li1.get(2).click();
 	 
 	 //driver.findElement(By.xpath(Testelements.BulkEdit_SelectProd)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Select the Set to review option in popup of bulk edit
 	 driver.findElement(By.cssSelector(Testelements.SetToreview_Option)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Press the bulk edit button
 	 driver.findElement(By.cssSelector(Testelements.BulkEdit_PopupButton)).click();
 	 
 	 waitForPageLoad();
 	 
 	 //Select the legal review checkbox
 	 driver.findElement(By.cssSelector(Testelements.Restrictedwordscheckbox_ProductInreview)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Enter the cooments for legal review section
 	 driver.findElement(By.cssSelector(Testelements.Legalreview_Comments)).sendKeys("Set to Restricted words Review");
 	 
 	 Thread.sleep(1000);
 	 
 	
 	 
 	 
 	 //Press the outer area to make the button enable for set to review
 	 driver.findElement(By.cssSelector(Testelements.legalreview_Clickbalearea_ButtonEnable)).click();
 	 
 	 Thread.sleep(1000);
 	 
 	 //Press the set to review button for legal
 	 driver.findElement(By.cssSelector(Testelements.SelectedProductInreview_Button)).click();
 	 
 	waitForPageLoad();
 	 
 	 Thread.sleep(2000);
 	 
 	 //Press the ok to confirm email
 	 driver.findElement(By.cssSelector(Testelements.EmailNotificationalert_Confirm)).click();
 	 
 	 Thread.sleep(2000);
 	 
 	 driver.navigate().refresh();
 	 
 	 wait = new WebDriverWait(driver, 120);
 	 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ProductRestrictedwordstext)));
 	 
 	 Thread.sleep(4000);
 	 
 	 if(driver.findElement(By.cssSelector(Testelements.ProductRestrictedwordstext)).getText().equals("Your product is in review because of Restricted words")){
 		 
 	       System.out.print("Product becomes inactive sucessfully and changes to restricted words review");
 	       test = extent.createTest("Product_WithRestrictedWords");
 		  	
 		  test.log(Status.PASS, "Product becomes inactive sucessfully and changes to restricted words review");
 	 
 	 
 	 }
 	 else{
 		 
 		 System.out.print("Product becomes inactive unsucessfull and changes to restricted words review is also unsucessfull");
 	       test = extent.createTest("Product_WithRestrictedWords");
 		  	
 		  test.log(Status.FAIL, "Product becomes inactive unsucessfull and changes to restricted words review is also unsucessfull");
 	 }
 	 
      
  

  }
  
  
  @Test(priority=15)
  public void SupplierInReview_RestrictedWordsReviewProduct_Download() throws InterruptedException{
 	 try{
 	 //Press the EIT Dashboard from action bar
 	 driver.findElement(By.xpath(Testelements.EITDashboardButton)).click();
 	 
 	 //Wait for the EIt Reports tab to appear
 	 //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITReports_Tab)));
      
      Thread.sleep(1000);
      
      //PRess the EIT Admin tab
      driver.findElement(By.xpath(Testelements.EITReports_Tab)).click();
      
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITReports_Selectreport_dropdown)));
      
      Thread.sleep(1000);
      
  	WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.EITReports_Selectreport_dropdown));
     Select dropdown20= new Select(mySelectElement20);
    
     dropdown20.selectByVisibleText("Products in review by supplier");
     
     Thread.sleep(1000);
     
     //Select the supplier checkbox
     driver.findElement(By.xpath(Testelements.EITReports_ProductsinReview3)).click();
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.Restrictedwordscheckbox_SupplierInreview)).click();
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.EITReports_Download3)).click();
     
     Thread.sleep(10000);
     
     File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
	 String fileName = getLatestFile.getName();
	 
	 if(fileName.contains("SuppliersWithProductsInReview")){
		 System.out.println("Supplier Product with Restricted Words Review downloaded sucessfully");
		 
		 
		    test = extent.createTest("SupplierInReview_RestrictedWordsReviewProduct_Download");
		  	
		  	test.log(Status.PASS, "Supplier Product with Restricted Words Review downloaded sucessfully"); 
	 }
	 else{
		 System.out.println("Supplier Product with Restricted Words Review downloaded unsucessfully");
		     System.out.println("Supplier Product with legal review downloaded unsucessfully");
		 
		    test = extent.createTest("SupplierInReview_RestrictedWordsReviewProduct_Download");
		  	
		  	test.log(Status.FAIL, "Supplier Product with Restricted Words Review downloaded unsucessfully");
	 }     
     
  }
  
  catch(NoSuchElementException e){
 	  e.getStackTrace();
 	} 
   
 }
  
 @Test(priority=16)
 public void EITAdmin_Restrictedwords_Sanity() throws InterruptedException{
	 try{
	//Press the EIT Admin Tab
     driver.findElement(By.xpath(Testelements.EITAdminTab)).click();
     
     //Wait for global list tab to be appear
     
 	wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.GlobalListsTab)));
     
     Thread.sleep(2000);
     
     //Press the global lists tab
     driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
     
     Thread.sleep(1000);
     
     //Select the global list options
     WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
     Select dropdown= new Select(mySelectElement);
    
     dropdown.selectByVisibleText("Manage Restricted words");
     
     
     
     //Wait for Add Restricted words  Button
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddRestrictedWords_Button)));
     
     Thread.sleep(2000);
     
     //Press the Add Restricted words button
     driver.findElement(By.xpath(Testelements.AddRestrictedWords_Button)).click();
     
     Thread.sleep(1000);
     
     
     //Enter the Trade Name
     driver.findElement(By.xpath(Testelements.RestrictedWordsInsertion_Field)).sendKeys(Testdata.RestrictedWordsAdd);
     
     Thread.sleep(3000);
     
     //Press the Add Trade button in popup
     driver.findElement(By.xpath(Testelements.RestrictedWordsAdd_ButtonPopup)).click();
     
     Thread.sleep(1000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	System.out.println("RestrictedWords Added Successfully"); 
    	 
    	test = extent.createTest("Add RestrictedWords");
 		
 		test.log(Status.PASS, "RestrictedWords Added Successfully");
     }
     else{
    	 System.out.println("RestrictedWords Added UnSuccessfully"); 
    	 
    	test = extent.createTest("Add RestrictedWords");
  		
  		test.log(Status.FAIL, "RestrictedWords Added UnSuccessfully");
     }
     
     
 
		//Search the term
    	driver.findElement(By.xpath(Testelements.RestrictedWordsSearch_Insertion)).sendKeys("Automation");
    	
    	Thread.sleep(2000);
    	
    	//Press the search button
    	driver.findElement(By.xpath(Testelements.RestrictedWordsSearch_Button)).click();
    	
    	
    	
    	Thread.sleep(5000);
    	
    	if(driver.findElement(By.xpath(Testelements.RestrictedwordsSearch_Validation)).getText().contains("Automation RestrictedWords-")){
    	System.out.println("RestrictedWords Searched Successfully");
    	test = extent.createTest("Search RestrictedWords");
 		
 		test.log(Status.PASS, "RestrictedWords Searched Successfully");
    	}
    	
    	else{
    		
    		System.out.println("RestrictedWords Searched UnSuccessfully");
    		test = extent.createTest("Search RestrictedWords");
     		
     		test.log(Status.FAIL, "RestrictedWords Searched UnSuccessfully");
    		
    	}
 		//Press the edit button
 	   driver.findElement(By.xpath(Testelements.RestrictedWordsUpdate_Button)).click();
 	   
 	   Thread.sleep(4000);
 	   
 	   //Clear the previous name
 	   WebElement toClear = driver.findElement(By.xpath(Testelements.RestrictedWordsUpdate_InsertionField));
 	     toClear.sendKeys(Keys.CONTROL + "a");
 	     toClear.sendKeys(Keys.DELETE); 
    
       //Wait
 	     Thread.sleep(2000);
 	     
 	  //Enter Updated Restricted word and save
 	     driver.findElement(By.xpath(Testelements.RestrictedWordsUpdate_InsertionField)).sendKeys(Testdata.RestrictedwordsUpdate);
 	     
 	     Thread.sleep(2000);
 	     
 	  //Press the confirm for the update process to be completed
 	     driver.findElement(By.xpath(Testelements.RestrictedWorsUpdate_ConfirmUpdate)).click();
 	     
 	     Thread.sleep(1000);
 	     
 	    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    
 	    System.out.println("Restricted Words Updated Successfully");
 	    test = extent.createTest("Edit Restricted Words");
 	 		
 	 	test.log(Status.PASS, "Restricted Words Updated Successfully");
 	    }
 	    else{
 	    	
 	    	System.out.println("Restricted Words Updated UnSuccessfully");
 	    	
 	    	test = extent.createTest("Edit Restricted Words");
 	 		
 	 		test.log(Status.FAIL, "Restricted Words Updated UnSuccessfully");
 	    }
 	 
 	    Thread.sleep(4000);
 	    
 	    //Press the delete Button
 	 		driver.findElement(By.xpath(Testelements.RestrictedwordsDelete_Button)).click();
 	 		
 	 		Thread.sleep(4000);
 	 		
 	 //Press OK to delete the restricted word
 	 		driver.findElement(By.xpath(Testelements.RestrictedWordsDelete_PopupOk)).click();
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
 	 		
 	 		test = extent.createTest("Delete RestrictedWords");
 	 		
 	 		test.log(Status.PASS, "RestrictedWords Deleted Successfully");
 	 		 }
 	 		 else{
 	 			System.out.println("Delete RestrictedWords UnSuccessfully");
 	 			 
 	 			test = extent.createTest("Delete RestrictedWords");
 	 	 		
 	 	 		test.log(Status.FAIL, "RestrictedWords Deleted UnSuccessfully"); 
 	 		 }
 
 
 }
  
  
 catch(NoSuchElementException e){
	  e.getStackTrace();
	} 
  
}
  
@Test(priority=17)
public void EITAdmin_SupplierLevel_Validations() throws InterruptedException{
	try{
	//Press the company Level option on eit manager screen
	driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
	
	wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection)));
    
    Thread.sleep(1000);
    
    //Creating a robot instance to select option in 2nd place in dropdown
  	WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Enable / Disable Validations");
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EnableDisableASITextField)));
      
      Thread.sleep(1000);
      
      //Enter the ASI Number
      WebElement AsinoField=driver.findElement(By.xpath(Testelements.EnableDisableASITextField));
      AsinoField.sendKeys("30232");
      
      Thread.sleep(1000);
      
      AsinoField.sendKeys(Keys.ENTER);
      
      Thread.sleep(1000);
      
      //Press the show validation button
      driver.findElement(By.xpath(Testelements.ShowValidationButton)).click();
      
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ValidationValuesListings_Validation)));
      
      Thread.sleep(2000);
    
      if(driver.findElement(By.cssSelector(Testelements.ValidationValuesListings_Validation)).isDisplayed()){
      
       System.out.println("Enable/Disable Validation Listings displayed sucessfully on EIT dashboard");
       test = extent.createTest("Validation Listings");
		
	   test.log(Status.PASS, "Enable/Disable Validation Listings displayed sucessfully on EIT dashboard");
      }
      else{
    	  
    	  System.out.println("Enable/Disable Validation Listings displayed unsucessfully on EIT dashboard");
          test = extent.createTest("Validation Listings");
   		
   	       test.log(Status.FAIL, "Enable/Disable Validation Listings displayed unsucessfully on EIT dashboard");
      }
	 //Press the Manage Products Tab
		driver.findElement(By.xpath(Testelements.EITManageProducts)).click();
		
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
	      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
	 
	      //Wait for supplier selection option to appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ManageProducts_Tab)));
	      
	      Thread.sleep(2000);
	      
	      //Click the manage products tab
	      driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
	      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));

	      Thread.sleep(2000);
	      
	      driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
	      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
	      
	      Thread.sleep(2000);
	      
	      //Press the ok button to active the product
	      driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
	      
	      Thread.sleep(8000);
      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
	      
	      Thread.sleep(2000);
	      
	      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	      
	      waitForPageLoad();
	      
	      Thread.sleep(2000);
	      
          waitForPageLoad();
	      
	      Thread.sleep(2000);
	      
	      //Goto imprinting tab and select imprinting
	      driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
	      
	      waitForPageLoad();
	      
	    //Scroll Up
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,250)", "");
		    
		    Thread.sleep(1000);
		    
	   //Check the rush service checkbox
		   driver.findElement(By.cssSelector(Testelements.RushServiceCheckbox)).click();
		   
		   Thread.sleep(1000);
		   
		   if(driver.getCurrentUrl().contains("stage")){
		   driver.findElement(By.cssSelector(Testelements.RushServiceDetailsTextfield)).sendKeys("Asiqa");
		   
		   Thread.sleep(1000);
		   }
		   else if(driver.getCurrentUrl().contains("uat")){
			   
			   driver.findElement(By.cssSelector(Testelements.RushServiceDetailsTextfield)).sendKeys(Testdata.Productname);
			   
			   Thread.sleep(1000);
		   }
		   else{
			   
                driver.findElement(By.cssSelector(Testelements.RushServiceDetailsTextfield)).sendKeys(Testdata.Productname);
			   
			    Thread.sleep(1000);
		   }
		   
		   
		   //Manane product listing
		      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  	 
		      wait = new WebDriverWait(driver, 180);
		      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		     
		      
		  	Thread.sleep(2000);
		  	
		     
		    //Make chnages Active
		    driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		    
		    Thread.sleep(2000);
		    if(driver.getCurrentUrl().contains("stage")){
		   
		    if(driver.findElement(By.cssSelector(Testelements.ImprintValidationError)).getText().equals("Imprinting: Rush Service Details contains an exact match of Line name:Asiqa")){
		    	
		    	test = extent.createTest("Validation Message Verification");
		 		
		 		test.log(Status.PASS, "Validation message displaying sucessfully that Imprinting: Rush Service Details contains an exact match of Line name:Asiqa");
		    
		    
		    
		    }
		  	   
		    else{
		    	
		    	 test = extent.createTest("Validation Message Verification ");
			 		
			 	test.log(Status.FAIL, "Validation message displaying unsucessfully that Imprinting: Rush Service Details contains an exact match of Line name:Asiqa");
		    }
	
		    }
		    else if(driver.getCurrentUrl().equals("https://espupdates.asicentral.com") & driver.getCurrentUrl().contains("uat")){
		    	
		    	if(driver.findElement(By.cssSelector(Testelements.ImprintValidationError)).getText().contains("Imprinting: Rush Service Details contains an exact match of Line name:Asiqa")){
			    	
			     test = extent.createTest("Validation Message Verification");
			 		
			 	test.log(Status.PASS, "Validation message displaying sucessfully that Imprinting: Rush Service Details contains an exact match of Line name:Product");
			    
			    
			    
			    }
			  	   
			    else{
			    	
			    	 test = extent.createTest("Validation Message Verification ");
				 		
				 	test.log(Status.FAIL, "Validation message displaying unsucessfully that Imprinting: Rush Service Details contains an exact match of Line name:Product");
		    	
			    }
		       Thread.sleep(2000);
		    
		    }
		    
		    }	
		    catch(NoSuchElementException e){
		  	  e.getStackTrace();
		  	} 
	      
	      
}
	

 
 @Test(priority=18)
 public void ScoreCard_EmailFrequency() throws InterruptedException{
	 try{
	 //Press the cancel button from error validation message
	driver.findElement(By.cssSelector(Testelements.CancelValidationErrorMessage)).click();
	 
	 //Thread.sleep(4000);
	 
	 //Goto ScoreCard Screen
	 driver.findElement(By.cssSelector(Testelements.ScorecardTab)).click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EmailFrequencyChangeButton)));
	 
 	 Thread.sleep(2000);
 	 //Press the change frequency button
 	 WebElement Changebutton=driver.findElement(By.xpath(Testelements.EmailFrequencyChangeButton));
 	 //For Quarterly Frequency
 	 Changebutton.click();
 	 
 	 
 	 
 	WebElement mySelectElement20 = driver.findElement(By.cssSelector(Testelements.Frequency_Dropdown));
    Select dropdown20= new Select(mySelectElement20);
   
    dropdown20.selectByVisibleText("Quarterly");
    
    WebElement SaveChangesButton=driver.findElement(By.cssSelector(Testelements.Frequency_SaveChanges_Button));
    
    //Press the save changes button
    SaveChangesButton.click();
    
    Thread.sleep(4000);
    
    if(driver.findElement(By.cssSelector(Testelements.FrequencyValidationcheck)).getText().equals("Quarterly"))
    {
    	
    	 test = extent.createTest("Frequency Status changes to Quarterly on Scorecard");
	 		
	 	test.log(Status.PASS, "Frequency Status changes to Quarterly Sucessfully on Scorecard");
    
    
    }
    else{
    	
    	test = extent.createTest("Frequency Status changes to Quarterly on Scorecard");
 		
 		test.log(Status.FAIL, "Frequency Status changes to Quarterly Unsucessfull on Scorecard");

    }
    
    
    
    Changebutton.click();
	 
	 
	 //For Monthly Frequency
 	WebElement mySelectElement21 = driver.findElement(By.cssSelector(Testelements.Frequency_Dropdown));
    Select dropdown21= new Select(mySelectElement21);
   
    dropdown21.selectByVisibleText("Monthly");
    
    SaveChangesButton.click();
    
    Thread.sleep(4000);
    
    if(driver.findElement(By.cssSelector(Testelements.FrequencyValidationcheck)).getText().equals("Monthly"))
    {
    	
    	 test = extent.createTest("Frequency Status changes to Monthly on Scorecard");
	 	test.log(Status.PASS, "Frequency Status changes to Monthly Sucessfully on Scorecard");
    
    
    }
    else{
    	
    	test = extent.createTest("Frequency Status changes to Monthly on Scorecard");
 		
 		test.log(Status.FAIL, "Frequency Status changes to Monthly Unsucessfull on Scorecard");

    }
    
    
    
    Changebutton.click();
	 
	 
	 //For Biannual frequency
 	WebElement mySelectElement22 = driver.findElement(By.cssSelector(Testelements.Frequency_Dropdown));
    Select dropdown22= new Select(mySelectElement22);
   
    dropdown22.selectByVisibleText("Biannually");
    
    SaveChangesButton.click();
    
    Thread.sleep(4000);
    
   
    if(driver.findElement(By.cssSelector(Testelements.FrequencyValidationcheck)).getText().equals("Biannually"))
    {
    	
    	 test = extent.createTest("Frequency Status changes to Biannually on Scorecard");
	 		
	 	test.log(Status.PASS, "Frequency Status changes to Biannually Sucessfully on Scorecard");
    
    
    }
    else{
    	
    	test = extent.createTest("Frequency Status changes to Biannually on Scorecard ");
 		
 		test.log(Status.FAIL, "Frequency Status changes to Biannually Unsucessfull on Scorecard");

    }
    
    Changebutton.click();
	 
	 //For Never Frequency
	 
 	WebElement mySelectElement23 = driver.findElement(By.cssSelector(Testelements.Frequency_Dropdown));
    Select dropdown23= new Select(mySelectElement23);
   
    dropdown23.selectByVisibleText("Never");
    
    SaveChangesButton.click();
    
    Thread.sleep(4000);
    
    if(driver.findElement(By.cssSelector(Testelements.FrequencyValidationcheck)).getText().equals("Never"))
    {
    	
    	 test = extent.createTest("Frequency Status changes to Never on Scorecard");
	 		
	 	test.log(Status.PASS, "Frequency Status changes to Never Sucessfully on Scorecard");
    
    
    }
    else{
    	
    	test = extent.createTest("Frequency Status changes to Never on Scorecard");
 		
 		test.log(Status.FAIL, "Frequency Status changes to Never Unsucessfull on Scorecard");

    }
	 }
	 catch(NoSuchElementException e){
		  e.getStackTrace();
		} 
 
 
 }
 
 @Test(priority=19)
 public void EITAdmin_EmailFrequency_WithScorecardEmailFrequencyChanges() throws InterruptedException{
	 try{
	   Thread.sleep(6000);
		 
		 //Goto EIt Manager tab
	 driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
	 
	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
     
      
  	Thread.sleep(1000);
	 
	 
	 
	 //Wait for the EIT Comapny level to appear tab to be appear
	 driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel)));
    
     
 	Thread.sleep(1000);
 	
 	driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
 	
 	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection)));
     
     Thread.sleep(1000);
     
     WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
     Select dropdown20= new Select(mySelectElement20);
    
     dropdown20.selectByVisibleText("Set Product Scorecard Email Frequency");
    
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CustomerASI_Field)));
     
     Thread.sleep(1000);
     
     //Enter the asino in the select customer field
     driver.findElement(By.xpath(Testelements.CustomerASI_Field)).sendKeys("30232");
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.CustomerASI_Field)).sendKeys(Keys.ENTER);
     
     Thread.sleep(8000);
     
     if(driver.getCurrentUrl().contains("uat")){
     //Search which is being assigned the eit manager licence
     driver.findElement(By.xpath(Testelements.SearchCustomerUser)).sendKeys("faheem");
     
     
     
     //Press the search button
     driver.findElement(By.xpath(Testelements.SearchCustomerUser_ButtonSearch)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_EmailFrequency_Biannualy_UAT_Prod)));
     
     Thread.sleep(2000);
 
     //Press the biannuall radio button
     driver.findElement(By.xpath(Testelements.EITAdmin_EmailFrequency_Biannualy_UAT_Prod)).click();
     
     Thread.sleep(4000);
     }
     else if(driver.getCurrentUrl().contains("stage")){
    	 
    	 //Search which is being assigned the eit manager licence
         driver.findElement(By.xpath(Testelements.SearchCustomerUser)).sendKeys("bilal mubarik");
         
         
         
         //Press the search button
         driver.findElement(By.xpath(Testelements.SearchCustomerUser_ButtonSearch)).click();
         
         wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EITAdmin_EmailFrequency_Biannualy_Stage)));
         
         Thread.sleep(1000);
     
         //Press the biannuall radio button
         driver.findElement(By.cssSelector(Testelements.EITAdmin_EmailFrequency_Biannualy_Stage)).click();
         
         Thread.sleep(4000);
     
     
     }
     else{
    	 
    	//Search which is being assigned the eit manager licence
         driver.findElement(By.xpath(Testelements.SearchCustomerUser)).sendKeys("faheem");
         
         
         
         //Press the search button
         driver.findElement(By.xpath(Testelements.SearchCustomerUser_ButtonSearch)).click();
         
         wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_EmailFrequency_Biannualy_UAT_Prod)));
         
         Thread.sleep(1000);
     
         //Press the biannually radio button
         driver.findElement(By.xpath(Testelements.EITAdmin_EmailFrequency_Biannualy_UAT_Prod)).click();
     }
     
     //Now verify on Scorecard screen email frequency area the email frequency changes to binannually
     
     //Scroll Up
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,-250)", "");
	    
	    Thread.sleep(1000);
	    
	 //Press the manage products tab
	    driver.findElement(By.xpath(Testelements.EITManageProducts)).click();
	    
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
	      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click(); 
	      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductScorecardText)));
	      
	      Thread.sleep(2000);
	      
	    //Go to the bottom of page
	 	 Actions actions = new Actions(driver);
	  	 actions.sendKeys(Keys.END).perform();
	  	 
	  	 //Scroll Up
		    JavascriptExecutor jse78 = (JavascriptExecutor)driver;
		    jse78.executeScript("window.scrollBy(0,-150)", "");
	  	   
		    Thread.sleep(1000);
		
	  	  if(driver.findElement(By.cssSelector(Testelements.FrequencyValidationcheck)).getText().equals("Biannually"))
	      {
	      	
	      	 test = extent.createTest("Frequency Status changes taking effect when changes form EIT Admin to Biannually on Scorecard");
	  	 		
	  	 	test.log(Status.PASS, "Frequency Status changes taking effect when changes form EIT Admin to Biannually on Scorecard");
	      
	      
	      }
	      else{
	      	
	      	test = extent.createTest("Frequency Status changes taking effect when changes form EIT Admin to Biannually on Scorecard ");
	   		
	   		test.log(Status.FAIL, "Frequency Status changes taking effect when changes form EIT Admin to Biannually Unsucessfull on Scorecard");

	      }
	  	  
	  	  
	 }
	 catch(NoSuchElementException e){
		  e.getStackTrace();
		} 
 
 }
 
 @Test(priority=20)
 public void ScorecardChanges() throws InterruptedException{
	 try{
	 
		 Thread.sleep(4000);
		 //Scroll to the top
	//Scroll Up
	    JavascriptExecutor jse78 = (JavascriptExecutor)driver;
	    jse78.executeScript("window.scrollBy(0,-250)", "");
	    
	    JavascriptExecutor jse79 = (JavascriptExecutor)driver;
	    jse79.executeScript("window.scrollBy(-250,-500)", "");
	 
        Thread.sleep(1000);
	    //Verify the text change fro discovery to Search
	    if(driver.findElement(By.xpath(Testelements.SearchText_Scorecard)).getText().equals("Search")){
	    	
	    	System.out.print("Search Heading display sucessfully");
	    	test = extent.createTest("Search Heading On ScoreCard");
  	 		
  	 		test.log(Status.PASS, "Search Heading On ScoreCard Sucessfully");
      
	    }
 
	    else{
	    	
	    	System.out.print("Search Heading display Unsucessfully");
	    	test = extent.createTest("Search Heading On ScoreCard");
  	 		
  	 		test.log(Status.FAIL, "Search Heading On ScoreCard  Unsucessfully");
	    }
 
     //Verify the (s) in products text 
	    if(driver.findElement(By.xpath(Testelements.SearchAreaWithS_Inbetween)).getText().contains("(s)"))
	    		{
	    	
	    	System.out.print("Product contains (s) in viw like product(s) sucessfully");
	    	test = extent.createTest("Text changes on Scorecard");
  	 		
  	 		test.log(Status.PASS, "Product contains (s) in viw like product(s) Sucessfully");
      
	    	   
	    		}
	    else{
	    	
	    	System.out.print("Product contains (s) in viw like product(s) unsucessfully");
	    	test = extent.createTest("Text changes on Scorecard");
  	 		
  	 		test.log(Status.FAIL, "Product contains (s) in viw like product(s) unsucessfully");
      
	    }

	  //Scroll Up
	    JavascriptExecutor jse80 = (JavascriptExecutor)driver;
	    jse80.executeScript("window.scrollBy(0,250)", "");
	    
	    
	    if(driver.findElement(By.cssSelector(Testelements.ScorecardDisplaying_WhileScrolling)).isDisplayed()){
	    	
	    	System.out.print("Scorecard Summary displayed sucessfully after scrolling");
	    	test = extent.createTest("Scorecard Summary Displayed While Scrolling");
  	 		
  	 		test.log(Status.PASS, "Scorecard Summary displayed sucessfully after scrolling Sucessfully");
      	
	    }
 
	    else{
	    	System.out.print("Scorecard Summary displayed sucessfully after scrolling");
	    	test = extent.createTest("Text changes on Scorecard");
  	 		
  	 		test.log(Status.FAIL, "Product contains (s) in viw like product(s) unsucessfully");
      
	    	
	    }
 
	 }
	 catch(NoSuchElementException e){
		  e.getStackTrace();
		} 
 }

 @Test(priority=21)
 public void SentEmail_ToSuppliers() throws InterruptedException{
	try{
	 
	      driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
		 
		  wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
	     
	      
	  	Thread.sleep(2000);
		 
		 
		 
		 //Wait for the EIT Comapny level to appear tab to be appear
		 driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
		 
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel)));
	    
	     
	 	Thread.sleep(2000);
	 	
	 	driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
	 	
	 	 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection)));
	     
	     Thread.sleep(2000);
	     
	     WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
	     Select dropdown20= new Select(mySelectElement20);
	    
	     dropdown20.selectByVisibleText("Set Product Scorecard Email Frequency");
	    
	     wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CustomerASI_Field)));
	     
	     Thread.sleep(1000);
	     
	     //Enter the asino in the select customer field
	     driver.findElement(By.xpath(Testelements.CustomerASI_Field)).sendKeys("30232");
	     
	     Thread.sleep(1000);
	     
	     driver.findElement(By.xpath(Testelements.CustomerASI_Field)).sendKeys(Keys.ENTER);
	     
	     Thread.sleep(8000);
	     
	     //Search which is being assigned the eit manager licence
	     driver.findElement(By.xpath(Testelements.SearchCustomerUser)).sendKeys("bilal Mubarik");
	     
	     
	     
	     //Press the search button
	     driver.findElement(By.xpath(Testelements.SearchCustomerUser_ButtonSearch)).click();
	     
	     if(driver.getCurrentUrl().contains("stage")){
	    	 
	    	 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.SendEmail_ToSupplier_Stage)));
		     
		     Thread.sleep(5000);
		     
		     //Press the email button to send the email to supplier
		     driver.findElement(By.cssSelector(Testelements.SendEmail_ToSupplier_Stage)).click();
		     
		     Thread.sleep(5000);
	     }
	     else{
	     wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SendEmail_ToSupplier_Button_UAT_Prod)));
	     
	     Thread.sleep(5000);
	     
	     //Press the email button to send the email to supplier
	     driver.findElement(By.xpath(Testelements.SendEmail_ToSupplier_Button_UAT_Prod)).click();
	     
	     Thread.sleep(5000);
	     }
	     
	  // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(2000);
	        		
	        // Accepting alert		
	        alert.accept();	
	        
	        
	        Thread.sleep(10000);
	        
	     // Switching to Alert        
	        Alert alertConfirm = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessageConfirm= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessageConfirm);	
	        Thread.sleep(2000);
	        		
	        if(alertMessageConfirm.contains("Email was sent to MMubarik")){
	        	 System.out.print("ScoreCard Email Sent to supplier sucessfully");
	 	    	test = extent.createTest("SentScoreCardEmail_ToSuppliers");
	   	 		
	   	 		test.log(Status.PASS, "ScoreCard Email Sent to supplier sucessfully");	
	        }
	        else{
	        	 System.out.print("ScoreCard Email Sent to supplier unsucessfully");
		 	    	test = extent.createTest("SentScoreCardEmail_ToSuppliers");
		   	 		
		   	 		test.log(Status.FAIL, "ScoreCard Email Sent to supplier unsucessfully");	
	        	
	        }
	        // Accepting alert		
	        alertConfirm.accept();	
	        
	        Thread.sleep(3000);
	       
	        
      	
 }
 catch(NoSuchElementException e){
	  e.getStackTrace();
	} 
	 
 
 
 }
 @Test(priority=22)
 public void NewProductFilter_Validation() throws InterruptedException{
	 try{
	 //Press the Manage Product Tab
	 driver.findElement(By.cssSelector(Testelements.Dist_ManageProducts)).click();
	 
     Thread.sleep(1000);
	 
	 driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
     //Click the search for supplier serach
     driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
     //Wait for supplier selection option to appear
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
     //Select the supplier through clicking
     driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
     
     Thread.sleep(2000);
    
   //Click the manage product tab
	  	driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	  	
	  	wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MoreFilterOption)));
	  	
	  	Thread.sleep(2000);
     
     //Press the More Filters
     driver.findElement(By.xpath(Testelements.MoreFilterOption)).click();
     
     Thread.sleep(12000);
     
     //Validate the New Product on more filter elastic search
     if(driver.findElement(By.xpath(Testelements.NewProductOption_MoreFilters)).isDisplayed()){
    	 
    	 System.out.println("New Product displayed successfully for More filter elastic Search");
          test = extent.createTest("New Product Option More Filter Search");
	 		test.log(Status.PASS, "New Product option displayed successfully for More filter elastic Search");
    	 
     }
     else{
    	 System.out.println("New Product displayed unsuccessfull for More filter elastic Search");
         test = extent.createTest("New Product Option More Filter Search");
	 		test.log(Status.FAIL, "New Product option displayed unsuccessfully for More filter elastic Search");
    	 
     }
	 
	 
	
	 
	 //Now press the New Product Count for validation flag products
	 driver.findElement(By.xpath(Testelements.NewProductOption_MoreFilters)).click();
	 
	 Thread.sleep(3000);
	 
	//Click the count
	 driver.findElement(By.cssSelector(Testelements.NewProduct_CountClick)).click();
	 
	 Thread.sleep(18000);
	 
	 //Scroll Up
	 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
     jse70.executeScript("window.scrollBy(0,-250)", "");
     
     
     
     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
     jse71.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.DeletechangesLinktext)).click();
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.DeletechangesConfirm)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
     
     Thread.sleep(2000);
     //Click the Edit Button
     driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
     
     waitForPageLoad();
     
     Thread.sleep(2000);
     
     waitForPageLoad();
     
     Thread.sleep(2000);
     
     //Validate the New Flag checked
     if(driver.findElement(By.cssSelector(Testelements.NewProduct_NewFlag)).isSelected()){
    	 
    	 System.out.println("New Product flag checked successfully Already for More filter elastic Search");
         test = extent.createTest("New Product Flag Checked");
	 		test.log(Status.PASS, "New Product flag checked successfully Already for More filter elastic Search");
    	 
     }
     else{
    	 
    	 System.out.println("New Product flag checked unsuccessfully Already for More filter elastic Search");
         test = extent.createTest("New Product Flag Checked");
	 		test.log(Status.FAIL, "New Product flag checked unsuccessfull Already for More filter elastic Search");
     }
	 //Validate the New Flag displayed on basic detail screen
     if(driver.findElement(By.xpath(Testelements.BasicdetailsTextValidation)).isDisplayed() && driver.findElement(By.cssSelector(Testelements.NewProduct_NewFlag)).isDisplayed()){
    	 
    	 System.out.println("New product flag displayed on basic detail screen Successfully");
    	 test = extent.createTest("New Product flag display on Basic details screen");
	 		test.log(Status.PASS, "New product flag displayed on basic detail screen Successfully");
     }
     else{
    	 
    	 System.out.println("New product flag displayed on basic detail screen UnSuccessfully");
    	 test = extent.createTest("New Product flag display on Basic details screen");
	 		test.log(Status.FAIL, "New product flag displayed on basic detail screen UnSuccessfully");
	 		
     }
     
     waitForPageLoad();
     
     
     //Now go Manage Products Screen
     driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
     
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
     
     
     Thread.sleep(2000);
     
     
     
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
	     	  
	     	Thread.sleep(2000);
				
	 		
	 		//Press the selected product radio button on bulk edit popup
	 		 List<WebElement> li20= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
	 		 li20.get(2).click();
	 		 
	 		 //Now Select the Remove flag product Option
	 		 Thread.sleep(1000);
	 		 
	 		 driver.findElement(By.xpath(Testelements.RemoveNewProductFlag_BulkEdit)).click();
	 		 
	 		 //Press the bulk Edit button on popup for Bulk Edit
	 		//Press the bulk edit poup button
			 	List<WebElement> li72= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
				li72.get(8).click();
				
				Thread.sleep(1000);
				
		   //Press the confirm to bulkEdit the flag
				driver.findElement(By.cssSelector(Testelements.BulkRemoveflagConfirm)).click();
				
		  Thread.sleep(2000);
		  
		  //Validate email successf message displayed
		  if(driver.findElement(By.cssSelector(Testelements.EmailSuccessText)).isDisplayed()){
			  
			  System.out.println("Bulk Opertion for New flag takes Successfully");
			  test = extent.createTest("Bulk Operation Success Message");
		 		test.log(Status.PASS, "Bulk Opertion for New flag takes Successfully");
		  }
		  else{
			  
			  System.out.println("Bulk Opertion for New flag takes Unsuccessfully");
			  test = extent.createTest("Bulk Operation Success Message");
		 		test.log(Status.FAIL, "Bulk Opertion for New flag takes Unsuccessfully");
		  }
		  
		  //Press the Ok Button to finish
		  driver.findElement(By.cssSelector(Testelements.EmailNotificationalert_Confirm)).click();
		  
		  Thread.sleep(3000);
		  
		  //Press the clear All from filter
		  driver.findElement(By.cssSelector(Testelements.ClearAllFilter)).click();
		  
		  Thread.sleep(4000);
		  
		  //Press the Edit Button
		  driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	       
	      waitForPageLoad();
	      
	      Thread.sleep(2000);
	      
          waitForPageLoad();
	      
	      Thread.sleep(2000);
	       
	      if(driver.findElement(By.cssSelector(Testelements.NewProduct_NewFlag)).isEnabled()){
	    	  
	    	  System.out.println("New product flag displayed on basic detail is Enabled");
	     	 test = extent.createTest("New Product flag display Disabled on Basic Details Screen");
	 	 		test.log(Status.FAIL, "New product flag displayed on basic detail is Enabled");
	      }
	      else{
	    	  
	    	  System.out.println("New product flag displayed on basic detail is Disabled");
		     	 test = extent.createTest("New Product flag display Disabled on Basic Details Screen");
		 	 		test.log(Status.PASS, "New product flag displayed on basic detail is Disabled");
	      }
	      
	    //Now go Manage Products Screen
	      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	      
	      Thread.sleep(2000);
	
	 }
     catch(NoSuchElementException e){
    	 e.getStackTrace();
     }
 }
 
 @Test(priority=23)
 public void CategorySaving_WithEITCategory_WithProductCategory() throws InterruptedException{
	  
	 try{
	 
	 //Click the manage product tab
	  	//driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	 //First store parent window to switch back
	    String parentWindow = driver.getWindowHandle();
	 
	 
	 driver.findElement(By.cssSelector(Testelements.AddProductButton_EITSupplier)).click();

	  

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
	  		
	  		//driver.findElement(By.cssSelector(Testelements.Product_Number)).sendKeys(Testdata.Productnumber);
	  	    
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
	  	    
	  	
	  	    
	  	//Press the apply on category product popup
	  	    driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton)).click();
	  	    
	  	  //Switch back to parent window 
	  	    driver.switchTo().window(parentWindow1);
	  	   
	  	    
	  	    //Wait for 4 sec
	  	    
	  			Thread.sleep(2000);
	  			
	  		  //Select the pricing tab for SPG
	  		    
	  	      driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
	  	    
	  	     
	  	    JavascriptExecutor jse891 = (JavascriptExecutor)driver;
	  	       jse891.executeScript("window.scrollBy(0,-250)", "");
	  	       
	  	     JavascriptExecutor jse892 = (JavascriptExecutor)driver;
	  	       jse892.executeScript("window.scrollBy(-250,-500)", "");
	  	      
	  	      // Wait for attributes to appear
	  	      
	  	     Thread.sleep(1000);
	  	      
	  	      
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
	  	      
	  	      Thread.sleep(1000);
	  	      
	  	      WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
	  	      JavascriptExecutor executor = (JavascriptExecutor)driver;
	  	      executor.executeScript("arguments[0].click();", element);
	  	     
	  	      Thread.sleep(2000);
	  	      
	  	      
	  	      
	  	      
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
	  	      
	  	      WebElement mySelectElement100 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
	  	      Select dropdown100= new Select(mySelectElement100);
	  	     
	  	      dropdown100.selectByVisibleText("L 70%");
	  	      
	  	      //Selection from dropdown
	  	      
	  	  		
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
	  	  	
	  	   //Wait for the button to appear
	  	  	 wait = new WebDriverWait(driver, 180);
	  	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
	  	          
	  	       Thread.sleep(2000);
	  	       
	  	       //First store parent window to switch back
	  	       String parentWindow2 = driver.getWindowHandle(); 
	  	       
	  	      
	  	       
	  	    JavascriptExecutor jse893 = (JavascriptExecutor)driver;
	  	    jse893.executeScript("window.scrollBy(0,-250)", "");
	  	    
	  	  JavascriptExecutor jse894 = (JavascriptExecutor)driver;
	  	   jse894.executeScript("window.scrollBy(-250,-500)", "");
	  	    
	  	  JavascriptExecutor jse895 = (JavascriptExecutor)driver;
	  	  jse895.executeScript("window.scrollBy(-500,-750)", "");
	  	  
	  	  
	      Thread.sleep(1000);
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
	  	       
	  	       JavascriptExecutor jse89 = (JavascriptExecutor)driver;
	  	       jse89.executeScript("window.scrollBy(0,250)", "");
	  		   	
	  	       
	  	      Thread.sleep(1000);
	  	 
	  	       
	  	       //Confirm the images uploading details
	  	       driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
	  	       
	  	   
	  	       //Switch back to parent window 
	  	          driver.switchTo().window(parentWindow2);
	  	          
	  	       
	  	  	    waitForPageLoad();
	  	 
	  	  	    waitForPageLoad();
	  	  	    
	  	  	    Thread.sleep(3000);
	  	          
	  	  	 //Goto Summary Tab
	  	      driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	  	          
	  	     //Wait for some time
	  	     
	  	  		waitForPageLoad();
	  	  		
	  	  		Thread.sleep(1000);
	  	  	

	  	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	  	    
	  	 
	  	//Scroll Up
	         JavascriptExecutor jse75 = (JavascriptExecutor)driver;
	         jse75.executeScript("window.scrollBy(0,-250)", "");
	         
	         JavascriptExecutor jse76 = (JavascriptExecutor)driver;
	         jse76.executeScript("window.scrollBy(-250,-500)", "");
	  	    
	         Thread.sleep(1000);
	  	    
	  	    
	  	    
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
	  	  	
	  	  	Thread.sleep(2000);
	  	  	
	  	     waitForPageLoad();
	  	  	
	  	  	Thread.sleep(2000);
	  	 
	  	  WebElement mySelectElement = driver.findElement(By.xpath(Testelements.ProductSelectTaxCategory));
	         Select dropdown= new Select(mySelectElement);
	        
	         dropdown.selectByVisibleText("Software as a Service");
	         
	         Thread.sleep(1000);
	       
	       //Scroll Up
	         JavascriptExecutor jse701 = (JavascriptExecutor)driver;
	         jse701.executeScript("window.scrollBy(0,-250)", "");
	         
	         JavascriptExecutor jse711 = (JavascriptExecutor)driver;
	         jse711.executeScript("window.scrollBy(-250,-500)", "");
	         
	         JavascriptExecutor jse721 = (JavascriptExecutor)driver;
	         jse721.executeScript("window.scrollBy(-500,-750)", "");
	         
	         JavascriptExecutor jse731 = (JavascriptExecutor)driver;
	         jse731.executeScript("window.scrollBy(-750,-1000)", "");
	         
	         JavascriptExecutor jse741 = (JavascriptExecutor)driver;
	         jse741.executeScript("window.scrollBy(-1000,-1250)", "");
	         
	         JavascriptExecutor jse791= (JavascriptExecutor)driver;
	         jse791.executeScript("window.scrollBy(-1250,-1500)", "");
	         
	         Thread.sleep(2000);
	       
	//Click the eit category and select the category
	         driver.findElement(By.cssSelector(Testelements.Productcategory_dropdown)).click();	         
	         
	         driver.findElement(By.xpath(Testelements.ProductCategory_EIT_Button_Selection_Option)).click();
	         
	 //Now select the EIT Category from list
	         driver.findElement(By.cssSelector(Testelements.EITCategory_Selection)).click();
	         
	         Thread.sleep(1000);
	         
	         WebElement element1 = driver.findElement(By.cssSelector(Testelements.EITCategoryApply_Button));
	         JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	         executor1.executeScript("arguments[0].click();", element1);
	         
	         
	         
	         //Press the apply button
	        // driver.findElement(By.cssSelector(Testelements.EITCategoryApply_Button)).click();
	         
	         Thread.sleep(2000);
	         
//Now Press the save button
	         driver.findElement(By.xpath(Testelements.SaveButton_ProductLevel)).click();
	         
	         waitForPageLoad();
	         
	         Thread.sleep(2000);
	  
	       //Now remove the EIT Category
	         driver.findElement(By.xpath(Testelements.RemoveEITCategory)).click();
	         
	         Thread.sleep(1000);
	         
	     //Scroll Up
	         JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	         jse70.executeScript("window.scrollBy(0,-250)", "");
	         
	         JavascriptExecutor jse71 = (JavascriptExecutor)driver;
	         jse71.executeScript("window.scrollBy(-250,-500)", "");
	         
	         JavascriptExecutor jse72 = (JavascriptExecutor)driver;
	         jse72.executeScript("window.scrollBy(-500,-750)", "");
	         
	         JavascriptExecutor jse73 = (JavascriptExecutor)driver;
	         jse73.executeScript("window.scrollBy(-750,-1000)", "");
	         
	         JavascriptExecutor jse74 = (JavascriptExecutor)driver;
	         jse74.executeScript("window.scrollBy(-1000,-1250)", "");
	         
	         JavascriptExecutor jse79= (JavascriptExecutor)driver;
	         jse79.executeScript("window.scrollBy(-1250,-1500)", "");
	         
	     
	         Thread.sleep(3000);
	         //Press the Product category
	         
	         //First store parent window to switch back
		  	    String parentWindow8 = driver.getWindowHandle(); 
		  	    
		  	  
		  	    
		  	    
		  	    //Open the category popup
		  	    driver.findElement(By.cssSelector(Testelements.Productcategory_dropdown)).click();
		  	    
		  	  driver.findElement(By.xpath(Testelements.ProductCategory_Product_Button_Selection_Option)).click();
		  	    
		  	  //Switch to new window opened
		  		for(String winHandle : driver.getWindowHandles()){
		  		    if(!winHandle.equals(parentWindow8)) {
		  		        driver.switchTo().window(winHandle);
		  		    }
		  		}
 
               Thread.sleep(3000);
		  		 //Select 2  categories of frames 
		  	    driver.findElement(By.cssSelector(Testelements.Product_category2)).click();
		  	    
		  	   Thread.sleep(2000);
		  	    
		  	//Press the apply on category product popup
		  	 WebElement element2 = driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton));
	         JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	         executor2.executeScript("arguments[0].click();", element2);
		  	   
		  //driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton)).click();
		  	    
		  	//Switch back to parent window 
		  	 driver.switchTo().window(parentWindow8);
		  	   
		  	    
		  	    //Wait for 4 sec
		  	    
		  			Thread.sleep(2000);
 
         //Press the save button
		  			
		  			 driver.findElement(By.xpath(Testelements.SaveButton_ProductLevel)).click();
			         
			         waitForPageLoad();
		  			 
		  			 Thread.sleep(2000);
			         
	   //Now validate as if the product category displayed successfully after saving or not
			   if(driver.findElement(By.cssSelector(Testelements.ProductCategoryExistenceValidation)).isDisplayed()){
				   
				   System.out.println("Product category doesn't disappear after adding same same EIT Category in product category,So the test is passed successfully");
				   test = extent.createTest("EIT and Product Category Saving Scenario");
		 	 		test.log(Status.PASS, "Category Saved Successfully in EIT And Product Category Scenario Successfully");
			   }
			   else{
				   
				   System.out.println("Product category does disappear after adding same same EIT Category in product category,So the test is passed unsuccessfully");
				   test = extent.createTest("EIT and Product Category Saving Scenario");
		 	 		test.log(Status.FAIL, "Category Saved Successfully in EIT And Product Category Scenario Successfully");
			   }
 
     Thread.sleep(2000);
     
     //Insert the Advertising keyword
     WebElement Adkeyword=driver.findElement(By.xpath(Testelements.AdKeyword_BasicDetails));
     Adkeyword.sendKeys("Ad KeywordTest");
     Thread.sleep(1000);
     Adkeyword.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
     
     //Insert the Hidden Keyword
     WebElement HiddenKeyword=driver.findElement(By.xpath(Testelements.HiddenKeyword_BasicDetails));
     HiddenKeyword.sendKeys("Hidden KeywordTest");
     Thread.sleep(1000);
     HiddenKeyword.sendKeys(Keys.ENTER);
     Thread.sleep(2000);
     
   //Scroll Up
     JavascriptExecutor jse80 = (JavascriptExecutor)driver;
     jse80.executeScript("window.scrollBy(0,-250)", "");
     
     JavascriptExecutor jse81 = (JavascriptExecutor)driver;
     jse81.executeScript("window.scrollBy(-250,-500)", "");
     
     JavascriptExecutor jse82 = (JavascriptExecutor)driver;
     jse82.executeScript("window.scrollBy(-500,-750)", "");
     
     JavascriptExecutor jse83 = (JavascriptExecutor)driver;
     jse83.executeScript("window.scrollBy(-750,-1000)", "");
     
     JavascriptExecutor jse84 = (JavascriptExecutor)driver;
     jse84.executeScript("window.scrollBy(-1000,-1250)", "");
     
     
     Thread.sleep(2000);
     
     //Goto Manage Product Again
     
     driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
     
     Thread.sleep(2000);
 
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
   
    
	Thread.sleep(2000);
	
   
     
     
     //Make chnages Active
   driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
  
   //Wait for the button to appear
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
     
     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
     
     
	 Thread.sleep(10000);
	 }
	 catch(NoSuchElementException e){
		 
		 e.getStackTrace();
	 }
 
 
 
 }
 
 @Test(priority=24)
 public void AfterCopyProduct_FieldsDefaultBehaviourValidation() throws InterruptedException{
	 
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
   
	Thread.sleep(4000);

   WebElement toClear = driver.findElement(By.xpath(Testelements.Copy_Product_field));
   toClear.sendKeys(Keys.CONTROL + "a");
   toClear.sendKeys(Keys.DELETE); 
   //Insert a new name
   driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
   //Save the copy product 
   
   driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
   
   waitForPageLoad();
	
   Thread.sleep(2000);

   //Successfull alert OK on copy
  //driver.findElement(By.xpath("//button[contains(@data-target,'#sayModalSuccessDialog')]")).click();
   
   //Refresh the page for changes to take effect
  
 // driver.navigate().refresh();
  
  //Thread.sleep(10000);
  
  //Switch back to parent window 
    //driver.switchTo().window(parentWindow5);
     
 //Press the Edit Button   
     //driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	   
	 
     
  //Now Validate the default behaviour for all different functinalities on basic detaisl screen
	  	
	  	if(driver.findElement(By.xpath(Testelements.ProductSelectTaxCategory)).getText().contains("(Select)")){
	  		
	  		System.out.println("Tax category default data displayed successfully");
	  		 test = extent.createTest("Validating default Behaviour of Tax Category");
	 	 		test.log(Status.PASS, "Tax category default data displayed successfully");
	  		
	  	}
	  	else{
	  		System.out.println("Tax category default data displayed unsuccessfully");
	  		 test = extent.createTest("Validating default Behaviour of Tax Category");
	 	 		test.log(Status.FAIL, "Tax category default data displayed unsuccessfully");
	  	}
 
  //Validating Ad Keyword
	  	if(driver.findElement(By.xpath(Testelements.AdKeyword_BasicDetails)).getText().equals("Ad KeywordTest")){
	  		
	  		System.out.println("Ad Keyword field contains Ad KeywordTest keyword,so test case failed");
	  		 test = extent.createTest("Validating default Behaviuor of Ad Keyword Field");
	 	 		test.log(Status.FAIL, "Ad Keyword field contains Ad KeywordTest keyword,so test case failed");
	  	
	  	}
	  	else{
	  		
	  		System.out.println("Ad Keyword field doesn't contains Ad KeywordTest keyword,so test case Passed");
	  		 test = extent.createTest("Validating default Behaviuor of Ad Keyword Field");
	 	 		test.log(Status.PASS, "Ad Keyword field doesn't contains Ad KeywordTest keyword,so test case Passed");
	  	}
 
    //Validating Hidden Keyword field default behaviour 
	  	
	  	if(driver.findElement(By.xpath(Testelements.HiddenKeyword_BasicDetails)).getText().equals("Hidden KeywordTest")){
    	   
    	   System.out.println("Hidden Keyword field contains Hidden KeywordTest keyword,so test case failed");
	  		 test = extent.createTest("Validating default Behaviuor of Hidden Keyword Field");
	 	 		test.log(Status.FAIL, "Hidden Keyword field  contains Hidden KeywordTest keyword,so test case failed");
       }
       else{
    	   
    	   System.out.println("Hidden Keyword field doesn't contains Hidden KeywordTest keyword,so test case Passed");
	  		 test = extent.createTest("Validating default Behaviuor of Hidden Keyword Field");
	 	 		test.log(Status.PASS, "Hidden Keyword field doesn't contains Hidden KeywordTest keyword,so test case Passed");
       }
 }
 
 @Test(priority=25)
 public void SEOFlag_BulkRemove() throws Exception
 {
 	try{
 		
 		waitForPageLoad();
 		
 		//Now goto Manage Product Screen Again
  		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	
  		 wait = new WebDriverWait(driver, 180);
 	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
  		
  		Thread.sleep(3000);
 		
 		
		 //Active the product
	    driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
	    //Wait for the alert to appear
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
	    //Press the ok button from alert
	    driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
	    
	    
	  	Thread.sleep(5000);
		
	//Press the Edit Button
 	driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
     
     waitForPageLoad();
 	
     Thread.sleep(2000);
     
     waitForPageLoad();
  	
     Thread.sleep(2000);
    //Checked the SEO Flag
     driver.findElement(By.xpath(Testelements.NewProduct_SEOFlag)).click();
     
     //Now goto Manage Product Screen Again
 		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();

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
      
  Thread.sleep(10000);
  
  //Select the Product for SEO Flag bulk remove
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
 				
 			    Thread.sleep(4000);
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
 				  System.out.println("Bulk SEO Operation Successfully done");
 				  
 				  test = extent.createTest("SEOFlag_BulkRemove ");
 		  		     
 		  		  test.log(Status.PASS, "Bulk SEO Operation Successfully done");
 			  }

 			  else{
                  System.out.println("Bulk SEO Operation UnSuccessfully done");
 				  
 				  test = extent.createTest("SEOFlag_BulkRemove ");
 		  		     
 		  		  test.log(Status.FAIL, "Bulk SEO Operation UnSuccessfully done");
 				  
 			  }
 	}catch(NoSuchElementException e){
 	  	   e.getStackTrace();
 	  	  
 	  	 }

 	
}
 @Test(priority=26)
 public void AddToNewGroup_Products() throws Exception{
	 try{
	
		 waitForPageLoad();
		 
		 //Now goto Manage Product Screen Again
		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();

	    
	    
	
	    wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
		 
		 Thread.sleep(3000);	    
	    //Select the First Two Products Checkboxes
	    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
	    
	
	    JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	     jse70.executeScript("window.scrollBy(0,-250)", "");
	     
	     Thread.sleep(3000);
	     
	     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
	     jse71.executeScript("window.scrollBy(-250,-500)", "");
	     
	     
	     Thread.sleep(2000);
	    //Click the Groups Option on Manage Products
	    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	    
	    
	    
	//Select Add to New Group Option
	    driver.findElement(By.xpath(Testelements.AddToNewGroupOption)).click();
	    
	    Thread.sleep(4000);
	//Storing the external ID for the Product
	    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
	    
	    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
	    
	    //Select the first Product radio button and make grouping of products against this product External ID
	    driver.findElement(By.xpath(Testelements.AddToNewGroup_ProductSelection)).click();
 
	    //Press the Create Group Button to Make Groups
	    driver.findElement(By.xpath(Testelements.AddToNewGroup_CreateGroupButton)).click();
	    
	    Thread.sleep(10000);
	    
	    //Storing value for Group after adding new groups
	    GroupName_Product1=driver.findElement(By.xpath(Testelements.GroupName_1stProduct_Verification)).getText();
	    
	    System.out.println("Product 1 Group Name:"+ GroupName_Product1);
	    
	    GroupName_Product2=driver.findElement(By.xpath(Testelements.GroupName_2ndProduct_Verification)).getText();
	    
        System.out.println("Product 2 Group Name:"+GroupName_Product2);
        
        //Validating as if the new group has been created or not
        if(GroupName_Product1.contains(AddToNewGroup_ExternalID) & GroupName_Product2.contains(AddToNewGroup_ExternalID)){
        	System.out.println("Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen");
            
        	 test = extent.createTest("AddToNewGroup_Products");
	  		     
	  		test.log(Status.PASS, "Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen");
        }
 
        else{
        	System.out.println("Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen");
            
       	    test = extent.createTest("AddToNewGroup_Products");
	  		     
	  		test.log(Status.PASS, "Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen");
        }
 
	 }catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 }
 
 
 
 
 
 }
 @Test(priority=27)
 public void AddToExistingGroup() throws Exception{
	 try{
	 //Select the Product at third position on Manage Products Screen
	 driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox3)).click();
	 
	 
	 JavascriptExecutor jse70 = (JavascriptExecutor)driver;
     jse70.executeScript("window.scrollBy(0,-250)", "");
     
     Thread.sleep(3000);
     
     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
     jse71.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(3000);
	 
	 //Go to groups and select Add to existing 
	 driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	 
	 driver.findElement(By.xpath(Testelements.AddToExistingGroup)).click();
	 
	 Thread.sleep(4000);
	 
	 ExistingGroup_ExternalID=driver.findElement(By.xpath(Testelements.ExistingProduct_ExternalID_Popup)).getText();
	 
	 System.out.println("Existing group External ID:"+ExistingGroup_ExternalID);
	 //Select the Product
	 driver.findElement(By.xpath(Testelements.AddToExistingGroup_ProductSelection)).click();
	 
	 //Press the Next Button
	 
	 WebElement element1 = driver.findElement(By.xpath(Testelements.AddToExistingGroup_NextButton));
     JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     executor1.executeScript("arguments[0].click();", element1);
	 
	//driver.findElement(By.xpath(Testelements.AddToExistingGroup_NextButton)).click();
	 
	 wait = new WebDriverWait(driver, 120);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddToExistingGroup_AddGroupButton)));
	 
	 Thread.sleep(1000);
	 
	 WebElement element2 = driver.findElement(By.xpath(Testelements.AddToExistingGroup_AddGroupButton));
     JavascriptExecutor executor2 = (JavascriptExecutor)driver;
     executor2.executeScript("arguments[0].click();", element2);
	 
	 
	 //driver.findElement(By.xpath(Testelements.AddToExistingGroup_AddGroupButton)).click();
	 
	 Thread.sleep(3000);
	 
	 isAlertPresent();
	 
	 Thread.sleep(10000);
	 
	 GroupName_Product3=driver.findElement(By.xpath(Testelements.GroupName_3rdProduct_Verification)).getText();
	 
	 System.out.println("Existing Group Updated ID:"+GroupName_Product3);
	 
	 if(GroupName_Product3.contains(ExistingGroup_ExternalID))
	 {
		System.out.println("Existing Group Name Updated Successfully For Product");
		
		 test = extent.createTest("AddToExistingGroup");
		     
	  	test.log(Status.PASS, "Existing Group Name Updated Successfully For Product");
		
	 }
	 else{
		
		 System.out.println("Existing Group Name Updated UnSuccessfully For Product");
			
		 test = extent.createTest("AddToExistingGroup");
		     
	  	test.log(Status.FAIL, "Existing Group Name Updated UnSuccessfully For Product");
	 }
	 }catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 }


 
 }
 
 @Test(priority=28)
 public void ManageGroups_Editing_WithGroupsRemoval() throws Exception
 {
	 try{
	 //Select a product from product Listing
	 //Select the First Two Products Checkboxes
	    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	    Thread.sleep(1000);
	    
	  //Click the Groups Option on Manage Products
	    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	    
	  //Select the Manage Groups Option
	    driver.findElement(By.xpath(Testelements.Groups_ManageGroups_Option)).click();
	    
	    Thread.sleep(4000);
	    
	  //Press the Edit button for first group
	    driver.findElement(By.xpath(Testelements.ManageGroup_EditButton)).click();
	    
	    Thread.sleep(5000);
	    
	    ExternalID_StringRemoval();
	    
	    if(driver.findElement(By.xpath(Testelements.AdFlag_Column)).getText().contains("Ad Flag"))
		   {
			   System.out.println("Ad flag Column Displayed Successfully");
			   
			   test = extent.createTest("ADFlag_Column_Verification");
			     
	  		   test.log(Status.PASS, "Ad flag Column Displayed Successfully");
			   
			   
		   }
		   else{
	           System.out.println("Ad flag Column Displayed UnSuccessfully");
			   
			   test = extent.createTest("ADFlag_Column_Verification");
			     
	  		   test.log(Status.FAIL, "Ad flag Column Displayed UnSuccessfully");

		   }
		    
	    
	    //Now storing the product to which group is updating to
	    ExternalID_Update_ProductNameGet=driver.findElement(By.xpath(Testelements. ExternalProductName_Updated_Editing)).getText();
	    
	    System.out.println(ExternalID_Update_ProductNameGet);
	    
	    //Now select the group and update it
	    driver.findElement(By.xpath(Testelements.EditGroup_SelectionRadioPrimary)).click();
	    
	    WebElement element0 = driver.findElement(By.xpath(Testelements.GroupEdit_SaveButton));
	       JavascriptExecutor executor0 = (JavascriptExecutor)driver;
	       executor0.executeScript("arguments[0].click();", element0);  
	    
	    
	    //Press the save Button
	    //driver.findElement(By.xpath(Testelements.GroupEdit_SaveButton)).click();
	    
	    Thread.sleep(2000);
	    
	  
	    Alert alert = driver.switchTo().alert();		
		
      // Accepting alert		
        alert.accept();
        
        Thread.sleep(8000);
        
        isAlertPresent();
        
        Thread.sleep(5000);
          
	    //Search the external id for product
	    driver.findElement(By.xpath(Testelements.SearchProduct_field)).sendKeys(reminder);
	    
        driver.findElement(By.xpath(Testelements.SearchProduct_Button)).click();
    	
    	Thread.sleep(8000);
    	
    	if(driver.getPageSource().contains(ExternalID_Update_ProductNameGet))
    	{
    		System.out.println("Grouping for a Group Updated Successfully");
    		
    		 test = extent.createTest("ManageGroups_UpdateGrouping");
		     
    		 test.log(Status.PASS, "Grouping for a Group Updated Successfully");
    	}
    	else{
    		System.out.println("Grouping for a Group Updated UnSuccessfully");
    	
    		 test = extent.createTest("ManageGroups_UpdateGrouping");
		     
    		 test.log(Status.FAIL, "Grouping for a Group Updated UnSuccessfully");
    	}
	
    	 //Select the First Two Products Checkboxes
	    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	    Thread.sleep(1000);
	    
	  //Click the Groups Option on Manage Products
	    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	    
	  //Select the Manage Groups Option
	    driver.findElement(By.xpath(Testelements.Groups_ManageGroups_Option)).click();
	    
	    Thread.sleep(4000);
	    
	    OldNumberofProduct_In_Groups=driver.findElement(By.xpath(Testelements.NumberofProducts_InGroup_Verification)).getText();
	    System.out.println(OldNumberofProduct_In_Groups);
	  //Press the Edit button for first group
	    driver.findElement(By.xpath(Testelements.ManageGroup_EditButton)).click();
	    
	    Thread.sleep(5000);
	    
	   
	    
	    //Press the delete x icon
	    driver.findElement(By.xpath(Testelements.EditGroup_RemoveProduct_FromGroup)).click();
	    
	       Alert alert1 = driver.switchTo().alert();		
		
	      // Accepting alert		
	       alert1.accept();
	        
	       Thread.sleep(8000);
	  
	       WebElement element2 = driver.findElement(By.xpath(Testelements.GroupEdit_SaveButton));
	       JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	       executor2.executeScript("arguments[0].click();", element2);     
	 
	 //driver.findElement(By.xpath(Testelements.GroupEdit_SaveButton)).click();
	 
	 Alert alert2 = driver.switchTo().alert();		
		
     // Accepting alert		
      alert2.accept();
      
      isAlertPresent();
	 
      JavascriptExecutor jse70 = (JavascriptExecutor)driver;
      jse70.executeScript("window.scrollBy(0,-250)", "");
      
      
      JavascriptExecutor jse71 = (JavascriptExecutor)driver;
      jse71.executeScript("window.scrollBy(-250,-500)", "");
      
      Thread.sleep(8000);
      
	 //Select the First Two Products Checkboxes
	    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	    Thread.sleep(1000);
	    
	  //Click the Groups Option on Manage Products
	    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	    
	  //Select the Manage Groups Option
	    driver.findElement(By.xpath(Testelements.Groups_ManageGroups_Option)).click();
	    
	    Thread.sleep(4000);
	 
	    NewNumberofProduct_In_Groups=driver.findElement(By.xpath(Testelements.NumberofProducts_InGroup_Verification)).getText();
	    System.out.println(NewNumberofProduct_In_Groups);
	   //Validaing as if the Product is removed or not
	    
	    if(!NewNumberofProduct_In_Groups.equals(OldNumberofProduct_In_Groups))
	    {
	    	System.out.println("Product removed from the group Successfully");
	   
	    	test = extent.createTest("GroupRemoving_From_ManageGroups");
		     
    		test.log(Status.PASS, "Product removed from the group Successfully");
	    }
	    else{
	    	System.out.println("Product removed from the group UnSuccessfully");
	    	
	    	test = extent.createTest("GroupRemoving_From_ManageGroups");
		     
	    	 test.log(Status.FAIL, "Product removed from the group UnSuccessfully");
	    }
	  //Now Delete the Group as a whole
	    driver.findElement(By.xpath(Testelements.ManageGroups_DeleteGroup_Button)).click();
	    
	    Thread.sleep(1000);
	    
	    Alert alert3 = driver.switchTo().alert();		
		
	     // Accepting alert		
	      alert3.accept();
		 
		 Thread.sleep(8000);
	    
		 WebElement element1 = driver.findElement(By.xpath(Testelements.ManageGroups_CloseButton));
	       JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	       executor1.executeScript("arguments[0].click();", element1);  
		 
		 
		 //Close the Manage Groups
	    //driver.findElement(By.xpath(Testelements.ManageGroups_CloseButton)).click();
	    
	    Thread.sleep(2000);
	    
	   
	    
	 }catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 } 
 }
 
 @Test(priority=29)
 public void CreateNewMergeRelationship() throws InterruptedException, AWTException{
	 try{
		 driver.findElement(By.xpath(Testelements.RemoveSearched1)).click();
	    	
	     Thread.sleep(2000);
	    
		  CopyProduct();
	    
	    //Select two products and Add groups and make child product expires for Now
        driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
	    
	    JavascriptExecutor jse70 = (JavascriptExecutor)driver;
        jse70.executeScript("window.scrollBy(0,-250)", "");
        
        
        JavascriptExecutor jse71 = (JavascriptExecutor)driver;
        jse71.executeScript("window.scrollBy(-250,-500)", "");
        
        Thread.sleep(1000);
	    
	    
	    
	    //Click the Groups Option on Manage Products
	    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
	    
	//Select Add to New Group Option
	    driver.findElement(By.xpath(Testelements.AddToNewGroupOption)).click();
	    
	    Thread.sleep(4000);
	//Storing the external ID for the Product
	    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
	    
	    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
	    
	    //Select the first Product radio button and make grouping of products against this product External ID
	    driver.findElement(By.xpath(Testelements.AddToNewGroup_ProductSelection)).click();
 
	    //Set Expire Child product for now option
	    driver.findElement(By.xpath(Testelements.ChildProductSetExpiryDate_Now)).click();
	    
	    //Press the Create Group Button to Make Groups
	    driver.findElement(By.xpath(Testelements.AddToNewGroup_CreateGroupButton)).click();
	    
	    Thread.sleep(3000);
	    
	    Alert alert=driver.switchTo().alert();
        
	    String Alertext=alert.getText();
	    
	    System.out.println(Alertext);
	    
	    if(Alertext.contains("An Inactive product has been selected as a Primary Product"))
	    {
	    	System.out.println("Alert Displayed if Inactive product Selected as Parent Product for Creating Grouping Successfully");
	    	
	    	test = extent.createTest("AlertVerification_InactiveProductSelectAsParent_CreateNewGroup");
		     
	  		test.log(Status.PASS, "Alert Displayed  if Inactive product Selected as Parent Product for Creating Grouping Successfully");
	    	
	    }
	    else{
            System.out.println("Alert Displayed if Inactive product Selected as Parent Product for Creating Grouping UnSuccessfully");
	    	
	    	test = extent.createTest("AlertVerification_InactiveProductSelectAsParent_CreateNewGroup");
		     
	  		test.log(Status.FAIL, "Alert Displayed  if Inactive product Selected as Parent Product for Creating Grouping UnSuccessfully"); 
	    }
	    
	    
	    alert.dismiss();
	    
	    Thread.sleep(2000);
	   
	    //Close the Popup
	    driver.findElement(By.xpath(Testelements.AddNewGroup_CancelButton)).click();
	    
	    Thread.sleep(8000);
	    
	    //Active the product
	       driver.findElement(By.xpath(Testelements.ProductAcive_2ndRow)).click();
	       //Wait for the alert to appear
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
	       //Press the ok button from alert
	       driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
	       
	       Thread.sleep(7000);
	       
	       JavascriptExecutor jse73 = (JavascriptExecutor)driver;
	        jse73.executeScript("window.scrollBy(0,-250)", "");
	        
	        
	        JavascriptExecutor jse74 = (JavascriptExecutor)driver;
	        jse74.executeScript("window.scrollBy(-250,-500)", "");
	        
	        Thread.sleep(1000);
	       
	       
	       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
		    
		
		    JavascriptExecutor jse75 = (JavascriptExecutor)driver;
	        jse75.executeScript("window.scrollBy(0,-250)", "");
	        
	        
	        JavascriptExecutor jse76 = (JavascriptExecutor)driver;
	        jse76.executeScript("window.scrollBy(-250,-500)", "");
		    
		    
		    //Click the Groups Option on Manage Products
		    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
		    
		//Select Add to New Group Option
		    driver.findElement(By.xpath(Testelements.AddToNewGroupOption)).click();
		    
		    Thread.sleep(4000);
		//Storing the external ID for the Product
		    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
		    
		    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
		    
		    //Select the first Product radio button and make grouping of products against this product External ID
		    driver.findElement(By.xpath(Testelements.AddToNewGroup_ProductSelection)).click();
	 
		    //Set Expire Child product for now option
		    driver.findElement(By.xpath(Testelements.ChildProductSetExpiryDate_Now)).click();
		    
		    //Press the Create Group Button to Make Groups
		    driver.findElement(By.xpath(Testelements.AddToNewGroup_CreateGroupButton)).click();
		    
		   Thread.sleep(10000);
	    
	    //Storing value for Group after adding new groups
	    GroupName_Product1=driver.findElement(By.xpath(Testelements.GroupName_1stProduct_Verification)).getText();
	    
	    System.out.println("Product 1 Group Name:"+ GroupName_Product1);
	    
	    GroupName_Product2=driver.findElement(By.xpath(Testelements.GroupName_2ndProduct_Verification)).getText();
	    
        System.out.println("Product 2 Group Name:"+GroupName_Product2);
        
        
	    
        if(driver.findElement(By.xpath(Testelements.ProductInReviewMerge_Now_Verification)).getText().contains("Your product is in review"))
        {
        	System.out.println("Child Product in review  by Applying Now option Successfully ");
        	
        	test = extent.createTest("AddToNewGroup_ChildProductMergeRelationship_InReview_Now");
 		     
	  		test.log(Status.PASS, "Child Product in review  by Applying Now option Successfully");
        }
        else{
            System.out.println("Child Product in review  by Applying Now option UnSuccessfully ");
        	
        	test = extent.createTest("AddToNewGroup_ChildProductMergeRelationship_InReview_Now");
 		     
	  		test.log(Status.FAIL, "Child Product in review  by Applying Now option UnSuccessfully");
        }
	   
        if(GroupName_Product1.contains(AddToNewGroup_ExternalID) & GroupName_Product2.contains(AddToNewGroup_ExternalID)){
        	System.out.println("Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen With Merge Scenario");
            
        	 test = extent.createTest("AddToNewGroup_Products_WithMerge");
	  		     
	  		test.log(Status.PASS, "Add To New Groups Done Successfully with Groups details Display successfully on Manage Products Screen With Merge Scenario");
        }
 
        else{
        	System.out.println("Add To New Groups Done UnSuccessfully with Groups details Display successfully on Manage Products Screen With Merge Scenario");
            
       	    test = extent.createTest("AddToNewGroup_Products_WithMerge");
	  		     
	  		test.log(Status.FAIL, "Add To New Groups Done UnSuccessfully with Groups details Display successfully on Manage Products Screen With Merge Scenario");
        }
	 
	 
	 }
	 catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 } 
 }
 
 @Test(priority=30)
 public void EditExisting_MergeRelationShip() throws InterruptedException{
	 
	 try{
		 GroupName_Product1=driver.findElement(By.xpath(Testelements.GroupName_1stProduct_Verification)).getText();
		    
		 System.out.println("Product 1 Group Name:"+ GroupName_Product1);
		
		 
		 //Click the Groups Option on Manage Products
		    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
		    
		  //Select the Manage Groups Option
		    driver.findElement(By.xpath(Testelements.Groups_ManageGroups_Option)).click();
		    
		 // Grab the table
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageProductGroupsModal']/div[2]/div[1]/div/table/tbody"));

		    // Now get all the TR elements from the table
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));
		    
		    System.out.println(allRows.size());
       	 
       	  if(driver.findElement(By.xpath("//span[contains(text(),'"+GroupName_Product1+"')]")).isDisplayed())
       	  {
       		driver.findElement(By.xpath("//span[contains(text(),'"+GroupName_Product1+"')]/parent::td/parent::tr/td[7]/button")).click();  
       	    
       	  }
       	  else{
       		  driver.findElement(By.xpath("//*[@id='nextPageLinkIdManageProductGroups']")).click();
       	  }
          
       	   
       	   // And iterate over them, getting the cells
		    //for (WebElement row : allRows) {
		    	
		    	
		        //List<WebElement> cells = row.findElements(By.tagName("td"));
		       // System.out.println(cells.size());
		       // String Test=cells.get(1).getText();
		       // System.out.println(Test);
		       
		       // if(Test.equals(GroupName_Product1)){
		       // 	System.out.println("Value Matched");
		        //	 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'"+Test+"')]/parent::td/parent::tr/td[7]/button")));
		    
		        //	 driver.findElement(By.xpath("//span[contains(text(),'"+Test+"')]/parent::td/parent::tr/td[7]/button")).click();
		        
		        //    Thread.sleep(5000);
		      //  }
		      //  else{
		        	//System.out.println("Value not Matched");
		        
		           
		        //}
		      
		   // }
		    //Now Select the new primary product to update the Grouping for Current
		    driver.findElement(By.xpath(Testelements.NewPrimaryProductSelection)).click();
		    
		    Thread.sleep(2000);
		    
		    String ExternalID_UpdatedPrimaryProduct=driver.findElement(By.xpath(Testelements.NewPrimaryProductSlection_ExternalID)).getText();
	        System.out.println(ExternalID_UpdatedPrimaryProduct);
	        
	        driver.findElement(By.xpath(Testelements.ChildProductSetExpiryDate_Later)).click();
	        
	        Thread.sleep(3000);
	        
	        //Chnage the inactive date to future date
	        driver.findElement(By.xpath(Testelements.DataPicker_ChildProductFutureExpiry_AddGroups)).click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath(Testelements.DatePicker_AddGroups_NextButton)).click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath(Testelements.DateSelection)).click();
	        
	        driver.findElement(By.xpath(Testelements.GroupEdit_SaveButton)).click();
		    
		    Thread.sleep(2000);
		    
		  
		    Alert alert = driver.switchTo().alert();		
			
	      // Accepting alert		
	        alert.accept();
	        
	        Thread.sleep(3000);
	        
	        alert.accept();
	        
	        Thread.sleep(8000);
		    GroupName_Product1=driver.findElement(By.xpath(Testelements.GroupName_1stProduct_Verification)).getText();
		    
			 System.out.println("Product 1 Group Name:"+ GroupName_Product1);
			 
			 if(ExternalID_UpdatedPrimaryProduct.equals(GroupName_Product1) & driver.findElement(By.xpath(Testelements.ScheduledInActivationValidation)).isDisplayed())
			 {
				 System.out.println("Edit Existing Merge Relationship with future date Successfully");
				 
				 test = extent.createTest("EditExistingMergeRelationShip_WithFutureDate");
	  		     
			  	 test.log(Status.PASS, "Edit Existing Merge Relationship with future date Successfully");
			 }
			 else{
                 System.out.println("Edit Existing Merge Relationship with future date UnSuccessfully");
				 
				 test = extent.createTest("EditExistingMergeRelationShip_WithFutureDate");
	  		     
			  	 test.log(Status.FAIL, "Edit Existing Merge Relationship with future date UnSuccessfully");
			 }
	        
	 }
	 catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 } 
 }
 
 @Test(priority=31)
 public void EditAddGroups_MergeRelationShip() throws InterruptedException, AWTException{
	 
	 try{
		
		   CopyProduct();
		  
		//Select two products and Add groups and make child product expires for Now
	        driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
		    
		    JavascriptExecutor jse75 = (JavascriptExecutor)driver;
	        jse75.executeScript("window.scrollBy(0,-250)", "");
	        
	        
	        JavascriptExecutor jse76 = (JavascriptExecutor)driver;
	        jse76.executeScript("window.scrollBy(-250,-500)", "");
	        
	        Thread.sleep(1000);
		    
		    
		    //Click the Groups Option on Manage Products
		    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
		    
		//Select Add to New Group Option
		    driver.findElement(By.xpath(Testelements.AddToNewGroupOption)).click();
		    
		    Thread.sleep(4000);
		//Storing the external ID for the Product
		    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
		    
		    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
		    
		    //Select the first Product radio button and make grouping of products against this product External ID
		    driver.findElement(By.xpath(Testelements.AddToNewGroup_ProductSelection)).click();
	 
		    //Set Expire Child product for now option
		    driver.findElement(By.xpath(Testelements.ChildProductSetExpiryDate_Now)).click();
		    
		    //Press the Create Group Button to Make Groups
		    driver.findElement(By.xpath(Testelements.AddToNewGroup_CreateGroupButton)).click();
		    
		    Thread.sleep(3000);
		    
		    Alert alert=driver.switchTo().alert();
	        
		    String Alertext=alert.getText();
		    
		    System.out.println(Alertext);
		    
		    if(Alertext.contains("An Inactive product has been selected as a Primary Product"))
		    {
		    	System.out.println("Alert Displayed if Inactive product Selected as Parent Product for Creating Grouping Successfully");
		    	
		    	test = extent.createTest("AlertVerification_InactiveProductSelectAsParent_CreateNewGroup");
			     
		  		test.log(Status.PASS, "Alert Displayed  if Inactive product Selected as Parent Product for Creating Grouping Successfully");
		    	
		    }
		    else{
	            System.out.println("Alert Displayed if Inactive product Selected as Parent Product for Creating Grouping UnSuccessfully");
		    	
		    	test = extent.createTest("AlertVerification_InactiveProductSelectAsParent_CreateNewGroup");
			     
		  		test.log(Status.FAIL, "Alert Displayed  if Inactive product Selected as Parent Product for Creating Grouping UnSuccessfully"); 
		    }
		    
		    
		    alert.dismiss();
		   
		    //Close the Popup
		    driver.findElement(By.xpath(Testelements.AddNewGroup_CancelButton)).click();
		    
		    Thread.sleep(8000);
		    
		    //Active the product
		       driver.findElement(By.xpath(Testelements.ProductAcive_2ndRow)).click();
		       //Wait for the alert to appear
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
		       //Press the ok button from alert
		       driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
		       
		       Thread.sleep(7000);
		       
		       JavascriptExecutor jse85 = (JavascriptExecutor)driver;
		        jse85.executeScript("window.scrollBy(0,-250)", "");
		        
		        
		        JavascriptExecutor jse86 = (JavascriptExecutor)driver;
		        jse86.executeScript("window.scrollBy(-250,-500)", "");
		        
		        Thread.sleep(1000);
		       
		       
		       driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
			    
			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath(Testelements.BulkProduct_Checkbox2)).click();
			    
			    JavascriptExecutor jse78 = (JavascriptExecutor)driver;
		        jse78.executeScript("window.scrollBy(0,-250)", "");
		        
		        
		        JavascriptExecutor jse77 = (JavascriptExecutor)driver;
		        jse77.executeScript("window.scrollBy(-250,-500)", "");
		        
		        Thread.sleep(1000);
			    
			    
			    //Click the Groups Option on Manage Products
			    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
			    
			//Select Add to New Group Option
			    driver.findElement(By.xpath(Testelements.AddToNewGroupOption)).click();
			    
			    Thread.sleep(4000);
			//Storing the external ID for the Product
			    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
			    
			    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
			    
			    
			    
			    //Select the first Product radio button and make grouping of products against this product External ID
			    driver.findElement(By.xpath(Testelements.AddToNewGroup_ProductSelection)).click();
		 
			    //Set Expire Child product for now option
			    driver.findElement(By.xpath(Testelements.ChildProductSetExpiryDate_Now)).click();
			    
			    //Press the Create Group Button to Make Groups
			    driver.findElement(By.xpath(Testelements.AddToNewGroup_CreateGroupButton)).click();
			    
			   Thread.sleep(10000);
		    
		    //Storing value for Group after adding new groups
		    GroupName_Product1=driver.findElement(By.xpath(Testelements.GroupName_1stProduct_Verification)).getText();
		    
		    System.out.println("Product 1 Group Name:"+ GroupName_Product1);
		    
		    GroupName_Product2=driver.findElement(By.xpath(Testelements.GroupName_2ndProduct_Verification)).getText();
		    
	        System.out.println("Product 2 Group Name:"+GroupName_Product2);
	        
	        wait = new WebDriverWait(driver, 180);
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));

	        Thread.sleep(1000);
	        
	        driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
	        
	        //Wait for the button to appear
	   	    wait = new WebDriverWait(driver, 180);
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
	        
	        driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
	        
	        Thread.sleep(10000);
	        
	        CopyProduct();
	        
	        JavascriptExecutor jse81 = (JavascriptExecutor)driver;
	        jse81.executeScript("window.scrollBy(0,-250)", "");
	        
	        
	        JavascriptExecutor jse82 = (JavascriptExecutor)driver;
	        jse82.executeScript("window.scrollBy(-250,-500)", "");
	        
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		    
		    Thread.sleep(1000);
		    
		    JavascriptExecutor jse79 = (JavascriptExecutor)driver;
	        jse79.executeScript("window.scrollBy(0,-250)", "");
	        
	        
	        JavascriptExecutor jse80 = (JavascriptExecutor)driver;
	        jse80.executeScript("window.scrollBy(-250,-500)", "");
	        
	        Thread.sleep(1000);
		    
		    
		    //Click the Groups Option on Manage Products
		    driver.findElement(By.xpath(Testelements.GroupsOption_ManageProducts)).click();
		    
		//Select Add to New Group Option
		    driver.findElement(By.xpath(Testelements.AddToExistingGroup)).click();
			 
			 Thread.sleep(4000);
		    
		//Storing the external ID for the Product
		    AddToNewGroup_ExternalID=driver.findElement(By.xpath(Testelements.AddNewGroup_Product_ExternalID)).getText();
		    
		    System.out.println("External ID For Product is:"+AddToNewGroup_ExternalID);
		    
		    driver.findElement(By.xpath(Testelements.AddToExistingGroup_ProductSelection)).click();
		    
		    //Press the Next Button
		    WebElement element2 = driver.findElement(By.xpath(Testelements.AddToExistingGroup_NextButton));
		    JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		    executor2.executeScript("arguments[0].click();", element2);
		    
		    // driver.findElement(By.xpath(Testelements.AddToExistingGroup_NextButton)).click();
			 
			 wait = new WebDriverWait(driver, 120);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddToExistingGroup_AddGroupButton)));
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//*[@id='addProductsToExistingGroupModal']/div[2]/div[3]/div/input[1]")).click();
			 
			 Thread.sleep(2000);
			 
			 String GroupUpdationID=driver.findElement(By.xpath(Testelements.GroupUpdation_ID_MergeRelationship)).getText();
			 
			 System.out.println(GroupUpdationID);
			 
			
			 WebElement element7 = driver.findElement(By.xpath(Testelements.AddToExistingGroup_NextButton));
			 JavascriptExecutor executor7 = (JavascriptExecutor)driver;
			 executor7.executeScript("arguments[0].click();", element7);
			 
			// driver.findElement(By.xpath(Testelements.AddToExistingGroup_AddGroupButton)).click();
			 
			 Thread.sleep(8000);
			 
			 isAlertPresent();
			 
			 Thread.sleep(10000);
			 
			 GroupName_Product3=driver.findElement(By.xpath(Testelements.GroupName_3rdProduct_Verification)).getText();
			 
			 System.out.println("Existing Group Updated ID:"+GroupName_Product3);
		    
		   
			 if(GroupName_Product3.contains(GroupUpdationID))
			 {
				System.out.println("Existing Group Name Updated Successfully For Merge relationship group");
				
				 test = extent.createTest("AddToExistingGroup_MergeRelationShip");
				     
			  	test.log(Status.PASS, "Existing Group Name Updated Successfully For Merge relationship group");
				
			 }
			 else{
				
				 System.out.println("Existing Group Name Updated UnSuccessfully For Merge relationship group");
					
				 test = extent.createTest("AddToExistingGroup_MergeRelationShip");
				     
			  	test.log(Status.FAIL, "Existing Group Name Updated UnSuccessfully For Merge relationship group");
			 }
		    
	        
		    
	       
		   
	       
		 
		  
	        
	 }
	 catch(NoSuchElementException e){
	  	   e.getStackTrace();
	  	  
	  	 } 
 }
 
 
 @Test(priority=32)
 public void LockProducts() throws Exception
 {
	 try{
	 
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));

	     Thread.sleep(1000);
	        
	     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
	        
	        //Wait for the button to appear
	   	 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
	        
	     driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
	        
	     Thread.sleep(10000);
	      
		 //Go to EIT Dashboard tab 
			driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
			
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

		    dropdown.selectByVisibleText("Lock / Unlock Categories");

		    Thread.sleep(2000);
		    
		    //Enter the ASI Number
		    driver.findElement(By.xpath(Testelements.CategoryASI_SearchField)).sendKeys("30232");
		    
		    driver.findElement(By.xpath(Testelements.CategoryASI_SearchButton)).click();
		    
		    Thread.sleep(4000);
		    
		    if(driver.getCurrentUrl().contains("stage"))
		    {
		    	driver.findElement(By.xpath(Testelements.CategoryEIT_SelectionStage)).click();
			    
			    Thread.sleep(2000);
		    }
		    else{
		    //Select the category from list
		    driver.findElement(By.xpath(Testelements.CategoryEIT_Selection)).click();
		    
		    Thread.sleep(2000);
		    }
		    
		    //Press the save Button
		    driver.findElement(By.xpath(Testelements.SaveCategories_ForLocking)).click();
		    
		    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
       	    {
       	    	System.out.println("Locked Operationfor EIT Categories Successfull");
       	    	
       	    	
       	    }
       	    else{
       	  
                   System.out.println("Locked Operationfor EIT Categories UnSuccessfull");
       	    	
       	    	    
       	    }
		    Thread.sleep(2000);
		    
		    
		    
		    driver.findElement(By.xpath(Testelements.EITManageProducts)).click();
			  
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
		      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
		 
		      //Wait for supplier selection option to appear
		      wait = new WebDriverWait(driver, 180);
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ManageProducts_Tab)));
		      
		      Thread.sleep(4000);
		      
		      //Click the manage products tab
		      driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
		      
		      Thread.sleep(3000);
              if(driver.getCurrentUrl().contains("stage"))
              {
            	  driver.findElement(By.xpath(Testelements.DefaultSearchedoptionStage)).click();
  		    	
    		      Thread.sleep(8000);  
              }
              else{
		      driver.findElement(By.xpath(Testelements.DefaultSearchedoption)).click();
		    	
		      Thread.sleep(8000);
              }
		     
              //Go to Edit Product Details
              driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
              
              waitForPageLoad();
              
              Thread.sleep(2000);
             
              waitForPageLoad();
           	
              Thread.sleep(2000);
              
              driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
              
              Thread.sleep(8000);
              
              driver.navigate().refresh();
              
              driver.navigate().refresh();
              
              Thread.sleep(2000);
              
              wait = new WebDriverWait(driver, 180);
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.LockedProductVerification)));
		    
		      Thread.sleep(2000);
		      
		      if(driver.findElement(By.xpath(Testelements.LockedProductVerification)).isDisplayed())
		      {
		    	  System.out.println("Product Locking done Successfully");
		    	  
		    	  test = extent.createTest("ProductLocking");
				     
		    	  test.log(Status.PASS, "Product Locking done Successfully");
		      }
		      else{
                  System.out.println("Product Locking done Successfully");
		    	  
		    	  test = extent.createTest("ProductLocking");
				     
		    	  test.log(Status.FAIL, "Product Locking done Successfully");
		      }
	    
		    
		    //Go to Customer Account and Validate restriction on locked products
			    driver.findElement(By.xpath(Testelements.MyAccount_MenuBar)).click();
			    
			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath(Testelements.Logout_MyAccount)).click();
			    
			    Thread.sleep(5000);
			    
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
			    test = extent.createTest("Login To Customer Supplier");
			   
			   	test.log(Status.PASS, "Supplier Loggedin Successfully");
			    }
			    else{
			    	 System.out.println("Supplier Loggedin UnSuccessfully");
			    	test = extent.createTest("Login To Customer Supplier");
			    	   
			       	test.log(Status.FAIL, "Supplier Loggedin UnSuccessfully");
			    }
				 
			    
			    if(driver.getCurrentUrl().contains("stage"))
	              {
	            	  driver.findElement(By.xpath(Testelements.DefaultSearchedoptionStage)).click();
	  		    	
	    		      Thread.sleep(8000);  
	              }
	              else{
			      driver.findElement(By.xpath(Testelements.DefaultSearchedoption)).click();
			    	
			      Thread.sleep(8000);
	              }
			    
			    if(!driver.findElement(By.cssSelector(Testelements.EditProduct)).isEnabled() & !driver.findElement(By.xpath(Testelements.Copy_Button)).isEnabled() & driver.findElement(By.xpath(Testelements.LockedProductVerification)).isDisplayed())
			    {
			    	System.out.println("Product Edit and Copy Button Disabled Successfully on Customer user after locking the category for the product");
			    
			    	test = extent.createTest("Edit&Copy_Buttons_Disabled after Locking Verification");
					   
				   	test.log(Status.PASS, "Product Edit and Copy Button Disabled Successfully on Customer user after locking the category for the product");
			    
			    }
			    else{
			    	System.out.println("Product Edit and Copy Button Disabled UnSuccessfully on Customer user after locking the category for the product");
				    
			    	test = extent.createTest("Edit&Copy_Buttons_Disabled after Locking Verification");
					   
				   	test.log(Status.FAIL, "Product Edit and Copy Button Disabled UnSuccessfully on Customer user after locking the category for the product");
			    }
		      
			    driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
		  		
			    Thread.sleep(1000);
			    
			  //Press the bulk edit button
	  			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click(); 
	  			
	  			Thread.sleep(4000);
	  			
	  			List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
  	 		  	li1.get(2).click();
  	
  			   Thread.sleep(4000);
  			   
  			//Press the keyword option
  	  		 driver.findElement(By.xpath(Testelements.Bulk_keyword)).click();
  			  
  			 Thread.sleep(2000);
  			
  	  		//Press the bulk edit poup button
  	  		
  			  //Press the keyword option
  		  		List<WebElement> li8= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
  				li8.get(8).click();
  		  		
  	  			Thread.sleep(2000);
  	  			
  	  		if(driver.findElement(By.xpath(Testelements.LockedProduct_BulkUpdateVerification)).getText().contains("will not be updated as they are locked"))
  	  		{
  	  			System.out.println("Locked Product Doesn't Bulk Edit Successfully");
  	  			
  	  		test = extent.createTest("LockedProducts_BulkEdit_Verification");
			   
		   	test.log(Status.PASS, "Locked Product Doesn't Bulk Edit Successfully");
  	  			
  	  		}
  	  		else{
  	  			
  	  		System.out.println("Locked Product Does Bulk Edit Successfully");
	  			
  	  		test = extent.createTest("LockedProducts_BulkEdit_Verification");
			   
		   	test.log(Status.FAIL, "Locked Product Does Bulk Edit Successfully");
  	  		}
  	  		
  	  		//Press the Ok button to close the verification alert for bulk Edit Locked Products
  	  		driver.findElement(By.xpath(Testelements.LockedProductAlert_OkButton)).click();
  	  		
  	  		Thread.sleep(2000);
  	  		
  	  	Alert alert = driver.switchTo().alert();		
		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert.accept();	
        
        Thread.sleep(1000);
        
        driver.navigate().refresh();
        
        wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));

	    Thread.sleep(4000);
	    
        
        driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
  		
	    Thread.sleep(3000);
        
       //Press the Add To Special Button for Locked Products
        driver.findElement(By.xpath(Testelements.AddToSpecial_Button)).click();
        
        Thread.sleep(2000);
        
        if(driver.findElement(By.xpath(Testelements.AddToSpecial_LockedProductVerification)).getText().contains("not be added to special as they have been locked by ASI"))
        {
        	System.out.println("Add To Special Locked product not updated Successfully");
        	
        	test = extent.createTest("LockedProducts_AddToSpecial_Verification");
			   
		   	test.log(Status.PASS, "Add To Special Locked Product Doesn't Bulk Edit Successfully");
        }
        else{
        	
            System.out.println("Add To Special Locked product updated Successfully");
        	
        	test = extent.createTest("LockedProducts_AddToSpecial_Verification");
			   
		   	test.log(Status.FAIL, "Add To Special Locked Product Doesn't Bulk Edit Successfully");
        }
        
        //Press the Ok Button
        driver.findElement(By.xpath(Testelements.AddToSpecial_LockedProduct_OKButton)).click();
        
        Thread.sleep(2000);
        
        Alert alert1 = driver.switchTo().alert();		
		
        // Capturing alert message.    
        String alertMessage1= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage1);	
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert1.accept();	
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();
        
        Thread.sleep(2000);
        
        List<WebElement> li3= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
		  	li3.get(2).click();

		   Thread.sleep(2000);
        
		   driver.findElement(By.xpath(Testelements.BulkEdit_MakeInactiveOption)).click();
		  
			 Thread.sleep(2000);
			
	  		//Press the bulk edit poup button
	  		
			  
			 //Press the keyword option
		  		List<WebElement> li9= driver.findElements(By.xpath(Testelements.BulkEdit_Popup));
				li9.get(8).click();
		  		
	  			Thread.sleep(2000);
	  			
	  			//Now Select the Inacive Now Option for Bulk Edit 
	  			driver.findElement(By.xpath(Testelements.BulkEdit_UnpublishSelection)).click();
	  			
	  			Thread.sleep(2000);
	  			
	  			//Press Make Inactive Product Button
	  			driver.findElement(By.xpath(Testelements.BulkEditInactiveConfirmButton)).click();
	  			
	  			Thread.sleep(2000);
	  			
	  			driver.navigate().refresh();
	  			
	  			
	  			Thread.sleep(5000);
	  		  	if(driver.findElement(By.xpath(Testelements.InactivationNowValidation)).isDisplayed()){
	  		        System.out.println("Bulk Edit Locked Product Inactivation NOW Successfull");
	  		  	    
	  		        test = extent.createTest("BulkEdit_LockedProductInactivation");
	  		    	
	  		    	test.log(Status.PASS, "Bulk Edit Locked Product Inactivation NOW Successfull");
	  		  	}
	  		  	else{
	  		  		 System.out.println("Bulk Edit Locked Product Inactivation NOW UnSuccessfull");
	  		       
	  		  		 test = extent.createTest("LockedProductInactivation");
	  		    	
	  		    	test.log(Status.FAIL, "Bulk Edit Locked Product Inactivation NOW UnSuccessfull");
	  		  	}
  	  		
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
			    test = extent.createTest("Login");
				
				test.log(Status.PASS, "Login to Esp Updates Successfully");
			    }
			    else{
			    	 System.out.println("Login UnSuccessfull");
			    	    test = extent.createTest("Login");
			    		
			    		test.log(Status.FAIL, "Login to Esp Updates UnSuccessfully");
			    }
			    
  	  		
		      //Go to EIT Dashboard tab 
				//driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
				
		    //Go to Admin Tab
				wait = new WebDriverWait(driver, 120);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));

			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
			    
			    wait = new WebDriverWait(driver, 120);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_CompanyLevel)));

			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel)).click();
			    
			    WebElement mySelectElement1 = driver.findElement(By.xpath(Testelements.EITAdmin_CompanyLevel_OperationSelection));
			    Select dropdown1= new Select(mySelectElement1);

			    dropdown1.selectByVisibleText("Lock / Unlock Categories");

			    Thread.sleep(2000);
			    
			    //Enter the ASI Number
			    driver.findElement(By.xpath(Testelements.CategoryASI_SearchField)).sendKeys("30232");
			    
			    driver.findElement(By.xpath(Testelements.CategoryASI_SearchButton)).click();
			    
			    Thread.sleep(4000);
			    
			    if(driver.getCurrentUrl().contains("stage"))
			    {
			    	//Select the category from list
				    driver.findElement(By.xpath(Testelements.CategoryEIT_SelectionStage)).click();
				    
				    Thread.sleep(2000);
			    }
			    else{
			    //Select the category from list
			    driver.findElement(By.xpath(Testelements.CategoryEIT_Selection)).click();
			    
			    Thread.sleep(2000);
			    }
			    //Press the save Button
			    driver.findElement(By.xpath(Testelements.SaveCategories_ForLocking)).click();
			    
			    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully"))
	       	    {
	       	    	System.out.println("Locked Operationfor EIT Categories Successfull");
	       	    	
	       	    	
	       	    }
	       	    else{
	       	  
	                   System.out.println("Locked Operationfor EIT Categories UnSuccessfull");
	       	    	
	       	    	    
	       	    }
	           
			    Thread.sleep(5000);
	 
	 
	 
	 
	 
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

 
 public static void ExternalID_StringRemoval(){
		
	 ExternalID_StringRemoval=driver.findElement(By.xpath(Testelements.ExternalProductID_Updated_Editing)).getText();
	
	 System.out.println(ExternalID_StringRemoval);	
	 
	 substr = ExternalID_StringRemoval.substring(0,ExternalID_StringRemoval.indexOf("-"));
	 
	 System.out.println(substr);
	 
	 reminder = ExternalID_StringRemoval.substring(ExternalID_StringRemoval.indexOf("-")+1, ExternalID_StringRemoval.length());
		
	  System.out.println(reminder);
		
		
	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 public void CopyProduct() throws InterruptedException{
	 
	 				 		        driver.findElement(By.xpath(Testelements.Copy_Button)).click();
	 					 		   
	 					 		 //Wait for few sec 
	 					 		    
	 					 		 	Thread.sleep(2000);
	 					 		 
	 					 		    WebElement toClear116 = driver.findElement(By.xpath(Testelements.Copy_Product_field));
	 					 		    toClear116.sendKeys(Keys.CONTROL + "a");
	 					 		    toClear116.sendKeys(Keys.DELETE); 
	 					 		    //Insert a new name
	 					 		    driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
	 					 		    //Save the copy product 
	 					 		    
	 					 		    driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
	 					 		    
	 					 		    waitForPageLoad();
	 					 		    
	 					 		    Thread.sleep(2000);
	 					 		   
	 					 		   waitForPageLoad();
	 					 		    
	 					 		    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	 					 		
	 					 		      //Wait for the alert to appear
	 					 		      wait = new WebDriverWait(driver, 180);
	 					 		      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
	 					 		     
	 					 		      Thread.sleep(2000);
	 					 		   
	 					 		     driver.findElement(By.xpath(Testelements.Copy_Button)).click();
	 						 		   
	 						 		 //Wait for few sec 
	 						 		    
	 						 		 	Thread.sleep(2000);
	 						 		 
	 						 		    WebElement toClear117 = driver.findElement(By.xpath(Testelements.Copy_Product_field));
	 						 		    toClear117.sendKeys(Keys.CONTROL + "a");
	 						 		    toClear117.sendKeys(Keys.DELETE); 
	 						 		    //Insert a new name
	 						 		    driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
	 						 		    //Save the copy product 
	 						 		    
	 						 		    driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
	 						 		    
	 						 		    waitForPageLoad();
	 						 		    
	 						 		    Thread.sleep(2000);
	 						 		   
	 						 		    waitForPageLoad();
	 						 		    
	 						 		    Thread.sleep(2000);
	 						 		   
	 						 		    waitForPageLoad();
	 						 		    
	 						 		    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	 						 		
	 						 		      //Wait for the alert to appear
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
	 						 		       
	 						 		       Thread.sleep(7000);
	 
 }
 
 
 public static boolean isAlertPresent() throws AWTException{
	    boolean foundAlert = false;
	    wait = new WebDriverWait(driver, 13 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	        System.out.println("Alert Displayed");
	        Alert alert=driver.switchTo().alert();
	        alert.accept();
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	        System.out.println("Alert Not Displayed");
	    }
	    return foundAlert;
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

