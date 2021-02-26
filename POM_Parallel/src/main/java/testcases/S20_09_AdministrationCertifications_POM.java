package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_09_AdministrationCertifications_POM extends ProjectSpecificMethods {

	@Test
	public void verifyAdministrationCertifications() throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.clickLearnMore()
		.mouseHoverResources()
		.clickSalesforceCertification()
		.verifyCertifications();
	}
	
	
}
