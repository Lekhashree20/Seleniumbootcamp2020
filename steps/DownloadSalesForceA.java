package steps;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.*;

public class DownloadSalesForceA extends BaseClass {

	public WebDriverWait wait;
	Set<String> windows = driver.getWindowHandles();
	String str = "SalesforceA";

	@When("Click on the sliding icon until Download SalesForceA is displayed")
	public void clickOnTheSlidingIconUntilIsDisplayed() throws InterruptedException {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")));
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(2000);
		System.out.println("Download SalesforceA is displayed now");
	}

	@When("Click on the Google Play link")
	public void clickOnTheGooglePlayLink() {

		driver.findElement(By.xpath("//span[text()='Google Play']")).click();
	}

	@Then("Navigate to the Google Play window")
	public void navigateToTheGooglePlayWindow() {

		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
		String playstoretitle = driver.getTitle();
		System.out.println(playstoretitle + "is displayed");
	}

	@Then("SalesForceA is displayed with an enabled Install button")
	public void salesforceaIsDisplayedWithAnEnabledInstallButton() {
		
		String actualName = driver.findElement(By.xpath("//span[text()='SalesforceA']")).getText();
		if (str.equalsIgnoreCase(actualName))
			System.out.println("SalesForceA is displayed");
		else
			System.out.println("SalesForceA is not displayed");

		boolean button = driver.findElement(By.xpath("//button[text()='Install']")).isEnabled();
		System.out.println(button);

	}

}