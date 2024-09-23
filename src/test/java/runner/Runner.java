package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinition",
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // to generate reports
        monochrome = true)
public class Runner {

}
