Feature: Creating Reports 

Scenario: TC01_Creating Reports 
	Given Enter the Username as bowyakarthikeyan@testleaf.com
	And Enter the Password as India@123
	When Click on Login button
	Then Home page is displayed
	When Click on App launcher
	And Click on view All
	And Click on Service
	And Click on Reports
	And Click on New Report
	Then Create new report page is displayed
	When Click on Leads
	And Download save the image
	And Click on Create
	And Select Range as All time
	And To date as 5 days from today
	Then Preview is in Tabular Format
	And List of Company account count
	And Grand Total of Records Available
	When Click on save
	And Enter Report Name as YourName
	And Enter Report Unique Name as YourName_anyNumber
	And Enter Report Discussion as Reported updated by YourName
	And Select Report Folder as Unfiled Public Reports
	And Click on Save
    Then Verify Report has been created successfully
    When Click on Run report
    Then Get the total Number of records
    When Click on Edit
    And click on close
    Then Get the text of Report name
    And check the report name
    And Date and Time when the report is created on