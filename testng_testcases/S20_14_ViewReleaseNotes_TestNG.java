package testng_testcases;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S20_14_ViewReleaseNotes_TestNG extends GeneralMethods{
	@Test
	public void downloadReleaseNotes() throws InterruptedException {


		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Get Started'])[5]")).click();

		String parent = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				driver.findElement(By.xpath("(//span[@class='dropdown' and @id = 'version-picker'])[4]")).click();
				Thread.sleep(1000);
				Actions actions = new Actions(driver);
				WebElement dropdown = driver.findElement(By.xpath("(//a[contains(text(),'Summer ’20')])[4]"));
				actions.moveToElement(dropdown).build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[text()='Download this PDF'])[2]")).click();

				windows = driver.getWindowHandles();
				String[] arrayOfString = Arrays.copyOf(windows.toArray(), windows.size(), String[].class);
				driver.switchTo().window(arrayOfString[2]);

				Thread.sleep(2000);

				// Downloading the PDF

			}
		}
	}

}