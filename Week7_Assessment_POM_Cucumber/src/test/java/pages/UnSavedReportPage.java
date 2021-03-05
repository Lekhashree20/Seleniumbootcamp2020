package pages;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UnSavedReportPage extends BaseClass {
	
	
	
	@When("Select Range as All time")
	public UnSavedReportPage selectRange() throws InterruptedException {
		
		driver.findElement(By.name("duration")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='All Time']")).click();
		return this;

	}
	
	@When("To date as 5 days from today")
	public UnSavedReportPage selectTodate() throws InterruptedException, ParseException {
		
		driver.findElement(By.xpath("//input[@name='startDate']//following-sibling::img")).click();
		Thread.sleep(5000);
		String date = driver.findElement(By.xpath("//td[@title='Today']")).getText();
		String monthNyear = driver.findElement(By.xpath("//td[@class='x-date-middle']//button")).getText();
		String year = monthNyear.replaceAll("[^\\d.]", "").trim();
		String month = monthNyear.replaceAll("\\d", "").trim();
		SimpleDateFormat dates = new SimpleDateFormat("dd MMMM yyyy");
		String format = date + " " + month + " " + year;
		Calendar c = Calendar.getInstance();
		c.setTime(dates.parse(format));
		c.add(Calendar.DAY_OF_MONTH, 5);
//		driver.findElement(By.xpath("//button[text()='Today']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='endDate']//following-sibling::img")).click();
		Thread.sleep(8000);
		String tomonthNyear = driver
				.findElement(
						By.xpath("//div[contains(@class,'x-menu-floating')][2]//td[@class='x-date-middle']//button"))
				.getText();
		String toyear = tomonthNyear.replaceAll("[^\\d.]", "").trim();
		String tomonth = tomonthNyear.replaceAll("\\d", "").trim();
		if ((toyear.trim().equals(Integer.toString(c.get(Calendar.YEAR)).trim()))
				&& (tomonth.trim().equals(new SimpleDateFormat("MMMM").format(c.getTime()).trim()))) {
			// driver.findElement(By.xpath("div[contains(@class,'x-menu-floating')][2]//span[text()='"+c.get(Calendar.DAY_OF_MONTH)+"']//ancestor::a")).click();
			List<WebElement> findElements = driver
					.findElements(By.xpath("//span[text()='" + c.get(Calendar.DAY_OF_MONTH) + "']"));
			for (WebElement iterable_element : findElements) {
				if (iterable_element.isDisplayed()) {
					iterable_element.click();
					Thread.sleep(4000);
				}
			}
		} else {
			driver.findElement(
					By.xpath("//div[contains(@class,'x-menu-floating')][2]//td[@class='x-date-middle']//button"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[contains(@class,'x-menu-floating')][2]//td[@class='x-date-mp-month']/a[text()='"
							+ new SimpleDateFormat("MMM").format(c.getTime()) + "']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='x-date-mp-ok']")).click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[contains(@class,'x-menu-floating')][2]//td[@class='x-date-active']//span[text()='"
							+ c.get(Calendar.DAY_OF_MONTH) + "']"))
					.click();
			Thread.sleep(2000);
		}
	    
	    return this;
	   	}
	

	@Then("Preview is in Tabular Format")
	public UnSavedReportPage verifyTabularFormat() {
		String text = driver.findElement(By.xpath("//table[@id='reportFormatMink']//button")).getText();
		assertEquals(text.trim(), "Tabular Format");
		return this;
	}
	
	@Then("List of Company account count")
	public UnSavedReportPage verifyCompanyCount() {
		List<WebElement> company = driver.findElements(
				By.xpath("//td[contains(@class,'x-grid3-col') and contains(@class,'x-grid3-td-COMPANY')]"));
		for (WebElement webElement : company) {
			String companyName = webElement.getText();
			System.out.println(companyName);
		}
		return this;
	}
	
	@Then("Grand Total of Records Available")
	public UnSavedReportPage verifyGrandTotal() {
		String totalrecords = driver
				.findElement(
						By.xpath("//div[@id='gridViewScrollpreviewPanelGrid']//b[contains(text(),'Grand Totals')]"))
				.getText();
		System.out.println(totalrecords);
		return this;

	}
	
	@When("Click on save")
	public SaveReportPage clickSaveReport() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		return new SaveReportPage();
	}
	
	
}
