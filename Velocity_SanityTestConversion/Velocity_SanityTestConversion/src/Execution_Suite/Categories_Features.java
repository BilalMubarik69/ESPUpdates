package Execution_Suite;


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
public class Categories_Features {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	String CategorialProductType;
	String EditorialCategory;
	String CategorialProductType1;
	String EditorialCategory1;
	static WebDriver wdriver;
    static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	@BeforeTest
	
	@Parameters("browser")
	public void setup(String browser) throws InterruptedException{
		
		if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/FireFoxReports/CategoriesFeatures"+".html");
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
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ChromeReports/CategoriesFeatures"+".html");
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
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/EdgeReports/CategoriesFeatures"+".html");
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	
	}
	
  @Test(priority=0)
  public void login() throws InterruptedException {
    try{
    	Thread.sleep(5000);
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
    }	
    //Catch the exception if any
    catch(NoSuchElementException e){
    	e.getStackTrace();
    	
    }
  }  
  @Test(priority=1)
  public void AddProductType() throws InterruptedException{
	  try{
	  wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
	    
	    Thread.sleep(1000);
	  
	  
	  //Press the EIT Admin Tab
	  driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
	  
	  
	  
	  //Press the category option
	  driver.findElement(By.xpath(Testelements.EITAdmin_CategoriesTab)).click();
	  
	  WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Manage Product Types");
	  
	  
	    wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.AddProductType_Button)));
	    
	    Thread.sleep(1000);
	    
	    //Press the add Button
	    driver.findElement(By.xpath(Testelements.AddProductType_Button)).click();
	    
	    
	    
	    //Enter the Product Type
	    driver.findElement(By.xpath(Testelements.ProductTypeName)).sendKeys("Automation");
	    
	    
	    
	    //Press the Add Product Type Button
	    driver.findElement(By.xpath(Testelements.ProductTypeAddButton)).click();
	    

	    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	    
	    System.out.println("New Product Type Added sucessfully");
	    test = extent.createTest("AddProductType");
 		test.log(Status.PASS, "New Product Type Added sucessfully");
 		
	    }
	    else{
	    	
	    	 System.out.println("New Product Type Added unsucessfully");
	 	    test = extent.createTest("AddProductType");
	  		test.log(Status.FAIL, "New Product Type Added  unsucessfully");
	    }
	  	  
	  
	  }
	  
	  
	  catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		}
  
  }
  @Test(priority=2)
  public void SearchProductType() throws InterruptedException{
  	   try{
  	
  	waitForPageLoad();
     //Search the term
  	driver.findElement(By.xpath(Testelements.SearchProductType_SearchField)).sendKeys("Automation");
  	
  	
  	//Press the search button
  	driver.findElement(By.xpath(Testelements.FilterProductTypeSearchButton)).click();
  	
  	waitForPageLoad();
  	
  	Thread.sleep(1000);
  	
  	if(driver.findElement(By.xpath(Testelements.SearchProductTypeVerification)).isDisplayed()){
  	System.out.print("Product Type Searched Successfully");
  	test = extent.createTest("Search ProductType");
		
		test.log(Status.PASS, "Product Type Searched Successfully");
  	}
  	else{
  		
  		System.out.print("Product Type Searched UnSuccessfully");
      	test = extent.createTest("Search ProductType");
   		
   		test.log(Status.FAIL, "Product Type Searched UnSuccessfully");
  	}
  
  
      }catch(NoSuchElementException e){
      	
  		e.getStackTrace();
  		 
      
      }
  	
  }
  @Test(priority=3)
  public void EditProductType() throws InterruptedException{
	   try{
	   //Press the edit button
	   driver.findElement(By.xpath(Testelements.ProductTypeEditButton)).click();
	   
	   
	   
	   //Clear the previous name
	   WebElement toClear = driver.findElement(By.xpath(Testelements.ProductTypeEditField));
	     toClear.sendKeys(Keys.CONTROL + "a");
	     toClear.sendKeys(Keys.DELETE); 
  
     //Wait
	    
	     
	  //Enter Updated Trade Name and save
	     driver.findElement(By.xpath(Testelements.ProductTypeEditField)).sendKeys("Automation 1");
	     
	     
	     
	  //Press the confirm for the update process to be completed
	     driver.findElement(By.xpath(Testelements.UpdateProductType_UpdateOkButton)).click();
	     
	     waitForPageLoad();
	     
	     Thread.sleep(1000);
	     
	     if(driver.findElement(By.xpath(Testelements.UpdatedProductType_Verification)).getText().contains("Automation 1")){
	            
	        	System.out.println("Product Type Updated  Successfully");
	        	
	        	test = extent.createTest("Edit ProductType");
	     		
	     		test.log(Status.PASS, "Trade Name  Updated Successfully");
	        }
	        else{
	        	System.out.println("Product Type Updated UnSuccessfully");
	        	test = extent.createTest("Edit ProductType");
	     		
	     		test.log(Status.FAIL, "Product Type Updated UnSuccessfully");
	        }
	     
	         
	    
	        }catch(NoSuchElementException e){
	        	
	    		e.getStackTrace();
	    		 
	        
	        }
  
  }
  @Test(priority=4)
  public void AddNewCategory_WithAssignProductType() throws InterruptedException{
	  try{
	  
	  WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Manage Categories");
	  
	  
	    wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Categories_AddButton)));
	    
	    Thread.sleep(1000);
	    
	    //Press the add Button
	    driver.findElement(By.xpath(Testelements.Categories_AddButton)).click();
	    
	    
	    
	    //Press the next button as major category is already selected
	    driver.findElement(By.xpath(Testelements.AddCategory_NextButton)).click();
	    
	    
	    
	    //Enter the category Name
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField)).sendKeys(Testdata.CategoryName);
	    
	   
	    
	    //Assign Product Type
	    driver.findElement(By.xpath(Testelements.AssignProductType_Category)).sendKeys("Automation 1");
	    
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath(Testelements.AssignProductType_Category)).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    
	    //Assign Editorial Category
	    driver.findElement(By.xpath(Testelements.AssignEditorialCategory)).sendKeys("a");
	    
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath(Testelements.AssignEditorialCategory)).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    
	    //Now Storing categorial Product Type and Editorial Category into String
	    CategorialProductType=driver.findElement(By.xpath(Testelements.AssignProductType_Category_ValueStore)).getText();
	    System.out.println(CategorialProductType);
	    
	     EditorialCategory=driver.findElement(By.xpath(Testelements.AssignEditorialCategory_ValueStore)).getText();
	    System.out.println(EditorialCategory);
	    //Click outside area to enable next button
	    driver.findElement(By.cssSelector(Testelements.ClickOutsideAddCategory_NextButtonEnable)).click();
	    
	    Thread.sleep(1000);
	    
	    
	    //Press the next button
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField_NextButton)).click();
	    
	 
	    
	    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	    
	    System.out.println("Product Type Assign New Category Added With sucessfully");
	    
 		
	    }
	    else{
	    	
	    	 System.out.println("Product Type Assign New Category Added With unsucessfully");
	 	    
	    }
	  	  
	     waitForPageLoad();
	    
	    //Search the category which has been created
		  driver.findElement(By.xpath(Testelements.SearchCategory_Field)).sendKeys("Automation");
		  
		  Thread.sleep(2000);
		  
		  //Press the search button
		  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
		  
		  wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EditCategoryButton)));
		    
		    Thread.sleep(2000);
		    
		    if(driver.getPageSource().contains("Automation 1"))
		    {
		    	System.out.println("New Category Added With Product Type Assign Successfully");
		    	
		    	test = extent.createTest("AddNewCategory_WithAssignProductType_Verification");
		 		
		    	test.log(Status.PASS, "New Category Added With Product Type Assign sucessfully");
		    	
		    	
		    }
		    else{
                System.out.println("New Category Added With Product Type Assign UnSuccessfully");
		    	
		    	test = extent.createTest("AddNewCategory_WithAssignProductType_Verification");
		 		
		    	test.log(Status.FAIL, "New Category Added With Product Type Assign unsucessfully");
		    }
	  
		    driver.findElement(By.xpath(Testelements.Categorydeletion1)).click();
	         
	         wait = new WebDriverWait(driver, 120);
	 	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteConfirmCategory)));
	         
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath(Testelements.DeleteCategory_Confirm)).click();
	        
	        Thread.sleep(5000);
	  
	  }
	  
	  
	  catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		}
  
  }
  @Test(priority=5)
  public void DeleteProductType() throws InterruptedException{
	  try{
	  
	  WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Manage Product Types");
	  
	  
	    wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteProductTypeButton)));
	    
	    Thread.sleep(1000);
	    
	    //Press the add Button
	    driver.findElement(By.xpath(Testelements.DeleteProductTypeButton)).click();
	    
	    Thread.sleep(1000);
	    
	    //Press the next button as major category is already selected
	    driver.findElement(By.xpath(Testelements.DeleteProductTypeConfirm)).click();
	    
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
	   if(driver.findElement(By.xpath(Testelements.ProductTypeDelete_Verification)).getText().contains("No result found"))
	   {
		   System.out.println("Product Type Deleted Successfully");
		   
		   test = extent.createTest("ProductType_Delete");
	 		
	       test.log(Status.PASS, "Product Type Deleted Successfully");
		   
	   }
	   else{
           System.out.println("Product Type Deleted UnSuccessfully");
		   
		   test = extent.createTest("ProductType_Delete");
	 		
	       test.log(Status.FAIL, "Product Type Deleted UnSuccessfully");
	   }
	  }
	  
	  
	  catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		}
  
  }
  @Test(priority=6)
  public void AddNewCategory() throws InterruptedException{
	  try{
	  
		  driver.navigate().refresh();
		  
		  
		  wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
	    
	    Thread.sleep(2000);
	  
	  
	  //Press the EIT Admin Tab
	  driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
	  
	 
	  
	  //Press the category option
	  driver.findElement(By.xpath(Testelements.EITAdmin_CategoriesTab)).click();
	  
	  WebElement mySelectElement20 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
      Select dropdown20= new Select(mySelectElement20);
     
      dropdown20.selectByVisibleText("Manage Categories");
	  
	  
	    wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Categories_AddButton)));
	    
	    Thread.sleep(2000);
	    
	    //Press the add Button
	    driver.findElement(By.xpath(Testelements.Categories_AddButton)).click();
	    
	    
	    
	    //Press the next button as major category is already selected
	    driver.findElement(By.xpath(Testelements.AddCategory_NextButton)).click();
	    
	    
	    
	    //Enter the category Name
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField)).sendKeys(Testdata.CategoryName);
	    
	    
	    //Assign Product Type
	    driver.findElement(By.xpath(Testelements.AssignProductType_Category)).sendKeys("a");
	    
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath(Testelements.AssignProductType_Category)).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    
	    //Assign Editorial Category
	    driver.findElement(By.xpath(Testelements.AssignEditorialCategory)).sendKeys("a");
	    
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath(Testelements.AssignEditorialCategory)).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    
	    //Now Storing categorial Product Type and Editorial Category into String
	    CategorialProductType=driver.findElement(By.xpath(Testelements.AssignProductType_Category_ValueStore)).getText();
	    System.out.println(CategorialProductType);
	    
	     EditorialCategory=driver.findElement(By.xpath(Testelements.AssignEditorialCategory_ValueStore)).getText();
	    System.out.println(EditorialCategory);
	    //Click outside area to enable next button
	    driver.findElement(By.cssSelector(Testelements.ClickOutsideAddCategory_NextButtonEnable)).click();
	    
	    Thread.sleep(1000);
	    
	    
	    //Press the next button
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField_NextButton)).click();
	    
	 
	    
	    if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	    
	    System.out.println("New Category Added sucessfully");
	    test = extent.createTest("AddCategory");
 		test.log(Status.PASS, "New Category Added sucessfully");
 		
	    }
	    else{
	    	
	    	 System.out.println("New Category Added unsucessfully");
	 	    test = extent.createTest("AddCategory");
	  		test.log(Status.FAIL, "New Category Added unsucessfully");
	    }
	  	  
	  
	  }
	  
	  
	  catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		}
  
  }
  
  @Test(priority=7)
  public void SubCategoryAdd_WithoutAssignProduct() throws InterruptedException{
	  
	  try{
		  waitForPageLoad();
		  
		  Thread.sleep(1000);
		//Search the category which has been created
		  driver.findElement(By.xpath(Testelements.SearchCategory_Field)).sendKeys("Automation");
		  
		 
		  
		  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
		  
		  waitForPageLoad();
		  
		  Thread.sleep(1000);
		  
		  //Press the add Button
		    driver.findElement(By.xpath(Testelements.Categories_AddButton)).click();
		    
		    
		    
	  //Select the sub category radio button
		    driver.findElement(By.xpath(Testelements.SubcategoryRadioButton)).click();
		    
		    
	  
		    driver.findElement(By.xpath(Testelements.AddCategory_NextButton)).click();
		    
		    
		    
		    driver.findElement(By.xpath(Testelements.MajorCategorySearch_SubCategory)).sendKeys(Testdata.CategoryName);
		    
		    Thread.sleep(6000);
		    
		    driver.findElement(By.xpath(Testelements.MajorCategorySearch_SubCategory)).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath(Testelements.MajorCategory_SelectionNextButton)).click();
		    
		    Thread.sleep(4000);
	  
	        //Add AssignProduct and EditorialType
		    driver.findElement(By.xpath(Testelements.AssignProductType_SubCategory)).sendKeys("a");
		    
		    Thread.sleep(4000);
		    
           driver.findElement(By.xpath(Testelements.AssignProductType_SubCategory)).sendKeys(Keys.ENTER);
		    
		   Thread.sleep(1000);
		   
		   driver.findElement(By.xpath(Testelements.AssignEditorial_SubCategory)).sendKeys("a");
		   
		   Thread.sleep(4000);
		   
           driver.findElement(By.xpath(Testelements.AssignEditorial_SubCategory)).sendKeys(Keys.ENTER);
		   
		   Thread.sleep(1000);
		   
		   //Storing the values into String for ProductType and EditorialType for Sub Category
		   CategorialProductType1=driver.findElement(By.xpath(Testelements.NoAssignProductType_SubCategory)).getText();
		    System.out.println(CategorialProductType1);
		    
		     EditorialCategory1=driver.findElement(By.xpath(Testelements.NoAssignEditorialType_SubCategory)).getText();
		    System.out.println(EditorialCategory1);
		   
		   
		   
		   //Press the Add Button
		   driver.findElement(By.xpath(Testelements.NoAssignProduct_Subcategory_AddButton)).click();
		   
		   wait = new WebDriverWait(driver, 180);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SubCategoryEdit)));
		      
		   Thread.sleep(3000);
		   
		   driver.findElement(By.xpath(Testelements.SubCategoryEdit)).click();
		   
		   Thread.sleep(1000);
		   
		   if(driver.findElement(By.xpath(Testelements.NoAssignProductType_SubCategoryEdit)).getText().contains(CategorialProductType1) & driver.findElement(By.xpath(Testelements.NoAssignEditorialType_SubCategoryEdit)).getText().contains(EditorialCategory1) )
		   {
			   System.out.println("Product Type and Editorial Type Display Successfully on Edit Sub Category");
			   
			   test = extent.createTest("SubCategoryAdd_WithoutAssignProduct");
		 		
			   test.log(Status.PASS, "Product Type and Editorial Type Display Successfully on Edit Sub Category");
		   }
		   else{
			   System.out.println("Product Type and Editorial Type Display UnSuccessfully on Edit Sub Category");
		   
			   test = extent.createTest("SubCategoryAdd_WithoutAssignProduct");
		 		
			   test.log(Status.FAIL, "Product Type and Editorial Type Display UnSuccessfully on Edit Sub Category");
		   }
		   
		   //Press Ok to finish the Edit Category Popup
		   driver.findElement(By.xpath(Testelements.EditCategory_OKButton)).click();
		   
		   
	    
		   
		   
	  }catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
  }
 
  @Test(priority=8)
  public void SubCategoryAdd2() throws InterruptedException{
	  
	  try{
		  
		  waitForPageLoad();
		  
		  Thread.sleep(1000);
		  
		  //Press the add Button
		    driver.findElement(By.xpath(Testelements.Categories_AddButton)).click();
		    
		    
		    
	  //Select the sub category radio button
		    driver.findElement(By.xpath(Testelements.SubcategoryRadioButton)).click();
		    
		   
	  
		    driver.findElement(By.xpath(Testelements.AddCategory_NextButton)).click();
		    
		    
		    
		    driver.findElement(By.xpath(Testelements.MajorCategorySearch_SubCategory)).sendKeys(Testdata.CategoryName);
		    
		    Thread.sleep(6000);
		    
		    driver.findElement(By.xpath(Testelements.MajorCategorySearch_SubCategory)).sendKeys(Keys.ENTER);
		    
		    Thread.sleep(1000);
		    
		    
		    
		    driver.findElement(By.xpath(Testelements.MajorCategory_SelectionNextButton)).click();
		    
		    
		    
		    WebElement toClear = driver.findElement(By.xpath(Testelements.NewSubCategoryField));
		    toClear.sendKeys(Keys.CONTROL + "a");
		    toClear.sendKeys(Keys.DELETE); 
		    
		   
		    
		    driver.findElement(By.xpath(Testelements.NewSubCategoryField)).sendKeys(Testdata.NewSubCategoryUpdatedName);
		    
		    
		    
		    driver.findElement(By.xpath(Testelements.NewSubCategoryText)).click();
		    
		    Thread.sleep(1000);
	  
	        //Add AssignProduct and EditorialType
		    driver.findElement(By.xpath(Testelements.AssignProductType_SubCategory)).sendKeys("a");
		    
		    Thread.sleep(4000);
		    
           driver.findElement(By.xpath(Testelements.AssignProductType_SubCategory)).sendKeys(Keys.ENTER);
		    
		   Thread.sleep(1000);
		   
		   driver.findElement(By.xpath(Testelements.AssignEditorial_SubCategory)).sendKeys("a");
		   
		   Thread.sleep(4000);
		   
           driver.findElement(By.xpath(Testelements.AssignEditorial_SubCategory)).sendKeys(Keys.ENTER);
		   
		   Thread.sleep(1000);
		   
		   //Storing the values into String for ProductType and EditorialType for Sub Category
		   CategorialProductType1=driver.findElement(By.xpath(Testelements.NoAssignProductType_SubCategory)).getText();
		    System.out.println(CategorialProductType1);
		    
		     EditorialCategory1=driver.findElement(By.xpath(Testelements.NoAssignEditorialType_SubCategory)).getText();
		    System.out.println(EditorialCategory1);
		   
		   
		   
		   //Press the Add Button
		   driver.findElement(By.xpath(Testelements.NoAssignProduct_Subcategory_AddButton)).click();
		   
		   wait = new WebDriverWait(driver, 180);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.SubCategoryEdit)));
		      
		   Thread.sleep(3000);
		   
		   driver.findElement(By.xpath(Testelements.SubCategoryEdit2)).click();
		   
		   Thread.sleep(3000);
		   
		   if(driver.findElement(By.xpath(Testelements.NoAssignProductType_SubCategoryEdit)).getText().contains(CategorialProductType1) & driver.findElement(By.xpath(Testelements.NoAssignEditorialType_SubCategoryEdit)).getText().contains(EditorialCategory1) )
		   {
			   System.out.println("Product Type and Editorial Type Display Successfully on Edit Sub Category");
			   
			   test = extent.createTest("SubCategoryAdd_WithoutAssignProduct");
		 		
			   test.log(Status.PASS, "Product Type and Editorial Type Display Successfully on Edit Sub Category");
		   }
		   else{
			   System.out.println("Product Type and Editorial Type Display UnSuccessfully on Edit Sub Category");
		   
			   test = extent.createTest("SubCategoryAdd_WithoutAssignProduct");
		 		
			   test.log(Status.FAIL, "Product Type and Editorial Type Display UnSuccessfully on Edit Sub Category");
		   }
		   
		   //Press Ok to finish the Edit Category Popup
		   driver.findElement(By.xpath(Testelements.EditCategory_OKButton)).click();
		   
		   
		   
		   
	    
		   
		   
	  }catch(NoSuchElementException e){
		  e.getStackTrace();
	  }
  }
 
  @Test(priority=9)
  public void AssignCategoryToProduct_WithMergingProductsToCategory() throws InterruptedException
  {
	  try{
		   waitForPageLoad();
		   
		   Thread.sleep(1000);
		  
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
		      
		      Thread.sleep(3000);
		      
		      //Click the manage products tab
		      driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
		      
		      //Wait for the process to complete	    	
			  	wait = new WebDriverWait(driver, 180);
			      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.AddProductButton_EITSupplier)));
			      
			    Thread.sleep(1000);
			    
			      
			 driver.findElement(By.cssSelector(Testelements.AddProductButton_EITSupplier)).click();

		      
			      
				  
			      //Insert the product name
			  	driver.findElement(By.cssSelector(Testelements.Product_Name)).sendKeys(Testdata.Productname);
			  	
			  	//Insert Product description
			  	driver.findElement(By.cssSelector(Testelements.Product_description)).sendKeys("Description: Our most popular bottle, available in a variety of colors to help brighten up anybodys gear. The large opening on our wide-mouth bottles easily accommodates ice cubes, fits most water purifiers and filters, and makes hand washing a breeze. The attached loop-top never gets lost and screws on and off easily. Printed graduations let keep track of your hydration. Dishwasher safe Please make sure the top does not touch the heating element, or it will melt.");

		        
			  	
			  	driver.findElement(By.xpath("//*[@id='addNewProduct']/div[2]/div/div[3]/div/label/strong")).click();
		        
		        
			  	
			  	
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

			      waitForPageLoadProductLevel();
			      
			      Thread.sleep(1000);
			      
                  waitForPageLoadProductLevel();
			      
			      Thread.sleep(2000);
			      
                  waitForPageLoadProductLevel();
			      
			      Thread.sleep(2000);
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
			     
			     
			 	Thread.sleep(2000);

			   
			  //Search the category
			     driver.findElement(By.cssSelector(Testelements.Category_Searchfield)).sendKeys("Automation");
			     
			  
			 	Thread.sleep(2000);

			     
			     //Select 2  categories of frames 
			     driver.findElement(By.cssSelector(Testelements.Product_category1)).click();
			     
			 //Select the 2nd 1 
			     driver.findElement(By.cssSelector(Testelements.Product_category2)).click();
			     
			 //Press the apply on category product popup
			     driver.findElement(By.cssSelector(Testelements.ProductCategory_ApplyButton)).click();
			     
			     Thread.sleep(2000);
			     
			   //Switch back to parent window 
			     driver.switchTo().window(parentWindow1);
			     
			     driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
			     
			     Thread.sleep(2000);
			     
			     JavascriptExecutor jse = (JavascriptExecutor)driver;
				 jse.executeScript("window.scrollBy(0,-250)", "");
			     
				 JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				 jse1.executeScript("window.scrollBy(-250,-500)", "");
				    
				 JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				 jse2.executeScript("window.scrollBy(-500,-750)", "");
				 
				 Thread.sleep(1000);
			     
				 wait = new WebDriverWait(driver, 120);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Copy_Button)));
				    
				 Thread.sleep(3000);
				 
				 
				 
				 driver.findElement(By.xpath(Testelements.Copy_Button)).click();
			     
			    
			       
			       //Wait for few sec 
			       
			    	Thread.sleep(2000);
			    
			       WebElement toClear = driver.findElement(By.xpath(Testelements.Copy_Product_field));
			       toClear.sendKeys(Keys.CONTROL + "a");
			       toClear.sendKeys(Keys.DELETE); 
			       //Insert a new name
			       driver.findElement(By.xpath(Testelements.Copy_Product_field)).sendKeys(Testdata.Productname);
			       //Save the copy product 
			       
			       driver.findElement(By.xpath(Testelements.Copy_product_save)).click();
			       
			       waitForPageLoadProductLevel();
			       
			       Thread.sleep(1000);
			       
			       waitForPageLoadProductLevel();
			       
			       Thread.sleep(1000);
			       
			       driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
			       
			       //Press the EIT Dashboard from action bar
			  	 driver.findElement(By.xpath(Testelements.EITDashboardButton)).click();
			  	 
			  	 wait = new WebDriverWait(driver, 120);
				    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EITAdmin_Tab)));
				    
				    Thread.sleep(1000);
				  
				  
				  //Press the EIT Admin Tab
				  driver.findElement(By.xpath(Testelements.EITAdmin_Tab)).click();
				  
				  
				  
				  //Press the category option
				  driver.findElement(By.xpath(Testelements.EITAdmin_CategoriesTab)).click();
				  
				  WebElement mySelectElement201 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
			      Select dropdown201= new Select(mySelectElement201);
			     
			      dropdown201.selectByVisibleText("Manage Categories");
				  
				  
				    wait = new WebDriverWait(driver, 120);
				    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.Categories_AddButton)));
				    
				    Thread.sleep(1000);
				    
				  //Search the category which has been created
					 driver.findElement(By.xpath(Testelements.SearchCategory_Field)).sendKeys("Automation");
					  
					 
					  
					  //Press the search button
					  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
					  
					  wait = new WebDriverWait(driver, 120);
					  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.MergeCategoryButton)));
					    
					  Thread.sleep(2000);
					  
					  driver.findElement(By.xpath(Testelements.MergeCategoryButton)).click();
					  
					  Thread.sleep(1000);
					  
					  driver.findElement(By.xpath(Testelements.MergeCategoryConfirmButton)).click();
					  
					  Thread.sleep(12000);
					  
					  //Validating if the count increase 2 after merging
					  if(driver.findElement(By.xpath(Testelements.MajorCategoryCountBeforeMerge)).getText().contains("2"))
					  {
						  System.out.println("Merging for categories done successfully");
						  
						  test = extent.createTest("AssignCategoryToProduct_WithMergingProductsToCategory");
					 		
						   test.log(Status.PASS, "Merging for categories done successfully");
					  }
					    
					  else{
						  
                          System.out.println("Merging for categories done unsuccessfully");
						  
						  test = extent.createTest("AssignCategoryToProduct_WithMergingProductsToCategory");
					 		
						   test.log(Status.FAIL, "Merging for categories done unsuccessfully");
					  }
					   
	                  waitForPageLoad();
	                  
	                  Thread.sleep(2000);
	                  
                      waitForPageLoad();
	                  
	                  Thread.sleep(1000);
	  
	  }
	  catch(NoSuchElementException e){
	    	e.getStackTrace();
		}
  }
  
  
  
  
  
  @Test(priority=10)
  public void UpdateCategory() throws InterruptedException{
	  try{
	  //Search the category which has been created
	  //driver.findElement(By.xpath(Testelements.SearchCategory_Field)).sendKeys("Automation");
	  
	  //Thread.sleep(2000);
	  
	  //Press the search button
	  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
	  
	  wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EditCategoryButton)));
	    
	    Thread.sleep(2000);
	    
	    if(driver.getPageSource().contains(EditorialCategory) & driver.findElement(By.xpath(Testelements.ProductType_CategoryListing)).getText().contains(CategorialProductType))
	    {
	     System.out.println("Product Type and Editorial Category Displayed Successfully");
	     
	     test = extent.createTest("ProductType&EditorialCategory_Verification");
	 		
	     test.log(Status.PASS, "Product Type and Editorial Category Displayed Successfully");
	    }
	    else{
	    	System.out.println("Product Type and Editorial Category Displayed UnSuccessfully");
		     
		     test = extent.createTest("ProductType&EditorialCategory_Verification");
		 		
		     test.log(Status.FAIL, "Product Type and Editorial Category Displayed UnSuccessfully");
	    }
	    
	    //Press the edit button
	    driver.findElement(By.xpath(Testelements.EditCategoryButton)).click();
	    
	    
	    wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.EditCategory_TextField)));
	    
	    Thread.sleep(1000);
	    
	    if(driver.findElement(By.xpath(Testelements.AssignProductTypeEditCategory)).getText().contains(CategorialProductType) & driver.findElement(By.xpath(Testelements.AssignEditorialCategory_Edit)).getText().contains(EditorialCategory) )
	    {
	    	System.out.println("Product Type and Editorial Category Displayed Successfully on Edit Category");
	    
	    	test = extent.createTest("ProductType&EditorialCategory_Verification");
	 		
		     test.log(Status.PASS, "Product Type and Editorial Category Displayed Successfully on Edit Category");
	    }
	    else{
	    	System.out.println("Product Type and Editorial Category Displayed UnSuccessfully on Edit Category");
		    
	    	test = extent.createTest("ProductType&EditorialCategory_Verification");
	 		
		     test.log(Status.FAIL, "Product Type and Editorial Category Displayed UnSuccessfully on Edit Category");
	    }
	    
	    //Remove the previous category name
	    WebElement toClear = driver.findElement(By.xpath(Testelements.EditCategory_TextField));
	     toClear.sendKeys(Keys.CONTROL + "a");
	     toClear.sendKeys(Keys.DELETE); 
  
	    //Insert the updated name
	     driver.findElement(By.xpath(Testelements.EditCategory_TextField)).sendKeys(Testdata.CategoryUpdateName);
	     
	    
	     
	  //Press the ok to confirm
	     driver.findElement(By.xpath(Testelements.EditCategory_ConfirmEditing)).click();
	     
	     if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	    	 
	    	 System.out.println("Category Updated sucessfully");
	    	 test = extent.createTest("UpdateCategory");
		 	
		 	test.log(Status.PASS, "Category Updated sucessfully");
	     
	     }
	     else{
	    	 System.out.println("Category Updated unsucessfully");
	    	 test = extent.createTest("UpdateCategory");
		 	
		 	test.log(Status.FAIL, "Category Updated unsucessfully");
	    	 
	     }
	     
	     waitForPageLoad();
	     
	     Thread.sleep(2000);
	     
	    
	  }
	 		catch(NoSuchElementException e){
	 	    	e.getStackTrace();
	 		}
	  
	  }
  
  @Test(priority=11)
  public void ReassignCategoryToProduct() throws InterruptedException{
	  try{
	 
		//Press the search button
					  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
					  
					  waitForPageLoad();
					  
					  Thread.sleep(1000);
			    
			  
			  //Press the reassign button
			  driver.findElement(By.xpath(Testelements.SubCategory_ReassignButton)).click();
			  
			  
			  wait = new WebDriverWait(driver, 180);
			  	 
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ReassignField_Field)));
		       
		       Thread.sleep(1000);
		       
		       driver.findElement(By.xpath(Testelements.ReassignField_Field)).sendKeys("Frames");
		       
		       Thread.sleep(8000);
		       
		       driver.findElement(By.xpath(Testelements.ReassignField_Field)).sendKeys(Keys.ENTER);
		       
		       Thread.sleep(1000);
		       
		       
		       wait = new WebDriverWait(driver, 180);
			  	 
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ReassignConfirmButton1)));
		       
		       Thread.sleep(2000);
		       
		       //press the button
		       driver.findElement(By.xpath(Testelements.ReassignConfirmButton1)).click();
		       
		       Thread.sleep(8000);
		       
		       //Press the 2nd confirmation button
		       driver.findElement(By.xpath(Testelements.ReassignConfirmButton2)).click();
		       
		       waitForPageLoad();
		       
		       Thread.sleep(1000);
		       
		       //Close the popup now
		       driver.findElement(By.xpath(Testelements.ReassignCategoryClose)).click();
		       
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       
		       Thread.sleep(5000);
		      
		      
		    	      
		       //Press the category option
				  driver.findElement(By.xpath(Testelements.EITAdmin_CategoriesTab)).click();
				  
				  
				  
				  WebElement mySelectElement2010 = driver.findElement(By.xpath(Testelements.CategoriesOptionsDropdown));
			      Select dropdown2010= new Select(mySelectElement2010);
			     
			      dropdown2010.selectByVisibleText("Manage Categories");
			      
			      
				  
				  //Search the category which has been created
				  driver.findElement(By.xpath(Testelements.SearchCategory_Field)).sendKeys("Automation");
				  
				//Press the search button
				  driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
				  
				  waitForPageLoad();
				  
				  Thread.sleep(1000);
				  
				  if(driver.getCurrentUrl().contains("stage")){
			    	   
			    	   if(driver.findElement(By.xpath("//span[contains(text(),'Edited by 30232bm on ')]")).getText().contains("Edited by 30232bm on")){
			    		   System.out.println("Do not change last update date or last update by when reassigning products from categories Sucessfull");
			    		   test = extent.createTest("Do not change last update date or last update by when reassigning products from categories.");
							test.log(Status.PASS, "Do not change last update date or last update by when reassigning products from categories Sucessfull");
			    	   }
			       
			    	   else{
			    		   System.out.println("Do not change last update date or last update by when reassigning products from categories UnSucessfull");
			    		   test = extent.createTest("Do not change last update date or last update by when reassigning products from categories.");
							test.log(Status.FAIL, "Do not change last update date or last update by when reassigning products from categories UnSucessfull");
			    	   }
			         
			       }
			       else if(driver.getCurrentUrl().contains("uat") || driver.getCurrentUrl().contains("https://espupdates.asicentral.com/")){
			    	   
			    	   if(driver.findElement(By.xpath("//span[contains(text(),'Edited by fa20 on ')]")).getText().contains("Edited by fa20 on")){
			    		   System.out.println("Do not change last update date or last update by when reassigning products from categories Sucessfull");
			    		   test = extent.createTest("Do not change last update date or last update by when reassigning products from categories.");
							test.log(Status.PASS, "Do not change last update date or last update by when reassigning products from categories Sucessfull");
			       }
			    	   
			    	   else{
			    		   System.out.println("Do not change last update date or last update by when reassigning products from categories UnSucessfull");
			    		   test = extent.createTest("Do not change last update date or last update by when reassigning products from categories.");
							test.log(Status.FAIL, "Do not change last update date or last update by when reassigning products from categories UnSucessfull");
			    	   }
			       }  
			       			  
				  if(!driver.findElement(By.xpath("//button[contains(text(),'Reassign')]")).isEnabled()){
					   System.out.println("Category Reassign Sucessfully");
					  
					  test = extent.createTest("ReassignCategoryToProduct");
						
					test.log(Status.PASS, "Category Reassign Sucessfully");  
				  }
				  else{
					  System.out.println("Category Reassign UnSucessfully");
					  
					  test = extent.createTest("ReassignCategoryToProduct");
						
					  test.log(Status.FAIL, "Category Reassign UnSucessfully");  
				  }
		       
			  
			  
		      //Deleteing the reassign category 
	         
	   driver.findElement(By.xpath(Testelements.Categorydeletion1)).click();
	         
	         wait = new WebDriverWait(driver, 120);
	 	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.DeleteConfirmCategory)));
	         
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath(Testelements.DeleteCategory_Confirm)).click();
	        
	        Thread.sleep(5000);  
	  }
	           
	         
	  
	  			
				catch(NoSuchElementException e){
		 	    	e.getStackTrace();
		 		}
	}
  
 @Test(priority=12)
  public void DeleteCategory() throws InterruptedException{
	  try{
	  //Press the add Button
	    driver.findElement(By.xpath(Testelements.Categories_AddButton)).click();
	    
	    
	    
	    driver.findElement(By.xpath(Testelements.MajorCategory_RadioButton_AddCategory)).click();
	    
	    
	    
	    //Press the next button as major category is already selected
	    driver.findElement(By.xpath(Testelements.AddCategory_NextButton)).click();
	    
	    
	    
	    //Enter the category Name
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField)).sendKeys(Testdata.CategoryName1);
	    
	    
	    
	    //Click outside area to enable next button
	    driver.findElement(By.cssSelector(Testelements.ClickOutsideAddCategory_NextButtonEnable)).click();
	    
	    Thread.sleep(1000);
	    
	    
	    //Press the next button
	    driver.findElement(By.xpath(Testelements.MajorCategory_InsertField_NextButton)).click();
	
	    waitForPageLoad();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(Testelements.SearchCategory_Button)).click();
	    
	    waitForPageLoad();
	    
	 //Press the delete option after editing
	  driver.findElement(By.xpath(Testelements.DeleteCategory_Button)).click();
	  
	  Thread.sleep(4000);
	  
	  //Press the ok button to delete the category
	  driver.findElement(By.xpath(Testelements.DeleteCategory_Confirm)).click();
	  
	  if(driver.findElement(By.cssSelector(Testelements.SaveSuccessMessage)).getText().contains("Data saved successfully")){
	      System.out.println("Category deleted Sucessfully");
		  test = extent.createTest("DeleteCategory");
			test.log(Status.PASS, "Category deleted Sucessfully");
	  }
	  else{
		  
		  System.out.println("Category deleted UnSucessfully");
		  test = extent.createTest("DeleteCategory");
			test.log(Status.FAIL, "Category deleted UnSucessfully");
	  }
	  
	  
	  Thread.sleep(2000);	
  
  }
		catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		}
  }	
  
	@Test(priority=13)
	public void EITAdminMessageCenter_SummaryDisplay() throws InterruptedException{
		try{
		
			 //Scroll down
		    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		    jse2.executeScript("window.scrollBy(0,250)", "");
		    
		    Thread.sleep(1000);
			
			//Press the message center tab
		driver.findElement(By.xpath(Testelements.MessageCenterTab)).click();
		
		
		
		//Enter asi number in to field
		driver.findElement(By.xpath(Testelements.MessageCenterToField)).sendKeys("30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232,30232");
	
		
		
		//Enter the message in message area
		driver.findElement(By.xpath(Testelements.MessageCenter_MessageArea)).sendKeys("test");
		
		
		
		//Slect the start data
		driver.findElement(By.xpath(Testelements.MessageCenter_StartdateButton)).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]/span")).click();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath(Testelements.MessageCenterStartDate_Select)).click();
		
		Thread.sleep(2000);
		
		
		
		//Select the end date
		driver.findElement(By.xpath(Testelements.MessageCenter_EndDateButton)).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]/span")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(Testelements.MessageCenterEnddate_Select)).click();
		
		Thread.sleep(2000);
		
		//Press the post button
		driver.findElement(By.xpath(Testelements.MessageCenter_PostButton)).click();
		
		waitForPageLoad();
		
		Thread.sleep(1000);
		
		 //Scroll down
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,250)", "");
	    
	    Thread.sleep(1000);
		
		if(driver.findElement(By.xpath(Testelements.MessageCenter_ShowMorelink)).getText().contains("Show More")){
			System.out.println("EITAdminMessageCenter_SummaryDisplay with show more expand button shown and pressed sucessfully");
			test = extent.createTest("EITAdminMessageCenter_SummaryDisplay");
			test.log(Status.PASS, "EITAdminMessageCenter_SummaryDisplay with show more expand button shown and pressed sucessfully");
		}
		else{
			System.out.println("EITAdminMessageCenter_SummaryDisplay with show more expand button shown and pressed unsucessfully");
			test = extent.createTest("EITAdminMessageCenter_SummaryDisplay");
			test.log(Status.FAIL, "EITAdminMessageCenter_SummaryDisplay with show more expand button shown and pressed unsucessfully");
		}
	    //Press the show more tab
		driver.findElement(By.xpath(Testelements.MessageCenter_ShowMorelink)).click();
		
		Thread.sleep(2000);
		
		//Press the radio button in message center
		driver.findElement(By.xpath("//input[contains(@name,'rb_MessageList')]")).click();
		
		
		
		//Press the delete button
		driver.findElement(By.xpath("//button[contains(text(),'DELETE')]")).click();
		
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
		
	        //wait = new WebDriverWait(driver, 120);
 	       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div/div")));
 	       //Wait for 4 sec 
 	        Thread.sleep(6000);
		
		}
		catch(NoSuchElementException e){
 	    	e.getStackTrace();
 		} 
	  
	}
  
  
  @Test(priority=14)
  public void BulkEdit_ChangeRadioButtons() throws InterruptedException{
	  
	    try{
	  
	    	 //Scroll Up
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,-250)", "");
		    
		    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		    jse1.executeScript("window.scrollBy(-250,-500)", "");
		    
		    
	    	Thread.sleep(1000);
	    	//Press the manage product tab in EIT Maneger
	  driver.findElement(By.xpath(Testelements.EITManageProducts)).click();
	  
	  
	  //Wait for the supplier asi number field to be appear and insert the asi number
	//Wait for supplier asi insertion field to appear
	  wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_asi_Insertion)));
      
      Thread.sleep(2000);
      //Send info into asi field
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_Insertion)).sendKeys("30232");
      //Click the search for supplier serach
      driver.findElement(By.cssSelector(Testelements.Supplier_asi_search)).click();
      //Wait for supplier selection option to appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Supplier_selection)));
      //Select the supplier through clicking
      driver.findElement(By.cssSelector(Testelements.Supplier_selection)).click();
      
     //Wait for Manage products tab to be appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.ManageProducts_Tab)));
      
      Thread.sleep(2000);
      
      //Press the manage products tab
      driver.findElement(By.xpath(Testelements.ManageProducts_Tab)).click();
      
    //Wait for Manage products tab to be appear
      wait = new WebDriverWait(driver, 180);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Testelements.BulkProduct_checkbox)));
      
      Thread.sleep(2000);
      
      driver.findElement(By.xpath(Testelements.BulkProduct_checkbox)).click();
      
      
      
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
	     	  
	     	
	 		
					Thread.sleep(1000);
				
	 		
					List<WebElement> li1= driver.findElements(By.xpath(Testelements.BulkEdit_SelectProd));
					li1.get(2).click();
					 
		
		
			       Thread.sleep(1000);
			
	   //Press All prodcuts selected tab
			
			       List<WebElement> li3= driver.findElements(By.xpath(Testelements.BulkEdit_AllProdRadio));
			  	   li3.get(0).click();
			  	 
			       
			       
			
			      Thread.sleep(1000);
			
	          if(driver.findElement(By.xpath(Testelements.BulkEdit_AllProdRadio)).isEnabled() & driver.findElement(By.xpath(Testelements.BulkEdit_SelectProd)).isEnabled())
			      
	        	  {
	        	  System.out.println("Bulk Edits - All and Selected Product radio button is enabled and selected Successfully");
					test = extent.createTest("BulkEdit_ChangeRadioButtons_All and Selected Product Radio Button Selection");
						
					test.log(Status.PASS, "Bulk Edits - All and Selected Product Products radio button is enabled and selected Successfully");
	        	  
	        	  }
	        	  else{
	        		
	        		  System.out.println("Bulk Edits - All and Selected Product radio button is enabled and selected UnSuccessfully");
	  				test = extent.createTest("BulkEdit_ChangeRadioButtons_All and Selected Product Products Radio Button Selection");
	  					
	  				test.log(Status.FAIL, "Bulk Edits - All and Selected Product radio button is enabled and selected UnSuccessfully");
	        	  }
			      //Press the cancel button
			       driver.findElement(By.xpath(Testelements.BulkCancelButton)).click();
			  	  
			      Thread.sleep(1000);
			
			
	 //Press the category option
			driver.findElement(By.xpath(Testelements.BulkEdit_CategorySelect_ForAllFilteredradio)).click();
			
			Thread.sleep(5000);
			
			//Press the bulk edit button
			driver.findElement(By.xpath(Testelements.BulkEdit_Button)).click();   
			
			Thread.sleep(1000);
			
			//Press the all filtered radio button
			 List<WebElement> li6= driver.findElements(By.xpath(Testelements.BulkEdit_AllFilteredProducts));
		  	 li6.get(1).click();
		      
			if(driver.findElement(By.xpath(Testelements.BulkEdit_AllFilteredProducts)).isEnabled()){
				 
				System.out.println("Bulk Edits - Filtered radio button is enabled and selected Successfully");
				test = extent.createTest("BulkEdit_ChangeRadioButtons_Filtered Products Radio Button Selection");
					
				test.log(Status.PASS, "Bulk Edits - Filtered Products radio button is enabled and selected Successfully");
			  
			}
			else{
				System.out.println("Bulk Edits - Filtered Products radio button is enabled and selected UnSuccessfully");
				test = extent.createTest("BulkEdit_ChangeRadioButtons_Filtered Products Products Radio Button Selection");
					
				test.log(Status.FAIL, "Bulk Edits - Filtered Products radio button is enabled and selected UnSuccessfully");
			}
			
			
			
	    
				//Press the cancel button
				 driver.findElement(By.xpath(Testelements.BulkCancelButton)).click();
			  	  
			    
					
				   //remove search for category
					driver.findElement(By.xpath("//i[contains(@id,'removeFilter')]")).click();
					
					Thread.sleep(2000);
					
					  //Enter the product to assign new category
				      driver.findElement(By.xpath(Testelements.SearchProduct_field)).sendKeys("Reassign");
				      
				      Thread.sleep(2000);
				      
				      //Press the search button
				      driver.findElement(By.xpath(Testelements.SearchProduct_Button)).click();
				      
				      //Wait for Manage products tab to be appear
				      wait = new WebDriverWait(driver, 180);
				      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.EditProduct)));
				      
				      Thread.sleep(2000);
				      
				      driver.findElement(By.cssSelector(Testelements.EditProduct)).click();
				      
				      waitForPageLoadProductLevel();
				      
				      Thread.sleep(1000);
				      
                      waitForPageLoadProductLevel();
				      
				      Thread.sleep(2000);
				      
				      //Move to Images tab
					  	driver.findElement(By.cssSelector(Testelements.Product_Image_Tab)).click();
					  	
					  	waitForPageLoadProductLevel();
					  	
					  	Thread.sleep(1000);
					  	
					   //Wait for the button to appear
					  	 wait = new WebDriverWait(driver, 180);
					       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.Product_Images_MediaLibrary_Button)));
					          
					       Thread.sleep(1000);
					       
					  
					       String DefaultTextOnImage_Invisbility=driver.findElement(By.xpath(Testelements.DefaultImageSelectedDiv)).getText();
					       System.out.println(DefaultTextOnImage_Invisbility);
					       
					       if(!DefaultTextOnImage_Invisbility.contains("Set as Default"))
					       {
					    	   System.out.println("No Set as Default Link Visible on Image Listing in media Tab In Product");
					    	   
					    	   test = extent.createTest("SetAsDefaultLink_Visibility_OnPrimaryImage");
								
							   test.log(Status.PASS, "No Set as Default Link Visible on Image Listing in media Tab In Product");  
					       }
					       else{
			                  System.out.println("Set as Default Link Visible on Image Listing in media Tab In Product");
					    	   
					    	   test = extent.createTest("SetAsDefaultLink_Visibility_OnPrimaryImage");
								
							   test.log(Status.FAIL, "Set as Default Link Visible on Image Listing in media Tab In Product");  
					    	   
					       }
					       
					       
					       //Select the default image option
					       //Scroll down
						    JavascriptExecutor jse12 = (JavascriptExecutor)driver;
						    jse12.executeScript("window.scrollBy(0,250)", "");
						    
						    Thread.sleep(1000);
						   
					       driver.findElement(By.xpath(Testelements.DefaultImage)).click();
					       
						   Thread.sleep(2000);
						   
						   List<WebElement> li4= driver.findElements(By.xpath(Testelements.MediaLibrarySaveButton));
						   
						   if(li4.get(2).isEnabled()){
							   
							   System.out.println("Default images should be auto assigned the Primary tag sucessfully");
							   
							   test = extent.createTest("Default Image As Primary tag");
								
								test.log(Status.PASS, "Default images should be auto assigned the Primary tag sucessfully");  
						   }
						   else{
							   
							   System.out.println("Default images should be auto assigned the Primary tag unsucessfully");
							  
							   test = extent.createTest("Default Image As Primary tag");
								
							test.log(Status.FAIL, "Default images should be auto assigned the Primary tag unsucessfully");  
						   }
						 //Scroll Up
						    JavascriptExecutor jse10 = (JavascriptExecutor)driver;
						    jse10.executeScript("window.scrollBy(0,-250)", "");
						    
						    Thread.sleep(1000);
						
						  //Goto Summary Tab
					      driver.findElement(By.cssSelector(Testelements.Product_Summary_Tab)).click();
					          
					     //Wait for some time
					      
					  	  waitForPageLoadProductLevel();	
					      
					      Thread.sleep(1000);
					  	
					    driver.findElement(By.cssSelector(Testelements.Product_Manage)).click();
					    
					    wait = new WebDriverWait(driver, 180);
					  	 
					    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Testelements.MakeChangesActive)));
					       
					    
					    
					  	Thread.sleep(2000);
					 
					    
					    //Press the make changes active button after editing
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
				
		
	  	
  
  public static void waitForPageLoad() throws InterruptedException {
		
		
	   wait = new WebDriverWait(driver, 120);
	       
	    pageLoaded = new Predicate<WebDriver>() {

	        public boolean apply(WebDriver input) {
	            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
	        }

	    };
	  
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


