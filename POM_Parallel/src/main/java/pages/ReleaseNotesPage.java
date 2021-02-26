package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecificMethods;

public class ReleaseNotesPage extends ProjectSpecificMethods {

	public ReleaseNotesPage(WebDriver driver) {

		this.driver=driver;
	}
	
	public ReleaseNotesPage clickDropdown() throws InterruptedException {

		driver.findElement(By.xpath("(//span[@class='dropdown' and @id = 'version-picker'])[4]")).click();
		Thread.sleep(1000);
		return this;

	}

	public ReleaseNotesPage selectDropdownValue() throws InterruptedException {

		Actions actions = new Actions(driver);
		WebElement dropdown = driver.findElement(By.xpath("(//a[contains(text(),'Summer ’20')])[4]"));
		actions.moveToElement(dropdown).build().perform();
		Thread.sleep(2000);
		return this;

	}

	public ReleaseNotesPdfPage clickDownloadPDF() {

		driver.findElement(By.xpath("(//a[text()='Download this PDF'])[2]")).click();
		return new ReleaseNotesPdfPage(driver);

	}
}
