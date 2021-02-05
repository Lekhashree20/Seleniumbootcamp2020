package testng_testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class S20_13_DownloadSalesForceA_TestNG extends GeneralMethods{
	
	@Test
	public void downloadSalesForce() throws InterruptedException {
		String str = "SalesforceA";

		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Google Play']")).click();

		String parent = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				String actualName = driver.findElement(By.xpath("//span[text()='SalesforceA']")).getText();
				if (str.equalsIgnoreCase(actualName))
					System.out.println("SalesForceA is displayed");
				else
					System.out.println("SalesForceA is not displayed");

				boolean button = driver.findElement(By.xpath("//button[text()='Install']")).isEnabled();
				System.out.println(button);


			}
		}
	}

}