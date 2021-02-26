package base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {

	public WebDriver driver;
	public JavascriptExecutor executor = (JavascriptExecutor) driver;
    public String comparison = "Salesforce Automation by Lekhashree";
    
    @Parameters({"browser","url"})
	@BeforeMethod
	public void startapp(String browser,String url) {

		switch (browser.toUpperCase()) {

		case "CHROME": {

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(opt);
			break;

		}
		case "FIREFOX": {

			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		}
		case "EDGE": {

			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		}

		default: {

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(opt);

		}

		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	

	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
}
