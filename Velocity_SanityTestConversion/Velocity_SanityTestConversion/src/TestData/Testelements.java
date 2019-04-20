package TestData;

public interface Testelements {

	//=================================Elements Locators For Velocity Supplier Application===================//
	
		public String ASI_Num="#txtAsiNum";
		public String USername="#txtUserName";
		public String Password="#txtPassword";
		public String LoginButton="#memberLogin > div:nth-child(6) > input";
        public String LoginSuccessfullValidation="//h4[contains(text(),'Search for the member you wish to Log in as:')]";
		public String EspLogo="#shellTop-view > div.container-fluid > div > div.span6.hidden-print > a";
        public String AddProduct_button="button[data-bind='click: $root.showProductAddModal";
        public String Product_Name="#prodName";
        public String ProductName_TextClick_BasicDetails="//*[@id='product-info-view']/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/label/strong";
        public String ProductName_BasicDetails="//input[contains(@id,'productName')]";
        public String Product_FullDescription_BasicDetails="//textarea[contains(@id,'productDescription')]";
        public String Product_description="#prodDesc";
        public String Product_type="#addNewProduct > div.modal-body > div > div:nth-child(3) > div > select";
        public String AddProduct_Applybutton="#addNewProduct > div.modal-footer > button";
        public String Product_Basicdetails="#shellTop-view > div.row-fluid > div > div.master-menu.top-menu > ul > li.top-route.active > a";
        public String Product_Number="#productNum";
        public String UPCCode="#upcCode";
        public String Product_Summary="#productSummary";
        public String Summary_OuterArea="//*[@id='product-info-view']/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/label/span[1]";
        public String CancelandExit="//div[contains(@class,'span5 text-right')]/a[3]";
        public String DeleteChanges="//a[contains(text(),'Delete Changes')]";
        public String ManageProductListing_ProductDescription="//td[@class='product-description']";
        public String ProductDetails_MenuBar_Verification_WhileScrolling="//div[contains(@class,'master-menu top-menu')]";
          //UAT/Prod
        //public String Productcategory_dropdown="#product-info-view > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div.control-group > div:nth-child(2) > button";
        
        //Stage
        public String Productcategory_dropdown="button[class='btn marginB5']";
        public String ProductCategory_Product_Button_Selection_Option="//button[contains(text(),'Product')][contains(@data-bind,'categoriesModalCancelBtn')]";
        public String ProductCategory_EIT_Button_Selection_Option="//button[contains(text(),'EIT')][contains(@data-bind,'categoriesModalCancelBtn')]";
        
        public String InventoryStatus_BasicDetail="//select[contains(@data-bind,'productLevelInventoryStatusCode')]";
        public String InventoryQuantity_BasicDetail="//input[contains(@data-bind,'productLevelInventoryQuantity')]";
       
       
        public String Category_Searchfield="#allCategoriesModal > div.modal-body > div:nth-child(1) > input";
        public String Product_category1="#allCategoriesModal > div.modal-body > div.col2.clearfix > div:nth-child(2) > div > input[type='checkbox']";
        public String Product_category2="#allCategoriesModal > div.modal-body > div.col2.clearfix > div:nth-child(1) > div > input[type='checkbox']";
        public String ProductCategory_ApplyButton="#allCategoriesModal > div.modal-footer > button";
        public String Product_attributes_Tab="#shellTop-view > div.row-fluid > div > div.master-menu.top-menu > ul > li:nth-child(2) > a";
        public String Product_attributes_1="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(1) > button:nth-child(1) > i.icon-color";
        public String Product_attributes_2="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(1) > button:nth-child(2) > i.icon-color";
        public String Product_Atrribute_Pink="//span[contains(text(),'Pink')]";
        public String Product_Attribute_Green="//*[@id='product-attributes-view']/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[2]/span";
        
        public String DeleteProduct_SecPosition="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[3]/div[2]/button[3]";
        public String ProductSupportValidationCheck="#main-nav > div > a > img";
        public String LoginSuccessfullValidation_Supplier="//span[contains(@id,'asinum')]";
        public String ScheduledInActivationValidation="//span[contains(text(),'This product will be inactivated on ')]";
        public String InactivationNowValidation="//strong[contains(text(),'Product is Inactive')]";
        public String ProductActiveValidation="//strong[contains(text(),'Product is Active')]";
        public String CopyProductValidation="//*[@id='product-info-view']/div[2]/div[1]/div[1]/div[1]/strong";
        public String LastUpdatedNameandDate_Validation="//div[contains(text(),'Last updated by')]";
        public String DefaultImageSelectedDiv="//li[contains(@class,'image-list-item')]/div";
        public String SeeAll_Categories_ManageProducts="//span[contains(@id,'showAllTermsText')]";
        //Prod or time being image Elements
        
        
        public String product_pricingtab="#shellTop-view > div.row-fluid > div > div.master-menu.top-menu > ul > li:nth-child(4) > a";
        
        //UAT/Prod
        //public String SPG_Listprice_1="#pgid_0 > div.row-fluid.data-grid > div:nth-child(2) > div:nth-child(3) > input";
        
        
        //Stage
        public String SPG_Listprice_1="input[data-select='list-price']";
        
        //UAT/Prod
       // public String SPG_Quantity_1="#pgid_0 > div.row-fluid.data-grid > div:nth-child(2) > div:nth-child(2) > input";
        
        //Stage
        public String SPG_Quantity_1="input[data-select='quantity']";
        
        
        public String QuantityDesending_ValidationError_Pricing="//div[contains(@class,'popover-content')]";
        
        //UAT/Prod
      // public String SPG_Pricecode_1="#pgid_0 > div.row-fluid.data-grid > div:nth-child(2) > div:nth-child(5) > select";
        
        //Stage
        public String SPG_Pricecode_1="div:nth-child(2) > div:nth-child(3) > select[data-select='discount']";
        
        
        //UAT/Prod
       // public String SPG_Quantity_2="#pgid_0 > div.row-fluid.data-grid > div:nth-child(3) > div:nth-child(2) > input";
        
        
        //Stage
        public String SPG_Quantity_2="div.row-fluid.data-grid.marginT10 > div > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > input[data-select='quantity']";
        
        //UAT/Prod
        //public String SPG_Listprice2="#pgid_0 > div.row-fluid.data-grid > div:nth-child(3) > div:nth-child(3) > input";
       
        //Stage
        public String SPG_Listprice2="div:nth-child(3) > div:nth-child(1) > input[data-select='list-price']";
        
        //UAT/Prod
        //public String SPG_Pricecode_2="#pgid_0 > div.row-fluid.data-grid > div:nth-child(3) > div:nth-child(5) > select";
        
        //Stage
        public String SPG_Pricecode_2="div:nth-child(3) > div:nth-child(3) > select[data-select='discount']";
        
        
        public String Product_Save_Button="#btnSection > div > div:nth-child(1) > button";
        public String Product_Image_Tab="a[data-href='#/product/media']";
        public String Product_Images_MediaLibrary_Button="#product-images-view > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > input";
        //Stage
        public String MediaLibrary_Image1="#imagesTabContent > div.span10 > div.large-scroll-y > div:nth-child(1) > div.mediaSelector > input[type='checkbox']";
        public String MediaLibrary_Image2="#imagesTabContent > div.span10 > div.large-scroll-y > div:nth-child(3) > div.mediaSelector > input[type='checkbox']";
       
        //Prod & UAT
       // public String MediaLibrary_Image1="#divMediaLibrary > div.MediaLibrary_images.modal.hide.mediaLibraryModal.in > div.modal-body-nomax > div.large-scroll-y > div:nth-child(1) > div.mediaSelector > input[type='checkbox']";
        //public String MediaLibrary_Image2="#divMediaLibrary > div.MediaLibrary_images.modal.hide.mediaLibraryModal.in > div.modal-body-nomax > div.large-scroll-y > div:nth-child(3) > div.mediaSelector > input[type='checkbox']";
        
        public String MediaLibrary_Popup_Confirmbutton="#divMediaLibrary > div.MediaLibrary_images.modal.hide.mediaLibraryModal.in > div.modal-footer > button";
        public String Product_Summary_Tab="#shellTop-view > div.row-fluid > div > div.master-menu.top-menu > ul > li:nth-child(8) > a";
        public String Product_Manage="#lnkCancelExit > a:nth-child(1)";
        public String Product_Active="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr > td.product-options > div:nth-child(2) > div > button:nth-child(1)";
        public String ProductAcive_2ndRow="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[3]/div[2]/div/button[1]";
        public String Product_Active_Confirm="#dashboard-view > div.modal.hide.publishSuccessModalDash.in > div.modal-footer > button";
        public String Product_Inactive="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr > td.product-options > div:nth-child(2) > button:nth-child(6)";
        public String Product_Inactive_Popup_Radio="unpublishNow";
        public String Product_Inactive_Confirm="#unpublishProductModal > div.modal-footer > button";
        public String Product_Inactive_Scheduled="unpublishLater";
        public String Product_Inactive_Scheduled_Confirm=".//*[@id='unpublishLaterSuccessModal']/div[3]/button";
        //public String Product_Inactive_Scheduled_Confirm="html/body/div[2]/div/section/section[1]/div[63]/div[3]/button";
        public String Copy_Button="//button[contains(@data-bind,'showCopyProductModal')]";
        public String Copy_Product_field="//input[contains(@id,'copyProdName')]";
        public String Copy_product_save="//button[contains(@data-bind,'enable: copyProductDialogIsValid')]";
        public String EditProduct="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr > td.product-options > div:nth-child(2) > button:nth-child(1)";
        public String Imagedelete="//a[2][contains(@data-bind,'removeMedia')]";
        public String KeywordCount="//span[contains(@data-bind,'productKeywordsCount')]/parent::div";
        public String BulkColorSaveSuccess_Validation="#product-attributes-view > div.modal.hide.sayModalSuccessCriteriaDialog.in > div.modal-header > h4";
        public String SearchKeywordVerification_BasicDetailScreen="//p[contains(text(),'Pro1')]";
        public String defaultcategoryVerification_BasicdetailScreen="//p[contains(text(),'FRAMES')]";
        
        //For Prod/UAT
        
        
        public String SupplierInfo_page="//a[contains(text(),'Supplier Info')]";
        
        //For UAT
        //public String SupplierInfo_page="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(5) > a";
        
        public String Help="div[class='pull-right']>ul>li.dropdown:nth-child(7)";
        public String LicenceAgreement="div[class='pull-right']>ul>li.dropdown:nth-child(7)>ul>li:nth-child(2) > a";
        public String Licenceclosed="#LicenseAgreementAlert > div.modal-header > button > i";
        //For Prod/UAT
       public String Manage_Product_Tab="//a[contains(text(),'Manage Products')]";
        
        //For UAt
       // public String Manage_Product_Tab="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(3) > a";
        
        public String MakeChangesActive="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr:nth-child(2) > td > div > div > div.span6.align-right.padR10 > a:nth-child(5)";
        public String MakeChangesActive_Confirm="#dashboard-view > div.modal.hide.publishSuccessModalDash.in > div.modal-footer > button"; 
        public String MakeActive_ButtonPricingStep="//*[@id='btnSection']/div[2]/div[1]/div/button[1]";
        public String MakeActiveConfirm_Pricing="//*[@id='product-pricing-view']/div[8]/div[3]/button";
        public String ProductKeywordfield="#token-input-productKeywords";
        public String SKUInventory="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.top-menu > ul > li:nth-child(6) > a";
        public String SKU_ToolTip=".//*[@id='product-sku-view']/div[1]/div[2]/button[1]";
        public String SKU_ToolTipMessage="html/body/div[2]/div/section/section[7]/div[1]/div[2]/div";
        public String SKUInventorySelection_dropdown="#product-sku-view > div:nth-child(4) > div.controls-row > div > select:nth-child(1)";
        public String SKUInventoryshow_button="#product-sku-view > div:nth-child(4) > div.controls-row > div > button:nth-child(3)";
        public String SKURequired1="//tbody[contains(@id, 'gridBody')]/tr[1]/td[2]/input";
        public String SKURequired2="//tbody[contains(@id, 'gridBody')]/tr[2]/td[2]/input";
        public String Invstatus1="//tbody[contains(@id, 'gridBody')]/tr[1]/td[3]/select";
        public String Invstatus2="//tbody[contains(@id, 'gridBody')]/tr[2]/td[3]/select";
        public String SKUquantity1="//tbody[contains(@id, 'gridBody')]/tr[1]/td[4]/input";
        public String SKUquantity2="//tbody[contains(@id, 'gridBody')]/tr[2]/td[4]/input";
        public String MPGOptions="//div[contains(@class,'subsection')]/div[2]/a";
        public String OptionName="//div[contains(@class,'modal hide PROPOptionModalBox in')]/div[2]/div/div[3]/input";
        public String OptionValue="//div[contains(@class,'modal hide PROPOptionModalBox in')]/div[2]/div/div[4]/ul/li/input";
        public String ApplyAddButton="//*[@id='product-attributes-view']/div[1]/div[2]/div[4]/div[3]/div[3]/button[2]";
        public String Apply="//*[@id='product-attributes-view']/div[1]/div[2]/div[4]/div[3]/div[3]/button[1]";
        public String MultipleGridRadio="//input[contains(@id,'rbMpConfigGrid')]";
        public String MultipleGridSetup_Color="//*[@id='mpConfigStep1']/div[4]/div/div/div[8]/div/div/input";
        public String MultipleGridSetup_option="//*[@id='mpConfigStep1']/div[4]/div/div/div[9]/div/div/input";
        public String MultipleGridSetup_Next="//*[@id='multipriceGridSetupModal']/div[3]/button";
        public String MultipleGridcriteria_White="//*[@id='mpConfigStep2']/div[2]/div/div/div/div[1]/input";
        public String MultipleGridcriteria_Blue="//*[@id='mpConfigStep2']/div[2]/div/div/div/div[2]/input";
        public String SaveandAdd="//*[@id='multipriceGridSetupModal']/div[3]/button[2]";
        public String SaveConfig="//*[@id='multipriceGridSetupModal']/div[3]/button[1]";
        public String NewAttributeAddedAtPricing_AfterEditing_Verification="//*[@id='pricingTabContent']/div[6]/div[3]/div/div/div/div[1]/div[2]/input";
        public String ClickToContinue_Button_Pricing="//button[contains(text(),'Click Here to Continue')]";
        public String BrownColor_Selection_Multipricing="//*[@id='mpConfigStep2']/div[2]/div/div/div/div[3]/input";
        public String DeleteGridButton_Multipricing="//*[@id='pricingTabContent']/div[6]/div[3]/div/div/div/div[1]/div[5]/span[2]/a";
        public String PriceExpand1="//a[contains(@data-toggle,'collapse')]";
        public String PriceExpand2="//*[@id='pricingTabContent']/div[6]/div[2]/div[1]/div/div/div[1]/div[1]/a";
        public String ProductNo_White="#pricingTabContent > div.accordion > div:nth-child(1) > div > div > div > div.accordion-heading.clearfix.normalImp.pad20 > div:nth-child(3) > input";
        public String ProductNo_Blue="#pricingTabContent > div.accordion > div:nth-child(2) > div > div > div > div.accordion-heading.clearfix.normalImp.pad20 > div:nth-child(3) > input";
        public String MG_Quantity1="//input[contains(@data-select,'quantity')]";
        public String MG_ListPrice1="//input[contains(@data-select,'list-price')]";
        public String MG_Pricecode1="html/body/div[2]/div/section/section[6]/div[3]/div[1]/div[6]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[5]/select";
        

        public String MG_Quantity2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/input";
        public String MG_ListPrice2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/input";
        public String MG_PriceCode2="//select[contains(@data-select,'discount')]";
        
        public String SKUInv_Sel1="//div[contains(@class,'well well-small form-horizontal')]/select[1]";
        public String SKUInv_Sel2="//div[contains(@class,'well well-small form-horizontal')]/select[2]";
        public String SKUQuantityReq="//tbody[contains(@id,'gridBody')]/tr/td[3]/input";
        public String Availability_Tab="//a[contains(text(),'Availability')]";
        public String Availability_Firstvalue="//*[@id='sectionProductAvailability']/div[1]/div[4]/div[1]/select";
        public String Availability_Secondvalue="//*[@id='sectionProductAvailability']/div[1]/div[5]/div[1]/div[1]/select";
        public String Availability_showbutton="//button[contains(text(),'Show')][contains(@class,'btn btn-small btn-primary')]";
        public String BulkProduct_checkbox="//input[contains(@data-bind,'checked: isSelected')]";
        public String BulkProduct_Checkbox2="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[1]/input";
        public String BulkProduct_Checkbox3="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[1]/input";
        public String BulkEdit_Button="//strong[contains(text(),'Bulk Edit')]";
        public String Bulk_keyword="//span[starts-with(text(), 'Keywords')]";
        public String BulkEdit_Popup="//a[contains(@class,'btn btn-primary')]";
        public String BulkEdit_SelectProd="//input[contains(@name,'rbSelectAll')]";
        public String BulkEdit_AllProdRadio="//input[contains(@name,'rbSelectAll')]";
        public String BulkEdit_AllFilteredProducts="//input[contains(@name,'rbSelectAll')]";
        public String BulkCancelButton="//*[@id='bulkEditOptionsModal']/div[3]/a[1]";
        public String BulkEdit_CategorySelect_ForAllFilteredradio="//a[contains(@data-bind,'performFilterSearch')]";
        
        public String BulkEdit_AddKeyword="//a[contains(text(),' Add Keywords ')]";
        public String BulkEdit_AddKeywordInsert="//input[contains(@id,'token-input-productKeywords-Supplier')]";
        public String Addkeywordpopbutton="#bulkEditKeywordsModal-Supplier > div.modal-footer.well > button > span";
        public String KeywordAdd_OK=".//*[@id='sayModalSuccessForm']/div[3]/button";
        
        public String Bulk_Addcolor="//span[starts-with(text(), 'Add Color')]";
        public String Bulkcolor_Brown="//span[contains(text(),'Brown')]";
        public String BulkColor_ApplyButton="//button[contains(text(),'Bulk Apply')]";
        public String BulkColor_Confirm="//button[contains(text(),'Ok')]";
        public String BulkColor_Success="#product-attributes-view > div.modal.hide.sayModalSuccessCriteriaDialog.in > div.modal-footer > button";
       
        public String SearchProduct_field="//input[contains(@id,'supplierSearchTextBox')]";
        public String SearchProduct_Button="//a[contains(@id,'SearchButtonParent')]";
        public String RemoveSearched1="//i[contains(@id,'chkSearchTerm')]";
        
        public String DefaultSearchedoption="//a[contains(text(),'CERTIFICATE HOLDERS & FRAMES')]";
        public String DefaultSearchedoptionStage="//a[contains(text(),'Certificate Holders & Frames')]";
        public String RemoveSearched2="//i[contains(@id,'removeFilter')]";
        
        public String SortBy_Button="//strong[contains(text(),'Sort by')]";
        public String SortBy_ProductName="//a[contains(text(),'Product Name')]";
        public String SortBy_ProductNumber="//a[contains(text(),'Product Number')]";
        public String SortBy_Catalog="//ul[contains(@class,'dropdown-menu')]/li[4]/a";
        public String SortBy_LastUpdated="//a[contains(text(),'Last Updated')]";

        public String DeleteProduct_Button="//button[contains(@data-bind,'showDeleteProductModal')]";
        public String DeleteAlert_Confirm="//a[contains(@data-bind,'deleteProduct')]";

        public String Orderingoption_alert_Yes="//div[contains(@class,'modal hide PROPOptionModalBoxConfirmation in')]/div[3]/a[1]";
        public String ProductType="//select[contains(@class,'input-block-level')]";
        public String PriceCode1="//div[2][contains(@class,'dataCol')]/div[5]//select[contains(@data-select,'discount')]"; 
        public String PriceCode2="//div[3][contains(@class,'dataCol')]/div[5]//select[contains(@data-select,'discount')]";
        
        
        //UAT/Prod
      // public String MGP_PriceCode1="//div[contains(@class,'accordion-body in collapse')]/div[1]/div[2]/div[5]/select";
       
       //Stage 
        public String MGP_PriceCode1="//div[2]/div[3]/select[contains(@data-select,'discount')]";
        
        
        public String MGP_PriceCode2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/select";
        public String ProductSupport="//a[contains(text(),'Product Support')]";
        
        public String PricingUpcharges_Tab="//a[contains(text(),'Upcharges')]";
        public String AddUpcharge_Button="//span[contains(text(),'Add an Upcharge')]";
        public String Upcharge_ProductColor="//*[@id='mpUpchrgConfigStep1']/div/div/div/div[2]/input";
        public String UpchargeSetup_NextButton="//button[contains(@data-bind,'upchargeConfigChange')]";
        public String IndividualGrid_Checkbox="//input[contains(@data-bind,'createIndividualUpchargeGrids')]";
        public String UpchargeColorWhite="//*[@id='mpUpchrgConfigStep2']/div[2]/div/div/div/div[1]/input";
        public String UpchargeColorBlue="//*[@id='mpUpchrgConfigStep2']/div[2]/div/div/div/div[2]/input";
        public String UpchargeApplyButton="//button[contains(@data-bind,'upchargeConfigChange')][contains(text(),'Apply')]";
        public String UpchargeGrid1_Expand="//label[contains(text(),'Upcharge')]/parent::div/a";
        public String UpchargeGrid2_Expand="//div[contains(@class,'accordion-heading clearfix normalImp')]//div[contains(@class,'pull-left desc')]//label[contains(text(),'Upcharge')]/parent::div//a[contains(@class,'collapsed')]";
        public String UpchargesGrid1_Quantity="//input[1][contains(@data-bind,'validateQuantity')]";//20 position
        public String UpchargesGrid1_ListPrice="//input[contains(@data-select,'list-price')]"; //20 position
        public String UpchargesGrid1_Pricecodes="//select[contains(@data-select,'discount')]"; //23 position
        public String UpchargesGrid2_Quantity="//input[1][contains(@data-bind,'validateQuantity')]"; //Position 30
        public String UpchargesGrid2_ListPrice="//input[contains(@data-select,'list-price')]"; //Position 30
        public String UpchargesGrid2_Pricecodes="//select[contains(@data-select,'discount')]"; //Position 33
        public String SaveButton_ProductCreation="//button[contains(@data-bind,'command: saveProduct')]";
        public String SaveButton_PricingScreen="button[data-bind='command: savePricing, activity: savePricing.isExecuting']";
        public String SaveButton_AfterImageDragandDrop_Change="button[data-bind='command: saveProductMedia, activity: saveProductMedia.isExecuting']";
        public String SaveButton_MediaLibrary="//button[contains(@data-bind,'command: saveProductMedia')]";
        public String NetCostValidation_UpchargesPricing="//input[contains(@data-bind,'value: netCost, enable: (isNetCostEnabled() && !$parent.isQUR() && isEnabled())')]";
        public String AddCatalogSource_BulkEdit="//span[contains(text(),'Add Catalog Source')]";
        public String DeleteCatalogSource_BulkEdit="//span[contains(text(),'Delete Catalog Source')]";
        public String CatalogSelectionDropdown="//em[contains(text(),'(select one)')]";
        public String CatalogSelection="//span[contains(text(),'CAT link on 8 sept')]";
        public String CatalogSaveButton="//button[contains(text(),'Bulk Save')]";
        public String CatalogSaveMailAlert="#product-info-view > div.modal.hide.sayModalSuccessCriteriaDialog.in > div.modal-footer > button";
        public String CatalogSource_InsertionField="//input[contains(@id,'token-input-bulkDeleteCatalogsSourceInput')]";
        public String CatalogDelete_SaveButton="#bulkDeleteCatalogsSource > div.modal-footer > div > button:nth-child(2) > span";
        public String AddOption_BulkEdit="//span[contains(text(),'Add Option')]";
        public String AddValuesToOption_BulkEdit="//span[contains(text(),'Add Values To Option')]";
        public String AddCustomOptionAlert_Yes_Click="#dashboard-view > div.modal.hide.OptionModalBoxConfirmation.in > div.modal-footer > a:nth-child(1)";
        public String CustomOption_OptionType="#dashboard-view > div.modal.hide.OptionModalBox.in > div.modal-body > div > div:nth-child(2) > select";
        public String CustomOption_OptionName="#dashboard-view > div.modal.hide.OptionModalBox.in > div.modal-body > div > div:nth-child(3) > input";
        public String CustomOption_OptionValue="#token-input-";
        public String CustomOption_BulkSaveButton="#dashboard-view > div.modal.hide.OptionModalBox.in > div.modal-footer > button:nth-child(4)";
        public String CustomOption_CancelOption="#dashboard-view > div.modal.hide.OptionModalBox.in > div.modal-footer > a";
        public String CustomOptions_OptionsHeading="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.well.well-small > strong";
        public String CustomOptions_NewOptionValidation="//span[contains(text(),'Product 3')]";
        public String BulkAddValuesToOptions_OptionType="#bulkAddValuesToOptionModal > div.modal-body > div.control-group > div:nth-child(1) > select";
        public String BulkAddValuesToOptions_OptionName="//input[contains(@id,'token-input-')]";
        public String BulkAddValuesToOptions_Value="#token-input-txtBulkAddOptionValues";
        public String BulkAddValuesToOptions_SaveButton="#bulkAddValuesToOptionModal > div.modal-footer > button:nth-child(2) > span";
        public String OptionsEditButton="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.subsection > div:nth-child(3) > div.span5.align-right > a:nth-child(1)";
        public String NewOptionValueValidation="//li[contains(text(),'Test')]";
        public String NewOptionValue_cancelButton="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.modal.hide.PROPOptionModalBox.in > div.modal-footer > a";
        public String NewOptionDeleteButton="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.subsection > div:nth-child(3) > div.span5.align-right > a.icon-remove";
        public String NewOptionDeleteConfirm="//span[contains(text(),'Yes, Delete this Product option')]";
        public String EditOption_ApplyButtonValidation="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.modal.hide.PROPOptionModalBox.in > div.modal-footer > button:nth-child(4)";
        public String EditOption_ApplyandAddButtonValidation="#product-attributes-view > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div.modal.hide.PROPOptionModalBox.in > div.modal-footer > button:nth-child(5)";
        public String SaveButton_ProductLevel="//button[contains(text(),'Save')]";
        public String EITCategoryApply_Button="#allEITmemberCategoriesModal > div.modal-footer > button";
        public String EITCategoryRemoval="#product-info-view > div.well.well-small > div:nth-child(2) > ul > li > span";
        public String MarketSegment_BulkEdit_Option="//span[contains(text(),'Market Segments')]";
        public String MarketSegment_RemoveButton_BulkEdit="//button[contains(text(),'Remove Market Segment')]";
        public String MarketSegment_AddMarketSegment_BulkEdit="//button[contains(text(),'Add Market Segment')]";
        public String MarketSegmentSelection_Dropdown="//*[@id='menuMarketSegment']/span[1]";
        public String MarketSegmentSelection_BulkEdit="//input[contains(@data-bind,'selectMarketSegment')]";
        public String MarketSegmentSelection_Second="//*[@id='chkSeg_USAALL']";
        public String BulkEdit_MarketSegment_SaveandApply="//button[contains(@data-bind,'BulkSaveAndApply(true)')]";
        public String MarketSegmentBulkEditAdd_Verification="//span[contains(text(),'USA')][contains(@data-bind,'selectedMargetSegments')]";
        public String MarketSegmentBulkEditRemove_Verification="//span[contains(text(),'Select Market Segment')][contains(@data-bind,'selectedMargetSegments')]";
        public String Pricing_DefaultCurrencySelected_With2MarketSegments_Verification="//span[contains(@data-bind,'selectedPriceCurrencies')][contains(text(),'USD')]";
        public String Canada_MarketSegment_Selection="//input[contains(@id,'chkSeg_CANALL')]";
        public String Canada_MarketSegment_CustomProductVerification="//span[contains(text(),'Canada')]";
        public String USA_MarketSegment_CustomProductVerification="//span[contains(text(),'USA')]";
        public String MarketSegmentMultiCountry_Verification_BasicDetails_Screen="//span[contains(text(),'USA')][contains(text(),'Canada')]";
        //====================================================Velocity Distributors Locators====================================================//
        public String EspWebsiteLogo="//a[contains(@class,'span2 espwebsitesLogo')]";
        public String AddProduct_Dist="//strong[contains(text(),'+ Add a New Product')]";
        //public String AddProduct_Dist="//button[contains(text(),'+ Add a New Product ')]";
        public String DistributorLoginSuccess_Validation="//span[contains(text(),'asi/101574')]";
        public String DecoratorLoginSuccess_Validation="//span[contains(text(),'asi/125725')]";
        public String DecoratorLoginSuccessUAT_Validation="//span[contains(text(),'asi/788888')]";
        
        //For UAT,PROD(Decorator)
        public String DistSKUDec_InvStatus1="//tbody[contains(@id,'gridBody')]/tr[1]/td[3]/select";
        public String DistSKUDec_InvStatus2="//tbody[contains(@id,'gridBody')]/tr[2]/td[3]/select";
       
        
        
        //For UAT,PROD(Distributor)
       public String DistSKU_InvStatus1="//tbody[contains(@id,'gridBody')]/tr[1]/td[3]/select";
       public String DistSKU_InvStatus2="//tbody[contains(@id,'gridBody')]/tr[2]/td[3]/select";
        
        
        
        //For UAT,PROD(Decorator)
        public String DistSKUDec_Quantity1="//tbody[contains(@id,'gridBody')]/tr[1]/td[4]/input";
        public String DistSKUDec_Quantity2="//tbody[contains(@id,'gridBody')]/tr[2]/td[4]/input";
        
        //FOR UAT,PROD(Distributor)
        public String DistSKU_Quantity1="//tbody[contains(@id,'gridBody')]/tr[1]/td[4]/input";
        public String DistSKU_Quantity2="//tbody[contains(@id, 'gridBody')]/tr[2]/td[4]/input";
        
        
        
        public String PrivateProduct_Checkbox="//input[contains(@data-bind,'distOnlyView')]";
        public String Dist_ManageProducts="#shellTop-view > div > div > ul > li:nth-child(1) > a";
        
        public String Dist_ImportProductButton="#importExportButtonGroup > button:nth-child(8)";
        public String DownloadTemplatePopButton="#importProductModal > div:nth-child(1) > div.modal-footer > div.span6.text-align-left > button";
        public String ProductDataFormat="//select[contains(@data-bind,'dataFormats')]";
        public String CloseImportProduct_Popup="//*[@id='importProductModal']/div[1]/div[1]/button";
        public String SearchCopy_Button="//strong[contains(text(),'Search & Copy')]";
        public String QuickSearch_Product="html/body/form/div[6]/section/div/div/div[1]/div[1]/div[1]/div/span[1]/input";
        public String QuickSearch_Go="html/body/form/div[6]/section/div/div/div[1]/div[1]/div[1]/div/span[6]/a";
        public String CreateCustom_Products="html/body/form/div[6]/section/div/div/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div[8]/a";
        public String BackToWebsiteButton="//strong[contains(text(),'Back to Websites')]";
        public String Websites_GlobalFeaturesTab="html/body/form/div[5]/header/div/div[4]/div/div[1]/div/button[1]";
        public String Globalfeatures_CustomProducts="html/body/form/div[5]/header/div/div[4]/div/div[1]/div/ul[1]/li[3]/a";
        
        
        
        
        
  //===================================================Velocity With Licence locators for supplier========================================//
       
        public String Supplier_asi_Insertion="#supplierSearchTextBox";
    	
        //Prod/UAT
        //public String Supplier_asi_search="#eit-dashboard-view > div:nth-child(2) > div > a > i";
    	
        
        //Stage
        public String Supplier_asi_search="a[data-bind='click: performSupplierSearch']";
    	
    	//Prod/UAT
    	//public String Supplier_selection="#eit-dashboard-view > div:nth-child(5) > div > div:nth-child(1) > div > div > div.span4 > a:nth-child(5) > strong";
       
        //Stage
    	public String Supplier_selection="button[data-bind='click: $root.loginAsSupplier, enable: !hasNotes()']";
    	
    	public String EITManager_Tab="//a[contains(text(),'EIT Dashboard')]";
        public String EITReports_Tab="html/body/div[2]/div[1]/div/div/ul/li[2]/a";
        public String EITReports_Selectreport_dropdown="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[1]/select";
        public String EITReports_Zcodereview1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[8]/div[2]/label[1]/input";
        public String EITReports_Zcodereview2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[8]/div[2]/label[2]/input";
        public String EITReports_Download1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[8]/div[3]/button";
        public String RecentProducts="#sectionSearchBoost > div.hidden-print.span3.gray-box-bordered > div.row-fluid.span11.activity > div:nth-child(2) > a > label";
        public String ProductNumber_Link_Scorecard="//strong[contains(text(),'Product Number')]/parent::a";
        
        public String ProductNumberValidation_Basicdetails_Screen="//strong[contains(text(),'Product Number')]/parent::label";
        
        public String SKU_Link_Scorecard="//strong[contains(text(),'SKU')]/parent::a";
        
        public String SupplierRatingOption_Scorecard="//p[contains(text(), 'Supplier Performance Rating')]";
        public String ImprovementCenter_TextChangeValidation="//span[contains(text(), 'IMPROVEMENT CENTER')]";
        public String SKUScorecardLinkToProductDetails_ValidationCheck="#product-sku-view > div:nth-child(1) > div.controls-row.padTop5 > label > strong";
        public String PerformanceRatingText_SupplierInfoScreen="#preferences-view > div > div.span6.columnDivider > div:nth-child(1) > span > strong";
        public String ScorecardScreenDisplay_SuccessfullyValidation="//section[contains(@id,'scoreboard-view')]";
        public String SGREITUser_SearchValidation="//span[contains(text(),'1502')]";
        public String EITReports_ProductwithouImages1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[1]/div[2]/div[1]/label[1]/input";
        public String EITReports_ProductwithouImages2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[1]/div[2]/div[1]/label[2]/input";
        public String EITReports_ProductwithouImages3="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[1]/div[2]/div[1]/label[3]/input";
        public String EITReports_Download2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[1]/div[3]/button";
        public String ExportProductEmail_PopupValidation="//span[contains(text(),'Your export is in process. You will receive an email shortly with the result.')]";
        public String EITReports_ProductsinReview1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[2]/div[2]/label[1]/input";
        public String EITReports_ProductsinReview2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[2]/div[2]/label[2]/input";
        public String EITReports_ProductsinReview3="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[2]/div[2]/label[3]/input";
        public String EITReports_Download3="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[2]/div[5]/button";
        
        public String EITReports_Activecatalog1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[3]/div[2]/label[1]/input";
        public String EITReports_Activecatalog2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[3]/div[2]/label[3]/input";
        public String EITReports_Download4="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[3]/div[3]/button";
        
        public String EITReports_ActiveSuppliers1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[4]/div[2]/label[3]/input";
        public String EITReports_ActiveSuppliers2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[4]/div[2]/label[4]/input";
        public String EITReports_Download5="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[4]/div[3]/button";
        
        public String EITReports_ActiveQURReports1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[5]/div[2]/label[2]/input";
        public String EITReports_ActiveQURReports2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[5]/div[2]/label[3]/input";
        public String EITReports_Download6="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[5]/div[3]/button";
        
        public String EITReports_OrphanReports1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[6]/div[2]/label[2]/input";
        public String EITReports_OrphanReports2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[6]/div[2]/label[3]/input";
        public String EITReports_Download7="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[6]/div[3]/button";
        
        public String EITReports_ConfirmAccurate1="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[7]/div[2]/label[2]/input";
        public String EITReports_ConfirmAccurate2="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[7]/div[2]/label[3]/input";
        public String EITReports_Download8="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[7]/div[3]/button";
        
        public String EITReports_InactiveProduct_field="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[9]/div[2]/input";
        public String EITReports_Download9="html/body/div[2]/div[2]/div/section/section[2]/div/div/div[2]/div[9]/div[3]/button";

        public String ManageProducts_Tab="//a[contains(text(),'Manage Products')]";
        public String ExportProduct_Button="//button[contains(@data-bind,'showProductExportModal')]";
        public String ExportProduct_Confirm="//button[contains(@id,'btnExport')]";
        public String Export_Ok="//div[contains(@class,'modal hide fade in')]/div[3]/div[2]/button";
        public String ExportFormat_Dropdown="//select[contains(@data-bind,'importTemplatesSorted')]";
        public String ColorOk_BulkEdit="//button[contains(@data-bind,'confirmBulkCriteriaOperation')]";
        public String PrintPreview_MoreSettings_Button="#more-settings > a";
        public String HeaderFooter_Printpreview_Checkbox="#header-footer-container > label > input";
        public String BackgroundGraphics_Printpreview_Checkbox="#css-background-container > label > input";
        public String PrintScoreboard="#print-header > div > button.print.default";
        public String EITAdmin_Tab="//a[contains(text(),'EIT Admin')]";
        public String EITAdmin_CompanyLevel="//a[contains(@id,'eitAdminSupplierHeader')]";
        public String EITAdmin_OptionSelection_Dropdown="//select[contains(@data-bind,'selectedCompanyLevelOperation')]";
        public String EnableDisableImportExportButton_ASINo_Field="//input[contains(@data-bind,'asiNum')][contains(@class,'input-small')]";
        public String ShowOptions_button_ImportExportButton_ASI="//button[contains(text(),'Show Options')]";
        public String EnableProductImportCheckbox="//input[contains(@data-bind,'enableImport')]";
        public String EnableProductExportCheckbox="//input[contains(@data-bind,'enableExport')]";
        public String ApplyButton_ImportExportButtons_Settings="//button[contains(text(),'Apply')]";
        public String EITMember_Logout_Toggledropdown="//a[contains(@data-toggle,'dropdown')]";
        public String Logoff_EITMember="//a[contains(text(),'Log off')]";
        public String ExportButton_ManageProducts="//strong[contains(@data-bind,'exportButtonLabel')]";
        public String ImportButton_ManageProducts="//strong[contains(text(),'Import Products')]";
        public String CustomerByASI_EITAdmin="//input[contains(@data-bind,'selectedCustType()')]";
        public String DisableScoreboard_EITAdmin="//input[contains(@name,'disableProdScorecard')]";
        public String DisableScoreboard_Apply="//button[contains(@data-bind,'click: showConfirmationModal')]";
        public String DisableScoreboard_Confirm="//button[contains(@data-bind,'click: confirmOk')]";
        public String EITAdmin_AdminReports="//a[contains(@id,'eitAdminReportHeader')]";
        public String AdminReports_Supplier_Checkbox="//input[contains(@value,'SPLR')]";
        public String AdminReports_Distributor_Checkbox="//input[contains(@value,'DIST')]";
        public String AdminReports_Decorator_Checkbox="//input[contains(@value,'DECR')]";
        public String DownloadExcel_AdminReports="//button[contains(@data-bind,'prodsMadeActiveFilters')]";
        public String Helpandsupport_Button=".//*[@id='_elev_io']/div/div/button";
        public String MoreOptions_Helpcenter=".//*[@id='_elev_io']/div/div/div/span";
        public String HelpCenter_EspUpdatesHomepage="#_elev_io > div > div > div > div:nth-child(1)";
        public String HelpCenter_EspUpdatesTraining="#_elev_io > div > div > div > div:nth-child(2) > div > div";
        public String HelpCenter_BasicdetailsPage="#_elev_io > div > div > div > div:nth-child(3) > div > div";
        public String HelpCenter_AttributesTab="#_elev_io > div > div > div > div:nth-child(4) > div > div";
        public String HelpCenter_ImprintingTab="#_elev_io > div > div > div > div:nth-child(5) > div > div";
        public String HelpCenter_PricingTab="#_elev_io > div > div > div > div:nth-child(6) > div > div";
        public String HelpCenter_ImagesTab="#_elev_io > div > div > div > div:nth-child(7) > div > div";
        public String HelpCenter_SKUInventryTab="#_elev_io > div > div > div > div:nth-child(8) > div > div";
        public String HelpCenter_AvailabilityTab="#_elev_io > div > div > div > div:nth-child(9) > div > div";
        public String HelpCenter_SupplierInfoTab="#_elev_io > div > div > div > div:nth-child(10) > div > div";
        public String HelpCenter_MediaLibraryTab="#_elev_io > div > div > div > div:nth-child(11) > div > div";
        public String HelpCenter_ManageProductsTab="#_elev_io > div > div > div > div:nth-child(12) > div > div";
        public String HelpCenter_SpecialsTab="#_elev_io > div > div > div > div:nth-child(13) > div > div";
        public String HelpCenter_CopyProduct="#_elev_io > div > div > div > div:nth-child(14) > div > div";
        public String HelpCenter_CatalogandComplainceTab="#_elev_io > div > div > div > div:nth-child(15) > div > div";
        public String HelpCenter_DataCenterESP="#_elev_io > div > div > div > div:nth-child(16) > div > div";
        public String HelpCenter_ImageRequirement="#_elev_io > div > div > div > div:nth-child(17) > div > div";
        public String HelpCenter_EditSingleProduct="#_elev_io > div > div > div > div:nth-child(18) > div > div";
        public String HelpCenter_SummaryTab="#_elev_io > div > div > div > div:nth-child(19) > div > div";
        public String HelpCenter_AddNewproduct="#_elev_io > div > div > div > div:nth-child(20) > div > div";
        public String HelpCenter_SearchfilterSortProductsTab="#_elev_io > div > div > div > div:nth-child(21) > div > div";
        public String HelpCenter_ESPSpecialsFAQS="#_elev_io > div > div > div > div:nth-child(22) > div > div";
        public String HelpCenter_Search="#_elev_io_placebo";
        public String Search_AttributesTab="#_elev_io > div > div > div._4fjpa._elevio_module_icon._elevio_module_icon_1";
        public String HelpCenter_BackButton="#_elev_io > div > div > div:nth-child(1) > div > div._45r9y._elevio_navbar > div._1pzly._jfgu2._qq9gi > div > svg";
        public String HelpCenter_TrainingTab="#_elev_io > div > div > div._4fjpa._elevio_module_icon._elevio_module_icon_4 > div._d9ggd";
        public String HelpCenter_TrainingTab_ForDistributors="#_elev_io > div > div._ublfa._1rkeb > p:nth-child(1)";
        public String HelpCenter_TrainingTab_ForSuppliers="#_elev_io > div > div._ublfa._1rkeb > p:nth-child(2) > span";
        public String HelpCenter_ContactsTab="#_elev_io > div > div > div._4fjpa._elevio_module_icon._elevio_module_icon_6 > div._d9ggd > div > svg";
        public String ContactsTab_BackButton="#_elev_io > div > div > div:nth-child(1) > div > div > div._1pzly._jfgu2._qq9gi > div > svg";
        public String Finish_HelpSupport="#_elev_io > div > div > div:nth-child(1) > div > div._45r9y._elevio_navbar > div._ir0vf._jfgu2 > div > svg";
        public String HelpandSupportSanity_ValidationCheck="//div[contains(text(),'Was this helpful?')]";
        public String Iframe_SwitchingHelpSupport="//iframe[contains(@class,'_1ynss')]";
        public String TrainingOptions_HelpSupport="//span[contains(text(),'Training Options for Distributors')]";
        public String EITAdmin_CompanyLevel_OperationSelection="//select[contains(@data-bind,'companyLevelOperationList')]";
        public String ScorecardPrintPreview="//embed[contains(@id,'plugin')]";
        public String NoImportExport_Invisible="//button[contains(@class,'btn btn-large')]";
        public String CatalogAndComplaince_Invisible="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(4) > a";
        public String SupplierInfo_Invisible="//a[contains(text(),'Supplier Info')]";
        public String LicenceAgreementText="//h3[contains(text(),'License Agreement')]";
        
        
        //=================================Elements Locators For Specials Feature===================//
    	
        //For Production
        public String Specials_tab="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(5) > a";
    	
    	//For UAt
    	//public String Specials_tab="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(6) > a";
    	
    	
    	public String Specialname="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(1) > div > div > div > input";
        public String CreateSpecial_Button="#specials-view > div.row-fluid > div.specialsHeader > button > strong";
    	public String Special_type_dropdown="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(3) > div > div > select";
        public String Special_description="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(5) > div > div > div > textarea";
        public String Special_Startdate="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(7) > div > div > div > div:nth-child(1) > div > button > img";
        public String Special_Enddate="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(7) > div > div > div > div:nth-child(4) > div > button > img";
        public String Promo_code="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span8 > div:nth-child(9) > div > div > div > input";
        public String Specials_save_button="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(3) > div.span1 > div > div > div > button";
        public String Add_Product_button="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(4) > div > div.pull-right > button.btn.btn-danger > strong";
        public String Product_popup_selection="#SpecialsAddProductsModal > div.modal-body > div.row-fluid.block > div.span10 > div:nth-child(1) > div.mediaSelector";    
        public String Addproduct_popup_button="#SpecialsAddProductsModal > div.modal-footer > button.btn.btn-danger";
        public String Delete_product_button="#tblSpecialsProducts > tbody > tr:nth-child(1) > td:nth-child(8) > button > i";
        public String Delete_OK="#specialConfirmationModal > div.modal-footer > button";
        public String Nav_Back_Specials=".//*[@id='specials-view']/div[1]/div[2]/div/div[1]/a";
        public String Specials_Edit_button="#tblSpecials > tbody > tr:nth-child(2) > td:nth-child(2) > button";
        public String flyer_upload_button="#flyer-to-upload";
        public String flyer_submit_button="#btnUploadImageFlyer";
        
        public String Manage_Addspecial_button="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(2) > table > tbody > tr > td.product-options > div.button-fixed.marginT10 > button:nth-child(1) > span";
        public String Search_ManageProducts="#supplierSearchTextBox";
        public String Search_Button_ManageProducts="#SearchButtonParent";
        public String Addspecial_radiobutton="rbSpecials";
        public String Addspecial_Confirm_button="#addProductsToSpecialModal > div.modal-footer > button";
        public String Product_selection_update="#SpecialsAddProductsModal > div.modal-body > div.row-fluid.block > div.span10 > div:nth-child(2) > div.mediaSelector";
        public String ViewSpecial_Button="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(2) > table > tbody > tr:nth-child(1) > td.product-options > div.button-fixed.marginT10 > button:nth-child(2) > span";
        public String Viewspecial_popup_Ok="#ShowProductSpecialsModal > div.modal-footer > button";
        public String Select_all_checkboxdelete="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(5) > div.controls-row > div.control-group > div > div > div.span6.pull-left > span > input[type='checkbox']";
        public String Selection_all_deletebutton="#specials-view > div.row-fluid > div.row-fluid > div > div:nth-child(5) > div.controls-row > div.control-group > div > div > div.span6.pull-left > button.btn.btn-inverse";
        public String Selection_all_Confirmbutton="#specialConfirmationModal > div.modal-footer > button";
        public String Special_Inactivate_Button="#tblSpecials > tbody > tr:nth-child(1) > td:nth-child(10) > button";
        public String Special_Inactivate_Confirm="#inactivateSpecialConfirmationModal > div.modal-footer > button";
        public String Special_Tab_Action="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(6) > a";
        public String Manage_Tab_Action="#shellTop-view > div.row-fluid > div > div.master-menu.tab-menu > ul > li:nth-child(3) > a";
        public String SearchSpecial_SearchField="//input[contains(@data-bind,'searchSpecialByName')]";
        public String SearchSpecial_SearchButton="//a[contains(@data-bind,'searchSpecialByName')]";
        public String ActionDropdownSpecialPage="//select[contains(@data-bind,'actionSpecial')]";
        public String CopySpecial_Creation_Verification="//*[@id='tblSpecials']/tbody/tr[1]/td[2]";
        public String CopyProduct_Specials="//button[contains(@data-bind,'copySpecialProducts')]";
        public String SpecialSelection_For_Products="//input[contains(@data-bind,'copySpecialProductsId')]";
        public String CopyProductsPopup_FilterChange="//select[contains(@data-bind,'FilterByStatusCopyProduct')]";
        public String CopyProductSelectionConfirm="//button[contains(@data-bind,'selectCopySpecialProducts')]";
        public String CopyProductTable="//*[@id='tblSpecialsProducts']/tbody";
                
//=============================================Trade Elements=============================================================================//
        public String EITDashboardButton="//a[contains(text(),'EIT Dashboard')]";
        public String EITAdminTab="//a[contains(text(),'EIT Admin')]";
        public String GlobalListsTab="//a[contains(@id,'eitAdminGlobalHeader')]";
        public String TradeAddButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[4]/button";
        public String TradeName_Field="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div[2]/input";
        public String TradeCreateButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[2]/div[3]/button";
        public String TradeSearchfield="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/input";
        public String TradeSearchButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/a/i";
        public String TradeEditButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr/td[2]/button";
        public String TradeUpdateField="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[4]/div[2]/div[2]/input";
        public String TradeUpdateConfirm="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[4]/div[2]/div/div[2]/div[4]/div[3]/button";
        public String TradeRejectButton="//button[contains(text(),'Reject')]";
        public String TradeRejectConfirm="//button[contains(text(),'Confirm')]";
        public String TradeApprovedButton="//button[contains(text(),'Approve')]";
        public String TradeApprovedConfirm="//button[contains(@data-bind,'click: approveTradeName')]";
        public String TradeBulkSelection1="//*[@id='tblTradeNames']/tbody/tr[1]/td[1]/label/input";
        public String TradeBulkSelection2="//*[@id='tblTradeNames']/tbody/tr[2]/td[1]/label/input";
        public String TradeBulkSelection3="//*[@id='tblTradeNames']/tbody/tr[3]/td[1]/label/input";
        public String TradeBulkDropdownSelection="//select[contains(@data-bind,'countSelectedTradeNames')]";
        public String TradeBulkRejectConfirm="//button[contains(@data-bind,'bulkRejectTradeNames')]";
        public String TradeBulkApprovedConfirm="//button[contains(@data-bind,'bulkApproveTradeNames')]";
        public String ProductSelectTaxCategory="//select[contains(@data-bind,'value: taxCode')]";
        public String EITManageProducts="html/body/div[2]/div[1]/div/div/ul/li[1]/a";
        public String EITCategory_BasicDetails="//button[contains(text(),'Choose an EIT Category...')]";
        public String EITCategory_Selection="#allEITmemberCategoriesModal > div.modal-body > div.col2.clearfix > div:nth-child(1) > div > input[type='checkbox']";
        public String DeleteTrade_Button="//button[contains(text(),'Delete')]";
        public String ConfirmDeleteTrade="//button[contains(@data-bind,'confirmDeleteTradeName')]";
        
        
        //UAT/Prod
       // public String ImagesSortDropdown="html/body/div[2]/div/section/section[4]/div[4]/div[1]/div[1]/div[3]/div[1]/div[3]/select";
        
        //Stage
      //Stage
        public String ImagesSortDropdown="//select[contains(@data-bind,'selSortOpt')]";
       //UAT/Prod 
        //public String ImagesSelectAll="html/body/div[2]/div/section/section[4]/div[4]/div[1]/div[2]/div[2]/span/input";
        
      //Stage
        public String ImagesSelectAll="//input[contains(@data-bind,'selectAllAction')]";
       
        public String MediaLibraryCancel_Button="//a[contains(@data-bind,'clearSelectedMediaItems')]";
        public String GlobalListOperation_Dropdown="//*[@id='collapseGlobal']/div/div[1]/select";
        

        //==========================================================================================================================//
        public String ImprintingTab="//a[contains(text(),'Imprinting')]";
        public String ImprintingMethodSelection="//select[contains(@id,'cmbImprintMethods')]";
        public String ImprintingMethodSelectionAdd="//button[contains(@data-bind,'click: addImprintMethod, enable: selectedImprintMethod')]";
        

       //============================================EIT Admin Categories=====================================================//
        
        public String EITAdmin_CategoriesTab="//a[contains(@id,'eitAdminCategoryHeader')]";
        public String Categories_AddButton="//button[contains(@data-bind,'AddCategoryWizard.start')]";
        public String AddCategory_NextButton="//button[contains(@data-bind,'majorSubStep.next')]";
        public String MajorCategory_InsertField="//input[contains(@data-bind,'majorCategory.name')]";
        public String MajorCategory_InsertField_NextButton="//button[contains(@data-bind,'majorAddCategoryStep.next')]";
        public String AddCategory_ConfirmButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[5]/div[2]/div/div/div[7]/div[3]/button[1]";
        public String SearchCategory_Field="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[5]/div[2]/div/div/div[1]/div[2]/div[2]/input";
        public String SearchCategory_Button="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[5]/div[2]/div/div/div[1]/div[2]/div[2]/a/i";
        public String EditCategoryButton="//*[@id='tblCategories']/tbody/tr/td[3]/button/i";
        public String EditCategory_TextField="//input[contains(@id,'txtEditCategoryName')]";
        public String EditCategory_ConfirmEditing="//button[contains(text(),'OK')]";
        public String DeleteCategory_Button="//button[contains(text(),'Delete')]";
        public String DeleteCategory_Confirm="//button[contains(text(),'Ok')]";
        public String ReassignCategoryButton="//button[contains(text(),'Reassign')]";
        public String SubCategory_ReassignButton="//*[@id='tblCategories']/tbody/tr[1]/td[7]/button[1]";
        public String ReassignField_Field="//input[contains(@id,'token-input-reassignCategorySearchTextBox')]";
        public String ReassignConfirmButton1="//button[contains(@data-bind,'reassignCategoryConfirmation')]";
        public String ReassignConfirmButton2="//button[contains(@data-bind,'reassign.saySuccess')]";
        public String ReassignCategoryClose="//button[contains(text(),'Close')]";
        public String reassignCategorySelect="//*[@id='allCategoriesModal']/div[2]/div[2]/div/div/input";
        public String SubcategoryRadioButton="//input[contains(@value,'sub')]";
        public String MajorCategorySearch_SubCategory="//input[contains(@id,'token-input-categorySearchTextBox')]";
        public String MajorCategory_SelectionNextButton="//*[@id='SubSelectMajorCategory']/div[3]/button[1]";
        public String SubcategoryAdd="//button[contains(text(),'Add')]";
        public String AssignProduct_SubCategory="//input[contains(@name,'categoryType')]";
        public String Subcategory_PopUpClosebUTTON="//button[contains(@data-bind,'hideSuccessMessage')]";
        public String BasePricingOption_BulkEdit="html/body/div[2]/div/section/section[1]/div[43]/div[2]/div[3]/table/tbody/tr/td[1]/ul/li[1]/a/span";
        public String MakeEdit_Button="html/body/div[2]/div/section/section[1]/div[52]/div[3]/button";
        public String PiecePrice_bulkNetcost="html/body/div[2]/div/section/section[1]/div[18]/form/div[2]/select";
        public String BulkNetCost_Percentage="html/body/div[2]/div/section/section[1]/div[18]/form/div[2]/div[2]/div[3]/div/ul/li[1]/div/label/input";
        public String Areaclick_ApplyPriceChangeEnable="html/body/div[2]/div/section/section[1]/div[18]/form/div[2]/div[2]";
        public String ApplyPriceChanges="html/body/div[2]/div/section/section[1]/div[18]/form/div[3]/button";
        public String EmailPopupConfirm="html/body/div[2]/div/section/section[1]/div[49]/form/div[3]/button";
        public String MessageCenterTab="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[7]/div[1]/a";
        public String MessageCenterToField="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[7]/div[2]/div/section/div/div[1]/div[1]/input";
        public String MessageCenter_MessageArea="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[7]/div[2]/div/section/div/div[1]/div[2]/textarea";
        public String MessageCenter_StartdateButton="//*[@id='message-section']/div[3]/div/button[1]";
        public String MessageCenterStartDate_Select="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a";
        public String MessageCenter_EndDateButton="//*[@id='message-section']/div[3]/div/button[2]";
        public String MessageCenterEnddate_Select="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a";
        public String MessageCenter_PostButton="//*[@id='message-section']/div[3]/div/button[3]";
        public String MessageCenter_ShowMorelink="//a[contains(text(),'Show More')]";
        public String DefaultImage="//a[contains(text(),'Set as Default')]";
        public String ClickOutsideAddCategory_NextButtonEnable="#MajorAddCategory > div.modal-header";
        public String MAkeEdits_NetCost="#bulkOperationWarningDialog > div.modal-footer > button";
        public String AssignProductType_SubCategory="//input[contains(@id,'token-input-productTypeForSubCategoryText0')]";
        public String AssignEditorial_SubCategory="//input[contains(@id,'token-input-editorialCategoryForSubCategoryText0')]";
        public String NoAssignProduct_Subcategory_AddButton="//button[contains(@data-bind,'subAddSubCategoryNoAssignStep')][contains(@class,'btn btn-primary')]";
        public String NoAssignProductType_SubCategory="//*[@id='SubAddSubCategoryNoAssign']/div[2]/div[3]/div[1]/div[2]/div[2]/ul/li[1]/p";
        public String NoAssignEditorialType_SubCategory="//*[@id='SubAddSubCategoryNoAssign']/div[2]/div[3]/div[1]/div[2]/div[3]/ul/li[1]/p";        
        public String NoAssignProductType_SubCategoryEdit="//*[@id='editCategory']/div[2]/div[2]/ul/li[1]/p";
        public String NoAssignEditorialType_SubCategoryEdit="//*[@id='editCategory']/div[2]/div[3]/ul/li[1]/p";
        public String SubCategoryEdit="//*[@id='tblCategories']/tbody/tr[2]/td[3]/button/i";
        public String SubCategoryEdit2="//*[@id='tblCategories']/tbody/tr[3]/td[3]/button/i";
        public String EditCategory_OKButton="//button[contains(text(),'OK')]";
        public String MajorCategory_RadioButton_AddCategory="//input[contains(@name,'categoryType')]";
        
        
        //====================================================2.24 Release Locators=======================================================
        public String SKUField_BasicDetails_Displayed="#SKUTitle > strong";
        public String AddProductButton_EITSupplier="#importExportButtonGroup > button:nth-child(14)";
        public String WhiteHueColor_Dropdown="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(4) > div:nth-child(2) > div.well.well-small.span10 > div > select";
        public String BlueHueColor_Dropdown="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(5) > div:nth-child(2) > div.well.well-small.span10 > div > select";
        public String LightWhiteTextColor_Verifiation="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(4) > div:nth-child(1) > div > div.span6 > strong > span";
        public String LightBlueTextColor_Verification="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(5) > div:nth-child(1) > div > div.span6 > strong > span";
        public String AnyandAllColorscategory_Existence_Attributes="//span[contains(text(),'Any/All Colors')]";
        public String CustomColorCategory_Existence_Attribute="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(7) > div:nth-child(1) > div > div.span6 > strong > span";
        public String StandardColorCategory_Existence_Attribute="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(8) > div:nth-child(1) > div > div.span6 > strong > span";
        public String OtherColorCategory_Existence_Attribute="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(9) > div:nth-child(1) > div > div.span6 > strong > span";
        
        public String PriceConfirmedCheckbox_Pricing="#priceGridTab > li.pull-right.form-inline > div.checkbox.inline > input[type='checkbox']";
        public String OtherColors_Tab_Atributes="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(4) > div:nth-child(4) > button > span";
        public String AnyOthersAll_Option_Newcolor="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(4) > div.btn-group.span3.open > ul > li:nth-child(1) > a";
        public String Custom_NewColor="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(4) > div.btn-group.span3.open > ul > li:nth-child(2) > a";
        public String Standard_NewColor="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(4) > div.btn-group.span3.open > ul > li:nth-child(3) > a";
        public String Other_Newcolor="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(2) > div:nth-child(4) > div.btn-group.span3.open > ul > li:nth-child(4) > a";
        public String AnyAllColors_Popup="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(6) > div:nth-child(2) > div.span3 > div > div > div > button:nth-child(2) > i";
        public String AnyAllColors_Selection="#unassignedColorModal > div.modal-body > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(3) > a > span";
        public String ApplySelection="#unassignedColorModal > div.modal-footer > button";
        public String CustomNewColor_Popup="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(7) > div:nth-child(2) > div.span3 > div > div > div > button:nth-child(2) > i";
        public String CustomNewColor_Selection="#unassignedColorModal > div.modal-body > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(4) > a > span";
        public String Standard_Newcolor_Popup="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(8) > div:nth-child(2) > div.span3 > div > div > div > button:nth-child(2) > i";
        public String Standard_Newcolor_Selection="#unassignedColorModal > div.modal-body > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(5) > a > span";
        public String Other_NewColorPopUp="#product-attributes-view > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div.control-group > div:nth-child(9) > div:nth-child(2) > div.span3 > div > div > div > button:nth-child(2) > i";
        public String Other_NewColorSelection="#unassignedColorModal > div.modal-body > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(6) > a > span";
        public String Availability_Unselect="#sectionProductAvailability > div.row-fluid > div:nth-child(4) > div.align-right.span6 > button:nth-child(2)";
        public String UnselectCheckboxValidation_Availability="#tblAvailability > tbody > tr:nth-child(1) > td:nth-child(3) > input[type='checkbox']";
        public String Availability_Select="#sectionProductAvailability > div.row-fluid > div:nth-child(4) > div.align-right.span6 > button:nth-child(1)";
        public String SetToreview_Option="#bulkEditOptionsModal > div.modal-body > div.span11.row-fluid > table > tbody > tr > td:nth-child(2) > ul > li:nth-child(4) > a > span";
        public String BulkEdit_PopupButton="#bulkEditOptionsModal > div.modal-footer > a.btn.btn-primary";
        public String Legalreview_checkbox="#bulkSetInReviewForm > div.modal-body > div:nth-child(1) > label > input[type='checkbox']";
        public String Legalreview_Comments="input[data-bind='value: comments, forbiddenWordsCheck: comments']";
        public String legalreview_Clickbalearea_ButtonEnable="#bulkSetInReviewForm > div.modal-body > div:nth-child(4) > span.required";
        public String SelectedProductInreview_Button="#bulkSetInReviewForm > div.modal-footer > button";
        public String EmailNotificationalert_Confirm="#sayModalSuccessForm > div.modal-footer > button";
        public String ProductLegalreviewText="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr:nth-child(1) > td.product-options > div.padBot20";
        public String LegalCheckbox_SupplierInreview=".//*[@id='InReviewProds']/div[4]/label[1]/input";
        public String Restrictedwordscheckbox_ProductInreview="#bulkSetInReviewForm > div.modal-body > div:nth-child(3) > label > input[type='checkbox']";
        public String ProductRestrictedwordstext="#dashboard-view > div:nth-child(2) > div.row-fluid.block > div.span10 > div > div:nth-child(1) > table > tbody > tr:nth-child(1) > td.product-options > div.padBot20";
        public String Restrictedwordscheckbox_SupplierInreview=".//*[@id='InReviewProds']/div[4]/label[2]/input"; 
        public String AddRestrictedWords_Button=".//*[@id='collapseGlobal']/div/div[2]/div[1]/div[2]/div[2]/button";
        public String RestrictedWordsInsertion_Field=".//*[@id='newRestrictedWordModal']/div[2]/div[2]/input";
        public String RestrictedWordsAdd_ButtonPopup=".//*[@id='newRestrictedWordModal']/div[3]/button";
        public String RestrictedWordsSearch_Insertion=".//*[@id='collapseGlobal']/div/div[2]/div[1]/div[2]/div[1]/input";
        public String RestrictedWordsSearch_Button=".//*[@id='collapseGlobal']/div/div[2]/div[1]/div[2]/div[1]/a/i";
        public String RestrictedwordsSearch_Validation="//span[contains(text(),'Automation RestrictedWords-')]";
        public String RestrictedWordsUpdate_Button=".//*[@id='tblRestrictedWords']/tbody/tr/td[1]/button";
        public String RestrictedWordsUpdate_InsertionField=".//*[@id='editRestrictedWordModal']/div[2]/div[2]/input";
        public String RestrictedWorsUpdate_ConfirmUpdate=".//*[@id='editRestrictedWordModal']/div[3]/button";
        public String RestrictedwordsDelete_Button="//button[contains(@data-bind,' click: $parent.showConfirmDeleteModal')]";
        public String RestrictedWordsDelete_PopupOk="//button[contains(@data-bind,'click: confirmDeleteRestrictedWord')]";
        public String EnableDisableASITextField=".//*[@id='collapseSupplier']/div/div[2]/div[2]/div/label/input[2]";
        public String ShowValidationButton=".//*[@id='collapseSupplier']/div/div[2]/div[2]/div/label/button";
        public String ValidationValuesListings_Validation="#collapseSupplier > div > div.row-fluid > div.control-group > div.row-fluid.padTop15 > div";
        public String RushServiceCheckbox="#product-imprint-view > div.row-fluid > div:nth-child(11) > div.padBot10 > div > input[type='checkbox']";
        public String RushServiceDetailsTextfield="#product-imprint-view > div.row-fluid > div:nth-child(11) > div:nth-child(3) > div.span9 > input";
        public String ImprintValidationError="#validationErrorsDash > table > tbody > tr > td:nth-child(2)";
        public String CancelValidationErrorMessage="#validationModalDash > div.modal-footer > button.btn.btn-link";
        public String ScorecardTab="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.tab-menu > ul > li:nth-child(1) > a";
        public String EmailFrequencyChangeButton=".//*[@id='sectionSearchBoost']/div[1]/div[3]/div/div/div/div[2]/div[2]/button";
        public String Frequency_Dropdown="#changeEmailFrequencyModal > div.modal-body > div > select";
        public String Frequency_SaveChanges_Button="#changeEmailFrequencyModal > div.modal-footer > button.btn.btn-primary";
        public String FrequencyValidationcheck="#sectionSearchBoost > div.span9 > div.gray-box-bordered.padBot20.hidden-print > div > div > div > div:nth-child(2) > div:nth-child(3) > strong";
        public String CustomerASI_Field=".//*[@id='collapseSupplier']/div/div[2]/div[2]/div/input";
        public String SearchCustomerUser=".//*[@id='collapseSupplier']/div/div[2]/div[4]/div[2]/input";
        public String SearchCustomerUser_ButtonSearch=".//*[@id='collapseSupplier']/div/div[2]/div[4]/div[2]/a/i";
        public String EITAdmin_EmailFrequency_Biannualy_UAT_Prod=".//*[@id='tblAllLicensedUsers']/tbody/tr[2]/td[3]/input";
        public String EITAdmin_EmailFrequency_Biannualy_Stage="#tblAllLicensedUsers > tbody > tr:nth-child(3) > td:nth-child(3) > input[type='radio']";
        
        public String ProductScorecardText=".//*[@id='sectionProductScoreImprovement']/div[1]/div[1]/label/span";
        public String SearchText_Scorecard="//span[contains(@class,'scoreSummary-label')]";
        public String SearchAreaWithS_Inbetween=".//*[@id='sectionSearchBoost']/div[1]/div[1]/div[2]/div[1]/div[1]/a";
        public String ScorecardDisplaying_WhileScrolling="#sectionProductSummary";
        public String SendEmail_ToSupplier_Button_UAT_Prod=".//*[@id='tblAllLicensedUsers']/tbody/tr[1]/td[7]/button";
        public String SendEmail_ToSupplier_Stage="#tblAllLicensedUsers > tbody > tr:nth-child(2) > td:nth-child(7) > button";

        public String BasicDetails_Product="#shellTop-view > div.row-fluid.hidden-print > div > div.master-menu.top-menu > ul > li:nth-child(1) > a";
        public String BasicDetails_InventoryStatus="//select[contains(@data-bind,'productLevelInventoryStatusCode')]";
        public String BasicDetails_InventoryQuantity="#product-info-view > div:nth-child(3) > div:nth-child(2) > div:nth-child(3) > div:nth-child(4) > input";
        public String BasicDetails_SKUField="input[class='span12']";
        public String SizeFilter_ManageProducts_Verification="//*[@id='accordion2']/div[1]/div[3]";
        

//==============================================2.25 Release Elements=====================================================================//
        public String MediaLibraryTab="//a[contains(text(),'Media Library')]";
        public String MediaLibrary_UnlinkedFilter="//a[contains(text(),'Unlinked')]";
        public String BulkDeleteProduct1="//*[@id='imagesTabContent']/div[2]/div[6]/div[1]/div[2]/input";
        public String BulkDeleteProduct2="//*[@id='imagesTabContent']/div[2]/div[6]/div[3]/div[2]/input";
        public String OuterAreaClick="//*[@id='imagesTabContent']/div[2]/div[5]";
        public String BulkDeleteImagesButton_MediaLibrary="//button[contains(@data-bind,'bulkDeleteImages')]";
        public String ConfirmBulkImageDelete="//a[contains(@data-bind,'confirmBulkDeleteImages')]";
        public String ClearUnlinkedFilter="//a[contains(@id,'mclearAll')]";
        public String MediaLibrary_VideosTab="//a[contains(text(),'Videos')]";
        public String MediaLibrary_AddVideoButton="//button[contains(text(),'Add Video')]";
        public String VideoName_TextField=".//*[@id='addVideoSection']/div[1]/div/div[3]/div[1]/div[1]/div/div/div/input";
        public String VideoProductType_Dropdown="//select[contains(@data-bind,'Select a video type')]";
        public String VideoURL_TextField="//input[contains(@data-bind,'url')]";
        public String VideoDescription="//textarea[contains(@data-bind,'description')][contains(@class,'marginL10 span12')]";
        public String Video_SaveButton="//button[contains(text(),'Save')][contains(@class,'btn btn-danger pull-right')]";
        public String VideoPreviewLinkAfterSave="//button[contains(@data-bind,'previewVideo')]";
        public String VideoPreviewVerification="//div[contains(@id,'videoPreviewModalML')]";
        public String VideoPreviewClose_DetailVideoScreen="//button[contains(@data-bind,'closeVideoPreviewModal')]";
        public String Videos_AssociateProducts_Button="//button[contains(@data-bind,'AssociatedProductsToVideo')]";
        public String AssociatedProducts_Selection="//*[@id='VideoAddProductsModal']/div[2]/div[2]/div[2]/div[1]/div[3]/input";
        public String AssociatedProducts_AddButton=".//*[@id='VideoAddProductsModal']/div[3]/button[2]";
        public String AssociatedProducts_Search_TextField=".//*[@id='supplierSearchTextBox']";
        public String AssociatedProducts_SearchButton=".//*[@id='SearchButton']";
        public String Videos_Back_Button=".//*[@id='addVideoSection']/div[1]/div/div[1]/a";
        public String VideosListingPreviewButton="//button[contains(@data-bind,'previewVideo')]";
        public String SearchVideo_SearchField=".//*[@id='videosListDiv']/div/div[1]/div[1]/input";
        public String SearchVideo_SearchButton=".//*[@id='videosListDiv']/div/div[1]/div[1]/a/i";
        public String VideoEdit_Button=".//*[@id='tblVideos']/tbody/tr/td[7]/button[1]";
        public String AssociatedProduct_2=".//*[@id='VideoAddProductsModal']/div[2]/div[2]/div[2]/div[3]/div[2]/input";
        public String Videos_DeleteButton=".//*[@id='tblVideos']/tbody/tr/td[7]/button[2]";
        public String DeleteVideoConfirm=".//*[@id='deleteVideoConfirmationModal']/div[3]/button";
        public String BulkDeletevideo_Checkbox=".//*[@id='addVideoSection']/div[1]/div/div[5]/div[1]/div[1]/div/div/div[1]/span/input";
        public String RemoveDeleteVideo_Button=".//*[@id='addVideoSection']/div[1]/div/div[5]/div[1]/div[1]/div/div/div[1]/button";
        public String BulkRemoveConfirm=".//*[@id='deleteVideoAssociationConfirmationModal']/div[3]/button";
        public String DeleteVideos_button=".//*[@id='tblVideos']/tbody/tr[1]/td[7]/button[2]";
        public String DeleteVideoConfirmButton=".//*[@id='deleteVideoConfirmationModal']/div[3]/button";
        public String AssociatedProductSelection_2=".//*[@id='VideoAddProductsModal']/div[2]/div[2]/div[2]/div[2]/div[2]/input";
        public String SingleAssociatedProductDeletion=".//*[@id='tblVideoProducts']/tbody/tr/td[7]/button";
        public String SingleAssociatedProductDeletion_Confirmation=".//*[@id='deleteVideoAssociationConfirmationModal']/div[3]/button";
        public String ProductLevelVideosTab=".//*[@id='priceGridTab']/li[2]/a";
        public String VideoIntegrationToProduct=".//*[@id='tblVideos']/tbody/tr/td[1]/input";
        public String SelectedMediaButtonSelection=".//*[@id='divMediaLibrary']/div[1]/div[3]/button";
        public String VideoIntegrateWithProductVerification=".//*[@id='image-import-container']/ul/li";
        public String PreviewVideoButton="//button[contains(@data-bind,'testVideoPreview')]";
        public String MediaLevelVideoCancelButton=".//*[@id='divMediaLibrary']/div[1]/div[3]/a";
        public String DiassociatevideoFromProduct="#image-import-container > ul > li > div > div.span6.text-right > a > i";
        public String EIT_IntegrationTab=".//*[@id='eitAdminIntegrationHeader']";
        public String Integration_OperationDropdown=".//*[@id='collapseIntegration']/div/div/select";
        public String Integration_SupplierSearch_TextField="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div/div/input";
        public String Integration_SupplierSelection="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[3]/a/strong";
        public String ChangeSettings_Integration="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[1]/div[2]/div/div[2]/div[4]/table/tbody/tr/td[3]/label[2]/input";
        public String ExportProductFlag_Download=".//*[@id='collapseIntegration']/div/div[2]/div[4]/div/div[1]/button";
        public String SearchSupplier_Integration_SearchButton="html/body/div[2]/div[2]/div/section/section[3]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div/div/a/i";
        public String SaveSuccessMessage="#toast-container";
        public String AutomationVimeoTextValidation_Search="//span[contains(text(),'Automation Vimeo')]";
        public String AutomationYoutubeValidation_Search="//span[contains(text(),'Automation Youtube')]";
        public String VideoIntegrationValidation_ProductLevel="//span[contains(text(),'Automation Youtube')]";
        
     //==================================================Additional Locators For EIT Manager Checks========================================
        public String MoreFilterOption="//span[contains(text(),'More Filters ')]";
        public String NewProductOption_MoreFilters="//span[contains(text(),'New Product')]";
        public String NewProduct_CountClick="#acrdid_25 > div > label > span";
       
        //UAT/Prod
        //public String NewProduct_NewFlag="#product-info-view > div:nth-child(4) > div.control-group > div.span6.supplierFlags > div:nth-child(1) > input[type='checkbox']";
        
        //Stage
        public String NewProduct_NewFlag="#product-info-view > div:nth-child(6) > div.control-group > div.span6.supplierFlags > div:nth-child(1) > input[type='checkbox']";
        
        public String NewProduct_SEOFlag="//input[contains(@data-bind,'isProductSEOEnabled')]";
        public String DistributorCommentsField_ProductLevel="//textarea[contains(@id,'distributorComments')]";
        public String OuterareaClickBasicDetail_ToEnableSaveButton="//*[@id='product-info-view']/div[2]/div[2]/div[4]/div[2]/div[10]/label/strong";
        public String Bulk_UpdateDistributorOnlyComments="//span[contains(text(),'Update Distributor Only Comments')]";
        public String DistributorComments_OperationsSelections="//select[contains(@data-bind,'options: operationValues')]";
        public String DistributorComments_BulkField_TextArea="//textarea[contains(@data-bind,'distributorOnlyComments')]";
        public String DistributorCommentsBulk_SaveandApply_Button="//a[contains(text(),'Save and Apply')]";
        public String DistributorCommentsBulk_SuccessMessage_OkButton="//button[contains(@data-target,'#sayModalSuccessDialog')]";
        
        public String BulkEdit_RemoveSEOFlag="//span[contains(text(),'Remove SEO Flag')]";
        public String BulkRemove_ApplyButton="//a[contains(@data-bind,'BulkRemoveSeoFlag')]";
        public String BulkRemove_SEOFlag_EmailConfirm="//button[contains(@data-target,'sayModalSuccessDialog')]";
        public String BasicdetailsTextValidation="//a[contains(text(),'Basic Details')]";
        public String ProductType_BasicdetailsScreen_Validation="//strong[contains(text(),'What type of product are you entering?')]";
        public String RemoveNewProductFlag_BulkEdit="//span[contains(text(),'Remove New Product Flag')]";
        public String BulkRemoveflagConfirm="#bulkRemoveNewProductFlagModal > div.modal-footer > a.btn.btn-primary";
        public String EmailSuccessText="#sayModalSuccessForm > div.modal-header > h4";
        public String ClearAllFilter="#clearAll";
        public String RemoveEITCategory="//button[contains(@data-bind,'removeEITmemberCategory')]";
        public String ProductCategoryExistenceValidation="#product-info-view > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div.control-group > div.controls-row.marginB10 > table > tbody > tr:nth-child(2)";
        public String AdKeyword_BasicDetails="//input[contains(@id,'token-input-adKeywords')]";
        public String HiddenKeyword_BasicDetails="//input[contains(@id,'token-input-seoKeywords')]";
        public String DeletechangesLinktext="//a[contains(text(),'Delete Changes')]";
        public String DeletechangesConfirm="//a[contains(text(),'Yes, Delete these changes')]";
        public String ResetButtonValidation_Upcharges="//a[contains(@data-bind,'click: $root.showPriceResetModal')]";
        public String DeleteButtonValidation_Upcharges="//a[contains(@data-bind,'click: $root.deletePriceGrid')]";
        public String CriteriaName_ValidationUpcharges="#upchargesTabContent > div > div.accordion > div:nth-child(1) > div.span11 > div > div > div.accordion-heading.clearfix.normalImp > div.pull-left.marginL5 > span";
        public String ResetButton_IconValidation="#ugid_826707684 > div.pad10 > div > div.span6.text-right > div:nth-child(2) > span:nth-child(1) > a > i";
        public String GlyphiconIconValidation="//i[contains(@class,'icon-refresh')]";
        public String CriteriaNamePricing="#upchargesTabContent > div > div.accordion > div:nth-child(2) > div > div > div > div.accordion-heading.clearfix.normalImp.pad20 > div.pull-left.marginL5 > span";
        public String daysExpiration_Specials="#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all.ui-state-disabled > span";
        public String TradeSearchValidation="//span[contains(text(),'Trade Works-')]";
        public String MediaSelectAllValidation="//div[contains(@class,'large-scroll-y')]";
        public String MediaTagsValidation1="//p[contains(text(),'3Q')]";
        public String MediaTagsValidation2="//p[contains(text(),'Alternate')]";
        public String Mediaremoval1="#image-import-container > ul > li > div:nth-child(3) > ul > li:nth-child(1) > span";
        public String Mediaremoval2="#image-import-container > ul > li > div:nth-child(3) > ul > li:nth-child(2) > span";
        public String SpecialDisabledcheckbox="//input[contains(@class,'checkbox')]";
        public String CatalogSortValidation="//span[contains(@data-bind,'visible:catalogName')]";
        public String ProductNameSortValidation="//strong[contains(@data-bind,'text: name')]";
        public String ImprintingValidationCheckDistributor="//div[contains(text(),'Product cannot be made Active if empty. Please specify an imprint method or choose sold unimprinted.')]";
        public String VideoPreview="//div[contains(@id,'videoPreviewModalimg')]";
        public String ClosePreview="//div[contains(@id,'videoPreviewModalimg')]/div[3]//button[contains(@data-bind,'closeVideoPreviewModal')]";
        public String MediaLibrarySaveButton="//button[contains(text(),'Save')]";
        public String ReassignCategoryDelete="#tblCategories > tbody > tr:nth-child(2) > td:nth-child(4) > button.btn.btn-danger";
       // public String Categorydeletion2="//*[@id='tblCategories']/tbody/tr[2]/td[6]/button[2]";
        public String Categorydeletion2="//*[@id='tblCategories']/tbody/tr[2]/td[7]/button[2]";
       // public String Categorydeletion1="//*[@id='tblCategories']/tbody/tr/td[6]/button[2]";
        
        public String Categorydeletion1="//*[@id='tblCategories']/tbody/tr/td[7]/button[2]";
        public String DeleteConfirmCategory="//button[contains(@data-bind,'confirmDeleteCategory')]";
        public String AssignProductType_Category="//*[@id='MajorAddCategory']/div[2]/div[3]/ul/li//input[contains(@id,'token-input-')]";
        public String AssignEditorialCategory="//*[@id='MajorAddCategory']/div[2]/div[4]/ul/li//input[contains(@id,'token-input-')]";
        public String AssignProductType_Category_ValueStore="//*[@id='MajorAddCategory']/div[2]/div[3]/ul/li[1]/p";
        public String AssignEditorialCategory_ValueStore="//*[@id='MajorAddCategory']/div[2]/div[4]/ul/li[1]/p";
        public String AssignProductTypeEditCategory="//*[@id='editCategory']/div[2]/div[2]/ul/li[1]/p";
        public String AssignEditorialCategory_Edit="//*[@id='editCategory']/div[2]/div[3]/ul/li[1]/p";
        public String ProductType_CategoryListing="//*[@id='tblCategories']/tbody/tr/td[1]/span";
        public String CategoriesOptionsDropdown="//select[contains(@data-bind,'selectedCategoryLevelOperation')]";
        
//===================================================Themes Locators===============================================================//
        public String AddThemeButton="//button[contains(text(),'Add a Theme')]";
        public String InsertThemeName_TextField="//input[contains(@maxlength,'50')]";
        public String AddThemeButton_popup="//button[contains(text(),'Add Theme')]";
        public String SearchTheme_SearchField="//input[contains(@placeholder,'Search Themes')]";
        public String SearchTheme_SearchButton="//a[contains(@data-bind,'click: filterThemes')]";
        public String EditThemeButton="//button[contains(@data-bind,'click: $parent.openEditThemeModal')]";
        public String EditTheme_TextField="//*[@id='editThemeModal']/div[2]/div[2]/input";
        public String EditTheme_OkButton="//button[contains(text(),'Ok')]";
        public String DeleteThemeButton="//button[contains(@data-bind,' click: $parent.showConfirmDeleteModal')]";
        public String DeletethemeConfirm="//button[contains(@data-bind,'click: confirmDeleteTheme')]";
        public String ThemeSearchVerification="//span[contains(text(),'Automation')]";
        public String DeleteThemeVerification="//div[contains(text(),'No result found')]";

//==============================================EIT Note Locators===============================================================//
        public String ViewNotes_Button_AfterSupplierSearch="//button[contains(@data-bind,'click: $root.eitCompanyNotesHelper.showCompanyNotes.bind($data)')]";
        public String AddNote_TextArea_Field="//textarea[contains(@id,'eitNote')]";
        public String AddNote_Button="//button[contains(text(),'Add Note')]";
        public String EditNoteTextArea_Field="//textarea[contains(@id,'eitEditNote')]";
        public String EditNoteButton="//button[contains(@data-bind,'click: $parent.editCompanyNote, visible: $parent.readOnly() === false')]";
        public String NoteCreated_Verification="//div[contains(@class,'span12 marginL0')]";
        public String NoteEditing_Verification="//*[@id='eitCompanyNotes']/div[2]/div[5]/div/div/div[3]";
        public String ReadNotes_Checkbox="//input[contains(@data-bind,'checked: chkReadNotes')]";
        public String ReadNotes_LoginAsSupplier_Button="//*[@id='eitCompanyNotes']/div[2]/div[6]/div[2]/button";
        public String NoteDeleteButton="//button[contains(@data-bind,'click: $parent.deleteCompanyNote, visible: $parent.readOnly() === false')]";
        public String ManageProducts_ViewNotes="//a[contains(@data-bind,'click: $root.showCompanyNotes')]";
        public String ManageProducts_Details_ViewNotes_Verification="//div[contains(@class,'input-block-level note_desc')]";
        public String NoteDeletion_Verification="//div[contains(@class,'controls-row padBot20')]";
        public String SupplierSearchfieldsVerification_SearchSupplierLevel="//table[contains(@class,'table table-condensed marginB0')]";
        public String EITNotesUI_Verification="//div[contains(@class,'row-fluid eitNotes marginB10')]";
//======================================ASCII Codes verification Locators==========================================================//
        public String OuterAreaClick_BasicDetails="#product-info-view > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div.control-group > div:nth-child(1) > div.controls-row.pad4.marginB10.label-warning > label > span.required";
        public String ASCII_Verification="//*[@id='product-info-view']/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]";
        public String MakeAciveProduct_From_BasicDetails="//button[contains(@data-bind,'command: publishProduct, activity: publishProduct.isExecuting')]";
        public String ASCII_MessageVerification="#validationErrorsBasic > table > tbody > tr > td:nth-child(2) > span:nth-child(3)";
        public String ASCII_ValidationMessage_OKButton="//*[@id='validationModalBasic']/div[3]/button[2]";
//================================================Prop65 and Compliance Locators==========================================================================
        public String Prop65_basicDetails_Checkbox="//input[contains(@data-bind,'checked: prop65Selected, click: selectProp65')]";
        public String Prop65_basicDetails_Validation_AfterMakeActive="//*[@id='validationErrorsBasic']/table/tbody/tr[4]/td[2]/span[2]";
        public String Pro65_basicDetails_Validation_OK_Button="//*[@id='validationModalBasic']/div[3]/button[2]";
        public String WarningCheckbox_prop65="//input[contains(@data-bind,'checked: selected, enable: selectionEnabled')]";
        public String WarningInputfield1="//textarea[contains(@data-bind,'warningInputText')]";
        public String Prop65_Warning_verification="//p[contains(text(),'AutomationWarning')]";
        public String ComplianceField_BasicDetails="//input[contains(@id,'token-input-complianceInput')]";
        public String ComplianceandSafety_Verification="//p[contains(text(),'ANSI')]";
        public String ComplianceandSafety_Verification_FLA="//p[contains(text(),'FLA')]";
        public String AttributeColor_BeforeDrag="//li[contains(@class,'btn ui-draggable red-background')]";
        public String AtributeColor_AfterDrag="//li[contains(@class,'btn ui-draggable green-background')]";
        public String HoverBasePriceField="//*[@id='pricingTabContent']/div[6]/div[1]/div/div/div/div[1]/div[2]/input";
        public String Pricegrid_HoverToolTip="//div[contains(@class,'tooltip fade top in')]";
        
  //=================================================Rename Size Group and Product Colors Locators========================================//
        public String SelectSize_Attributes="//*[@id='divProductSize']/div[2]/div[2]/div[1]/button/span";
        public String ViewAllSizes="//button[contains(text(),'View all Size Types')]";
        public String SizeSelection="#sizesTypesModal > div.modal-body > div > a:nth-child(6)";
        public String Apparel_CheckboxSelection="//*[@id='divApparelStyleLookupValues']/div[1]/div[2]/input";
        public String SizeVerification_AfterActive="//span[contains(text(),'Apparel-Mens/Tall')]";
        public String SizeTemplateMenu="//a[contains(@id,'sizeTemplateMenu')]";
        public String SaveTemplateOption_SizeTemplateMenu="//a[contains(@data-bind,'SaveSizeTemplate')]";
        public String SizeTemplateName="//input[contains(@data-bind,'sizeTemplateName')]";
        public String SaveSizeTemplate="//button[contains(@data-bind,'saveSizeTemplate')]";
        public String ApplyTemplateOption_SizeTemplateMenu="//*[@id='divProductSize']/div[1]/div/ul/li[2]/a";
        public String SizeTemplateSelection_Dropdown="//select[contains(@data-bind,'selectedSizeTemplate')]";
        public String SizeTemplateApplyButton="//button[contains(@data-bind,'applySizeTemplate')]";
        public String DeleteTemplateOption_SizeTemplateMenu="//*[@id='divProductSize']/div[1]/div/ul/li[3]/a";
        public String ClearSizeButton="//*[@id='divProductSize']/div/button";
        public String SizeTemplateApply_Verification="//*[@id='divProductSize']/div[2]/div[2]/div[1]/button/span";
        public String NumberofItemsField_ShippingEstimates="//input[contains(@data-bind,'numItems')]";
        public String EnableClearAllButton="//*[@id='product-info-view']/div[2]/div[1]/div[3]/div[1]/div[4]/div[1]";
        public String ClearAllButton_ShippingEstimates="//button[contains(@data-bind,'clearShippingEstimate')]";
        public String ClearAllFields_ShippingEstimates_Verification="//div[contains(@class,'well well-small label-blue')]";
        public String ColorTemplateMenu="//a[contains(@id,'colorTemplateMenu')]";
        public String ColorTemplateMenu_SaveTemplateOption="//a[contains(@data-bind,'SaveColorTemplate')]";
        public String ColorTemplateNameField="//input[contains(@data-bind,'colorTemplateName')]";
        public String ColorTemplateSaveButton="//button[contains(@data-bind,'saveColorTemplate')]";
        public String ColorTemplateMenu_ApplyTemplateOption="//a[contains(@data-bind,'Apply')]";
        public String ColorTemplateSelection="//select[contains(@data-bind,'selectedColorTemplate')]";
        public String ColorTemplateApplyButton="//button[contains(@data-bind,'applyColorTemplate')]";
        public String ColorTemplateMenu_DeleteTemplateOption="//*[@id='product-attributes-view']/div[1]/div[1]/div[2]/div[1]/div/ul/li[3]/a";
        public String ColorTemplateApplyVerification1="//*[@class='color-selections'][1]";
        public String ColorTemplateApplyVerification2="//*[@class='color-selections'][2]";
        public String ClearAllColor_Button="//*[@id='product-attributes-view']/div[1]/div[1]/div[2]/div[1]/button/span";
        public String ColorRemovalVerification="//*[@id='product-attributes-view']/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div[1]/strong/span";
  //=================================================Virtual Samples Media Library Locators====================================================//
        public String MediaLibrary_ImageVirtualize_Link="//div[contains(@class,'overflow-auto')]/div[1]/div[5]/a[2]";
        public String MediaLibrary_AddMask_Button="//button[contains(text(),'Add Mask Region')]";
        public String MediaLibrary_Virtualize_MaskLocation="//select[contains(@data-bind,'selectedMaskLocation')]";
        public String MediaLibrary_MaskWidth="//input[contains(@data-bind,'value: width')]";
        public String MediaLibrary_MaskHeight="//input[contains(@data-bind,'height')]";
        public String MediaLibrary_MaskSavingButton="//button[contains(@data-bind,'SaveMaskRegion')]";
        public String MediaLibrary_MaskDeletionButton="//tbody[contains(@data-bind,'foreach: maskRegions')]/tr/td[4]/button[2]";
        public String MediaLibrary_MediaTags_VirtualizeScreen="//div[2][contains(@class,'controls-row padTop10')]/div[2]/div[1]/div//input[contains(@class,'rbMediaTagGroup1 margin4By3')]";
        public String MediaLibrary_ClearMediatags="//div[contains(@class,'modal hide assignMaskRegionsModal modalAssignMaskRegions in')]/div[2]/div/div[1]/div[2]/div[2]/div[1]//button[contains(@data-bind,'ClearAllMediaTagsSelection')]";
        public String MediaLibrary_SaveVirtualize="//span[contains(@data-bind,'applyButtonCaption')]";
        public String MediaLibrary_ImageCannotbevirtualize_Checkbox="//input[contains(@data-bind,'currentMediaVsFlag()')]";
        public String MediaLibrary_VirtualizeImage_VerificationIcon="//div[contains(@class,'overflow-auto')]/div[1]/div[1]/div[1]/i";
        public String MediaLibrary_CannotVirtualizeImage_VerificationIcon="//div[contains(@class,'overflow-auto')]/div[1]/div[1]/div[2]/i";
        public String BannerVerification="//div[contains(@id,'Top_pushWrapper')]";
        public String BannerExpand_Open="//span[contains(@class,'arrows arrow-down')]";
        public String BannerExpand_Close="//span[contains(@class,'//span[contains(@class,'arrows arrow-up')]')]";
        public String DeleteMaskRegionArea_Verification="//table[contains(@id,'tblAddMaskRegions')]";
        public String ImageSelectionMediaLibrary="//*[@id='imagesTabContent']/div[2]/div[6]/div[1]/div[2]/input";
        public String DeleteMaskRegionButton_MediaLibrary="//button[contains(text(),'Delete Mask Region')]";
        public String ConfirmDeleteMaskRegion="//button[contains(@data-bind,'ConfirmDeleteMaskRegion')]";
        public String DeleteMasking_SuccessMessage_OkButton="//button[contains(@data-bind,'dismissBulkSuccessModal')]";
        public String AddTagButton_MediaLibrary="//button[contains(text(),'Add Tags')]";
        public String AddTag_FrontOption="//*[@id='media-library-view']/div/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[1]/input";
        public String AddTag_SaveButton="//button[contains(@data-bind,'virtualSampleVM')][contains(@class,'btn btn-primary')]";
        public String VirtualizeTag_Verification="//*[@id='media-library-view']/div/div[9]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/input";
//=====================================================Virtual Samples Product Level==============================================//
        public String ProductLevel_Virtualizelink="//*[@id='imagesTabContent']/div[2]/div[6]/div[1]/div[5]/a[2]/small";
        public String ProductLevel_ImageVirtualizationIconVerification="//div[contains(@class,'mediaContents noselect')]/div[1]/div/i";
        public String ProductLevel_ImageCannotbeVirtualizedIcon="//*[@id='imagesTabContent']/div[2]/div[6]/div[1]/div[1]/div[2]/i/i";
        public String ProductLevel_MediaTagButton="//button[contains(@data-bind,'ImageMediaTags')]";
        public String CopyMaskRegionButton="//span[contains(text(),'Copy Mask Region')]";
        public String CopyMaskImageSelection="//*[@id='imageCopyRegionsModal']/div[2]/div[2]/div[3]/div/div/input";
        public String CopyMaskSelectImageButton="//button[contains(text(),'Select Image')]";
        public String CopyRegionToanotherImageCheckbox="//*[@id='imageCopyRegionsModal']/div[2]/div[5]/div[1]/div/div/input";
        public String CopyMaskregionButton="//button[contains(text(),'Copy Mask Regions')]";
        public String CopyMaskRegionVerification="//*[@id='image-import-container']/ul/li[1]/div[1]/div[1]/div[2]/div[1]/i";
        public String DeleteMaskRegionButton="//span[contains(text(),'Delete Mask Region')]";
        public String DeleteMaskFromImageCheckbox="//*[@id='imageDeleteRegionsModal']/div[2]/div[2]/div[1]/div/div/input";
        public String DeleteMaskRegionsButton="//button[contains(text(),'Delete Mask Regions')]";
        public String VirtualizeTag_ManageImages="//a[contains(text(),'Virtualize/Tag')]";
        public String VirtualizeTag_ApplyButton="//*[@id='product-images-view']/div[17]/div/div[3]/button/span";
        public String VirtualizeTag_BackButton="//*[@id='product-images-view']/div[17]/div/div[1]/a";
        public String CannotVirtualizeImageIcon_ManageImage_Verification="//*[@id='image-import-container']/ul/li[1]/div[1]/div[1]/div[2]/div[2]/i/i";

//===================================================Shapes Locators===============================================================//
        public String AddShapeButton="//button[contains(text(),'Add a Shape')]";
        public String AddShape_NameTextField="//input[contains(@data-bind,'shapeValue')]";
        public String AddShape_ShapeGroup="//input[contains(@id,'token-input-')]";
        public String AddNewShape_AddButton="//button[contains(text(),'Add Shape')]";
        public String ShapeSearchField="//input[contains(@placeholder,'Search Shapes')]";
        public String ShapeSearchButton="//a[contains(@data-bind,'filterShapes')]";
        public String ShapeEditButton="//button[contains(@data-bind,'EditShapeModal')]";
        public String ShapeEditTextField="//*[@id='editShapeModal']/div[2]/div[1]/div[2]/input";
        public String ShapeEditConfirm_OkButton="//button[contains(text(),'Ok')]";
        public String ShapeDeleteButton="//button[contains(text(),'Delete')]";
        public String ShapeDeleteConfirmButton="//button[contains(@data-bind,'confirmDeleteShape')]";
        public String ShapeDeleteVerification="//div[contains(@class,'text-center')][contains(text(),'No result found')]";
        public String SearchShapeVerification="//span[contains(text(),'Automation')]";
        public String EditShapeVerification="//*[@id='tblShapes']/tbody/tr/td[1]/span";
        public String ProductShapeField="//input[contains(@id,'token-input-shapesInput')]";
        public String ShapesMultiGridCheckbox="//*[@id='mpConfigStep1']/div[4]/div/div/div[11]/div/div/input";
        public String Shape1_Selection="//*[@id='mpConfigStep2']/div[2]/div/div[2]/div/div[1]/input";
        public String Shape2_Selection="//*[@id='mpConfigStep2']/div[2]/div/div[2]/div/div[2]/input";
        public String AssignShapeErrorMessage_OInDeletion="//span[contains(@data-bind,'errorMessage')]";
        public String DeleteShapeErrorMessageOk_Button="//button[contains(@data-bind,'dialogErrorOk')]";
        public String ShapeDeletionFromProduct="//*[@id='product-attributes-view']/div[1]/div[2]/div[2]/div[2]/div[1]/ul/li[2]/span";
        
 //================================================Groups Locators================================================================//
        public String GroupsOption_ManageProducts="//strong[contains(text(),'Groups')]";
        public String AddToNewGroupOption="//a[contains(text(),'Add to New Group')]";
        public String AddNewGroup_Product_ExternalID="//span[contains(@class,'span')]";
        public String AddToNewGroup_ProductSelection="//tbody[contains(@data-bind,'foreach: selectedProducts')]/tr[1]/td[1]/input[1]";
        public String AddToNewGroup_CreateGroupButton="//button[contains(@data-bind,'createNewGroup')]";
        public String AddNewGroup_CancelButton="//*[@id='addProductsToNewGroupModal']/div[3]/button[contains(text(),'Cancel')]";
        public String AddToExistingGroup="//a[contains(text(),'Add to Existing Group')]";
        public String AddToExistingGroup_ProductSelection="//tbody[contains(@data-bind,'foreach: productGroups')]/tr[1]/td[1]/input[1]";
        public String AddToExistingGroup_NextButton="//button[contains(@data-bind,'getProductGroupDetails')]";
        public String AddToExistingGroup_AddGroupButton="//button[contains(@data-bind,'addProductsToGroup')]";
        public String GroupName_1stProduct_Verification="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[1]/table/tbody/tr/td[2]/div[2]/strong";
        public String GroupName_2ndProduct_Verification="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[2]/div[2]/strong";
        public String GroupName_3rdProduct_Verification="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[2]/div[2]/strong";
        public String ExistingProduct_ExternalID_Popup="//*[@id='addProductsToExistingGroupModal']/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/span";
        public String ManageGroups_DeleteGroup_Button="//button[contains(@data-bind,'deleteProductGroup')]";
        public String Groups_ManageGroups_Option="//a[contains(text(),'Manage Groups')]";
        public String ManageGroup_EditButton="//tbody/tr/td[7]//button[contains(text(),'Edit')]";
        public String EditGroup_RemoveProduct_FromGroup="//*[contains(@data-bind,'removeProductFromGroup')]";
        public String EditGroup_SelectionRadioPrimary="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/input";
       
        public String GroupEdit_SaveButton="//button[contains(@data-bind,'editProductGroup')]";
        public String ExternalProductID_Updated_Editing="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/span";
        public String ExternalProductName_Updated_Editing="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div/table/tbody/tr[2]/td[4]/span";
        public String ManageGroups_Edit_Groupdetails="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div/table/tbody";
        public String NumberofProducts_InGroup_Verification="//*[@id='manageProductGroupsModal']/div[2]/div[1]/div/table/tbody/tr[1]/td[5]/span";
        public String ManageGroups_CloseButton="//button[contains(text(),'Close')][contains(@class,'btn btn-primary')]";
        public String AdFlag_Column="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div/table/thead/tr/th[6]/strong";

        public String test="//div[contains(@class,'loading-backdrop fade in')]";
        public String CategoryEIT_Selection="//span[contains(text(),'CERTIFICATE HOLDERS & FRAMES')]/parent::td/parent::tr//input[contains(@type,'checkbox')]";
        public String CategoryEIT_SelectionStage="//span[contains(text(),'Certificate Holders & Frames')]/parent::td/parent::tr//input[contains(@type,'checkbox')]";
        public String CategoryASI_SearchField="//input[contains(@data-bind,'asiNum')]";
        public String CategoryASI_SearchButton="//button[contains(@data-bind,'ShowCategories')]";
        public String SaveCategories_ForLocking="//button[contains(@data-bind,'SaveCategories')]";
        public String LockedProductVerification="//i[contains(@class,'icon-lock')]";
        
        //===================================================================Footer Links Locators=========================================//
        public String ASIMagzines="//a[contains(text(),'ASI Magazines')]";
        public String Connect="//*[@id='footerAsiStore']/ul/li[2]/a";
        public String ESPWeb="//*[@id='footerAsiStore']/ul/li[3]/a";
        public String ESPAdvertising="//*[@id='footerAsiStore']/ul/li[4]/a";
        public String ESPWebsites="//*[@id='footerAsiStore']/ul/li[5]/a";
        public String EmailExpress="//*[@id='footerAsiStore']/ul/li[6]/a";
        public String ASICentral="//a[contains(text(),'ASI Central')]";
        public String TimAndrews="//a[contains(text(),'Tim Andrews Blog')]";
        public String ASIFacebook="//a[contains(text(),'ASI Facebook')]";
        public String ASIYoutube="//a[contains(text(),'ASI YouTube')]";
        public String ASITwitter="//a[contains(text(),'ASI Twitter')]";
        public String AboutASI="//a[contains(text(),'About ASI')]";
        public String PressRelease="//a[contains(text(),'Press Releases')]";
        public String ASICareers="//a[contains(text(),'ASI Careers')]";
        public String ContactUs="//*[@id='footerCompany']/ul/li[4]/a";
        
        //=============================================================2.32 Release Locators=======================================//
        public String MyAccount_MenuBar="//a[contains(text(),'My Account')]";
        public String Logout_MyAccount="//a[contains(text(),'Logout')]";
        public String LockedProduct_BulkUpdateVerification="//*[@id='confirmBulkLockedModal']/div[1]/div[1]/h6";
        public String LockedProductAlert_OkButton="//*[@id='confirmBulkLockedModal']/div[2]/button";
        public String BulkEdit_MakeInactiveOption="//tbody/tr/td[2]/ul/li[3]/a//span[contains(text(),'Make Inactive')]";
        public String BulkEdit_UnpublishSelection="//input[contains(@id,'unpublishNow')]";
        public String BulkEditInactiveConfirmButton="//button[contains(text(),'Make all Selected Products Inactive')]";
        public String BulkEditLockedProductSuccessMessage_OkButton="//button[contains(text(),'Ok')]";
        public String AddToSpecial_Button="//*[@id='dashboard-view']/div[2]/div[2]/div/div[1]/div[4]/button/span";
        public String AddToSpecial_LockedProductVerification="//*[@id='LockedProductsAddedToSpecialModal']/div[2]/div[1]/h6";
        public String AddToSpecial_LockedProduct_OKButton="//*[@id='LockedProductsAddedToSpecialModal']/div[3]/button";
        public String AdditionalShippingInfo_BasicDetails="//textarea[contains(@data-bind,'addtionalShippingInfo')]";
        public String AdditionShippingInfo_BasicDetailsText="//strong[contains(text(),'Additional Shipping Information')]";
        public String PreventSpecialCharactersVerification="//div[contains(text(),'Cannot use the symbol(s): [©®™]')]";
        public String ProductNumberTextClick="//strong[contains(text(),'Product Number')]";
        public String SpecialCharactersSKU_RestrictionVerification="//*[@id='product-info-view']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]";
        public String MakeActiveButton_BasicDetails="//button[contains(text(),'Make Active')]";
        public String MakeActiveProduct_RestrictionVerification1="//*[@id='validationErrorsBasic']/table/tbody/tr[1]/td[2]";
        public String MakeActiveProduct_RestrictionVerification2="//*[@id='validationErrorsBasic']/table/tbody/tr[2]/td[2]";
        public String PublishProductRestriction_OkButton="//*[@id='validationModalBasic']/div[3]/button[2]";
        public String PricingDecimalNumber_ErrorVerification="//*[@id='validationErrorsBasic']/table/tbody/tr/td[2]";
        public String AddProductType_Button="//button[contains(text(),'Add a Product Type')]";
        public String ProductTypeName="//input[contains(@data-bind,'productTypeValue')]";
        public String ProductTypeAddButton="//button[contains(text(),'Add Product Type')]";
        public String SearchProductType_SearchField="//input[contains(@placeholder,'Search Product Types')]";
        public String FilterProductTypeSearchButton="//a[contains(@data-bind,'filterProductTypes')]";
        public String ProductTypeEditButton="//button[contains(@data-bind,'editProductType')]";
        public String ProductTypeEditField="//input[contains(@data-bind,'wordsCheck: productTypeValue')]";
        public String UpdateProductType_UpdateOkButton="//button[contains(@data-bind,'UpdateProductType')]";
        public String UpdatedProductType_Verification="//span[contains(text(),'Automation 1')]";
        public String SearchProductTypeVerification="//span[contains(text(),'Automation')]";
        public String DeleteProductTypeButton="//button[contains(text(),'Delete')]";
        public String DeleteProductTypeConfirm="//button[contains(@data-bind,'confirmDeleteProductType')]";
        public String ProductTypeDelete_Verification="//div[contains(text(),'No result found')]";
        public String NewSubCategoryField="//input[contains(@placeholder,'Enter Sub Category…')][contains(@class,'form-control span12')]";
        public String NewSubCategoryText="//*[@id='SubAddSubCategoryNoAssign']/div[2]/div[3]/div[1]/div[1]/span[1]";
        public String MergeCategoryButton="//button[contains(text(),'Merge')]";
        public String MergeCategoryConfirmButton="//button[contains(@data-bind,'mergeCategoryProducts')]";
        public String MajorCategoryCountBeforeMerge="//*[@id='tblCategories']/tbody/tr[1]/td[6]/span";
        
        //====================================================Currency Feature Locators==========================================//
        public String CurrencyMenu_Pricing_ProductLevel="//button[contains(@id,'menuCurrency')]";
        public String Aus_CurrencySelection__Pricing_ProductLevel="//input[contains(@id,'chkCurr_AUD')]";
        public String Can_CurrencySelection__Pricing_ProductLevel="//input[contains(@id,'chkCurr_CAD')]";
        public String Aus_CurrencyListPrice_Grid1="//div[1][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/input";
        public String Aus_CurrencyPriceCode_Grid1="//div[1][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/select";
        public String Can_CurrencyListPrice_Grid1="//div[1][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[1]/input";
        public String Can_CurrencyPriceCode_Grid1="//div[1][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[3]/select";
        public String Aus_CurrencyListPrice_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/input";
        public String Aus_CurrencyPriceCode_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/select";
        public String Can_CurrencyListPrice_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[1]/input";
        public String Can_CurrencyPriceCode_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[3]/select";
        public String BasePricing_BulkEdit="//span[contains(text(),'Base Pricing')]";
        public String MakeCurrencyGrid_QUR_RadioButton_BulkEditBasePricing="//input[contains(@value,'QUR')]";
        public String MakeCurrencyGrid_NonQUR_RadioButton_BulkEditBasePricing="//input[contains(@value,'DQUR')]";
        public String BasePricing_BulkEdit_SelectCurrencyDropdown="//span[contains(@data-bind,'selectedPriceCurrencies')]";
        public String BasePricing_USD_CurrencySelection="//input[contains(@id,'USD')]";
        public String BasePricing_ApplyPriceChanges_Button="//button[contains(text(),'Apply Price Changes')]";
        public String BasePricing_ProductLevel_QURGrid_Verification_USD1="//input[contains(@data-bind,'checked: isQUR')]";
        public String BasePricing_ProductLevel_QURGrid_Verification_USD2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/input";
        public String EditProduct2_Button="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[3]/div[2]/button[1]";
        public String SubtractValue_BulkEdit_BasePricing_RadioOption="//input[contains(@value,'SUBTRACT')]";
        public String PercentageField_BulkEditPricing="//input[contains(@name,'inputPercentageValue')]";
        public String BulkEdit_outerAreaClick_ToEnableApplyButton="//*[@id='adjustPricingForm']/div[2]/strong[1]";
        public String BulkEdit_FixedAmount_RadioButton="//input[contains(@value,'FIXED_AMOUNT')]";
        public String BulkEdit_FixedAmount_Field="//*[@id='divBulkPriceAdjustTypePercentage']/div/ul/li[2]/div/label/input";
        public String Netcost_USCurrency_Grid1="//input[contains(@data-select,'net-cost')]";
        public String Netcost_USCurrency_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[2]/input";
        public String BulkEdit_Pricecode_RadioButton="//input[contains(@value,'DISCOUNT_CODE')]";
        public String BulkEdit_PriceCode_Selection="//select[contains(@data-bind,'discountRateCode')]";
        public String DefaultPriceType_ProductLevel="//*[@id='priceGridTab']/li[3]/div[2]/select";
        public String ChangingPriceGrids_PriceType_ProductLevel_Confirm="//a[contains(text(),'OK')][contains(@data-bind,'onChangePriceType')]";
        public String PriceGridCopyValueSelection="//select[contains(@data-bind,'priceGridToCopy')]";
        public String CopyPriceGridButton_BasePricing="//a[contains(text(),'Copy')]";
        public String PriceTypeUpdate_BulkEdit="//select[contains(@data-bind,'priceUpdate')]";
        public String NetCost_BulkEdit_Validation_Verification_WhenListPriceAtProductLevel="//*[@id='bulkPriceUpdatePriceTypeConfirmationModal']/div[1]/div[1]/h6";
        public String NetCost_BulkEdit_ConfirmOKButton="//button[contains(@data-bind,'confirmPriceUpdateOperation')]";
        public String BrownAttribute_Color="//span[contains(text(),'Brown')]";
        public String AddUpcharge_BulkEdit="//span[contains(text(),'Add Upcharges')]";
        public String Upcharge_ProductColorSelection="//*[@id='bulkAddUpchargeModal']/div[1]/div[2]/div/div/div/div[17]/input";
        public String BulkAddUpcharge_NextStep="//button[contains(text(),'Next Step')]";
        public String BulkAddUpcharge_BrownColorSelection="//*[@id='bulkAddUpchargeModal']/div[1]/div[3]/div/div/div/div/div[1]/div/div[3]/input";
        public String BulkUpchargeAdd_ApplyButton="//*[@id='bulkAddUpchargeModal']/div[2]/button[2]";
        public String BulkApply_Addupcharge_Confirm="//button[contains(@data-target,'sayModalSuccessBulkAddUpchargesDialog')]";
        public String ValidationMessage_EditProductButton="//button[contains(text(),'Edit this Product')]";
        public String Upcharge_AllGridsExpand="//span[contains(@data-bind,'collapseAllUpchargeGrids')]";
        public String AddUpcharge_CurrencySelection="//button[contains(@id,'menuCurrency')]";
        public String BrownAddUpchargeBulk_Verification="//*[@id='upchargesTabContent']/div/div[2]/div[2]/div/div/div/div[1]/div[2]/input";
        public String UpchargeCopyGrid_Selection="//*[@id='upchargesTabContent']/div/div[2]/div[1]/div/div/div/div[1]/div[7]/span[1]/select";
        public String CopyUpchargeGrid_Button="//*[@id='upchargesTabContent']/div/div[2]/div[1]/div/div/div/div[1]/div[7]/span[1]/a";
        public String DeleteUpcharge_BulkEditoption="//span[contains(text(),'Delete Upcharges')]";
        public String BulkEdit_DeleteUpcharge_ProductColorSelection="//*[@id='bulDeleteUpchargeModal']/div[1]/div[2]/div/div[12]/input";
        public String BulkEdit_DeleteUpcharge_NextStep_Button="//button[contains(@data-bind,'bulkDeleteUpchargesDriver')]";
        public String ColorSelection_BulkEdit_DeleteUpcharges="//*[@id='bulDeleteUpchargeModal']/div[1]/div[3]/div[1]/div/div/div[1]/div[3]/input";
        public String DeleteUpcharge_Type="//input[contains(@id,'token-input-upchargeTypeSelect')]";
        public String DeleteUpcharge_AllCurrencyRadioButton="//input[contains(@value,'ALL_CURRENCY')]";
        public String DeleteandApply_BulkDeleteUpcharge="//button[contains(text(),'Delete and Apply')]";
        public String DeleteUpcharge_ThroughBulk_Verification="//*[@id='upchargesTabContent']/div/div[2]/div[3]/div/div/div";
        public String BulkEdit_ChangeCurrency="//span[contains(text(),'Change Currency')]";
        public String CurrencyTypeFrom_BulkEdit_ChangeCurrency="//select[contains(@data-bind,'priceCurrencyCodeFrom')]";
        public String CurrencyTypeTo_BulkEdit_ChangeCurrency="//select[contains(@data-bind,'priceCurrencyCodeTo')]";
        public String CurrencySaveandApply_ChangeCurrencyBulkEdit="//button[contains(@data-bind,'checkUpdateProductCurrencyFromAndTo')]";
        public String ChangeCurrencyVerification_BasePricing_Grid1="//div[1][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[1]/div/div/span";
        public String ChangeCurrencyVerification_BasePricing_Grid2="//div[2][contains(@class,'row-fluid marginB10')]/div/div/div/div[2]/div[4]/div/div[1]/div[1]/div/div/span";
        public String ChangeCurrencyVerification_Upcharges="//span[contains(@data-bind,'getCurrencyName')]";
        public String BulkEdit_RemoveCurrency="//span[contains(text(),'Remove Currency')]";
        public String BulkCurrencySelection_RemoveCurrency="//*[@id='bulkMenuCurrency']/span[1]";//5th array position
        public String SaveandApply_BulkEdit_RemoveCurrency="//button[contains(@data-bind,'checkCurrencyFromAndTo')]";
        public String AusCurrencySelection_BulkEditRemoveCurrency="//input[contains(@id,'chkbCurr_JPY')]"; //3rd Array Position
        public String CurrencyUnCheck_Confirm="//a[contains(@data-bind,'confirmCurrencyUncheck')]";
        public String ApplyAllcodes_PricingCheckbox="//input[contains(@id,'chkBoxUseSameCodeForAll')]";
        public String OuterAreaPricingClick="//*[@id='lblHeader']/div/em";
        public String ResetGrid="//a[contains(@data-bind,'showPriceResetModal')]"; //6th Array position
        public String ConfirmResetGrid="//a[contains(@data-bind,'confirmPriceReset')]";     
        public String Copy_SecondGrid_DropdownValue="//*[@id='pricingTabContent']/div[6]/div[2]/div/div/div/div[1]/div[5]/span[1]/select";
        public String Copy_SecondGrid_Button="//*[@id='pricingTabContent']/div[6]/div[2]/div/div/div/div[1]/div[5]/span[1]/a";
        public String CollapseGridVerification_AfterCopyingGrid="//div[contains(@class,'accordion-body padL40 padR40 in collapse')]";
        
        //=====================================================Merge Relationship Locators===============================================//
        public String ChildProductSetExpiryDate_Now="//input[contains(@value,'now')][contains(@data-bind,'expirationMode')]";
        public String ChildProductSetExpiryDate_Later="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div[2]/input[2]";
        public String DataPicker_ChildProductFutureExpiry_AddGroups="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div[2]/button[1]";
        public String DatePicker_AddGroups_NextButton="//span[contains(text(),'Next')][contains(@class,'ui-icon ui-icon-circle-triangle-e')]";
        public String DateSelection="//a[contains(text(),'13')][contains(@class,'ui-state-default')]";
        public String ProductInReviewMerge_Now_Verification="//strong[contains(text(),'Your product is in review because of')]";
        public String NewPrimaryProductSelection="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[1]/input";
        public String NewPrimaryProductSlection_ExternalID="//*[@id='manageProductGroupsModal']/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[2]/span";
        public String SummaryDetailsScreen_Quantity1="//*[@id='sectionSummary']/div[4]/div/div[2]/table/tbody/tr[1]/td[2]/span";
        public String SummaryDetailsScreen_ListPrice1="//*[@id='sectionSummary']/div[4]/div/div[2]/table/tbody/tr[3]/td[2]/span";
        public String NetCost1_SummaryDetails="//*[@id='sectionSummary']/div[4]/div/div[2]/table/tbody/tr[2]/td[2]/span";
        public String GroupUpdation_ID_MergeRelationship="//*[@id='addProductsToExistingGroupModal']/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/span";

     //==============================================================Image Uploading Media Library=================================//
        public String UploadImages_Button="//button[contains(@data-bind,'bulkUploadImages')][contains(text(),'Upload Images')]";
        public String SelecImageButton="//input[contains(@title,'file input')]";
        public String ImageUpload_triggerbutton="//button[contains(@id,'trigger-upload')]";
        public String ImageFileUpload_Success="//div[contains(@id,'fileSuccess')]";
        public String ImageUpload_ContinueButton="//button[contains(@data-bind,'uploadCompleted')]";
        public String MediaLibraryImageUpload_Verification="//small[contains(@data-bind,'shortDescription')]";
        public String MediaLibraryImage_Hover="//*[@id='imagesTabContent']/div[2]/div[6]/div[1]/div[1]/img";
        public String ImageDeleteIcon="//i[contains(@data-bind,'showDeleteIcon')]";
        public String ImageDeleteVerification="//small[contains(@data-bind,'shortDescription')][contains(text(),'MediaLibrary.jpg')]";
        public String InvalidImageSize_Validation_Verification="//li[contains(text(),'exceeds maximum file size of 5MB')]";
    
    //============================================================Catalog & Complaince Locators ==============================================//
        public String CatalogandComp_Tab="//a[contains(text(),'Catalog & Compliance')]";
        public String AddCatalogButton="//button[contains(text(),'Add Catalog')]";
        public String AddCatalog_CatalogNameField="catalogName";
        public String AddCatalog_SelectLanguage_Dropdown="//span[contains(text(),'Select Language')]";
        public String AddCatalog_LanguageSelection="//input[contains(@id,'acChkLang_EUS')]";
        public String AddCatalog_Currency_Dropdown="//*[@id='menuACCurrency']/span[1]";
        public String AddCatalog_CurrencySelection="//input[contains(@id,'acChkCurr_AUD')]";
        public String UploadCatalog_Button="//input[contains(@id,'catalogFile-to-upload')]";
        public String ECatalog_URLField="//input[contains(@data-bind,'e_URL')]";
        public String EMasked_URLField="//input[contains(@data-bind,'Masked')]";
        public String CatalogSave_Button="//button[contains(@id,'uploadCatalogDocument')]";
        public String CatalogCreate_Verification="//*[@id='catalog-container']/ul/div[1]/li[1]/div/div[2]/div[1]/span[2]";
        public String EditCatalogButton="//a[contains(@data-bind,'openEditCatalogModal')]";
        public String EditCatalog_NameField="//*[@id='editCatalogModal']/div[2]/div/div[1]/div[1]/input";
        public String EditCatalog_EndYear_Dropdown="//*[@id='editCatalogModal']/div[2]/div/div[2]/div[2]/div/select[2]";
        public String EditCatalog_SaveButton="//button[contains(@data-bind,'editCatalog')]";
        public String CatalogEndDate_Verification_AfterSaving="//*[@id='catalog-container']/ul/div[1]/li[1]/div/div[4]/div[1]/span[2]";
        public String DeleteCatalog="//a[contains(@data-bind,'confirmDeleteCatalog')]";
        public String DeleteCatalogConfirm="//a[contains(@data-bind,'deleteCatalog')]";
        public String AddCatalog_Option_ByLink_RadioButton="//input[contains(@id,'catalogByLink')]";
        public String OnlineCatalogURL_Field="//input[contains(@id,'catalogLink')]";
        public String OnlineUrl_Link_Verification="//span[contains(@data-bind,'url')]";
        public String SaveButton_WithUrlLink="//button[contains(@data-bind,'by_Link')]";
        public String ProductLevel_CatalogSelection_Dropdown="//em[contains(text(),'select one')]";
        public String CatalogSelection_ProductLevel="//*[@id='product-info-view']/div[2]/div[2]/div[2]/div[2]/ul/div/li/div/div/div[2]/ul/li[1]/a/strong/span";
        public String Add_AdditionalCatalog_Button="//button[contains(@data-bind,'AdditionalCatalogButton')]";
        public String AddedCatalog_Verification1="//*[@id='product-info-view']/div[2]/div[2]/div[2]/div[2]/ul/div/li[1]/div/div/div[2]/button[1]/span/span/strong";
        public String AddedCatalog_Verification2="//*[@id='product-info-view']/div[2]/div[2]/div[2]/div[2]/ul/div/li[2]/div/div/div[2]/button[1]/span/span/strong";
        public String DragCatalog="//*[@id='product-info-view']/div[2]/div[2]/div[2]/div[2]/ul/div/li[2]/div/div/div[1]/div/i";
        public String DropCatalog="//*[@id='product-info-view']/div[2]/div[2]/div[2]/div[2]/ul/div/li[1]/div/div/div[1]/div/i";
        public String DefaultCatalog_Text_Verification="//i[contains(text(),'Default')]";
        public String EnterPageNumber_DefaultCatalog="//input[contains(@placeholder,'Page #')]";
        public String CatalogName_ManageProducts_Verification="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[1]/table/tbody/tr/td[2]/div[6]/span[2]";
        public String CatalogPageNumber_Verification_ManageProducts="//*[@id='dashboard-view']/div[2]/div[3]/div[2]/div/div[1]/table/tbody/tr/td[2]/div[6]/span[4]";

}
