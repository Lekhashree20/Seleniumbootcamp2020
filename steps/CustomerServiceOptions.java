package steps;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.*;

public class CustomerServiceOptions extends BaseClass{
	
	public static WebDriverWait wait;

	
	// This has been commented out since we are using them in Hooks class
	/*
	 * @Given("launch the chrome browser") public void launch_the_chrome_browser() {
	 * System.setProperty("webdriver.chrome.driver",
	 * ".\\Drivers\\chromedriver.exe"); ChromeOptions opt = new ChromeOptions();
	 * opt.addArguments("--disable-notifications"); driver = new ChromeDriver(opt);
	 * driver.manage().window().maximize(); }
	 * 
	 * @Given("launch the salesforce application") public void
	 * launch_the_salesforce_application() {
	 * driver.get("https://login.salesforce.com/"); }
	 */

	@Given("Enter the username as (.*)")
	public void enter_the_username(String username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	}

	@Given("Enter the password as (.*)")
	public void enter_the_password(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@Given("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}

	@When("click on Learn More link in Mobile Publisher")
	public void click_on_Learn_More_link_in_Mobile_Publisher() throws InterruptedException {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Learn More']")));
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> I1 = windows.iterator();
		String parent = driver.getWindowHandle();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				Thread.sleep(3000);
			}
		}
	}

	@Then("Salesforce customer service page should get displayed")
	public void salesforce_customer_service_page_should_get_displayed() {
		String actual = driver.getTitle();
		String expected = "Create and publish custom-branded mobile apps.";
		if (actual.equalsIgnoreCase(expected))
			System.out.println("Salesforce customer service page is displayed");

	}

	@Then("Tabs should be displayed in the salesforce customer service page")
	public void tabs_should_be_displayed_in_the_salesforce_customer_service_page() {
		List<WebElement> tabs = driver
				.findElements(By.xpath("//ul[@class='wwww-main-nav searchEnabled']/li[@class='nav-item ']"));
		for (WebElement tab : tabs)
			System.out.println(tab.getText().trim() + " is Displayed");
	}

}