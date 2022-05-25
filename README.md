# Car Rental Application

## Table of contents

### Application  description
* [General description](#general-description)
* [Technologies used](#technologies-used)
* [Signing up for an account and logging in](#signing-up-for-an-account-and-logging-in)
* [The Manager Account](#the-manager-account)
* [The Client Account](#the-client-account)
* [The Car Specialist Account]

### Setup & Run

* [Prerequisites](#prerequisites)
* [Download & Run](#download--run)

### Resources
![main_page](https://user-images.githubusercontent.com/101906050/170367196-7323d585-8f59-460e-8c52-93b395e6199f.png)


## Application description

### General description

The purpose of this application is to help a client rent a car by showcasing a large variety of top model cars.

### Technologies used
* Java 18
* JavaFX 18 - UI;
* Maven - dependencies and build tool;
* MySQL - database;

### Signing up for an account and logging in

Before using the platform, every user, be they a manager or a client, must sign up for an account. On registration, there are two types of user accounts, based on the aforementioned roles:
* Client
* Manager

### The Manager Account

After logging in, the manager will be redirected to a home page. The following operations are available here:
* **Add cars** from where the manager can add a car;
* **Account**, from where the manager can see his profile;
* **Verify the list of cars**, from where the manager can check the list;
* **Log out**, the manager will be redirected to log in;

![manager_page](https://user-images.githubusercontent.com/101906050/170368077-8a08964e-e9f0-47eb-8f4d-eb27a12f0c4f.png)


### The Client Account

After logging in, a client will be redirected to a home page. The following operations are available here:
* **List of companies**, where the client can select a certain company;
* **Account**, where the client can see his profile;
* **Log out**, the client will be redirected to log in;

![customer_page](https://user-images.githubusercontent.com/101906050/170368372-f7d8cea3-6c29-419e-9072-c413fa7392bb.png)


### The Car Specialist Account
After logging in, a car specialist will be redirected to a home page. The following operations are available here:
* **List of cars**, where the car specialist can select a certain company;
* **Account**, where the car specialist can see his profile;
* **Log out**, the car specialist will be redirected to log in;

## Setup & Run

### Prerequisites
* **Java 11 or higher**. To check your Java version you can run `java -version` in the command line;
* **Maven**. To check if you have Maven installed run `mvn -version` in the command line.
* **JavaFX**. Make sure you install JavaFX SDK on your machine, using the instructions provided in the [Official Documentation](https://openjfx.io/openjfx-docs/#install-javafx);

### Download & Run
To set up and run the project locally on your machine, please follow the next steps:

* **Clone the repository**. You can do this using `git clone https://github.com/clipici-gabriela/Car_Rental.git`;
* **Verify that the project build locally**. Open the project folder in the command line, and you should be able to run `mvn clean install`;
* **Open in Intellij IDEA**;
  * **Run the project with Maven**. To start the project use `mvn javafx:run` or `.\mvnw javafx:run`.


## Resources

To understand and learn more about **JavaFX**, you can take a look at some of the following links:
* [Introduction to FXML](https://openjfx.io/javadoc/16/javafx.fxml/javafx/fxml/doc-files/introduction_to_fxml.html)
* [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/)
* [JavaFX Tutorial](https://code.makery.ch/library/javafx-tutorial/)
* [JavaFX Java GUI Design Tutorials](https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)
