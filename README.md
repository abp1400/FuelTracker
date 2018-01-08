This README file is for the Event Tracker project I created. The purpose of this project is to create a REST API with CRUD functions utilizing MySQL as a database, Java to create the data objects, Spring as the framework, and Gradle as the Build Tool.

Part 1

The events I tracked in my project were fuel payments, which consisted of the name of the gas station, its address, the grade of gas, the amount of gallons purchased, the price per gallon, the total purchase price, and the date of the transaction.  

I captured the data using a one-table MySQL database, called fueldb, with a table called "payment." Each payment id was assigined an integer as its primary key, and it was auto-incremented.  The name of the station, address, and grade were stored as VARCHARs.  Gallons, price per gallon, and total price were stored as DECIMALs, and date was stored as a DATE.

I created a corresponding Payment object in Java, utilizing appropriate annotation to map the objects to database and tested the mappings with JUnit.

I then created the Controller, DAO and DAOImpl using Spring MVC.  The controller, called "PaymentController," had five methods:
index, show, create, delete, and update.  Index showed all the data objects. Show displayed the object by id. Create created a new data object. Delete deleted the object, and Update updated the object with new data.

The controller used corresponding DAO and DAOImpl methods which were based on Spring's EntityManager.  The show and index methods basically used the Entity Manager's FIND function and the delete method used the Entity Manager's REMOVE function.  

The create and update methods used FasterXML's Jackson ObjectMapper to create or update the objects from a JSON string before passing them to the Entity Manager.    

All controller methods were tested locally via the Postman tool.  After all methods were found to be functional, I copied and uploaded my fueldb database to AWS via a dump file and exported my Spring MVC Rest project to a WAR file and also uploaded it to AWS.  I then tested all the methods again on AWS using the Postman tool.

The API can be used (and tested) using the following URLs:

http://54.156.178.25:8080/RestProject/rest/payments/ ( displays all payments)

http://54.156.178.25:8080/RestProject/rest/payments/{id} (displays payment by ID)

http://54.156.178.25:8080/RestProject/rest/payments/ (using POST in Postman and passing in a Json string, creates a payment)

http://54.156.178.25:8080/RestProject/rest/payments/{id} (using DELETE in Postman, deletes a payment)

http://54.156.178.25:8080/RestProject/rest/payments/{id} (using PUT in Postman and passing in a Json string, updates a payment)


---
Part 2

The second part of this project was to build a front end for the above functions using HTML, CSS, and Angular JS.  

The single page front end consists of a form to enter a new payment, a table that displays all the payments in the database table, a "view" method which can be accessed by hovering over and clicking each "store name" and displays a detailed view of the payment and includes an EDIT button, where the payment information can be updated.  

Files used to create the front end included an index html file, a component html file which linked to the various javascript files and the css file, and several JS files - the module js, the component js, and the service js.  

The module js contained the angular module that was called by ng-app in our index.html, which gave us angular's robust features.

I then created a component js which contained a component that called upon the module and contained a controller that both displayed information to and received information from the component.html template URL.  

The controller contained the core CRUD functions, listed as reload() (to display all data objects to the table in the component url) , update, which was used to update existing objects, add, which created new objects, and destroy, which was used to delete.  These functions called upon the service.js for functionality.  

The service.js used angular's $http (xmlHttp request) function to perform the HTTP Request methods GET,POST,UPDATE,DELETE on the API routes I created in Part 1.

Also included in the component.js controller were methods to display the total amount of fuel consumed, the total cost of fuel, and the average price per gallon.

The web application can be accessed at:

http://54.156.178.25:8080/RestProjectAngular/
