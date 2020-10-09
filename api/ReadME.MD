## Pre-requisite:
==============
Install the below things before running the app:

* 1. jdk
* 2. maven
* 3. mysql server

## Steps to run the application:
=============================
* 1. start MySQL server
* 2. change mysql root credential in "carbooking/api/src/main/resources/application.yml"
* 3. create database "carbooking" in MySQL
* 4. mvn clean install the app
* 5. java -jar <above_created_jar>


## Note:  if u want to run this jar as docker then follow below instructions:

* 1. docker build -f Dockerfile -t <image_name>
* 2. docker run <image_name>