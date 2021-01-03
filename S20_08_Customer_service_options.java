package Selenium.bootcamp;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class S20_08_Customer_service_options {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		
		//1. Launch Sales force application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		//2. Login with username as "hari.radhakrishnan@testleaf.com" and password as "India@123"
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Bootcamp@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String parent =driver.getWindowHandle();
		
		//Clicking on Learn More
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1= windows.iterator();
        while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		Thread.sleep(3000);
		
		//Verifying the tabs displayed
		List<WebElement> tabs= driver.findElements(By.xpath("//ul[@class='wwww-main-nav searchEnabled']/li[@class='nav-item ']"));
		for(WebElement tab : tabs)
			System.out.println(tab.getText().trim()+" is Displayed");
		}
		}
        
		
	}

	}