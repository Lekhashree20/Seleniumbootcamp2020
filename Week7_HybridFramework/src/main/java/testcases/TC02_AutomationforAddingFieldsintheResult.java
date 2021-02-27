package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC02_AutomationforAddingFieldsintheResult extends ProjectSpecificMethods{

	
	@Test
	public void AutomationforAddingFieldsintheResult() throws InterruptedException{
		
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.clickAppLauncher()
		.clickViewAll()
		.clickPaymentGatewayLogs()
		.selectDropdownList()
		.clickSettingsDropdown()
		.clickTheValue()
		.selectingFieldsToDisplay()
		.movingToVisibleField()
		.clickSaveButton();
	
	}
}
