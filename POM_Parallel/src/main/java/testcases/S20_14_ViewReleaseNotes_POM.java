package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class S20_14_ViewReleaseNotes_POM extends ProjectSpecificMethods{
	
	@Test
	public void viewReleaseNotes() throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterpassword()
		.clickLoginButton()
		.oneClick()
		.SecondClick()
		.clickReleaseNotes()
		.clickDropdown()
		.selectDropdownValue()
		.clickDownloadPDF()
		.viewReleaseNotesPdf();
		
	}

}
