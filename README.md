# WebAutomation_ABSA

# Project Title
Assessment QA Automation for ABSA. Sample results are attached in "Test_Results_WEB.docx" file.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

# Author
Pooja Killedar.

# Prerequisites
- Java
- Maven
- Set up an environment variables.

# Installing
- Download project artifact from your GitHub. And unzip it.
- Import as Maven project into Eclipse workspace

# Running the tests
- Right click on Project. Click on Maven -> Update Project.
- Right click on Project -> Run As -> TestNG.
 
# Tests
com.absa.testcases package contains all test cases. Below class file is created to automate pre-defined test flows. 
TC1_UserListTable.java

# Automation Project
Input Data : 
-TestNG Data provider was used to read data from excel.
-User can set the environment of execution in config -> executionHost.properties
-Environemt properties for e.g. URL and browser on which execution can be done are kept under 'environments' folder.
environments  -> production -> environment.properties
			  -> qa	-> environment.properties
-Page Object model implemented to store and use web elements

#Test Execution
1. Run testng.xml to execute the testcases. AutomatonReport.html gets created when the suite is executed.

# Test Output:
-Implemented extent report to log and document for test cases with steps along with results.
- Latest execution report is saved as "AutomationReport.html" under "Results" folder
	Results -> AutomationReport.html
-Previous execution results are placed at "Result" folder with date time stamp naming convention.

