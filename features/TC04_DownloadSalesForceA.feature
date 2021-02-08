Feature: Automation of Verify Google play store loaded to download SalesForceA 

Scenario: TC01_Verifying salesforceA displayed or not 
	And Enter the username as cypress@testleaf.com 
	And Enter the password as Bootcamp@123 
	And click on login button 
	When Click on the sliding icon until Download SalesForceA is displayed
	And Click on the Google Play link
	Then Navigate to the Google Play window 
	And SalesForceA is displayed with an enabled Install button
	