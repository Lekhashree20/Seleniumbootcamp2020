package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class DashboardPage extends ProjectSpecificMethods{
	
	public DashboardPage(WebDriver driver) {

		this.driver=driver;
	}
	
	public OpportunitiesPage clickOpportunity() throws InterruptedException {
	
	WebElement Oppdropdown = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	executor.executeScript("arguments[0].click();", Oppdropdown);
	Thread.sleep(5000);
	return new OpportunitiesPage(driver);
	}

}

