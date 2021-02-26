package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class ArchitectOverviewPage extends ProjectSpecificMethods{

	public ArchitectOverviewPage(WebDriver driver) {

		this.driver=driver;
	}

	public ArchitectOverviewPage verifyArchitectCert() {
		
		List<WebElement> cert=driver.findElements(By.xpath("//div[@class='cs-card tile']/div[3]/a"));
		for(WebElement cert1:cert) 
			System.out.println(cert1.getText()+ "is Displayed");
		return this;
	}
}
