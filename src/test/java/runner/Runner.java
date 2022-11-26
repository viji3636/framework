package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = {"src/test/java/features/LoginWithWrapper.feature"}, 
					glue = {"stepDefinition"}, 
					monochrome = true,
					
					dryRun = true,
					publish = true)

public class Runner extends AbstractTestNGCucumberTests {

}
 