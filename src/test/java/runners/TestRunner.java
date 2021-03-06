package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests/BuscarCep.feature",
		glue= {"stepDefinitions"},
		plugin = {"json:target/cucumber.json"}
		)
public class TestRunner {

}
