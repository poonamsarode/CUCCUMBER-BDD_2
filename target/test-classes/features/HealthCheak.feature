@ui

Feature:  E-commerce Project Web Site Health Check
@Search 
 Scenario: User is able to Open the application and able to perform search opeartion for Tablet
 # Given User opened browser
  Given   User navigated to the landing page of application 
  When  User Search for product "Tablet"
  Then  Search Result page is displayed "Tablet"
#  And   browser is closed

@Search   
  Scenario: User is able to Open the application and able to perform search opeartion for Mobiles
 # Given User opened browser
  Given   User navigated to the landing page of application 
  When  User Search for product "Mobiles"
  Then  Search Result page is displayed "Mobiles"
#  And   browser is closed
  
@ProdDesc 
  Scenario: User is click on the Product and check the Product Details
 # Given User opened browser
  Given   User navigated to the landing page of application
  And   User Search for product "Laptop"
  When  User click on any product
  Then  Product Description is displayed in new tab
#  And   browser is closed
  