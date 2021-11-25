package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "@target/failed.txt",
        glue = "stepDefinitions"

        ,plugin = { "pretty",
                    "html:target/html-report.html",
                     "json:target/cucumber.json",
                   }


)
//Command to run scenarios with specific tag in CMD
// mvn verify -Dcucumber.filter.tags="@test"
// mvn verify -Dcucumber.filter.tags="@smoke"

public class FailedReRunner {



}
