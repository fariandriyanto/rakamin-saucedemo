package SauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SauceDemo/cucumber/feature",
        glue = "SauceDemo/cucumber/stepdef",
        plugin = {"html:target/HTML_report.html"}

)

public class Runner {
}