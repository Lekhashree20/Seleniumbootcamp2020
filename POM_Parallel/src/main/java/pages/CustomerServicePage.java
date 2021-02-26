package pages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecificMethods;

public class CustomerServicePage extends ProjectSpecificMethods {

	public CustomerServicePage(WebDriver driver) {

		this.driver=driver;
	}

	public Set<String> windows = driver.getWindowHandles();

	public CustomerServicePage verifyTabs() {

		List<WebElement> tabs = driver
				.findElements(By.xpath("//ul[@class='wwww-main-nav searchEnabled']/li[@class='nav-item ']"));
		for (WebElement tab : tabs)
			System.out.println(tab.getText().trim() + " is Displayed");
		return this;
	}

	public CustomerServicePage mouseHoverResources() throws InterruptedException {

		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement mousehover = driver.findElement(By.xpath("(//span[text()='Resources'])[1]"));
		actions.moveToElement(mousehover).build().perform();
		Thread.sleep(2000);
		return this;

	}

	public AdministratorOverviewPage clickSalesforceCertification() throws InterruptedException {

		WebElement certselect = driver.findElement(By.xpath("//span[contains(text(),'Salesforce Certification')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", certselect);
		Thread.sleep(2000);

		windows = driver.getWindowHandles();
		String[] arrayOfString = Arrays.copyOf(windows.toArray(), windows.size(), String[].class);
		driver.switchTo().window(arrayOfString[2]);
		return new AdministratorOverviewPage(driver);

	}

}
