package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrapper {

	public static RemoteWebDriver driver;

	public static void launchbrowser(String browser, String url) {

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

	public WebElement locateElement(String locator, String locatorValue) {

		try {
			switch (locator.toUpperCase()) {

			case "ID": {

				return driver.findElementById(locatorValue);
			}
			case "CLASSNAME": {

				return driver.findElementByClassName(locatorValue);
			}

			case "LINKTEXT": {

				return driver.findElementByLinkText(locatorValue);
			}

			case "XPATH": {

				return driver.findElementByXPath(locatorValue);
			}

			}

		} catch (Exception e) {
			System.out.println("failed");
		}
		return null;

	}

	public void click(WebElement ele) {

		try {

			ele.click();

		} catch (Exception e) {

			System.out.println("Element is not clickable");
		}

	}

	public void enterValue(WebElement ele, String str) {

		try {

			ele.sendKeys(str);

		} catch (Exception e) {

			System.out.println("Element is not available");
		}

	}

}
