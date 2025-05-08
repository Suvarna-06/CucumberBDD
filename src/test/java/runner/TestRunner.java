package runner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                glue = {"org.example.stepdefination"},
            plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
            monochrome = true,
            publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
