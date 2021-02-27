package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC01_NewPaymentGatewayLogs extends ProjectSpecificMethods {

	
	@Test
	public void NewPaymentGatewayLogs() throws InterruptedException{
		
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.clickAppLauncher()
		.clickViewAll()
		.clickPaymentGatewayLogs()
		.clickNewbutton()
		.selectInteractionType()
		.selectStatus();
		
		
		
	}
	
	
	
}
