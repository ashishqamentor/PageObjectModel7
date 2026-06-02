package greenkartstepdefination;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/greenkart.feature", 
		glue = "greenkartstepdefination", 
		plugin = {		"pretty", "html:report/cucumberReport/greenkart.html ",
								  "json:report/cucumberReport/greenkart.json" }, 
		monochrome = true)

public class greenkarttestrunner extends AbstractTestNGCucumberTests {

}
