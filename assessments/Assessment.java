package assessments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assessment extends CommonMethods {

	@Test
	public void createDashboard() throws InterruptedException {
		int WAITTIME = 3000;
		Actions actions1 = new Actions(driver);

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Cancel']")));
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

		List<WebElement> goals = driver.findElementsByXPath("//ul[@class='metricRow']/li/span[2]");
		System.out.println(goals.size());
		int CLOSED_Value = Integer.parseInt(goals.get(0).getText());
		int OPEN_Value = Integer.parseInt(goals.get(1).getText());

		if ((CLOSED_Value + OPEN_Value) < 1000) {
			System.out.println("Less than 1000 adding Open and Closed");
			WebElement editLink = driver.findElement(By.xpath("//span[text()='Edit Goal']"));
			jsClick(editLink);
			Thread.sleep(WAITTIME * 2);
			driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("$10000");
			Thread.sleep(WAITTIME * 2);
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			jsClick(dashdropdown);
			Thread.sleep(WAITTIME * 2);
		}
		else {
			System.out.println("Not less than 1000 for adding Closed and Open");
		}

		WebElement dashboard = driver
				.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Dashboards']"));
		jsClick(dashboard);

		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Lekhashree_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		String str = "Lekhashree_Workout";
		String dashname = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']"))
				.getText();

		if (str.equalsIgnoreCase(dashname)) {
			System.out.println("Dashboard is created");
		}

		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Daily']")));
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		WebElement timedd = driver.findElement(By.xpath("//select[@id='time']"));
		Select dd = new Select(timedd);
		dd.selectByVisibleText("10:00 AM");

		driver.findElement(By.xpath("//span[text()='Save']")).click();
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