Feature: Automation of Customer Service Options 

Scenario: TC01_Verifying the SalesForce Customer service page 
	Given Enter the username as cypress@testleaf.com 
	And Enter the password as Bootcamp@123 
	And click on login button 
	When click on Learn More link in Mobile Publisher 
	Then Salesforce customer service page should get displayed 
	And Tabs should be displayed in the salesforce customer service page 