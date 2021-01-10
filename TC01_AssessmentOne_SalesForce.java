package Assessments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC01_AssessmentOne_SalesForce extends CommonMethods {
	@Test
	public void createDashboard() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-context-bar__icon-action']/button/lightning-primitive-icon")));
		driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']/button/lightning-primitive-icon")).click();
		Thread.sleep(5000);

		WebElement dashdrop=driver.findElement(By.xpath("//span[text()='Home']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", dashdrop);
		executor.executeScript("arguments[0].click();", dashdrop);
		
		driver.findElement(By.xpath("//span[text()='Closed']/following-sibling::span[text()='$0']")).getText();
		driver.findElement(By.xpath("//span[contains(text(),'Open')]/following-sibling::span[text()='$0']")).getText();
		driver.findElement(By.xpath("//span[text()='Edit Goal']")).click();
		driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("$10000");

		driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']/button/lightning-primitive-icon")).click();
		
		Actions actions1 = new Actions(driver);
		WebElement dropdown1 = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Dashboards']"));
		actions1.moveToElement(dropdown1).build().perform();
		
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Lekhashree_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		String str="Lekhashree_Workout";
		String dashname = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		
		if(str.equalsIgnoreCase(dashname)) {
			System.out.println("Dashboard is created");
		}
		
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Daily']")));
		driver.findElement(By.xpath("//span[text()='Daily']")).click();
		
		WebElement timedd =driver.findElement(By.xpath("//select[@id='time']"));
		Select dd =new Select(timedd);
		dd.selectByVisibleText("10:00 AM");
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		
		

	}
}
