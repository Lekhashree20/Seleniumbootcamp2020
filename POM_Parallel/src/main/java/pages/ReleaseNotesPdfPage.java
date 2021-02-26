package pages;

import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class ReleaseNotesPdfPage extends ProjectSpecificMethods{
	
	public ReleaseNotesPdfPage(WebDriver driver) {

		this.driver=driver;
	}
	
	public ReleaseNotesPdfPage viewReleaseNotesPdf() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles();
		windows = driver.getWindowHandles();
		String[] arrayOfString = Arrays.copyOf(windows.toArray(), windows.size(), String[].class);
		driver.switchTo().window(arrayOfString[2]);
		
		Thread.sleep(2000);
		return this;
	}
	
	
	

}
