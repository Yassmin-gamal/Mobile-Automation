# Jetflix App Automation Testing

 ## Table of Contents
- [Overview](#Overview)
- [Prerequisites](#Prerequisites)
- [Device Configuration](#Device-Configuration)
- [Setup](#setup)
    - [Install Appium](#install-appium)
    - [Install Android Studio](#install-android-studio)
    - [Clone the Repository](#clone-the-repository)
    - [Configure the Project](#configure-the-project)
- [Features](#Features)
- [Project Structure](#Project-Structure)
- [Running the Tests](#running-the-tests)
  - [Using IDE](#using-ide)
  - [Using Maven](#using-maven)
- [Issues](#Issues)
- [TestNG Reports](#TestNG-Reports)
- [Demo Videos](#Demo-Videos) 


## Overview
- This project demonstrates how to use Appium with TestNG to automate the testing of the Jetflix App. The tests are written in Java and organized using the TestNG framework, following the Page Object Model (POM) pattern.

## Prerequisites

- Selenium Java: Version 7.1.0
- Maven: Version 3.7.0
- TestNG: Version 7.5
- Appium Java-client: Version 7.1.0
  #### All dependencies are managed via the pom.xml file in Eclipse IDE.
  
## Device Configuration

- Device: Samsung SM A145F
- Android Version: 13.0

## Setup

### Install Appium

1. Install Appium via npm:

   ```sh
   npm install -g appium

2. Start the Appium server:
      ```sh
   appium

### Install Android Studio
1. Download and install Android Studio from the [official website](https://developer.android.com/studio)
2. Configure the Android SDK and ensure you have the necessary platform tools and SDKs installed.
3. Connect your physical Android device or start an Android Virtual Device (AVD) for testing.

### Clone the Repositor
1. Clone:

   ```sh
   git clone https://github.com/Yassmin-gamal/Mobile-Automation.git
   cd Mobile-Automation

### Configure the Project
1. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse). ( i use Eclipse)
2. Ensure the testng.xml file is properly configured.
3. Update the BaseTest.java file with the correct path to your Calculator APK and device details.
   
   ```java(Java)
   
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM A145F"); 
        caps.setCapability(MobileCapabilityType.UDID, "RK8W5048BXB");
        caps.setCapability( MobileCapabilityType.PLATFORM_VERSION, "13.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        
    caps.setCapability("appPackage","com.yasinkacmaz.jetflix.debug");
 	  caps.setCapability("appActivity","com.yasinkacmaz.jetflix.ui.main.MainActivity");

    driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

## Running the Tests

### Using IDE
   Open testng.xml in your IDE.
   Right-click on testng.xml and select "Run 'testng.xml'".

### Using Maven
1. Maven Test
   ```sh
   mvn test


## Features
1. Automated Test Execution: Executes automated tests for various functionalities of the Jetflix App.
2. Home Page Testing: Verifies the functionality and layout of the home page, including navigation and element interactions.
3. Movie Page Testing: Validates the movie detail views and interactions on the movie page.
4. Page Object Model (POM): Utilizes POM to structure test code, making it maintainable and scalable.
5. Dynamic Capabilities Setup: Configures desired capabilities dynamically for different test environments and devices.
6. Data-Driven Testing: Uses TestNG Data Providers to test different films within a single test case, allowing for comprehensive validation of movie-related functionalities across various data sets
7. Locator Management: Stores all locators and elements in a dedicated file for better maintainability and organization.
8. Element Visibility Handling: Implements timeouts to handle the visibility of elements and manage errors related to elements not being visible.

## Project Structure

- Implement the elements in a separate class to improve the maintainability and readability of my code. This is often referred to as the Page Object Model (POM) pattern. 
        - BaseTest: Sets up the device and app capabilities.
        - ElementsLocators: Defines locators for all elements used in the app, managed in a dedicated file for better organization.
        - HomePage: Manages interactions and verifications for the home page.
        - MoviePage: Manages interactions and verifications for the movie page.

1. POM Pattern of my Project :
   ```css
    Mobile-Automation
   ├── pom.xml
   ├── testng.xml
   ├── src
   │   ├── main
   │   │   └── java
   │   │       └── Android
   │   │           └── App
   │   │       
   │   └── test
   │       └── java
   │               └── example
   │                   │   ├── Scenario1.java
   │                   │   ├── Scenario2.java
   │                   │   └── Scenario2AnotherSolution .java
   │                   │   
   │                   │   
   │                   └── pages
   │                          └── MoviePage.java
   │                          ├── HomePage.java
   │                          ├── ElementsLocators.java
   │                          └── BasePage.java
   └── README.md

## Issues 
1- Date Parsing Issue in Scenario 2: In Scenario 2, some dates may be missing data, causing parsing errors. This results in error messages and causes the test case to fail. This issue needs to be addressed to ensure the robustness of the test case.
  
   ![fgv](https://github.com/user-attachments/assets/906723c9-f89a-4cfb-955b-f9c28149fca4)

   ![WhatsApp Image 2024-08-18 at 11 06 08 PM](https://github.com/user-attachments/assets/8fa1a523-b960-4948-b5e0-23baec0b40ab)
   ![WhatsApp Image 2024-08-18 at 11 05 57 PM](https://github.com/user-attachments/assets/cffafa05-7090-4696-9758-145a482c8f2f)

   #### I am trying to handle this by incorporating DateTimeParseException to test

   
2- When applying the filter for release dates to show only future dates, and then selecting 'Order Ascending,' the earliest date should be closest to 2024 but still in the future. However, in @ Video Scenario 2, a date from the past is incorrectly displayed.

## TestNG Reports
1- In the first scenario, I used data-driven testing to handle various datasets and created a generic function to check the movie name on both the home screen and movie screen. Since the movie might not be on the initial screen and scrolling through a large amount of data would be time-consuming, I implemented a search feature. This approach saves time and makes the test more efficient.

![axf (1)](https://github.com/user-attachments/assets/47cd8bc4-cf16-45de-b507-e6d105ea3787)


## Demo Videos

1- In the first scenario, I used data-driven testing to handle various datasets and created a generic function to check the movie name on both the home screen and movie screen. Since the movie might not be on the initial screen and scrolling through a large amount of data would be time-consuming, I implemented a search feature. This approach saves time and makes the test more efficient.



https://github.com/user-attachments/assets/a33ceeaf-0b47-4309-b4a5-f1b3f529b5ba


 

2- In the second scenario, I applied a filter to show only films with future release dates. When selecting 'Ascending,' the results should display dates closest to the current date but still in the future. However, it incorrectly shows dates from the past


https://github.com/user-attachments/assets/3a5be627-eefe-4c91-8b06-45fa8059bcdd




3- In the third scenario, I used the scroll method to verify that the dates of movies appearing on the initial screen, as well as those visible after scrolling down three times, are in the future. This check was successfully completed and passed


https://github.com/user-attachments/assets/d4e75787-b608-4704-9e27-973cb1e8ecdb



