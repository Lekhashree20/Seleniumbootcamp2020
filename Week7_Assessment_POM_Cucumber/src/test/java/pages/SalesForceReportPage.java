package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;


import cucumber.api.java.en.When;

public class SalesForceReportPage extends BaseClass{
	
	@When("Click on New Report")
	public NewReportpage clickNewReport(){
		
		driver.findElement(By.xpath("//div[@title='New Report (Salesforce Classic)']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new NewReportpage();

	}

	
	
	
	
}
