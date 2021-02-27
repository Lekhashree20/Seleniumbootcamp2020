package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;
public class HomePage extends ProjectSpecificMethods{

		public HomePage clickAppLauncher() {

			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			return this;

		}

		public HomePage clickViewAll() {

			
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			return this;

		}
		
		public RecentlyViewedLogsPage clickPaymentGatewayLogs() throws InterruptedException {
			
			Thread.sleep(3000);
			WebElement payment = driver.findElement(By.xpath("//p[text()='Payment Gateway Logs']"));
			JavascriptExecutor executer = (JavascriptExecutor) driver; 
			executer.executeScript("arguments[0].scrollIntoView(true);", payment);
			executer.executeScript("arguments[0].click();", payment);
			Thread.sleep(3000);
			return new RecentlyViewedLogsPage();
		}
		
	}
	
	
