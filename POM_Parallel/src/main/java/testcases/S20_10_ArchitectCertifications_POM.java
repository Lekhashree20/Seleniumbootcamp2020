package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_10_ArchitectCertifications_POM extends ProjectSpecificMethods {

	@Test
	public void verifyArchitectCertifications() throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.clickLearnMore()
		.mouseHoverResources()
		.clickSalesforceCertification()
		.selectRoleArchitect()
		.verifyArchitectCert();
		
	}
	
	
}
