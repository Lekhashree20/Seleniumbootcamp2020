package assessments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonMethods {

	public static RemoteWebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void browsersetup(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
		
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		}
	}

	@Parameters({ "username", "password", "url" })
	@BeforeMethod
	public void login(String username, String password, String url) {

		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();

	}
}