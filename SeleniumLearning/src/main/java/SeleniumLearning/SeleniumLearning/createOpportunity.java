package SeleniumLearning.SeleniumLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class createOpportunity {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("India$123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Opportunities']")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//span[text()='Opportunity Information']//following::input[4]")).sendKeys("Salesforce Automation by Lekhashree");
		
		
	}

}
