package pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	public HomePage(WebDriver driver) {

		this.driver=driver;
	}
	

	public HomePage clickAppLauncher() {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;

	}

	public HomePage clickViewAll() {

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;

	}

	public DashboardPage clickSales() throws InterruptedException {

		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		return new DashboardPage(driver);
	}

	public CustomerServicePage clickLearnMore() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
		return new CustomerServicePage(driver);
	}

	public HomePage oneClick() throws InterruptedException {

		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		Thread.sleep(2000);
		return this;

	}

	public HomePage SecondClick() throws InterruptedException {

		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		Thread.sleep(2000);
		return this;

	}

	public SalesforceAPage clickGooglePlay() {

		driver.findElement(By.xpath("//span[text()='Google Play']")).click();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			}

		}
		return new SalesforceAPage(driver);
	}
	
	public ReleaseNotesPage clickReleaseNotes() {
	
	driver.findElement(By.xpath("(//span[text()='Get Started'])[6]")).click();
	
	String parent = driver.getWindowHandle();
	
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> I1 = windows.iterator();
	while (I1.hasNext()) {
		String child_window = I1.next();
		if (!parent.equals(child_window)) {
			driver.switchTo().window(child_window);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		}
	}
	return new ReleaseNotesPage(driver);
	}
}
