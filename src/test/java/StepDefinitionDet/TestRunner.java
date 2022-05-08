package StepDefinitionDet;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/AllFeatures",glue= {"StepDefinitionDet"},
monochrome=true,
plugin = {"pretty","junit:target/JUnitReports/Reports.xml",
		"html:target/HtmlReports/hmlReports.html"},

tags = "@AmazonLogin"      

		)

public class TestRunner {
// Glue added above for central run.
}
