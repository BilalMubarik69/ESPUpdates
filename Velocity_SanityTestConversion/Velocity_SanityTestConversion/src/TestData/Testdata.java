package TestData;

import java.util.Random;

public interface Testdata {


	//==========================================Velocity URL=========================================================
	    //Prod
	     static String VelocityURL = "https://espupdates.asicentral.com";
		
	    //UAT	
	  //  static String VelocityURL = "https://espupdates.uat-asicentral.com";	
			
	     //Stage   
	    
	  // static String VelocityURL = "https://espupdates.stage-asicentral.com";
		
	
	
	//======================================================Chrome Path==========================================
			//public String chromepath="C:\\chromedriver.exe";
			public String sChromePath = "Installation/chromedriver.exe";
			public String sFirefoxPath = "Installation/geckodriver.exe";
			public String sIEPath = "Installation/IEDriverServer.exe";
			public String sEdgePath = "Installation/MicrosoftWebDriver.exe";
			public String sOperaPath = "Installation/operadriver.exe";
			//==========================================Velocity Supplier Credentials=========================================================
            //Without Eit Manager licence
			
			//Prod
			public String vASINumberProd_Cust = "30232";
			public String vUserNameProd_Cust = "30232bm1";
		    public String vPasswordProd_Cust = "bilal.1234";
			
			
			
			//UAT
			public String vASINumberUAT_Cust = "30232";
			public String vUserNameUAT_Cust = "30232bm1";
		    public String vPasswordUAT_Cust = "bilal.1234";
			
			
			
			//Stage
			public String vASINumberStage_Cust="30232";
			public String vUserNameStage_Cust= "bi20";
			public String vPasswordStage_Cust="bilal.1234";
	   //======================================================Replace Credentials============================================
			//Prod
			public String vASINumberProd = "30235";
			public String vUserNameProd = "22dec";
		    public String vPasswordProd = "test1234";
			
			
			
			//UAT
			public String vASINumberUAT = "33020";
			public String vUserNameUAT = "12917";
		    public String vPasswordUAT = "test1234";
			
			
			
			//Stage
			//public String vASINumberStage="30003";
			//public String vUserNameStage= "30003fa";
			//public String vPasswordStage="test1234";
			
			public String vASINumberStage="30035";
			public String vUserNameStage= "30035";
			public String vPasswordStage="test1234";
			
			
			//With Eit Manager Licence Supplier
			//Prod
			public String vEASINumberProd = "30232";
			public String vEUserNameProd = "fa20";
			public String vEPasswordProd = "test1234";
			
			//UAT
			public String vEASINumberUAT = "30232";
			public String vEUserNameUAT = "fa20";
			public String vEPasswordUAT = "test1234";
       
	        //Stage
			public String vEASINumberStage = "30232";
			public String vEUserNameStage = "30232bm";
			public String vEPasswordStage = "bilal.1234";
			
			
			//============================================Velocity Distributor Credentials===================================================//
		  
			//Without Eit Manager Licence Distributor
			//Prod
			 public String vDASINumberProd="101574";
			 public String vDUsernameProd="101574bm1";
			 public String vDPasswordProd="bilal.1234";

			
			
			//UAT
		   public String vDASINumberUAT="101574";
		   public String vDUsernameUAT="101574bm1";
		   public String vDPasswordUAT="bilal.1234";

		   //Stage
		   public String vDASINumberStage="101574";
		   public String vDUsernameStage="bi21";
		   public String vDPasswordStage="bilal.1234";
     
		   
		   
		   //With Eit Manager Licence Distributor
		   //Prod
		   public String vDEASINumberProd="101574";
		   public String vDEUsernameProd="mfaheem";
		   public String vDEPasswordProd="test1234";
		   
		   //UAT
		   public String vDEASINumberUAT="101574";
		   public String vDEUsernameUAT="mfaheem";
		   public String vDEPasswordUAT="test1234";
		   
		   //Stage
		   public String vDEASINumberStage="101574";
		   public String vDEUsernameStage="bi22";
		   public String vDEPasswordStage="bilal.1234";
			
    //==========================================Velocity Decorator Credentials=========================================================//
		   //Prod
		   public String vDecoASINumberProd="788888";
		   public String vDecoUsernameProd="e788888";
		   public String vDecoPasswordProd="Macro1234";
		  
		   //UAT
		   public String vDecoASINumberUAT="788888";
		   public String vDecoUsernameUAT="decofa";
		   public String vDecoPasswordUAT="test1234";
		   
		   //Stage
		   public String vDecoASINumberStage="125725";
		   public String vDecoUsernameStage="decobi";
		   public String vDecoPasswordStage="bilal.1234";
		   
		   
		   
		   //=======================================Random Number Generation================================================================
			Random rn = new Random();
			Random ch = new Random();
			int sRandam = rn.nextInt(100000) + 1;
			char schar = (char)(ch.nextInt(26) + 'a');
			
			public String Productname = ("Product"+-schar+schar);

			public String Productnumber = ("Num"+-+sRandam+schar);
			
			public String Productnumber1 = ("Pro"+-+sRandam);
			
			public String Productnumber2 = ("Pro"+-+schar);
			
			public String UPCCode = ("Product"+-+sRandam+schar+schar);

			public String specialname = ("Special"+-+sRandam+schar+schar);
			
			public String CopySpecialName = ("Copy Special"+-+sRandam);

            public String TradeName=("Trade Works"+-+schar+sRandam+"Test");

            public String TradeUpdateName=("Trade WoodRow"+-+schar+sRandam+"Test");

            public String TradeName1=("Trade Works"+-+schar+sRandam+sRandam+"Test");
 
            public String TradeName2=("Trade Works"+-sRandam+schar+sRandam+"Test");
            
            public String ShapeName=("Automation"+-sRandam+schar+sRandam+"Test");
            
            public String UpdateShapeName=("Automation"+-sRandam+schar+"Test");

            public String CategoryName=("Automation Category"+-sRandam+schar);

            public String CategoryUpdateName=("Automation Category"+-schar);

            public String CategoryName1=("Automation Category"+-+schar+sRandam);
            
            public String CategoryName2=("Automation Category"+-+sRandam);
            
            public String NewSubCategoryUpdatedName=("Automation SubCategory"+-+sRandam);
            

            public String RestrictedWordsAdd=("Automation RestrictedWords"+-+schar+sRandam);
            
            public String RestrictedwordsUpdate=("Automation RestrictedWords"+-+schar);
            
            public String Automation_Youtube=("Automation Youtube"+-+schar);
            
            public String Automation_Facebook=("Automation Facebook"+-+schar);
            
            public String Automation_Vimeo=("Automation Vimeo"+-+schar);
            
            public String CatalogName=("Catalog"+-+schar+sRandam);
            
            public String UpdatedCatalogName=("Catalog"+-+sRandam);

            public static String items[] = {"Mug","Basket", "Pen", "Golf", "bags", "USB"};
            
            public String EcatalogURL="https://s7d4.scene7.com/s7viewers/html5/eCatalogViewer.html?emailurl=https://s7d4.scene7.com/s7/emailFriend&serverUrl=https://s7d4.scene7.com/is/image/&config=Scene7SharedAssets/Universal_HTML5_eCatalog_Adv&contenturl=https://s7d4.scene7.com/skins/&asset=ASI/2016-17 PromoMatting Catalog";

            public String EmaskedURL="https://s7d4.scene7.com/s7viewers/html5/eCatalogViewer.html?emailurl=https://s7d4.scene7.com/s7/emailFriend&serverUrl=https://s7d4.scene7.com/is/image/&config=Scene7SharedAssets/Universal_HTML5_eCatalog_Adv&contenturl=https://s7d4.scene7.com/skins/&asset=ASI/2016-17 PromoMatting Catalog";

            public static String downloadPath = "C:\\Users\\Bilal.Mubarik\\Downloads";
            
            public String ColorTemplateName=("Color Template"+-+schar+sRandam);
            
            public String SizeTemplateName=("Size Template"+-+schar+sRandam);
}
