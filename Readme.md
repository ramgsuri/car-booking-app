# Sample Car Booking Application

"Sample Car Booking App" is a java and angular based web application that can be used to book a car on rent. 

Two types of users can register in this application "Customer" and "Dealer".

Dealer: users will be adding the cars for the listed outlets/location. 
has options on the dashboard to add, edit, delete, and update the cars and the list cars added by him/her including searching, sorting, and pagination functionality.

Customer: users will be booking the cars added by any dealer. can see the list of cars on their dashboard with searching, sorting, and pagination functionality. Apart from these options, customer has an additional button "Book Now" with each listed car to book that car.

Both (Customer and Dealer): users can see their bookings and profile from the sidebar menu after login.

* Latest Angular version has been used for better performance.
* Angular Router has been used to make this SPA (Single Page Application) for better performance.
* Latest Angular Material components has been used in the application for better user experience. For example sidebar, card, table, and dialog, components etc .   

=======================================================================
  
## Pre-requisites:

Install following before running the app:

* 1. jdk (8.0 used)
* 2. maven (3.3 used)
* 3. mysql server (8 used)
* 4. NodeJs (10.16.0 LTS used)
* 5. Angular CLI (8.0.0 LTS used)

=======================================================================

## Steps to run the API application server:

* 1. start MySQL server
* 2. change mysql root credential in "carbooking/api/src/main/resources/application.yml"
* 3. create database "carbooking" in MySQL
* 4. Run mvn clean install 
* 5. java -jar <above_created_jar>


## Note:  if u want to run this jar as docker then follow below instructions:

* 1. Make sure you have executed mvn clean install 
* 2. docker build .
* 3. docker run <image_name>


=======================================================================

## Steps to run the UI application server:

* 1. Open cmd
* 2. Go to <project directory>
* 3. npm install
* 4. ng serve --open

## Note: application will execute on URL :  http://localhost:4200/
