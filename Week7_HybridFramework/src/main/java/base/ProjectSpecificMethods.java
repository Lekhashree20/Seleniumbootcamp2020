package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods extends GenericWrapper{

	@Parameters({"browser","url"})
	@BeforeMethod
	public void browsersetup(String browser,String url) {

		launchbrowser(browser,url);
		
		
	}

	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
	}
}
