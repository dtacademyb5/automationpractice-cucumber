package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = "@search or @smoke",   // "@search and @smoke", "@search or @smoke", "not @smoke"
        features = "src/test/resources/features",
        glue = "stepDefinitions"
//        ,dryRun = true


)
public class CucumberRunner {
}
