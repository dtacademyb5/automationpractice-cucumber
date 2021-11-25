package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = "@parallel",   // "@search and @smoke", "@search or @smoke", "not @smoke"
        features = "src/test/resources/parallel",
        glue = "stepDefinitions"
//        ,dryRun = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,stepNotifications = true
        ,plugin = { "pretty",
                    "html:target/html-report.html",
                     "json:target/cucumber.json",
                     "rerun:target/failed.txt"
                   }


)
//Command to run scenarios with specific tag in CMD
// mvn verify -Dcucumber.filter.tags="@test"
// mvn verify -Dcucumber.filter.tags="@smoke"

public class ParallelRunner {



}
