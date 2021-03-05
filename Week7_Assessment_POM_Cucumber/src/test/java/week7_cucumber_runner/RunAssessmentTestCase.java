package week7_cucumber_runner;
import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features/Assessment.feature",
                 glue = "pages",
                 monochrome=true,
                 dryRun = false)//To verify if all the steps are present in step definition class
                 //snippets = SnippetType.CAMELCASE
                 

public class RunAssessmentTestCase extends AbstractTestNGCucumberTests {
		
	
	
	
}
