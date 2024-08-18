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
- [Test Cases Coverage](#Test-Cases-Coverage)
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
1-  Automated Test Execution: Executes automated tests for various functionalities of the Jetflix App.
2-  Home Page Testing: Verifies the functionality and layout of the home page, including navigation and element interactions.
3-  Movie Page Testing: Validates the movie detail views and interactions on the movie page.
4-  Page Object Model (POM): Utilizes POM to structure test code, making it maintainable and scalable.
5-  Dynamic Capabilities Setup: Configures desired capabilities dynamically for different test environments and devices.
6-  Data-Driven Testing: Uses TestNG Data Providers to test different films within a single test case, allowing for comprehensive validation of movie-related functionalities across various data sets
7-  Locator Management: Stores all locators and elements in a dedicated file for better maintainability and organization.
8-  Element Visibility Handling: Implements timeouts to handle the visibility of elements and manage errors related to elements not being visible.
