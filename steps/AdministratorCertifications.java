package steps;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.*;

public class AdministratorCertifications extends BaseClass{
	
	public static WebDriverWait wait;
	Set<String> windows = driver.getWindowHandles();

	@When("Mouse Hover on Support and services")
	public void mouseHoverOnSupportAndServices() throws InterruptedException {
	    
		Actions actions = new Actions(driver);
		WebElement mousehover = driver.findElement(By.xpath("(//span[text()='Resources'])[1]"));
		actions.moveToElement(mousehover).build().perform();
		Thread.sleep(2000);
	}

	@When("Click on the Certifications link")
	public void clickOnTheCertificationsLink() throws InterruptedException {
		
		WebElement certselect = driver.findElement(By.xpath("//span[contains(text(),'Salesforce Certification')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", certselect);
		Thread.sleep(2000);
		
	}

	@Then("Certification - Administrator Overview window should get displayed")
	public void certificationAdministratorOverviewWindowShouldGetDisplayed() {
	   
		String title = driver.getTitle();
		System.out.println(title + "is getting displayed");
	}

	@Then("Certifications available for Administrator")
	public void certificationsAvailableForAdministrator() {
		
		windows = driver.getWindowHandles();
		String[] arrayOfString = Arrays.copyOf(windows.toArray(), windows.size(), String[].class);
		driver.switchTo().window(arrayOfString[2]);
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='cs-card tile']/div[3]/a"));
		for (WebElement tab : tabs)
			System.out.println(tab.getText().trim() + " is Displayed");
		
	}
	

}