package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewReportpage extends BaseClass {
	
	@Then("Create new report page is displayed")
	public NewReportpage verifyNewReportPage() {
		
		System.out.println("New Report Page is displayed");
		return this;

	}

	@When("Click on Leads")
	public NewReportpage clickLeads() throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'isEdit')]")));
		driver.findElement(By.xpath("//div[contains(@class,'x-unselectable folder')]//span[text()='Leads']")).click();
		Thread.sleep(3000);
		return this;

	}

	@When("Download save the image")
	public NewReportpage SalesForceReportPageDownload()
			throws MalformedURLException, IOException, InterruptedException {

		WebElement imgElement = driver.findElement(By.id("thePage:dummyForm:report_img"));
		Thread.sleep(2000);
		String src = imgElement.getAttribute("src");
		BufferedImage bufferedImage = ImageIO.read(new URL(src));
		File outputfile = new File("saved.png");
		ImageIO.write(bufferedImage, "png", outputfile);
		Thread.sleep(3000);
		return this;

	}
    @When("Click on Create")
	public UnSavedReportPage clickCreateButton() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='thePage:rtForm:createButton']")).click();
		Thread.sleep(3000);
		return new UnSavedReportPage();

	}
}
