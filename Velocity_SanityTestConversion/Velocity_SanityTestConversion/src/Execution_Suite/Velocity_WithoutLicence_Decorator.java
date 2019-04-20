package Execution_Suite;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

import TestData.Testdata;
import TestData.Testelements;
import io.github.bonigarcia.wdm.WebDriverManager;




public class Velocity_WithoutLicence_Decorator {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	static String dest;
	String screenshotPath;
	ChromeDriver Opdriver;
	
	
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
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/VelocityDecoratorWithoutLicenceReport"+".html");
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
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/VelocityDecoratorWithoutLicenceReport"+".html");
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
				
		  else {
				
			  WebDriverManager.chromedriver().setup();
				//ChromeOptions options=new ChromeOptions();
				//options.addArguments("window-size=1400,800");
				//options.addArguments("headless");
				
				driver=new ChromeDriver();
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/VelocityDecoratorWithoutLicenceReport"+".html");
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
	 
	 
	 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		
	 driver.manage().window().maximize();
		 
	
	}
	
  @Test(priority=0)
  public void login() throws InterruptedException, IOException {
    try{
    	
    
			 
	//Wait for the login buttons to be appear 
	
	wait = new WebDriverWait(driver, 120);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.ASI_Num)));
    
    if(driver.getCurrentUrl().contains("stage")){
    
    //Insert ASI Number
    driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDecoASINumberStage);
    
    //Insert the username
    driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDecoUsernameStage);
    
    //Insert the Password
    driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDecoPasswordStage);
    
    }
    
    else if(driver.getCurrentUrl().contains("uat")){
    	 //Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDecoASINumberUAT);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDecoUsernameUAT);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDecoPasswordUAT);
    	
    }
    else{
    	
    	 //Insert ASI Number
        driver.findElement(By.cssSelector(Testelements.ASI_Num)).sendKeys(Testdata.vDecoASINumberProd);
        
        //Insert the username
        driver.findElement(By.cssSelector(Testelements.USername)).sendKeys(Testdata.vDecoUsernameProd);
        
        //Insert the Password
        driver.findElement(By.cssSelector(Testelements.Password)).sendKeys(Testdata.vDecoPasswordProd);
    }
    //Press the login Button
    driver.findElement(By.cssSelector(Testelements.LoginButton)).click();
    
    
    
    if(driver.getCurrentUrl().contains("stage")){
    	
    	wait = new WebDriverWait(driver, 120);
  	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DecoratorLoginSuccess_Validation)));
  	    
  	    Thread.sleep(2000);
    	
    	
    	if(driver.findElement(By.xpath(Testelements.DecoratorLoginSuccess_Validation)).isDisplayed()){
    		System.out.print("Decorator Loggedin Sucessfully");
    		test = extent.createTest("Login");
    		test.log(Status.PASS, "Decorator Loggedin Sucessfully");
    		
 
    		
    	}
    	else{
    		System.out.print("Decorator Loggedin UnSucessfully");
    		test = extent.createTest("Login");
    		test.log(Status.FAIL, "Decorator Loggedin UnSucessfully");	
    	}
    }	
    
    	else if(driver.getCurrentUrl().contains("uat")){
    		
    		
    		wait = new WebDriverWait(driver, 120);
      	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DecoratorLoginSuccessUAT_Validation)));
      	    
      	    Thread.sleep(2000);
    		
    		if(driver.findElement(By.xpath(Testelements.DecoratorLoginSuccessUAT_Validation)).isDisplayed()){
    			
    			System.out.print("Decorator Loggedin Sucessfully");
        		test = extent.createTest("Login");
        		test.log(Status.PASS, "Decorator Loggedin Sucessfully");
    		}
    	
    		else{
    			System.out.print("Decorator Loggedin UnSucessfully");
        		test = extent.createTest("Login");
        		test.log(Status.FAIL, "Decorator Loggedin UnSucessfully");
    		}
    		
    	}
    
	
    }    
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
    
    }
  }  
   
  
  
  @Test(priority=1)
  
  public void AddSharedProductDecorator() throws InterruptedException{
  	
  	try{
  		
  		Thread.sleep(2000);
  		
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
    	  Thread.sleep(2000);
       
		
        //Insert the product name
    	driver.findElement(By.cssSelector(Testelements.Product_Name)).sendKeys(Testdata.Productname);
    	
    	//Insert Product description
    	driver.findElement(By.cssSelector(Testelements.Product_description)).sendKeys("Chin Up Decorator");
    
        driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
        
        Thread.sleep(1000);
    	
    	
    	//Select the product type
    	//driver.findElement(By.cssSelector(Testelements.Product_type)).click();
    	
    	 //Creating a robot instance to select option in 2nd place in dropdown
    	WebElement mySelectElement = driver.findElement(By.xpath(Testelements.ProductType));
        Select dropdown= new Select(mySelectElement);
       
        dropdown.selectByVisibleText("Automotive Accessories");
    
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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Select the pricing tab for SPG
      
        driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
      
        waitForPageLoad();
        // Wait for attributes to appear
        
        wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_attributes_1)));
        
     
		Thread.sleep(1000);
		
        
        driver.findElement(By.cssSelector(Testelements.Product_attributes_1)).click();
        
        //Select the 2nd attribute
        driver.findElement(By.cssSelector(Testelements.Product_attributes_2)).click();
        
        //Save the attributes details
       // driver.findElement(By.cssSelector(Testelements.Product_Save_Button)).click();
        
        //Wait for few sec
       
		Thread.sleep(1000);
		
        
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
       
        Thread.sleep(1000);
        
        
        
        
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
        
        //Selection from dropdown
        	
        WebElement mySelectElement170 = driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_1));
        Select dropdown170= new Select(mySelectElement170);
       
        dropdown170.selectByVisibleText("L 70%");
        
       
			
		driver.findElement(By.cssSelector(Testelements.SPG_Quantity_2)).sendKeys("2");
		
		driver.findElement(By.cssSelector(Testelements.SPG_Listprice2)).sendKeys("10");
		
		//driver.findElement(By.cssSelector(Testelements.SPG_Pricecode_2)).click();
		
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
	     
	    
	     Thread.sleep(1000);
	
	     
	//Scroll down
    JavascriptExecutor jse119 = (JavascriptExecutor)driver;
    jse119.executeScript("window.scrollBy(0,250)", "");
    
	Thread.sleep(1000);
	
	
	
	//Confirm the images uploading details
	     driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
	     
	 
	     //Switch back to parent window 
	   driver.switchTo().window(parentWindow2);
	        
	   waitForPageLoad();
	   
	   Thread.sleep(1000);
	   
      waitForPageLoad();
	   
	   Thread.sleep(3000);
	     
	     
	  //Goto Summary Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	        
	   //Wait for some time
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
        waitForPageLoad();
	    
	    Thread.sleep(3000);
		
		
    
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
	 
	 driver.findElement(By.cssSelector(Testelements.ProductKeywordfield)).sendKeys(Keys.ENTER);

	 Thread.sleep(1000);
	
      driver.findElement(By.cssSelector(Testelements.SKUInventory)).click();
      
      waitForPageLoad();
	
      Thread.sleep(1000);
      
      waitForPageLoad();
  	
      Thread.sleep(3000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
      
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).click();
      
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventorySelection_dropdown)).sendKeys(Keys.DOWN);
      
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector(Testelements.SKUInventoryshow_button)).click();
      
      Thread.sleep(2000);
	
      
      driver.findElement(By.xpath(Testelements.SKURequired1)).sendKeys("3");
      
      driver.findElement(By.xpath(Testelements.SKURequired2)).sendKeys("2");
      
      
      WebElement mySelectElement10 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1));
      Select dropdown10= new Select(mySelectElement10);
     
      dropdown10.selectByVisibleText("In Stock");
      
      driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
      
      Thread.sleep(1000);
      
      driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus1)).click();
      
      Thread.sleep(1000);
      
      
      WebElement mySelectElement11 = driver.findElement(By.xpath(Testelements.DistSKUDec_InvStatus2));
      Select dropdown11= new Select(mySelectElement11);
      
      dropdown11.selectByVisibleText("In Stock");
      
	  Thread.sleep(1000);
	
   	 driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity1)).sendKeys("2");
   	 
   	 driver.findElement(By.xpath(Testelements.DistSKUDec_Quantity2)).sendKeys("3");
   	 
   	
	  Thread.sleep(1000);
	
   	 //Goto Summary Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
	    
	  
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
        waitForPageLoad();
	    
	    Thread.sleep(3000);
		
	    //Manane product listing
	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
   	 
	  //Wait for the button to appear
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
	     
       Thread.sleep(2000);
	     
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
	 		  System.out.println("Decorator product added and updated sucessfully");
	 		  test = extent.createTest("AddUpdateSharedDecoratorProduct");
	 		 
	 		  	test.log(Status.PASS, "Decorator product added and updated sucessfully");
	 		    
	 		  	}
	 		  	else{
	 		  		
	 		  		System.out.println("Decorator product added and updated unsucessfully");
	 		  	  test = extent.createTest("AddUpdateSharedDecoratorProduct");
	 		  	 
	 		  	  	test.log(Status.FAIL, "Decorator product added and updated unsucessfully");
	 		  	}
   
    	
    	} catch(NoSuchElementException e){
        	e.getStackTrace();
        	
	}
      } 
  
  public static String capture(String screenshotPath)throws IOException, InterruptedException{
		
		
		 	 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 dest = System.getProperty("user.dir")+"/Screenshot/"+screenshotPath+".jpg";
			 
		     File destination = new File(dest);
		     FileUtils.copyFile(source, destination);
		     return dest;
	
		 	 
		
		     
  
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
public void getResult(ITestResult result) throws IOException, InterruptedException{
	
	 
	 
	 if(result.getStatus()==ITestResult.FAILURE){
	 		System.out.println("Failure");
	 		
	 		test.log(Status.FAIL, result.getThrowable());
	 }
	 		
	 		extent.flush();
}


 
 
 
 
 
 @AfterTest
public void teardown(){
 	
 	
    driver.close();

}





}




