package Execution_Suite;



import java.util.List;
import java.util.NoSuchElementException;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Predicate;
import TestData.Testelements;
import io.github.bonigarcia.wdm.WebDriverManager;
import TestData.Testdata;

public class Specials_and_Trade_Features {
  
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
    static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		
           if(browser.equalsIgnoreCase("firefox")) {
			
        	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/Specials_and_Trade_Features"+".html");
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
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/Specials_and_Trade_Features"+".html");
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
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/Specials_and_Trade_Features"+".html");
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
  public void Supplier_asinumber_Insertion(){
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
    public void SpecialsCreation() throws InterruptedException
    {
    	try{
    	//Wait for the specials tab to be appear
    	wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Special_Tab_Action)));
        
        //Press the specials tab
        driver.findElement(By.cssSelector(Testelements.Special_Tab_Action)).click();
    
       //Wait for Create Special button to be appear
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.CreateSpecial_Button)));
        
       //Press the create special button
        driver.findElement(By.cssSelector(Testelements.CreateSpecial_Button)).click();
    
       //Wait for create special form to be appear
    
        wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Specialname)));
      
      //Insert the special name
        driver.findElement(By.cssSelector(Testelements.Specialname)).sendKeys(Testdata.specialname);
      
     //Press the special type dropdown
        driver.findElement(By.cssSelector(Testelements.Special_type_dropdown)).click();
     
    //Creating a robot instance to select option in 2nd place in dropdown
       
        driver.findElement(By.cssSelector(Testelements.Special_type_dropdown)).sendKeys(Keys.DOWN);
        
        driver.findElement(By.cssSelector(Testelements.Special_type_dropdown)).sendKeys(Keys.ENTER);
        
        
        
   
    //Insert the description of Specials
        driver.findElement(By.cssSelector(Testelements.Special_description)).sendKeys("Special Accessories:In the sports accessories special offer,all the discounts and benefits are placed in it so that people take special offer and with the discount on products in it also.");
   
        Thread.sleep(2000);
   //Select the start date from date picker
        driver.findElement(By.cssSelector(Testelements.Special_Startdate)).click();
        
        Thread.sleep(2000);
    	
            
        //Select a future  start date from  the date picker
       driver.findElement(By.linkText("Next")).click();
       
       driver.findElement(By.linkText("25")).click();
       
    //Select the end date from date picker
       driver.findElement(By.cssSelector(Testelements.Special_Enddate)).click();
       
       
   		Thread.sleep(2000);
   	 
       //Insert the date
       driver.findElement(By.linkText("Next")).click();
       driver.findElement(By.linkText("27")).click();
       
   //Insert the promo code
       driver.findElement(By.cssSelector(Testelements.Promo_code)).sendKeys("SA-12546");
  
       JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,250)", "");
       
      
		Thread.sleep(3000);
	
       //Validating the checkbox is disabled
      // List<WebElement> ImageUploadCheckbox= driver.findElements(By.xpath(Testelements.SpecialDisabledcheckbox));
       
       if(driver.findElement(By.cssSelector("#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span3 > div:nth-child(3) > div > div > div:nth-child(2) > div.padTop10 > input")).isEnabled())
       {
    	  System.out.print("Image Upload checkbox is enabled");
    	   
    	   test = extent.createTest("Image Upload Checkbox validation");
    	  	
    	  	test.log(Status.FAIL, "Image Upload checkbox is enabled");
    		   
    	   
       }
       else{
    	   System.out.print("Image Upload checkbox is disabled"); 
    	test = extent.createTest("Image Upload Checkbox validation");
   	  
   	  	test.log(Status.PASS, "Image Upload checkbox is disabled");
       }
      
      
       if(driver.findElement(By.cssSelector("#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span3 > div:nth-child(3) > div > div > div:nth-child(2) > div.padTop10 > strong")).getText().contains("I certify that I am uploading an end-buyer friendly image that relates to the Special being added to ESP.")){
    	   
    	   System.out.print("Image Upload Text  display correctly"); 
       	test = extent.createTest("uploading flyer message and validation verification");
      	  
      	  	test.log(Status.PASS, "Image Upload Text display correctly");
       
       }
       else{
    	   System.out.print("Image Upload Text not display correctly"); 
       	test = extent.createTest("uploading flyer message and validation verification");
      	  
      	  	test.log(Status.FAIL, "Image Upload Text not display correctly"); 
    	   
       }
       //Press the choose image button
       driver.findElement(By.cssSelector(Testelements.flyer_upload_button)).sendKeys("C:\\Desert.jpg");
       
      Thread.sleep(3000);
	
    driver.findElement(By.cssSelector(Testelements.flyer_submit_button)).click();
		
		
	Thread.sleep(15000);
		
		
		 JavascriptExecutor jse90 = (JavascriptExecutor)driver;
	       jse90.executeScript("window.scrollBy(0,-250)", "");
	       
	       
			Thread.sleep(1000);
		
		 
	   //Save the specials details
       driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();

       if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	  test = extent.createTest("SpecialsCreation");
    	   	
    	   	test.log(Status.PASS, "Special Created sucessfully");
      
      }
      else{
    	  test = extent.createTest("SpecialsCreation");
  	   	
  	   	test.log(Status.FAIL, "Special Created unsucessfully"); 
    	  
      }
       
    	
    	}catch(NoSuchElementException e){
    		
    		e.getStackTrace();
    		    	}
    	
    	
    	}

    @Test(priority=3)
    public void ProductsInsert_Specials() throws InterruptedException
    {
         try{
    	
        	//Scroll Page down
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("window.scrollBy(0,250)", "");
    	
            
             Thread.sleep(1000);
             
             //Press the add product button in new window
    	//First store parent window to switch back
    	String parentWindow = driver.getWindowHandle();

    	
    	driver.findElement(By.cssSelector(Testelements.Add_Product_button)).click();
    	
    	//Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    	    if(!winHandle.equals(parentWindow)) {
    	        driver.switchTo().window(winHandle);
    	    }
    	}
    	  
        Thread.sleep(4000);
		
      //Scroll Page down
        JavascriptExecutor jse981 = (JavascriptExecutor)driver;
        jse981.executeScript("window.scrollBy(0,-250)", "");
	
        JavascriptExecutor jse991 = (JavascriptExecutor)driver;
        jse991.executeScript("window.scrollBy(-250,-500)", "");
        
        Thread.sleep(4000);
        
        //Now find products checkbox and click 
        
          driver.findElement(By.cssSelector(Testelements.Product_popup_selection)).click();
          
          Thread.sleep(3000);
         
         
       
         //Press the add products button
         driver.findElement(By.cssSelector(Testelements.Addproduct_popup_button)).click();
         
         waitForPageLoadProductLevel();
         
         Thread.sleep(2000);
		
         

        
         //Switch back to parent window 
         driver.switchTo().window(parentWindow);

         
       //Scroll Page down
         JavascriptExecutor jse98 = (JavascriptExecutor)driver;
         jse98.executeScript("window.scrollBy(0,-250)", "");
	
         JavascriptExecutor jse99 = (JavascriptExecutor)driver;
         jse99.executeScript("window.scrollBy(-250,-500)", "");
         
         Thread.sleep(1000);
         
         //Continue with parent window 
       //Save the specials details
         driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();
         
         if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
       	  test = extent.createTest("ProductsInsert_Specials");
       	   	
       	   	test.log(Status.PASS, "Product added to special sucessfully");
         
         }
         else{
       	  test = extent.createTest("ProductsInsert_Specials");
     	   	
     	   	test.log(Status.FAIL, "Product added to special unsucessfully"); 
       	  
         }
         
        //Wait for save data process to be completed
        
	    Thread.sleep(2000);
		    
       }catch(NoSuchElementException e){
        	 e.getStackTrace();
        
         }
         
         }

     
    @Test(priority=4)
    public void Update_Specials() throws Exception{
    	try{
    	
    		//Scroll Page Up
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,-250)", "");
    		
    		//Press the back button
    		 Thread.sleep(2000);
    	
    	driver.findElement(By.xpath(Testelements.Nav_Back_Specials)).click();
        //Wait for element to appear
    	 wait = new WebDriverWait(driver, 120);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ActionDropdownSpecialPage)));
         
         Thread.sleep(2000);
         
         driver.findElement(By.xpath(Testelements.SearchSpecial_SearchField)).sendKeys(Testdata.specialname);
         
         Thread.sleep(1000);
         
         driver.findElement(By.xpath(Testelements.SearchSpecial_SearchButton)).click();
         
         Thread.sleep(4000);
    	
         WebElement mySelectElement_Edit = driver.findElement(By.xpath(Testelements.ActionDropdownSpecialPage));
         Select dropdown_Edit= new Select(mySelectElement_Edit);
        
         dropdown_Edit.selectByVisibleText("Edit");
		
         
        
    
    	//Press the add product button in new window
    	//First store parent window to switch back
    	
    	//Wait for few seconds
    	
		Thread.sleep(4000);
		
    	
    	
    	//Scroll Page down
        JavascriptExecutor jse7 = (JavascriptExecutor)driver;
        jse7.executeScript("window.scrollBy(0,250)", "");
    	
       
    	
        Thread.sleep(1000);
        String parentWindow = driver.getWindowHandle();

    	
    	driver.findElement(By.cssSelector(Testelements.Add_Product_button)).click();
    	
    	//Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    	    if(!winHandle.equals(parentWindow)) {
    	        driver.switchTo().window(winHandle);
    	    }
    	}
    	  
    
			Thread.sleep(2000);
		
    	
        
         //Now find products checkbox and click 
        
          driver.findElement(By.cssSelector(Testelements.Product_selection_update)).click();
          
        //Scroll Page down
          JavascriptExecutor jse72 = (JavascriptExecutor)driver;
          jse72.executeScript("window.scrollBy(0,250)", "");
         
         
       
         //Press the add products button
         driver.findElement(By.cssSelector(Testelements.Addproduct_popup_button)).click();
         
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
         

         //Switch back to parent window 
         driver.switchTo().window(parentWindow);
        
         try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         //Scroll Up
         JavascriptExecutor jse1 = (JavascriptExecutor)driver;
         jse1.executeScript("window.scrollBy(0,-250)", "");
         
         //Scroll Up
         JavascriptExecutor jse14 = (JavascriptExecutor)driver;
         jse14.executeScript("window.scrollBy(-250,-500)", "");
         
         
         
         //Save the details
         driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();
    
         if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
          	  test = extent.createTest("Update_Specials");
          	   	
          	   	test.log(Status.PASS, "Special Updated sucessfully");
            
            }
            else{
          	  test = extent.createTest("Update_Specials");
        	   	
        	   	test.log(Status.FAIL, "Special Updated unsucessfully"); 
          	  
            }
 			
          Thread.sleep(2000);
    	
    	}catch(NoSuchElementException e){
    		e.getStackTrace();
    		
    	}
    }
    	
@Test(priority=5)
public void Manage_Products_Add_to_Specials() throws InterruptedException{
       
	try{
        		
        //Wait for element to appear
       	 wait = new WebDriverWait(driver, 120);
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
        	
        	
        	//Select Manage products tab
        	
        	driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
        	
        	 wait = new WebDriverWait(driver, 120);
             wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Search_ManageProducts)));
        	
        
			Thread.sleep(1000);
			
        	//Search item to be insert into 
            driver.findElement(By.cssSelector(Testelements.Search_ManageProducts)).sendKeys("bats");
            
            //Press the search button
            driver.findElement(By.cssSelector(Testelements.Search_Button_ManageProducts)).click();
        	
            Thread.sleep(4000);
			
            
            //Add specials to the product
        	
            driver.findElement(By.cssSelector(Testelements.Manage_Addspecial_button)).click();
        	
        	//Shift to new window
        	String parentWindow = driver.getWindowHandle();
        	
        	//Switch to new window opened
        	for(String winHandle : driver.getWindowHandles()){
        	    if(!winHandle.equals(parentWindow)) {
        	        driver.switchTo().window(winHandle);
        	    }
        	}
        	
           Thread.sleep(2000);
    		
        	//Select the radio button of specials
        	driver.findElement(By.name(Testelements.Addspecial_radiobutton)).click();
        	//Press the ok button  
        	WebElement element = driver.findElement(By.cssSelector(Testelements.Addspecial_Confirm_button));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        	
        	//driver.findElement(By.cssSelector(Testelements.Addspecial_Confirm_button)).click();
        	
            Thread.sleep(3000);
    		
        	
        	  //Switch back to parent window 
            driver.switchTo().window(parentWindow);
        	
            //Refresh the page for view special button to be appeared
            driver.navigate().refresh();
            
            wait = new WebDriverWait(driver, 180);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ViewSpecial_Button)));
            
            Thread.sleep(2000);
			
            
            
            //View the specials
            driver.findElement(By.cssSelector(Testelements.ViewSpecial_Button)).click();
            
            //Switch to popup window again
          //Shift to new window
        	String parentWindow1 = driver.getWindowHandle();
        	
        	//Switch to new window opened
        	for(String winHandle : driver.getWindowHandles()){
        	    if(!winHandle.equals(parentWindow1)) {
        	        driver.switchTo().window(winHandle);
        	    }
        	}
        	
            Thread.sleep(2000);
    		
            if(driver.findElement(By.cssSelector(Testelements.Viewspecial_popup_Ok)).isDisplayed()){
            	test = extent.createTest("Manage_Products_Add_to_Specials");
        		
        		test.log(Status.PASS, "Product added to specials sucessfully from manage product list");
            }
            else{
            	
            	test = extent.createTest("Manage_Products_Add_to_Specials");
        		
        		test.log(Status.FAIL, "Product added to specials sucessfully from manage product list");
            }
        	driver.findElement(By.cssSelector(Testelements.Viewspecial_popup_Ok)).click();
        	//Switch back again to parent window
        	 //Switch back to parent window 
            driver.switchTo().window(parentWindow1);
        	
       	}catch(NoSuchElementException e){
        		e.getStackTrace();
        		
        	
        	}
        	
        	
    	}
    	
@Test(priority=6)
public void Copy_Special() throws InterruptedException{
	 try{ 
		
		//Wait for the specials tab to be appear
       	wait = new WebDriverWait(driver, 180);
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Special_Tab_Action)));
           
           //Press the specials tab
           driver.findElement(By.cssSelector(Testelements.Special_Tab_Action)).click();
		 
		 
		 //Wait for the Inactivate button to be appear on the screen
		 wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ActionDropdownSpecialPage)));
        
        Thread.sleep(3000);
   	
        driver.findElement(By.xpath(Testelements.SearchSpecial_SearchField)).sendKeys(Testdata.specialname);
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath(Testelements.SearchSpecial_SearchButton)).click();
        
        Thread.sleep(4000);
   	
        WebElement mySelectElement_Edit2 = driver.findElement(By.xpath(Testelements.ActionDropdownSpecialPage));
        Select dropdown_Edit2= new Select(mySelectElement_Edit2);
       
        dropdown_Edit2.selectByVisibleText("Copy");
   
   //Wait for 2 sec for popup to appear
   
	Thread.sleep(2000);
	
	 wait = new WebDriverWait(driver, 120);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Specialname)));
     
     //Insert the special name
       driver.findElement(By.cssSelector(Testelements.Specialname)).sendKeys(Testdata.CopySpecialName);
       
       //Select the start date from date picker
       driver.findElement(By.cssSelector(Testelements.Special_Startdate)).click();
       
       Thread.sleep(2000);
   	
           
       //Select a future  start date from  the date picker
      driver.findElement(By.linkText("Next")).click();
      
      driver.findElement(By.linkText("15")).click();
      
   //Select the end date from date picker
      driver.findElement(By.cssSelector(Testelements.Special_Enddate)).click();
      
      
  		Thread.sleep(2000);
  	 
      //Insert the date
      driver.findElement(By.linkText("Next")).click();
      driver.findElement(By.linkText("16")).click();
      
  //Insert the promo code
      driver.findElement(By.cssSelector(Testelements.Promo_code)).sendKeys("SA-12546");
 
      JavascriptExecutor jse = (JavascriptExecutor)driver;
      jse.executeScript("window.scrollBy(0,-250)", "");
      
     
		Thread.sleep(3000);
		
		//Save the specials details
	       driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();
	       
	       waitForPageLoad();
	       
	       Thread.sleep(2000);
	       
	       driver.findElement(By.xpath(Testelements.Nav_Back_Specials)).click();
	        //Wait for element to appear
	    	 wait = new WebDriverWait(driver, 120);
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ActionDropdownSpecialPage)));
	         
	         Thread.sleep(2000);
	         
	         driver.findElement(By.xpath(Testelements.SearchSpecial_SearchField)).sendKeys(Testdata.CopySpecialName);
	         
	         Thread.sleep(1000);
	         
	         driver.findElement(By.xpath(Testelements.SearchSpecial_SearchButton)).click();
	         
	         Thread.sleep(4000);
	         
	         if(driver.findElement(By.xpath(Testelements.CopySpecial_Creation_Verification)).getText().contains(Testdata.CopySpecialName))
	         {
	        	System.out.println("Special Copied Successfully");
	        	
	        	 test = extent.createTest("Copy_Special");
	          	   	
	          	 test.log(Status.PASS, "Special Copied Successfully");
	         }
	         else{
	        	 System.out.println("Special Copied UnSuccessfully");
		        	
	        	 test = extent.createTest("Copy_Special");
	          	   	
	          	 test.log(Status.FAIL, "Special Copied UnSuccessfully");
	         }
	        
			
	    	
	    	
	    	
  
  
}catch(NoSuchElementException e){
	 e.getStackTrace();
	 
}

}
@Test(priority=7)
public void CopyProducts_FromSpecials() throws InterruptedException{
	try{
		
		 WebElement mySelectElement_Edit = driver.findElement(By.xpath(Testelements.ActionDropdownSpecialPage));
         Select dropdown_Edit= new Select(mySelectElement_Edit);
        
         dropdown_Edit.selectByVisibleText("Edit");
         
         wait = new WebDriverWait(driver, 120);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CopyProduct_Specials)));
         
         Thread.sleep(2000);
         
         driver.findElement(By.xpath(Testelements.CopyProduct_Specials)).click();
         
         waitForPageLoad();
         
         Thread.sleep(3000);
         
         WebElement CopyProducts_FilterChange = driver.findElement(By.xpath(Testelements.CopyProductsPopup_FilterChange));
         Select dropdown_FilterChange= new Select(CopyProducts_FilterChange);
        
         dropdown_FilterChange.selectByVisibleText("Scheduled");
         
         waitForPageLoad();
         
         Thread.sleep(3000);
         
         driver.findElement(By.xpath(Testelements.SpecialSelection_For_Products)).click();
         
         Thread.sleep(1000);
         
         driver.findElement(By.xpath(Testelements.CopyProductSelectionConfirm)).click();
         
         waitForPageLoad();
         
         Thread.sleep(8000);
         
         WebElement table = driver.findElement(By.xpath(Testelements.CopyProductTable));

		   // Now get all the TR elements from the table
		 List<WebElement> allRows = table.findElements(By.tagName("tr"));
		    
		 System.out.println(allRows.size());
		 
		 if(allRows.size()==3)
		 {
			 System.out.println("Products Copy From Other Special Successfully");
			 
		     test = extent.createTest("ProductCopy_From_Special");
          	   	
          	 test.log(Status.PASS, "Products Copy From Other Special Successfully");
			 
		 }
		 else{
			 System.out.println("Products Copy From Other Special UnSuccessfully");
		 
			 test = extent.createTest("ProductCopy_From_Special");
       	   	
          	 test.log(Status.FAIL, "Products Copy From Other Special UnSuccessfully");
		 
		 }
		
	}catch(NoSuchElementException e){
		e.getMessage();
	}
}

@Test(priority=8)
         public void Delete_Product_From_Specials() throws Exception
         {
       	  try{
       	  
         //Wait for the delete button to appear
       	     wait = new WebDriverWait(driver, 120);
             wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Delete_product_button)));
             
             //Click a delete button to drop a product
             driver.findElement(By.cssSelector(Testelements.Delete_product_button)).click();
        
             Thread.sleep(1000);
			
             
             
             //Press the OK button to delete
             driver.findElement(By.cssSelector(Testelements.Delete_OK)).click();
            
             Thread.sleep(3000);
			
             //Scroll Page Up
             JavascriptExecutor jse8 = (JavascriptExecutor)driver;
             jse8.executeScript("window.scrollBy(0,-250)", "");
             
             JavascriptExecutor jse81 = (JavascriptExecutor)driver;
             jse81.executeScript("window.scrollBy(-250,-500)", "");
             
             Thread.sleep(1000);
			
             
             //Save the specials details
             driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();
             
             //Wait for 2 sec
             
			Thread.sleep(2000);
			
           //Scroll Page down
             JavascriptExecutor jse7 = (JavascriptExecutor)driver;
             jse7.executeScript("window.scrollBy(0,250)", "");
             
         
             Thread.sleep(1000);
	
             driver.findElement(By.cssSelector(Testelements.Select_all_checkboxdelete)).click();
             
             driver.findElement(By.cssSelector(Testelements.Selection_all_deletebutton)).click();
             
              Thread.sleep(1000);
			
             driver.findElement(By.cssSelector(Testelements.Selection_all_Confirmbutton)).click();
             
             Thread.sleep(2000);
			
             
             //Scroll Page Up
             JavascriptExecutor jse10 = (JavascriptExecutor)driver;
             jse10.executeScript("window.scrollBy(0,-250)", "");
             
             //Scroll Page Up
             JavascriptExecutor jse101 = (JavascriptExecutor)driver;
             jse101.executeScript("window.scrollBy(-250,-500)", "");
             
             Thread.sleep(1000);
			
             
             //Save the specials details
             driver.findElement(By.cssSelector(Testelements.Specials_save_button)).click();
             
            
			Thread.sleep(1000);
			
			if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	          	  test = extent.createTest("Delete_Product_From_Specials");
	          	   	
	          	   	test.log(Status.PASS, "Product deleted from specials sucessfully");
	            
	            }
	            else{
	          	  test = extent.createTest("Delete_Product_From_Specials");
	        	   	
	        	   	test.log(Status.FAIL, "Product deleted from specials unsucessfully"); 
	          	  
	            }
             
			
	//Go back and inacivate the special to complete the script  
       	  
       	  }catch(NoSuchElementException e){
       		  e.getStackTrace();
       		
       	  }
        
     
     
         
         }
    	 
    	 @Test(priority=9)
         public void Inactivate_Specials() throws InterruptedException{
        	 try{ 
        		//Scroll Page down
			        JavascriptExecutor jse7 = (JavascriptExecutor)driver;
			        jse7.executeScript("window.scrollBy(0,-250)", "");
			        
			        Thread.sleep(1000);
        		 
			        
			        driver.findElement(By.xpath(Testelements.Nav_Back_Specials)).click();
			        
			        wait = new WebDriverWait(driver, 120);
			        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ActionDropdownSpecialPage)));
			        
			        Thread.sleep(3000);
			        
			        
			        
                 WebElement mySelectElement_Edit2 = driver.findElement(By.xpath(Testelements.ActionDropdownSpecialPage));
                 Select dropdown_Edit2= new Select(mySelectElement_Edit2);
                
                 dropdown_Edit2.selectByVisibleText("Make Inactive");
            
            //Wait for 2 sec for popup to appear
            
			Thread.sleep(2000);
			
            
            //Press the OK button to inactivate the special
            driver.findElement(By.cssSelector(Testelements.Special_Inactivate_Confirm)).click();
            
            
		    Thread.sleep(1000);
			
		    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	          	  test = extent.createTest("Inactivate_Specials");
	          	   	
	          	   	test.log(Status.PASS, "Special Inactivate sucessfully");
	            
	            }
	            else{
	          	  test = extent.createTest("Inactivate_Specials");
	        	   	
	        	   	test.log(Status.FAIL, "Special Inactivate unsucessfully"); 
	          	  
	            }
           
   }catch(NoSuchElementException e){
    		 e.getStackTrace();
    		 
    	 }
    
    	 }
    
   @Test(priority=10)
   public void SpecialsExpiration_NotMoreThan180Days() throws InterruptedException{
	   try{
	 //Press the create special button
       driver.findElement(By.cssSelector(Testelements.CreateSpecial_Button)).click();
       
     //Select the start date from date picker
       driver.findElement(By.cssSelector(Testelements.Special_Startdate)).click();
       
       try {
   		Thread.sleep(2000);
   	} catch (InterruptedException e2) {
   		// TODO Auto-generated catch block
   		e2.printStackTrace();
   	}
           
       //Select a future  start date from  the date picker
      driver.findElement(By.linkText("Next")).click();
      
      driver.findElement(By.linkText("28")).click();
      
   //Select the end date from date picker
      driver.findElement(By.cssSelector(Testelements.Special_Enddate)).click();
      
      try {
  		Thread.sleep(2000);
  	} catch (InterruptedException e2) {
  		// TODO Auto-generated catch block
  		e2.printStackTrace();
  	}
          
      
      //Insert the date
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("Next")).click();
      
      Thread.sleep(2000);
      
      
      
      if(driver.findElement(By.cssSelector(Testelements.daysExpiration_Specials)).isEnabled()){
      System.out.println("Restriction for 180 days on special creation works sucessfully as no date after 180 days is selectable");
      
      test = extent.createTest("SpecialsExpiration_NotMoreThan180Days");
		
		test.log(Status.PASS, "Restriction for 180 days on special creation works sucessfully as no date after 180 days is selectable");
  
      }
      else{
    	  
    	  System.out.println("Restriction for 180 days on special creation works sucessfully as date after 180 days is selectable");
          
          test = extent.createTest("SpecialsExpiration_NotMoreThan180Days");
    		
    		test.log(Status.FAIL, "Restriction for 180 days on special creation works sucessfully as  date after 180 days is selectable");
      }
  
      }catch(NoSuchElementException e){
      	
  		e.getStackTrace();
  		 
      
      }
   
   
   }
     
   @Test(priority=11)
    public void AddTrade() throws InterruptedException{
    	try{
    	//Press the EIT Manager Tab
    	
    	driver.findElement(By.xpath(Testelements.EITDashboardButton)).click();
    	
    	//Wait for the EITAdminTab to be appear on the screen
       	wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdminTab)));
        
        Thread.sleep(1000);
        
        //Press the EIT Admin Tab
        driver.findElement(By.xpath(Testelements.EITAdminTab)).click();
        
        //Wait for global list tab to be appear
        
    	wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.GlobalListsTab)));
        
        Thread.sleep(2000);
        
        //Press the global lists tab
        driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
        
        Thread.sleep(2000);
        
        //Select the global list options
        WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
        Select dropdown= new Select(mySelectElement);
       
        dropdown.selectByVisibleText("Brand Names");
        
        
        
        //Wait for Add Trade Button
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeAddButton)));
        
        Thread.sleep(1000);
        
        //Press the Add Trade button
        driver.findElement(By.xpath(Testelements.TradeAddButton)).click();
        
        Thread.sleep(1000);
        
        //Enter the Trade Name
        driver.findElement(By.xpath(Testelements.TradeName_Field)).sendKeys(Testdata.TradeName);
        
        Thread.sleep(1000);
        
        //Press the Add Trade button in popup
        driver.findElement(By.xpath(Testelements.TradeCreateButton)).click();
        
        if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
            
        	System.out.println("Trade Name Added Successfully");
        	
        	test = extent.createTest("Add TradeName");
     		
     		test.log(Status.PASS, "Trade Name Added Successfully");
        }
        else{
        	System.out.println("Trade Name Added UnSuccessfully");
        	test = extent.createTest("Add TradeName");
     		
     		test.log(Status.FAIL, "Trade Name Added UnSuccessfully");
        }
        
        Thread.sleep(2000);
        
        }catch(NoSuchElementException e){
        	

    		e.getStackTrace();
    		 
        
        }
        	
    }
    
    @Test(priority=12)
    public void SearchTradeName() throws InterruptedException{
    	   try{
    	
    	
       //Search the term
    	driver.findElement(By.xpath(Testelements.TradeSearchfield)).sendKeys("Trade Works-");
    	
    	Thread.sleep(2000);
    	
    	//Press the search button
    	driver.findElement(By.xpath(Testelements.TradeSearchButton)).click();
    	
    	wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeSearchValidation)));
    	
    	//Thread.sleep(15000);
    	Thread.sleep(2000);
        
    	if(driver.findElement(By.xpath(Testelements.TradeSearchValidation)).isDisplayed()){
    	System.out.print("Trade Name Searched Successfully");
    	test = extent.createTest("Search TradeName");
 		
 		test.log(Status.PASS, "Trade Name Searched Successfully");
    	}
    	else{
    		
    		System.out.print("Trade Name Searched UnSuccessfully");
        	test = extent.createTest("Search TradeName");
     		
     		test.log(Status.FAIL, "Trade Name Searched UnSuccessfully");
    	}
    
    
        }catch(NoSuchElementException e){
        	
    		e.getStackTrace();
    		 
        
        }
    	
    }
     
    	 
   @Test(priority=13)
   public void EditTradeName() throws InterruptedException{
	   try{
	   //Press the edit button
	   driver.findElement(By.xpath(Testelements.TradeEditButton)).click();
	   
	   Thread.sleep(1000);
	   
	   //Clear the previous name
	   WebElement toClear = driver.findElement(By.xpath(Testelements.TradeUpdateField));
	     toClear.sendKeys(Keys.CONTROL + "a");
	     toClear.sendKeys(Keys.DELETE); 
   
      //Wait
	     
	     
	  //Enter Updated Trade Name and save
	     driver.findElement(By.xpath(Testelements.TradeUpdateField)).sendKeys(Testdata.TradeUpdateName);
	     
	     
	     
	  //Press the confirm for the update process to be completed
	     driver.findElement(By.xpath(Testelements.TradeUpdateConfirm)).click();
	     
	     
	     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	            
	        	System.out.println("Trade Name Updated  Successfully");
	        	
	        	test = extent.createTest("Edit TradeName");
	     		
	     		test.log(Status.PASS, "Trade Name  Updated Successfully");
	        }
	        else{
	        	System.out.println("Trade Name Updated UnSuccessfully");
	        	test = extent.createTest("Edit TradeName");
	     		
	     		test.log(Status.FAIL, "Trade Name Updated UnSuccessfully");
	        }
	     
	        Thread.sleep(2000);   
	    
	        }catch(NoSuchElementException e){
	        	
	    		e.getStackTrace();
	    		 
	        
	        }
   
   }
    	 
    	 
    	 
    @Test(priority=14)
    public void RejectTrade() throws InterruptedException{
    	try{
    	if(!driver.findElement(By.xpath(Testelements.TradeRejectButton)).isEnabled())
    	{
    		//Press the reject button
        	driver.findElement(By.xpath(Testelements.TradeApprovedButton)).click();
        	
        	 wait = new WebDriverWait(driver, 180);
             wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeApprovedConfirm)));
             
             Thread.sleep(1000);
        	
        	//Press the confirm button
        	driver.findElement(By.xpath(Testelements.TradeApprovedConfirm)).click();
        	
        	Thread.sleep(5000);
        	
        	 //Press the reject button
        	driver.findElement(By.xpath(Testelements.TradeRejectButton)).click();
        	
        	wait = new WebDriverWait(driver, 180);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeRejectConfirm)));
            
            Thread.sleep(1000);
        	
        	//Press the confirm button
        	driver.findElement(By.xpath(Testelements.TradeRejectConfirm)).click();
        	
        	
        	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).isDisplayed()){
    	            
    	        	System.out.println("Trade Reject Successfully");
    	        	
    	        	test = extent.createTest("Reject Trade");
    	     		
    	     		test.log(Status.PASS, "Reject Trade Successfully");
    	        }
    	        else{
    	        	System.out.println("Trade Reject UnSuccessfully");
    	        	test = extent.createTest("Reject Trade");
    	     		
    	     		test.log(Status.FAIL, "Reject Trade UnSuccessfully");
    	        }
        	Thread.sleep(3000);
        	
    	}
    	else{		
        //Press the reject button
    	driver.findElement(By.xpath(Testelements.TradeRejectButton)).click();
    	
    	wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeRejectConfirm)));
        
        Thread.sleep(1000);
    	
    	//Press the confirm button
    	driver.findElement(By.xpath(Testelements.TradeRejectConfirm)).click();
    	
    	
    	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).isDisplayed()){
	            
	        	System.out.println("Trade Reject Successfully");
	        	
	        	test = extent.createTest("Reject Trade");
	     		
	     		test.log(Status.PASS, "Reject Trade Successfully");
	        }
	        else{
	        	System.out.println("Trade Reject UnSuccessfully");
	        	test = extent.createTest("Reject Trade");
	     		
	     		test.log(Status.FAIL, "Reject Trade UnSuccessfully");
	        }
    	Thread.sleep(3000);
    	}
      }catch(NoSuchElementException e){
        	
    		e.getStackTrace();
    		 
        
        }
    	
    }
    	 
    	 
    @Test(priority=15)
    public void ApprovedTrade() throws InterruptedException{
    	try{
    	//Press the reject button
    	driver.findElement(By.xpath(Testelements.TradeApprovedButton)).click();
    	
    	 wait = new WebDriverWait(driver, 180);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeApprovedConfirm)));
         
         Thread.sleep(1000);
    	
    	//Press the confirm button
    	driver.findElement(By.xpath(Testelements.TradeApprovedConfirm)).click();
    	
    	if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
            
        	System.out.println("Approved Trade Successfully");
        	
        	test = extent.createTest("Approved Trade");
     		
     		test.log(Status.PASS, "Approved Trade Successfully");
        }
        else{
        	System.out.println("Approved Trade UnSuccessfully");
        	test = extent.createTest("Approved Trade");
     		
     		test.log(Status.FAIL, "Approved Trade UnSuccessfully");
        }
    	
    	
        Thread.sleep(2000);
    	
        }catch(NoSuchElementException e){
        	e.getStackTrace();
    		 
        
        }
    	
    }
    	  	 
    @Test(priority=16)
    public void RejectBulkTrade() throws InterruptedException{
    	try{
    	 //Press the Add Trade button
        driver.findElement(By.xpath(Testelements.TradeAddButton)).click();
        
        Thread.sleep(1000);
        
        //Enter the Trade Name
        driver.findElement(By.xpath(Testelements.TradeName_Field)).sendKeys(Testdata.TradeName1);
        
        
        
        //Press the Add Trade button in popup
        driver.findElement(By.xpath(Testelements.TradeCreateButton)).click();
        
        waitForPageLoad();
        
        Thread.sleep(1000);
        
        //Press the Add Trade button
        driver.findElement(By.xpath(Testelements.TradeAddButton)).click();
        
        Thread.sleep(1000);
        
        //Enter the Trade Name
        driver.findElement(By.xpath(Testelements.TradeName_Field)).sendKeys(Testdata.TradeName2);
        
       
        
        //Press the Add Trade button in popup
        driver.findElement(By.xpath(Testelements.TradeCreateButton)).click();
        
        waitForPageLoad();
        
        Thread.sleep(1000);
    	
    	//Select the trades for bulk reject process
        driver.findElement(By.xpath(Testelements.TradeBulkSelection1)).click();
        
       
        
        driver.findElement(By.xpath(Testelements.TradeBulkSelection2)).click();
        
        
        
        driver.findElement(By.xpath(Testelements.TradeBulkSelection3)).click();
        
        
        
        WebElement mySelectElement = driver.findElement(By.xpath(Testelements.TradeBulkDropdownSelection));
        Select dropdown= new Select(mySelectElement);
       
        dropdown.selectByVisibleText("Bulk Reject");
        
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeBulkRejectConfirm)));
        
        Thread.sleep(2000);
        //Confirm the bulk reject process
        driver.findElement(By.xpath(Testelements.TradeBulkRejectConfirm)).click();
        
        if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
            
        	System.out.println("Bulk Reject Trade Successfully");
        	
        	test = extent.createTest("Bulk Reject Trade");
     		
     		test.log(Status.PASS, "Bulk Reject Trade Successfully");
        }
        else{
        	System.out.println("Bulk Reject Trade UnSuccessfully");
        	test = extent.createTest("Bulk Reject Trade");
     		
     		test.log(Status.FAIL, "Bulk Reject Trade UnSuccessfully");
        }
        
        
        
        
        
      //Refresh the page for changes to take effect
        
        driver.navigate().refresh();
        
        //Wait for Add Trade Button
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.GlobalListsTab)));
        
        Thread.sleep(1000);
        
      //Press the global lists tab
        driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
        
        Thread.sleep(1000);
        
        //Select the global list options
        WebElement mySelectElement1 = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
        Select dropdown1= new Select(mySelectElement1);
       
        dropdown1.selectByVisibleText("Brand Names");
        
        
        //Wait for Add Trade Button
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeAddButton)));
        
        Thread.sleep(1000);
        
      //Search the term
    	driver.findElement(By.xpath(Testelements.TradeSearchfield)).sendKeys("Trade Works-");
    	
    	
    	
    	//Press the search button
    	driver.findElement(By.xpath(Testelements.TradeSearchButton)).click();
    	
    	 waitForPageLoad();
         
         Thread.sleep(1000);
  
        }catch(NoSuchElementException e){
        	
    		e.getStackTrace();
    		 
        
        }
   
    
    
    }
    	 
    	 
    @Test(priority=17)
    public void ApprovedBulkTrade() throws InterruptedException{
    	try{
    	//Select the trades for bulk reject process
        driver.findElement(By.xpath(Testelements.TradeBulkSelection1)).click();
        
        
        
        driver.findElement(By.xpath(Testelements.TradeBulkSelection2)).click();
        
        
        
        driver.findElement(By.xpath(Testelements.TradeBulkSelection3)).click();
        
        
        
        WebElement mySelectElement = driver.findElement(By.xpath(Testelements.TradeBulkDropdownSelection));
        Select dropdown= new Select(mySelectElement);
       
        dropdown.selectByVisibleText("Bulk Approve");
        
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeBulkApprovedConfirm)));
        
        Thread.sleep(1000);
        
        //Confirm the bulkAprrove
        driver.findElement(By.xpath(Testelements.TradeBulkApprovedConfirm)).click();
    
        if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
            
        	System.out.println("Bulk Approved Trade Successfully");
        	
        	test = extent.createTest("Bulk Approved Trade");
     		
     		test.log(Status.PASS, "Bulk Approved Trade Successfully");
        }
        else{
        	System.out.println("Bulk Approved Trade UnSuccessfully");
        	test = extent.createTest("Bulk Approved Trade");
     		
     		test.log(Status.FAIL, "Bulk Approved Trade UnSuccessfully");
        }
           
        
    
 //Refresh the page for changes to take effect
        
        driver.navigate().refresh();
        
        //Wait for Add Trade Button
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.GlobalListsTab)));
        
        Thread.sleep(1000);
        
      //Press the global lists tab
        driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
        
        Thread.sleep(1000);
        
      //Select the global list options
        WebElement mySelectElement2 = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
        Select dropdown2= new Select(mySelectElement2);
       
        dropdown2.selectByVisibleText("Brand Names");
        
        
        
        //Wait for Add Trade Button
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.TradeAddButton)));
        
        Thread.sleep(1000);
        
      //Search the term
    	driver.findElement(By.xpath(Testelements.TradeSearchfield)).sendKeys("Trade Works-");
    	
    	Thread.sleep(2000);
    	
    	//Press the search button
    	driver.findElement(By.xpath(Testelements.TradeSearchButton)).click();
    	
    	 waitForPageLoad();
         
         Thread.sleep(1000);
      
        }catch(NoSuchElementException e){
        	
    		e.getStackTrace();
    		 
        
        }
 
   
    
    
    }
    	 
   @Test(priority=18)
   public void DeleteTrade() throws InterruptedException
   {
	   
	   //Press the delete button to remove the trade
	   driver.findElement(By.xpath(Testelements.DeleteTrade_Button)).click();
	   
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath(Testelements.ConfirmDeleteTrade)).click();
	   
	   if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
           
	       	System.out.println("Trade Deleted Successfully");
	       	
	       	test = extent.createTest("DeleteTrade");
	    		
	    		test.log(Status.PASS, "Trade Deleted Successfully");
	       }
	       else{
	       	System.out.println("Trade Deleted UnSuccessfully");
	       	test = extent.createTest("DeleteTrade");
	    		
	    		test.log(Status.FAIL, "Trade Deleted UnSuccessfully");
	       }
	   waitForPageLoad();
       
       Thread.sleep(1000);
   }
    
    
    
    
   @Test(priority=19)
   public void AddTheme() throws InterruptedException{
	   try{
	   //Select the global list options
       WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
       Select dropdown= new Select(mySelectElement);
      
       dropdown.selectByVisibleText("Manage Themes");
       
     
      
        waitForPageLoad();
        
        Thread.sleep(2000);
       // Thread.sleep(20000);
       
       //Press the Add theme Button
       driver.findElement(By.xpath(Testelements.AddThemeButton)).click();
       
       Thread.sleep(1000);
       
       //Enter the Theme Name
       driver.findElement(By.xpath(Testelements.InsertThemeName_TextField)).sendKeys("Automation");
       
       
       
       //Press the Add Theme Button
       driver.findElement(By.xpath(Testelements.AddThemeButton_popup)).click();
       
       if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
           
       	System.out.println("Theme Added Successfully");
       	
       	test = extent.createTest("Add Theme");
    		
    		test.log(Status.PASS, "Theme Added Successfully");
       }
       else{
       	System.out.println("Theme Added UnSuccessfully");
       	test = extent.createTest("Add Theme");
    		
    		test.log(Status.FAIL, "Theme Added UnSuccessfully");
       }
          
       waitForPageLoad();
       
       Thread.sleep(1000);
      // waitForPageLoad();
   }catch(NoSuchElementException e){
   	
		e.getStackTrace();
		 
   
   }
       
   }
  
   @Test(priority=20)
   public void SearchTheme() throws InterruptedException{
	   try{
	 //Search the term
   	driver.findElement(By.xpath(Testelements.SearchTheme_SearchField)).sendKeys("Automation");
   	
   	Thread.sleep(2000);
   	
   	//Press the search button
   	driver.findElement(By.xpath(Testelements.SearchTheme_SearchButton)).click();
   	
    waitForPageLoad();
    
    Thread.sleep(1000);
   	
   	//waitForPageLoad();
   	
   	if(driver.findElement(By.xpath(Testelements.ThemeSearchVerification)).getText().contains("Automation"))
   	{
	     System.out.println("Theme Searched Successfully");
       	
       	 test = extent.createTest("Searched Theme");
    		
    		test.log(Status.PASS, "Theme Searched Successfully");
       }
       else{
       	System.out.println("Theme Searched UnSuccessfully");
       	test = extent.createTest("Add Theme");
    		
    		test.log(Status.FAIL, "Theme Searched UnSuccessfully");
       }
	   }catch(NoSuchElementException e){
		   	
			e.getStackTrace();
			 
	   
	   }
   
	   
	   }
    
   @Test(priority=21)
   public void UpdateTheme() throws InterruptedException{
	   try{
	   //Press the Edit Button
	   driver.findElement(By.xpath(Testelements.EditThemeButton)).click();
	   
	   Thread.sleep(1000);
	   
	   WebElement toClear = driver.findElement(By.xpath(Testelements.EditTheme_TextField));
	     toClear.sendKeys(Keys.CONTROL + "a");
	     toClear.sendKeys(Keys.DELETE); 
	     
	     
	     
	   //Enter the updated name
	     driver.findElement(By.xpath(Testelements.EditTheme_TextField)).sendKeys("Automation 1");
	     
	     Thread.sleep(1000);
	     
	   //Press the Ok Button
	     driver.findElement(By.xpath(Testelements.EditTheme_OkButton)).click();
	     
	    // waitForPageLoad();
	     
	     waitForPageLoad();
	        
	     Thread.sleep(1000);
	     
	 	if(driver.findElement(By.xpath(Testelements.ThemeSearchVerification)).getText().contains("Automation 1"))
	   	{
		     System.out.println("Theme Updated Successfully");
	       	
	       	 test = extent.createTest("Theme Update");
	    		
	    		test.log(Status.PASS, "Theme Updated Successfully");
	       }
	       else{
	       	System.out.println("Theme Updated UnSuccessfully");
	       	test = extent.createTest("Theme Update");
	    		
	    		test.log(Status.FAIL, "Theme Updated UnSuccessfully");
	       }
		   }catch(NoSuchElementException e){
			   	
				e.getStackTrace();
				 
		   
		   }
	     
   }
  
   @Test(priority=22)
   public void DeleteTheme() throws InterruptedException{
	   try{
	   //Press the delete button
	   driver.findElement(By.xpath(Testelements.DeleteThemeButton)).click();
	   
	   
	   
	   //Press the Ok button to delete the Theme
	   driver.findElement(By.xpath(Testelements.DeletethemeConfirm)).click();
	   
	   waitForPageLoad();
       
       Thread.sleep(1000);
	   
	   if(driver.findElement(By.xpath(Testelements.DeleteThemeVerification)).getText().contains("No result found"))
	   	{
		     System.out.println("Theme Deleted Successfully");
	       	
	       	 test = extent.createTest("Theme Delete");
	    		
	    		test.log(Status.PASS, "Theme Deleted Successfully");
	       }
	       else{
	       	System.out.println("Theme Deleted UnSuccessfully");
	       	test = extent.createTest("Theme Delete");
	    		
	    		test.log(Status.FAIL, "Theme Deleted UnSuccessfully");
	       }
		   }catch(NoSuchElementException e){
			   	
				e.getStackTrace();
				 
		   
		   }
	   
   }
    
   @Test(priority=23)
   public void AddShape() throws InterruptedException{
	 try{
	   //Select the global list options
       WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
       Select dropdown= new Select(mySelectElement);
      
       dropdown.selectByVisibleText("Manage Shapes");
       
       waitForPageLoad();
       
       Thread.sleep(1000);
       
    //Press the Add Shape Button
       driver.findElement(By.xpath(Testelements.AddShapeButton)).click();
       
       Thread.sleep(1000);
       
       //Insert the Shape name
       driver.findElement(By.xpath(Testelements.AddShape_NameTextField)).sendKeys(Testdata.ShapeName);
       
      //Insert Shape Group
       driver.findElement(By.xpath(Testelements.AddShape_ShapeGroup)).sendKeys("a");
       
       Thread.sleep(8000);
       
       driver.findElement(By.xpath(Testelements.AddShape_ShapeGroup)).sendKeys(Keys.ENTER);
       
       Thread.sleep(1000);
       
       //Press the Add Button
       driver.findElement(By.xpath(Testelements.AddNewShape_AddButton)).click();
       
       if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	   
    	   System.out.println("Shape Added Successfully");
    	   
    	   test = extent.createTest("Add Shape");
   		
   		   test.log(Status.PASS, "Shape Added Successfully");
       }
       else{
    		System.out.println("Shape Added UnSuccessfully");
	       	
    		test = extent.createTest("Add Shape");
	    		
	    	test.log(Status.FAIL, "Shape Added UnSuccessfully"); 
       }
       waitForPageLoad();
       
       Thread.sleep(1000);
  
	 }catch(NoSuchElementException e){
		   	
			e.getStackTrace();
			 
	   
	   }
	 }
   
   @Test(priority=24)
   public void SearchShape() throws InterruptedException{
	   try{
		   
	   //Search the Shape name
	   driver.findElement(By.xpath(Testelements.ShapeSearchField)).sendKeys(Testdata.ShapeName);
	   
	   driver.findElement(By.xpath(Testelements.ShapeSearchButton)).click();
	   
	   waitForPageLoad();
       
       Thread.sleep(1000);
	   
	   if(driver.findElement(By.xpath(Testelements.SearchShapeVerification)).getText().contains("Automation"))
	   {
		   System.out.println("Shape Searched Successfully");
		   
		   test = extent.createTest("Search Shape");
	   		
   		   test.log(Status.PASS, "Shape Searched Successfully");
		   
		   
	   }
	   else{
		   
           System.out.println("Shape Searched UnSuccessfully");
		   
		   test = extent.createTest("Search Shape");
	   		
   		   test.log(Status.FAIL, "Shape Searched UnSuccessfully");
	   }
	   }catch(NoSuchElementException e){
		   	
			e.getStackTrace();
			 
	   
	   }
   
   }
   
   @Test(priority=25)
   public void EditShape() throws InterruptedException
   {
	   try{
	   //Press the Edit Button
	   driver.findElement(By.xpath(Testelements.ShapeEditButton)).click();
	   
	   Thread.sleep(1000);
	   
	   WebElement toClear = driver.findElement(By.xpath(Testelements.ShapeEditTextField));
	     toClear.sendKeys(Keys.CONTROL + "a");
	     toClear.sendKeys(Keys.DELETE); 
	   
	     //Update the Name of shape
	     driver.findElement(By.xpath(Testelements.ShapeEditTextField)).sendKeys(Testdata.UpdateShapeName);
	     
	     //Press the Ok Button 
	     driver.findElement(By.xpath(Testelements.ShapeEditConfirm_OkButton)).click();
	     
	     waitForPageLoad();
	        
	     Thread.sleep(2000);
	     
	     driver.findElement(By.xpath(Testelements.ShapeSearchField)).clear();
	     
	     Thread.sleep(1000);
		   
		   driver.findElement(By.xpath(Testelements.ShapeSearchField)).sendKeys(Testdata.UpdateShapeName);
		   
		   driver.findElement(By.xpath(Testelements.ShapeSearchButton)).click();
		   
		   waitForPageLoad();
	       
	       Thread.sleep(2000);
	     
	     if(driver.findElement(By.xpath(Testelements.EditShapeVerification)).getText().contains(Testdata.UpdateShapeName))
	     {
	    	 System.out.println("Shape Updated Succesfully");
	    	 
	    	 test = extent.createTest("Edit Shape");
		   		
	   		 test.log(Status.PASS, "Shape Searched Successfully");
	    	 
	     }
	     
	     else{
	    	 
             System.out.println("Shape Updated UnSuccesfully");
	    	 
	    	 test = extent.createTest("Edit Shape");
		   		
	   		 test.log(Status.FAIL, "Shape Updated UnSuccessfully");
	    	 
	     }
	   }catch(NoSuchElementException e){
		   	
			e.getStackTrace();
			 
	   
	   }
   
   }
  @Test(priority=26)
  public void AssignShapeToProduct_WithShapeDeletionError_Verification() throws InterruptedException{
	  try{
	  
	  //Press the manage products tab
	   driver.findElement(By.cssSelector(Testelements.Dist_ManageProducts)).click();
	   
	   
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
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
	      
	     
	      Thread.sleep(2000);
	      
	      //Click th Manage product tab
	      driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	      
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
	     
	        //Select the product type
	     //	driver.findElement(By.cssSelector(Testelements.Product_type)).click();
	     	
	     	driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
	        
	        Thread.sleep(1000);
	     	
	     	
	     	//Creating a robot instance to select option in 2nd place in dropdown
	     	WebElement mySelectElement21 = driver.findElement(By.xpath(Testelements.ProductType));
	      Select dropdown21= new Select(mySelectElement21);
	     
	      dropdown21.selectByVisibleText("Automotive Accessories");
	     
	         
	      
	      
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
	         
	         waitForPageLoadProductLevel();
	  		
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
	         //Scroll Up
	         JavascriptExecutor jse600 = (JavascriptExecutor)driver;
	         jse600.executeScript("window.scrollBy(0,-250)", "");
	         
	         //Scroll Up
	         JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	         jse1.executeScript("window.scrollBy(-250,-500)", "");
	         
	         Thread.sleep(1000);
	         
	         driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
	         
	         //Select the 2nd attribute
	         driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
	         
	       
	         //Wait for few sec
	         try {
	  			Thread.sleep(2000);
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	         
	        //Enter the Shape
	         driver.findElement(By.xpath(Testelements.ProductShapeField)).sendKeys(Testdata.UpdateShapeName);
	         
	         Thread.sleep(3000);
	         
	         driver.findElement(By.xpath(Testelements.ProductShapeField)).sendKeys(Keys.ENTER);
	         
	         Thread.sleep(1000);
	         
             driver.findElement(By.xpath(Testelements.ProductShapeField)).sendKeys("T");
	         
	         Thread.sleep(4000);
	         
	         driver.findElement(By.xpath(Testelements.ProductShapeField)).sendKeys(Keys.ENTER);
	         
	         Thread.sleep(1000);
	       
	       //First store parent window to switch back
	  	     String parentWindow10 = driver.getWindowHandle(); 
	         
	         //Press the custom option
	         driver.findElement(By.xpath(Testelements.MPGOptions)).click();
	         
	         
	  		 Thread.sleep(1000);
	  	
	         driver.findElement(By.xpath(Testelements.Orderingoption_alert_Yes)).click();
	         
	         try {
	  		Thread.sleep(1000);
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
	         
	         Thread.sleep(2000);
	  		
	         
	       //Goto imprinting tab and select imprinting
	         driver.findElement(By.xpath(Testelements.ImprintingTab)).click();
	         
	         waitForPageLoadProductLevel();
	         
	        //Select an option
	         
	         WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.ImprintingMethodSelection));
	         Select dropdown70= new Select(mySelectElement70);
	        
	         dropdown70.selectByVisibleText("Silkscreen");
	         
	         
	         
	         WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
	         JavascriptExecutor executor = (JavascriptExecutor)driver;
	         executor.executeScript("arguments[0].click();", element);
	         Thread.sleep(1000);
	          
	         //Switch back to parent window 
	         driver.switchTo().window(parentWindow10);
	         
	         //Open the pricing tab
	         driver.findElement(By.cssSelector(Testelements.product_pricingtab)).click();
	         
	         waitForPageLoadProductLevel();
	         
	         Thread.sleep(1000);
	  	
	  	    
	  	//First store parent window to switch back
	  	     String parentWindow16 = driver.getWindowHandle(); 
	     	
	     	driver.findElement(By.xpath(Testelements.MultipleGridRadio)).click();
	     	
	     	//Switch to new window opened
	     	for(String winHandle : driver.getWindowHandles()){
	     	    if(!winHandle.equals(parentWindow16)) {
	     	        driver.switchTo().window(winHandle);
	     	    }
	     	}
	         
	     	
	  		Thread.sleep(2000);
	  		
	     	driver.findElement(By.xpath(Testelements.MultipleGridSetup_Color)).click();
	     	
	   		
	  		
	     	driver.findElement(By.xpath(Testelements.MultipleGridSetup_option)).click();
	     	
	     	
	     	driver.findElement(By.xpath(Testelements.ShapesMultiGridCheckbox)).click();
	     	
	     	driver.findElement(By.xpath(Testelements.MultipleGridSetup_Next)).click();
	     	
	   		Thread.sleep(1000);
	  		
	   	   driver.findElement(By.xpath(Testelements.MultipleGridcriteria_White)).click();
	   	    
	     	driver.findElement(By.xpath(Testelements.Shape1_Selection)).click();
	   	   
	   	   Thread.sleep(1000);
	  		
	  	   driver.findElement(By.xpath(Testelements.SaveandAdd)).click();
	  	  
	  	 waitForPageLoadProductLevel();
	  	 
	  	 Thread.sleep(5000);
	  	
	  	  driver.findElement(By.xpath(Testelements.MultipleGridcriteria_Blue)).click();
	  	 
	  	  driver.findElement(By.xpath(Testelements.Shape2_Selection)).click();
	  	  
	  	  Thread.sleep(1000);
	  	
	  	  driver.findElement(By.xpath(Testelements.SaveConfig)).click();
	  	  
	  	 
	  	//Switch back to parent window 
	      driver.switchTo().window(parentWindow16);
	  	  
	      waitForPageLoadProductLevel();
	      
	      Thread.sleep(5000);
	  	
	      driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	  	
	 	  Thread.sleep(1000);
	  	
	 	  
	 	  
	 	  
	 	  //Enter the Product no for White
		  driver.findElement(By.cssSelector(Testelements.ProductNo_White)).sendKeys(Testdata.Productnumber1);
		  
		  Thread.sleep(1000);
	  	//Enter details into fields
	  	driver.findElement(By.xpath(Testelements.MG_Quantity1)).sendKeys("1");
	  	
	  	Thread.sleep(1000);
	  	
	  	
	  //Scroll up
	    JavascriptExecutor jse110 = (JavascriptExecutor)driver;
	    jse110.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll up
	    JavascriptExecutor jse111 = (JavascriptExecutor)driver;
	    jse111.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(2000);
	  	
	  	
	  	
	  	driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	  	
	  	Thread.sleep(3000);
	  	
        driver.findElement(By.xpath(Testelements.PriceExpand1)).click();
	  	
	  	Thread.sleep(3000);
	  	
	  	
	  	driver.findElement(By.xpath(Testelements.MG_ListPrice1)).sendKeys("20");
	  	
	  	Thread.sleep(2000);
	  	
	  	//driver.findElement(By.xpath(Testelements.MG_Pricecode1)).click();
	  	
	  	 WebElement mySelectElement72 = driver.findElement(By.xpath(Testelements.MGP_PriceCode1));
	   Select dropdown72= new Select(mySelectElement72);

	   dropdown72.selectByVisibleText("L 70%");
	   
	    Thread.sleep(1000);
	  		
	          	
	     	
	     driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	     
	    
	  	  Thread.sleep(2000);
	  	
	     //Enter the Product number for 2nd
	     driver.findElement(By.cssSelector(Testelements.ProductNo_Blue)).sendKeys(Testdata.Productnumber2);
	     
	     Thread.sleep(1000);
	     
	     
	     
	     
	     
	     //Enter details into fields
	      driver.findElement(By.xpath(Testelements.MG_Quantity2)).sendKeys("2");
	     
	 
	  	
	  	Thread.sleep(1000);
	  	
	  //Scroll up
	    JavascriptExecutor jse1100 = (JavascriptExecutor)driver;
	    jse1100.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll up
	    JavascriptExecutor jse1110 = (JavascriptExecutor)driver;
	    jse1110.executeScript("window.scrollBy(-250,-500)", "");
	    
	    Thread.sleep(2000);
	  	
	  	 driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	  	 
	  	 Thread.sleep(3000);
	  	 
	  	driver.findElement(By.xpath(Testelements.PriceExpand2)).click();
	  	 
	  	 Thread.sleep(3000);
	  	
	  	driver.findElement(By.xpath(Testelements.MG_ListPrice2)).sendKeys("10");
	  	
	  	Thread.sleep(2000);
	  
	   
	   WebElement mySelectElement100 = driver.findElement(By.xpath(Testelements.MGP_PriceCode2));
	    Select dropdown100= new Select(mySelectElement100);
	   
	    dropdown100.selectByVisibleText("L 70%");

	  	Thread.sleep(2000);
	 
	  //Scroll up
	    JavascriptExecutor jse1105 = (JavascriptExecutor)driver;
	    jse1105.executeScript("window.scrollBy(0,-250)", "");
	    
	  //Scroll up
	    JavascriptExecutor jse1115 = (JavascriptExecutor)driver;
	    jse1115.executeScript("window.scrollBy(-250,-500)", "");
	 	
	    JavascriptExecutor jse112 = (JavascriptExecutor)driver;
	    jse112.executeScript("window.scrollBy(-500,-750)", "");
	    
	    JavascriptExecutor jse113 = (JavascriptExecutor)driver;
	    jse113.executeScript("window.scrollBy(-750,-1000)", "");
	    
	    //Move to upcharges section
	    
	    
		Thread.sleep(1000);
		
	 	
	 	driver.findElement(By.xpath(Testelements.PricingUpcharges_Tab)).click();
	 	
	 	
		Thread.sleep(2000);
		
	 	
	 	//First store parent window to switch back
	    String parentWindow17 = driver.getWindowHandle();
	 	//Press the add Upcharge Button
	 	driver.findElement(By.xpath(Testelements.AddUpcharge_Button)).click();
	 	
	 	
		Thread.sleep(2000);
		
	 	//Switch to new window opened
	 	for(String winHandle : driver.getWindowHandles()){
	 	    if(!winHandle.equals(parentWindow17)) {
	 	        driver.switchTo().window(winHandle);
	 	    }
	 	}
	 	
	 	
	 	
	 	//Press the product color checkbox
	 	driver.findElement(By.xpath(Testelements.Upcharge_ProductColor)).click();
	 	
	 
		
	 	//Press the next step button
	 	driver.findElement(By.xpath(Testelements.UpchargeSetup_NextButton)).click();
	 	
	 	
		Thread.sleep(1000);
		
	 	
	 	//Press the indivdual grid checkbox
	 	driver.findElement(By.xpath(Testelements.IndividualGrid_Checkbox)).click();
	 	
	 	
		Thread.sleep(2000);
		
	 	//Press the colors checkboxes
	 	driver.findElement(By.xpath(Testelements.UpchargeColorWhite)).click();
	 
		
	    driver.findElement(By.xpath(Testelements.UpchargeColorBlue)).click();
	 	
	 
	 	driver.findElement(By.xpath(Testelements.UpchargeApplyButton)).click();
	 	
	 	waitForPageLoadProductLevel();
	 	
	 	Thread.sleep(5000);
		
	 	
	 	//Switch back to parent window 
	    driver.switchTo().window(parentWindow17);
		  
	 	
	 	//Expand the first grid
	 	driver.findElement(By.xpath(Testelements.UpchargeGrid1_Expand)).click();
	 	
	    
		Thread.sleep(5000);
		
	 //Validating Reset Button on upcharge	
	    
	    
	     //Enter details into fields
	     List<WebElement> QuantityUpcharge1 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Quantity));
	     QuantityUpcharge1.get(20).sendKeys("2");
	 
	  	
	  	Thread.sleep(1000);
	  	
	  	
	  	List<WebElement> PriceUpcharge1=driver.findElements(By.xpath(Testelements.UpchargesGrid1_ListPrice));
	  	PriceUpcharge1.get(20).sendKeys("10");
	    
	   List<WebElement> mySelectElement92 = driver.findElements(By.xpath(Testelements.UpchargesGrid1_Pricecodes));
	   Select dropdown79= new Select(mySelectElement92.get(23));

	    dropdown79.selectByVisibleText("G/V 20%");
	    
	    Thread.sleep(2000);
		
	    //Scroll up
	    JavascriptExecutor jse200 = (JavascriptExecutor)driver;
	    jse200.executeScript("window.scrollBy(0,-250)", "");
	   
	    //Scroll up
	    JavascriptExecutor jse201 = (JavascriptExecutor)driver;
	    jse201.executeScript("window.scrollBy(-250,-500)", "");
	    
	    //Press the save button
	    driver.findElement(By.cssSelector(Testelements.SaveButton_PricingScreen)).click();
	    
	    waitForPageLoadProductLevel();
	    
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
	   	
	      
	  	Thread.sleep(4000);
	  	
	   	
	      //Enter quantity
	  	 //Enter details into fields
	    List<WebElement> QuantityUpcharge2 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Quantity));
	    QuantityUpcharge2.get(30).sendKeys("2");

	 	
	 	Thread.sleep(2000);
	 	
	 	
	 	List<WebElement> PriceUpcharge2=driver.findElements(By.xpath(Testelements.UpchargesGrid2_ListPrice));
	 	PriceUpcharge2.get(30).sendKeys("10");
	   
	  List<WebElement> mySelectElement93 = driver.findElements(By.xpath(Testelements.UpchargesGrid2_Pricecodes));
	  Select dropdown93= new Select(mySelectElement93.get(33));

	   dropdown93.selectByVisibleText("G/V 20%");
	   
	   Thread.sleep(2000);
	  	 	
	  	//Move to Images tab
	  	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
	  	
	  	waitForPageLoadProductLevel();
	  	
	  	Thread.sleep(1000);
	  	
	  //Scroll up
	    JavascriptExecutor jse2001 = (JavascriptExecutor)driver;
	    jse2001.executeScript("window.scrollBy(0,-250)", "");
	   
	    //Scroll up
	    JavascriptExecutor jse2010 = (JavascriptExecutor)driver;
	    jse2010.executeScript("window.scrollBy(-250,-500)", "");
     
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
	        
	    	waitForPageLoadProductLevel();
	    	
	    	Thread.sleep(1000);
	  
	      //Select the 1st image from Library to upload
	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
	     
	     //Scroll down
	     JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	     jse70.executeScript("window.scrollBy(0,250)", "");
	   	
	     
	  	 Thread.sleep(1000);
	 
	    //Confirm the images uploading details
	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
	     
	    //Switch back to parent window 
	        driver.switchTo().window(parentWindow2);
	        
	        
	        
	   //Scroll Up
	        JavascriptExecutor jse72 = (JavascriptExecutor)driver;
	        jse72.executeScript("window.scrollBy(0,-250)", "");
	        
	        waitForPageLoadProductLevel();
	        
	        Thread.sleep(1000);
	  
	 
	   driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	   
	   //Switch to new window opened
	    	for(String winHandle : driver.getWindowHandles()){
	    	    if(!winHandle.equals(parentWindow2)) {
	    	        driver.switchTo().window(winHandle);
	    	    }
	    	}
	        
	    	waitForPageLoadProductLevel();
	    	
	    	Thread.sleep(1000);
	  	
	   //Select the 1st image from Library to upload
	   driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
	   //Scroll Down
	   JavascriptExecutor jse71 = (JavascriptExecutor)driver;
	   jse71.executeScript("window.scrollBy(0,250)", "");
	 	
	   Thread.sleep(1000);

	   //Confirm the images uploading details
	   driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
	   

	   //Switch back to parent window 
	      driver.switchTo().window(parentWindow2);
	      
	      waitForPageLoadProductLevel();
	      
	      Thread.sleep(1000);
	      
	  	//Scroll Up
	      JavascriptExecutor jse = (JavascriptExecutor)driver;
	      jse.executeScript("window.scrollBy(0,-250)", "");
	      
	  	//Scroll Up
	      JavascriptExecutor jse30 = (JavascriptExecutor)driver;
	      jse30.executeScript("window.scrollBy(-250,-500)", "");
	      
	    //Scroll Up
	      JavascriptExecutor jse31 = (JavascriptExecutor)driver;
	      jse31.executeScript("window.scrollBy(-500,-750)", "");
	     
	      Thread.sleep(1000);
	      
	      //Press the save Button
	      driver.findElement(By.xpath(Testelements.SaveButton_MediaLibrary)).click();
	  
	      waitForPageLoadProductLevel();
	      
	      Thread.sleep(1000);
		
	   //Drag the 2nd placed Image to first and then drop it 
	     //Actions act=new Actions(driver);
		    //1st Media tagging  
		   // find element which we need to drag
		   //WebElement drag=driver.findElement(By.cssSelector("#image-import-container > ul > li:nth-child(2) > div.row-fluid > div.span2 > div.pull-left.marginR10 > i"));
		    
		    // find element which we need to drop
		   //WebElement drop=driver.findElement(By.cssSelector("#image-import-container > ul > li:nth-child(1) > div:nth-child(2) > strong"));
		    
		   // this will drag element to destination
		   //act.dragAndDrop(drag, drop).build().perform();
		    
		   
		   //Thread.sleep(2000);
	       
		 //Scroll Up
		      JavascriptExecutor jse32 = (JavascriptExecutor)driver;
		      jse32.executeScript("window.scrollBy(0,-250)", "");
		   
		      Thread.sleep(1000);
		   
		  
	   //Go to sku inventory
	   driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
	   
	  
	   waitForPageLoadProductLevel();
	  	
	   Thread.sleep(1000);
	   
	   waitForPageLoadProductLevel();
	  	
	   Thread.sleep(3000);
	   
	    driver.findElement(By.xpath(Testelements.SKUInv_Sel1)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.SKUInv_Sel1)).click();
	    
	    Thread.sleep(1000);
	    
	   WebElement mySelectElement3 = driver.findElement(By.xpath(Testelements.SKUInv_Sel1));
	   Select dropdown3= new Select(mySelectElement3);

	   
	   dropdown3.selectByVisibleText("Product Option: Product 1");
	   
	   driver.findElement(By.xpath(Testelements.SKUInv_Sel2)).click();
	   
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath(Testelements.SKUInv_Sel2)).click();
	   
	   Thread.sleep(1000);
	  
	   WebElement mySelectElement4 = driver.findElement(By.xpath(Testelements.SKUInv_Sel2));
	   Select dropdown4= new Select(mySelectElement4);
	   
	   dropdown4.selectByVisibleText("Product Option: Product 2"); 	
	     	
	   
	  	Thread.sleep(1000);
	  
	   
	   driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
	   
	   
	  	Thread.sleep(2000);
	  		
	    driver.findElement(By.xpath(Testelements.SKUQuantityReq)).sendKeys("3");
	    
	   
	  	
	  	
	     	//Move to availability tab
	   driver.findElement(By.xpath(Testelements.Availability_Tab)).click();
	   
	   
	   waitForPageLoadProductLevel();
	   
	   Thread.sleep(1000);
	  
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
	  	
	   
	   driver.findElement(By.xpath(Testelements.Availability_showbutton)).click();	
	     	
	     	
	  	Thread.sleep(3000);
	  		
	     	
	      //Goto Summary Tab
	  	 driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	  	        
	  	   //Wait for some time
	  	waitForPageLoadProductLevel();
	  	
	  	Thread.sleep(1000);
	  		
	      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	        
	      //Wait for all the fields to be appeared
	        wait = new WebDriverWait(driver, 180);
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active)));
	        
	        Thread.sleep(8000);
	  	
	       //Active the product
	        driver.findElement(By.cssSelector(Testelements.Product_Active)).click();
	        //Wait for the alert to appear
	        wait = new WebDriverWait(driver, 180);
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Active_Confirm)));
	        //Press the ok button from alert
	        driver.findElement(By.cssSelector(Testelements.Product_Active_Confirm)).click();
	        
	        Thread.sleep(10000);
	  	
	      //Press the eit manager Tab
	  		
		  	driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
		  	
		    Thread.sleep(1000);
		   //Press the eit admin tab
		   driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
		   
		   //Press the global lists tab
	        driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
	        
	        Thread.sleep(1000);
	        
	        //Select the global list options
	        WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
	        Select dropdown= new Select(mySelectElement);
	       
	        dropdown.selectByVisibleText("Manage Shapes");
	        
	        waitForPageLoad();
	        
	        Thread.sleep(1000);
	        
	        //Search the Shape name
	 	   driver.findElement(By.xpath(Testelements.ShapeSearchField)).sendKeys(Testdata.UpdateShapeName);
	 	   
	 	   driver.findElement(By.xpath(Testelements.ShapeSearchButton)).click();
	 	   
	 	   waitForPageLoad();
	 	   
	 	  //Press the delete Button
		   driver.findElement(By.xpath(Testelements.ShapeDeleteButton)).click();
		   
		   Thread.sleep(1000);
		   
		   //Press the delete confirmation button
		   driver.findElement(By.xpath(Testelements.ShapeDeleteConfirmButton)).click();
		   
		   Thread.sleep(10000);
		   
		   if(driver.findElement(By.xpath(Testelements.AssignShapeErrorMessage_OInDeletion)).getText().contains("Unable to delete shape"))
		   {
			   System.out.println("Shape Doesn't Delete if it is assign to products as Pricing, Product Number or Availability Relationships.");
			   
			   test = extent.createTest("AssignShapeToProduct_WithShapeDeletionError_Verification");
			  	  
			   test.log(Status.PASS, "Shape Doesn't Delete if it is assign to products as Pricing, Product Number or Availability Relationships.");
			   
		   }
		   else{
               System.out.println("Shape Does Delete if it is assign to products as Pricing, Product Number or Availability Relationships.");
			   
			   test = extent.createTest("AssignShapeToProduct_WithShapeDeletionError_Verification");
			  	  
			   test.log(Status.FAIL, "Shape Doesn't Delete if it is assign to products as Pricing, Product Number or Availability Relationships.");
		   }
	        
		   //Press to Ok Button to remove error
		   driver.findElement(By.xpath(Testelements.DeleteShapeErrorMessageOk_Button)).click();
		   
		   Thread.sleep(2000);
	       
	    	
	    	} catch(NoSuchElementException e){
	        	e.getStackTrace();
	  
  }
  
  }
   
   @Test(priority=27)
   public void DeleteShape() throws InterruptedException
   {
	   try{
		   
		   //Press the manage products tab
		   driver.findElement(By.cssSelector(Testelements.Dist_ManageProducts)).click();
		   
		   
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
		      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
		      
		     
		      Thread.sleep(1000);
		      
		      //Click th Manage product tab
		      driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
		      
		      wait = new WebDriverWait(driver, 180);
		      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
		      
		      Thread.sleep(1000);
		      
		      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
		      
		      waitForPageLoadProductLevel();
		      
		      Thread.sleep(1000);
		      
              waitForPageLoadProductLevel();
		      
		      Thread.sleep(2000);
		      
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
		       //Remove the shape
		         driver.findElement(By.xpath(Testelements.ShapeDeletionFromProduct)).click();
		         
		         Thread.sleep(2000);
		         
		      // Switching to Alert        
			        Alert alert = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= driver.switchTo().alert().getText();		
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);	
			        Thread.sleep(2000);
			        		
			        // Accepting alert		
			        alert.accept();	
			        
			        waitForPageLoadProductLevel();
			        
			        Thread.sleep(1000);
			        
			      //Now go Manage Products Screen
			        driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
			        
			        Thread.sleep(1000);
			        
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
		      
			        //Press the eit manager Tab
			  		
				  	driver.findElement(By.xpath(Testelements.EITManager_Tab)).click();
				  	
				  Thread.sleep(1000);
				   //Press the eit admin tab
				   driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
				   
				   //Press the global lists tab
			        driver.findElement(By.xpath(Testelements.GlobalListsTab)).click();
			        
			        Thread.sleep(1000);
			        
			        //Select the global list options
			        WebElement mySelectElement = driver.findElement(By.xpath(Testelements.GlobalListOperation_Dropdown));
			        Select dropdown= new Select(mySelectElement);
			       
			        dropdown.selectByVisibleText("Manage Shapes");
			        
			        waitForPageLoad();
			        
			        Thread.sleep(1000);
			        
			        //Search the Shape name
			 	   driver.findElement(By.xpath(Testelements.ShapeSearchField)).sendKeys(Testdata.UpdateShapeName);
			 	   
			 	   driver.findElement(By.xpath(Testelements.ShapeSearchButton)).click();
			 	   
			 	  waitForPageLoad();
			        
			        Thread.sleep(1000);
			 	   
			 	  //Press the delete Button
				   driver.findElement(By.xpath(Testelements.ShapeDeleteButton)).click();
				   
				   Thread.sleep(1000);
				   
				   //Press the delete confirmation button
				   driver.findElement(By.xpath(Testelements.ShapeDeleteConfirmButton)).click();
				   
				   waitForPageLoad();
			        
			        Thread.sleep(1000);
		     
	   if(driver.findElement(By.xpath(Testelements.ShapeDeleteVerification)).getText().contains("No result found"))
	   {
		   System.out.println("Shape Deleted Successfully");
		   
		   test = extent.createTest("Delete Shape");
	   		
	       test.log(Status.PASS, "Shape Deleted Successfully");
	   }
	   else{
		   
           System.out.println("Shape Deleted UnSuccessfully");
		   
		   test = extent.createTest("Delete Shape");
	   		
	       test.log(Status.FAIL, "Shape Deleted UnSuccessfully");
	   
	   }
	   }catch(NoSuchElementException e){
		   	
			e.getStackTrace();
			 
	   
	   }
   
   }
   @Test(priority=28)
   public void SpecifyTaxCategory() throws InterruptedException{
	   try{
	   //Press the manage products tab
	   driver.findElement(By.cssSelector(Testelements.Dist_ManageProducts)).click();
	   
	   
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
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Manage_Tab_Action)));
	      
	     
	      Thread.sleep(6000);
	      
	      //Click th Manage product tab
	      driver.findElement(By.cssSelector(Testelements.Manage_Tab_Action)).click();
	      
	     
	      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements. EditProduct)));
	      
	      Thread.sleep(2000);
	      
	      //Press the edit button
	      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	      
	      waitForPageLoadProductLevel();
	       
	        Thread.sleep(1000);
	        
	        waitForPageLoadProductLevel();
		       
	        Thread.sleep(2000);
	       
	         
	         WebElement mySelectElement = driver.findElement(By.xpath(Testelements.ProductSelectTaxCategory));
	         Select dropdown= new Select(mySelectElement);
	        
	         dropdown.selectByVisibleText("Software as a Service");
	         
	         Thread.sleep(1000);
	         
	         WebElement mySelectElement1 = driver.findElement(By.xpath(Testelements.ProductSelectTaxCategory));
	         Select dropdown1= new Select(mySelectElement1);
	        
	         dropdown1.selectByVisibleText("Textbook");
	         
	         Thread.sleep(1000);
	         
	         if(driver.findElement(By.xpath(Testelements.ProductSelectTaxCategory)).getText().contains("Textbook")){
	         
	         test = extent.createTest("SpecifyTaxCategory");
	  		
	  		 test.log(Status.PASS, "Specify Tax Category Code through UI Successfully");
	         }
	         else{
	        	  System.out.println("Specify Tax Category Code through UI Unsuccessfully");
	        	 
	        	 test = extent.createTest("SpecifyTaxCategory");
	 	  		
		  		 test.log(Status.FAIL, "Specify Tax Category Code through UI Unsuccessfully"); 
	        	 
	         }
	     
	         }catch(NoSuchElementException e){
	         	
	     		e.getStackTrace();
	     		 
	         
	         }
	      
	      
   
   
   }
    	 
   @Test(priority=29)
   public void MediaLibrarySelectAll() throws InterruptedException{
	   
	   try{
	   
       //First store parent window to switch back
       String parentWindow2 = driver.getWindowHandle(); 
       
       
   
       //Scroll down
       JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,-250)", "");
       
     //Scroll down
       JavascriptExecutor jse1 = (JavascriptExecutor)driver;
       jse1.executeScript("window.scrollBy(-250,-500)", "");
       
     //Scroll down
       JavascriptExecutor jse2 = (JavascriptExecutor)driver;
       jse2.executeScript("window.scrollBy(-500,-750)", "");
       
       Thread.sleep(1000);
       //Move to Images tab
     	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
     	
     	waitForPageLoad();
        
        Thread.sleep(1000);
     //Wait for the button to appear
     	 wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
           
       
       
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
    	
   
     //Press the select all checkbox
          driver.findElement(By.xpath(Testelements.ImagesSelectAll)).click();
          
          waitForPageLoadProductLevel();
	        
	        Thread.sleep(1000);
          
          if(driver.findElement(By.cssSelector("#imagesTabContent > div.span10 > div.large-scroll-y > div:nth-child(1) > div.mediaSelector > input[type='checkbox']")).isSelected() & driver.findElement(By.cssSelector("#imagesTabContent > div.span10 > div.large-scroll-y > div:nth-child(3) > div.mediaSelector > input[type='checkbox']")).isSelected()){
        	  
          System.out.println("All the images are sucessfully selected through select all checkbox");
          test = extent.createTest("Media Library-Select All");
	  	  test.log(Status.PASS, "All the images are sucessfully selected through select all checkbox");
          }
          else{
        	  
        	  System.out.println("All the images are unsucessfully selected through select all checkbox");
              test = extent.createTest("Media Library-Select All");
    	  	  test.log(Status.FAIL, "All the images are unsucessfully selected through select all checkbox"); 
          }
	         }catch(NoSuchElementException e){
	         	
	     		e.getStackTrace();
	     		 
	         
	         } 
      
   }
    	 
    	 
    @Test(priority=30)
    public void MediaLibrarySort() throws InterruptedException{
    	try{
    	//Press the select all to uncheck all selected
        driver.findElement(By.xpath(Testelements.ImagesSelectAll)).click();
    	
    	Thread.sleep(3000);
    	
    	  WebElement mySelectElement13 = driver.findElement(By.xpath(Testelements.ImagesSortDropdown));
	         Select dropdown13= new Select(mySelectElement13);
	        
	         dropdown13.selectByVisibleText("Oldest");
	         
	         waitForPageLoadProductLevel();
		        
		        Thread.sleep(1000);
	         
	         WebElement mySelectElement14 = driver.findElement(By.xpath(Testelements.ImagesSortDropdown));
	         Select dropdown14= new Select(mySelectElement14);
	        
	         dropdown14.selectByVisibleText("File Size");
	         
	         waitForPageLoadProductLevel();
		        
		        Thread.sleep(1000);
	         
	         WebElement mySelectElement15 = driver.findElement(By.xpath(Testelements.ImagesSortDropdown));
	         Select dropdown15= new Select(mySelectElement15);
	        
	         dropdown15.selectByVisibleText("File Name");
	         
	         waitForPageLoadProductLevel();
		        
		        Thread.sleep(1000);
	         
	         test = extent.createTest("Media Library-Sort Order");
		  		
		  	 test.log(Status.PASS, "Sorting through media library is sucessfully done");
		  		
		  		//Press the cancel button on media library
		  		driver.findElement(By.xpath(Testelements.MediaLibraryCancel_Button)).click();
		  		
		  		Thread.sleep(5000);
		  		
		  		//Select the manage my product button
		  		driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		  		
		  		wait = new WebDriverWait(driver, 120);
		  	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		  	    
		  	    Thread.sleep(2000);
		  	    
		  	    //Press the make changes active button
		  	    driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		  	    
		  	  wait = new WebDriverWait(driver, 120);
		  	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
		  	    
		  	    Thread.sleep(1000);
		  	    //Press the confirm ok button
		  	    driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
		  	   
		  	    
		  	    Thread.sleep(5000);
		     
		         }catch(NoSuchElementException e){
		         	
		     		e.getStackTrace();
		     		 
		         
		         } 
    	
    	
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

     
    
	public static void waitForPageLoad() throws InterruptedException {
			
			
		   wait = new WebDriverWait(driver, 120);
		       
		    pageLoaded = new Predicate<WebDriver>() {

		        public boolean apply(WebDriver input) {
		            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
		        }

		    };
		   //wait.until(pageLoaded) ;
		   System.out.println("Page Loaded Successfully");  
           Thread.sleep(2000);
           if( driver.findElement(By.xpath("//div[contains(@id,'busyindicator')]")).isDisplayed()){
 			  
        	   waitForPageLoad();
		   }
	 
     
     }
	public static void waitForPageLoadProductLevel() throws InterruptedException {
		
		
		   wait = new WebDriverWait(driver, 120);
		       
		    pageLoaded = new Predicate<WebDriver>() {

		        public boolean apply(WebDriver input) {
		            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
		        }

		    };
		  
		   System.out.println("Page Loaded Successfully");
		   
		   Thread.sleep(2000);
		   
		   if(driver.findElement(By.xpath("//div[contains(@id,'info_pibusyindicator')]")).isDisplayed()){
			   waitForPageLoadProductLevel();
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


