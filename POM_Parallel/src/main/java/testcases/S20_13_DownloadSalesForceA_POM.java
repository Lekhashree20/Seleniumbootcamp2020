package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_13_DownloadSalesForceA_POM extends ProjectSpecificMethods {

	@Test
	public void DownloadSalesForceAttachment() throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.oneClick()
		.SecondClick()
		.clickGooglePlay()
		.verifyButton();
		
	}
	
}
