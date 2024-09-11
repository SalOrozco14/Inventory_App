# Inventory Application
## Salvador Orozco Ramirez

### Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

    mainscreen.html:

    I. Line 15- Changed Title to read "Izakaya Sushi".
    II. Line 21- Changed Header <h1> to read "Izakaya Sushi"
    III. Line 24- Changed the Header <h2> that read "Parts" to "Sushi Ingredients"
    IV. Line 34,35- Changed two button labels (Add Inhouse part & Add Outsourced part) to "Add Inhouse Ingredient" and "Add Outsourced Ingredient"
    V. Line 58- Changed Header <h2> to read "Sushi Rolls". Previously read "Products".
    VI. Line 73- Changed button label to read "Add Sushi Roll". previously read "Add Product". 


### Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
    Created an about.html file to house the information about the sushi roll shop, and a Controller named AboutController to handle the http request to the about page. 
    In order for the view to change to the about page from the main screen. I added a button to the main screen to direct the view to the about page. 

    about.html: 

    I. Line 22-38- Added text to the page explaining who this app is intended for, and some simple instructions on how to use the app.
    II. Line 40- Created a button at the bottom of the page that directs the view back to the mainscreen. Button name: Home

    AboutController.java:
    Simple controller class to handle http request to the about page. Currently only has 1 method (aboutPage). 

    I. Line 9- Class annotated with the @Controller. Lets Spring know to create an instance in the framework.
    II. Line 12- @GetMapping in the method level that handles calls for the "/about" request. 
    III. Line 13-16- aboutPage() method has no logic in it, but returns the "about" String so that Spring can find the corresponding view (about.html).

    mainscreen.html:
    Button was added to the mainscreen to help navigate to the about page. 

    I. Line 24: Button was add next to the shop name to help users find it. Purpose of the button is to send a request to view the about page. Button name: About


### Add a sample inventory appropriate for your chosen store to the application. Should have five parts and five products in your sample inventory and should not overwrite existing data in the database.


    For this task, all my changes where made in the BootStrapData.java file. I used this file to load sample data to the database to create the following: 
       Parts:
            Outsourced ingredients: Sweet Water Shrimp, Nori Paper and Crab Stix.
            Inhouse ingredients: Rice and cucumbers.
       Products:
            Shrimp Roll, Crab Roll, Veggi Roll, Crab Nigiri, Shrimp Nigiri

    Total of 5 parts where added to the database. 3 Outsourced and 2 inhouse.
    Total of 5 products where added to the database. 
    *Note: Sample data is loaded when the database is empty. If there is existing records no data will be loaded to the database. 

    BootStrapData.java:
    File loads sample data to the app's database. 

    Seting up InhousePart Repository-
    I. Line 33: Added the InhousePartRepository attribute so I can Save inhouse parts to the database. 
    II. Line 36-38: In the BootStrapData constructer I add the InhouseRepository as a parameter. Spring autowire will pull the bean automatically to the class. 
    III. Line 44: The InhouseReposity reference is stored locally and ready to be used/called.

    Check if there's data existing in the database-
    IV. Line 54: If statement is used to check if the database has any records of type: inhousePart, outsourcePart, or products. 
        This is done by getting the record count of all the repositories, and checking if it is 0. If the return value is 0, Sample data will be loaded.
        Otherwise data load will be skipped and current data will be printed.
    
    Creating and saving outsourced part data to the database-
    V. Line 60-65: Initialized an object of Type OutsourcedPart named shimp.
                   After initialization I set the following attributes:
                        setCompanyName = S.W. Shrimp CO.
                        setName = Sweet Water Shrimp
                        setInv = 100
                        setPrice = 5.00
                        setID = 100L
    VI. Line 66: saved the part to the outsourced repository.

    VII. Line 69-74: Initialized an object of Type OutsourcedPart named crab.
                   After initialization I set the following attributes:
                        setCompanyName = Yummy Crab LLC
                        setName = Crab Stix
                        setInv = 150
                        setPrice = 2.00
                        setID = 101L
    VIII. Line 75: saved the part to the outsourced repository.
    
    IX. Line 78-83: Initialized an object of Type OutsourcedPart named nori.
                   After initialization I set the following attributes:
                        setCompanyName = SeaPaper LLC
                        setName = Nori Paper
                        setInv = 80
                        setPrice = 1.00
                        setID = 102L
    X. Line 84: saved the part to the outsourced repository.

    Creating and saving inhouse part data to database-
    XI. Line 90-95: Initialized an object of Type InhousePart named rice.
                   After initialization I set the following attributes:
                        setName = Rice
                        setInv = 100
                        setPrice = .50
                        setPartId = 1
                        setID = 103L
    XII. Line 96: saved the part to the inhouse repository.

    XIII. Line 99-104: Initialized an object of Type InhousePart named cucumber.
                   After initialization I set the following attributes:
                        setName = Cucumber
                        setInv = 102
                        setPrice = .25
                        setPartId = 2
                        setID = 104L
    XIV. Line 105: saved the part to the inhouse repository.

    Creating and Saving Product data to database-
    XV. Line 111: Initialized an object of Type Product named shrimpRoll with the following attributes in the constructor.
                        name = Shrimp Roll
                        price = 18.0
                        inv = 15
    XVI. Line 113: saved the product to the product repository.

    XVII. Line 116: Initialized an object of Type Product named crabRoll with the following attributes in the constructor.
                        name = Crab Roll
                        price = 18.0
                        inv = 15
    XVIII. Line 118: saved the product to the product repository.

    XIX. Line 121: Initialized an object of Type Product named veggi with the following attributes in the constructor.
                        name = Veggi Roll
                        price = 12.0
                        inv = 15
    XX. Line 123: saved the product to the product repository.

    XXI. Line 126: Initialized an object of Type Product named crabNigiri with the following attributes in the constructor.
                        name = Carb Nigiri
                        price = 8.0
                        inv = 15
    XXII. Line 128: saved the product to the product repository.

    XXIII. Line 131: Initialized an object of Type Product named shrimpNigiri with the following attributes in the constructor.
                        name = Shrimp Nigiri
                        price = 8.0
                        inv = 20
    XXIV. Line 133: saved the product to the product repository.

    Print Data from the database-
    XXV. Line 138-141: gets a list of all the outsourced part records from the repository, and prints the list by iterating with a for each loop. 
    XXVI. Line 144-147: gets a list of all the Inhouse part records from the repository, and prints the list by iterating with a for each loop. 
    XXVII. Line 149-153: Prints out the total number of Parts and Products in the database. Also prints a list of all parts and products. 

### Add a “Buy Now” button to the product list:

    The buy now button was added on the mainscreen page next to the existing update and delete button. When the button is pressed, the http request is handled by the 
    AddProductController. The controller will decide which page should be viewed if the transaction is either succesfull or unsuccessful. To determind which page should be loaded
    the controller uses the ProductService Service by sending it the Product id and evalute the product's inventory. The Service will return a Boolean value. If the transaction 
    was succesfull it will return True otherwise False. The Service looks up the product by pulling it from the product repository and looks at the inventory count. If the value is equal
    or less than 0, the service will return False to the controller and the unsuccessful page will be display. If the product inventory is greater then 1. The inventroy count will be decremented by 1,
    and the new inventory count will be updated in the product repository. The Service will return True to the controller and the successful page will be displayed. 

    Changes were made to the following files: 
    mainscreen.html
    AddProductController.java
    ProductService.java
    ProductServiceImpl.java

    New Files created: 
    successfulbuynow.html
    unsuccessfulbuynow.html

•   The “Buy Now” button must be next to the buttons that update and delete products.
    
    mainscreen.html: 
    I. Line 96: buy button added next to the exisitng update and delete button. When clicked the button will send the product Id and send a request for "/buyProduct".
             Request will be handled by the buyProduct method in the AddProductController controller. 

•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

    AddProductController.java:
    II. Line 174-183: New method added to the controller named "buyProduct()" that will handle the "/buyProduct" request. The method is dependent on the ProductService service to help
                 decide which view to display. The method will collect the Product ID during the request and send to the Service for evaluation. In return the Service will return a boolean value 
                 and the controller's method uses an If condition to evaluate which view to display. 

    Interface : ProductService.java.
    III. Line 21: Add new method to handle the buy now business logic. Method name: buyNow(). The method needs the product id as a parameter and returns a boolean value. 
    
    implementation: ProductServiceImpl.java
    IV. Line 71-85 : the buyNow() method is implement here and collects the product Id in the parameter. The method uses an exisitng method named findById() that takes the product Id, searches for the product 
                in the product repository, and returns the Product. In line 72 the buyNow() method saves the product referance for later use. Line 73 we get the product's current inventory count and save it in 
                a variable name inventory. line 75 an if statment evaluates if the inventory is less then or equal to 0. If true the method will return false, and the controller will return the unsuccessful view. 
                Else the inventory will decrement by 1 (Line 78). The product inventory will be updated using the Setter (Line 79), and saved again in the product repository to save the changes (Line 80). Finally,
                The method will return True to the controller and display the successful view. 

•   Display a message that indicates the success or failure of a purchase.

    created 2 html pages to handle confirmation and unsuccessful buy now actions.
    successfulbuynow.html
        New Html page added to display when a product is successfully purchased. The page includes a short message and a home button to return to the main screen.
    V. Line 2-12: Is boilerplate code copied from the about page to add style to the page. 
    VI. Line 14: title is set to read as "Successful"
    VII. Line 17-23: Header is set to read "Successful" and short message that will display when the purchase is successfull. 
    VIII. Line 26: Home button added to the bottom of the page to go back to the main screen page. 

    -unsuccessfulbuynow.html
        New Html page added to display when the product purchase is unsuccessful. The page includes a short message and a home button to return to the main screen.
    V. Line 2-12: Is boilerplate code copied from the about page to add style to the page. 
    VI. Line 14: title is set to read as "Unsuccessful"
    VII. Line 17-23: Header is set to read "Unsuccessful" and short message that will display when the purchase is unsuccessful. 
    VIII. Line 26: Home button added to the bottom of the page to go back to the main screen page. 
 

### Modify the parts to track maximum and minimum inventory by doing the following:

    Changes were made to the following files: 
    Part.java
    BootStrapData.java
    mainscreen.html
    InhousePartForm.html
    OutsourcedPartForm.html
    application.properties
    AddOutsourcedPartController.java
    AddInhousePartController.java

•   Add additional fields to the part entity for maximum and minimum inventory.

    updating the Part.java, creating two new value attributes for max and min inventory.
    Also setter and getters for the new atrributes, and a new constructor that inclused the attributes.

    Part.Java
    Line 34-38: Added two new variable attributes to the part entity named minInv and maxInv. 
                On Line 34 and 37 I added a validation rule to each of the variables. This enforces the input to be a positve
                number, and display an error message to the user when constraints aren't met.

    Line 61-68: Added a new part constructer to initialize the two new varibles (minInv,maxInv).

    Line 104-116: Added getters and setters for the two new varibles (minInv, maxInv).
    

•   Modify the sample inventory to include the maximum and minimum fields.
    
    Updated the sample parts data to include the new min/max fields when initializing. 

    BootStrapData.java: Set the min/max on all inhouse and outsource parts. 
                        updates can be found on the following lines:
                        outsourced parts: Line 67-68
                                          Line 79-80
                                          Line 91-92
                        inhouse parts:  Line 106-107
                                        Line 118-119

•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

    Modified the mainscreen to include the new min/max headers as well as adding the table data elements for min/max.
    Changes were  only mad for the parts table.

    mainscreen.html:
        Line 47-48: Added table header tags to add the min/max on the parts table.
        Line 58-59: Added table data tags to add the min/max on the parts table. 

    Added two input fields for the min and max. Also added the thymeleaf if and error tag to help display error messages to the user.
    anticipated error message happens if the user inputs a non positive number.

    InhousePartForm.html
        Line 26-30: two new inputfields added for the min and max. The user input must be a positive number or an error will display
                    

    OutsourcedPartForm.html
        Line 27-31: two new inputfields added for the min and max. The user input must be a positive number or an error will display

•   Rename the file the persistent storage is saved to.

    Changed the spring.datasource.url to Izakaya-Sushi-db

    application.properties
        Line 6: Changed db name to Izakaya-Sushi-db

•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.

    For the enforcement of the inventory I used the BindingResult object to add an error to the inventory field to both the 
    AddOutsourcedPartController and AddInhouseController. The error triggers when a part is being created and the inventory is not
    between the min and max range, or when the part is being updated and the inventory is outside of the range. The changes were made in 
    the submitForm() method. 

    AddOutsourcedPartController.java
        Line 46-48: if statement checks if the inventory is out of range of the min and max. If it is out of range, a binding result error is
        created on the inventory field telling the user that the inventory needs to be with in range. The part will not be saved until inventory is
        in range. 

    AddInhousePartController.java
        Line 46-48: if statement checks if the inventory is out of range of the min and max. If it is out of range, a binding result error is
        created on the inventory field telling the user that the inventory needs to be with in range. The part will not be saved until inventory is
        in range. 


### Add validation for between or at the maximum and minimum fields. The validation must include the following:

•   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.

    AddOutSourcePartController.java
        Line 55-57: Controller checks if the inventory is less then the minimum before the part is updated or created. 
                    If the inventory falls below the minimum a binding result error is created and a message is diplayed to 
                    the user. 

    AddInhousePartController.java
        Line 55-57: Controller checks if the inventory is less then the minimum before the part is updated or created. 
                    If the inventory falls below the minimum a binding result error is created and a message is diplayed to 
                    the user.

•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
    
    EnufPartsValidator.java
        Line 38: If condition was added to check if a associated part would fall below the minimum when added to a product. 
                 If the associated product does fall below the minimum. The validation will trigger and send a message to the user. 

•   Display error messages when adding and updating parts if the inventory is greater than the maximum.

    AddOutSourcePartController.java
        Line 51-53: Controller checks if the inventory is greater then the maximum before the part is updated or created. 
                    If the inventory is above the maximum a binding result error is created and a message is diplayed to 
                    the user.

    AddInhousePartController.java
        Line 51-53: Controller checks if the inventory is greater then the maximum before the part is updated or created. 
                    If the inventory is above the maximum a binding result error is created and a message is diplayed to 
                    the user.

### Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
    Created test units for the Min and Max variable attributes in the Inhouse and Outsourced parts. 
    Achieved this by setting a value and returning the getter method to receive the correct value.
    All test units where done in the PartTest.java file. 

    Changes were made to the following file:
    PartTest.java

    PartTest.java: 
    Line 105-121: Testing Minimum inventroy setter and getter. Set the value to 5 and used the assertEquals() method to 
                  test if the getter method returns the correct value. 

    Line 124-140: Testing Maximum inventroy setter and getter. Set the value to 150 and used the assertEquals() method to 
                  test if the getter method returns the correct value. 

    

    


### Remove the class files for any unused validators in order to clean your code.
    For this task, I went and checked each validator and deleted unused validations. 
    Ended up only removing the DeletePartValidator.java as this is unused in the application. 
