package Execution_Suite;

import java.awt.AWTException;
import java.io.File;
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


public class Videos_Features {
	protected static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	String Parentwindow;
	static WebDriver wdriver;
	static Predicate<WebDriver> pageLoaded;
	static String pageLoadStatus = null;
	String Projectpath;
	
	
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/Videos_Catalog_Features"+".html");
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
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/Videos_Catalog_Features"+".html");
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
	   			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/Videos_Catalog_Features"+".html");
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

 /* @Test(priority=2)
  public void FooterLinks_HttpsUrl_Verification() throws InterruptedException
  {
	  
	  //First store parent window to switch back
	     Parentwindow = driver.getWindowHandle();
	     
	     //Press the first footer link
	     driver.findElement(By.xpath(Testelements.ASIMagzines)).click();

	    //Switch to new window opened
	  	for(String winHandle : driver.getWindowHandles()){
	  	    if(!winHandle.equals(Parentwindow)) {
	  	        driver.switchTo().window(winHandle);
	  	    }
	  	}
  
	  	if(driver.getCurrentUrl().contains("https"))
	  	{
	  		System.out.println("Magzines https url verified Successfully");
	  	}
	  	else{
	  		System.out.println("Magzines https url verified UnSuccessfully");
	  	}
          
	  	
	  	
	  	
	  	driver.close();
	  	
	  	//Switch back to parent window 
	      driver.switchTo().window(Parentwindow);
	      
	      
 
	      //Press the first footer link
		     driver.findElement(By.xpath(Testelements.Connect)).click();

		    //Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(Parentwindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
	  
		  	if(driver.getCurrentUrl().contains("https"))
		  	{
		  		System.out.println("Connect https url verified Successfully");
		  	}
		  	else{
		  		System.out.println("Connect https url verified UnSuccessfully");
		  	}
	          driver.close();
		  	
		  	//Switch back to parent window 
		      driver.switchTo().window(Parentwindow);
	 
	  
		    //Press the first footer link
			     driver.findElement(By.xpath(Testelements.Connect)).click();

			    //Switch to new window opened
			  	for(String winHandle : driver.getWindowHandles()){
			  	    if(!winHandle.equals(Parentwindow)) {
			  	        driver.switchTo().window(winHandle);
			  	    }
			  	}
		  
			  	if(driver.getCurrentUrl().contains("https"))
			  	{
			  		System.out.println("Connect https url verified Successfully");
			  	}
			  	else{
			  		System.out.println("Connect https url verified UnSuccessfully");
			  	}
		          driver.close();
			  	
			  	//Switch back to parent window 
			      driver.switchTo().window(Parentwindow);
		 
			    //Press the first footer link
				     driver.findElement(By.xpath(Testelements.Connect)).click();

				    //Switch to new window opened
				  	for(String winHandle : driver.getWindowHandles()){
				  	    if(!winHandle.equals(Parentwindow)) {
				  	        driver.switchTo().window(winHandle);
				  	    }
				  	}
			  
				  	if(driver.getCurrentUrl().contains("https"))
				  	{
				  		System.out.println("Connect https url verified Successfully");
				  	}
				  	else{
				  		System.out.println("Connect https url verified UnSuccessfully");
				  	}
			          driver.close();
				  	
				  	//Switch back to parent window 
				      driver.switchTo().window(Parentwindow);
			 
				    //Press the first footer link
					     driver.findElement(By.xpath(Testelements.Connect)).click();

					    //Switch to new window opened
					  	for(String winHandle : driver.getWindowHandles()){
					  	    if(!winHandle.equals(Parentwindow)) {
					  	        driver.switchTo().window(winHandle);
					  	    }
					  	}
				  
					  	if(driver.getCurrentUrl().contains("https"))
					  	{
					  		System.out.println("Connect https url verified Successfully");
					  	}
					  	else{
					  		System.out.println("Connect https url verified UnSuccessfully");
					  	}
				          driver.close();
					  	
					  	//Switch back to parent window 
					      driver.switchTo().window(Parentwindow);
				 
					    //Press the first footer link
						     driver.findElement(By.xpath(Testelements.Connect)).click();

						    //Switch to new window opened
						  	for(String winHandle : driver.getWindowHandles()){
						  	    if(!winHandle.equals(Parentwindow)) {
						  	        driver.switchTo().window(winHandle);
						  	    }
						  	}
					  
						  	if(driver.getCurrentUrl().contains("https"))
						  	{
						  		System.out.println("Connect https url verified Successfully");
						  	}
						  	else{
						  		System.out.println("Connect https url verified UnSuccessfully");
						  	}
					          driver.close();
						  	
						  	//Switch back to parent window 
						      driver.switchTo().window(Parentwindow);
					 
						    //Press the first footer link
							     driver.findElement(By.xpath(Testelements.ESPWeb)).click();

							    //Switch to new window opened
							  	for(String winHandle : driver.getWindowHandles()){
							  	    if(!winHandle.equals(Parentwindow)) {
							  	        driver.switchTo().window(winHandle);
							  	    }
							  	}
						  
							  	if(driver.getCurrentUrl().contains("https"))
							  	{
							  		System.out.println("ESPWeb https url verified Successfully");
							  	}
							  	else{
							  		System.out.println("ESPWeb https url verified UnSuccessfully");
							  	}
						          driver.close();
							  	
							  	//Switch back to parent window 
							      driver.switchTo().window(Parentwindow);
						 
							    //Press the first footer link
								     driver.findElement(By.xpath(Testelements.ESPAdvertising)).click();

								    //Switch to new window opened
								  	for(String winHandle : driver.getWindowHandles()){
								  	    if(!winHandle.equals(Parentwindow)) {
								  	        driver.switchTo().window(winHandle);
								  	    }
								  	}
							  
								  	if(driver.getCurrentUrl().contains("https"))
								  	{
								  		System.out.println("ESPAdvertising https url verified Successfully");
								  	}
								  	else{
								  		System.out.println("ESPAdvertising https url verified UnSuccessfully");
								  	}
							          driver.close();
								  	
								  	//Switch back to parent window 
								      driver.switchTo().window(Parentwindow);
							 
								    //Press the first footer link
									     driver.findElement(By.xpath(Testelements.ESPWebsites)).click();

									    //Switch to new window opened
									  	for(String winHandle : driver.getWindowHandles()){
									  	    if(!winHandle.equals(Parentwindow)) {
									  	        driver.switchTo().window(winHandle);
									  	    }
									  	}
								  
									  	if(driver.getCurrentUrl().contains("https"))
									  	{
									  		System.out.println("ESPWebsites https url verified Successfully");
									  	}
									  	else{
									  		System.out.println("ESPWebsites https url verified UnSuccessfully");
									  	}
								          driver.close();
									  	
									  	//Switch back to parent window 
									      driver.switchTo().window(Parentwindow);
								 
									    //Press the first footer link
										     driver.findElement(By.xpath(Testelements.EmailExpress)).click();

										    //Switch to new window opened
										  	for(String winHandle : driver.getWindowHandles()){
										  	    if(!winHandle.equals(Parentwindow)) {
										  	        driver.switchTo().window(winHandle);
										  	    }
										  	}
									  
										  	if(driver.getCurrentUrl().contains("https"))
										  	{
										  		System.out.println("EmailExpress https url verified Successfully");
										  	}
										  	else{
										  		System.out.println("EmailExpress https url verified UnSuccessfully");
										  	}
									          driver.close();
										  	
										  	//Switch back to parent window 
										      driver.switchTo().window(Parentwindow);
									 
										    //Press the first footer link
											     driver.findElement(By.xpath(Testelements.ASICentral)).click();

											    //Switch to new window opened
											  	for(String winHandle : driver.getWindowHandles()){
											  	    if(!winHandle.equals(Parentwindow)) {
											  	        driver.switchTo().window(winHandle);
											  	    }
											  	}
										  
											  	if(driver.getCurrentUrl().contains("https"))
											  	{
											  		System.out.println("ASICentral https url verified Successfully");
											  	}
											  	else{
											  		System.out.println("ASICentral https url verified UnSuccessfully");
											  	}
										          driver.close();
											  	
											  	//Switch back to parent window 
											      driver.switchTo().window(Parentwindow);
										 
											    //Press the first footer link
												     driver.findElement(By.xpath(Testelements.TimAndrews)).click();

												    //Switch to new window opened
												  	for(String winHandle : driver.getWindowHandles()){
												  	    if(!winHandle.equals(Parentwindow)) {
												  	        driver.switchTo().window(winHandle);
												  	    }
												  	}
											  
												  	if(driver.getCurrentUrl().contains("https"))
												  	{
												  		System.out.println("TimAndrews https url verified Successfully");
												  	}
												  	else{
												  		System.out.println("TimAndrews https url verified UnSuccessfully");
												  	}
											          driver.close();
												  	
												  	//Switch back to parent window 
												      driver.switchTo().window(Parentwindow);
											 
												    //Press the first footer link
													     driver.findElement(By.xpath(Testelements.ASIFacebook)).click();

													    //Switch to new window opened
													  	for(String winHandle : driver.getWindowHandles()){
													  	    if(!winHandle.equals(Parentwindow)) {
													  	        driver.switchTo().window(winHandle);
													  	    }
													  	}
												  
													  	if(driver.getCurrentUrl().contains("https"))
													  	{
													  		System.out.println("ASIFacebook https url verified Successfully");
													  	}
													  	else{
													  		System.out.println("ASIFacebook https url verified UnSuccessfully");
													  	}
												          driver.close();
													  	
													  	//Switch back to parent window 
													      driver.switchTo().window(Parentwindow);
												 
													    //Press the first footer link
														     driver.findElement(By.xpath(Testelements.ASIYoutube)).click();

														    //Switch to new window opened
														  	for(String winHandle : driver.getWindowHandles()){
														  	    if(!winHandle.equals(Parentwindow)) {
														  	        driver.switchTo().window(winHandle);
														  	    }
														  	}
													  
														  	if(driver.getCurrentUrl().contains("https"))
														  	{
														  		System.out.println("ASIYoutube https url verified Successfully");
														  	}
														  	else{
														  		System.out.println("ASIYoutube https url verified UnSuccessfully");
														  	}
													          driver.close();
														  	
														  	//Switch back to parent window 
														      driver.switchTo().window(Parentwindow);
													 
														    //Press the first footer link
															     driver.findElement(By.xpath(Testelements.ASITwitter)).click();

															    //Switch to new window opened
															  	for(String winHandle : driver.getWindowHandles()){
															  	    if(!winHandle.equals(Parentwindow)) {
															  	        driver.switchTo().window(winHandle);
															  	    }
															  	}
														  
															  	if(driver.getCurrentUrl().contains("https"))
															  	{
															  		System.out.println("ASITwitter https url verified Successfully");
															  	}
															  	else{
															  		System.out.println("ASITwitter https url verified UnSuccessfully");
															  	}
														          driver.close();
															  	
															  	//Switch back to parent window 
															      driver.switchTo().window(Parentwindow);
														 
															    //Press the first footer link
																     driver.findElement(By.xpath(Testelements.AboutASI)).click();

																    //Switch to new window opened
																  	for(String winHandle : driver.getWindowHandles()){
																  	    if(!winHandle.equals(Parentwindow)) {
																  	        driver.switchTo().window(winHandle);
																  	    }
																  	}
															  
																  	if(driver.getCurrentUrl().contains("https"))
																  	{
																  		System.out.println("AboutASI https url verified Successfully");
																  	}
																  	else{
																  		System.out.println("AboutASI https url verified UnSuccessfully");
																  	}
															          driver.close();
																  	
																  	//Switch back to parent window 
																      driver.switchTo().window(Parentwindow);
															 
															  
																      //Press the first footer link
																	     driver.findElement(By.xpath(Testelements.PressRelease)).click();

																	    //Switch to new window opened
																	  	for(String winHandle : driver.getWindowHandles()){
																	  	    if(!winHandle.equals(Parentwindow)) {
																	  	        driver.switchTo().window(winHandle);
																	  	    }
																	  	}
																  
																	  	if(driver.getCurrentUrl().contains("https"))
																	  	{
																	  		System.out.println("PressRelease https url verified Successfully");
																	  	}
																	  	else{
																	  		System.out.println("PressRelease https url verified UnSuccessfully");
																	  	}
																          driver.close();
																	  	
																	  	//Switch back to parent window 
																	      driver.switchTo().window(Parentwindow);
																 
																	      //Press the first footer link
																		     driver.findElement(By.xpath(Testelements.ASICareers)).click();

																		    //Switch to new window opened
																		  	for(String winHandle : driver.getWindowHandles()){
																		  	    if(!winHandle.equals(Parentwindow)) {
																		  	        driver.switchTo().window(winHandle);
																		  	    }
																		  	}
																	  
																		  	if(driver.getCurrentUrl().contains("https"))
																		  	{
																		  		System.out.println("ASICareers https url verified Successfully");
																		  	
																		  		test = extent.createTest("FooterLinks_HttpsUrl_Verification");
																		     	 
																		     	 test.log(Status.PASS, "ASICareers https url verified Successfully"); 
																		  	
																		  	}
																		  	else{
																		  		System.out.println("ASICareers https url verified UnSuccessfully");
																		  	
																		  		test = extent.createTest("FooterLinks_HttpsUrl_Verification");
																		     	 
																		     	 test.log(Status.FAIL, "ASICareers https url verified UnSuccessfully"); 
																		  	
																		  	}
																	          driver.close();
																		  	
																		  	//Switch back to parent window 
																		      driver.switchTo().window(Parentwindow);
																	 
																	  
  
  
  
  }*/
  
 @Test(priority=3)
public void BannerVerification() throws InterruptedException{
	
	
//Scroll Up
      
      JavascriptExecutor jse70 = (JavascriptExecutor)driver;
      jse70.executeScript("window.scrollBy(0,-250)", "");
      
      JavascriptExecutor jse71 = (JavascriptExecutor)driver;
      jse71.executeScript("window.scrollBy(-250,-500)", "");
      
      JavascriptExecutor jse72 = (JavascriptExecutor)driver;
      jse72.executeScript("window.scrollBy(-500,-750)", "");
      
      Thread.sleep(1000);
	  
	  waitForPageLoad();
	
	if(driver.findElement(By.xpath(Testelements.BannerVerification)).isDisplayed())
	{
		System.out.println("Banner Displayed Successfully");
		
		test = extent.createTest("Banner_Verification");
     	 
     	 test.log(Status.PASS, "Banner Displayed Successfully"); 
	}
	else{
		
       System.out.println("Banner Displayed UnSuccessfully");
		
		test = extent.createTest("Banner_Verification");
     	 
     	test.log(Status.FAIL, "Banner Displayed UnSuccessfully");
	}

}
 @Test(priority=4)
 public void MediaLibrary_BulkDelete() throws InterruptedException{
	 
	 try{
		 
		//Click the manage product tab
		  	driver.findElement(By.xpath(Testelements.Manage_Product_Tab)).click();
		  	
		  	Thread.sleep(3000);
		      //Wait for the process to complete	    	
		  	wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProduct_button)));
		      
            Thread.sleep(2000);
            
            driver.findElement(By.cssSelector(Testelements.AddProduct_button)).click();
            
            Thread.sleep(2000);
		    
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
		      
		      Thread.sleep(2000);
		      
		      driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		      
		      Thread.sleep(3000);
		 
		 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibraryTab)));
	     
	     Thread.sleep(1000);
	     
	     //Press the Media Image Tab
	     driver.findElement(By.xpath(Testelements.MediaLibraryTab)).click();
		
		
		wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_UnlinkedFilter)));
	    
	    Thread.sleep(1000);
	    
	    //Clikc the Unlinked filter
	    driver.findElement(By.xpath(Testelements.MediaLibrary_UnlinkedFilter)).click();
	    
	    Thread.sleep(8000);
	    
	    //Select the Images  to bulk Delete
	    driver.findElement(By.xpath(Testelements.BulkDeleteProduct1)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.OuterAreaClick)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.BulkDeleteProduct2)).click();
	    
	    Thread.sleep(1000);
	    
	    
	    //Press the Bulk Delete Button
	    driver.findElement(By.xpath(Testelements.BulkDeleteImagesButton_MediaLibrary)).click();
	    
	    //Confirm Bulk delete
	    driver.findElement(By.xpath(Testelements.ConfirmBulkImageDelete)).click();
	    
	    Thread.sleep(7000);
	    
	 // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(1000);
        
        if(alertMessage.contains("Operation completed successfully"))
        {
        	System.out.println("Bulk Image Delete Successfully");
        	
        	test = extent.createTest("BulkImageDelete_MediaLibrary");
        	 
        	 test.log(Status.PASS, "Bulk Image Delete Successfully"); 
        	
        }
        else{
            System.out.println("Bulk Image Delete Successfully");
        	
        	test = extent.createTest("BulkImageDelete_MediaLibrary");
        	 
        	test.log(Status.FAIL, "Bulk Image Delete UnSuccessfully"); 
        	
        }
	    alert.accept();
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath(Testelements.ClearUnlinkedFilter)).click();
	    
	    Thread.sleep(2000);
	 
	 }
	 catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
 
 
 
 }

@Test(priority=5)
public void ImageUpload_MediaLibrary() throws InterruptedException{
	try{
	//Press the upload image button
		driver.findElement(By.xpath(Testelements.UploadImages_Button)).click();
		
		Thread.sleep(2000);
		
		Projectpath=System.getProperty("user.dir");
		System.out.println(Projectpath);
		
		
		//Uplaod the Image
		driver.findElement(By.xpath(Testelements.SelecImageButton)).sendKeys(Projectpath+"/Images/largesize.jpg");
		
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath(Testelements.InvalidImageSize_Validation_Verification)).getText().contains("exceeds maximum file size of 5MB"))
		{
			System.out.println("Invalid image size validation displayed Successfully");
			
			test = extent.createTest("InvalidImageUpload_MediaLibrary_ValidationCheck");
	       	 
       	    test.log(Status.PASS, "Invalid image size validation displayed Successfully");
			
		}
		else{
            System.out.println("Invalid image size validation displayed UnSuccessfully");
			
			test = extent.createTest("InvalidImageUpload_MediaLibrary_ValidationCheck");
	       	 
       	    test.log(Status.FAIL, "Invalid image size validation displayed UnSuccessfully");
		}
		
		//Uplaod the Image
		driver.findElement(By.xpath(Testelements.SelecImageButton)).sendKeys(Projectpath+"/Images/MediaLibrary.jpg");
		
		Thread.sleep(2000);
		
		//Press the upload button
		driver.findElement(By.xpath(Testelements.ImageUpload_triggerbutton)).click();
		
		wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ImageFileUpload_Success)));
	
	    waitForPageLoad();
	    
	    Thread.sleep(2000);
	    
	    //Press the Continue button
	    driver.findElement(By.xpath(Testelements.ImageUpload_ContinueButton)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(2000);
	    
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibraryImageUpload_Verification)));
	    
	    Thread.sleep(2000);
	    
	    if(driver.findElement(By.xpath(Testelements.MediaLibraryImageUpload_Verification)).getText().contains("MediaLibrary"))
	    {
	    	System.out.println("Media Library Image Uploaded Successfully");
	    	
	    	test = extent.createTest("ImageUpload_MediaLibrary");
       	 
       	    test.log(Status.PASS, "Media Library Image Uploaded Successfully");
	    }
	    else{
            System.out.println("Media Library Image Uploaded UnSuccessfully");
	    	
	    	test = extent.createTest("ImageUpload_MediaLibrary");
       	 
       	    test.log(Status.FAIL, "Media Library Image Uploaded UnSuccessfully");
	    }
	
	}
	
	catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}
@Test(priority=6)
public void MediaLibrary_ImageDelete() throws InterruptedException{
	try{
	  
		driver.navigate().refresh();
		
		Thread.sleep(20000);
		
		WebElement HoverImage=driver.findElement(By.xpath(Testelements.MediaLibraryImage_Hover));
	 	Hover(HoverImage);
	 	
	 	Thread.sleep(2000);
	 	
	 	driver.findElement(By.xpath(Testelements.ImageDeleteIcon)).click();
	 	
	 	Thread.sleep(3000);
	 	
	 // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(1000);
        
        alert.accept();
        
        waitForPageLoad();
        
        Thread.sleep(3000);
        
           List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.ImageDeleteVerification));
	       
	       int count=elementcount.size();
	       
	       System.out.println(count);
	       
	       if(count==0)
	       {
	          System.out.println("Media Library Image Deleted Successfully");
	          
	          test = extent.createTest("MediaLibrary_ImageDeletion");
	 		   	
	 		 test.log(Status.PASS, "Media Library Image Deleted Successfully");
	     	  
	        }
	       else{
	    	   System.out.println("Media Library Image Deleted UnSuccessfully");
		          
		        test = extent.createTest("MediaLibrary_ImageDeletion");
		 		   	
		 	test.log(Status.FAIL, "Media Library Image Deleted UnSuccessfully");
	       }
	 	
	 	
		
	}
	
	
	catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}

@Test(priority=7)
public void MediaLibrary_VirtualizeImage() throws InterruptedException{
	try{ 
	
	wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibraryTab)));
     
     Thread.sleep(1000);
     
     //Press the Media Image Tab
     driver.findElement(By.xpath(Testelements.MediaLibraryTab)).click();
	
	
	wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)));
    
    Thread.sleep(1000);
    
    //Press the Media Image Tab
    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    //Add A mask to virtualize image
   driver.findElement(By.xpath(Testelements.MediaLibrary_AddMask_Button)).click();
   
   if(driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).getText().contains("Save"))
   {
	   System.out.println("Mask Region Save Button displayed Successfully");
	   
	   test = extent.createTest("MaskRegion_SaveButton_Verification");
	      
	   test.log(Status.PASS, "Mask Region Save Button displayed successfully");
	   
   }
   else{
	   
         System.out.println("Mask Region Save Button displayed UnSuccessfully");
	   
	   test = extent.createTest("MaskRegion_SaveButton_Verification");
	      
	   test.log(Status.FAIL, "Mask Region Save Button displayed UnSuccessfully");
   
   }
   //Enter the width and height
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskWidth)).sendKeys("50");
   
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskHeight)).sendKeys("100");
   
   //Press the save button
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).click();
   
   Thread.sleep(1000);
   
   //Slect the mask media tags
   driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).click();
   
   //Press the save button
   driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
   
   waitForPageLoad();
   
   Thread.sleep(1000);
    
    if(driver.findElement(By.xpath(Testelements.MediaLibrary_VirtualizeImage_VerificationIcon)).isDisplayed())
    {
    	System.out.println("Image virtualized successfully");
    	 test = extent.createTest("MediaLibrary_VirtualizeImage");
	      test.log(Status.PASS, "Image virtualized successfully");
    	
    }
    else{
    	
    	System.out.println("Image virtualized unsuccessfully");
   	     test = extent.createTest("MediaLibrary_VirtualizeImage");
	     test.log(Status.FAIL, "Image virtualized unsuccessfully");
    }

	}
	  
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
	}

@Test(priority=8)
public void MediaLibrary_ImageCannotVirtualized() throws InterruptedException{
	try{
	 //Press the Media Image Tab
    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
    
    waitForPageLoad();
    
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)));
    
    Thread.sleep(1000);
    
    //Delete the button
    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)).click();
    
    waitForPageLoad();
    
    if(!driver.findElement(By.xpath(Testelements.DeleteMaskRegionArea_Verification)).isDisplayed())
    {
    	System.out.println("Mask Region Deleted Successfully");
    	
    	 test = extent.createTest("Mask Region Deletion");
	      
    	 test.log(Status.PASS, "Image cannot be virtualized successfully");
    }
    else{
    	System.out.println("Mask Region Deleted UnSuccessfully");
    	
   	 test = extent.createTest("Mask Region Deletion");
	      
   	 test.log(Status.FAIL, "Mask Region Deleted UnSuccessfully");
    }
    
    	//Check the image cannot be virtualized checkbox
    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)).click();
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
    
    waitForPageLoad();
    
    if(driver.findElement(By.xpath(Testelements.MediaLibrary_CannotVirtualizeImage_VerificationIcon)).isDisplayed())
    {
    	System.out.println("Image cannot be virtualized Successfully");
    	 test = extent.createTest("MediaLibrary_ImageCannotVirtualized");
	      test.log(Status.PASS, "Image cannot be virtualized successfully");
    	
    }
    else{
    	
    	System.out.println("Image can be  virtualized");
   	     test = extent.createTest("MediaLibrary_ImageCannotVirtualized");
	     test.log(Status.FAIL, "Image can be virtualized");
    }
	}
	  
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	

	
	}
@Test(priority=9)
public void MediaLibrary_NotVirtualizedImage() throws InterruptedException{
	 try{
	 driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
	    
	 waitForPageLoad();
	 
	 //Uncheck the Cannot be virtualized checkbox
	 
	    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)).click();
	    
	    //Press the save button
	    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
	    
	    waitForPageLoad();
	    
	    if(!driver.findElement(By.xpath(Testelements.MediaLibrary_CannotVirtualizeImage_VerificationIcon)).isDisplayed())
	    {
	    	System.out.println("Image Not virtualized Successfully");
	    	 test = extent.createTest("MediaLibrary_NotVirtualizedImage");
		      test.log(Status.PASS, "Image Not virtualized Successfully");
	    	
	    }
	    else{
	    	
	    	System.out.println("Image Not virtualized UnSuccessfully");
	   	     test = extent.createTest("MediaLibrary_ImageCannotVirtualized");
		     test.log(Status.FAIL, "Image Not virtualized Successfully");
	    }
		}
		  
		  catch(NoSuchElementException e){
			  e.getStackTrace();
		  }
		

		
		}	 


@Test(priority=10)
public void DeleteMasking() throws InterruptedException{
driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
    
    waitForPageLoad();
    
    //Add A mask to virtualize image
   driver.findElement(By.xpath(Testelements.MediaLibrary_AddMask_Button)).click();
   
  
   //Enter the width and height
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskWidth)).sendKeys("50");
   
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskHeight)).sendKeys("100");
   
   //Press the save button
   driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).click();
   
   Thread.sleep(1000);
   
   //Slect the mask media tags
   driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).click();
   
   //Press the save button
   driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
   
   waitForPageLoad();
    
    if(driver.findElement(By.xpath(Testelements.MediaLibrary_VirtualizeImage_VerificationIcon)).isDisplayed())
    {
    	System.out.println("Image virtualized successfully");
    	 
    	
    }
    else{
    	
    	System.out.println("Image virtualized unsuccessfully");
   	     
    }
   //Select the Image
    driver.findElement(By.xpath(Testelements.ImageSelectionMediaLibrary)).click();
    
   //Press the Delete Masking Button
    driver.findElement(By.xpath(Testelements.DeleteMaskRegionButton_MediaLibrary)).click();
    
    Thread.sleep(1000);
    
    //Press the Ok button to make confirmation 
    driver.findElement(By.xpath(Testelements.ConfirmDeleteMaskRegion)).click();
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteMasking_SuccessMessage_OkButton)));
    
    Thread.sleep(1000);
    
	//Press the success ok button
    driver.findElement(By.xpath(Testelements.DeleteMasking_SuccessMessage_OkButton)).click();
    
    Thread.sleep(1000);
    
    driver.navigate().refresh();
    
    Thread.sleep(2000);
    if(!driver.findElement(By.xpath(Testelements.MediaLibrary_VirtualizeImage_VerificationIcon)).isDisplayed())
    {
    	System.out.println("Masking deleted Successfully");
    	 test = extent.createTest("DeleteMasking");
	      test.log(Status.PASS, "Masking deleted Successfully");
    	
    }
    else{
    	
    	System.out.println("Masking deleted unsuccessfully");
   	     test = extent.createTest("DeleteMasking");
	     test.log(Status.FAIL, "Masking deleted unsuccessfully");
    }
}

@Test(priority=11)
public void MediaLibrary_ClearMediaTag() throws InterruptedException{
	 try{
	 driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
	    
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	 
	 //Clear all the media tag on virtualize popup
	 driver.findElement(By.xpath(Testelements.MediaLibrary_ClearMediatags)).click();
	 
	Thread.sleep(1000);
	 
    if(!driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).isSelected())
    {
    	System.out.println("Media tags unselect Successfully");
   	    test = extent.createTest("MediaLibrary_ClearAllMediaTags_Virtualize");
	    test.log(Status.PASS, "Media tags unselect Successfully");
   
    }
    else{
    	System.out.println("Media tags unselect UnSuccessfully");
  	     test = extent.createTest("MediaLibrary_ClearAllMediaTags_Virtualize");
	     test.log(Status.FAIL, "Media tags unselect UnSuccessfully");
   }
    	
    
    //Press the save button
	    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
	    
	    waitForPageLoad();
	    
	 }
		  
		  catch(NoSuchElementException e){
			  e.getStackTrace();
		  }
		

		
		}	 

@Test(priority=12)
public void AddTags_MediaLibrary() throws InterruptedException{
	
	//Select the Image
    driver.findElement(By.xpath(Testelements.ImageSelectionMediaLibrary)).click();
    
    Thread.sleep(1000);
    
   //Press the Add Tags Button
    driver.findElement(By.xpath(Testelements.AddTagButton_MediaLibrary)).click();
    
    waitForPageLoad();

  //Select the tags and save it
    driver.findElement(By.xpath(Testelements.AddTag_FrontOption)).click();
    
    Thread.sleep(1000);
    
  //Press the save button
    driver.findElement(By.xpath(Testelements.AddTag_SaveButton)).click();
    
    waitForPageLoad();
    
  //Refresh the Page
    driver.navigate().refresh();
    
    Thread.sleep(1000);
    
   //Press the virtaulize again for the image
driver.findElement(By.xpath(Testelements.MediaLibrary_ImageVirtualize_Link)).click();
    
    waitForPageLoad();
    
    if(driver.findElement(By.xpath(Testelements.VirtualizeTag_Verification)).isSelected())
    {
    	System.out.println("Tag Added Successfully");
    	
    	test = extent.createTest("AddTags_MediaLibrary");
	    
    	test.log(Status.PASS, "Tag Added Successfully");
    	
    }
    else{
        System.out.println("Tag Added UnSuccessfully");
    	
    	test = extent.createTest("AddTags_MediaLibrary");
	    
    	test.log(Status.FAIL, "Tag Added UnSuccessfully");
    	
    }
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
    
    waitForPageLoad();


}
@Test(priority=13)
  public void MediaLibraryVideoSanity_Youtube() throws InterruptedException{
	  
	  try{
		  
		//Press the Media Image Tab
	      driver.findElement(By.xpath(Testelements.MediaLibraryTab)).click();
	      
	    //Wait for Videos Tab to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_VideosTab)));
	      
	      Thread.sleep(1000);
	      
	   //Press the videos Tab
	      driver.findElement(By.xpath(Testelements.MediaLibrary_VideosTab)).click();
	      
	    //Wait for Add Video Button to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_AddVideoButton)));
	      
	      Thread.sleep(1000);
	   //Wait for Add Video Button to be appear
	      driver.findElement(By.xpath(Testelements.MediaLibrary_AddVideoButton)).click();
	      
	    //Wait for Add Video Create Screen to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoName_TextField)));
	      
	      Thread.sleep(1000);
	      
	      //Insert the name for video
	      driver.findElement(By.xpath(Testelements.VideoName_TextField)).sendKeys(Testdata.Automation_Youtube);
	      
	      
	      
	      WebElement mySelectElement = driver.findElement(By.xpath(Testelements.VideoProductType_Dropdown));
	      Select dropdown= new Select(mySelectElement);
	     
	      dropdown.selectByVisibleText("Product");
	  
	      //Enter the URL
	      driver.findElement(By.xpath(Testelements.VideoURL_TextField)).sendKeys("https://www.youtube.com/watch?v=njkSX6cyVLM");
	      
	       WebElement VideoDescription=driver.findElement(By.xpath(Testelements.VideoDescription));
	      //Enter the description
	      VideoDescription.click();
	      Thread.sleep(1000);
	      VideoDescription.sendKeys("Automation Youtube Video");
	      
	      
	      
	      //Press the save button
	      driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	      
	      Thread.sleep(1000);
	      
	      if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	      System.out.println("YouTube Video Added Successfully with Product Level");
	      test = extent.createTest("Youtube Video Added Sucessfully with Product Level");
	      test.log(Status.PASS, "Youtube Video Added Sucessfully with Product Level");
	      }
	      else{
	    	  
	    	  System.out.println("YouTube Video Added UnSuccessfully");
		      test = extent.createTest("Youtube Video Added Sucessfully with Product Level");
		      test.log(Status.FAIL, "Youtube Video Added Sucessfully with Product Level"); 
	      }
	      
	      Thread.sleep(3000);
	      
	      
	      //Press the Preview Button
	      driver.findElement(By.xpath(Testelements.VideoPreviewLinkAfterSave)).click();
	      
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoPreviewVerification)));
	      
	      Thread.sleep(3000);
	      
	      if(driver.findElement(By.xpath(Testelements.VideoPreviewVerification)).isDisplayed())
	      {
	    	  System.out.println("Video Preview Displayed On video Details screen Successfully");
	       
	    	  test = extent.createTest("VideoPreview_VideoDetails");
		      
	    	  test.log(Status.PASS, "Video Preview Displayed On video Details screen Successfully");
	      
	      }
	      else{
	    	  
	    	  System.out.println("Video Preview Displayed On video Details screen UnSuccessfully");
		       
	    	  test = extent.createTest("VideoPreview_VideoDetails");
		      
	    	  test.log(Status.FAIL, "Video Preview Displayed On video Details screen UnSuccessfully");
	      }
	  //Close the Preview
	      driver.findElement(By.xpath(Testelements.VideoPreviewClose_DetailVideoScreen)).click();
	      
	      Thread.sleep(4000);
	  
	  }
  
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
  
  
  }
 
 @Test(priority=14)
 public void AssociatedProduct_WithYoutubevideo() throws InterruptedException{
	 try{
	 //Press the associated products button
	 driver.findElement(By.xpath(Testelements.Videos_AssociateProducts_Button)).click();
	 
	 Thread.sleep(4000);
	 
	 //Search the product which want to associate with youtube video
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_Search_TextField)).sendKeys("Youtube video associated product");
	 
	 //Press the search button
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_SearchButton)).click();
	 waitForPageLoad();
	 
	 Thread.sleep(5000);
	 
	 //Select the the product which searched
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_Selection)).click();
	 
	 Thread.sleep(3000);
	 
	 //Press the add product Associated button on popup
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_AddButton)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	 //Press the save button
	 driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	 
	 Thread.sleep(1000);
	 
	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	 System.out.println("Product Asscociated with youtube video sucessfully");
	 test = extent.createTest("Product_Association with Youtube video");
 	test.log(Status.PASS, "Product Asscociated with youtube video sucessfully");
	 }
	 else{
		 
		 System.out.println("Product Asscociated with youtube video unsucessfully");
		 test = extent.createTest("Product_Association with Youtube video");
		 test.log(Status.FAIL, "Product Asscociated with youtube video unsucessfully");
		 
	 }
	 
	
	//Scroll Up
     
	   JavascriptExecutor jse70 = (JavascriptExecutor)driver;
  jse70.executeScript("window.scrollBy(0,-250)", "");
  
//Scroll Up
  
  JavascriptExecutor jse77 = (JavascriptExecutor)driver;
jse77.executeScript("window.scrollBy(-250,-500)", "");

Thread.sleep(4000);
	 }
	 
	 
	  catch(NoSuchElementException e){
		  e.getStackTrace();
 }
 
 }
 
 @Test(priority=15)
 public void UpdateYoutubeVideo() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 //Wait for the edit button to be appear
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoEdit_Button)));
     
     Thread.sleep(1000);
     
     //Press the Preview Button
     driver.findElement(By.xpath(Testelements.VideosListingPreviewButton)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoPreviewVerification)));
     
     Thread.sleep(2000);
     if(driver.findElement(By.xpath(Testelements.VideoPreviewVerification)).isDisplayed())
     {
    	 System.out.println("Video Preview On Video Listing Screen Display Successfully");
    	 
    	 test = extent.createTest("VideoPreview_VideosListing");
    	 	
    	 test.log(Status.PASS, "Video Preview On Video Listing Screen Display sucessfully");
    	 
     }
     else{
       System.out.println("Video Preview On Video Listing Screen Display Successfully");
    	 
    	 test = extent.createTest("VideoPreview_VideosListing");
    	 	
    	 test.log(Status.FAIL, "Video Preview On Video Listing Screen Display sucessfully"); 
    	 
     }
     //CLose the Preview
     driver.findElement(By.xpath(Testelements.VideoPreviewClose_DetailVideoScreen)).click();
     
     Thread.sleep(1000);
     
     //Press the edit button
     driver.findElement(By.xpath(Testelements.VideoEdit_Button)).click();
     
     waitForPageLoad();
     
     Thread.sleep(1000);
     
     //Update the description
     driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys(" Updated Youtube description");
     
     
     
     JavascriptExecutor jse70 = (JavascriptExecutor)driver;
     jse70.executeScript("window.scrollBy(0,-250)", "");
     
     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
     jse71.executeScript("window.scrollBy(-250,-500)", "");
 
     Thread.sleep(1000);
     //Press the save button
     driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
     
     Thread.sleep(2000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	 System.out.println("UpdateYoutubeVideo details sucessfully");
    	 test = extent.createTest("UpdateYoutubeVideo details");
    	 test.log(Status.PASS, "UpdateYoutubeVideo details sucessfully");
     }
     else{
    	 
    	 System.out.println("UpdateYoutubeVideo details unsucessfully");
    	 test = extent.createTest("UpdateYoutubeVideo details");
    	  	
    	  	test.log(Status.FAIL, "UpdateYoutubeVideo details unsucessfully");
     }
     
     Thread.sleep(6000);
     
     //Bulk delete the videos
     driver.findElement(By.xpath(Testelements.BulkDeletevideo_Checkbox)).click();
     
     Thread.sleep(1000);
     
     //Press the remove button
     driver.findElement(By.xpath(Testelements.RemoveDeleteVideo_Button)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemoveConfirm)));
     
     Thread.sleep(1000);
     
     //Press the ok button to bulk delete the videos
     driver.findElement(By.xpath(Testelements.BulkRemoveConfirm)).click();
     
     Thread.sleep(2000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
     
     System.out.println("Bulk delete the videos sucessfully");
     test = extent.createTest("Bulk delete the videos");
   	
   	test.log(Status.PASS, "Bulk delete the videos sucessfully");
     }
     else{
    	 System.out.println("Bulk delete the videos unsucessfully");
    	 test = extent.createTest("Bulk delete the videos");
    	   
    	   	test.log(Status.FAIL, "Bulk delete the videos unsucessfully");
     }
     
     Thread.sleep(1000);
  //Scroll Up
	     
	   JavascriptExecutor jse79 = (JavascriptExecutor)driver;
       jse79.executeScript("window.scrollBy(0,-250)", "");
       
       JavascriptExecutor jse791 = (JavascriptExecutor)driver;
       jse791.executeScript("window.scrollBy(-250,-500)", "");
    
    Thread.sleep(1000);
     //Press the save button
     driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
     
     waitForPageLoad();
     
     Thread.sleep(6000);
     
    
 	 }
 	 
 	 
 	  catch(NoSuchElementException e){
 		  e.getStackTrace();
  }
     
	 
 }
 
 @Test(priority=16)
 public void SearchVideo() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 Thread.sleep(2000);
	 
	 //Search the  youtube video
    driver.findElement(By.xpath(Testelements.SearchVideo_SearchField)).sendKeys("Automation Youtube");
    
    
    
    //Press the search button
    driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    if(driver.findElement(By.xpath(Testelements.AutomationYoutubeValidation_Search)).isDisplayed()){
	    test = extent.createTest("Youtube video Search from media library Product level");
	   	
	   	test.log(Status.PASS, "Youtube video Search from media library Product level Successfully");
	    }
	    else{
	    	 test = extent.createTest("Youtube video Search from media library Product level");
	 	   	
	 	   	test.log(Status.FAIL, "Youtube video Search from media library Product level Unsuccessfull");
	    }
   	
  	 }
  	 
  	 
  	  catch(NoSuchElementException e){
  		  e.getStackTrace();
   }
      
 	 
  }
    
 @Test(priority=17)
 public void DeleteVideo() throws InterruptedException{
	 try{
	 //Press the delete button
	 driver.findElement(By.xpath(Testelements.DeleteVideos_button)).click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteVideoConfirmButton)));
     
     Thread.sleep(1000);
     
     //PRess the ok button to delete the video
     driver.findElement(By.xpath(Testelements.DeleteVideoConfirmButton)).click();
     
     Thread.sleep(1000);
     
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
     
    	 System.out.println("Video Deleted Successfully"); 
    	 test = extent.createTest("Video Deleted");
    	
    	test.log(Status.PASS, "Video Deleted sucessfully");
     }
     else{
    	 
    	 System.out.println("Video Deleted UnSuccessfully"); 
    	 test = extent.createTest("Video Deleted ");
    	
    	test.log(Status.FAIL, "Video Deleted Unsucessfully");
     }
     
     
    	WebElement toClear = driver.findElement(By.xpath(Testelements.SearchVideo_SearchField));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        
        
        
      //Press the search button
        driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
        
        waitForPageLoad();
        
        Thread.sleep(1000);
        
        
    	
   	 }
   	 
   	 
   	  catch(NoSuchElementException e){
   		  e.getStackTrace();
    }
	 
 }
 
 @Test(priority=18)
 public void MediaLibraryVideoSanity_VimeoProductLevel() throws InterruptedException{
	  
	  try{
		  
		
	   //Wait for Add Video Button to be appear
	      driver.findElement(By.xpath(Testelements.MediaLibrary_AddVideoButton)).click();
	      
	    //Wait for Add Video Create Screen to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoName_TextField)));
	      
	      Thread.sleep(1000);
	      
	      //Insert the name for video
	      driver.findElement(By.xpath(Testelements.VideoName_TextField)).sendKeys(Testdata.Automation_Vimeo);
	      
	      
	      
	      WebElement mySelectElement = driver.findElement(By.xpath(Testelements.VideoProductType_Dropdown));
	      Select dropdown= new Select(mySelectElement);
	     
	      dropdown.selectByVisibleText("Product");
	  
	      
	      
	      //Enter the URL
	      driver.findElement(By.xpath(Testelements.VideoURL_TextField)).sendKeys("https://vimeo.com/246983302");
	      
	      
	      
	      driver.findElement(By.xpath(Testelements.VideoDescription)).click();
	      
	      Thread.sleep(1000);
	      //Enter the description
	      driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys("Automation vimeo Video");
	      
	      
	      
	      //Press the save button
	      driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	      
	      Thread.sleep(2000);
	      
	      if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	      System.out.println("Vimeo Video Added Sucessfully with Product Level");
	      test = extent.createTest("Vimeo Video Added  with Product Level");
	    	
	    	test.log(Status.PASS, "Vimeo Video Added Sucessfully with Product Level");
	      }
	      else{
	    	  
	    	  System.out.println("Vimeo Video Added UnSucessfully with Product Level");
		      test = extent.createTest("Vimeo Video Added  with Product Level");
		    	
		    	test.log(Status.FAIL, "Vimeo Video Added UnSucessfully with Product Level");
	      }
	  	  
	     Thread.sleep(5000);
	      
	      
	      
	  
	  }
 
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
 
 
 }

@Test(priority=19)
public void AssociatedProduct_WithVimeovideo() throws InterruptedException{
	 try{
	 //Press the associated products button
	 driver.findElement(By.xpath(Testelements.Videos_AssociateProducts_Button)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	 
	 //Search the product which want to associate with youtube video
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_Search_TextField)).sendKeys("vimeo video associated product");
	 
	 //Press the search button
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_SearchButton)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(5000);
	 
	 //Select the the product which searched
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_Selection)).click();
	 
	 Thread.sleep(3000);
	 
	 //Press the add product Associated button on popup
	 driver.findElement(By.xpath(Testelements.AssociatedProducts_AddButton)).click();
	 
	 Thread.sleep(2000);
	 
	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
		 System.out.println("Product Asscociated with vimeo video sucessfully");
		 test = extent.createTest("Product_Association with vimeo video");
		test.log(Status.PASS, "Product Asscociated with vimeo video sucessfully");
		 
	 }
	 else{
		 
		 System.out.println("Product Asscociated with vimeo video unsucessfully");
		 test = extent.createTest("Product_Association with vimeo video");
		test.log(Status.FAIL, "Product Asscociated with vimeo video unsucessfully");
	 }
	 
	 //Press the save button
	 driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	 
	 Thread.sleep(2000);
	 
	//Scroll Up
     
	   JavascriptExecutor jse70 = (JavascriptExecutor)driver;
	   jse70.executeScript("window.scrollBy(0,-250)", "");
	   
	 //Scroll Up
	     
	   JavascriptExecutor jse79 = (JavascriptExecutor)driver;
	   jse79.executeScript("window.scrollBy(-250,-500)", "");
	 
	   Thread.sleep(4000);
	 }
	 
	 
	  catch(NoSuchElementException e){
		  e.getStackTrace();
}

}

@Test(priority=20)
public void UpdateVimeoVideo() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 //Wait for the edit button to be appear
	 wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoEdit_Button)));
    
    Thread.sleep(1000);
    
    //Press the edit button
    driver.findElement(By.xpath(Testelements.VideoEdit_Button)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    //Update the description
    driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys(" Updated Vimeo description");
    
   
    
    JavascriptExecutor jse90 = (JavascriptExecutor)driver;
    jse90.executeScript("window.scrollBy(0,-250)", "");
    
    JavascriptExecutor jse91 = (JavascriptExecutor)driver;
    jse91.executeScript("window.scrollBy(-250,-500)", "");
    
    Thread.sleep(1000);
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	
    	 System.out.println("UpdateVimeoVideo details sucessfully");
    	 test = extent.createTest("UpdateVimeoVideo details");
    	 test.log(Status.PASS, "UpdateVimeoVideo details sucessfully");
    
    }
    else{
    	 System.out.println("UpdateVimeoVideo details unsucessfully");
    	 test = extent.createTest("UpdateVimeoVideo details");
    	 test.log(Status.FAIL, "UpdateVimeoVideo details unsucessfully");
    }
    Thread.sleep(6000);
   
    
    //Bulk delete the videos
    driver.findElement(By.xpath(Testelements.BulkDeletevideo_Checkbox)).click();
    
    Thread.sleep(1000);
    
    //Press the remove button
    driver.findElement(By.xpath(Testelements.RemoveDeleteVideo_Button)).click();
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkRemoveConfirm)));
    
    Thread.sleep(1000);
    
    //Press the ok button to bulk delete the videos
    driver.findElement(By.xpath(Testelements.BulkRemoveConfirm)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	  System.out.println("Bulk delete the videos sucessfully");
    	  test = extent.createTest("Bulk delete the videos");
    	  test.log(Status.PASS, "Bulk delete the videos sucessfully");
   
   }
   else{
	   System.out.println("Bulk delete the videos unsucessfully");
	   test = extent.createTest("Bulk delete the videos");
	  
	  	test.log(Status.FAIL, "Bulk delete the videos unsucessfully");
   }
         
 //Scroll Up
	     
   JavascriptExecutor jse70 = (JavascriptExecutor)driver;
   jse70.executeScript("window.scrollBy(0,-250)", "");
   
   JavascriptExecutor jse71 = (JavascriptExecutor)driver;
   jse71.executeScript("window.scrollBy(-250,-500)", "");
   
   Thread.sleep(1000);
    //Press the save button
    driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
    
    Thread.sleep(9000);
    
   
	 }
	 
	 
	  catch(NoSuchElementException e){
		  e.getStackTrace();
 }
    
	 
}

@Test(priority=21)
public void SearchVimeoVideo() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	 
	 //Search the  youtube video
   driver.findElement(By.xpath(Testelements.SearchVideo_SearchField)).sendKeys("Automation Vimeo");
   
   
   
   //Press the search button
   driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
   
   waitForPageLoad();
   
   Thread.sleep(1000);
   
   if(driver.findElement(By.xpath(Testelements.AutomationVimeoTextValidation_Search)).isDisplayed()){
    System.out.println("Vimeo video Searched sucessfully");
	test = extent.createTest("Vimeo video Search");
  test.log(Status.PASS, "Vimeo video Searched sucessfully");
   }
   else{
	   System.out.println("Vimeo video Searched unsucessfully");
	   test = extent.createTest("Vimeo video Search");
	   test.log(Status.FAIL, "Vimeo video Searched unsucessfully");
   }
  	
 	 }
 	 
 	 
 	  catch(NoSuchElementException e){
 		  e.getStackTrace();
  }
     
	 
 }
   
@Test(priority=22)
public void DeleteVimeoVideo() throws InterruptedException{
	 try{
	//Press the delete button
	 driver.findElement(By.xpath(Testelements.DeleteVideos_button)).click();
	 
	 wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteVideoConfirmButton)));
    
    Thread.sleep(1000);
    
    //PRess the ok button to delete the video
    driver.findElement(By.xpath(Testelements.DeleteVideoConfirmButton)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
  	  System.out.println("Video Deleted sucessfully");
  	 test = extent.createTest("Video Deleted");
    	
    	test.log(Status.PASS, "Video Deleted sucessfully");
 
 }
 else{
	   System.out.println("Video Deleted unsucessfully");
	   test = extent.createTest("Video Deleted");
	   
	   	test.log(Status.FAIL, "Video Deleted unsucessfully");
 }
    Thread.sleep(7000);
   	   WebElement toClear = driver.findElement(By.xpath(Testelements.SearchVideo_SearchField));
       toClear.sendKeys(Keys.CONTROL + "a");
       toClear.sendKeys(Keys.DELETE);
       
       
       
     //Press the search button
       driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
       
       waitForPageLoad();
       
       Thread.sleep(1000);
       
       
   	
  	 }
  	 
  	 
  	  catch(NoSuchElementException e){
  		  e.getStackTrace();
   }
	 
}

 
 
 
 @Test(priority=23)
 public void FacebookVideoCreation_SupplierLevel() throws InterruptedException{
	 try{
	 //Wait for Add Video Button to be appear
     driver.findElement(By.xpath(Testelements.MediaLibrary_AddVideoButton)).click();
     
   //Wait for Add Video Create Screen to be appear
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoName_TextField)));
     
     Thread.sleep(1000);
     
     //Insert the name for video
     driver.findElement(By.xpath(Testelements.VideoName_TextField)).sendKeys(Testdata.Automation_Facebook);
     
     
     
     WebElement mySelectElement = driver.findElement(By.xpath(Testelements.VideoProductType_Dropdown));
     Select dropdown= new Select(mySelectElement);
    
     dropdown.selectByVisibleText("Supplier");
 
     
     
     //Enter the URL
     driver.findElement(By.xpath(Testelements.VideoURL_TextField)).sendKeys("https://www.facebook.com/AwaamiOfficial/posts/321228728357634");
     
     
     
     driver.findElement(By.xpath(Testelements.VideoDescription)).click();
     
     Thread.sleep(1000);
     //Enter the description
     driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys("Automation Facebook Video");
     
     
     
     //Press the save button
     driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
     
     Thread.sleep(2000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
     	  System.out.println("FaceBook Video Added Sucessfully with Supplier Level Successfully");
     	 test = extent.createTest("FaceBook Video Added with Supplier Level");
        	
        	test.log(Status.PASS, "FaceBook Video Added Sucessfully with Supplier Level Successfully");
      	  
    
    }
    else{
   	   System.out.println("FaceBook Video Added Sucessfully with Supplier Level UnSuccessfully");
   	 test = extent.createTest("FaceBook Video Added Sucessfully with Supplier Level");
    	
    	test.log(Status.FAIL, "FaceBook Video Added Sucessfully with Supplier Level UnSuccessfully");
  	  
     
    
    }
    Thread.sleep(5000); 
     
     
 
 }

 catch(NoSuchElementException e){
	  e.getStackTrace();
 }

 }
 @Test(priority=24)
 public void UpdateFacebook_SupplierLevel() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 //Wait for search 
	 
	 //Wait for the edit button to be appear
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoEdit_Button)));
     
     Thread.sleep(1000);
     
     //Press the edit button
     driver.findElement(By.xpath(Testelements.VideoEdit_Button)).click();
     
     waitForPageLoad();
     
     Thread.sleep(1000);
     
     //Update the description
     driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys(" Updated Facebook description");
     
     
     
     //Press the save button
     driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
     
     Thread.sleep(2000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
     
     test = extent.createTest("FaceBook Video Updated  with Supplier Level");
    	
    	test.log(Status.PASS, "FaceBook Video Updated Sucessfully with Supplier Level");
     }
     else{
    	 
    	 test = extent.createTest("FaceBook Video Updated  with Supplier Level");
     	
     	test.log(Status.FAIL, "FaceBook Video Updated UnSucessfully with Supplier Level");
     }
      
      
     Thread.sleep(5000);
      
  
  }

  catch(NoSuchElementException e){
 	  e.getStackTrace();
  }
     
 
 
 }
 
 @Test(priority=25)
 public void DeleteFaceBook_VideoSupplierLevel() throws InterruptedException{
	 try{
	 //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	 
	 //Search the  youtube video
    driver.findElement(By.xpath(Testelements.SearchVideo_SearchField)).sendKeys("Automation Facebook");
    
    
    
    //Press the search button
    driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    //Press the delete button
    driver.findElement(By.xpath(Testelements.Videos_DeleteButton)).click();
    
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteVideoConfirmButton)));
    
    Thread.sleep(1000);
    
    //PRess the ok button to delete the video
    driver.findElement(By.xpath(Testelements.DeleteVideoConfirmButton)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    
    
    test = extent.createTest("Facebook Video Deleted Supplier Level");

   	test.log(Status.PASS, "Facebook Video with supplier level  Deleted sucessfully");
    }
    else{
    	
    	test = extent.createTest("Facebook Video Deleted Supplier Level");
       	
       	test.log(Status.FAIL, "Facebook Video with supplier level  Deleted unsucessfully");
    }
    
    
   	WebElement toClear = driver.findElement(By.xpath(Testelements.SearchVideo_SearchField));
       toClear.sendKeys(Keys.CONTROL + "a");
       toClear.sendKeys(Keys.DELETE);
       
       
       
     //Press the search button
       driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
       
       waitForPageLoad();
      
       Thread.sleep(1000);

 }

 catch(NoSuchElementException e){
	  e.getStackTrace();
 }
 
 
 }
 @Test(priority=26)
 public void MediaLibraryVideoSanity_YoutubeShareLinkVideo() throws InterruptedException{
	  
	  try{
		  
		
	   //Wait for Add Video Button to be appear
	      driver.findElement(By.xpath(Testelements.MediaLibrary_AddVideoButton)).click();
	      
	    //Wait for Add Video Create Screen to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoName_TextField)));
	      
	      Thread.sleep(1000);
	      
	      //Insert the name for video
	      driver.findElement(By.xpath(Testelements.VideoName_TextField)).sendKeys(Testdata.Automation_Youtube);
	      
	      
	      
	      WebElement mySelectElement = driver.findElement(By.xpath(Testelements.VideoProductType_Dropdown));
	      Select dropdown= new Select(mySelectElement);
	     
	      dropdown.selectByVisibleText("Product");
	  
	      
	      
	      //Enter the URL
	      driver.findElement(By.xpath(Testelements.VideoURL_TextField)).sendKeys("https://youtu.be/_7XJenTvR34");
	      
	      
	      
	      WebElement VideoDescription=driver.findElement(By.xpath(Testelements.VideoDescription));
	      //Enter the description
	      VideoDescription.click();
	      Thread.sleep(1000);
	      VideoDescription.sendKeys("Automation Youtube Share Link Video");
	      
	      
	      
	      //Press the save button
	      driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	      
	      Thread.sleep(1000);
	      
	      if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	      System.out.println("YouTube Video Share Link Added Successfully");
	      test = extent.createTest("MediaLibraryVideoSanity_YoutubeShareLinkVideo");
	      test.log(Status.PASS, "YouTube Video Share Link Added");
	      }
	      else{
	    	  
	    	  System.out.println("YouTube Video Share Link Added UnSuccessfully");
		      test = extent.createTest("MediaLibraryVideoSanity_YoutubeShareLinkVideo");
		      test.log(Status.FAIL, "YouTube Video Share Link Added UnSuccessfully"); 
	      }
	     
	      Thread.sleep(5000);
	  
	      driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 	 
	 	  waitForPageLoad();
	      
	      Thread.sleep(1000);
	  
	 	//Press the delete button
	 	 driver.findElement(By.xpath(Testelements.DeleteVideos_button)).click();
	 	 
	 	 wait = new WebDriverWait(driver, 180);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteVideoConfirmButton)));
	     
	     Thread.sleep(1000);
	     
	     //PRess the ok button to delete the video
	     driver.findElement(By.xpath(Testelements.DeleteVideoConfirmButton)).click();
	     
	     waitForPageLoad();
	     
	     Thread.sleep(1000);
	  
	  }
 
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
 
 
 }
 
@Test(priority=27)
public void AddingVideosOnProductLevel() throws InterruptedException{
	try{
	 
		
		
		
		//Press the manage products tab
    driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
    //Scroll Up
    JavascriptExecutor jse70 = (JavascriptExecutor)driver;
    jse70.executeScript("window.scrollBy(0,-250)", "");
    
    Thread.sleep(3000);
    
    JavascriptExecutor jse71 = (JavascriptExecutor)driver;
    jse71.executeScript("window.scrollBy(-250,-500)", "");
    
    Thread.sleep(1000);
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
     
      
      Thread.sleep(1000);
      
    
  
      //Select the pricing tab for SPG
    
      driver.findElement(By.cssSelector(Testelements.Product_attributes_Tab)).click();
    
     // Wait for attributes to appear
      
      JavascriptExecutor jse8911 = (JavascriptExecutor)driver;
      jse8911.executeScript("window.scrollBy(0,-250)", "");
      
      JavascriptExecutor jse8910 = (JavascriptExecutor)driver;
      jse8910.executeScript("window.scrollBy(-250,-500)", "");
      
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
      
      
      
      WebElement element = driver.findElement(By.xpath(Testelements.ImprintingMethodSelectionAdd));
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click();", element);
     
      waitForPageLoad();
      
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
  	
  	   Thread.sleep(1000);
  	
  	 JavascriptExecutor jse896 = (JavascriptExecutor)driver;
     jse896.executeScript("window.scrollBy(0,-250)", "");
     
     JavascriptExecutor jse897 = (JavascriptExecutor)driver;
     jse897.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(1000);

    //Move to Images tab
  	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
  	
  	waitForPageLoad();
  	
   //Wait for the button to appear
  	 wait = new WebDriverWait(driver, 180);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
          
       
       
       //First store parent window to switch back
       String parentWindow2 = driver.getWindowHandle(); 
       
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
       
       JavascriptExecutor jse891 = (JavascriptExecutor)driver;
       jse891.executeScript("window.scrollBy(0,250)", "");
	   	
      
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
    
    //Scroll Up
    JavascriptExecutor jse709 = (JavascriptExecutor)driver;
    jse709.executeScript("window.scrollBy(0,-250)", "");
    
    Thread.sleep(3000);
    
    JavascriptExecutor jse710 = (JavascriptExecutor)driver;
    jse710.executeScript("window.scrollBy(-250,-500)", "");
    
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
    
    Thread.sleep(7000);
  
    driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
   
   waitForPageLoad();
   
   waitForPageLoad();
   
   Thread.sleep(2000);
  	
  	//Go to images Tab
 	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
 	
 	waitForPageLoad();
 	
 	Thread.sleep(2000);
   	
 	if(driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).getText().equals("Media")){
 		
 		 test = extent.createTest("TextChangesTo_Media_From_Images");
 	    	
 	    	test.log(Status.PASS, "Text Changes Sucessfully from Images to Media");
 		
 	}
 	else{
 		
 		test = extent.createTest("TextChangesTo_Media_From_Images");
     	
     	test.log(Status.FAIL, "Text Changes Unsucessfull from Images to Media");
 		
 	}
    
	
	}
	 catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
   
   
}
@Test(priority=28)
public void ImageUpload_ProductLevel() throws InterruptedException{
	try{
	
		//Press the medialibrary button select image
	       driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	       
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.UploadImages_Button)));
	       
	       Thread.sleep(2000);
		
	       WebElement element = driver.findElement(By.xpath(Testelements.UploadImages_Button));
	       JavascriptExecutor executor = (JavascriptExecutor)driver;
	       executor.executeScript("arguments[0].click();", element);
	       //Press the upload image button
		//driver.findElement(By.xpath(Testelements.UploadImages_Button)).click();
		
		Thread.sleep(2000);
		
		Projectpath=System.getProperty("user.dir");
		System.out.println(Projectpath);
		
		//Uplaod the Image
		driver.findElement(By.xpath(Testelements.SelecImageButton)).sendKeys(Projectpath+"/Images/largesize.jpg");
		
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath(Testelements.InvalidImageSize_Validation_Verification)).getText().contains("exceeds maximum file size of 5MB"))
		{
			System.out.println("Invalid image size validation displayed Successfully");
			
			test = extent.createTest("InvalidImageUpload_ProductLevel_ValidationCheck");
	       	 
       	    test.log(Status.PASS, "Invalid image size validation displayed Successfully");
			
		}
		else{
            System.out.println("Invalid image size validation displayed UnSuccessfully");
			
			test = extent.createTest("InvalidImageUpload_ProductLevel_ValidationCheck");
	       	 
       	    test.log(Status.FAIL, "Invalid image size validation displayed UnSuccessfully");
		}
		
		//Uplaod the Image
		driver.findElement(By.xpath(Testelements.SelecImageButton)).sendKeys(Projectpath+"/Images/MediaLibrary.jpg");
		
		Thread.sleep(2000);
		
		//Press the upload button
		driver.findElement(By.xpath(Testelements.ImageUpload_triggerbutton)).click();
		
		wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ImageFileUpload_Success)));
	
	    waitForPageLoad();
	    
	    Thread.sleep(2000);
	    
	    //Press the Continue button
	    driver.findElement(By.xpath(Testelements.ImageUpload_ContinueButton)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(2000);
	    
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibraryImageUpload_Verification)));
	    
	    Thread.sleep(2000);
	    
	    if(driver.findElement(By.xpath(Testelements.MediaLibraryImageUpload_Verification)).getText().contains("MediaLibrary"))
	    {
	    	System.out.println("Product Level Image Uploaded Successfully");
	    	
	    	test = extent.createTest("ImageUpload_ProductLevel");
       	 
       	    test.log(Status.PASS, "Product Level Image Uploaded Successfully");
	    }
	    else{
            System.out.println("Product Level Image Uploaded UnSuccessfully");
	    	
	    	test = extent.createTest("ImageUpload_ProductLevel");
       	 
       	    test.log(Status.FAIL, "Product Level Image Uploaded UnSuccessfully");
	    }
	
	     Thread.sleep(5000);
	
	}
	
	catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}
@Test(priority=29)
public void ProductLevel_ImageDelete() throws InterruptedException{
	try{
	  
		WebElement HoverImage=driver.findElement(By.xpath(Testelements.MediaLibraryImage_Hover));
	 	Hover(HoverImage);
	 	
	 	Thread.sleep(2000);
	 	
	 	driver.findElement(By.xpath(Testelements.ImageDeleteIcon)).click();
	 	
	 	Thread.sleep(3000);
	 	
	 // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(1000);
        
        alert.accept();
        
        waitForPageLoad();
        
        Thread.sleep(3000);
        
           List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.ImageDeleteVerification));
	       
	       int count=elementcount.size();
	       
	       System.out.println(count);
	       
	       if(count==0)
	       {
	          System.out.println("Product Level Image Deleted Successfully");
	          
	          test = extent.createTest("ProductLevel_ImageDeletion");
	 		   	
	 		 test.log(Status.PASS, "Product Level Image Deleted Successfully");
	     	  
	        }
	       else{
	    	   System.out.println("Product Level Image Deleted UnSuccessfully");
		          
		        test = extent.createTest("ProductLevel_ImageDeletion");
		 		   	
		 	test.log(Status.FAIL, "Media Library Image Deleted UnSuccessfully");
	       }
	 	
	 	
		
	}
	
	
	catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}






@Test(priority=30)	
public void ProductLevel_VirtualizeImage() throws InterruptedException{
	   
	try{
		//Press the medialibrary button select image
	      // driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	       
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ProductLevel_Virtualizelink)));
	       
	       Thread.sleep(1000);
	       
	       //Click the virtualize link to make image virtualize
	       driver.findElement(By.xpath(Testelements.ProductLevel_Virtualizelink)).click();
	       
	       wait = new WebDriverWait(driver, 180);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_AddMask_Button)));
	       
	       Thread.sleep(1000);
	       
	     //Check if the Mask Region Already exist or not
	       List <WebElement> elementcount = driver.findElements(By.xpath(Testelements.MediaLibrary_MaskDeletionButton));
	       
	       int count=elementcount.size();
	       
	       System.out.println(count);
	       
	       if(count>0)
	       {
	           driver.findElement(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)).click();;
	     	  
	     	    Thread.sleep(1000);
	     	  
	           
	       }
	       
	       
	       //Add A mask to virtualize image
	       driver.findElement(By.xpath(Testelements.MediaLibrary_AddMask_Button)).click();
	       
	       Thread.sleep(1000);
	       
	       if(driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).getText().contains("Save"))
	       {
	    	   System.out.println("Mask Region Save Button displayed Successfully at Product Level");
	    	   
	    	   test = extent.createTest("MaskRegion_SaveButton_Verification_ProductLevel");
	    	      
	    	   test.log(Status.PASS, "Mask Region Save Button displayed Successfully at Product Level");
	    	   
	       }
	       else{
	    	   
	             System.out.println("Mask Region Save Button displayed UnSuccessfully at Product Level");
	    	   
	    	   test = extent.createTest("MaskRegion_SaveButton_Verification_ProductLevel");
	    	      
	    	   test.log(Status.FAIL, "Mask Region Save Button displayed UnSuccessfully at Product Level");
	       
	       }
	       //Enter the width and height
	       driver.findElement(By.xpath(Testelements.MediaLibrary_MaskWidth)).sendKeys("50");
	       
	       driver.findElement(By.xpath(Testelements.MediaLibrary_MaskHeight)).sendKeys("100");
	       
	       //Press the save button
	       driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).click();
	       
	       Thread.sleep(1000);
	       
	       //Slect the mask media tags
	       driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).click();
	       
	       //Press the save button
	       driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
	       
	       waitForPageLoad();
	       
	       Thread.sleep(1000);
	        
	        if(driver.findElement(By.xpath(Testelements.ProductLevel_ImageVirtualizationIconVerification)).isDisplayed())
	        {
	        	System.out.println("Image virtualized successfully at Product Level");
	        	 test = extent.createTest("MediaLibrary_VirtualizeImage_ProductLevel");
	    	      test.log(Status.PASS, "Image virtualized successfully at Product Level");
	        	
	        }
	        else{
	        	
	        	System.out.println("Image virtualized unsuccessfully at Product Level");
	       	     test = extent.createTest("MediaLibrary_VirtualizeImage_ProductLevel");
	    	     test.log(Status.FAIL, "Image virtualized unsuccessfully at Product Level");
	        }
		
	}    
    catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
 
}

@Test(priority=31)
public void ProductLevel_CannotVirtualizedImage() throws InterruptedException{
	try{
	//Click the virtualize link to make image virtualize
    driver.findElement(By.xpath(Testelements.ProductLevel_Virtualizelink)).click();
    
    
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)));
    
    Thread.sleep(1000);
    
    
    
    
    //Delete the button
    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)).click();
    
    Thread.sleep(1000);
    
    if(!driver.findElement(By.xpath(Testelements.DeleteMaskRegionArea_Verification)).isDisplayed())
    {
    	System.out.println("Mask Region Deleted Successfully at Product Level");
    	
    	 test = extent.createTest("Mask Region Deletion Product Level");
	      
    	 test.log(Status.PASS, "Image cannot be virtualized successfully at Product Level");
    }
    else{
    	System.out.println("Mask Region Deleted UnSuccessfully at Product Level");
    	
   	 test = extent.createTest("Mask Region Deletion at Product Level");
	      
   	 test.log(Status.FAIL, "Mask Region Deleted UnSuccessfully at Product Level");
    }
    
    	//Check the image cannot be virtualized checkbox
    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)).click();
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
    
    waitForPageLoad();
    
   Thread.sleep(1000);
    
    if(driver.findElement(By.xpath(Testelements.ProductLevel_ImageCannotbeVirtualizedIcon)).isDisplayed())
    {
    	System.out.println("Image cannot be virtualized Successfully at Product Level");
    	 test = extent.createTest("MediaLibrary_ImageCannotVirtualized_ProductLevel");
	      test.log(Status.PASS, "Image cannot be virtualized successfully at Product Level");
    	
    }
    else{
    	
    	System.out.println("Image can be  virtualized at Product Level");
   	     test = extent.createTest("MediaLibrary_ImageCannotVirtualized_ProductLevel");
	     test.log(Status.FAIL, "Image can be virtualized at Product Level");
    }
	}
	  
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}
		
@Test(priority=32)
public void ProductLevel_ImageNotVirtualizd() throws InterruptedException{
	try{
	//Click the virtualize link to make image virtualize
    driver.findElement(By.xpath(Testelements.ProductLevel_Virtualizelink)).click();
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)));
    
    Thread.sleep(1000);

    //Uncheck the Cannot be virtualized checkbox
	 
    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)).click();
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    if(!driver.findElement(By.xpath(Testelements.ProductLevel_ImageCannotbeVirtualizedIcon)).isDisplayed())
    {
    	System.out.println("Image Not virtualized Successfully at Product Level");
    	 test = extent.createTest("MediaLibrary_NotVirtualizedImage_ProductLevel");
	      test.log(Status.PASS, "Image Not virtualized Successfully at Product Level");
    	
    }
    else{
    	
    	System.out.println("Image Not virtualized UnSuccessfully at Product Level");
   	     test = extent.createTest("MediaLibrary_ImageCannotVirtualized_ProductLevel");
	     test.log(Status.FAIL, "Image Not virtualized Successfully at Product Level");
    }
	}
	  
	  catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
	
}
		
@Test(priority=33)
public void CopyMaskRegion() throws InterruptedException{
	try{
	 //Click the virtualize link to make image virtualize
    driver.findElement(By.xpath(Testelements.ProductLevel_Virtualizelink)).click();
    
    wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MediaLibrary_AddMask_Button)));
    
    Thread.sleep(1000);
    
    
    //Add A mask to virtualize image
    driver.findElement(By.xpath(Testelements.MediaLibrary_AddMask_Button)).click();
    
    Thread.sleep(1000);
    
    
    //Enter the width and height
    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskWidth)).sendKeys("50");
    
    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskHeight)).sendKeys("100");
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).click();
    
    Thread.sleep(1000);
    
    //Slect the mask media tags
    driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).click();
    
    //Press the save button
    driver.findElement(By.xpath(Testelements.MediaLibrary_SaveVirtualize)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    //Select the images to upload
    driver.findElement(By.cssSelector(Testelements.MediaLibrary_Image1)).click();
    
    
     //Confirm the images uploading details
    driver.findElement(By.cssSelector(Testelements.MediaLibrary_Popup_Confirmbutton)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
  //Scroll Up
    JavascriptExecutor jse70 = (JavascriptExecutor)driver;
    jse70.executeScript("window.scrollBy(0,-250)", "");
    
    
    
    JavascriptExecutor jse71 = (JavascriptExecutor)driver;
    jse71.executeScript("window.scrollBy(-250,-500)", "");
    
    Thread.sleep(1000);
    
    //Press the copy mask region
    driver.findElement(By.xpath(Testelements.CopyMaskRegionButton)).click();
    
    Thread.sleep(1000);
    
    //Press the radio button for image which we want to copy
    driver.findElement(By.xpath(Testelements.CopyMaskImageSelection)).click();
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(Testelements.CopyMaskSelectImageButton)).click();
    
    Thread.sleep(1000);
    
    //copy virtualization into other image 
    driver.findElement(By.xpath(Testelements.CopyRegionToanotherImageCheckbox)).click();
    
    Thread.sleep(1000);
    
    //Now complete the copy process
    driver.findElement(By.xpath(Testelements.CopyMaskregionButton)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.xpath(Testelements.CopyMaskRegionVerification)).isDisplayed())
    {
    	System.out.println("Copy Mask Region successfull");
    	
    	 test = extent.createTest("CopyMaskRegions");
	     
    	 test.log(Status.PASS, "Copy Mask Region Successfull");
    }
    else{
    	
    	System.out.println("Copy Mask Region unsuccessfull");
    	
   	 test = extent.createTest("CopyMaskRegions");
	     
   	 test.log(Status.FAIL, "Copy Mask Region unsuccessfull");
    }
     
    
	
}    
catch(NoSuchElementException e){
	  e.getStackTrace();
}

}
@Test(priority=34)
public void DeletingCopyMaskRegions() throws InterruptedException{
	try{
	//Press the delete Copy Mask region
	driver.findElement(By.xpath(Testelements.DeleteMaskRegionButton)).click();
	
	Thread.sleep(1000);
	
	//press image check box
	driver.findElement(By.xpath(Testelements.DeleteMaskFromImageCheckbox)).click();
	
	Thread.sleep(1000);
	
	//Press the delete MAsk region button
	driver.findElement(By.xpath(Testelements.DeleteMaskRegionsButton)).click();
	
	Thread.sleep(2000);
	
	 if(!driver.findElement(By.xpath(Testelements.CopyMaskRegionVerification)).isDisplayed())
	    {
	    	System.out.println("Delete Mask Region successfull");
	    	
	    	 test = extent.createTest("DeleteMaskRegions");
		     
	    	 test.log(Status.PASS, "Delete Mask Region Successfull");
	    }
	    else{
	    	
	    	System.out.println("Delete Mask Region unsuccessfull");
	    	
	   	 test = extent.createTest("DeleteMaskRegions");
		     
	   	 test.log(Status.FAIL, "Delete Mask Region unsuccessfull");
	    }
	}    
	catch(NoSuchElementException e){
		  e.getStackTrace();
	}
}
		
@Test(priority=35)
public void VirtualizeTag_ManageImages() throws InterruptedException
{
	try{
	//Press the Virtualize tag on image Level
	driver.findElement(By.xpath(Testelements.VirtualizeTag_ManageImages)).click();
	
	Thread.sleep(2000);
	
	//Add Region for particular image
	
	 driver.findElement(By.xpath(Testelements.MediaLibrary_AddMask_Button)).click();
	    
	    Thread.sleep(2000);
	    
	    
	    //Enter the width and height
	    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskWidth)).sendKeys("50");
	    
	    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskHeight)).sendKeys("100");
	    
	    //Press the save button
	    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskSavingButton)).click();
	    
	    Thread.sleep(1000);
	    
	    //Slect the mask media tags
	    driver.findElement(By.xpath(Testelements.MediaLibrary_MediaTags_VirtualizeScreen)).click();
	    
	    //Press the Apply Button
	    driver.findElement(By.xpath(Testelements.VirtualizeTag_ApplyButton)).click();
	    
        driver.findElement(By.xpath(Testelements.VirtualizeTag_BackButton)).click();
	    
	    Thread.sleep(2000);
	    
	    if(driver.findElement(By.xpath(Testelements.CopyMaskRegionVerification)).isDisplayed())
	    {
	    	System.out.println("Virtualize Tag Added successfull and made image virtualize");
	    	
	    	 test = extent.createTest("Virtualize Tag/Virtualize Image");
		     
	    	 test.log(Status.PASS, "Virtualize Tag Added successfull and made image virtualize");
	    }
	    else{
	    	
	    	System.out.println("Virtualize Tag Added unsuccessfull and made image virtualize");
	    	
	   	 test = extent.createTest("Virtualize Tag/Virtualize Image");
		     
	   	 test.log(Status.FAIL, "Virtualize Tag Added unsuccessfull and made image virtualize");
	    }
	}    
	catch(NoSuchElementException e){
		  e.getStackTrace();
	}   
}

@Test(priority=36)
public void CannotVirtualize_ManageImages() throws InterruptedException{
	
	try{
	//Press the Virtualize tag on image Level
		driver.findElement(By.xpath(Testelements.VirtualizeTag_ManageImages)).click();
		
		Thread.sleep(2000);
		
    //	Make Image Cannotbe virtualized
	    driver.findElement(By.xpath(Testelements.MediaLibrary_MaskDeletionButton)).click();
	    
	    Thread.sleep(1000);
	    
	  	//Check the image cannot be virtualized checkbox
	    driver.findElement(By.xpath(Testelements.MediaLibrary_ImageCannotbevirtualize_Checkbox)).click();
	    
	    //Press the Apply Button
	    driver.findElement(By.xpath(Testelements.VirtualizeTag_ApplyButton)).click();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.VirtualizeTag_BackButton)).click();
	    
	    Thread.sleep(2000);
	    
	    
	    if(driver.findElement(By.xpath(Testelements.CannotVirtualizeImageIcon_ManageImage_Verification)).isDisplayed())
	    {
	    	System.out.println("Cannot Virtualize Tag Added successfull");
	    	
	    	 test = extent.createTest("Virtualize Tag/CannotVirtualize Image");
		     
	    	 test.log(Status.PASS, "Cannot Virtualize Tag Added successfull");
	    }
	    else{
	    	
	    	System.out.println("Cannot Virtualize Tag Added unsuccessfull");
	    	
	   	 test = extent.createTest("Virtualize Tag/CannotVirtualize Image");
		     
	   	 test.log(Status.FAIL, "Cannot Virtualize Tag Added unsuccessfull");
	    }
	
	//Exit from product
	    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	 
	    //Delete the changes
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteChanges)));
	    
	    Thread.sleep(2000);
	   
	    //Active the product
	    driver.findElement(By.xpath(Testelements.DeleteChanges)).click();
	    
	    Thread.sleep(1000);
	    
	    //Press the Yes button to complete the process
	    driver.findElement(By.xpath(Testelements.DeletechangesConfirm)).click();
	    
	    
	    
	}
	   
	catch(NoSuchElementException e){
		  e.getStackTrace();
	}     
}

@Test(priority=37)
public void YoutubeVideo_ProductLevel() throws InterruptedException{

//Wait for Add Video Button to be appear
	      try{
	    	  
	  
	    wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));	
	    
	    Thread.sleep(2000);
	    	  
	     driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
	    	    
	   waitForPageLoad();
	   
	   Thread.sleep(2000);
	   
	   waitForPageLoad();
	   
	   Thread.sleep(2000);
	    	    
	 //Go to images Tab
	    driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
	    
	  //Wait for Add Video Create Screen to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));		
	    
	      Thread.sleep(1000);
	      
	      driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	      
	      waitForPageLoad();
	      
	      Thread.sleep(1000);
	      
          waitForPageLoad();
	      
	      Thread.sleep(2000);
	      
	    //Press the videos Tab
	      driver.findElement(By.xpath(Testelements.MediaLibrary_VideosTab)).click();
	
	      
	      
	      driver.findElement(By.xpath(Testelements.MediaLibrary_AddVideoButton)).click();
	      
	    //Wait for Add Video Create Screen to be appear
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoName_TextField)));
	      
	      Thread.sleep(1000);
	      
	      //Insert the name for video
	      driver.findElement(By.xpath(Testelements.VideoName_TextField)).sendKeys(Testdata.Automation_Youtube);
	      
	      
	      
	      
	      
	      //Enter the URL
	      driver.findElement(By.xpath(Testelements.VideoURL_TextField)).sendKeys("https://www.youtube.com/watch?v=njkSX6cyVLM");
	      
	      
	      
	      //Enter the description
	      driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys("Automation Youtube Video");
	      
	      
	      
	      //Press the save button
	      driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
	      
	      Thread.sleep(2000);
	      
	      if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	      
	      
	      
	      test = extent.createTest("AddingVideosOnProductLevel");
	    	
	    	test.log(Status.PASS, "Youtube Video Added Sucessfully from Product Level media library video Section");
	  	  
	      }
	      else{
	    	  
	    	  test = extent.createTest("AddingVideosOnProductLevel");
		    	
		    	test.log(Status.FAIL, "Youtube Video Added UnSucessfully from Product Level media library video Section");
	    	  
	      }
	      }
	      
	      catch(NoSuchElementException e){
			  e.getStackTrace();
		}  
	
	   
	    }
	  
	 

	 
 
@Test(priority=38)
public void VideosSearch_ProductLevelMediaLibrary() throws InterruptedException{
	try{
	//Press the back button
		 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
		 
		 waitForPageLoad();
		 
		 Thread.sleep(1000);
		 
		 //Search the  youtube video
	    driver.findElement(By.xpath(Testelements.SearchVideo_SearchField)).sendKeys("Automation Youtube");
	    
	   
	    
	    //Press the search button
	    driver.findElement(By.xpath(Testelements.SearchVideo_SearchButton)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
	    if(driver.findElement(By.xpath(Testelements.AutomationYoutubeValidation_Search)).isDisplayed()){
	    test = extent.createTest("Youtube video Search from media library Product level");
	   	
	   	test.log(Status.PASS, "Youtube video Search from media library Product level Successfully");
	    }
	    else{
	    	 test = extent.createTest("Youtube video Search from media library Product level");
	 	   	
	 	   	test.log(Status.FAIL, "Youtube video Search from media library Product level Unsuccessfull");
	    }
	  	 }
	  	 
	  	 
	  	  catch(NoSuchElementException e){
	  		  e.getStackTrace();
	   }
	      
	 	 
	  }

@Test(priority=39)
public void MediaLibraryProductLevel_UpdateVideo() throws InterruptedException{
	try{
	 //Press the edit button
    driver.findElement(By.xpath(Testelements.VideoEdit_Button)).click();
    
    waitForPageLoad();
    
    Thread.sleep(1000);
    
    //Update the description
    driver.findElement(By.xpath(Testelements.VideoDescription)).sendKeys(" Updated Youtube description");
    
    
    
  //Press the save button
    driver.findElement(By.xpath(Testelements.Video_SaveButton)).click();
    
    Thread.sleep(2000);
    
    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
    	

   	 test = extent.createTest("Youtube video update from media library product level");
   	   
   	   	test.log(Status.PASS, "Youtube video update from media library product level Successfully ");
    }
    else{
    	
    	 test = extent.createTest("Youtube video update from media library product level");
    	   	
    	   	test.log(Status.FAIL, "Youtube video update from media library product level Unsuccessfull");
    }
    
    Thread.sleep(1000);
    //Press the back button
	 driver.findElement(By.xpath(Testelements.Videos_Back_Button)).click();
	 
	 waitForPageLoad();
	 
	 Thread.sleep(1000);
	
	
	
	}
    catch(NoSuchElementException e){
		  e.getStackTrace();
 }
    
	 


}

@Test(priority=40)
public void VideoIntegrationWithProduct_FromMediaLibraryProductLevel() throws InterruptedException{
	try{
	//Press the radio button 
	driver.findElement(By.xpath(Testelements.VideoIntegrationToProduct)).click();
	
	Thread.sleep(1000);
	
	//Press the media selected button
	driver.findElement(By.xpath(Testelements.SelectedMediaButtonSelection)).click();
	
	Thread.sleep(2000);
	
	 if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
		 
		   test = extent.createTest("VideoIntegrationWithProduct_FromMediaLibraryProductLevel");
		   	
		   	test.log(Status.PASS, "Video Integrate with Product from Media Library at product Level successfully");
	   }
	   else{
		   
		   test = extent.createTest("VideoIntegrationWithProduct_FromMediaLibraryProductLevel");
		   	
		   	test.log(Status.FAIL, "Video Integrate with Product from Media Library at product Level unsuccessfully");
	   }
	
	
  
 //First store parent window to switch back
  // String parentWindow = driver.getWindowHandle();

//Press the preview button for video preview
   driver.findElement(By.xpath(Testelements.PreviewVideoButton)).click();
   
   
   wait = new WebDriverWait(driver, 180);
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.VideoPreview)));
   
   Thread.sleep(2000);
   

 	if(driver.findElement(By.xpath(Testelements.VideoPreview)).isDisplayed()){
 		System.out.println("Youtube video play succesfully in new tab");
 		test = extent.createTest("Video Preview");
 	  	
 	  	test.log(Status.PASS, "Video Preview Successfully displayed in new browser window ");
 	
 	}
 	else{
 		
 		System.out.println("Youtube video play succesfully in new tab");
 		test = extent.createTest("Video Preview");
 	  	test.log(Status.FAIL, "Video Preview Successfully displayed in new browser window ");
 	}
 	
 	   //Close the Preview video
 	  driver.findElement(By.xpath(Testelements.ClosePreview)).click();
 	  
 	 
 	  
 	  //driver.close();
  	
 	  Thread.sleep(2000);
  	
 	 
 	  
 	  
 	  //Switch back to parent window 
      //driver.switchTo().window(parentWindow);
   
      
   
	
	
	
	}
catch(NoSuchElementException e){
	  e.getStackTrace();
}



}
 
@Test(priority=41)
public void DeleteVideo_FromMediaLibrary_AtProductLevel() throws InterruptedException{
	try{
	 
     //Remove the Diassociate the video from product
     driver.findElement(By.cssSelector(Testelements.DiassociatevideoFromProduct)).click();
     
     Thread.sleep(1000);
     
     
     //Scroll Up
     JavascriptExecutor jse70 = (JavascriptExecutor)driver;
     jse70.executeScript("window.scrollBy(0,-250)", "");
     
     Thread.sleep(3000);
     
     JavascriptExecutor jse71 = (JavascriptExecutor)driver;
     jse71.executeScript("window.scrollBy(-250,-500)", "");
     
     Thread.sleep(1000);
     
     //Press the media library button
	    driver.findElement(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
	  //Press the videos Tab
	      driver.findElement(By.xpath(Testelements.MediaLibrary_VideosTab)).click();
	      
	 //Search the youtube video at product level and delete it
	          
	      wait = new WebDriverWait(driver, 180);
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Videos_DeleteButton)));  
	      
	      Thread.sleep(2000);
		    
		    //Press the delete button 
		    driver.findElement(By.xpath(Testelements.Videos_DeleteButton)).click();
		    
		    wait = new WebDriverWait(driver, 180);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteVideoConfirmButton)));
		    
		    Thread.sleep(1000);
		    
		    //Press the ok button to delete the video
		    driver.findElement(By.xpath(Testelements.DeleteVideoConfirmButton)).click();
		    
		    Thread.sleep(2000);
		    
		    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
		    
		    test = extent.createTest("Remove video from media library at Product Level");
		  	
		  	test.log(Status.PASS, "Remove video from media library at Product Level Sucessfully ");
		    }
		    else{
		    	
		    	test = extent.createTest("Remove video from media library at Product Level");
			  	
			  	test.log(Status.FAIL, "Remove video from media library at Product Level UnSucessfully ");
		    }
			Thread.sleep(2000);
			
			}
		catch(NoSuchElementException e){
			  e.getStackTrace();
		}   


}
 
 @Test(priority=42)
 public void SaveChanges_AfterVideoProductLevelSanity() throws InterruptedException{
	 
	 try{
	 //Press the cancel button
	 driver.findElement(By.xpath(Testelements.MediaLevelVideoCancelButton)).click();
	 
	 Thread.sleep(2000);
	 
	 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
	    
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
   
  
	Thread.sleep(2000);
	
    //Make chnages Active
   driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
  
   //Wait for the button to appear
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
     
    if(driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).isDisplayed()){
    	
    	driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
    	
    	 test = extent.createTest("SaveChanges_AfterVideoProductLevelSanity");
 	  	
 	  	test.log(Status.PASS, "Changes saved Sucessfully after videos Product Level Sanity ");
 		
    	
    }
    else{
    	 test = extent.createTest("SaveChanges_AfterVideoProductLevelSanity");
  	  	
  	  	test.log(Status.FAIL, "Changes saved UnSucessfully after videos Product Level Sanity ");
  		
    	
    }
     
     Thread.sleep(8000);
	
    
	 
	 
	 }
	catch(NoSuchElementException e){
		  e.getStackTrace();
	}   

 }
 
 @Test(priority=43)
 public void ToggleAPI_AtSupplierLevel() throws InterruptedException{
	 try{
	 //Press the EIT Manager Tab
	 driver.findElement(By.xpath(Testelements.EITDashboardButton)).click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EIT_IntegrationTab)));
     
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(Testelements.EIT_IntegrationTab)).click();
     
     wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Integration_OperationDropdown)));
     
     Thread.sleep(1000);
     
     WebElement mySelectElement21 = driver.findElement(By.xpath(Testelements.Integration_OperationDropdown));
     Select dropdown21= new Select(mySelectElement21);
    
     dropdown21.selectByVisibleText("Enable / Disable APIs");
     
     Thread.sleep(2000);
     
     driver.findElement(By.xpath(Testelements.Integration_SupplierSearch_TextField)).sendKeys("30232");
     
     
     
     driver.findElement(By.xpath(Testelements.SearchSupplier_Integration_SearchButton)).click();
     
    
     
     waitForPageLoad1();
     
     //Click the supplier
     driver.findElement(By.xpath(Testelements.Integration_SupplierSelection)).click();
     
    
     waitForPageLoad1();
     
     driver.findElement(By.xpath(Testelements.ChangeSettings_Integration)).click();
     
     Thread.sleep(2000);
     
     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
     
     test = extent.createTest("InventoryAPI FLag Change");
	  	
	  	test.log(Status.PASS, "Inventory Api flag changes to NO sucessfully ");
     }
     else{
    	 
    	 test = extent.createTest("InventoryAPI FLag Change");
 	  	
 	  	test.log(Status.FAIL, "Inventory Api flag changes to NO unsucessfully ");
    	 
     }
	 //Download the export flag products reports
	  	driver.findElement(By.xpath(Testelements.ExportProductFlag_Download)).click();
	  	
	  	Thread.sleep(5000);
		
	  	File getLatestFile = getLatestFilefromDir(Testdata.downloadPath);
		 String fileName = getLatestFile.getName();
		 
		 if(fileName.contains("EITProductAPIFlags")){
			 System.out.println("Download the export flag product report sucessfully");
			 
			 test = extent.createTest("Export_FlagProduct Report Downlaod");
			 
			 test.log(Status.PASS, "Download the export flag product report sucessfully"); 
		 }
		 else{
			 System.out.println("Download the export flag product report unsucessfully");
			 
			 test = extent.createTest("Export_FlagProduct Report Downlaod");
			 
			 test.log(Status.FAIL, "Download the export flag product report unsucessfully");
		 }
	  	  
	 
	 }
	catch(NoSuchElementException e){
		  e.getStackTrace();
	}   
    finally{
    	driver.get(Testdata.VelocityURL);
    	
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
        
        driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
        
    }
     
 }
	 @Test(priority=44,groups="Catalog")
	 public void AddCatalog_WithDocFile() throws InterruptedException{
		 try{
    
	      
			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogandComp_Tab)));
			 
		     Thread.sleep(2000);
		     
		     driver.findElement(By.xpath(Testelements.CatalogandComp_Tab)).click();
		     
		     
		     wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddCatalogButton)));
			 
		     Thread.sleep(2000);
			 
			 //Press the Add Catalog Button
			 driver.findElement(By.xpath(Testelements.AddCatalogButton)).click();
			 
			 Thread.sleep(2000);
			 
		//Insert the catlog name
			 driver.findElement(By.id(Testelements.AddCatalog_CatalogNameField)).sendKeys(Testdata.CatalogName);
			 
		//Press the Language dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_SelectLanguage_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_LanguageSelection)).click();
			 
	    //Press the currency dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_Currency_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_CurrencySelection)).click();
			 
			 Projectpath=System.getProperty("user.dir");
			 System.out.println(Projectpath);
				
				
			 //Upload the file
			 driver.findElement(By.xpath(Testelements.UploadCatalog_Button)).sendKeys(Projectpath+"/Images/DocP.docx");
			 
			 Thread.sleep(4000);
			 
	  //Enter the E-URL and E-Masked URL
			 driver.findElement(By.xpath(Testelements.ECatalog_URLField)).sendKeys(Testdata.EcatalogURL);
			 
			 driver.findElement(By.xpath(Testelements.EMasked_URLField)).sendKeys(Testdata.EmaskedURL);
			 
			 Thread.sleep(3000);
			 
			 WebElement element = driver.findElement(By.xpath(Testelements.CatalogSave_Button));
		      JavascriptExecutor executor = (JavascriptExecutor)driver;
		      executor.executeScript("arguments[0].click();", element);
		      
		      Thread.sleep(2000);
			 
			 //driver.findElement(By.xpath(Testelements.CatalogSave_Button)).click();
			 
			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogCreate_Verification)));
		     
		     Thread.sleep(2000);
		     
		     waitForPageLoad();
		     
             Thread.sleep(2000);
		     
		     waitForPageLoad();
		     
		     if(driver.findElement(By.xpath(Testelements.CatalogCreate_Verification)).getText().contains(Testdata.CatalogName))
		     {
		    	 System.out.println("Catalog Added with doc file Successfully");
		    	 
		    	 test = extent.createTest("AddCatalog_WithDocFile");
				 
				 test.log(Status.PASS, "Catalog Added with doc file Successfully");
		    	 
		     }
		     
		     else{
		    	 System.out.println("Catalog Added with doc file Unsuccessfull");
		     
		    	 test = extent.createTest("AddCatalog_WithDocFile");
				 
				 test.log(Status.FAIL, "Catalog Added with doc file Unsuccessfull");
		     }
			 
		 
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 }
	 
	 @Test(priority=45,groups="Catalog")
	 public void EditCatalog() throws InterruptedException{
		 try{
    
	      //Press the Edit Button
			 driver.findElement(By.xpath(Testelements.EditCatalogButton)).click();
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(Testelements.EditCatalog_NameField)).click();
			 
			 driver.findElement(By.xpath(Testelements.EditCatalog_NameField)).sendKeys(Testdata.UpdatedCatalogName);
			 
			 //change the End year
			 WebElement mySelectElement70 = driver.findElement(By.xpath(Testelements.EditCatalog_EndYear_Dropdown));
		      Select dropdown70= new Select(mySelectElement70);
		     
		      dropdown70.selectByVisibleText("2021");
		      
		      Thread.sleep(1000);
		      
		      //Press the save button
		      
		      WebElement element = driver.findElement(By.xpath(Testelements.EditCatalog_SaveButton));
		      JavascriptExecutor executor = (JavascriptExecutor)driver;
		      executor.executeScript("arguments[0].click();", element);
		      
		      Thread.sleep(2000);
		      
		      //driver.findElement(By.xpath(Testelements.EditCatalog_SaveButton)).click();
		      
		      wait = new WebDriverWait(driver, 180);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogCreate_Verification)));
			     
			  Thread.sleep(2000);
			     
			  waitForPageLoad();
			  
			  if(driver.findElement(By.xpath(Testelements.CatalogCreate_Verification)).getText().contains(Testdata.UpdatedCatalogName) & driver.findElement(By.xpath(Testelements.CatalogEndDate_Verification_AfterSaving)).getText().contains("2021"))
			     {
			    	 System.out.println("Catalog Updated Successfully");
			    	 
			    	 test = extent.createTest("UpdateCatalog_WithDocFile");
					 
					 test.log(Status.PASS, "Catalog Updated Successfully");
			    	 
			     }
			     
			     else{
			    	 System.out.println("Catalog Updated with doc file Unsuccessfull");
			     
			    	 test = extent.createTest("UpdateCatalog_WithDocFile");
					 
					 test.log(Status.FAIL, "Catalog Updated with doc file Unsuccessfull");
			     }
			
		 
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 } 
     @Test(priority=46,groups="Catalog")
	 public void DeleteCatalog() throws InterruptedException, AWTException{
		 try{
    
	      //Press the Delete button
			 driver.findElement(By.xpath(Testelements.DeleteCatalog)).click();
			 
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath(Testelements.DeleteCatalogConfirm)).click();
			 
			 waitForPageLoad();
			 
			 Thread.sleep(2000);
			 
	         if(!driver.findElement(By.xpath(Testelements.CatalogCreate_Verification)).getText().contains(Testdata.UpdatedCatalogName))
	         {
	        	 System.out.println("Catalog Deleted Successfully");
	        	 
	        	 test = extent.createTest("DeleteCatalog");
				 
				 test.log(Status.PASS, "Catalog Deleted Successfully");
	         }
	         else{
                 System.out.println("Catalog Deleted UnSuccessfully");
	        	 
	        	 test = extent.createTest("DeleteCatalog");
				 
				 test.log(Status.PASS, "Catalog Deleted UnSuccessfully");
	         }
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 } 

     @Test(priority=47,groups="Catalog")
	 public void AddCatalog_WithURLLink() throws InterruptedException{
		 try{
    
	         wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddCatalogButton)));
			 
		     Thread.sleep(2000);
			 
			 //Press the Add Catalog Button
			 driver.findElement(By.xpath(Testelements.AddCatalogButton)).click();
			 
			 Thread.sleep(2000);
			 
		//Insert the catlog name
			 driver.findElement(By.id(Testelements.AddCatalog_CatalogNameField)).sendKeys(Testdata.CatalogName);
			 
		//Press the Language dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_SelectLanguage_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_LanguageSelection)).click();
			 
	    //Press the currency dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_Currency_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_CurrencySelection)).click();
			 
	         driver.findElement(By.xpath(Testelements.AddCatalog_Option_ByLink_RadioButton)).click();
	         
	         Thread.sleep(1000);
	         
	         driver.findElement(By.xpath(Testelements.OnlineCatalogURL_Field)).sendKeys(Testdata.EcatalogURL);
	         
	         Thread.sleep(1000);
			 
	  //Enter the E-URL and E-Masked URL
			 driver.findElement(By.xpath(Testelements.ECatalog_URLField)).sendKeys(Testdata.EcatalogURL);
			 
			 //driver.findElement(By.xpath(Testelements.EMasked_URLField)).sendKeys(Testdata.EmaskedURL);
			 
			 Thread.sleep(3000);
			 
			 WebElement element = driver.findElement(By.xpath(Testelements.SaveButton_WithUrlLink));
		      JavascriptExecutor executor = (JavascriptExecutor)driver;
		      executor.executeScript("arguments[0].click();", element);
		      
		      Thread.sleep(2000);
			 
			 //driver.findElement(By.xpath(Testelements.CatalogSave_Button)).click();
			 
			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogCreate_Verification)));
		     
		     Thread.sleep(2000);
		     
		     waitForPageLoad();
		     
		     if(driver.findElement(By.xpath(Testelements.CatalogCreate_Verification)).getText().contains(Testdata.CatalogName) & driver.findElement(By.xpath(Testelements.OnlineUrl_Link_Verification)).isDisplayed())
		     {
		    	 System.out.println("Catalog Added with With Online Url Successfully");
		    	 
		    	 test = extent.createTest("AddCatalog_WithOnlineUrl");
				 
				 test.log(Status.PASS, "Catalog Added with With Online Url Successfully");
		    	 
		     }
		     
		     else{
		    	 System.out.println("Catalog Added with With Online Url Unsuccessfull");
		     
		    	 test = extent.createTest("AddCatalog_WithOnlineUrl");
				 
				 test.log(Status.FAIL, "Catalog Added with With Online Url Unsuccessfull");
		     }
			 
		 
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 
 }

     @Test(priority=48,groups="Catalog")
	 public void AssigningCatalog_AtProductLevel() throws InterruptedException{
		 try{
    
	         wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddCatalogButton)));
			 
		     Thread.sleep(2000);
			 
			 //Press the Add Catalog Button
			 driver.findElement(By.xpath(Testelements.AddCatalogButton)).click();
			 
			 Thread.sleep(2000);
			 
		//Insert the catlog name
			 driver.findElement(By.id(Testelements.AddCatalog_CatalogNameField)).sendKeys(Testdata.UpdatedCatalogName);
			 
		//Press the Language dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_SelectLanguage_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_LanguageSelection)).click();
			 
	    //Press the currency dropdown
			 driver.findElement(By.xpath(Testelements.AddCatalog_Currency_Dropdown)).click();
			 
			 driver.findElement(By.xpath(Testelements.AddCatalog_CurrencySelection)).click();
			 
	         driver.findElement(By.xpath(Testelements.AddCatalog_Option_ByLink_RadioButton)).click();
	         
	         Thread.sleep(1000);
	         
	         driver.findElement(By.xpath(Testelements.OnlineCatalogURL_Field)).sendKeys(Testdata.EcatalogURL);
	         
	         Thread.sleep(1000);
			 
	  //Enter the E-URL and E-Masked URL
			 driver.findElement(By.xpath(Testelements.ECatalog_URLField)).sendKeys(Testdata.EcatalogURL);
			 
			 //driver.findElement(By.xpath(Testelements.EMasked_URLField)).sendKeys(Testdata.EmaskedURL);
			 
			 Thread.sleep(3000);
			 
			 WebElement element = driver.findElement(By.xpath(Testelements.SaveButton_WithUrlLink));
		      JavascriptExecutor executor = (JavascriptExecutor)driver;
		      executor.executeScript("arguments[0].click();", element);
		      
		      Thread.sleep(2000);
			 
			 //driver.findElement(By.xpath(Testelements.CatalogSave_Button)).click();
			 
			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.CatalogCreate_Verification)));
		     
		     Thread.sleep(2000);
		     
		     waitForPageLoad();
		     
		     
		   //Click the manage product tab
			driver.findElement(By.xpath(Testelements.Manage_Product_Tab)).click();
			  	
			 wait = new WebDriverWait(driver, 180);
		     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
		     
		     Thread.sleep(2000);
  	
			driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
			
			waitForPageLoad();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Testelements.ProductLevel_CatalogSelection_Dropdown)).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Testelements.CatalogSelection_ProductLevel)).click();
			
			//Select the 2nd Catalog from dropdown list
			driver.findElement(By.xpath(Testelements.Add_AdditionalCatalog_Button)).click();
			
			Thread.sleep(1000);
			
            driver.findElement(By.xpath(Testelements.ProductLevel_CatalogSelection_Dropdown)).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Testelements.CatalogSelection_ProductLevel)).click();
			
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath(Testelements.AddedCatalog_Verification1)).getText().contains(Testdata.CatalogName) & driver.findElement(By.xpath(Testelements.AddedCatalog_Verification2)).getText().contains(Testdata.UpdatedCatalogName) )
			{
				System.out.println("Catalog Assign at Product Level Successfully");
				
				test = extent.createTest("CatalogAssign_AtProductLevel_Verification");
				 
				test.log(Status.PASS, "Catalog Assign at Product Level Successfully");
				
			}
			else{
                System.out.println("Catalog Assign at Product Level UnSuccessfully");
				
				test = extent.createTest("CatalogAssign_AtProductLevel_Verification");
				 
				test.log(Status.FAIL, "Catalog Assign at Product Level UnSuccessfully");
			}
			
			
			
		     
		 
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 
 }  
     @Test(priority=49,groups="Catalog")
	 public void CatalogRankingSwitching_AtProductLevel() throws InterruptedException{
		 try{
           //before ranking Switching
	        String Postion1_Catalog_before=driver.findElement(By.xpath(Testelements.AddedCatalog_Verification1)).getText();
	        System.out.println(Postion1_Catalog_before);
	        
	        String Postion2_Catalog_before=driver.findElement(By.xpath(Testelements.AddedCatalog_Verification2)).getText();
	        System.out.println(Postion2_Catalog_before);
			
	        Actions act=new Actions(driver);
		    //1st Media tagging  
		   // find element which we need to drag
		   WebElement drag=driver.findElement(By.xpath(Testelements.DragCatalog));
		    
		    // find element which we need to drop
		   WebElement drop=driver.findElement(By.xpath(Testelements.DropCatalog));
		    
		   // this will drag element to destination
		   act.dragAndDrop(drag, drop).build().perform();
		    
		   Thread.sleep(3000);
		   
		   
		  driver.findElement(By.xpath(Testelements.SaveButton_ProductCreation)).click();
		   
		   waitForPageLoad();
		   
		   Thread.sleep(2000);
		   
		 //After ranking Switching
	        String Postion1_Catalog_After=driver.findElement(By.xpath(Testelements.AddedCatalog_Verification1)).getText();
	        System.out.println(Postion1_Catalog_After);
	        
	        String Postion2_Catalog_After=driver.findElement(By.xpath(Testelements.AddedCatalog_Verification2)).getText();
	        System.out.println(Postion2_Catalog_After);
	        
	        if(Postion1_Catalog_After.contains(Testdata.UpdatedCatalogName) & Postion2_Catalog_After.contains(Testdata.CatalogName) & driver.findElement(By.xpath(Testelements.DefaultCatalog_Text_Verification)).getText().contains("Default"))
	        {
	        	System.out.println("Switching of Catalog Ranking done at Product Level Successfully");
	        	
	        	test = extent.createTest("CatalogRankingSwitching_AtProductLevel_WithDefaultCatalogText");
				 
				test.log(Status.PASS, "Switching of Catalog Ranking done at Product Level Successfully");
	        	
	        }
	        else{
                System.out.println("Switching of Catalog Ranking done at Product Level UnSuccessfully");
	        	
	        	test = extent.createTest("CatalogRankingSwitching_AtProductLevel_WithDefaultCatalogText");
				 
				test.log(Status.FAIL, "Switching of Catalog Ranking done at Product Level UnSuccessfully");
	        }
		   
		     
		 
		 }catch(NoSuchElementException e)
		 {
			 e.getStackTrace();
		 }
 

	 
 }   
     @Test(priority=50,groups="Catalog")
	 public void CatalogDetails_Verification_OnManageProductsScreen() throws InterruptedException{
		 try{
          
			 driver.findElement(By.xpath(Testelements.EnterPageNumber_DefaultCatalog)).sendKeys("7");
			 
			 driver.findElement(By.xpath(Testelements.DefaultCatalog_Text_Verification)).click();
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
		      
		     Thread.sleep(3000);
		 
		      
		       wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
		     
		      
		  		Thread.sleep(4000);
		  	
		      //Make chnages Active
		     driver.findElement(By.cssSelector(Testelements.MakeChangesActive)).click();
		    
		     //Wait for the button to appear
		  	 wait = new WebDriverWait(driver, 180);
		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive_Confirm)));
		       
		       driver.findElement(By.cssSelector(Testelements.MakeChangesActive_Confirm)).click();
		       
		       
		  		Thread.sleep(10000);
		      
		      if(driver.findElement(By.xpath(Testelements.CatalogName_ManageProducts_Verification)).getText().contains(Testdata.UpdatedCatalogName) & driver.findElement(By.xpath(Testelements.CatalogPageNumber_Verification_ManageProducts)).getText().contains("7"))
		      {
		    	  System.out.println("Catalog Details Display on Manage Products Page Successfully");
		    	  
		    	  test = extent.createTest("CatalogDetails_Verification_OnManageProductsScreen");
					 
	               test.log(Status.PASS, "Catalog Details Display on Manage Products Page Successfully");
		    	  
		      }
		      else{
                  System.out.println("Catalog Details Display on Manage Products Page UnSuccessfully");
		    	  
		    	  test = extent.createTest("CatalogDetails_Verification_OnManageProductsScreen");
					 
	               test.log(Status.FAIL, "Catalog Details Display on Manage Products Page UnSuccessfully"); 
		      }
		 
		 }catch(NoSuchElementException e)
		 {
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


