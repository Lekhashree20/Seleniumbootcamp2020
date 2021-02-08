Feature: Automation of Administrator Certifications 

Scenario: TC01_Verifying the Adminstrator Certifications 
	And Enter the username as cypress@testleaf.com 
	And Enter the password as Bootcamp@123 
	And click on login button 
	When click on Learn More link in Mobile Publisher 
	Then Salesforce customer service page should get displayed 
	When Mouse Hover on Support and services 
	And Click on the Certifications link 
	Then Certification - Administrator Overview window should get displayed 
	And Certifications available for Administrator 
	