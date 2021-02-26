package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class AdministratorOverviewPage extends ProjectSpecificMethods {
	
	
	public AdministratorOverviewPage(WebDriver driver) {

		this.driver=driver;
	}

	public AdministratorOverviewPage verifyCertifications() {

		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='cs-card tile']/div[3]/a"));
		for (WebElement tab : tabs)
			System.out.println(tab.getText().trim() + " is Displayed");
		return this;

	}

	public ArchitectOverviewPage selectRoleArchitect() {

		driver.findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return new ArchitectOverviewPage(driver);
		
	}

}
