package assessments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC01_AssessmentOne_SalesForce extends CommonMethods {

	public WebDriverWait wait;

	@Test
	public void createDashboard() throws InterruptedException {
		int WAITTIME = 3000;

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Click Service Console from App Launcher
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();

		// Select Home from the DropDown

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("(//a[@title='Dashboards']/span)[1]")).click();
		Thread.sleep(WAITTIME);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@title='Show Navigation Menu']/lightning-primitive-icon")));
		WebElement dashdropdown = driver
				.findElement(By.xpath("//button[@title='Show Navigation Menu']/lightning-primitive-icon"));
		jsClick(dashdropdown);

		Thread.sleep(WAITTIME);

		WebElement home = driver.findElement(By.xpath("//span[text()='Home']"));
		jsClick(home);

		// Add CLOSED + OPEN values and result should set as the GOAL (If the result is
		// less than 10000 then set the goal as 10000)
		Thread.sleep(WAITTIME);
		List<WebElement> goals = driver.findElementsByXPath("//ul[@class='metricRow']/li/span[2]");
		System.out.println(goals.size());
		String CLOSED_Value = goals.get(0).getText();
		String CLOSED_Value1 = CLOSED_Value.replaceAll("\\D", "");
		int CLOSED = Integer.parseInt(CLOSED_Value1);
		String OPEN_Value = goals.get(1).getText();
		String OPEN_Value1 = OPEN_Value.replaceAll("\\D", "");
		int OPEN = Integer.parseInt(OPEN_Value1);

		if ((CLOSED + OPEN) < 1000) {
			System.out.println("Less than 1000 adding Open and Closed");
			WebElement editLink = driver.findElement(By.xpath("//span[text()='Edit Goal']"));
			jsClick(editLink);
			Thread.sleep(WAITTIME * 2);
			driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).clear();
			driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("10000");
			Thread.sleep(WAITTIME * 2);
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			Thread.sleep(WAITTIME * 2);
		} else {
			System.out.println("Not less than 1000 for adding Closed and Open");
		}

		// Select Dashboards from DropDown
		driver.findElement(By.xpath("//div[@class='navMenu slds-context-bar__item--divider-right oneAppNavMenu']"))
				.click();
		System.out.println("Dashboard Dropdown Clicked Successfully");

		WebElement we_dashboard_dpdn_item = driver.findElement(By.xpath("//div[@class='slds-context-bar__primary navLeft']//a[@title='Dashboards']"));
		jsScroll(we_dashboard_dpdn_item);
		jsClick(we_dashboard_dpdn_item);

		// Click on New Dashboard
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		Thread.sleep(3000);

		// Switching to Frame

		WebElement we_frame1 = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]"));

		driver.switchTo().frame(we_frame1);
		Thread.sleep(3000);
		
		// Entering values in Dashboard

		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).clear();
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Lekhashree_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent(); // Its still in the frame
		WebElement we_frame2 = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]"));
		driver.switchTo().frame(we_frame2);


		driver.findElement(By.xpath("//button[text()='Done']")).click();

		Thread.sleep(3000);

		String str = "Lekhashree_Workout";
		String dashname = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']"))
				.getText();

		if (str.equalsIgnoreCase(dashname)) {
			System.out.println("Dashboard is created");
		}

		driver.switchTo().defaultContent();
		WebElement we_frame3 = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")); 
  	  	driver.switchTo().frame(we_frame3);
  	  	
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Daily']")));
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		WebElement timedd = driver.findElement(By.xpath("//select[@id='time']"));
		Select dd = new Select(timedd);
		dd.selectByVisibleText("10:00 AM");

		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Private Dashboards'])[1]")).click();
		Thread.sleep(3000);
		
		WebElement elementLocator = driver.findElement(By.xpath("//span[text()='Created On']"));
		elementLocator.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small'])[1]")).click();
		
	}

	void jsClick(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", e);
	}

	void jsScroll(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", e);
	}
}