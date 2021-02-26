package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_02_CreateOpportunity_POM  extends ProjectSpecificMethods{

	@Test
	public void createOpportunity() throws InterruptedException{
		
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.clickAppLauncher()
		.clickViewAll()
		.clickSales()
		.clickOpportunity()
		.clickNewOpportunity()
		.enterOpportunityName()
		.selectDate()
		.selectStage()
		.clickSave()
		.verifyOpportunityName();
		
		
	}
	
}
