package steps;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.*;

public class ArchitectCertifications extends BaseClass {

	public WebDriverWait wait;
	Set<String> windows = driver.getWindowHandles();

	@When("Select Salesforce Architect")
	public void selectSalesforceArchitect() throws InterruptedException {

		windows = driver.getWindowHandles();
		String[] arrayOfString = Arrays.copyOf(windows.toArray(), windows.size(), String[].class);
		driver.switchTo().window(arrayOfString[2]);
		Thread.sleep(2000);

		// Selecting the role as Sales force Architect
		driver.findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}

	@Then("Certification - Architect Overview window should get displayed")
	public void certificationArchitectOverviewWindowShouldGetDisplayed() {

		String archititle = driver.getTitle();
		System.out.println(archititle + "is displayed");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	@Then("Certifications available for Architect")
	public void certificationsAvailableForArchitect() {

		List<WebElement> cert = driver.findElements(By.xpath("//div[@class='cs-card tile']/div[3]/a"));
		for (WebElement cert1 : cert)
			System.out.println(cert1.getText() + "is Displayed");
	}

}