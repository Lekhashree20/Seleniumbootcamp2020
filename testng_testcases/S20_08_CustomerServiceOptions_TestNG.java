package testng_testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S20_08_CustomerServiceOptions_TestNG extends GeneralMethods{
	
	@Test
	public void customeroptions() throws InterruptedException {

		String parent = driver.getWindowHandle();

		// Clicking on Learn More
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				Thread.sleep(3000);

				// Verifying the tabs displayed
				List<WebElement> tabs = driver.findElements(By.xpath("//ul[@class='wwww-main-nav searchEnabled']/li[@class='nav-item ']"));
				for (WebElement tab : tabs)
					System.out.println(tab.getText().trim() + " is Displayed");
	
			}
		}

	}

}