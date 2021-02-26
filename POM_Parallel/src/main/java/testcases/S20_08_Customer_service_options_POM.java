package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_08_Customer_service_options_POM extends ProjectSpecificMethods{

	
	@Test
	public void customerServiceOptions() throws InterruptedException{
		
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.clickLearnMore()
		.verifyTabs();
	
	}
}
