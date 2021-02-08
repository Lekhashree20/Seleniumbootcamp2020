package runner;
import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features/TC04_DownloadSalesForceA.feature",
                 glue = "steps",
                 monochrome=true,
                 dryRun = false)//To verify if all the steps are present in step definition class
                 //snippets = SnippetType.CAMELCASE)
                 

public class RunCustomerServiceOptions extends AbstractTestNGCucumberTests {
		
	
	
	
}
